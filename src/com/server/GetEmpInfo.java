package com.server;

import java.util.HashMap;


import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import com.action.EmployeeAction;
import com.dao.AbilityDAO;
import com.dao.AbilityDAO;
import com.dao.OrganizationDAO;
import com.dao.PositionDAO;
import com.dao.RoleDAO;
import com.bean.Ability;
import com.bean.Employee;
import com.bean.Organization;
import com.bean.Position;
import com.bean.Role;
import com.service.AbilityService;
import com.service.EmployeeService;
import com.service.impl.EmployeeServiceImpl;


public class GetEmpInfo {
	private  static RoleDAO roledao;
	private  static PositionDAO positiondao;
	private  static EmployeeService employeeservice;
	private static  AbilityDAO capacitydao;
	private static  OrganizationDAO organizationDao;

	public  RoleDAO getRoledao() {
		return roledao;
	}
	public  void setRoledao(RoleDAO roledao) {
		GetEmpInfo.roledao = roledao;
	} 
	public  PositionDAO getPositiondao() {
		return positiondao;
	}
	public  void setPositiondao(PositionDAO positiondao) {
		  this.positiondao = positiondao;
	}
	public  EmployeeService getEmployeeservice() {
		return employeeservice;
	}
	public  void setEmployeeservice(EmployeeService employeeservice) {
		GetEmpInfo.employeeservice = employeeservice;
	}
	
	
	public  AbilityDAO getCapacitydao() {
		return capacitydao;
	}
	public  void setCapacitydao(AbilityDAO capacitydao) {
		GetEmpInfo.capacitydao = capacitydao;
	}
	public  OrganizationDAO getOrganizationDao() {
		return organizationDao;
	}
	public  void setOrganizationDao(OrganizationDAO organizationDao) {
		this.organizationDao = organizationDao;
	}
	public String  test(){
	    String s=getEmployee(1);
	    positiondao.findByEmpId(1);
		getEmpfromrole(12);
		return s;
	}
	
