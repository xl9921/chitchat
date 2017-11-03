package com.ruanally.server.factory;

import java.nio.charset.Charset;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

import com.ruanally.server.codec.MessageDecoder;
import com.ruanally.server.codec.MessageEcoder;
/**
 * 
 * 消息编码解码工厂
 * @author 小石
 */
public class MessageCoderFactory  implements ProtocolCodecFactory {

	private final MessageEcoder messageEcoder;
	private final MessageDecoder messageDecoder;
	
	public MessageCoderFactory(){
		this(Charset.forName("UTF-8"));
	}
	
	public MessageCoderFactory(Charset charset){
		this.messageDecoder=new MessageDecoder(charset);
		this.messageEcoder=new MessageEcoder(charset);
	}
	
	@Override
	public ProtocolDecoder getDecoder(IoSession ioSession) throws Exception {
		return this.messageDecoder;
	}

	@Override
	public ProtocolEncoder getEncoder(IoSession ioSession) throws Exception {
		return this.messageEcoder;
	}

}
