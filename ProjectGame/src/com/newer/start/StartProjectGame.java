package com.newer.start;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


import com.newer.snake.Snake;
import com.newer.star.StartGame;

import plane.planeGameFrame;


public class StartProjectGame extends JFrame {

	public static void main(String[] args) {
		StartProjectGame spg=new StartProjectGame();
		spg.init();

	}
	public void init ()
	{
		this.setTitle("大厅");

		this.setLayout(null);

		this.setBounds(450, 200, 500, 350);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton jbstart=new JButton("开始");
		JButton jbstart2=new JButton("开始");
		JButton jbstart3=new JButton("开始");
		JButton jbstart4=new JButton("开始");
		jbstart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StartGame startGame=new StartGame();
				startGame.init();
				
			}
		});
		jbstart2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				planeGameFrame planeGameFrame=new planeGameFrame();
				planeGameFrame.launchFrame();
				
			}
		});
		jbstart3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Snake snake=new Snake();
				snake.init();
			}
		});
		jbstart4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		jbstart.setBounds(55, 245, 80, 25);
		this.add(jbstart);
		
		jbstart2.setBounds(160, 245, 80, 25);
		this.add(jbstart2);
		
		jbstart3.setBounds(265, 245, 80, 25);
		this.add(jbstart3);
		
		jbstart4.setBounds(370, 245, 80, 25);
		this.add(jbstart4);
		
		setResizable(false);
		startPanel startpanel=new startPanel();

		startpanel.init();

		startpanel.setBounds(0,0,500,350);

		add(startpanel);
	}
}
class startPanel extends JPanel{
	
	public void init() {
		
		
	}
	public void paint(Graphics g)
	{	
		    super.paint(g);
			g.drawImage(new ImageIcon("imgs\\mainbackground.jpg").getImage(),0,0,this);
			g.drawImage(new ImageIcon("imgs\\star.png").getImage(),65,165,60,60,this);
			g.drawImage(new ImageIcon("imgs\\plane.png").getImage(),170,165,60,60,this);
			g.drawImage(new ImageIcon("imgs\\snake.png").getImage(),275,165,60,60,this);
			g.drawImage(new ImageIcon("imgs\\bird.png").getImage(),380,165,60,60,this);
			
			g.setColor(Color.black);
			g.setFont(new Font("幼圆",Font.BOLD,13));
			g.setFont(getFont());
			g.drawString("舞动星星", 67, 240);
			g.drawString("球球躲避战", 172, 240);
			g.drawString("好吃蛇", 285, 240);
			g.drawString("FlappyBird", 378, 240);
	}
	
}