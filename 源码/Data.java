package game;

import java.net.URL;

import javax.swing.ImageIcon;

public class Data
{
	//图片地址url  imageicon 图片
	public static URL headurl=Data.class.getResource("Header3.png");
	public static ImageIcon header=new ImageIcon(headurl);
	
	//头
	public static URL upUrl=Data.class.getResource("up.png");
	public static URL downUrl=Data.class.getResource("down.png");
	public static URL leftUrl=Data.class.getResource("left.png");
	public static URL rightUrl=Data.class.getResource("right.png");
	public static ImageIcon up=new ImageIcon(upUrl);
	public static ImageIcon down=new ImageIcon(downUrl);
	public static ImageIcon left=new ImageIcon(leftUrl);
	public static ImageIcon right=new ImageIcon(rightUrl);
	
	//身体
	public static URL bodyUrl=Data.class.getResource("body.png");
	public static ImageIcon body=new ImageIcon(bodyUrl);
	
	//食物
	public static URL foodUrl=Data.class.getResource("food.png");
	public static ImageIcon food=new ImageIcon(foodUrl);
	
}
