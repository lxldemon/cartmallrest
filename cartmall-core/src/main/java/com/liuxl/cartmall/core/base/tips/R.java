package com.liuxl.cartmall.core.base.tips;

import java.util.HashMap;
import java.util.Map;

/**
 * api调用的时候，返回给前端的用户数据
 * @author win7
 *
 */
public class R extends HashMap<String, Object> {

	public R() {
		put("code", RetEnum.RET_SUCCESS.code);
		put("msg", RetEnum.RET_SUCCESS.message);
	}

	public static R error() {
		return error(RetEnum.RET_ERROR.code,RetEnum.RET_ERROR.message);
	}

	public static R error(String msg) {
		return error(RetEnum.RET_ERROR.code, msg);
	}

	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}

	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}

	public static R ok() {
		return new R();
	}

	@Override
	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}
	/**
	 * 前台返回的自定义异常或者消息，可以再这里定义
	 */
	enum RetEnum{
	    RET_SUCCESS(200, "消息返回成功"),RET_ERROR(500,"未知异常，请联系管理员");
	    private int code;
	    private String message;
		private RetEnum(int code, String message) {
			this.code = code;
			this.message = message;
		}
	    
	}
}
