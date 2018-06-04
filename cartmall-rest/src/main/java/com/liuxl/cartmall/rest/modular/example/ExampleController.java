package com.liuxl.cartmall.rest.modular.example;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuxl.cartmall.core.base.controller.BaseController;
import com.liuxl.cartmall.core.base.tips.R;
import com.liuxl.cartmall.rest.common.SimpleObject;

/**
 * 常规控制器
 *
 * @author fengshuonan
 * @date 2017-08-23 16:02
 */
@Controller
@RequestMapping("/hello")
public class ExampleController extends BaseController{

    @PostMapping(value="")
    @ResponseBody
    public ResponseEntity hello(@RequestBody SimpleObject simpleObject) {
        System.out.println(simpleObject.getUser());
        return ResponseEntity.ok("请求成功!");
    }
    @PostMapping("/999")
    @ResponseBody
    public Object h(String name){
    	System.out.println(name);
    	return R.ok().put("ss", 555).put("ff", 6666);
    	//return SUCCESS_TIP;
    	//return ResponseEntity.ok("请求成功2!");
    }
}
