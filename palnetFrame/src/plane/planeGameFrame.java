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
	//���ñ���ͼƬ
    Image bg=GameUtil.getImage("images/bg.jpg");
  //ʵ�����ɻ�ʵ����Ķ���
    plane p=new plane("images/plane.png",50,50);
  //ʵ�����ɻ���ը�Ķ���
    Explode baozhang=new Explode(50,50);
    //���ÿ�ʼʱ��ͽ���ʱ�������ֵ
    Date startTime;
    Date endTime;
	//ʵ�����ӵ�����
    ArrayList bulletList=new ArrayList();
    
    Explode bao;
    
    public void paint(Graphics g){
	   g.drawImage(bg,0,0,null);
	   p.draw(g);
	   baozhang.draw(g);
	// ѭ�������������е��ӵ�
	   for(int i=0;i<bulletList.size();i++){
		   Bullet b=(Bullet)bulletList.get(i);
		   b.draw(g);
		   
		   //���ɻ�����ײ
		   boolean peng =b.getRect().intersects(p.getRect());
		   if(peng){
			  p.setLive(false);//�ɻ�������
			
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
	   printIofo(g,"ʱ�䣺"+period+"��",20,120,260,Color.green);
	  // printIofo(g,"������100",10,100,80,Color.red);
   switch(period/10){
   case 0:
   case 1:
	   printIofo(g,"����",50,100,200,Color.pink);
        break;
   case 2:
	   printIofo(g,"С��",50,100,200,Color.pink);
   break;
   case 3:
	   printIofo(g,"����",50,100,200,Color.pink);
   break;
   case 4:
   printIofo(g,"�����",50,100,200,Color.pink);
   break;
   
   
   }
	   
	   
	   }
	   }
    /*
     * �ڴ����ϴ�ӡ��Ϣ
     */
    
    public void printIofo(Graphics g,String str,int size,int x,int y,Color color){
    	  Color c=g.getColor();
		  g.setColor(color);
		  Font f=new Font("������κ",Font.BOLD,size);
		  g.setFont(f);
		  g.drawString(str,x, y);
	      g.setColor(c);
    }

    
    public static void main(String [] args){
	new planeGameFrame().launchFrame();
}
    
    public void launchFrame(){
    	super.launchFrame();
    	//���Ӽ��̵ļ���
    	addKeyListener(new keymonitor());
    
    	//����һ���ӵ�
    	for(int i=0;i<20;i++){
    		Bullet b=new Bullet();
    		bulletList.add(b);
    	}
    	startTime=new Date();
    }
    
    
    
    
    //�����ڲ�����Է���ʹ���ⲿ�����ͨ��Ϥ
    class keymonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
		
			System.out.println("���£�"+e.getKeyCode());
			p.adddirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("�ͷţ�"+e.getKeyCode());;
			p.minusdirection(e);
		}
    	
    }
//����˫���弼��������˸
    	private Image offScreeImage=null;
    			public void update(Graphics g){
    				if(offScreeImage==null)
    					offScreeImage=this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGTH);
    					Graphics goff=offScreeImage.getGraphics();
    					paint(goff);
    					g.drawImage(offScreeImage, 0, 0, null);
    					}
}