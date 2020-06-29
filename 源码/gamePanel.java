package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel; 
import javax.swing.Timer;

public class gamePanel extends JPanel implements KeyListener,ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2541066079921732953L;
	int length=3;
	int []snakeX=new int[600];
	int []snakeY=new int[500];
	String fx; //R L U D:��������
	boolean isStart=false;
	boolean isFail=false;
	
	Timer timer=new Timer(100,this);
	
	//ʳ��
	int foodx;
	int foody;
	
	//����ϵͳ
	int score;
	
	Random random=new Random();
	
	//������
	public gamePanel()
	{
		init();
		//ʵ�ּ��̼���
		this.addKeyListener(this);
		this.setFocusable(true);
		timer.start();
	}
	
	public void init()
	{
		//��ʼ״̬
		length=3;
		snakeX[0]=100;snakeY[0]=165;
		snakeX[1]=75;snakeY[1]=165;
		snakeX[2]=50;snakeY[2]=165;
		fx="R";
		
		foodx=25+25*random.nextInt(34);
		foody=140+25*random.nextInt(24);
//		while (Arrays.binarySearch(snakeX, foodx)<0)
//		{
//			foodx=25+25*random.nextInt(34);
//			foody=140+25*random.nextInt(24);
//		}
		
		score=0;
	}
	
	//���壺  ���в���
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);//����
		this.setBackground(Color.white);
		
		
		g.fillRect(25, 140, 850,600);
		
		//�ߵĻ���
		
		for (int i = 1; i < length; i++)
		{
			Data.body.paintIcon(this, g, snakeX[i], snakeY[i]);
		}
		if(fx.equals("R"))
			Data.right.paintIcon(this, g, snakeX[0], snakeY[0]);
		else if(fx.equals("L"))
			Data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
		else if(fx.equals("U"))
			Data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
		else
			Data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
		
		Data.header.paintIcon(this, g, 25, 11);
		
		//����
		g.setColor(Color.white);
		g.setFont(new Font("΢���ź�",Font.BOLD,18));
		g.drawString("����: "+length, 800, 170);
		g.drawString("����: "+score, 800, 190);
		g.drawString("�ܳɽ�", 800, 700);
		
		//ʳ��
		Data.food.paintIcon(this, g, foodx, foody);
		
		//��Ϸ��ʾ���Ƿ�ʼ
		if (isStart==false)
		{
			g.setColor(Color.white);
			g.setFont(new Font("΢���ź�",Font.BOLD,40));
			g.drawString("���¿ո�ʼ��Ϸ", 300, 365);
		}
		if (isFail)
		{
			g.setColor(Color.RED);
			g.setFont(new Font("΢���ź�",Font.BOLD,40));
			g.drawString("��Ϸʧ�ܣ����¿ո����¿�ʼ", 200, 365);
		}
	}

	//������Ӧ
	@Override
	//����
	public void keyPressed(KeyEvent e)
	{
		//��ȡ���̵İ���
		int keyCode=e.getKeyCode();
		if(keyCode==KeyEvent.VK_SPACE)
		{
			if (isFail)
			{
				isFail=false;
				//���³�ʼ��
				init();
			}
			else 
			{
				isStart=!isStart;
			}
			repaint();
		}
		
		if(keyCode==KeyEvent.VK_LEFT&&fx!="R")
			fx="L";
		else if(keyCode==KeyEvent.VK_RIGHT&&fx!="L")
			fx="R";
		else if(keyCode==KeyEvent.VK_UP&&fx!="D")
			fx="U";
		else if(keyCode==KeyEvent.VK_DOWN&&fx!="U")
			fx="D";
		
		
	}
	//��ʱ����
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (isStart && isFail==false )
		{
			for (int i = length-1; i >0; i--)//����λ��
			{
				snakeX[i]=snakeX[i-1];
				snakeY[i]=snakeY[i-1];
			}

			
			//���Ʒ�����ͷ���ƶ�
			if(fx.equals("R"))
			{
				snakeX[0]=snakeX[0]+25;
				if(snakeX[0]>850)
				{
					snakeX[0]=25;
				}
			}
			else if (fx.equals("L")) 
			{
				snakeX[0]=snakeX[0]-25;
				if(snakeX[0]<25)
				{
					snakeX[0]=850;
				}
			}
			else if (fx.equals("U")) 
			{
				snakeY[0]=snakeY[0]-25;
				if(snakeY[0]<140)
				{
					snakeY[0]=715;
				}
			}
			else if (fx.equals("D")) 
			{
				snakeY[0]=snakeY[0]+25;
				if(snakeY[0]>715)
				{
					snakeY[0]=140;
				}
			}
			
			if(snakeX[0]==foodx&&snakeY[0]==foody) //����Ե�ʳ��
			{
				length++;
				snakeX[length-1]=snakeX[length-2];
				snakeY[length-1]=snakeY[length-2];
				
				score+=10;
				
				foodx=25+25*random.nextInt(34);
				foody=140+25*random.nextInt(24);
			}
			
			for (int i = 1; i < length; i++)
			{
				if(snakeX[0]==snakeX[i]&&snakeY[0]==snakeY[i])
				{
					isFail=true;
				}
				
			}
			
			repaint();//ˢ��
		}
		timer.start();
	}
	
	
	
	@Override
	//����
	public void keyReleased(KeyEvent e)
	{
	}
	@Override
	//���¡�����
	public void keyTyped(KeyEvent e)
	{
	}
	
	

}
