package edu.snake.test;

import javax.swing.JFrame;
import edu.snake.Global.Global;
import edu.snake.control.Controller;
import edu.snake.entity.Food;
import edu.snake.entity.Ground;
import edu.snake.entity.Snake;
import edu.snake.view.GamePanel;

public class SnakeGameTest {
	public static void main(String[] args)
	{
		//ʵ�����Ĵ���
		Snake snake = new Snake();
		Food food = new Food();
		Ground ground = new Ground();
		//��ͼ����Ĵ���
		GamePanel gamePanel = new GamePanel();
		//�������Ĵ���---->�����ߵļ�����Ҳ�Ǽ��̵ļ�����
		Controller c = new Controller(snake, food, ground, gamePanel);//����������snake food ground gamePanel
		snake.addSnakeListener(c);//������Ӽ�����
		gamePanel.addKeyListener(c);//�����Ӽ����¼�������
		JFrame frame = new JFrame("̰����С��Ϸ");
		frame.setSize(Global.CELL_SIZE*Global.WIDTH+100,Global.CELL_SIZE*Global.HEIGHT+100);//���ÿ�ܴ�С
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ����˳�
		frame.setLocationRelativeTo(null);//���λ���м�
		//������ý���,������̲�����Ч
		gamePanel.setFocusable(true);
		frame.add(gamePanel);
		//������Ϸ
		c.startGame();
		//��ʾ
		frame.setVisible(true);
	}

}
