package com.wuliji.web.action;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wuliji.domain.Customer;
import com.wuliji.domain.LinkMan;
import com.wuliji.domain.SaleVisit;
import com.wuliji.domain.User;
import com.wuliji.service.SaleVisitService;
import com.wuliji.utils.PageBean;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit>{
	
	private SaleVisit saleVisit = new SaleVisit();
	private SaleVisitService svs;
	
	public void setSvs(SaleVisitService svs) {
		this.svs = svs;
	}

	public String add() throws Exception {
		//取出登录用户，放入SaleVisit实体。表达关系
		User user = (User) ActionContext.getContext().getSession().get("user");
		saleVisit.setUser(user);
		//1.调用Service保存客户拜访记录
		svs.save(saleVisit);
		//2.重定向到拜访记录列表
		return "toList";
	}
	
	private Integer currentPage;
	private Integer pageSize;
	
	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
		//判断并封装参数
		if(saleVisit.getCustomer() != null && saleVisit.getCustomer().getCust_id() != null) {
			dc.add(Restrictions.eq("customer.cust_id", saleVisit.getCustomer().getCust_id()));
		}
		
		//1.调用Service查询分页数据
		PageBean pb = svs.getPageBean(dc, this.currentPage, this.pageSize);
		//2.将PageBean放入request域中，转发到页面显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	public String toEdit() throws Exception {
		//调用Service根据id获得客户对象
		SaleVisit existS = svs.findById(saleVisit.getVisit_id());
		//将客户对象放置到request域中，并转发到编辑页面
		ActionContext.getContext().put("saleVisit", existS);
		return "add";
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public SaleVisit getModel() {
		return saleVisit;
	}
}
