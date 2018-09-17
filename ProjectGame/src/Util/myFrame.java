package Util;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;




public class myFrame  extends Frame{
	
	/**
	 * 加载窗口
	 */
	public void launchFrame(){
		//设置面板大小
		setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGTH);
		//设置面板位置
		setLocation(450, 150);
		//让当前面板可见
		setVisible(true);
		//启动重画线程
		new PaintThread().start();  
		//添加一个窗口监听器实现面板关闭
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
	
	/**
	 * 定义一个重画窗口的线程类，是一个内部类
	 * @author dell
	 *
	 */
	class PaintThread extends Thread {
		
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(40); //1s = 1000ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}   
			}
		   }
		}
	}
		
		
	

	