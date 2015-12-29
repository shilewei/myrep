package com.common;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.message.Message;
import com.message.MessageController;

public class MessageConfig extends JFinalConfig {

	/**
	 * 配置常量
	 */
	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		// 加载少量必要配置，随后可用PropKit.get(...)获取值
			PropKit.use("a_little_config.txt");
			me.setDevMode(PropKit.getBoolean("devMode", false));
	}
	/** 
	 * 配置路由
	 */
	@Override
	
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		// 第三个参数省略时默认与第一个参数值相同，在此即为 "/message" 
		me.add("/message",MessageController.class);   
	}

	/**
	 * 配置插件
	 */
	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
		// 配置C3p0数据库连接池插件
		C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
		me.add(c3p0Plugin);
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		// 映射job_info_shiyansheng表到Message模型
		arp.addMapping("job_info_shiyansheng", Message.class);	

	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub

	}


	/**
	 * 配置处理器
	 */
	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 运行此 main 方法可以启动项目，此main方法可以放置在任意的Class类定义中，不一定要放于此
	 */
	public static void main(String[] args) {
		JFinal.start("WebRoot", 80, "/", 5);
	}
}
