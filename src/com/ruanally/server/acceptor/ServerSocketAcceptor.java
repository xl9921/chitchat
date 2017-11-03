package com.ruanally.server.acceptor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.ruanally.server.factory.MessageCoderFactory;
import com.ruanally.server.handler.ClientMessgeHandler;


/**
 * 绑定端口并注册服务
 * @author 小石
 * qq:807077517
 */
public class ServerSocketAcceptor {
	
	private Logger log=Logger.getLogger(ServerSocketAcceptor.class);
	
	//服务端口号
	private final int port;
	//编码
	private final Charset charset;
	
	//默认为888端口
	public ServerSocketAcceptor(){
		this(8888,Charset.forName("UTF-8"));
	}
	
	//自定义端口与编码
	public ServerSocketAcceptor(int port,Charset charset){
		this.port=port;
		this.charset=charset;
	}
	
	/**
	 * 启动服务
	 * @throws IOException 
	 */
	public void start() throws IOException{
		//实例化管理类
		IoAcceptor acceptor = new NioSocketAcceptor(); 
		// 设置过滤器
        acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new MessageCoderFactory(this.charset)));  
        // 设置读取数据的缓冲区大小   
        acceptor.getSessionConfig().setReadBufferSize(2048);  
        // 读写通道60秒内无操作进入空闲状态   
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,60);  
        // 绑定逻辑处理器  
        acceptor.setHandler(new ClientMessgeHandler());  
        // 绑定端口,启动服务器  
        acceptor.bind(new InetSocketAddress(this.port));  
        //打印日志
        log.info("服务已启动");
	}
	
}
