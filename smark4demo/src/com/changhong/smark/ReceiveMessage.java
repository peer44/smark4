package com.changhong.smark;

import java.io.IOException;
import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.chat.Chat;
import org.jivesoftware.smack.chat.ChatManager;
import org.jivesoftware.smack.chat.ChatManagerListener;
import org.jivesoftware.smack.chat.ChatMessageListener;
import org.jivesoftware.smack.packet.Message;

import junit.framework.TestCase;

/**
 * @author GWCheng
 *
 */
public class ReceiveMessage extends TestCase{
	public void testReceiveMessage() throws SmackException, IOException {
		try {
			AbstractXMPPConnection conn = GetXMPPConnection.getConnection();
			conn.connect();
			conn.login("man", "man");

			ChatManager chatmanager = ChatManager.getInstanceFor(conn);
			System.out.println("等待接受消息...");

			chatmanager.addChatListener(new ChatManagerListener() {
				@Override
				public void chatCreated(Chat chat, boolean create) {
					chat.addMessageListener(new ChatMessageListener() {

						@Override
						public void processMessage(Chat chat, Message msg) {
							// TODO Auto-generated method stub
							if (null != msg.getBody()) {
								System.out.println("接收到新消息：" + msg.getBody());
							}
						}
					});
				}
			});
		} catch (XMPPException e) {
			e.printStackTrace();
		}
		while (true);
	}
}
