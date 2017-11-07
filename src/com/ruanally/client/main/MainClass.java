package com.ruanally.client.main;

import java.net.InetSocketAddress;

import org.apache.log4j.Logger;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import com.ruanally.client.handler.ClientHandlerAdapter;

/**
 * 客户端入口
 * @author 小石
 * qq:807077517
 */
public class MainClass {
	
	private static Logger log = Logger.getLogger(MainClass.class);

	public static void main(String args[]){
		//创建一个socket连接        
        NioSocketConnector connector=new NioSocketConnector(); 
        //设置过滤器
        connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));
        //消息核心处理器       
        connector.setHandler(new ClientHandlerAdapter());  
        // 设置链接超时时间       
        connector.setConnectTimeoutCheckInterval(30);  
        // 连接服务器，知道端口、地址      
        ConnectFuture cf = connector.connect(new InetSocketAddress("127.0.0.1",8888));
        //打印连接日志
        log.info("已经与服务器连接");
        // 等待连接创建完成      
        cf.awaitUninterruptibly();
        cf.getSession().getCloseFuture().awaitUninterruptibly();  
        connector.dispose();
	}
}
