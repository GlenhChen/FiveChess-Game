package org.my.game.frame;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JApplet;
import javax.swing.JOptionPane;
public class ButtonControl implements Runnable{
	static int maxTime,blackTime,whiteTime;
	FiveChessFrame frame;
	Attack attack;
	Man_Machine man_machine;
	boolean timeSet = false;
	int[] noneI = new int[361];
	int[] noneJ = new int[361];
	Thread thread = new Thread(this);
	Thread thread1 = new Thread(this);
	
	AudioClip snd = null;
	boolean musicOn = true;
	
	boolean format = false;
	
	@SuppressWarnings("deprecation")
	public ButtonControl(FiveChessFrame _frame,Attack _attack,Man_Machine _man_machine){
		frame = _frame;
		attack = _attack;
		man_machine = _man_machine;
		thread.start();
		thread.suspend();
		URL mus=null;
		try {
			mus = new File("Image/bgSound.wav").toURI().toURL();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		snd =JApplet.newAudioClip(mus);
		
	}
	public void Music(){
		if(musicOn == true){
			snd.loop();
			musicOn = false;
		}
		else{
			snd.stop();
			musicOn = true;
		}
	}
	
	public void regret(){
		if(attack.canPlay == true){
			if(frame.man_Machine == false){
				if(Attack.step > 0){
					int i = attack.locationI[Attack.step];
					int j = attack.locationJ[Attack.step];
					if(Attack.allChess[i][j] == 1){
						frame.message = "�ֵ��ڷ�";
						attack.isBlack = true;
					}
					if(Attack.allChess[i][j] == 2){
						frame.message = "�ֵ��׷�";
						attack.isBlack = false;
					}
					Attack.allChess[i][j] = 0;
					//frame.repaint();
					Attack.step--;
				}
				else{
					JOptionPane.showMessageDialog(frame, "δ���ӣ����ܻ��壡");
				}
			}
			else{
				if(man_machine.step > 0){
					int i1 = man_machine.locationI[man_machine.step];
					int j1 = man_machine.locationJ[man_machine.step];
					Attack.allChess[i1][j1] = 0;
					man_machine.step--;
					int i2 = man_machine.locationI[man_machine.step];
					int j2 = man_machine.locationJ[man_machine.step];
					Attack.allChess[i2][j2] = 0;
					man_machine.step--;
					frame.repaint();
				}
				else{
					JOptionPane.showMessageDialog(frame, "δ���ӣ����ܻ��壡");
				}
				
			}
			
		}
		else{
			JOptionPane.showMessageDialog(frame, "��Ϸ�ѽ��������ܻ��壡");
		}
		
	}
	@SuppressWarnings("deprecation")
	public void inti(){
		int result = JOptionPane.showConfirmDialog(frame, "ȷ����ʼһ��ģʽ��");
		if(result == 0){
			for(int i = 0;i<19;i++){
				for(int j = 0;j<19;j++){
					Attack.allChess[i][j] = 0;
				}
			}
			thread.suspend();
			timeSet = false;
			frame.repaint();
			attack.isBlack = true;
			attack.canPlay = true;
			frame.message = "�ڷ�����";
		}
	}
	@SuppressWarnings("deprecation")
	public void game_set(){
		while(format == false){
			String input = JOptionPane.showInputDialog(null,"��������Ϸʱ�䣨��λ���룩");
			try {
				maxTime = Integer.parseInt(input);
				if(maxTime <= 0){
					JOptionPane.showMessageDialog(frame, "����ʱ��Ҫ�����㣬������������Ϸʱ�䣡");				
				}
				
				else if(maxTime >= 216000){
					JOptionPane.showMessageDialog(frame, "����ʱ�����������������Ϸʱ�䣡");
				}
				else if(0 < maxTime && maxTime < 216000){
					JOptionPane.showMessageDialog(frame, "���óɹ�");
					format = true;
					timeSet = true;
					blackTime = maxTime;
					whiteTime = maxTime;
					thread.resume();
					for(int i = 0;i<19;i++){
						for(int j = 0;j<19;j++){
							Attack.allChess[i][j] = 0;
						}
					}
					frame.repaint();
					attack.isBlack = true;
					attack.canPlay = true;
					frame.message = "�ڷ�����";
				}
				else{
				}
			}catch (NumberFormatException e1) {
			 //TODO Auto-generated catch block
				if(input == null){
					format = true;
				}
				else{
					JOptionPane.showMessageDialog(frame, "��������ȷ��Ϣ��");
				}
			} 
		}
	}
	@SuppressWarnings("deprecation")
	public void surrender(){
		thread.suspend();
		int result = JOptionPane.showConfirmDialog(null, "ȷ�����䣿");
		if(result == 0){
			if(attack.isBlack == true){
				
				JOptionPane.showMessageDialog(frame, "�׷�Ӯ����Ϸ������");
			}
			else{
				JOptionPane.showMessageDialog(frame, "�ڷ�Ӯ����Ϸ����");
			}
			attack.canPlay = false;
		}
		else{
			thread.resume();
		}
		
	}
	@SuppressWarnings("deprecation")
	public void gameover(){
		thread.suspend();
		int result = JOptionPane.showConfirmDialog(frame,"ȷ���˳���");
		if(result == 0){
			System.exit(0);
		}
		else{
			thread.resume();
		}
	}
	
	public void run() {	
		// TODO Auto-generated method stub
		int i = 0;
		int j = 0;
		if(maxTime > 0){
			while(true){
				if(attack.isBlack == true && attack.canPlay == true){
					blackTime--;
					if(blackTime == 0){
						int k = 0;
						for(i = 0;i < 19;i++){
							for(j = 0;j < 19;j++){
								if(Attack.allChess[i][j] == 0){
									noneI[k]=i;
									noneJ[k]=j;
									k++;
								}
							}
						}
						k =(int)(Math.random()*100+0);
						try {
							i = noneI[k];
						} catch (ArrayIndexOutOfBoundsException e) {
							// TODO Auto-generated catch block
							System.out.println();
						}
					    try {
							j = noneJ[k];
						} catch (ArrayIndexOutOfBoundsException e) {
							// TODO Auto-generated catch block
							System.out.println();
						}
						try {
							Attack.allChess[i][j] = 1;
						} catch (ArrayIndexOutOfBoundsException e) {
							// TODO Auto-generated catch block
							System.out.println();
						}
						Attack.step++;
						attack.locationI[Attack.step] = i;
						attack.locationJ[Attack.step] = j;
						frame.message = "�ֵ��׷�";
						attack.isBlack = false;
						blackTime = maxTime;
						frame.repaint();
						try {
							attack.Test(i,j,1);
						} catch (ArrayIndexOutOfBoundsException e) {
							// TODO Auto-generated catch block
							System.out.println();
						}		
					}	
				}
				else if(attack.isBlack == false && attack.canPlay == true){
					whiteTime--;
					if(whiteTime==0){
						int k = 0;
						for(i = 0;i < 19;i++){
							for(j = 0;j < 19;j++){
								if(Attack.allChess[i][j] == 0){
									noneI[k]=i;
									noneJ[k]=j;
									k++;
								}
							}
						}
						k =(int)(Math.random()*100+0);
						try {
							i = noneI[k];
						} catch (ArrayIndexOutOfBoundsException e) {
							// TODO Auto-generated catch block
							System.out.println();
						}
					    try {
							j = noneJ[k];
						} catch (ArrayIndexOutOfBoundsException e) {
							// TODO Auto-generated catch block
							System.out.println();
						}
						try {
							Attack.allChess[i][j] = 2;
						} catch (ArrayIndexOutOfBoundsException e) {
							// TODO Auto-generated catch block
							System.out.println();
						}
						Attack.step++;
						attack.locationI[Attack.step] = i;
						attack.locationJ[Attack.step] = j;
						frame.message = "�ֵ��ڷ�";
						attack.isBlack = true;
						frame.repaint();
						whiteTime = maxTime;
						try {
							attack.Test(i,j,1);
						} catch (ArrayIndexOutOfBoundsException e) {
							// TODO Auto-generated catch block
							System.out.println();
						}	
					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
