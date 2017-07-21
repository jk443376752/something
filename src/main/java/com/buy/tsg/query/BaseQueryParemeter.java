package com.buy.tsg.query;
/**
 * @author jiangkun
 * 分页提供的最小参数pageSize和currentPage根据实际情况而修改
 * 如果有其他查询条件 , 可以在子类继承此类
 */

public class BaseQueryParemeter {
	//每页查询多少条数据(默认每页查询10条数据)
	private Integer pageSize = 10;
	//当前(要查询的)是第几页 ,默认查询第一页
	private Integer currentPage = 1;
	
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	//拿到当前是从每几条数据开始查询
	public Integer getBeginIndex(){
		return (currentPage-1) * pageSize;
	}
}
