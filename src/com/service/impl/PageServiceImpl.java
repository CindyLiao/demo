package com.service.impl;

import java.util.List;

import com.dao.PageDAO;
import com.model.Page;
import com.service.PageService;

public class PageServiceImpl implements PageService{
	private PageDAO pagedao;
	public void setPagedao(PageDAO pagedao) {
		this.pagedao = pagedao;
	}

	public Page queryForPage(String hqls, int pageSize, int page) {
		final String hql=hqls;//��ѯ���
		int allRow=pagedao.getAllRowCount(hql);//�ܼ�¼��
		int totalPage=Page.countTotalPage(pageSize, allRow);//��ҳ��
		final int offset=Page.countOffset(pageSize, page);//��ǰҳ��ʼ��¼
		final int length=pageSize;//ÿҳ��¼��
		final int currentPage=Page.countCurrentPage(page);
		List<Page> list=pagedao.queryForPage(hql, offset, length);//"һҳ"�ļ�¼
		Page p=new Page();
		p.setPageSize(pageSize);
		p.setCurrentPage(currentPage);
		p.setAllRow(allRow);
		p.setTotalPage(totalPage);
		p.setList(list);
		p.init();
		return p;
	}

}
