package com.red.mail;

/**
 * 邮件实体对象
 * 
 * @author Red
 * @version 1.0
 */
public class MailBean {

	private String logo;// logo ，附图片
	private String phone;// 邮箱中附联系电话
	private String address;// 邮箱中附联系地址
	private String server;// 邮箱服务器
	private String port;// 邮件服务器端口
	private String email;// 发送邮箱
	private String passwd;// 发送邮箱密码

	public MailBean() {

	}

	public MailBean(String server, String port, String email, String passwd,
			String msg) {
		this.server = server;
		this.port = port;
		this.email = email;
		this.passwd = passwd;
	}

	public MailBean(String logo, String phone, String address, String server,
			String port, String email, String passwd) {
		this.logo = logo;
		this.phone = phone;
		this.address = address;
		this.server = server;
		this.port = port;
		this.email = email;
		this.passwd = passwd;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
