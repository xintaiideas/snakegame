package edu.snake.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.IllegalFormatCodePointException;

import edu.snake.Global.Global;

/**
 * ʳ��
 * @author �ճ�
 *
 */
public class Food extends Point {//ʳ������ʵ����һ���㣬������ʳ��̳е���
	public void drawMe(Graphics g)
	{
		g.setColor(Color.red);
		System.out.println("ʳ�����ڻ����Լ�...");
		g.fill3DRect(x*Global.CELL_SIZE, y*Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, true);
	}
	/**
	 * ���Ƿ�����ʳ��
	 * ֻҪ�ж���ͷ�ĵ��ʳ���Ƿ��غ�
	 * @param snake
	 * @return
	 */
	public boolean isEatBySnake(Snake snake)
	{
		System.out.println("�ж����Ƿ�������ʳ��");
		Point head = snake.getHead();
		if(this.equals(head))
			return true;
		return false;
		
	}
	public void addFood(Point p)
	{
		this.x = p.x;//ʳ����ĵ�
		this.y = p.y;
	}

}
