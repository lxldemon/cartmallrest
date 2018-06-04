package com.liuxl.cartmall.rest.common.modular.system.persistence.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.liuxl.cartmall.core.node.ZTreeNode;
import com.liuxl.cartmall.rest.common.modular.system.persistence.dao.RelationMapper;
import com.liuxl.cartmall.rest.common.modular.system.persistence.dao.RoleMapper;
import com.liuxl.cartmall.rest.common.modular.system.persistence.model.Role;
import com.liuxl.cartmall.rest.common.modular.system.persistence.service.IRoleService;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RelationMapper relationMapper;

    @Override
    @Transactional(readOnly = false)
    public void setAuthority(Integer roleId, String ids) {

        
    }

    @Override
    @Transactional(readOnly = false)
    public void delRoleById(Integer roleId) {
      
    }

    @Override
    public List<Map<String, Object>> selectRoles(String condition) {
        return this.baseMapper.selectRoles(condition);
    }

    @Override
    public int deleteRolesById(Integer roleId) {
        return this.baseMapper.deleteRolesById(roleId);
    }

    @Override
    public List<ZTreeNode> roleTreeList() {
        return this.baseMapper.roleTreeList();
    }

    @Override
    public List<ZTreeNode> roleTreeListByRoleId(String[] roleId) {
        return this.baseMapper.roleTreeListByRoleId(roleId);
    }

}
