package edu.snake.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import edu.snake.entity.Food;
import edu.snake.entity.Ground;
import edu.snake.entity.Snake;
import edu.snake.listener.SnakeListener;
import edu.snake.view.GamePanel;
/**
 * 控制器类
 * @author 艺超
 *
 */
public class Controller extends KeyAdapter implements SnakeListener{
	private Snake snake;
	private Food food;
	private Ground ground;
	private GamePanel gamePanel;
	public Controller(Snake snake, Food food, Ground ground, GamePanel gamePanel) {
		super();
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		this.gamePanel = gamePanel;
	}
	//继承类重写其中的方法
	@Override
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		switch (keycode) {
		case KeyEvent.VK_UP:
			snake.changeDirection(snake.UP);
			break;
		case KeyEvent.VK_DOWN:
			snake.changeDirection(snake.DOWN);
			break;
		case KeyEvent.VK_LEFT:
			snake.changeDirection(snake.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			snake.changeDirection(snake.RIGHT);
			break;
		}
	//蛇中的改变方向的方法
	}
	//实现接口重写其中的方法
	@Override
	public void snakeMoved(Snake snake)
	{
		System.out.println("判断蛇是否碰到身体，食物，障碍物");
		//判断完后显示身体食物障碍物
		gamePanel.display(snake, food, ground);//每次移动判断是否碰到，
		//没有显示出来蛇的动作状态
		/*判断蛇是否碰到身体，食物，障碍物
        面板显示
        蛇正在画出自己..
       食物正在画出自己...
       障碍物正在画出自己
       蛇正在移动*/
	}
	/**
	 * 游戏开始
	 */
	public void startGame()
	{
		snake.start();
	}
	

}
