package com.changhong.smark;

import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration.Builder;

/**
 * @author GWCheng
 *
 */
public class GetXMPPConnection {
	
	public static AbstractXMPPConnection  getConnection(){
		AbstractXMPPConnection connection = null;
		Builder builder = XMPPTCPConnectionConfiguration.builder();
		builder.setSecurityMode(SecurityMode.disabled);
		XMPPTCPConnectionConfiguration config = builder.setServiceName("gwcheng-pc").setHost("gwcheng-pc").setPort(5222)
				.build();
		connection = new XMPPTCPConnection(config);
		return connection;
		
	}
	public static void closeConnection(AbstractXMPPConnection connection){
		if (connection != null) {
			try {
				connection.disconnect();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	

}
