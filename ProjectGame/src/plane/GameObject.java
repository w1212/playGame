package plane;

import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {
	//���ڴ���ɻ���ʾ��ͼƬ����ֵ
	   Image img ;
	 //���ڴ洢��x�������ֵ
	   double x;
	 //���ڴ洢��y�������ֵ
	   double y;
	   //���������ӵ����ٶ�
	   int speed=7;
	  
	   int width,height;
	   //��һ������
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
