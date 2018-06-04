package com.liuxl.cartmall.rest.common.modular.system.persistence.dao;

import com.liuxl.cartmall.rest.common.modular.system.persistence.model.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 管理员表 Mapper 接口
 * </p>
 *
 * @author liuxl123
 * @since 2018-05-30
 */
public interface UserMapper extends BaseMapper<User> {

	
	User findByAccount(String account);
}
