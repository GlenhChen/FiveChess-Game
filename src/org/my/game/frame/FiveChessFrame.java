package org.my.game.frame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class FiveChessFrame extends JFrame{
	private static final long serialVersionUID = 2L;	
	//设置缓冲区中的图片初始为空
	Image bgImage = null;
	Image logoImage = null;
	Image voiceImage = null;
	Image regretImage = null;
	Image mapleImage = null;
	String message = "黑方先行";
	static int x,y;
	ButtonControl bControl;
	Attack attack;
	Man_Machine man_machine;
	boolean man_Machine = false;
		
	public FiveChessFrame(){
		
		//设置游戏界面的窗体
		this.setTitle("五子棋游戏");
		this.setSize(550,500);
		this.setLayout(null);
		this.setResizable(false);//设置窗体大小不可变化
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		//获取屏幕分辨率
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		//设置窗体初始位置位于屏幕中央
		this.setLocation((width-550)/2,(height-500)/2);
		this.setVisible(true);
				
        bgImage = new ImageIcon("Image/background.jpg").getImage();
		logoImage = new ImageIcon("Image/logo.jpg").getImage();
		voiceImage = new ImageIcon("Image/voice.png").getImage();
		regretImage = new ImageIcon("Image/regret.png").getImage();
		mapleImage = new ImageIcon("Image/maple leaf.jpg").getImage();
		this.addMouseListener(new Clicker());
		
		attack = new Attack(this);
		man_machine = new Man_Machine(this,attack);
		bControl = new ButtonControl(this, attack,man_machine);
		
	}
	
	public void paint(Graphics g){
		//双缓冲技术防止屏幕闪烁
		BufferedImage bi = new BufferedImage(550,500,BufferedImage.TYPE_INT_ARGB);
		Graphics g1  = bi.createGraphics();
		
		//将缓冲区中的图片在窗体中绘制出来
		g1.drawImage(bgImage,0,10, this);
		g1.drawImage(logoImage,365,26, this);
		
		
		g1.setColor(Color.RED);
		g1.setFont(new Font("黑体",30,30));
		g1.drawString("游戏信息："+message, 120, 60);
		
		//绘制枫叶图片
		g1.drawImage(mapleImage, 220, 210, this);
		
		//绘制棋盘
		g1.setColor(Color.BLACK);
		g1.drawRect(23, 80, 364, 364);
		for(int i=0;i<19;i++){
			g1.drawLine(25, 82+20*i, 385, 82+20*i);
			g1.drawLine(25+20*i,82,25+20*i,442);
		}
		
		
		//在棋盘上绘制选择框
		for(int i=0;i<5;i++){
			g1.setColor(Color.WHITE);
			g1.fillRect(400, 210+40*i, 100, 30);
		}
		
		//绘制选择框上的字体
		g1.setFont(new Font("宋体",20,20));
		g1.setColor(Color.BLACK);
		g1.drawString("一般模式",410, 230);
		g1.drawString("时间模式",410, 270);
		g1.drawString("人机模式",410, 310);
		g1.drawString("认输",410, 350);
		g1.drawString("退出游戏",410, 390);
		
		//绘制一个黑色棋子
		g1.fillOval(10,450,30,30);
		g1.setColor(Color.BLACK);
		g1.setFont(new Font("宋体",20,20));
		try {
			if(bControl.timeSet == false)
				g1.drawString("黑方时间：无限制",45,475);
			else
				g1.drawString("黑方时间："+ButtonControl.blackTime/3600/10+ButtonControl.blackTime/3600%10+":"+ButtonControl.blackTime%3600/60/10+ButtonControl.blackTime%3600/60%10+":"+ButtonControl.blackTime%3600%60/10+ButtonControl.blackTime%3600%60%10,45,475);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println();
		}
		this.repaint();
		
		//绘制一个白色棋子
		g1.setColor(Color.white);
		g1.fillOval(250,450,30,30);
		g1.setColor(Color.BLACK);
		try {
			if(bControl.timeSet == false)
				g1.drawString("白方时间：无限制",285,475);
			else
				g1.drawString("白方时间："+ButtonControl.whiteTime/3600/10+ButtonControl.whiteTime/3600%10+":"+ButtonControl.whiteTime%3600/60/10+ButtonControl.whiteTime%3600/60%10+":"+ButtonControl.whiteTime%3600%60/10+ButtonControl.whiteTime%3600%60%10,285,475);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println();
		}
		
		//标注点位
		g1.fillOval(63,140,4, 4);
		g1.fillOval(183, 140, 4, 4);
		g1.fillOval(303, 140, 4, 4);
		g1.fillOval(63, 260, 4, 4);
		g1.fillOval(183, 260, 4, 4);
		g1.fillOval(303, 260, 4, 4);
		g1.fillOval(63, 380, 4, 4);
		g1.fillOval(183, 380, 4, 4);
		g1.fillOval(303, 380, 4, 4);
		
		//鼠标点击时在棋盘上绘制棋子
				for(int i = 0;i<19;i++){
					for(int j = 0;j<19;j++){
						int tempX = 25+j*20;
						int tempY = 82+i*20;
						if(Attack.allChess[i][j] == 1){
							g1.setColor(Color.BLACK);
							g1.fillOval(tempX-5, tempY-5, 10, 10);
						}
						else if(Attack.allChess[i][j] == 2){
							g1.setColor(Color.WHITE);
							g1.fillOval(tempX-5, tempY-5, 10, 10);
						}
					}
					
				}
		
		//绘制声音和悔棋的按钮
		g1.drawImage(voiceImage, 23, 30, this);
		g1.drawImage(regretImage,70,30,this);
		
		g.drawImage(bi, 0, 0, this);
	}
	
	private class Clicker extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			x = e.getX();
			y = e.getY();
			if(man_Machine == false){
				try {
					attack.PlayGame();
					//	FiveChessFrame.this.repaint();
				} catch (NullPointerException e1) {
					// TODO Auto-generated catch block
					System.out.println();
				}
			}
			else{
				man_machine.PlayGame();
			}
		}
		
		public void mouseClicked(MouseEvent e){
			FiveChessFrame frame = null;
			x = e.getX();
			y = e.getY();
			
			//控制音乐按钮
			if(x >= 23 && x <= 63 && y > 30 && y <= 70){
				bControl.Music();
			}
			
			//控制悔棋按钮
			if(x >= 70 && x <= 110 && y >= 30 && y <=70){
				bControl.regret();
			}
				
			//控制开始按钮
			if(x >= 400 && x <= 500 && y > 210 && y <= 240){
				man_Machine = false;
				bControl.inti();
			}
			
			//控制游戏设置按钮
			if(x >= 400 && x <= 500 && y > 250 && y <= 280){
				bControl.format = false;
				bControl.game_set();
			}
			
			//控制人机对战按钮
			if(x >= 400 && x <= 500 && y > 290 && y <= 320){
				message = "人机对战";
				int result = JOptionPane.showConfirmDialog(frame, "确定开始人机模式？");
				if(result == 0){
					for(int i = 0;i<19;i++){
						for(int j = 0;j<19;j++){
							Attack.allChess[i][j] = 0;
						}
					}
					repaint();
					bControl.timeSet = false;
					man_Machine = true;	
					attack.isBlack = true;
					attack.canPlay = true;
					man_machine.step = 0;
				}
				
			}
			
			//控制认输按钮
			if(x >= 400 && x <= 500 && y > 330 && y <= 360){
				if(attack.canPlay == true){
					bControl.surrender();
				}
				else{
					JOptionPane.showMessageDialog(frame, "游戏已结束！");
				}
				
			}
			
			//控制退出按钮
			if(x >= 400 && x <= 500 && y > 370 && y <= 400){
				bControl.gameover();
			}
		}
		
	}
	
	public static void main(String args[]){
		new FiveChessFrame();
	}
	
}
		
	
	