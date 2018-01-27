package com.wuliji.utils;

import java.util.List;

public class PageBean {
	
	//当前页数
	private Integer currentPage;
	//总记录数
	private Integer totalCount;
	//每页显示条数
	private Integer pageSize;
	//总页数
	private Integer totalPage;
	//分页列表数据
	private List list;
	
	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		this.totalCount = totalCount;
		
		this.currentPage = currentPage;
		if(this.currentPage == null) {
			//没有指定页数，默认第一页
			this.currentPage = 1;
		}
		
		this.pageSize = pageSize;
		if(this.pageSize == null) {
			//没有指定条数，默认显示3条
			this.pageSize = 3;
		}
		
		//计算总页数
		this.totalPage = (this.totalCount + this.pageSize - 1) / this.pageSize;
		
		//判断当前页数是否超出范围   1<=currentPage<=totalPage
		if(this.currentPage < 1) {
			this.currentPage = 1;
		}
		if(this.currentPage > this.totalPage) {
			this.currentPage = this.totalPage;
		}
	}
	
	/**
	 * 计算页面起始位置
	 * @return
	 */
	public Integer getStart() {
		return (this.currentPage - 1) * this.pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	
	
	
}
