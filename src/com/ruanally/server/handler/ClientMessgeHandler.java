package com.ruanally.server.handler;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * 处理客户端发送来的消息
 * @author 小石
 *
 */
public class ClientMessgeHandler  extends IoHandlerAdapter{

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
	}

}
