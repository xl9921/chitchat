package com.ruanally.server.codec;

import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
/**
 * 消息解码器
 * @author 小石
 *
 */
public class MessageDecoder extends CumulativeProtocolDecoder{

	private final Charset charset;
	
	public MessageDecoder(){
		this(Charset.forName("UTF-8"));
	}
	
	public MessageDecoder(Charset charset){
		this.charset=charset;
	}
	
	@Override
	protected boolean doDecode(IoSession ioSession, IoBuffer ioBuffer, ProtocolDecoderOutput out) throws Exception {
		return false;
	}

}
