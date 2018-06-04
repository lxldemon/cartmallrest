package com.liuxl.cartmall.rest.common.modular.system.persistence.service;

import com.baomidou.mybatisplus.service.IService;
import com.liuxl.cartmall.rest.common.modular.system.persistence.model.User;

public interface IUserService extends IService<User>{

	/**
	 * 用户登录校验
	 * @param account
	 * @param password
	 * @return
	 */
	Object login(String account,String password);
	
	User findByAccount(String account);
}
