package Util;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;




public class myFrame  extends Frame{
	
	/**
	 * ���ش���
	 */
	public void launchFrame(){
		//��������С
		setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGTH);
		//�������λ��
		setLocation(450, 150);
		//�õ�ǰ���ɼ�
		setVisible(true);
		//�����ػ��߳�
		new PaintThread().start();  
		//���һ�����ڼ�����ʵ�����ر�
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
	
	/**
	 * ����һ���ػ����ڵ��߳��࣬��һ���ڲ���
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
		
		
	

	