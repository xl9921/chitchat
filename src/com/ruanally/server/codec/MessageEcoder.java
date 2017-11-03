package com.ruanally.server.codec;

import java.nio.charset.Charset;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
/**
 * 消息编码器
 * @author 小石
 *
 */
public class MessageEcoder implements ProtocolEncoder{

	private final Charset charset;
	
	
	public MessageEcoder(){
		this(Charset.forName("UTF-8"));
	}
	
	public MessageEcoder(Charset charset){
		this.charset=charset;
	}
	
	@Override
	public void encode(IoSession ioSession, Object message, ProtocolEncoderOutput out) throws Exception {
		
	}
	
	@Override
	public void dispose(IoSession ioSession) throws Exception {
		
	}

}
