package com.ruanally.server.main;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import com.ruanally.server.acceptor.ServerSocketAcceptor;

/**
 * 
 * 服务端启动入口
 * @author 小石
 * qq:807077517
 */
public class MainClass {

	private static Logger log=Logger.getLogger(MainClass.class);
	
	public static void main(String args[]){
		try {
			ServerSocketAcceptor ssa=new ServerSocketAcceptor();
			ssa.start();
			while(true){}
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
		}
	}
}
