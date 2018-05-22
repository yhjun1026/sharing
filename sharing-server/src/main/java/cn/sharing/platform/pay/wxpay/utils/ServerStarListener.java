package cn.sharing.platform.pay.wxpay.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServerStarListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		final String MPayConfiFile = "C:\\MPay\\MPayConfig.xml";	
		System.out.print("配置文件路径：" + MPayConfiFile);
		  /*读取微信账号相关参数配置*/  
		


	}

}