	public static  String getEmpfromrole(int roleid){
		try {
		List<Object> position = (List<Object>)positiondao.findByProperty("role.roleId", roleid);
		JSONArray json=new JSONArray();
		for (int i = 0; i< position.size();i++){
			Object[] o=(Object[]) position.get(i);
 			Employee employee =(Employee) o[1];
 				Map<String, String> map=new HashMap<String, String>();
 				map.put("empId", employee.getEmpId().toString());
 				map.put("empFirstName",employee.getFirstName());
 				map.put("empLastName", employee.getLastName());
 				map.put("userId", employee.getUserId().toString());
 				json.put(map);
		}
		return json.toString();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
		
	}
	
	public static String getRoles(){
		List<Role> role = roledao.findAll();
		JSONArray json=new JSONArray();
 		for (int i=0; i<role.size();i++){
 			Map<String, String> map=new HashMap<String, String>();
 			map.put("roleid", role.get(i).getRoleId().toString());
 			map.put("rolename", role.get(i).getRoleName());
 			json.put(map);
 		}
 		return json.toString();
	}
	
	public static String getEmployee(int id){
    	  Employee emp=employeeservice.findById(id);
    	  JSONArray json=new JSONArray();
   		  Map<String, String> map=new HashMap<String, String>();
   		  map.put("empid", emp.getEmpId().toString());
   		  map.put("FirstName", emp.getFirstName());
   		  map.put("LastName", emp.getLastName());
   		  json.put(map);  
   		  return json.toString();
    }
	
	public static String getPassword(int userId) {
		Employee emp=employeeservice.findById(userId);
		if (emp == null) return null;
		String password;
		password = emp.getPassword();
		return password;
		
	}
	
	public static  String getPosfromemp(int empId){
		try {
		List<Position> position = positiondao.findByEmpId(empId);
		JSONArray json=new JSONArray();
		System.out.println(position.size());
		for (int i = 0; i< position.size();i++){
			Position pos = new Position();
			pos = position.get(i);
 			Map<String, String> map=new HashMap<String, String>();
 			//map.put("empId",pos.getEmpId().toString());
 			map.put("posId",pos.getPosId().toString());
 			map.put("posName",pos.getPosName().toString());
 			json.put(map);
		}
		return json.toString();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
		
	}
	
	public static String loginVerify(String userid, String password) {
		JSONArray json=new JSONArray();
 		Map<String, String> map=new HashMap<String, String>();
 		System.out.println(userid+":"+getPassword(Integer.parseInt(userid)));
		if(password.equals(getPassword(Integer.parseInt(userid)))){
			map.put("userid", userid);
			map.put("LoginVerify", "success");
			/*List emps = employeeservice.findByUserId(Integer.parseInt(userid));
			Employee emp = new Employee();
			emp = (Employee) emps.get(0);
			if(emp.getAdministrator() != null){
				map.put("Administrator", emp.getAdministrator().toString());
			}*/
			
		}else{
			map.put("userid", userid);
			map.put("LoginVerify", "failed");
		}
		
		json.put(map); 
		System.out.println(json.toString());
 		return json.toString();
	}
	
	public static String getPosition(String userid) {
		//获取position
		JSONArray json=new JSONArray();
 		Map<String, String> map=new HashMap<String, String>();
 		map.put("userid", userid);
		List emps = employeeservice.findByUserId(Integer.parseInt(userid));
		Employee emp = new Employee();
		emp = (Employee) emps.get(0);
		int empid = emp.getEmpId();
		System.out.println(empid+"///");
		String positions = getPosfromemp(empid);
		System.out.println(positions+"///");
		map.put("positions", positions);
		json.put(map);
		System.out.println(json.toString());
		return json.toString();
	}
	
	public static String getAllEmployees() {
		JSONArray json=new JSONArray();
		List<Employee> emps = employeeservice.getEmployeedao().findAll();
		for(int i = 0; i < emps.size(); i++){
			Employee emp = new Employee();
			emp = emps.get(i);
			Map<String, String> map=new HashMap<String, String>();
			map.put("empid", emp.getEmpId().toString());
			map.put("userid", emp.getUserId().toString());
			map.put("password", emp.getPassword());
			map.put("FirstName", emp.getFirstName());
			map.put("LastName", emp.getLastName());
			/*if(emp.getAdministrator() != null){
				map.put("Administrator", emp.getAdministrator().toString());
			}*/
			
			json.put(map);
		}
		System.out.println(json.toString());
		return json.toString();
	}
	
	public static String getAllCapacities() {
		JSONArray json=new JSONArray();
		List<Ability> caps = capacitydao.findAll();
		for(int i = 0; i < caps.size(); i++){
			Ability cap = new Ability();
			cap = caps.get(i);
			Map<String, String> map=new HashMap<String, String>();
			map.put("capid", cap.getAbiId().toString());
			map.put("capname", cap.getAbiName());
			map.put("capdesc", cap.getAbiDesc());
			json.put(map);
		}
		System.out.println(json.toString());
		return json.toString();
	}
	
	public static String getAllOrgs() {
		JSONArray json=new JSONArray();
		List<Organization> orgs = organizationDao.findAll();
		for(int i = 0; i < orgs.size(); i++){
			Organization org = new Organization();
			org = orgs.get(i);
			Map<String, String> map=new HashMap<String, String>();
			map.put("orgid", org.getOrgId().toString());
			map.put("orgname", org.getOrgName());
			map.put("orgtype", org.getOrgType());
			map.put("orgdesc", org.getOrgDesc());
			if(org.getParentOrgId() != null){
				map.put("parentorgid", org.getParentOrgId().toString());
			}/*else{
				map.put("parentorgid", null);
			}*/
			
			json.put(map);
		}
		System.out.println(json.toString());
		return json.toString();
	}
	
	public static String getAllPositions() {
		JSONArray json=new JSONArray();
		List<Position> poss = positiondao.findAll();
		for(int i = 0; i < poss.size(); i++){
			Position pos = new Position();
			pos = poss.get(i);
			Map<String, String> map=new HashMap<String, String>();
			map.put("posid", pos.getPosId().toString());
			map.put("posname", pos.getPosName());
			if(pos.getOrganization() != null){
				map.put("orgid", pos.getOrganization().getOrgId().toString());
			}/*else{
				map.put("orgid", null);
			}*/
			
			map.put("posdesc", pos.getPosDesc());
			json.put(map);
		}
		System.out.println(json.toString());
		return json.toString();
	}
	
	public static String getAllRoles() {
		JSONArray json=new JSONArray();
		List<Role> roles = roledao.findAll();
		for(int i = 0; i < roles.size(); i++){
			Role role = new Role();
			role = roles.get(i);
			Map<String, String> map=new HashMap<String, String>();
			map.put("roleid", role.getRoleId().toString());
			map.put("rolename", role.getRoleName());
			map.put("roledesc", role.getRoleDesc());
			json.put(map);
		}
		System.out.println(json.toString());
		return json.toString();
	}
	
	/*public static String isAdmin(String userid) {
		JSONArray json=new JSONArray();
 		Map<String, String> map=new HashMap<String, String>();
		map.put("userid", userid);
		List emps = employeeservice.findByUserId(Integer.parseInt(userid));
		if(emps.size() != 0){
			Employee emp = new Employee();
			emp = (Employee) emps.get(0);
			if(emp.getAdministrator() != null){
				map.put("Administrator", emp.getAdministrator().toString());
			}
		}
		json.put(map); 
		System.out.println(json.toString());
 		return json.toString();
	}*/
	
	public static String getEmployeeNum() {
		JSONArray json=new JSONArray();
 		Map<String, String> map=new HashMap<String, String>();
		map.put("userNum", String.valueOf(employeeservice.getEmployeeNum()));
		json.put(map); 
		System.out.println(json.toString());
 		return json.toString();
	}
}
