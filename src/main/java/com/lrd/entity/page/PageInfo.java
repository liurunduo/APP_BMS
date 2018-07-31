package com.lrd.entity.page;

import java.util.List;


public class PageInfo<T> {

	private Integer pageIndex;
	private Integer pageSize;
	private Integer totalCount;
	private Integer pageTotalCount;
	private List<T> list;
	private String url;
	public PageInfo() {
		super();
	}
	public PageInfo(Integer pageIndex, Integer pageSize, Integer totalCount,
			Integer pageTotalCount, List<T> list, String url) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.pageTotalCount = pageTotalCount;
		this.list = list;
		this.url = url;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		if(pageIndex==null||pageIndex<1){
			pageIndex=1;
		}
		if(pageIndex>getPageTotalCount()){
			pageIndex=getPageTotalCount();
		}
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		if(pageSize==null||pageSize<1){
			pageIndex=1;
		}		
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		if(totalCount==null||totalCount<0){
			totalCount=0;
		}
		this.totalCount = totalCount;
	}
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public Integer getPageTotalCount() {
		if(totalCount==0){
			return 0;
		}		
		return totalCount%pageSize==0?(totalCount/pageSize):(totalCount/pageSize+1);
	}
	public void setPageTotalCount(Integer pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
