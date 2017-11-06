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
		//正常当长度小于4的时候说明断包了  
		if(ioBuffer.remaining() < 4){
            return false;  
        }else{  
        	//标记当前位置 
        	ioBuffer.mark();
            //这个方法会导致potion的改变，加4,作用是获取前面从指定位置开始的4个字节  
            int len = ioBuffer.getInt(ioBuffer.position()); 
            //判断数据长度是否足够
            if(len > ioBuffer.remaining()){  
            	//消息不够，断包处理 
            	ioBuffer.reset(); 
                return false;  
            }else{ 
                byte[] bytes = new byte[len]; 
                //获取数据到字节
                ioBuffer.get(bytes,0,len);  
                //返回数据包消息，可以在这里对返回数据包消息进行处理  
                new String(bytes,charset);
                //只有调用了这个方法，IoHandlerAdapter中的messageReceived方法才会被调用  
               out.write("Message to succeed");  
            }  
            //如果还粘了包，就让父类在进行一次处理  
            if(ioBuffer.remaining() > 0){
                return true;  
            } 
            //处理成功，让父类进行接收下一个包  
            return false;
        }
	}

}
