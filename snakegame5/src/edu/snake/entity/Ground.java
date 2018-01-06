package edu.snake.entity;

import java.awt.Color;
import java.awt.Graphics;

import edu.snake.Global.Global;

/**
 * 障碍物
 * @author 艺超
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
		System.out.println("判断蛇是否碰到了障碍物");
		return false;
	}
	public void drawMe(Graphics g)
	{
		g.setColor(Color.orange);
		System.out.println("障碍物正在画出自己");
		for(int y=0;y<Global.HEIGHT;y++)
		{
			for(int x =0;x<Global.WIDTH;x++)
			if(rocks[y][x]==1){
			g.fill3DRect(x*Global.CELL_SIZE, y*Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, true);
			}
		}
	}

}
