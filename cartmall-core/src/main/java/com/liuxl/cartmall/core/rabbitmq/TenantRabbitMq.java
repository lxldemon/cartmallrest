package com.liuxl.cartmall.core.rabbitmq;

import java.io.Serializable;

/**
 * tenant消息载体 
 * @author liuxl
 *
 */
public class TenantRabbitMq implements Serializable{
	private static final long serialVersionUID = 5342284448352391745L;
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
