package com.lh.back.common.passport.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.lh.back.entity.User;
import com.lh.back.service.sys.UserService;

public class UserRealm extends AuthorizingRealm{

	@Autowired
	private UserService userService;
	
	/**
	 * 为当限前登录的用户授予角色和权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();//用户名
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(userService.getRoles(username));
		authorizationInfo.setStringPermissions(userService.getPermissions(username));
		return authorizationInfo;
	}

	/**
	 * 验证当前登录的用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String)token.getPrincipal(); //用户名
		User user = userService.queryByUsername(username);//查询用户信息
		if(user == null){//没有找到账号
			throw new UnknownAccountException();
		}
		
		return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
	}

}
