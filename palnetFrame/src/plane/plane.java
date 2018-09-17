package plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import Util.GameUtil;
//飞机类
public class plane extends GameObject{
	  //设置飞机移动的四个方向
	   private  boolean left,up,right,down;  
	    
	   private boolean live=true;
	   
	
   //调用绘画的方法
    public void draw(Graphics g){
    	if(live){
    		//坐标x 坐标y  画在哪一个容器里面
    		g.drawImage(img, (int)x,(int)y, null);
    	      
        	move();
    	}
    	
    }
//设置每个方向飞机的移动速度
    public void move(){
		if(left){
			x-=speed;
		}
		if(right){
			x+=speed;
		}
		if(up){
			y-=speed;
		}
		if(down){
			y+=speed;
		}
    }
    
      public void adddirection(KeyEvent e)
      {
    		switch(e.getKeyCode()){
			case 37://左键
			left=true;
				break;
			case 38://上键
				up=true;
				break;
			case 39://右键
				right=true;
				break;
			case 40://下键
				down=true;
			    break;
			  default:
			    	break;
			    	
			    	
    		}
      }   
      public void minusdirection(KeyEvent e){
    		switch(e.getKeyCode()){
			case 37://左键
			left=false;
				break;
			case 38://上键
				up=false;
				break;
			case 39://右键
				right=false;
				break;
			case 40://下键
			down=false;
			    break;
			    default:
			    	break;
			}
      }
	public plane(String imgpath, double x, double y) {
		this.img = GameUtil.getImage(imgpath);
		this.width=img.getWidth(null);
		this.height=img.getHeight(null);
		this.x = x;
		this.y = y;
	}
    public  plane(){
    	
    }

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}
}
