package edu.snake.listener;

import edu.snake.entity.Snake;
/**
 * 蛇的监听器
 * 主要监听蛇的移动
 * @author 艺超
 *
 */
public interface SnakeListener {
	/**
	 * 该方法去监听是否碰到了自己
	 * 食物，障碍物
	 * @param snake
	 */
	public void snakeMoved(Snake snake);


}
