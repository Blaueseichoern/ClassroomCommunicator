package com.connection;

import java.net.InetAddress;

public class JoinEvent
{
	String nickname, pcName;
	InetAddress address;
	
	public JoinEvent(String nick, String pc, InetAddress address)
	{
		this.nickname = nick;
		this.pcName = pc;
		this.address = address;
	}
	
	public Participant formParticipant()
	{
		return new Participant(pcName, nickname, address);
	}
}
