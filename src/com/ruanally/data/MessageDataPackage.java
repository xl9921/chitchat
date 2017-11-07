package com.ruanally.data;

import java.io.Serializable;

/**
 * 数据包
 * @author 小石
 *
 */
public class MessageDataPackage  implements Serializable{
	
	private static final long serialVersionUID = 6156809210091001273L;
	
	private String id;  //自己的ID
	private String toUser; //要发送到的用户
	private String msg; //消息体
	private int type; //消息类型0欢迎
	
	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
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
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
