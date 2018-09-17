package com.newer.FlappyBird.lsj;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * 图片中障碍管道的类
 * @author wen
 *
 */
public class PipeLine {
	//加载管道图片的缓存
	BufferedImage pipeLine;
	//管道的正中心的位置,两个小管道的空隙的正中间
	int x;
	int y;
	/**
	 * 管道本身的宽度
	 */
	int width;
	/**
	 * 管道图片的高度
	 */
	int height;
	/**
	 * 用来创建随机数的对象,就是要是管道的位置不一样
	 */
	Random random;
	/**
	 * 定义管道间隙的高度(检查触碰)
	 */
	int gap = 109;
	/**
	 * 
	 * @param x1:当使用本类时,确定管道出现在哪里
	 * @throws IOException 
	 */
	public PipeLine(int x1) throws IOException {
		x = x1;
		//初始化管道的图片
		pipeLine = ImageIO.read(getClass().getResource("pipeLine.png"));
		/**
		 * 获得管道的宽度和高度
		 */
		width = pipeLine.getWidth();
		height = pipeLine.getHeight();
		//初始化random对象
		random = new Random();
		y = 140 +random.nextInt(140);
	}
	/**
	 * 绘制管道到BackGround上
	 * @param g
	 */
	public void paint(Graphics g) {
		g.drawImage(pipeLine, x-width/2, y-height/2, null);
	}
	/**
	 * 用来改变管道的横坐标
	 * 添加限制条件,不能一直向左移动
	 */
	public void step() {
		x--;
		if (x < -width) { //重新摆放管道的位置
			x = 320;
			y = 140 +random.nextInt(140);
		}
	}
}
