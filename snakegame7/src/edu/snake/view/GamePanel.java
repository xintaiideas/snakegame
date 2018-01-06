package edu.snake.view;

import java.awt.Graphics;

import javax.swing.JPanel;

import edu.snake.entity.Food;
import edu.snake.entity.Ground;
import edu.snake.entity.Snake;
/**
 * ��������
 * @author �ճ�
 *
 */
public class GamePanel extends JPanel{

	private Snake snake;
	private Food food;
	private Ground ground;

	public void display(Snake snake,Food food ,Ground ground)//��ʾ����
	{
		
		System.out.println("�����ʾ");
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		
		repaint();//����repaint()���������Ĺ���
		
	}
	@Override
	protected void paintComponent(Graphics g) {//���ʻ�����
		// TODO �Զ����ɵķ������
		super.paintComponent(g);//�Ѿ����Ĺ켣���
		if(snake!=null&&food!=null&&ground!=null)
			snake.drawMe(g);
			food.drawMe(g);
			ground.drawMe(g);
	}

}
