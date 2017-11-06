package com.ruanally.server.handler;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import com.ruanally.data.MessageDataPackage;
import com.ruanally.server.session.SessionManager;

/**
 * 处理客户端发送来的消息
 * @author 小石
 *
 */
public class ClientMessgeHandler  extends IoHandlerAdapter{
	
	private Logger log=Logger.getLogger(ClientMessgeHandler.class);

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		//获取客户端缓存的key
		String key=(String)session.getAttribute("key");
		//获取session管理实例
		SessionManager sessionManager=SessionManager.getSessionManagerInstance();
		//删除客户端
		sessionManager.remove(key);
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		MessageDataPackage mdp=new MessageDataPackage();
		mdp.setId(session.getId()+"");
		mdp.setData("你好，你的ID为："+session.getId());
		session.write(mdp);
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		log.info("客户端空闲");
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		log.info("打开连接");
	}

}
