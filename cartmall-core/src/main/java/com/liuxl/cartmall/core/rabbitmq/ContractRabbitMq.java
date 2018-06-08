package com.liuxl.cartmall.core.rabbitmq;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 合同消息载体 
 * @author liuxl
 *
 */
public class ContractRabbitMq implements Serializable {
	private static final long serialVersionUID = -5762808558366536746L;
	private String id;
	private String name;
	private List<String> contractList;
	private Date createDate;
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
	public List<String> getContractList() {
		return contractList;
	}
	public void setContractList(List<String> contractList) {
		this.contractList = contractList;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
