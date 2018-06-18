package com.spingmvc.chapter15.service;

import java.util.List;

import com.springmvc.chapter15.pojo.Role;
import com.springmvc.chapter15.pojo.RoleParams;


public interface RoleService {
	
	public int insertRoles(List<Role> roleList);
	
	public Role getRole(Long id);
	
	public List<Role> findRoles(RoleParams roleParams);
	
	public int deleteRoles(List<Long> idList);
	
	public int insertRole(Role role);
}
