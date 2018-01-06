package edu.snake.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

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
					rocks[y][x]=1;//上下障碍物
				if(x==0||x==Global.WIDTH-1)
				rocks[y][x] = 1;//左右障碍物
			}
		}
			
	}
	public boolean isEatBySnake(Snake snake){
		System.out.println("判断蛇是否碰到了障碍物");
		Point head = snake.getHead();//获取蛇头
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
		System.out.println("障碍物正在画出自己");
		for(int y=0;y<Global.HEIGHT;y++)
		{
			for(int x =0;x<Global.WIDTH;x++)
			if(rocks[y][x]==1){//数组下标刚好和坐标系刚好相反
			g.fill3DRect(x*Global.CELL_SIZE, y*Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, true);
			}
			
			
		}
	}/**
	 * 设置食物点的位置
	 * @ return
	 */
	public Point getPoint()
	{//  设置食物出现的范围在Global.WIDTH和Global.HEIGHT之间产生随机数
		int x,y;
		do{
		 x = new Random().nextInt(Global.WIDTH);
	 y = new Random().nextInt(Global.HEIGHT);
		}while(rocks[x][y]==1);//直到食物的位置值不是等于1的时候，结束循环
		return new Point(x,y);
	}

}
