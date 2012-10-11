package com.connection;

public class Chat 
{
	private String message;
	
	private Identifyer identity;
	
	public Chat(String msg, Identifyer id)
	{
		message = msg;
		
		identity = id;
	}
	
	public String getMessage()
	{
		return message;
	}
	
	public Identifyer getId()
	{
		return identity;
	}
	
}
