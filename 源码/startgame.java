package game;

import javax.swing.JFrame;

public class startgame
{

	public static void main(String[] args)
	{
		//���ƴ���
		JFrame frame=new JFrame("�ܳɽܵ�̰����С��Ϸ");
		//���ý����С
		frame.setBounds(300,100,900,790);
		//���ڴ�С���ɸı�
		frame.setResizable(false);
		//���ùر�
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//���
		frame.add(new gamePanel());
		
		frame.setVisible(true);
		
	}

}
