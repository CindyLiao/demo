package com.service.impl;

import java.util.List;

import com.bean.Position;
import com.dao.PositionDAO;
import com.service.PositionService;

public class PositionServiceImpl implements PositionService{

	private PositionDAO positiondao;
	
	public PositionDAO getPositiondao() {
		return positiondao;
	}

	public void setPositiondao(PositionDAO positiondao) {
		this.positiondao = positiondao;
	}

	public void addPosition(Position position) {
		positiondao.save(position);
	}

	public void updatePosition(Position position) {
		positiondao.attachDirty(position);
	}

	public void deletePosition(Position position) {
		positiondao.delete(position);
	}

	public List findByPositionName(String positionname) {
		return positiondao.findByPosName(positionname);
	}

	public List findByPrivilege(int privilege) {
		return positiondao.findByPrivilege(privilege);
	}

	

	public List findByEmpId(int employeeid) {
		List list= positiondao.findByEmpId(employeeid);
		System.out.println("ww");
		return list;
	}

	public List findByRoleId(int roleid) {
		return positiondao.findByRoleId("role.roleId", roleid);
	}

	public Position findById(int positionid) {
		return positiondao.findById(positionid);
	}
	
	public List findAll(){
		return positiondao.findAll();
	}
	
	public List<Object[]> getPositions() {
		return positiondao.getPositions();
	}

}
