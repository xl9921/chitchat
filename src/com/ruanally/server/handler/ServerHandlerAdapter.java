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
public class ServerHandlerAdapter  extends IoHandlerAdapter{
	
	private Logger log=Logger.getLogger(ServerHandlerAdapter.class);

	@Override
	public void messageReceived(IoSession session, Object obj) throws Exception {
		MessageDataPackage mdp=(MessageDataPackage)obj;
		if(1==mdp.getType()){
			SessionManager sessionManager=SessionManager.getSessionManagerInstance();
			IoSession ioSession=sessionManager.get(mdp.getToUser());
			ioSession.write(mdp);
		}
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
	public void sessionCreated(IoSession ioSession) throws Exception {
		MessageDataPackage mdp=new MessageDataPackage();
		mdp.setId(ioSession.getId()+"");
		mdp.setType(0);
		mdp.setMsg("欢迎你客户端");
		ioSession.write(mdp);
	}

	@Override
	public void sessionIdle(IoSession ioSession, IdleStatus status) throws Exception {
		log.info("客户端空闲");
	}

	@Override
	public void sessionOpened(IoSession ioSession) throws Exception {
		SessionManager sessionManager=SessionManager.getSessionManagerInstance();
		sessionManager.put(ioSession.getId()+"", ioSession);
	}

}
