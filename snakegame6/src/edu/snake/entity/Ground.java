package edu.snake.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import edu.snake.Global.Global;

/**
 * �ϰ���
 * @author �ճ�
 *
 */
public class Ground {

	private int [][] rocks = new int [Global.WIDTH][Global.HEIGHT];
	public Ground(){
		for(int y=0;y<Global.HEIGHT;y++){
			for(int x=0;x<Global.WIDTH;x++){
				if(y==0||y==Global.HEIGHT-1)
					rocks[y][x]=1;//�����ϰ���
				if(x==0||x==Global.WIDTH-1)
				rocks[y][x] = 1;//�����ϰ���
			}
		}
			
	}
	public boolean isEatBySnake(Snake snake){
		System.out.println("�ж����Ƿ��������ϰ���");
		Point head = snake.getHead();//��ȡ��ͷ
		for(int x=0;x<Global.WIDTH;x++){
			for(int y=0;y<Global.HEIGHT;y++)
				if(rocks[x][y]==1&&head.x==x&&head.y==y)
					return true;
		}
		return false;
	}
	public void drawMe(Graphics g)
	{
		g.setColor(Color.orange);
		System.out.println("�ϰ������ڻ����Լ�");
		for(int y=0;y<Global.HEIGHT;y++)
		{
			for(int x =0;x<Global.WIDTH;x++)
			if(rocks[y][x]==1){//�����±�պú�����ϵ�պ��෴
			g.fill3DRect(x*Global.CELL_SIZE, y*Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, true);
			}
			
			
		}
	}/**
	 * ����ʳ����λ��
	 * @ return
	 */
	public Point getPoint()
	{//  ����ʳ����ֵķ�Χ��Global.WIDTH��Global.HEIGHT֮����������
		int x,y;
		do{
		 x = new Random().nextInt(Global.WIDTH);
	 y = new Random().nextInt(Global.HEIGHT);
		}while(rocks[x][y]==1);//ֱ��ʳ���λ��ֵ���ǵ���1��ʱ�򣬽���ѭ��
		return new Point(x,y);
	}

}
