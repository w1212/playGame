package plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import Util.GameUtil;
//�ɻ���
public class plane extends GameObject{
	  //���÷ɻ��ƶ����ĸ�����
	   private  boolean left,up,right,down;  
	    
	   private boolean live=true;
	   
	
   //���û滭�ķ���
    public void draw(Graphics g){
    	if(live){
    		//����x ����y  ������һ����������
    		g.drawImage(img, (int)x,(int)y, null);
    	      
        	move();
    	}
    	
    }
//����ÿ������ɻ����ƶ��ٶ�
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
			case 37://���
			left=true;
				break;
			case 38://�ϼ�
				up=true;
				break;
			case 39://�Ҽ�
				right=true;
				break;
			case 40://�¼�
				down=true;
			    break;
			  default:
			    	break;
			    	
			    	
    		}
      }   
      public void minusdirection(KeyEvent e){
    		switch(e.getKeyCode()){
			case 37://���
			left=false;
				break;
			case 38://�ϼ�
				up=false;
				break;
			case 39://�Ҽ�
				right=false;
				break;
			case 40://�¼�
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
