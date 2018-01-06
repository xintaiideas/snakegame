package edu.snake.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.IllegalFormatCodePointException;

import edu.snake.Global.Global;

/**
 * 食物
 * @author 艺超
 *
 */
public class Food extends Point {//食物类其实就是一个点，我们让食物继承点类
	public void drawMe(Graphics g)
	{
		g.setColor(Color.red);
		System.out.println("食物正在画出自己...");
		g.fill3DRect(x*Global.CELL_SIZE, y*Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, true);
	}
	/**
	 * 蛇是否碰到食物
	 * 只要判断蛇头的点和食物是否重合
	 * @param snake
	 * @return
	 */
	public boolean isEatBySnake(Snake snake)
	{
		System.out.println("判断蛇是否碰到了食物");
		Point head = snake.getHead();
		if(this.equals(head))
			return true;
		return false;
		
	}
	public void addFood(Point p)
	{
		this.x = p.x;//食物类的点
		this.y = p.y;
	}

}
