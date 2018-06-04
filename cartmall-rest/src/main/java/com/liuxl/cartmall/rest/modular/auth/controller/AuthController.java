package com.liuxl.cartmall.rest.modular.auth.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.liuxl.cartmall.core.base.tips.R;
import com.liuxl.cartmall.core.exception.GunsException;
import com.liuxl.cartmall.core.node.MenuNode;
import com.liuxl.cartmall.rest.common.exception.BizExceptionEnum;
import com.liuxl.cartmall.rest.common.modular.system.persistence.model.User;
import com.liuxl.cartmall.rest.common.modular.system.persistence.service.IMenuService;
import com.liuxl.cartmall.rest.common.modular.system.persistence.service.IUserService;
import com.liuxl.cartmall.rest.modular.auth.controller.dto.AuthRequest;
import com.liuxl.cartmall.rest.modular.auth.controller.dto.AuthResponse;
import com.liuxl.cartmall.rest.modular.auth.util.JwtTokenUtil;
import com.liuxl.cartmall.rest.modular.auth.validator.IReqValidator;

/**
 * 请求验证的
 *
 * @author fengshuonan
 * @Date 2017/8/24 14:22
 */
@RestController
public class AuthController{

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private IUserService userService;
    
    @Autowired
    private IMenuService menuService;
    
    @Resource(name = "dbValidator")
    private IReqValidator reqValidator;

    @RequestMapping(value = "${jwt.auth-path}")
    public R createAuthenticationToken(AuthRequest authRequest) {
        boolean validate = reqValidator.validate(authRequest);
        if (validate) {
            final String randomKey = jwtTokenUtil.getRandomKey();
            final String token = jwtTokenUtil.generateToken(authRequest.getUserName(), randomKey);
            
            //根据token 获取用户信息
            User user = userService.findByAccount(jwtTokenUtil.getUsernameFromToken(token));
            //获取用户权限信息
            List<MenuNode> nodes = null;
            if(!StringUtils.isEmpty(user.getRoleid())){
            	List<Integer> listRoleIds = new ArrayList<Integer>();
            	listRoleIds.add(Integer.parseInt(user.getRoleid()));
            	nodes = menuService.getMenusByRoleIds(listRoleIds);
            }
            return R.ok().put("user", user).put("role_list", nodes).put("token_info", new AuthResponse(token, randomKey));
        } else {
            throw new GunsException(BizExceptionEnum.AUTH_REQUEST_ERROR);
        }
    }


}
