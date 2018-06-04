package com.liuxl.cartmall.rest.common.modular.system.persistence.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.liuxl.cartmall.rest.common.modular.system.persistence.dao.UserMapper;
import com.liuxl.cartmall.rest.common.modular.system.persistence.model.User;
import com.liuxl.cartmall.rest.common.modular.system.persistence.service.IUserService;
import com.liuxl.cartmall.rest.modular.auth.validator.IReqValidator;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

	@Autowired
	UserMapper userMapper;
	
	@Resource(name = "dbValidator")
	private IReqValidator reqValidator;

	@Value("${renzhengservers.auth-path}")
	private String auth_url;

	@Override
	public Object login(String account, String password) {

		/*
		 * 1.第一次认证：第一次登录，用户从浏览器输入用户名/密码，提交后到服务器的登录处理的Action层（Login Action）；
		 * 2.Login Action调用认证服务进行用户名密码认证，如果认证通过，Login
		 * Action层调用用户信息服务获取用户信息（包括完整的用户信息及对应权限信息）； 3.返回用户信息后，Login
		 * Action从配置文件中获取Token签名生成的秘钥信息，进行Token的生成； 4.生成Token的过程中可以调用第三方的JWT
		 * Lib生成签名后的JWT数据； 5.完成JWT数据签名后，将其设置到COOKIE对象中，并重定向到首页，完成登录过程；
		 */

		System.out.println(auth_url);
		return null;
	}

	@Override
	public User findByAccount(String account) {
		return userMapper.findByAccount(account);
	}

}
