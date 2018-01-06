package edu.snake.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
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
	 * ���ƶ��ķ���
	 */
	public void move() {
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
	public void changeDirection() {
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
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// try{} catch(){}���񲢴����쳣
					e.printStackTrace();
				}//ÿ��˯һ����
			}
		}
	}
}
