package com.changhong.smark;

import java.io.IOException;

import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration.Builder;

public class Test {
	public static void main(String[] args) throws SmackException, IOException, XMPPException {
		/*XMPPTCPConnectionConfiguration.Builder configBuilder = XMPPTCPConnectionConfiguration.builder();
		configBuilder.setUsernameAndPassword("cheng", "cheng").setPort(5222);
		configBuilder.setSecurityMode(SecurityMode.disabled);
		configBuilder.setServiceName("gwcheng-pc");

		AbstractXMPPConnection connection = new XMPPTCPConnection(configBuilder.build());
		// Connect to the server
		connection.connect();
		// Log into the server
		connection.login();


		// Disconnect from the server
		connection.disconnect();*/
		AbstractXMPPConnection connection = null;
		Builder builder = XMPPTCPConnectionConfiguration.builder();
		builder.setSecurityMode(SecurityMode.disabled);
		XMPPTCPConnectionConfiguration config = builder.setServiceName("gwcheng-pc").setHost("gwcheng-pc").setPort(5222)
				.build();
		connection = new XMPPTCPConnection(config);
		connection.connect();
		connection.login("cheng", "cheng");
	}

}
