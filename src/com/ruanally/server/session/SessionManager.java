package com.ruanally.server.session;

import java.util.HashMap;
import java.util.Map;

import org.apache.mina.core.session.IoSession;

/**
 *  session管理
 * @author 小石
 *
 */
public class SessionManager {

	private static SessionManager sessionManager=null;
	private static Map<String, IoSession> map=new HashMap<String, IoSession>();
	
	private SessionManager(){
	}
	
	public static SessionManager getSessionManagerInstance(){
		if(null==sessionManager){
			sessionManager=new SessionManager();
		}
		return sessionManager;
	}
	
	/**
	 * 将客户端的session进行保存
	 * @param key
	 * @param ioSession
	 */
	public void put(String key,IoSession ioSession){
		map.put(key, ioSession);
	}
	
	
	/**
	 * 客户端掉线将客户端删除
	 * @param key
	 */
	public void remove(String key){
		map.remove(key);
	}
	
	
	/**
	 * 获取相应的sesion
	 * @param key
	 * @return
	 */
	public IoSession get(String key){
		return map.get(key);
	}
	
}
