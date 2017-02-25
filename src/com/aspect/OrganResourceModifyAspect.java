package com.aspect;

import java.util.ArrayList;

import java.util.List;


import net.sf.json.JSONObject;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import com.bean.Employee;
import com.bean.Organization;
import com.bean.Position;
import com.bean.Role;
import com.bean.SimpleDepartment;
import com.bean.SimpleEmployee;
import com.bean.SimplePosition;
import com.bean.SimpleRole;
import com.bean.UserInfo;
import com.util.HttpRequestUtils;

/**
 * 切面增强类
 * 在对组织资源（除Ability之外）的做都将相应的修改发送至映射中心
 * @author yuzaizai
 *
 */
@Aspect
public class OrganResourceModifyAspect {
		private static final String url = "http://localhost:3000/cache/modifyResource";
		private JSONObject jsonObj = new JSONObject();

	   // 添加
	    @AfterReturning (pointcut="execution(* com.dao.impl.*DAOImpl.save*(..) )")
		public void save (JoinPoint point ) {
			Object[] args = point.getArgs();  //  获取目标方法参数
			//Object target = point.getTarget();  // 获取被织入增强处理的目标对象
			//Signature sig = point.getSignature();  // 获取目标方法签名
			Object objArg = args[0];  //  目前类中的参数只有一个实体
			setParam(objArg,"save");
			HttpRequestUtils.httpPost(url, jsonObj);
		}
		
		
		// 删除
	    @AfterReturning (pointcut="execution(* com.dao.impl.*DAOImpl.delete*(..) )")
		public void delete(JoinPoint point) {
			Object[] args = point.getArgs();  //  获取目标方法参数
			Object objArg = args[0];  //  目前类中的参数只有一个实体
			setParam(objArg,"delete");
			HttpRequestUtils.httpPost(url, jsonObj);
		}
		
		
		// 修改
	    @AfterReturning (pointcut="execution(* com.dao.impl.*DAOImpl.attachDirty(..) )")
		public void update(JoinPoint point) {
			Object[] args = point.getArgs();  //  获取目标方法参数
			Object objArg = args[0];  //  目前类中的参数只有一个实体
			setParam(objArg,"update");
			HttpRequestUtils.httpPost(url, jsonObj);
		}
		
		
		
		// set 访问参数
		private void setParam(Object objArg,String operation ) {
			List<Object> list = new ArrayList<Object>();   // 访问参数列表 
			list.add(getUserInfo()); // 用户信息
			list.add(operation); // 操作信息
			if ( objArg instanceof Organization ) {    // 若为组	织(部门信息)
				list.add("Department");  // 资源对象信息
				list.add(organization2simpleDep( (Organization)objArg ));
			}
			if ( objArg instanceof Position  ) {
				list.add("Position");
				list.add(position2simplePos((Position)objArg));
			}
			if ( objArg instanceof Role ) {
				list.add("Role");
				list.add(role2simpleRole((Role)objArg));
				
			}
			if ( objArg instanceof Employee ) {
			    list.add("Employee");  //
				list.add(employee2simpleEmployee((Employee)objArg));		
			}
			jsonObj.put("param",list);
		}
		
		
		// set访问用户信息
		private UserInfo getUserInfo() {
			UserInfo userInfo = new UserInfo();  // 访问用户的信息
			userInfo.setUserName("test1");
			userInfo.setUserPassword("123456");
			return userInfo;
		}
		
		
		// 将 Organization 转成 Org
		private  SimpleDepartment organization2simpleDep ( Organization organ) {
			SimpleDepartment simDep = new SimpleDepartment();
			simDep.setDepName(organ.getOrgName());
			simDep.setDepId(String.valueOf(organ.getOrgId()));
			simDep.setParentDepId(String.valueOf(organ.getOrgId()));
			return simDep;
		}
		
		// 将Position对象转为SimplePosition
		private SimplePosition position2simplePos ( Position position) {
			SimplePosition simPos = new SimplePosition();
			simPos.setId(position.getPosId());
			simPos.setPosName(position.getPosName());
			simPos.setDepId(position.getOrganization().getOrgId());
			simPos.setDepName(position.getOrganization().getOrgName());
			simPos.setRoleId(position.getRole().getRoleId());
			simPos.setRoleName(position.getRole().getRoleName());
			simPos.setEmpId(position.getEmpId());
			return simPos;
		}
		
		// 将role 对象转成SimpleRole
		private SimpleRole role2simpleRole( Role role ) {
			SimpleRole simRole = new SimpleRole();
			simRole.setId(role.getRoleId());
			simRole.setRoleName(role.getRoleName());
			return simRole;
		}
		
		// 将Employee对象转成SimpleEmployee 
		private SimpleEmployee employee2simpleEmployee ( Employee ep) {
			SimpleEmployee sim = new SimpleEmployee();
			sim.setId( ep.getEmpId() ); 
			sim.setName(ep.getLastName()+ep.getFirstName());
			sim.setPassword(ep.getPassword());
			return sim;
		}
}
