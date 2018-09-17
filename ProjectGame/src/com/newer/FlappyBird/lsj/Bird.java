package com.newer.FlappyBird.lsj;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * װС���ͼƬ�Լ�λ����Ϣ,�Լ�С���ƶ��ͻ��Ƶķ�������
 * @author wen
 *
 */
public class Bird {
	/**
	 * С������ĵ�
	 */
	int x;
	int y;
	/**
	 * С���ͼƬ
	 */
	BufferedImage bird;
	/**
	 * װ��3�Ų�ͬ��̬��С���ͼƬ
	 */
	BufferedImage[] birds;
	/**
	 * ������±�
	 */
	int index = 0;
	/**
	 * �������ٶ�
	 */
	int g;
	/**
	 * ����¼� /��
	 */
	double t;
	/**
	 * ��ʼ�ٶ� ����/��
	 */
	double v0;
	/**
	 * ��ǰʱ�̵��ٶ�
	 */
	double vt;
	/**
	 * �˶��ľ���
	 */
	double s;
	/**
	 * ��ķ��нǶ�
	 */
	double angle;
	/**
	 * С��Ĵ�С
	 */
	double size = 26;
	/**
	 * ��ʼ��С��,�������Ĳ���������С���λ��
	 * @param x
	 * @param y
	 * @throws IOException 
	 */
	 public Bird(int x , int y) throws IOException {
		this.x = x;
		this.y = y;
		//����һ������ͼƬ������
		birds = new BufferedImage[3];
		//ѭ����������ͼƬ
		for(int i = 0; i < 3 ; i++){
			birds[i] = ImageIO.read(getClass().getResource(i + ".png"));
		}
		//��ʼ����һ��ͼƬ
		bird = birds[0];
		//��ʼ���������
		g = 4;
		t = 0.25;
		v0 = 20;
		vt = v0;//(vt = 0;��ȫ����������)
	 } 
	 /**
	  * ����С��
	  */
	public void paint(Graphics g) {	
		//Ϊ�˻������ǵ�С��,��ת������ϵ
		Graphics2D gd = (Graphics2D) g;
		gd.rotate(angle,x,y);//����������ϵ���нǶȵ�ƫת
		
		//��(x,y)Ϊ����,������ͼƬ
		int x1 = x - bird.getWidth() / 2;
		int y1 = y - bird.getWidth() / 2;
		g.drawImage(bird, x1, y1, null);
		
		//Ȼ��������˾ͽ�����ϵ��ת����
		gd.rotate(-angle, x, y);
	}
	/**
	 * С��Ķ���(ɿ�����),���Ϸ�,������������
	 */
	public void step() {
		//(���������˶��������ߵ��������ٶ�)
		//���Ϻ����µ��˶�(�������ٶ�)
		//��ǰʱ���ٶ�
		double vt1 = vt;
		//���������ϵ��˶�,����t��֮����ٶ�
		double v = vt1 -g*t;
		//v��Ϊ��һ�μ���λ��ʱ�ĳ�ʼ�ٶ�
		vt = v;
		//���еľ���
		s = vt1*t - 0.5*g*t*t;//(s = vt -1/2g(t^2))
		//sλ�Ƶľ����������������λ�ƾ���
		y = y-(int) s;
		//����С�������
		angle = -Math.atan(s/15);//���������ٶ���60����ÿ�� *t(���涨���t=0.25) = 15����
		//�ȳ��
		index++;
		bird = birds[index/8 %3];//�κ���ȡ��3,����0,1,2;
	}
	/**
	 * ÿ���������ʱ��С���ó��ٶ�,���Ϸ�,֪����һ�ε��֮ǰ��һֱ�����������˶�
	 */
	public void fly() {
		vt = v0;
	}
	 /**
	  * ���С���Ƿ������,�컨��,�ܵ���������ײ
	  */
	public boolean hit(PipeLine p1 , PipeLine p2 ,Ground dm) {
		//�ж�С���Ƿ����컨�巢����ײ
		if (y - size/2 <=0) {
			return true;
		}
		//�ж�С������淢����ײ
		if (y - size/2 >dm.y) {
			return true;
		}
		//С���Ƿ���ܵ�������ײ
		if (hitPipeLine(p1) || hitPipeLine(p2)) {
			return true;
		}
		return false;
		
	}
	//������һ������,�ж�С���Ƿ�͹ܵ���ײ,
	/**
	 * ��Ϊ�������,
	 * 1.������ĵ�ĺ�������ڹܵ����һ���ȥ��Ĵ�С(��ײ--��Ϸ����)
	 * 2.С��ͨ���˹ܵ��м�Ŀ�϶(ûײ--��Ϸ����)
	 * 3.С��û�ӽ��ܵ�(ûײ--��Ϸ����)
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
	 * ���һ�������ķ���
	 */
	public boolean sum(PipeLine p1 ,PipeLine p2) {
		return p1.x ==x || p2.x ==x ;
	}
}
