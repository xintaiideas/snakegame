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
	//private Snake snake;
	//private Food food;
	//private Ground ground;
	public void display(Snake snake,Food food ,Ground ground)
	{
		System.out.println("�����ʾ");
		if(snake!=null&&food!=null&&ground!=null)
		snake.drawMe();
		food.drawMe();
		ground.drawMe();
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO �Զ����ɵķ������
		super.paintComponent(g);
	}

}
