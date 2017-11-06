package com.ruanally.client.main;

import java.net.InetSocketAddress;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

/**
 * 客户端入口
 * @author 小石
 * qq:807077517
 */
public class MainClass {

	public static void main(String args[]){
		NioSocketConnector connection=new NioSocketConnector();
		connection.setConnectTimeoutCheckInterval(30);
		connection.setHandler(new IoHandlerAdapter(){});
		ConnectFuture cf=connection.connect(new InetSocketAddress("127.0.0.1", 8888));
		cf.awaitUninterruptibly();
	
		cf.getSession().getCloseFuture().awaitUninterruptibly();
		connection.dispose();
	}
}
