package com.screen;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ChatPane extends JPanel
{
	private static final long serialVersionUID = -997392235063634247L;
	
	JTextArea output;
	
	MessageField input;
	
	public ChatPane()
	{
		//TODO
	}
	
	public void appendText(String msg)
	{
		output.setText(output.getText() + msg);
	}

}
