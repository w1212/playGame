package com.newer.snake;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
 
public class Snake implements WindowListener{
 
     public void init() {
JFrame frame = new JFrame(); // 创建一个游戏界面的框架
frame.setBounds(450, 100, 900, 720); // 设置框架的大小
frame.setResizable(false); // 设置框架大小为不能改变
// 点击关闭按钮 关闭游戏界面

SnakePanel panel = new SnakePanel();  //添加画布
frame.add(panel); // 刚添加时画布是空的看不到
frame.setVisible(true); // 允许显示游戏界面
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