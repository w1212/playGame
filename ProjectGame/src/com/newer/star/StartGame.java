package com.newer.star;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartGame extends JFrame implements WindowListener{

	
	public void init ()
	{
		this.setTitle("ÐÇÐÇ");

		this.setLayout(null);

		this.setBounds(450, 200, 300, 300);

		this.setLocationRelativeTo(null);
		this.setVisible(true);

		
		
		JButton jbstart=new JButton("¿ªÊ¼");
		jbstart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PlayPanel playPanel=new PlayPanel();
				playPanel.init();
				
				
			}
		});
		jbstart.setBounds(100, 180, 100, 35);
		this.add(jbstart);
		
		setResizable(false);
		startPanel startpanel=new startPanel();

		startpanel.init();

		startpanel.setBounds(0,0,300,300);

		add(startpanel);
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);;
	}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowOpened(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}
	
}
class startPanel extends JPanel{
	
	public void init() {
		
		
	}
	public void paint(Graphics g)
	{	
		    super.paint(g);
			g.drawImage(new ImageIcon("imgs\\start.jpg").getImage(),0,0,this);
	}
	
}


