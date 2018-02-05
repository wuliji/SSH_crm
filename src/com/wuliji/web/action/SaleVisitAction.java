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
		//ȡ����¼�û�������SaleVisitʵ�塣����ϵ
		User user = (User) ActionContext.getContext().getSession().get("user");
		saleVisit.setUser(user);
		//1.����Service����ͻ��ݷü�¼
		svs.save(saleVisit);
		//2.�ض��򵽰ݷü�¼�б�
		return "toList";
	}
	
	private Integer currentPage;
	private Integer pageSize;
	
	public String list() throws Exception {
		//��װ���߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
		//�жϲ���װ����
		if(saleVisit.getCustomer() != null && saleVisit.getCustomer().getCust_id() != null) {
			dc.add(Restrictions.eq("customer.cust_id", saleVisit.getCustomer().getCust_id()));
		}
		
		//1.����Service��ѯ��ҳ����
		PageBean pb = svs.getPageBean(dc, this.currentPage, this.pageSize);
		//2.��PageBean����request���У�ת����ҳ����ʾ
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	public String toEdit() throws Exception {
		//����Service����id��ÿͻ�����
		SaleVisit existS = svs.findById(saleVisit.getVisit_id());
		//���ͻ�������õ�request���У���ת�����༭ҳ��
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
