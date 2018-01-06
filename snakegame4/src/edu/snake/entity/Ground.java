package edu.snake.entity;
/**
 * 障碍物
 * @author 艺超
 *
 */
public class Ground {
	public boolean isEatBySnake(Snake snake){
		System.out.println("判断蛇是否碰到了障碍物");
		return false;
	}
	public void drawMe()
	{
		System.out.println("障碍物正在画出自己");
	}

}
