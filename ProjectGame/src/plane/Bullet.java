package plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import Util.Constant;

public class Bullet extends GameObject{
//	  子弹类
			double degree;
			
			//设置子弹的发射位置
			public Bullet(){
				degree=Math.random()*Math.PI*2;
			    x=Constant.GAME_HEIGTH/2;
			     y=Constant.GAME_WIDTH/2;
			     width=10;
			     height=10;
			}
	//将子弹绘画到容器中
			public void draw(Graphics g){
    	   Color c=g.getColor();
    	   //设置子弹的颜色
    	   g.setColor(Color.cyan);
    	   //使用当前颜色填充外接指定矩形框的椭圆。
    	   g.fillOval((int)x, (int)y, width,height);
    	  //设置子弹发射的角度
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
