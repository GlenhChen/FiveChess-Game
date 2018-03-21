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
	//���û������е�ͼƬ��ʼΪ��
	Image bgImage = null;
	Image logoImage = null;
	Image voiceImage = null;
	Image regretImage = null;
	Image mapleImage = null;
	String message = "�ڷ�����";
	static int x,y;
	ButtonControl bControl;
	Attack attack;
	Man_Machine man_machine;
	boolean man_Machine = false;
		
	public FiveChessFrame(){
		
		//������Ϸ����Ĵ���
		this.setTitle("��������Ϸ");
		this.setSize(550,500);
		this.setLayout(null);
		this.setResizable(false);//���ô����С���ɱ仯
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		//��ȡ��Ļ�ֱ���
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		//���ô����ʼλ��λ����Ļ����
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
		//˫���弼����ֹ��Ļ��˸
		BufferedImage bi = new BufferedImage(550,500,BufferedImage.TYPE_INT_ARGB);
		Graphics g1  = bi.createGraphics();
		
		//���������е�ͼƬ�ڴ����л��Ƴ���
		g1.drawImage(bgImage,0,10, this);
		g1.drawImage(logoImage,365,26, this);
		
		
		g1.setColor(Color.RED);
		g1.setFont(new Font("����",30,30));
		g1.drawString("��Ϸ��Ϣ��"+message, 120, 60);
		
		//���Ʒ�ҶͼƬ
		g1.drawImage(mapleImage, 220, 210, this);
		
		//��������
		g1.setColor(Color.BLACK);
		g1.drawRect(23, 80, 364, 364);
		for(int i=0;i<19;i++){
			g1.drawLine(25, 82+20*i, 385, 82+20*i);
			g1.drawLine(25+20*i,82,25+20*i,442);
		}
		
		
		//�������ϻ���ѡ���
		for(int i=0;i<5;i++){
			g1.setColor(Color.WHITE);
			g1.fillRect(400, 210+40*i, 100, 30);
		}
		
		//����ѡ����ϵ�����
		g1.setFont(new Font("����",20,20));
		g1.setColor(Color.BLACK);
		g1.drawString("һ��ģʽ",410, 230);
		g1.drawString("ʱ��ģʽ",410, 270);
		g1.drawString("�˻�ģʽ",410, 310);
		g1.drawString("����",410, 350);
		g1.drawString("�˳���Ϸ",410, 390);
		
		//����һ����ɫ����
		g1.fillOval(10,450,30,30);
		g1.setColor(Color.BLACK);
		g1.setFont(new Font("����",20,20));
		try {
			if(bControl.timeSet == false)
				g1.drawString("�ڷ�ʱ�䣺������",45,475);
			else
				g1.drawString("�ڷ�ʱ�䣺"+ButtonControl.blackTime/3600/10+ButtonControl.blackTime/3600%10+":"+ButtonControl.blackTime%3600/60/10+ButtonControl.blackTime%3600/60%10+":"+ButtonControl.blackTime%3600%60/10+ButtonControl.blackTime%3600%60%10,45,475);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println();
		}
		this.repaint();
		
		//����һ����ɫ����
		g1.setColor(Color.white);
		g1.fillOval(250,450,30,30);
		g1.setColor(Color.BLACK);
		try {
			if(bControl.timeSet == false)
				g1.drawString("�׷�ʱ�䣺������",285,475);
			else
				g1.drawString("�׷�ʱ�䣺"+ButtonControl.whiteTime/3600/10+ButtonControl.whiteTime/3600%10+":"+ButtonControl.whiteTime%3600/60/10+ButtonControl.whiteTime%3600/60%10+":"+ButtonControl.whiteTime%3600%60/10+ButtonControl.whiteTime%3600%60%10,285,475);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println();
		}
		
		//��ע��λ
		g1.fillOval(63,140,4, 4);
		g1.fillOval(183, 140, 4, 4);
		g1.fillOval(303, 140, 4, 4);
		g1.fillOval(63, 260, 4, 4);
		g1.fillOval(183, 260, 4, 4);
		g1.fillOval(303, 260, 4, 4);
		g1.fillOval(63, 380, 4, 4);
		g1.fillOval(183, 380, 4, 4);
		g1.fillOval(303, 380, 4, 4);
		
		//�����ʱ�������ϻ�������
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
		
		//���������ͻ���İ�ť
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
			
			//�������ְ�ť
			if(x >= 23 && x <= 63 && y > 30 && y <= 70){
				bControl.Music();
			}
			
			//���ƻ��尴ť
			if(x >= 70 && x <= 110 && y >= 30 && y <=70){
				bControl.regret();
			}
				
			//���ƿ�ʼ��ť
			if(x >= 400 && x <= 500 && y > 210 && y <= 240){
				man_Machine = false;
				bControl.inti();
			}
			
			//������Ϸ���ð�ť
			if(x >= 400 && x <= 500 && y > 250 && y <= 280){
				bControl.format = false;
				bControl.game_set();
			}
			
			//�����˻���ս��ť
			if(x >= 400 && x <= 500 && y > 290 && y <= 320){
				message = "�˻���ս";
				int result = JOptionPane.showConfirmDialog(frame, "ȷ����ʼ�˻�ģʽ��");
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
			
			//�������䰴ť
			if(x >= 400 && x <= 500 && y > 330 && y <= 360){
				if(attack.canPlay == true){
					bControl.surrender();
				}
				else{
					JOptionPane.showMessageDialog(frame, "��Ϸ�ѽ�����");
				}
				
			}
			
			//�����˳���ť
			if(x >= 400 && x <= 500 && y > 370 && y <= 400){
				bControl.gameover();
			}
		}
		
	}
	
	public static void main(String args[]){
		new FiveChessFrame();
	}
	
}
		
	
	