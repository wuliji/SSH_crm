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

	private File photo;//上传的文件会自动封装到File对象中，该属性名与前台页面属性名相同
	private String photoFileName;//提交的键名后加上固定FileName，文件名称会自动封装到属性中
	private String photoContentType;//提交的键名后加上固定ContentType，文件类型会自动封装到属性中
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
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		//判断并封装参数
		if(StringUtils.isNotBlank(customer.getCust_name())) {
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		
		//1.调用Service查询分页数据
		PageBean pb = cs.getPageBean(dc, this.currentPage, this.pageSize);
		//2.将PageBean放入request域中，转发到页面显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	public String add() throws Exception {
		//上传文件保存到指定位置
		System.out.println("文件名称:" + photoFileName);
		System.out.println("文件类型:" + photoContentType);
		photo.renameTo(new File("E:\\upload\\haha.jpg"));
		
		//1.调用Service保存Customer对象
		cs.save(customer);
		//2.重定向到客户列表
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
