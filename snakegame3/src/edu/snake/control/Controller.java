package edu.snake.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import edu.snake.entity.Food;
import edu.snake.entity.Ground;
import edu.snake.entity.Snake;
import edu.snake.listener.SnakeListener;
import edu.snake.view.GamePanel;
/**
 * ��������
 * @author �ճ�
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
	//�̳�����д���еķ���
	@Override
	public void keyPressed(KeyEvent e) {
	snake.changeDirection();//���еĸı䷽��ķ���
	}
	//ʵ�ֽӿ���д���еķ���
	@Override
	public void snakeMoved(Snake snake)
	{
		System.out.println("�ж����Ƿ��������壬ʳ��ϰ���");
		//�ж������ʾ����ʳ���ϰ���
		gamePanel.display(snake, food, ground);//ÿ���ƶ��ж��Ƿ�������
		//û����ʾ�����ߵĶ���״̬
		/*�ж����Ƿ��������壬ʳ��ϰ���
        �����ʾ
        �����ڻ����Լ�..
       ʳ�����ڻ����Լ�...
       �ϰ������ڻ����Լ�
       �������ƶ�*/
	}
	/**
	 * ��Ϸ��ʼ
	 */
	public void startGame()
	{
		snake.start();
	}
	

}
