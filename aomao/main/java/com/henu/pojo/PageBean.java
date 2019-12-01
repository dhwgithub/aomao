package com.henu.pojo;

import java.util.List;

public class PageBean<E> {

	private List<E> list;//当前页内容
	private int currPage;//当前页码
	private int pageSize;//每页显示的条数
	private int totalCount;//总条数
	private int totalPage;//总页数
	
	public PageBean(List<E> list, int currPage, int pageSize, int totalCount) {
		super();
		this.list = list;
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}
	public PageBean() {
		super();
	}
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	/**
	 * 获取总页数
	 * @return
	 */
	public int getTotalPage() {
		if (totalCount == 0) {
			return 1;
		}
		return (int) Math.ceil(totalCount*1.0/pageSize);
	}

	@Override
	public String toString() {
		return "PageBean [list=" + list + ", currPage=" + currPage + ", pageSize=" + pageSize + ", totalCount="
				+ totalCount + ", totalPage=" + totalPage + "]";
	}
	
}
