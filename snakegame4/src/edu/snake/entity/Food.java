package edu.snake.entity;
/**
 * 食物
 * @author 艺超
 *
 */
public class Food {
	public void drawMe()
	{
		System.out.println("食物正在画出自己...");
	}
	/**
	 * 蛇是否碰到食物
	 * @param snake
	 * @return
	 */
	public boolean isEatBySnake(Snake snake)
	{
		System.out.println("判断蛇是否碰到了食物");
		return false;
	}

}
