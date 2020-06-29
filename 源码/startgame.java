package game;

import javax.swing.JFrame;

public class startgame
{

	public static void main(String[] args)
	{
		//绘制窗口
		JFrame frame=new JFrame("周成杰的贪吃蛇小游戏");
		//设置界面大小
		frame.setBounds(300,100,900,790);
		//窗口大小不可改变
		frame.setResizable(false);
		//设置关闭
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//面版
		frame.add(new gamePanel());
		
		frame.setVisible(true);
		
	}

}
