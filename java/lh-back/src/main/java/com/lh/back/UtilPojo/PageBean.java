package com.lh.back.UtilPojo;

public class PageBean {

	private int page;     //当前第几页
    private int rows;     //每页显示记录数
    private int firstPage;  //第几条记录起始
    
	public PageBean(int page, int rows) {
		this.page = page;
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getFirstPage() {
		this.firstPage = (page - 1) * rows;
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
    
    
}
