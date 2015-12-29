package com.message;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

public class MessageController extends Controller {
	public void index() {
		//分页，最后的那个5（表示当前页面设置5行）
		setAttr("messagePage", Message.me.paginate(getParaToInt(0, 1), 5));
		render("job_info.html");
	}
	
	public void add() {
		render("add.html");
	}

	/*@Before(MessageValidator.class)*/
	public void save() {
		getModel(Message.class).save();
		redirect("/message"); // 类似重定向
	}

	public void edit() {
		setAttr("message", Message.me.findById(getParaToInt()));
		redirect("/message");
	}

	/*@Before(MessageValidator.class)*/
	public void update() {
		getModel(Message.class).update();
		redirect("/message");
	}
	

	public void delete() {
		Message.me.deleteById(getParaToInt());
		redirect("/message");
	}

}
