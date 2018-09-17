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
 * ��ʼ������,����,��ʼͼƬ
 * @author wen
 *2018��7��8��16:52:40
 */
public class BackGround extends JPanel{
	private static final long serialVersionUID = -113247073233785823L;
	
	/**
	 * ����ͼƬ
	 */
	BufferedImage background;
	/**
	 * ��ʼͼƬ
	 */
	BufferedImage startImg;
	/**
	 * Ҫ��Ground����������������(������һ�������ƶ��ĵ���)
	 */
	Ground ground;
	/**
	 * ���������ϰ��ܵ�,(һ���������������������ϰ��ܵ�,֮��Ĺܵ�����������ʧ�Ĺܵ�)
	 * ����һ����־λstart
	 */
	PipeLine pipeLine1;
	PipeLine pipeLine2;
	boolean start;//(������Ϸ����;)
	boolean end;//(��Ϸ��������;)
	/**
	 * ������һֻС��
	 */
	Bird bird;
	/**
	 * ����һ���÷�
	 */
	int score;
	/**
	 * �ڹ��췽����,��ͼƬ���м���
	 * @throws IOException 
	 */
	public BackGround() throws IOException {
		background = ImageIO.read(getClass().getResource("bg.png"));
		startImg = ImageIO.read(getClass().getResource("start.png")); 
		//��ʼ�����ground
		ground = new Ground();
		//��ʼ�������ܵ�
		pipeLine1 = new PipeLine(420);
		pipeLine2 = new PipeLine(600);
		//��ʼ��С��
		bird = new Bird(140, 225);
	}
	/**
	 * ��д�����paint����
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//���Ʊ���ͼƬ
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
		//���ƿ�ʼͼƬ
		if(start == false) 
		{
			g.drawImage(startImg, 0, 0, null);
		}
		if (start == true) {
			//���������ϰ��ܵ�
			pipeLine1.paint(g);
			pipeLine2.paint(g);
			//��ʼ��ʱ��������С��
			bird.paint(g);
		}
		g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
		g.setColor(Color.WHITE);
		g.drawString("score="+score, 30, 50);
		//���Ƶ�����ƶ�ͼƬ
		ground.paint(g);
		
	}
	/**
	 * ��ʼ�Ķ���(��ʾ���ǿ�ʼ����ʱ������ƶ�)
	 * @throws InterruptedException 
	 */
	public void action() throws InterruptedException {
		/**
		 * �������ע�ᵽ�������ʱ���������
		 */
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if (end == true) {//�����Ϸ����,���½��г�ʼ��
					//��ʼ�����ground
					try {
						score =0;
						ground = new Ground();
						//��ʼ�������ܵ�
						pipeLine1 = new PipeLine(420);
						pipeLine2 = new PipeLine(600);
						//��ʼ��С��
						bird = new Bird(140, 225);
						//���µ���
						start =false;
						end = false;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				//�����һ��,����Ϸ��ʼ
				start = true;
				//ÿ�ε�����ı�С��ĵ�ǰ�ٶȱ�Ϊ20
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
				//�ÿ����ƶ���ͼƬx--
				ground.step();
				if (start == true) {//��Ϸ��ʼ֮��,�ܵ����ƶ�
					//�ܵ��ƶ�
					pipeLine1.step();
					pipeLine2.step();
					//С���ȳ��
					bird.step();
					//������ײ���
					if (bird.hit(pipeLine1, pipeLine2, ground)) {
						start = false;
						end = true;
					}
					if (bird.sum(pipeLine1, pipeLine2)) {
						score++;
					}
				}
				//���»���
				repaint();
				Thread.sleep(1000/60);//ÿ��1/60���ػ�һ��
		}
		
		
	}
	public static void main(String[] args) throws Exception{
		BackGround backGround=new BackGround();
		backGround.init();
	}
	
	/**
	 * ��������
	 * @throws IOException 
	 */
	public void init() throws Exception {
		//����һ������
				JFrame frame = new JFrame("fly bird");
				//����һ�����
				BackGround bGround = new BackGround();
				//���������û���������
				frame.setSize(320, 480);
				//���������ò��ܵ�����С
				frame.setResizable(false);
				//����������Ĭ�ϵĹرն���
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//���ô��ڳ���ʱ��ʾ����Ļ������
				frame.setLocationRelativeTo(null);
				//�������ӵ�������
				frame.add(bGround);
				//���ÿɼ�
				frame.setVisible(true);
				//ִ�п�ʼ����
				bGround.action();
	}
}
