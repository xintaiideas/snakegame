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

	private Snake snake;
	private Food food;
	private Ground ground;

	public void display(Snake snake,Food food ,Ground ground)//显示作用
	{
		
		System.out.println("面板显示");
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		
		repaint();//调用repaint()方法做画的工作
		
	}
	@Override
	protected void paintComponent(Graphics g) {//画笔画东西
		// TODO 自动生成的方法存根
		super.paintComponent(g);//把经过的轨迹清空
		if(snake!=null&&food!=null&&ground!=null)
			snake.drawMe(g);
			food.drawMe(g);
			ground.drawMe(g);
	}

}
