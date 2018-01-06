package edu.snake.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;
import edu.snake.Global.Global;
import edu.snake.listener.SnakeListener;

/**
 * 蛇
 * 
 * @author 艺超
 * 
 */
public class Snake {
	private SnakeListener snakeListener;
	private LinkedList<Point>body = new LinkedList<Point>();//泛型
	//给蛇添加成员，蛇身就是由几个方块组成的
	public Snake()
	{
		init();
	}
	private void init(){
		int x =Global.WIDTH/2;
		int y= Global.HEIGHT/2;
		for(int i=0;i<3;i++)
		{
			body.add(new Point(x-i,y));
		}
		
	}
	/**
	 * 蛇移动的方法
	 */
	public void move() {
		System.out.println("蛇正在移动");

	}
	/**
	 * 吃食物
	 * @param food
	 */
	public void eatFood(Food food)
	{
	System.out.println("蛇正在吃食物");
	}
/**
 * 改变方向
 */
	public void changeDirection() {
		System.out.println("蛇正在改变方向");
	}
	/**
	 * 画出自己
	 */
	public void drawMe(Graphics g)//为DrawMe方法添加画笔
	{//遍历容器内容，画出蛇身
		System.out.println("蛇正在画出自己..");
		g.setColor(Color.blue);
		for (Point p:body)//foreach
		{
			//g.drawRect(p.getX()*Global.CELL_SIZE,p.getY()*Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE ,true);//true代表向上凸起
			//g.draw3DRect(p.x*Global.CELL_SIZE, p.y*Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, true);
			g.fill3DRect(p.x*Global.CELL_SIZE, p.y*Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, true);
		}
	}
	/**
	 * 是否吃到自己
	 * @return
	 */
	public boolean isEatSelf()
	{
		return false;//先默认没有吃到自己
	}
	public void addSnakeListener(SnakeListener snakeListener)
	{
		if(snakeListener!=null)
			this.snakeListener = snakeListener;
	}
	public void start() {
		new SnakeDriver().start();
		
	}
	private class SnakeDriver extends Thread{//启动一个线程
		@Override
		public void run(){
			while(true)//死循环
			{
				move();//不停的move
				snakeListener.snakeMoved(Snake.this);//每移动一次检查是否碰到食物
				//障碍物，自己，Snake.this指的是外部类的当前的对象
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// try{} catch(){}捕获并处理异常
					e.printStackTrace();
				}//每次睡一秒钟
			}
		}
	}
}
