package com.newer.snake;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
 
public class Snake implements WindowListener{
 
     public void init() {
JFrame frame = new JFrame(); // ����һ����Ϸ����Ŀ��
frame.setBounds(450, 100, 900, 720); // ���ÿ�ܵĴ�С
frame.setResizable(false); // ���ÿ�ܴ�СΪ���ܸı�
// ����رհ�ť �ر���Ϸ����

SnakePanel panel = new SnakePanel();  //��ӻ���
frame.add(panel); // �����ʱ�����ǿյĿ�����
frame.setVisible(true); // ������ʾ��Ϸ����
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