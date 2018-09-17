package com.newer.FlappyBird.lsj;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 装小鸟的图片以及位置信息,以及小鸟移动和绘制的方法的类
 * @author wen
 *
 */
public class Bird {
	/**
	 * 小鸟的中心点
	 */
	int x;
	int y;
	/**
	 * 小鸟的图片
	 */
	BufferedImage bird;
	/**
	 * 装载3张不同姿态的小鸟的图片
	 */
	BufferedImage[] birds;
	/**
	 * 数组的下标
	 */
	int index = 0;
	/**
	 * 重力加速度
	 */
	int g;
	/**
	 * 间隔事件 /秒
	 */
	double t;
	/**
	 * 初始速度 像素/秒
	 */
	double v0;
	/**
	 * 当前时刻的速度
	 */
	double vt;
	/**
	 * 运动的距离
	 */
	double s;
	/**
	 * 鸟的飞行角度
	 */
	double angle;
	/**
	 * 小鸟的大小
	 */
	double size = 26;
	/**
	 * 初始化小鸟,传进来的参数来决定小鸟的位置
	 * @param x
	 * @param y
	 * @throws IOException 
	 */
	 public Bird(int x , int y) throws IOException {
		this.x = x;
		this.y = y;
		//创建一个三张图片的数组
		birds = new BufferedImage[3];
		//循环遍历三张图片
		for(int i = 0; i < 3 ; i++){
			birds[i] = ImageIO.read(getClass().getResource(i + ".png"));
		}
		//初始化第一张图片
		bird = birds[0];
		//初始化物理参数
		g = 4;
		t = 0.25;
		v0 = 20;
		vt = v0;//(vt = 0;完全的自由落体)
	 } 
	 /**
	  * 绘制小鸟
	  */
	public void paint(Graphics g) {	
		//为了绘制仰角的小鸟,旋转了坐标系
		Graphics2D gd = (Graphics2D) g;
		gd.rotate(angle,x,y);//将整个坐标系进行角度的偏转
		
		//以(x,y)为中心,来绘制图片
		int x1 = x - bird.getWidth() / 2;
		int y1 = y - bird.getWidth() / 2;
		g.drawImage(bird, x1, y1, null);
		
		//然后绘制完了就将坐标系旋转回来
		gd.rotate(-angle, x, y);
	}
	/**
	 * 小鸟的动作(煽动翅膀),向上飞,向下自由落体
	 */
	public void step() {
		//(自由落体运动和抛物线的重力加速度)
		//向上和向下的运动(重力加速度)
		//当前时刻速度
		double vt1 = vt;
		//计算点击向上的运动,经过t秒之后的速度
		double v = vt1 -g*t;
		//v作为下一次计算位移时的初始速度
		vt = v;
		//运行的距离
		s = vt1*t - 0.5*g*t*t;//(s = vt -1/2g(t^2))
		//s位移的距离就是鸟的纵坐标的位移距离
		y = y-(int) s;
		//计算小鸟的仰角
		angle = -Math.atan(s/15);//地面运行速度是60像素每秒 *t(上面定义的t=0.25) = 15像素
		//扇翅膀
		index++;
		bird = birds[index/8 %3];//任何数取余3,都是0,1,2;
	}
	/**
	 * 每次鼠标点击的时候小鸟获得初速度,向上飞,知道下一次点击之前都一直做自由落体运动
	 */
	public void fly() {
		vt = v0;
	}
	 /**
	  * 检测小鸟是否与地面,天花板,管道发生了碰撞
	  */
	public boolean hit(PipeLine p1 , PipeLine p2 ,Ground dm) {
		//判断小鸟是否与天花板发生碰撞
		if (y - size/2 <=0) {
			return true;
		}
		//判断小鸟与地面发生碰撞
		if (y - size/2 >dm.y) {
			return true;
		}
		//小鸟是否与管道发生碰撞
		if (hitPipeLine(p1) || hitPipeLine(p2)) {
			return true;
		}
		return false;
		
	}
	//定义了一个方法,判断小鸟是否和管道相撞,
	/**
	 * 分为几种情况,
	 * 1.鸟的中心点的横坐标大于管道宽的一半减去鸟的大小(相撞--游戏结束)
	 * 2.小鸟通过了管道中间的空隙(没撞--游戏继续)
	 * 3.小鸟还没接近管道(没撞--游戏继续)
	 * @param pL
	 * @return
	 */
	public boolean hitPipeLine(PipeLine pL) {
		if(x > pL.x - pL.width / 2 - size / 2 &&
				x < pL.x + pL.width / 2 + size / 2){
			if(y > pL.y - pL.gap / 2 + size / 2 &&
					y < pL.y + pL.gap / 2 - size / 2){
				return false;
			}
			return true;
		}
		return false;
	}
	/**
	 * 添加一个计数的方法
	 */
	public boolean sum(PipeLine p1 ,PipeLine p2) {
		return p1.x ==x || p2.x ==x ;
	}
}
