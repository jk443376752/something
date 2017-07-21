package com.buy.tsg.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 提供分页的封装对象
 * @author jiangkun
 */
public class PageList<T> {
	
	//当前是第几页
	private Integer currentPage;
	//每页多少条数据
	private Integer pageSize;
	//一共多少条数据
	private Integer totalCount;
	//首页(就是第一页)
	private Integer firstPage =  1;
	//尾页(就是最后一页)/一共有多少页
	private Integer lastPage;
	//上一页
	private Integer upPage;
	//下一页
	private Integer nextPage;
	//这一页的所有数据
	private List<T> data = new ArrayList<T>();
	
	/**
	 * 提供了一构造方法 ,便于传参
	 * @param currentPage 当前页
	 * @param pageSize  每页多少条数据
	 * @param totalCount  一共多少条数据
	 */
	public PageList(Integer currentPage,Integer pageSize,Integer totalCount) {
		//当前页
		this.currentPage = currentPage;
		//每页多少条数据
		this.pageSize = pageSize;
		//总共有所少数据
		this.totalCount = totalCount;
		//计算一共多少页(它也就是尾页)
		this.lastPage = totalCount%pageSize>0?totalCount/pageSize+1:totalCount/pageSize;
		//上一页
		this.upPage = currentPage==1?1:currentPage-1;
		//下一页
		this.nextPage = currentPage==lastPage?lastPage:currentPage+1;
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
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(Integer firstPage) {
		this.firstPage = firstPage;
	}
	public Integer getLastPage() {
		return lastPage;
	}
	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}
	public Integer getUpPage() {
		return upPage;
	}
	public void setUpPage(Integer upPage) {
		this.upPage = upPage;
	}
	public Integer getNextPage() {
		return nextPage;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return "PageList [currentPage=" + currentPage + ", pageSize="
				+ pageSize + ", totalCount=" + totalCount + ", firstPage="
				+ firstPage + ", lastPage=" + lastPage + ", upPage=" + upPage
				+ ", nextPage=" + nextPage + ", data=" + data + "]";
	}
	
}
