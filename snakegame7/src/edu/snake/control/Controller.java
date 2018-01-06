package edu.snake.control;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JOptionPane;
import edu.snake.Global.Global;
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
	//���еĸı䷽��ķ���
	}
	//ʵ�ֽӿ���д���еķ���
	public void snakeMoved(Snake snake)
	{
		System.out.println("�ж����Ƿ��������壬ʳ��ϰ���");
		//�ж������ʾ����ʳ���ϰ���
		if(food.isEatBySnake(snake)){
			snake.eatFood(food);//���ʳ�ﱻ�߳Ե�ʳ�ﱻ����
			food.addFood(ground.getPoint());//�õ�һ�������λ��
			
		}
		if(ground.isEatBySnake(snake))
		{
			snake.setLife(false);
			JOptionPane.showConfirmDialog(null,"gameover");//�����Ի���gameover
			System.exit(0);
		}
		if(snake.isEatSelf())
		{
			snake.setLife(false);
			JOptionPane.showConfirmDialog(null,"gameover");
			System.exit(0);
		}
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
		food.addFood(ground.getPoint());
		
	}
/**
	 * ����ʳ����λ��
	 * @ return
	 */
	/*public Point getPoint()
	{//  ����ʳ����ֵķ�Χ��Global.WIDTH��Global.HEIGHT֮����������
		int x = new Random().nextInt(Global.WIDTH);
		int y = new Random().nextInt(Global.HEIGHT);
		return new Point(x,y);
	}�޸�ʳ����ܲ����ֵ���������������ƶ���Ground����*/
	

}
