package edu.snake.view;

import java.awt.Graphics;

import javax.swing.JPanel;

import edu.snake.entity.Food;
import edu.snake.entity.Ground;
import edu.snake.entity.Snake;
/**
 * 操作界面
 * @author 艺超
 *
 */
public class GamePanel extends JPanel{
	//private Snake snake;
	//private Food food;
	//private Ground ground;
	public void display(Snake snake,Food food ,Ground ground)
	{
		System.out.println("面板显示");
		if(snake!=null&&food!=null&&ground!=null)
		snake.drawMe();
		food.drawMe();
		ground.drawMe();
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO 自动生成的方法存根
		super.paintComponent(g);
	}

}
