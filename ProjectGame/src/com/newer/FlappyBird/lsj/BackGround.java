package com.newer.FlappyBird.lsj;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** 
 * 初始化界面,背景,开始图片
 * @author wen
 *2018年7月8日16:52:40
 */
public class BackGround extends JPanel{
	private static final long serialVersionUID = -113247073233785823L;
	
	/**
	 * 背景图片
	 */
	BufferedImage background;
	/**
	 * 开始图片
	 */
	BufferedImage startImg;
	/**
	 * 要把Ground类包含到这个类里面(增加了一个可以移动的地面)
	 */
	Ground ground;
	/**
	 * 增加两个障碍管道,(一个背景框内最多存有两个障碍管道,之后的管道可以利用消失的管道)
	 * 增加一个标志位start
	 */
	PipeLine pipeLine1;
	PipeLine pipeLine2;
	boolean start;//(启动游戏的用途)
	boolean end;//(游戏结束的用途)
	/**
	 * 增加了一只小鸟
	 */
	Bird bird;
	/**
	 * 增加一个得分
	 */
	int score;
	/**
	 * 在构造方法中,对图片进行加载
	 * @throws IOException 
	 */
	public BackGround() throws IOException {
		background = ImageIO.read(getClass().getResource("bg.png"));
		startImg = ImageIO.read(getClass().getResource("start.png")); 
		//初始化这个ground
		ground = new Ground();
		//初始化两个管道
		pipeLine1 = new PipeLine(420);
		pipeLine2 = new PipeLine(600);
		//初始化小鸟
		bird = new Bird(140, 225);
	}
	/**
	 * 重写父类的paint方法
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//绘制背景图片
		g.drawImage(background, 0, 0, null);
		if (end) {
			try {
				BufferedImage gameover = ImageIO.read(getClass().getResource("gameover.png"));
				g.drawImage(gameover, 0, 0, null);
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//绘制开始图片
		if(start == false) 
		{
			g.drawImage(startImg, 0, 0, null);
		}
		if (start == true) {
			//绘制两个障碍管道
			pipeLine1.paint(g);
			pipeLine2.paint(g);
			//开始的时候来绘制小鸟
			bird.paint(g);
		}
		g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
		g.setColor(Color.WHITE);
		g.drawString("score="+score, 30, 50);
		//绘制地面的移动图片
		ground.paint(g);
		
	}
	/**
	 * 开始的动作(表示就是开始启动时地面的移动)
	 * @throws InterruptedException 
	 */
	public void action() throws InterruptedException {
		/**
		 * 给主面板注册到鼠标点击的时间监听器上
		 */
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if (end == true) {//如果游戏结束,重新进行初始化
					//初始化这个ground
					try {
						score =0;
						ground = new Ground();
						//初始化两个管道
						pipeLine1 = new PipeLine(420);
						pipeLine2 = new PipeLine(600);
						//初始化小鸟
						bird = new Bird(140, 225);
						//重新调整
						start =false;
						end = false;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				//鼠标点击一下,则游戏开始
				start = true;
				//每次点击鼠标改变小鸟的当前速度变为20
				bird.fly();
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		while(true) {
				//让可以移动的图片x--
				ground.step();
				if (start == true) {//游戏开始之后,管道在移动
					//管道移动
					pipeLine1.step();
					pipeLine2.step();
					//小鸟扇翅膀
					bird.step();
					//进行碰撞检测
					if (bird.hit(pipeLine1, pipeLine2, ground)) {
						start = false;
						end = true;
					}
					if (bird.sum(pipeLine1, pipeLine2)) {
						score++;
					}
				}
				//重新绘制
				repaint();
				Thread.sleep(1000/60);//每隔1/60秒重绘一次
		}
		
		
	}
	public static void main(String[] args) throws Exception{
		BackGround backGround=new BackGround();
		backGround.init();
	}
	
	/**
	 * 窗口设置
	 * @throws IOException 
	 */
	public void init() throws Exception {
		//创建一个窗口
				JFrame frame = new JFrame("fly bird");
				//创建一个面板
				BackGround bGround = new BackGround();
				//给窗口设置基本的属性
				frame.setSize(320, 480);
				//给窗口设置不能调整大小
				frame.setResizable(false);
				//给窗口设置默认的关闭动作
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//设置窗口出现时显示在屏幕的正中
				frame.setLocationRelativeTo(null);
				//把面板添加到窗口上
				frame.add(bGround);
				//设置可见
				frame.setVisible(true);
				//执行开始动作
				bGround.action();
	}
}
