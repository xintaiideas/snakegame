package edu.snake.entity;

import java.awt.Color;
import java.awt.Graphics;

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
					rocks[y][x]=1;
			}
		}
			
	}
	public boolean isEatBySnake(Snake snake){
		System.out.println("�ж����Ƿ��������ϰ���");
		return false;
	}
	public void drawMe(Graphics g)
	{
		g.setColor(Color.orange);
		System.out.println("�ϰ������ڻ����Լ�");
		for(int y=0;y<Global.HEIGHT;y++)
		{
			for(int x =0;x<Global.WIDTH;x++)
			if(rocks[y][x]==1){
			g.fill3DRect(x*Global.CELL_SIZE, y*Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, true);
			}
		}
	}

}
