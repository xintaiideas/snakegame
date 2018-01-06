package edu.snake.entity;

/**
 * 蛇
 * 
 * @author 艺超
 * 
 */
public class Snake {
	/**
	 * 蛇移动的方法
	 */
	public void move() {
		System.out.println("蛇正在移动");

	}
	/**
	 * 吃食物
	 * @param food
	 */
	public void eatFood(Food food)
	{
	System.out.println("蛇正在吃食物");
	}
/**
 * 改变方向
 */
	public void changeDirection() {
		System.out.println("蛇正在改变方向");
	}
	/**
	 * 画出自己
	 */
	public void drawMe()
	{
		System.out.println("蛇正在画出自己..");
	}
	/**
	 * 是否吃到自己
	 * @return
	 */
	public boolean isEatSelf()
	{
		return false;//先默认没有吃到自己
	}
	
}
