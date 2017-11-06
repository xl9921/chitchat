package com.ruanally.data;

import java.io.Serializable;

/**
 * 数据包
 * @author 小石
 *
 */
public class MessageDataPackage  implements Serializable{
	private static final long serialVersionUID = 6156809210091001273L;
	
	private String id;
	private String toUser;
	private String data;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
