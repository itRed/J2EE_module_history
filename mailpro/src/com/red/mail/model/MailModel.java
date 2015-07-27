package com.red.mail.model;

import com.red.mail.MailBean;
import com.red.mail.MailContent;

/**
 * 邮件样式接口
 * 
 * @author Red
 * @version 1.0
 */
public interface MailModel {

	/**
	 * 设置邮件样式
	 * @param mail 发送端设置信息
	 * @param content 发送内容
	 * @return 生成的邮件样式
	 */
	public String format(MailBean mail, MailContent content);

}
