package plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.Date;

import Util.Constant;
import Util.GameUtil;
import Util.myFrame;
import images.Explode;

public class planeGameFrame extends myFrame{
	//设置背景图片
    Image bg=GameUtil.getImage("images/bg.jpg");
  //实例化飞机实体类的对象
    plane p=new plane("images/plane.png",50,50);
  //实例化飞机爆炸的对象
    Explode baozhang=new Explode(50,50);
    //设置开始时间和结束时间的属性值
    Date startTime;
    Date endTime;
	//实例化子弹集合
    ArrayList bulletList=new ArrayList();
    
    Explode bao;
    
    public void paint(Graphics g){
	   g.drawImage(bg,0,0,null);
	   p.draw(g);
	   baozhang.draw(g);
	// 循环画出集合所有的子弹
	   for(int i=0;i<bulletList.size();i++){
		   Bullet b=(Bullet)bulletList.get(i);
		   b.draw(g);
		   
		   //检测飞机的碰撞
		   boolean peng =b.getRect().intersects(p.getRect());
		   if(peng){
			  p.setLive(false);//飞机死掉！
			
			 if(bao==null){
				 endTime = new Date();
			 bao=new Explode(p.x,p.y);
			 }
			 bao.draw(g);
			 break;
		   }
	   }
	   if(!p.isLive()){
		  
	  
	   int period =(int)(endTime.getTime()-startTime.getTime())/1000;
	   printIofo(g,"时间："+period+"秒",20,120,260,Color.green);
	  // printIofo(g,"分数：100",10,100,80,Color.red);
   switch(period/10){
   case 0:
   case 1:
	   printIofo(g,"菜鸟",50,100,200,Color.pink);
        break;
   case 2:
	   printIofo(g,"小鸟",50,100,200,Color.pink);
   break;
   case 3:
	   printIofo(g,"大鸟",50,100,200,Color.pink);
   break;
   case 4:
   printIofo(g,"鸟大王",50,100,200,Color.pink);
   break;
   
   
   }
	   
	   
	   }
	   }
    /*
     * 在窗口上打印信息
     */
    
    public void printIofo(Graphics g,String str,int size,int x,int y,Color color){
    	  Color c=g.getColor();
		  g.setColor(color);
		  Font f=new Font("华文新魏",Font.BOLD,size);
		  g.setFont(f);
		  g.drawString(str,x, y);
	      g.setColor(c);
    }

    
    public static void main(String [] args){
	new planeGameFrame().launchFrame();
}
    
    public void launchFrame(){
    	super.launchFrame();
    	//增加键盘的监听
    	addKeyListener(new keymonitor());
    
    	//生成一堆子弹
    	for(int i=0;i<20;i++){
    		Bullet b=new Bullet();
    		bulletList.add(b);
    	}
    	startTime=new Date();
    }
    
    
    
    
    //定义内部类可以方便使用外部类的普通熟悉
    class keymonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
		
			System.out.println("按下："+e.getKeyCode());
			p.adddirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("释放："+e.getKeyCode());;
			p.minusdirection(e);
		}
    	
    }
//利用双反冲技术消除闪烁
    	private Image offScreeImage=null;
    			public void update(Graphics g){
    				if(offScreeImage==null)
    					offScreeImage=this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGTH);
    					Graphics goff=offScreeImage.getGraphics();
    					paint(goff);
    					g.drawImage(offScreeImage, 0, 0, null);
    					}
}