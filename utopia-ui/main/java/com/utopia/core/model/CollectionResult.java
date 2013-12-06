package com.utopia.core.model;

import java.util.Collection;

public class CollectionResult<R> {

	public int totalResultCount;
	public int pageSize;
	public int pageIndex;
	public Collection<R>collection;
	public int getTotalResultCount() {
		return totalResultCount;
	}
	public void setTotalResultCount(int totalResultCount) {
		this.totalResultCount = totalResultCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Collection<R> getCollection() {
		return collection;
	}
	public void setCollection(Collection<R> collection) {
		this.collection = collection;
	}
	
}
