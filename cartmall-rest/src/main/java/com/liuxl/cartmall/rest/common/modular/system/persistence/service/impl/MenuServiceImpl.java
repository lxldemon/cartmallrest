package com.liuxl.cartmall.rest.common.modular.system.persistence.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.liuxl.cartmall.core.node.MenuNode;
import com.liuxl.cartmall.rest.common.modular.system.persistence.dao.MenuMapper;
import com.liuxl.cartmall.rest.common.modular.system.persistence.model.Menu;
import com.liuxl.cartmall.rest.common.modular.system.persistence.service.IMenuService;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

	@Resource
	private MenuMapper menuMapper;

	@Override
	public List<MenuNode> getMenusByRoleIds(List<Integer> roleIds) {
		
		return this.baseMapper.getMenusByRoleIds(roleIds);
	}

}
