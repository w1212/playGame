package com.newer.star;
import java.awt.*;
import javax.swing.*;


import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

 

public class PlayPanel extends JFrame implements WindowListener{
	
	MyPanel mp=null;
	public void init()
	{	
			
		mp=new MyPanel();
		this.add(mp);
		mp.init();
		//事件监听
		this.addKeyListener(mp);
		
		this.setBounds(450, 200, 600, 600);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
			
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
class MyPanel extends JPanel implements KeyListener,Runnable
{	
	

	List<DirectionDown> directiondowns=new ArrayList<DirectionDown>();
	
	Ball ball;
	int fcount;
	
	public void init()
	{
		
		ball=new Ball();
		ball.x=260;
		ball.y=450;
		
		ReThread reThread=new ReThread(this);
		reThread.start();
		Thread threadp =new Thread(this);
		threadp.start();
		
	}
	
	public void paint(Graphics g)
	{		
		    super.paint(g);
			g.drawImage(new ImageIcon("imgs\\background.jpg").getImage(),0,0,this);
			g.drawImage(new ImageIcon("imgs\\left.png").getImage(),60,425,80,65,this);
			g.drawImage(new ImageIcon("imgs\\right.png").getImage(),460,420,80,65,this);
			g.drawImage(new ImageIcon("imgs\\down.png").getImage(),260,425,80,65,this);
			g.drawImage(new ImageIcon("imgs\\lanzi.png").getImage(),ball.x,ball.y,60,60,this);
			g.drawLine(180, 0, 180, 600);
			g.drawLine(400, 0, 400, 600);
			

			g.setColor(Color.ORANGE);
			g.setFont(new Font("幼圆",Font.BOLD,40));
			g.drawString("得分:"+fcount, 30, 100);
			
			for (int i = 0; i < directiondowns.size(); i++) {
				
				DirectionDown drtd=directiondowns.get(i);
				
				g.drawImage(drtd.imageicon.getImage(), drtd.x, drtd.y, 60, 60, this);
				
			
		}
			
	}
	@Override
	public void run() {
		
		Random random=new Random();
		int count=0;
		int sp=3;
		int sf=40;
		int[] x={1,2,3};
		while (true){
			
			int y=random.nextInt(x.length);
			int z=x[y];
			int x1 = 0;
		    switch (z) {
			case 1:
				x1=260;
				break;
			case 2:
				x1=60;
				break;
			case 3:
				x1=460;
				break;
			}
		    
		    if (count%(sf*15)==0) {
				sp=sp+1;
			}
		    if (count%(sf*15)==0) {
				sf=sf-2;
			}
				if(count%sf==0){
					DirectionDown directiondown=new DirectionDown();
					directiondown.x=x1;
					directiondown.y=10;
					directiondown.speed=sp;
					directiondowns.add(directiondown);
					
				}
				
				for (int i = 0; i < directiondowns.size(); i++) {
					DirectionDown direction=directiondowns.get(i);
					
					if (direction.y>500) {
						directiondowns.remove(i);
						fcount=0;
						count=0;
						sp=3;
						sf=40;
						
					}
					else 
					{
						directiondowns.get(i).y+=directiondowns.get(i).speed;
						
						for (int j = 0; j < directiondowns.size(); j++) {
							DirectionDown directiond = directiondowns.get(j);
							
							
							if ( (ball.y-20<directiond.y)&&(ball.x==directiond.x)) {
								
								
								directiondowns.remove(i);
								fcount++;			
								
							}
						   
							}
						
					}
					
			
				}
				try {
					Thread.sleep(20);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				count++;
				
		}
	}
	
	
	@Override//键被按下
	public void keyPressed(KeyEvent e) {
		//System.out.println("被按下"+(char)e.getKeyCode());
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_LEFT:
				ball.x=60;
				//调用repaint()函数，重新绘制小球位置
				this.repaint();
				break;
			case KeyEvent.VK_RIGHT:
				ball.x=460;
				//调用repaint()函数，重新绘制小球位置
				this.repaint();
				break;
			case KeyEvent.VK_DOWN:
				ball.x=260;
				//调用repaint()函数，重新绘制小球位置
				this.repaint();
				break;
			case KeyEvent.VK_UP:
				//调用repaint()函数，重新绘制小球位置
				Graphics g1; 
				g1=getGraphics(); 
			    paint(g1);
			    this.repaint();
				break;
		}

		
	}
 
	@Override//表示具体一个值被输出，例如：F1
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override//键被释放
	public void keyReleased(KeyEvent e) {

	}
	
	}






