package com.server;

public class EmployeeServerInterface {
	
	public   String getEmpfromrole(int roleid){
		return GetEmpInfo.getEmpfromrole(roleid);
	}
	
	public String getRoles(){
		return 	GetEmpInfo.getRoles();
	}
	
	public String getEmployee(int id){
		return GetEmpInfo.getEmployee(id);
	}
	
	public String loginVerify(String userid, String password) {
		// TODO Auto-generated method stub
		return GetEmpInfo.loginVerify(userid, password);
	}
	
	public String getPosition(String userid) {
		// TODO Auto-generated method stub
		return GetEmpInfo.getPosition(userid);
	}
	
	public String getAllEmployees() {
		return GetEmpInfo.getAllEmployees();
	}
	
	public String getAllCapacities() {
		return GetEmpInfo.getAllCapacities();
	}
	
	public String getAllOrgs() {
		return GetEmpInfo.getAllOrgs();
	}
	
	public String getAllPositions() {
		return GetEmpInfo.getAllPositions();
	}
	
	public String getAllRoles() {
		return GetEmpInfo.getAllRoles();
	}
	
	/*public String isAdmin(String userid) {
		return GetEmpInfo.isAdmin(userid);
	}*/
	
	public String getEmployeeNum() {
		return GetEmpInfo.getEmployeeNum();
	}
}
