package com.liuxl.cartmall.core.rabbitmq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMq {
	@Value("${spring.rabbitmq.addresses}")
	private String addresses;  
	@Value("${spring.rabbitmq.username}")
    private String username;
	@Value("${spring.rabbitmq.password}")
    private String password;
	@Value("${spring.rabbitmq.publisher-confirms}")
    private Boolean publisherconfirms;
	@Value("${spring.rabbitmq.port}")
	private int port;
	@Value("${spring.rabbitmq.virtual-host}")
	private String vHost;
    
    
    
	public String getAddresses() {
		return addresses;
	}
	public void setAddresses(String addresses) {
		this.addresses = addresses;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getPublisherconfirms() {
		return publisherconfirms;
	}
	public void setPublisherconfirms(Boolean publisherconfirms) {
		this.publisherconfirms = publisherconfirms;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getvHost() {
		return vHost;
	}
	public void setvHost(String vHost) {
		this.vHost = vHost;
	}  
    
    
}
