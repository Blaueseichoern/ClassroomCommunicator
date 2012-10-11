package com.screen;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import com.connection.Communicator;
import com.connection.Participant;

public class ComWindow extends JFrame
{
	private static final long serialVersionUID = 5333176854570891107L;
	
	private Communicator communicator;
	
	JList<Participant> participants;
	MessageField messages;
	TextInput input;
	
	public ComWindow(Communicator com)
	{
		super("Classroom Communicator");
		
		communicator = com;
		
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(4, 4, 4, 4);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		
		DefaultListModel<Participant> model = new DefaultListModel<Participant>();
		participants = new JList<Participant>(model);
		
		gbl.setConstraints(participants, gbc);
		add(participants);
		
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.gridheight = 2;
		gbc.gridwidth = 2;
		
		
		this.setSize(1024, 720);
	}
	
}
