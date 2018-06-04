package com.liuxl.cartmall.rest.modular.system.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liuxl.cartmall.core.base.controller.BaseRestController;
import com.liuxl.cartmall.core.base.tips.R;
import com.liuxl.cartmall.core.cache.redis.RedisService;
import com.liuxl.cartmall.rest.common.modular.system.persistence.service.IUserService;


/**
 * 登录页面
 * @author liuxl
 *
 */
@RestController
@RequestMapping("/system/api")
public class ApiLoginController extends BaseRestController{

	
	@Autowired
	IUserService userService;
	@Autowired
	RedisService redisService;
	
	@PostMapping("/login")
	public Object login(String username,String password){
		
		logger.info("55555555555");
		redisService.set("i", "你好");
		System.out.println(redisService.get("i"));
		/*
		 * 1.第一次认证：第一次登录，用户从浏览器输入用户名/密码，提交后到服务器的登录处理的Action层（Login Action）；
		 * 2.Login Action调用认证服务进行用户名密码认证，如果认证通过，Login Action层调用用户信息服务获取用户信息（包括完整的用户信息及对应权限信息）；
		 * 3.返回用户信息后，Login Action从配置文件中获取Token签名生成的秘钥信息，进行Token的生成；
		 * 4.生成Token的过程中可以调用第三方的JWT Lib生成签名后的JWT数据；
		 * 5.完成JWT数据签名后，将其设置到COOKIE对象中，并重定向到首页，完成登录过程；
		 */
		
		
		
		return R.ok();
	}
	
}
