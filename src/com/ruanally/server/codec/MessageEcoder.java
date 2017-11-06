package com.ruanally.server.codec;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import com.ruanally.data.MessageDataPackage;

/**
 * 消息编码器
 * 
 * @author 小石
 *
 */
public class MessageEcoder implements ProtocolEncoder {

	public MessageEcoder() {
		this(Charset.forName("UTF-8"));
	}

	public MessageEcoder(Charset charset) {
	}

	@Override
	public void encode(IoSession ioSession, Object message, ProtocolEncoderOutput out) throws Exception {
		IoBuffer ioBuffer = IoBuffer.allocate(100).setAutoExpand(true);
		MessageDataPackage mdp = (MessageDataPackage) message;
		byte[] bytes = null;//mdp.getBytes();
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(buf);
		byte[] heads = buf.toByteArray();
		dos.close();
		buf.close();
		ioBuffer.put(heads);
		ioBuffer.put(bytes);
		ioBuffer.flip();
		out.write(ioBuffer);
	}

	@Override
	public void dispose(IoSession ioSession) throws Exception {

	}

}
