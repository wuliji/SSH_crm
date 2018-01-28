package com.wuliji.web.action;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wuliji.domain.Customer;
import com.wuliji.service.CustomerService;
import com.wuliji.utils.PageBean;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private File photo;//�ϴ����ļ����Զ���װ��File�����У�����������ǰ̨ҳ����������ͬ
	private String photoFileName;//�ύ�ļ�������Ϲ̶�FileName���ļ����ƻ��Զ���װ��������
	private String photoContentType;//�ύ�ļ�������Ϲ̶�ContentType���ļ����ͻ��Զ���װ��������
	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}



	private Customer customer = new Customer();
	private CustomerService cs;
	private Integer currentPage;
	private Integer pageSize;
	
	public String list() throws Exception {
		//��װ���߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		//�жϲ���װ����
		if(StringUtils.isNotBlank(customer.getCust_name())) {
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		
		//1.����Service��ѯ��ҳ����
		PageBean pb = cs.getPageBean(dc, this.currentPage, this.pageSize);
		//2.��PageBean����request���У�ת����ҳ����ʾ
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	public String add() throws Exception {
		//�ϴ��ļ����浽ָ��λ��
		System.out.println("�ļ�����:" + photoFileName);
		System.out.println("�ļ�����:" + photoContentType);
		photo.renameTo(new File("E:\\upload\\haha.jpg"));
		
		//1.����Service����Customer����
		cs.save(customer);
		//2.�ض��򵽿ͻ��б�
		return "toList";
	}
	
	
	public Integer getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}


	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public Integer getPageSize() {
		return pageSize;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	public void setCs(CustomerService cs) {
		this.cs = cs;
	}

	
	
	@Override
	public Customer getModel() {
		return customer;
	}
		
}
