package edu.snake.entity;

/**
 * ��
 * 
 * @author �ճ�
 * 
 */
public class Snake {
	/**
	 * ���ƶ��ķ���
	 */
	public void move() {
		System.out.println("�������ƶ�");

	}
	/**
	 * ��ʳ��
	 * @param food
	 */
	public void eatFood(Food food)
	{
	System.out.println("�����ڳ�ʳ��");
	}
/**
 * �ı䷽��
 */
	public void changeDirection() {
		System.out.println("�����ڸı䷽��");
	}
	/**
	 * �����Լ�
	 */
	public void drawMe()
	{
		System.out.println("�����ڻ����Լ�..");
	}
	/**
	 * �Ƿ�Ե��Լ�
	 * @return
	 */
	public boolean isEatSelf()
	{
		return false;//��Ĭ��û�гԵ��Լ�
	}
	
}
