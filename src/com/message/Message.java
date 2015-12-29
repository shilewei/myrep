package com.message;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

@SuppressWarnings("serial")
public class Message extends Model<Message>{
	public static final Message me = new Message();
	
	public Page<Message> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", 
				"from job_info_shiyansheng order by id asc");
	}
}
