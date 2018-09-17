package Util;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;




public class myFrame  extends Frame {
	
	/**
	 * ���ش���
	 */
	public void launchFrame(){
		//��������С
		setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGTH);
		//�������λ��
		setLocation(100, 100);
		//�õ�ǰ���ɼ�
		setVisible(true);
		//�����ػ��߳�
		new PaintThread().start();  
		//���һ�����ڼ�����ʵ�����ر�
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
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
