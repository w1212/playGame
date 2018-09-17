package com.newer.FlappyBird.lsj;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * �·������ƶ��ĵ�����
 * @author wen
 *
 */
public class Ground {
	/**
	 * �����ͼƬ
	 */
	BufferedImage ground;
	/**
	 * ͼƬ�ĺ�����
	 */
	int x;
	/**
	 * ͼƬ��������
	 */
	int y;
	
	public Ground() throws IOException {
		//����ͼƬ
		ground = ImageIO.read(getClass().getResource("ground.png"));
		//��ΪͼƬҪĬ�ϵ����ڵ�������,����Ҫ�ô��ڵĸ߼�ȥͼƬ�Ŀ�,Ĭ�Ϻ����ֵ
		y=400;
		
	}
	/**
	 * ��Сx(�õ����ͼƬ�����ƶ�)
	 * ��ͼƬ���ؽ��ڴ�
	 * ����:��xС��ĳ������ʱ��λ
	 */
	public void step() {
		x--;
		if (x < -137) {//360-497(ͼƬ�ĳ���)
			x = 0;
		}
	}
	/**
	 * �Զ���ķ���(���Ǽ̳и���ķ���),��ͼ�λ����߻������ͼƬ
	 * @param g
	 */
	public void paint (Graphics g) {
		g.drawImage(ground,x,y, null);
	}
}
