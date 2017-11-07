package com.ruanally.server.main;

import java.net.InetSocketAddress;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.ruanally.server.handler.ServerHandlerAdapter;

/**
 * 
 * 服务端启动入口
 * 
 * @author 小石 qq:807077517
 */
public class MainClass {

	private static Logger log = Logger.getLogger(MainClass.class);

	public static void main(String args[]) {
		try {
			// 实例化管理类
			IoAcceptor acceptor = new NioSocketAcceptor();
			// 设置过滤器
			acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));
			// 设置读取数据的缓冲区大小
			acceptor.getSessionConfig().setReadBufferSize(2048);
			// 读写通道60秒内无操作进入空闲状态
			acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 60);
			// 绑定逻辑处理器
			acceptor.setHandler(new ServerHandlerAdapter());
			// 绑定端口,启动服务器
			acceptor.bind(new InetSocketAddress(8888));
			// 打印日志
			log.info("服务已启动,正在监听：8888端口");
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
		}
	}
}
