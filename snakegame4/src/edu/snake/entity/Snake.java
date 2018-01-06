package edu.snake.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.IllegalFormatCodePointException;
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
	public static final int UP= 1;//定义方向上下左右
	public static final int DOWN =-1;
	public static final int LEFT = 3;
	public static final int RIGHT = -3;
   private int direction;//存储当前方向
   private int oldDirection,newDirection;
	
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
		//this.diretion = RIGHT;//当前对象的成员变量
		this.oldDirection = this.newDirection  = RIGHT;//避免了同一时间同时按下两次
		
	}
	/**
	 * 蛇移动的方法
	 */
	public void move() {
		//去尾巴
		body.removeLast();
		//加头---》得到当前的头部坐标
		int x =body.getFirst().x;
		int y = body.getLast().y;
		/*要获得新的头部
		 * 要确定方向，才能知道新的头部
		 * 在初始化构造蛇身的时候默认方向是往右的
		 * 我们定义出所有方向
		 * 并完成changedirection方法
		 */
		if(this.oldDirection +this.newDirection!=0)//无论中间移动多少次，只有在下一次移动才判断方向
			this.oldDirection = this.newDirection;
		switch (oldDirection/*direction*/) {
		case UP:
			y--;
			if(y<0) y=Global.HEIGHT-1;
			break;
		case DOWN:
			y++;
			if(y>=Global.HEIGHT) y=0;
			break;
		case LEFT:
			x--;
			if(x<0) x=Global.WIDTH-1;
			break;
		case RIGHT:
			x++;
			if(x>=Global.WIDTH) x=0;
			break;
	
		}
		body.addFirst(new Point(x,y));// 改变方向后添加新的头
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
	public void changeDirection(int direction) {
		//if(this.direction+direction!=0)//解决反方向的问题
		//this.direction = direction;
		this.newDirection  = direction;
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
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// try{} catch(){}捕获并处理异常
					e.printStackTrace();
				}//每次睡一秒钟
			}
		}
	}
}
