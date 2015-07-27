package com.red.mail;

/**
 * 邮件内容实体bean
 * 
 * @author Red
 * @version 1.0
 */
public class MailContent {

	private String title; // 邮件主题
	private String message;// 邮件内容
	private String file;// 附件

	public MailContent() {
		this.title = "test";
		this.message = "test";
	}

	public MailContent(String title, String message) {
		this.title = title;
		this.message = message;
	}

	public void addFile(String file) {
		this.file = file;
	}

	protected String getFile() {
		return file;
	}

	public String getTitle() {
		return title;
	}

	protected void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	protected void setMessage(String message) {
		this.message = message;
	}

}
