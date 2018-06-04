package com.liuxl.cartmall.rest.common.modular.system.persistence.service;

import java.util.List;

import com.liuxl.cartmall.core.node.MenuNode;

public interface IMenuService {

	/**
     * 根据角色获取菜单
     *
     * @param roleIds
     * @return
     * @date 2017年2月19日 下午10:35:40
     */
    List<MenuNode> getMenusByRoleIds(List<Integer> roleIds);
}
