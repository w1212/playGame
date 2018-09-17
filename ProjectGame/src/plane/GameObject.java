package plane;

import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {
	//用于储存飞机显示的图片属性值
	   Image img ;
	 //用于存储飞x轴的属性值
	   double x;
	 //用于存储飞y轴的属性值
	   double y;
	   //用于设置子弹的速度
	   int speed=7;
	  
	   int width,height;
	   //画一个矩形
	   public Rectangle getRect(){
		   return  new Rectangle((int)x,(int)y,width,height);
	
	   }

	public GameObject(Image img, double x, double y, int speed, int width, int height) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}
	public GameObject(){
		
	}
}
