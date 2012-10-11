package com.screen;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.connection.Communicator;
/**
 * The inputfield of the text to send
 * @author Markus
 *
 */
public class TextInput
{
	private Communicator communicator;
	
	JTextArea input;
	JPanel layer;
	JButton send;
	
	public TextInput(Communicator com)
	{
		layer = new JPanel();
		
		GridBagLayout gbl = new GridBagLayout();
		layer.setLayout(gbl);
		
		input = new JTextArea();
		input.setEditable(true);
		input.setLineWrap(true);
		
		send = new JButton("SEND");
		send.setEnabled(true);
		
		addComponent(layer, gbl, input, 0, 1, 4, 3, 1, 1);
		addComponent(layer, gbl, send, 0, 0 , 4, 1, 1, 1);
		
		send.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				communicator.send(input.getText());
				input.setText("");
			}
		});
	}
	
	public void add(String msg)
	{
		input.append(msg);
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
