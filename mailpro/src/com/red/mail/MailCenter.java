package com.red.mail;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import com.red.mail.model.DefaultModel;
import com.red.mail.model.MailModel;
import com.red.mail.util.Util;

/**
 * 邮件操作中心，基本类
 * 
 * @author Red
 * @version 1.0
 */
public class MailCenter {

	private MailBean mailBean;// 邮件发送端信息
	private String[] receives;// 邮件接收者
	private String[] carbons;// 抄送人
	private MailModel mailModel;// 邮件模板

	public MailCenter() {
	}

	public MailCenter(MailBean mailBean, String[] receives) {
		this.mailBean = mailBean;
		this.receives = receives;
	}

	public MailCenter(MailBean mailBean, String[] receives, String[] carbons) {
		this.mailBean = mailBean;
		this.receives = receives;
		this.carbons = carbons;
	}

	/**
	 * 加载邮件模板
	 * 
	 * @param mailModel
	 *            邮件模板
	 */
	public void setMailModel(MailModel mailModel) {
		this.mailModel = mailModel;
	}

	/**
	 * 发送方法
	 * 
	 * @param content
	 *            发送内容 gbk编码
	 * @throws EmailException
	 *             邮件发送端设置错误
	 * @throws MalformedURLException
	 *             Logo路径不存在时
	 * @see com.tools.demo.MailDemo#mailSendDemo(String, String, String, String,
	 *      String, String, String, String, String, String, String[], String[],
	 *      MailModel)
	 */
	public void send(MailContent content) throws EmailException,
			MalformedURLException {
		HtmlEmail email = new HtmlEmail();
		email.setHostName(mailBean.getServer());
		email.setSmtpPort(Integer.parseInt(mailBean.getPort()));
		email.setTLS(false);
		email.setFrom(mailBean.getEmail());
		email.setAuthenticator(new DefaultAuthenticator(mailBean.getEmail(),
				mailBean.getPasswd()));
		email.setCharset("GBK");
		email.setSubject(content.getTitle());
		for (String receive : receives) {
			email.addTo(receive);
		}
		if (null != carbons && 0 != carbons.length) {
			for (String carbon : carbons) {
				email.addCc(carbon);
			}
		}
		if (null == mailModel)
			mailModel = new DefaultModel();
		String file = content.getFile();
		if (null != file) {
			EmailAttachment attachment = new EmailAttachment();
			File entityfile = new File(file);
			if (Util.isRemote(file)) {
				attachment.setURL(new URL(file));
			} else {
				attachment.setPath(file);
			}
			attachment.setDisposition("attachment");
			attachment.setDescription(entityfile.getName());
			attachment.setName(entityfile.getName());
			email.attach(attachment);
		}
		String msg = mailModel.format(mailBean, content);
		email.setMsg(msg);
		email.send();
	}

}
