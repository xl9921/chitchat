package com.ruanally.server.factory;

import java.nio.charset.Charset;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
/**
 * 
 * 消息编码解码工厂
 * @author 小石
 */
public class MessageCoderFactory  implements ProtocolCodecFactory {

	public MessageCoderFactory(){
		this(Charset.forName("UTF-8"));
	}
	
	public MessageCoderFactory(Charset charset){
		
	}
	
	@Override
	public ProtocolDecoder getDecoder(IoSession ioSession) throws Exception {
		return null;
	}

	@Override
	public ProtocolEncoder getEncoder(IoSession ioSession) throws Exception {
		return null;
	}

}
