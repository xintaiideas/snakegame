package edu.snake.listener;

import edu.snake.entity.Snake;
/**
 * �ߵļ�����
 * ��Ҫ�����ߵ��ƶ�
 * @author �ճ�
 *
 */
public interface SnakeListener {
	/**
	 * �÷���ȥ�����Ƿ��������Լ�
	 * ʳ��ϰ���
	 * @param snake
	 */
	public void snakeMoved(Snake snake);


}
