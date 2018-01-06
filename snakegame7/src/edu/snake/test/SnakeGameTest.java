package edu.snake.test;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.JButton;
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
		frame.setLayout(new BorderLayout());
		frame.add(new Label("��---��������" +
				""), BorderLayout.NORTH);
		frame.add(new Label("��---��������"), BorderLayout.SOUTH);
		frame.add(new Label("��---��������"), BorderLayout.WEST);
		frame.add(new Label("��---��������"), BorderLayout.EAST);
		/*JButton button = new JButton("����");
		JButton button2 = new JButton("����");
		JButton button3 = new JButton("ֹͣ");
		JButton button4 = new JButton("��ʼ");
	 gamePanel.add(button4);
		gamePanel.add(button3);
		gamePanel.add(button2);
	     gamePanel.add(button);*/

		frame.setSize(Global.CELL_SIZE*Global.WIDTH+200,Global.CELL_SIZE*Global.HEIGHT+200);//���ÿ�ܴ�С
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
