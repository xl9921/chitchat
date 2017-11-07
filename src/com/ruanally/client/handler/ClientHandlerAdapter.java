package com.ruanally.client.handler;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import com.ruanally.data.MessageDataPackage;

/**
 * 客户端处理
 *
 * @author 小石
 * qq:807077517
 * 微信：ruanally
 * create_time:2017年11月7日
 */
public class ClientHandlerAdapter extends IoHandlerAdapter{
	
	private Logger log=Logger.getLogger(ClientHandlerAdapter.class);
	
	public void sessionOpened(IoSession ioSession) throws Exception {  
         
   }  
     
   @Override  
   public void messageReceived(IoSession ioSession, Object obj)  
           throws Exception {
	   MessageDataPackage mdp=(MessageDataPackage)obj;
	   if(1==mdp.getType()){
		   log.info(""+mdp.getId()+"说："+mdp.getMsg());
	   }
	   if(0==mdp.getType()){
		   log.info(mdp.getMsg()+"你的ID为："+mdp.getId()+" 将该ID告诉你好友即可开始聊天");
		   new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					Scanner sc = new Scanner(System.in);
					log.info("请输入好友的ID");
					String id=sc.nextLine();
					while(true){
						log.info("输入内容");
						log.info("1 代表退出当前聊天");
						String s=sc.nextLine();
						if("1".equals(s)){
							break;
						}else{
							MessageDataPackage mk=new MessageDataPackage();
							mk.setId(mdp.getId());
							mk.setToUser(id);
							mk.setMsg(s);
							mk.setType(1);
							ioSession.write(mk);
						}
					}
				}
			}
		}).start();
	   }
   }  
     
   @Override  
   public void sessionClosed(IoSession ioSession) throws Exception { 
   }  
}
