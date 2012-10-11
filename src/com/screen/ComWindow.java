package com.screen;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.connection.Communicator;
import com.connection.Participant;

public class ComWindow
{
	private static final long serialVersionUID = 5333176854570891107L;
	
	private Communicator communicator;
	
	JFrame main;
	JList<Participant> participants;
	JPanel generalChat;
	JTabbedPane chats;
	MessageField messages;
	TextInput input;
	
	public ComWindow(Communicator com)
	{
		main = new JFrame("Classroom Communicator");
		
		communicator = com;
		
		
		GridBagLayout gbl = new GridBagLayout();
		main.setLayout(gbl);
		
		//LISTE
		DefaultListModel<Participant> model = new DefaultListModel<Participant>();
		participants = new JList<Participant>(model);
		
		//CHATS
		chats = new JTabbedPane();
		generalChat = new JPanel();
		initGeneralChat();
		chats.addTab("general Chat", generalChat);
		
		Container c = main.getContentPane();
		
		addComponent(c, gbl, participants, 0, 0, 1, 2, 1, 1);
		addComponent(c, gbl, chats, 1, 0, 2, 2, 1, 1);
		
		main.setSize(1024, 720);
		
		main.setVisible(true);
	}
	
    private void initGeneralChat() 
    {
		// TODO Auto-generated method stub
	}

	static void addComponent( Container cont,
            GridBagLayout gbl,
            Component c,
            int x, int y,
            int width, int height,
            double weightx, double weighty )
    {
        
       GridBagConstraints gbc = new GridBagConstraints();
       gbc.fill = GridBagConstraints.BOTH;
       gbc.gridx = x; gbc.gridy = y;
       gbc.gridwidth = width; gbc.gridheight = height;
       gbc.weightx = weightx; gbc.weighty = weighty;
       gbl.setConstraints( c, gbc );
       cont.add( c );
   }
	
}
