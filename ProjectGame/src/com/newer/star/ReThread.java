package com.newer.star;


public class ReThread extends Thread{
	MyPanel mPanel;

	public ReThread(MyPanel myPanel) {
		//�������������������������
		this.mPanel = myPanel;
	}
	public void run() {
		while (true) {
			try {
				Thread.sleep(10);
				mPanel.repaint();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
