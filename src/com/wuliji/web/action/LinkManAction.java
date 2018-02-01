package com.wuliji.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wuliji.domain.Customer;
import com.wuliji.domain.LinkMan;
import com.wuliji.service.LinkManService;
import com.wuliji.utils.PageBean;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
	
	private LinkMan linkMan = new LinkMan();
	LinkManService ls;

	public void setLs(LinkManService ls) {
		this.ls = ls;
	}
	
	private Integer currentPage;
	private Integer pageSize;
	
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

	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		//判断并封装参数
		if(StringUtils.isNotBlank(linkMan.getLkm_name())) {
			dc.add(Restrictions.like("lkm_name", "%"+linkMan.getLkm_name()+"%"));
		}
		if(linkMan.getCustomer()!=null && linkMan.getCustomer().getCust_id()!=null) {
			dc.add(Restrictions.eq("customer.cust_id", linkMan.getCustomer().getCust_id()));
		}
		
		//1.调用Service查询分页数据
		PageBean pb = ls.getPageBean(dc, this.currentPage, this.pageSize);
		//2.将PageBean放入request域中，转发到页面显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	public String add() throws Exception {
		//调用Service保存
		ls.save(linkMan);
		//重定向到列表
		return "toList";
	}
	
	public String toEdit() throws Exception {
		//调用Service根据id获得客户对象
		LinkMan lm = ls.findById(linkMan.getLkm_id());
		//将客户对象放置到request域中，并转发到编辑页面
		ActionContext.getContext().put("linkMan", lm);
		return "add";
	}

	@Override
	public LinkMan getModel() {
		return linkMan;
	}
}
