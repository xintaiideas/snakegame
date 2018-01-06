package edu.snake.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.IllegalFormatCodePointException;
import java.util.LinkedList;

import edu.snake.Global.Global;
import edu.snake.listener.SnakeListener;

/**
 * ��
 * 
 * @author �ճ�
 * 
 */
public class Snake {
	private SnakeListener snakeListener;
	private LinkedList<Point>body = new LinkedList<Point>();//����
	//������ӳ�Ա����������ɼ���������ɵ�
	public static final int UP= 1;//���巽����������
	public static final int DOWN =-1;
	public static final int LEFT = 3;
	public static final int RIGHT = -3;
   private int direction;//�洢��ǰ����
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
		//this.diretion = RIGHT;//��ǰ����ĳ�Ա����
		this.oldDirection = this.newDirection  = RIGHT;//������ͬһʱ��ͬʱ��������
		
	}
	/**
	 * ���ƶ��ķ���
	 */
	public void move() {
		//ȥβ��
		body.removeLast();
		//��ͷ---���õ���ǰ��ͷ������
		int x =body.getFirst().x;
		int y = body.getLast().y;
		/*Ҫ����µ�ͷ��
		 * Ҫȷ�����򣬲���֪���µ�ͷ��
		 * �ڳ�ʼ�����������ʱ��Ĭ�Ϸ��������ҵ�
		 * ���Ƕ�������з���
		 * �����changedirection����
		 */
		if(this.oldDirection +this.newDirection!=0)//�����м��ƶ����ٴΣ�ֻ������һ���ƶ����жϷ���
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
		body.addFirst(new Point(x,y));// �ı䷽�������µ�ͷ
		System.out.println("�������ƶ�");

	}
	/**
	 * ��ʳ��
	 * @param food
	 */
	public void eatFood(Food food)
	{
	System.out.println("�����ڳ�ʳ��");
	}
/**
 * �ı䷽��
 */
	public void changeDirection(int direction) {
		//if(this.direction+direction!=0)//��������������
		//this.direction = direction;
		this.newDirection  = direction;
		System.out.println("�����ڸı䷽��");
	}
	/**
	 * �����Լ�
	 */
	public void drawMe(Graphics g)//ΪDrawMe������ӻ���
	{//�����������ݣ���������
		System.out.println("�����ڻ����Լ�..");
		g.setColor(Color.blue);
		for (Point p:body)//foreach
		{
			//g.drawRect(p.getX()*Global.CELL_SIZE,p.getY()*Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE ,true);//true��������͹��
			//g.draw3DRect(p.x*Global.CELL_SIZE, p.y*Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, true);
			g.fill3DRect(p.x*Global.CELL_SIZE, p.y*Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, true);
		}
	}
	/**
	 * �Ƿ�Ե��Լ�
	 * @return
	 */
	public boolean isEatSelf()
	{
		return false;//��Ĭ��û�гԵ��Լ�
	}
	public void addSnakeListener(SnakeListener snakeListener)
	{
		if(snakeListener!=null)
			this.snakeListener = snakeListener;
	}
	public void start() {
		new SnakeDriver().start();
		
	}
	private class SnakeDriver extends Thread{//����һ���߳�
		@Override
		public void run(){
			while(true)//��ѭ��
			{
				move();//��ͣ��move
				snakeListener.snakeMoved(Snake.this);//ÿ�ƶ�һ�μ���Ƿ�����ʳ��
				//�ϰ���Լ���Snake.thisָ�����ⲿ��ĵ�ǰ�Ķ���
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// try{} catch(){}���񲢴����쳣
					e.printStackTrace();
				}//ÿ��˯һ����
			}
		}
	}
}
