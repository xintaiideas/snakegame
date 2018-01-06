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
		//实体对象的创建
		Snake snake = new Snake();
		Food food = new Food();
		Ground ground = new Ground();
		//视图对象的创建
		GamePanel gamePanel = new GamePanel();
		//控制器的创建---->既是蛇的监听器也是键盘的监听器
		Controller c = new Controller(snake, food, ground, gamePanel);//控制器控制snake food ground gamePanel
		snake.addSnakeListener(c);//给蛇添加监听器
		gamePanel.addKeyListener(c);//面板添加键盘事件监听器
		JFrame frame = new JFrame("贪吃蛇小游戏");
		frame.setLayout(new BorderLayout());
		frame.add(new Label("↑---方向向上" +
				""), BorderLayout.NORTH);
		frame.add(new Label("↓---方向向下"), BorderLayout.SOUTH);
		frame.add(new Label("←---方向向左"), BorderLayout.WEST);
		frame.add(new Label("→---方向向右"), BorderLayout.EAST);
		/*JButton button = new JButton("加速");
		JButton button2 = new JButton("降速");
		JButton button3 = new JButton("停止");
		JButton button4 = new JButton("开始");
	 gamePanel.add(button4);
		gamePanel.add(button3);
		gamePanel.add(button2);
	     gamePanel.add(button);*/

		frame.setSize(Global.CELL_SIZE*Global.WIDTH+200,Global.CELL_SIZE*Global.HEIGHT+200);//设置框架大小
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口退出
		frame.setLocationRelativeTo(null);//面板位于中间
		//让面板获得焦点,否则键盘操作无效
		gamePanel.setFocusable(true);
		frame.add(gamePanel);
		//启动游戏
		c.startGame();
		//显示
		frame.setVisible(true);
	}

}
