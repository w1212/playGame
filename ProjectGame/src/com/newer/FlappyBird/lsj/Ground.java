package com.newer.FlappyBird.lsj;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 下方可以移动的地面类
 * @author wen
 *
 */
public class Ground {
	/**
	 * 地面的图片
	 */
	BufferedImage ground;
	/**
	 * 图片的横坐标
	 */
	int x;
	/**
	 * 图片的纵坐标
	 */
	int y;
	
	public Ground() throws IOException {
		//加载图片
		ground = ImageIO.read(getClass().getResource("ground.png"));
		//因为图片要默认到窗口的最下面,所以要用窗口的高减去图片的宽,默认好这个值
		y=400;
		
	}
	/**
	 * 减小x(让地面的图片向左移动)
	 * 将图片加载进内存
	 * 考虑:当x小于某个数的时候复位
	 */
	public void step() {
		x--;
		if (x < -137) {//360-497(图片的长度)
			x = 0;
		}
	}
	/**
	 * 自定义的方法(不是继承父类的方法),用图形化工具绘制这个图片
	 * @param g
	 */
	public void paint (Graphics g) {
		g.drawImage(ground,x,y, null);
	}
}
