package com.red.mail.model;

import com.red.mail.MailBean;
import com.red.mail.MailContent;

/**
 * 邮件默认样式
 * 
 * @author Red
 * @version 1.0
 */
public class DefaultModel implements MailModel {

	/**
	 * 设置邮件默认样式
	 * @param bean 发送端设置信息
	 * @param content 发送内容
	 * @return 生成的邮件样式
	 */
	public String format(MailBean bean, MailContent content) {
		String htmlmsg = "<style class='fox_global_style'>div.fox_html_content { line-height: 1.5; }div.fox_html_content { font-size: 10.5pt; font-family: 宋体; color: rgb(0, 0, 0); line-height: 1.5; }</style><div style='MARGIN: 10px; FONT-FAMILY: verdana; FONT-SIZE: 10pt'>"
				+ content.getTitle()
				+ "<br><br><hr/><img src='"
				+ bean.getLogo()
				+ "'></div><div style='margin: 10px; font-size: 13px;'><font face='Arial'>"
				+ content.getMessage()
				+ " &nbsp;</font></div><div style='margin: 10px; font-size: 13px;'><span style='background-color: rgba(0, 0, 0, 0); font-family: Arial; line-height: 1.5;'>24小时客服电话："
				+ bean.getPhone()
				+ "</span></div><div style='margin: 10px; font-size: 13px;'><span style='font-family: 宋体, Tahoma; font-size: small; line-height: normal;'>"
				+ bean.getAddress() + "</span></div>";
		return htmlmsg;
	}

}
