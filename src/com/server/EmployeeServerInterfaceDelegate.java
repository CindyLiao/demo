package com.server;

@javax.jws.WebService(targetNamespace = "http://server.com/", serviceName = "EmployeeServerInterfaceService", portName = "EmployeeServerInterfacePort", wsdlLocation = "WEB-INF/wsdl/EmployeeServerInterfaceService.wsdl")
public class EmployeeServerInterfaceDelegate {

	com.server.EmployeeServerInterface employeeServerInterface = new com.server.EmployeeServerInterface();

	public String getEmpfromrole(int roleid) {
		return employeeServerInterface.getEmpfromrole(roleid);
	}

	public String getRoles() {
		return employeeServerInterface.getRoles();
	}

	public String getEmployee(int id) {
		return employeeServerInterface.getEmployee(id);
	}

	public String loginVerify(String userid, String password) {
		return employeeServerInterface.loginVerify(userid, password);
	}

	public String getPosition(String userid) {
		return employeeServerInterface.getPosition(userid);
	}

	public String getAllEmployees() {
		return employeeServerInterface.getAllEmployees();
	}

	public String getAllCapacities() {
		return employeeServerInterface.getAllCapacities();
	}

	public String getAllOrgs() {
		return employeeServerInterface.getAllOrgs();
	}

	public String getAllPositions() {
		return employeeServerInterface.getAllPositions();
	}

	public String getAllRoles() {
		return employeeServerInterface.getAllRoles();
	}

	public String getEmployeeNum() {
		return employeeServerInterface.getEmployeeNum();
	}

}