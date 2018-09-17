package plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import Util.Constant;

public class Bullet extends GameObject{
//	  �ӵ���
			double degree;
			
			//�����ӵ��ķ���λ��
			public Bullet(){
				degree=Math.random()*Math.PI*2;
			    x=Constant.GAME_HEIGTH/2;
			     y=Constant.GAME_WIDTH/2;
			     width=10;
			     height=10;
			}
	//���ӵ��滭��������
			public void draw(Graphics g){
    	   Color c=g.getColor();
    	   //�����ӵ�����ɫ
    	   g.setColor(Color.cyan);
    	   //ʹ�õ�ǰ��ɫ������ָ�����ο����Բ��
    	   g.fillOval((int)x, (int)y, width,height);
    	  //�����ӵ�����ĽǶ�
    	   x+=speed*Math.cos(degree);
    	   y+=speed*Math.sin(degree);
    	   
    	   if(y>Constant.GAME_HEIGTH-50){
           	degree=-degree;
           }
           if(y<0){
           	degree=-degree;	
           }
           if(x>Constant.GAME_WIDTH-50){
           	degree=Math.PI-degree;
           }
           if(x<0){
           	degree=Math.PI-degree;
           }
    	   
    	   
    	   g.setColor(c);
       }
}
