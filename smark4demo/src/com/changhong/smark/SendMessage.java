package com.changhong.smark;

import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.chat.Chat;
import org.jivesoftware.smack.chat.ChatManager;

import junit.framework.TestCase;

public class SendMessage extends TestCase {
	public void testSendMessage() throws SmackException{
		AbstractXMPPConnection conn = null;
		try {
			conn = GetXMPPConnection.getConnection();
			conn.connect();
			conn.login("cheng", "cheng");

			// 发送消息
			// Assume we've created an XMPPConnection name "connection"._
			ChatManager chatmanager = ChatManager.getInstanceFor(conn);
			Chat newChat = chatmanager.createChat("man@gwcheng-pc");
			newChat.sendMessage("我是程高伟");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			GetXMPPConnection.closeConnection(conn);;
			
		}
	}

}
