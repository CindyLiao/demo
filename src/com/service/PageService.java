package com.service;

import com.dao.PageDAO;
import com.model.Page;

public interface PageService {

	public abstract void setPagedao(PageDAO pagedao);

	/*
	 * ��ҳ��ѯ
	 * @@param currentPage��ǰ�ڼ�ҳ
	 * @@param pageSize ÿҳ��С
	 * @@return ����˷�ҳ��Ϣ��������¼��list����entry
	 */
	public abstract Page queryForPage(String hqls, int pageSize, int page);

}