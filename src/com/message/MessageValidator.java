package com.message;


import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * BlogValidator.
 */
public class MessageValidator extends Validator {
	
	protected void validate(Controller controller) {
		System.out.println(">>>>>>>>>开始验证了");
		/*controller.getFile();*/
		validateRequiredString("message.office", "officeMsg", "请输入");
		validateRequiredString("message.needCount", "needCountMsg", "请输入");
		validateRequiredString("message.department", "departmentMsg", "请输入");
		validateRequiredString("message.salary", "salaryMsg", "请输入");
		/*validateRequiredString("message.releaseDate", "releaseDateMsg", "请输入");*/
		validateRequiredString("message.validDate", "validDateMsg", "请输入");
		validateRequiredString("message.description", "descriptionMsg", "请输入");
		
	}
	

	protected void handleError(Controller controller) {
		System.out.println("《《《《《《《《验证不通过》》》》》》》");
		controller.keepModel(Message.class);		
		/*String actionKey = getActionKey();
		if (actionKey.equals("/message/save")){		
			controller.render("add.html");
		}else if (actionKey.equals("/message/update"))
			controller.render("edit.html");
		
		System.out.println(actionKey);*/
	}
}
