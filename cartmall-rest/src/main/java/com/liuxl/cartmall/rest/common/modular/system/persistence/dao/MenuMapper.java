package com.liuxl.cartmall.rest.common.modular.system.persistence.dao;

import com.liuxl.cartmall.core.node.MenuNode;
import com.liuxl.cartmall.rest.common.modular.system.persistence.model.Menu;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author liuxl123
 * @since 2018-05-30
 */
public interface MenuMapper extends BaseMapper<Menu> {

	
	/**
     * 根据角色获取菜单
     *
     * @param roleIds
     * @return
     * @date 2017年2月19日 下午10:35:40
     */
    List<MenuNode> getMenusByRoleIds(List<Integer> roleIds);
}
