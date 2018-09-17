package com.newer.FlappyBird.lsj;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * ͼƬ���ϰ��ܵ�����
 * @author wen
 *
 */
public class PipeLine {
	//���عܵ�ͼƬ�Ļ���
	BufferedImage pipeLine;
	//�ܵ��������ĵ�λ��,����С�ܵ��Ŀ�϶�����м�
	int x;
	int y;
	/**
	 * �ܵ�����Ŀ��
	 */
	int width;
	/**
	 * �ܵ�ͼƬ�ĸ߶�
	 */
	int height;
	/**
	 * ��������������Ķ���,����Ҫ�ǹܵ���λ�ò�һ��
	 */
	Random random;
	/**
	 * ����ܵ���϶�ĸ߶�(��鴥��)
	 */
	int gap = 109;
	/**
	 * 
	 * @param x1:��ʹ�ñ���ʱ,ȷ���ܵ�����������
	 * @throws IOException 
	 */
	public PipeLine(int x1) throws IOException {
		x = x1;
		//��ʼ���ܵ���ͼƬ
		pipeLine = ImageIO.read(getClass().getResource("pipeLine.png"));
		/**
		 * ��ùܵ��Ŀ�Ⱥ͸߶�
		 */
		width = pipeLine.getWidth();
		height = pipeLine.getHeight();
		//��ʼ��random����
		random = new Random();
		y = 140 +random.nextInt(140);
	}
	/**
	 * ���ƹܵ���BackGround��
	 * @param g
	 */
	public void paint(Graphics g) {
		g.drawImage(pipeLine, x-width/2, y-height/2, null);
	}
	/**
	 * �����ı�ܵ��ĺ�����
	 * �����������,����һֱ�����ƶ�
	 */
	public void step() {
		x--;
		if (x < -width) { //���°ڷŹܵ���λ��
			x = 320;
			y = 140 +random.nextInt(140);
		}
	}
}
