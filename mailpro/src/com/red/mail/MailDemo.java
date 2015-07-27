package com.red.mail;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.mail.EmailException;

import com.red.mail.model.MailModel;


/**
 * 邮件发送Demo
 */
public class MailDemo {
    /**
     * 默认样式发送邮件
     * @param mailBean 发送端邮箱配置
     * @param title 标题
     * @param content 邮件内容
     * @param receives 邮件发送人邮箱地址
     */
    public void mailDefaultSendDemo(MailBean mailBean, String title, String content, String[] receives) {
        try {
            // 发送邮件标题,内容
            MailContent mailContent = new MailContent(title, content);
            // 邮件发送中心配置
            MailCenter center = new MailCenter(mailBean, receives);
            // 邮件发送
            center.send(mailContent);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

    /**
     * 邮件发送,抄送给其他人
     * @param mailBean 发送端邮箱配置
     * @param title 标题
     * @param content 邮件内容
     * @param receives 收件人邮箱地址
     * @param carbons 抄送人邮箱地址
     */
    public void mailSendReceivesAndCarbons(MailBean mailBean, String title, String content, String[] receives, String[] carbons) {
        try {
            // 发送邮件标题,内容
            MailContent mailContent = new MailContent(title, content);
            // 邮件发送中心配置,设置抄送人
            MailCenter center = new MailCenter(mailBean, receives, carbons);
            // 邮件发送
            center.send(mailContent);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

    /**
     * 邮件发送,添加附件
     * @param mailBean 发送端邮箱配置
     * @param title 标题
     * @param content 邮件内容
     * @param receives 收件人邮箱地址
     * @param filepath 附件文件路径
     */
    public void mailSendFile(MailBean mailBean, String title, String content, String[] receives, String filepath) {
        try {
            // 发送邮件标题,内容
            MailContent mailContent = new MailContent(title, content);
            // 邮件添加附件路径
            mailContent.addFile(filepath);
            // 邮件发送中心配置
            MailCenter center = new MailCenter(mailBean, receives);
            // 邮件发送
            center.send(mailContent);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

    /**
     * 邮件发送,设置自定义模板
     * @param mailBean 发送端邮箱配置
     * @param title 标题
     * @param content 邮件内容
     * @param receives 收件人邮箱地址
     */
    public void mailSendDefinedModel(final MailBean mailBean, String title, String content, String[] receives) {
        try {
            // 发送邮件标题,内容
            MailContent mailContent = new MailContent(title, content);
            // 邮件发送中心配置
            MailCenter center = new MailCenter(mailBean, receives);
            // 邮件发送自定义样式
            center.setMailModel(new MailModel() {
                @Override
                public String format(MailBean mail, MailContent content) {
                    String htmlmsg = "<style class='fox_global_style'>div.fox_html_content { line-height: 1.5; }div.fox_html_content { font-size: 10.5pt; font-family: 宋体; color: rgb(0, 0, 0); line-height: 1.5; }</style><div style='MARGIN: 10px; FONT-FAMILY: verdana; FONT-SIZE: 10pt'>"
                                     + content.getTitle()
                                     + "<br><br><hr/><img src='"
                                     + mailBean.getLogo()
                                     + "'></div><div style='margin: 10px; font-size: 13px;'><font face='Arial'>"
                                     + content.getMessage()
                                     + " &nbsp;</font></div><div style='margin: 10px; font-size: 13px;'><span style='background-color: rgba(0, 0, 0, 0); font-family: Arial; line-height: 1.5;'>24小时客服电话："
                                     + mailBean.getPhone()
                                     + "</span></div><div style='margin: 10px; font-size: 13px;'><span style='font-family: 宋体, Tahoma; font-size: small; line-height: normal;'>" + mailBean.getAddress() + "</span></div>";
                    return htmlmsg;
                }
            });
            center.send(mailContent);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

    /**
     * Junit测试
     * 
     * <pre>
     * &#064;Test
     * public void main() {
     *     try {
     *         final MailBean mailBean = new MailBean(&quot;http://cdn.exclouds.com/yiyunlog.jpg&quot;, &quot;15916315696&quot;, &quot;上海市上海市闸北区测试地址&quot;, &quot;mail.exclouds.com&quot;, &quot;25&quot;, &quot;chablis@exclouds.com&quot;, &quot;woshi10&quot;);
     *         MailContent mailContent = new MailContent(&quot;testtile&quot;, &quot;测试&quot;);
     *         File filepath = new File(&quot;test.txt&quot;);
     *         if (!filepath.exists()) {
     *             filepath.createNewFile();
     *         }
     *         mailContent.addFile(filepath.getAbsolutePath());
     *         String[] receives = {&quot;yangchen@exclouds.com&quot;};
     *         String[] carbons = {&quot;wangzhao@exclouds.com&quot;};
     *         MailCenter center = new MailCenter(mailBean, receives, carbons);
     *         center.setMailModel(new MailModel() {
     *             &#064;Override
     *             public String format(MailBean mail, MailContent content) {
     *                 String htmlmsg = &quot;&lt;style class='fox_global_style'&gt;div.fox_html_content { line-height: 1.5; }div.fox_html_content { font-size: 10.5pt; font-family: 宋体; color: rgb(0, 0, 0); line-height: 1.5; }&lt;/style&gt;&lt;div style='MARGIN: 10px; FONT-FAMILY: verdana; FONT-SIZE: 10pt'&gt;&quot;
     *                                  + content.getTitle()
     *                                  + &quot;&lt;br&gt;&lt;br&gt;&lt;hr/&gt;&lt;img src='&quot;
     *                                  + mailBean.getLogo()
     *                                  + &quot;'&gt;&lt;/div&gt;&lt;div style='margin: 10px; font-size: 13px;'&gt;&lt;font face='Arial'&gt;&quot;
     *                                  + content.getMessage()
     *                                  + &quot;  &lt;/font&gt;&lt;/div&gt;&lt;div style='margin: 10px; font-size: 13px;'&gt;&lt;span style='background-color: rgba(0, 0, 0, 0); font-family: Arial; line-height: 1.5;'&gt;24小时客服电话：&quot;
     *                                  + mailBean.getPhone()
     *                                  + &quot;&lt;/span&gt;&lt;/div&gt;&lt;div style='margin: 10px; font-size: 13px;'&gt;&lt;span style='font-family: 宋体, Tahoma; font-size: small; line-height: normal;'&gt;&quot; + mailBean.getAddress() + &quot;&lt;/span&gt;&lt;/div&gt;&quot;;
     *                 return htmlmsg;
     *             }
     *         });
     *         center.send(mailContent);
     *     } catch (MalformedURLException e) {
     *         e.printStackTrace();
     *     } catch (EmailException e) {
     *         e.printStackTrace();
     *     } catch (IOException e) {
     *         e.printStackTrace();
     *     }
     * }
     * </pre>
     */
//    public void main(String[] args) {
//        try {
//            final MailBean mailBean = new MailBean("http://www.baidu.com/img/bd_logo1.png", "13671709929", "四川省成都市", "mail.sina.com", "25", "it_red@sina.com", "wang11160104");
//            MailContent mailContent = new MailContent("testtile", "测试");
//            File filepath = new File("test.txt");
//            if (!filepath.exists()) {
//                filepath.createNewFile();
//            }
//            mailContent.addFile(filepath.getAbsolutePath());
//            String[] receives = {"wangxingyu@exclouds.com"};
//            String[] carbons = {"it_red@163.com"};
//            MailCenter center = new MailCenter(mailBean, receives, carbons);
//            center.setMailModel(new MailModel() {
//                @Override
//                public String format(MailBean mail, MailContent content) {
//                    String htmlmsg = "<style class='fox_global_style'>div.fox_html_content { line-height: 1.5; }div.fox_html_content { font-size: 10.5pt; font-family: 宋体; color: rgb(0, 0, 0); line-height: 1.5; }</style><div style='MARGIN: 10px; FONT-FAMILY: verdana; FONT-SIZE: 10pt'>"
//                                     + content.getTitle()
//                                     + "<br><br><hr/><img src='"
//                                     + mailBean.getLogo()
//                                     + "'></div><div style='margin: 10px; font-size: 13px;'><font face='Arial'>"
//                                     + content.getMessage()
//                                     + " &nbsp;</font></div><div style='margin: 10px; font-size: 13px;'><span style='background-color: rgba(0, 0, 0, 0); font-family: Arial; line-height: 1.5;'>24小时客服电话："
//                                     + mailBean.getPhone()
//                                     + "</span></div><div style='margin: 10px; font-size: 13px;'><span style='font-family: 宋体, Tahoma; font-size: small; line-height: normal;'>" + mailBean.getAddress() + "</span></div>";
//                    return htmlmsg;
//                }
//            });
//            center.send(mailContent);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (EmailException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    
    public static void main(String[] args) {
        try {
            final MailBean mailBean = new MailBean("http://www.baidu.com/img/bd_logo1.png", "13671709929", "四川省成都市", "smtp.sina.com.cn", "25", "it_red@sina.com", "wang11160104");
            MailContent mailContent = new MailContent("testtile", "测试");
            File filepath = new File("test.txt");
            if (!filepath.exists()) {
                filepath.createNewFile();
            }
            mailContent.addFile(filepath.getAbsolutePath());
            String[] receives = {"wangxingyu@exclouds.com"};
            String[] carbons = {"it_red@163.com"};
            MailCenter center = new MailCenter(mailBean, receives, carbons);
//            center.setMailModel(null);
//            center.setMailModel(new MailModel() {
//                @Override
//                public String format(MailBean mail, MailContent content) {
//                    String htmlmsg = "<style class='fox_global_style'>div.fox_html_content { line-height: 1.5; }div.fox_html_content { font-size: 10.5pt; font-family: 宋体; color: rgb(0, 0, 0); line-height: 1.5; }</style><div style='MARGIN: 10px; FONT-FAMILY: verdana; FONT-SIZE: 10pt'>"
//                                     + content.getTitle()
//                                     + "<br><br><hr/><img src='"
//                                     + mailBean.getLogo()
//                                     + "'></div><div style='margin: 10px; font-size: 13px;'><font face='Arial'>"
//                                     + content.getMessage()
//                                     + " &nbsp;</font></div><div style='margin: 10px; font-size: 13px;'><span style='background-color: rgba(0, 0, 0, 0); font-family: Arial; line-height: 1.5;'>24小时客服电话："
//                                     + mailBean.getPhone()
//                                     + "</span></div><div style='margin: 10px; font-size: 13px;'><span style='font-family: 宋体, Tahoma; font-size: small; line-height: normal;'>" + mailBean.getAddress() + "</span></div>";
//                    return htmlmsg;
//                }
//            });
//            center.send(mailContent);
        } catch (MalformedURLException e) {
            e.printStackTrace();
//        } catch (EmailException e) {
//            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
