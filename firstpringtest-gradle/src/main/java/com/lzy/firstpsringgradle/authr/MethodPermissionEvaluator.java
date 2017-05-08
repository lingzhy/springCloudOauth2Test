package com.lzy.firstpsringgradle.authr;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.lzy.firstpsringgradle.entity.User;
 
public class MethodPermissionEvaluator implements PermissionEvaluator {

	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		// TODO Auto-generated method stub
		System.out.println("hasPermission!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+authentication.getName());
		
	/*	if(targetDomainObject instanceof User)
		{
			  User u = (User)targetDomainObject;
			  if(u.getName().equals(permission))
			  {
				  return true;
			  }
			
		}*/
		System.out.println("targetDomainObject:"+targetDomainObject + "                     permission:"+permission);
		if(targetDomainObject.equals(permission))
			  return true;
		
		return false;
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
}
