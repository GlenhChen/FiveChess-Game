package org.my.game.frame;

import javax.swing.JOptionPane;

public class Attack{
	static int[][] allChess = new int[19][19];
	//����һ�����飬������ֵΪ0��������ǰλ�������ӣ�������ֵΪ1��������ǰλ����һ�����ӣ�������ֵΪ2��������ǰλ����һ�����ӣ�	
	int[] locationI = new int[361];//����һ������洢ÿһ�����Ӷ�Ӧ�ĺ�����
	int[] locationJ = new int[361];//����һ������洢ÿһ�����Ӷ�Ӧ��������
	int[] noneI = new int[361];
	int[] noneJ = new int[361];
	
	static int step = 0;//����һ��������������Ĳ���
	

	boolean isBlack = true;//����һ����ʶ�Ա����жϵ�ǰӦ���º��廹�ǰ��壻
	boolean canPlay = true;//����һ����ʶ�Ա�����һ������������֣�
	
	String winner = null;
	
	FiveChessFrame frame;
	ButtonControl bControl;
	public Attack(FiveChessFrame _frame){
		frame = _frame;
	}
	

	public void Test(int i,int j,int n){
		if(allChess[i][j]  == n){
			if(n == 1)
				winner = "�ڷ�ʤ";
			else
				winner = "�׷�ʤ";
			//�жϺ����Ƿ��γ�����
			try {
				if(allChess[i][j-1] == n && allChess[i][j-2] == n && allChess[i][j-3] == n && allChess[i][j-4] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "����Ϸ������");
					//������֣����ڴ˸�������Խ���쳣����
				}
				if(allChess[i][j-1] == n && allChess[i][j-2] == n && allChess[i][j-3] == n && allChess[i][j+1] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "����Ϸ������");
					//������֣����ڴ˸�������Խ���쳣����
				}
				if(allChess[i][j-1] == n && allChess[i][j-2] == n && allChess[i][j+1] == n && allChess[i][j+2] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, "�ڷ�ʤ����Ϸ������");
					//������֣����ڴ˸�������Խ���쳣����
				}
				if(allChess[i][j-1] == n && allChess[i][j+1] == n && allChess[i][j+2] == n && allChess[i][j+3] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "����Ϸ������");
					//������֣����ڴ˸�������Խ���쳣����
				}
				if(allChess[i][j+1] == n && allChess[i][j+2] == n && allChess[i][j+3] == n && allChess[i][j+4] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "����Ϸ������");
					//������֣����ڴ˸�������Խ���쳣����
				}
				
				//�ж������Ƿ��γ�����
				if(allChess[i-1][j] == n && allChess[i-2][j] == n && allChess[i-3][j] == n && allChess[i-4][j] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "����Ϸ������");
					//������֣����ڴ˸�������Խ���쳣����
				}
				if(allChess[i-1][j] == n && allChess[i-2][j] == n && allChess[i-3][j] == n && allChess[i+1][j] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "����Ϸ������");
					//������֣����ڴ˸�������Խ���쳣����
				}
				if(allChess[i-1][j] == n && allChess[i-2][j] == n && allChess[i+1][j] == n && allChess[i+2][j] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "����Ϸ������");
					//������֣����ڴ˸�������Խ���쳣����
				}
				if(allChess[i-1][j] == n && allChess[i+1][j] == n && allChess[i+2][j] == n && allChess[i+3][j] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "����Ϸ������");
					//������֣����ڴ˸�������Խ���쳣����
				}
				if(allChess[i+1][j] == n && allChess[i+2][j] == n && allChess[i+3][j] == n && allChess[i+4][j] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "����Ϸ������");
					//������֣����ڴ˸�������Խ���쳣����
				}
				
				//�жϴ����ϵ����µķ����Ƿ��γ�����
				if(allChess[i-1][j-1] == n && allChess[i-2][j-2] == n && allChess[i-3][j-3] == n && allChess[i-4][j-4] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "����Ϸ������");
					//������֣����ڴ˸�������Խ���쳣����
				}
				if(allChess[i-1][j-1] == n && allChess[i-2][j-2] == n && allChess[i-3][j-3] == n && allChess[i+1][j+1] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "����Ϸ������");
					//������֣����ڴ˸�������Խ���쳣����
				}
				if(allChess[i-1][j-1] == n && allChess[i-2][j-2] == n && allChess[i+1][j+1] == n && allChess[i+2][j+2] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "����Ϸ������");
					//������֣����ڴ˸�������Խ���쳣����
				}
				if(allChess[i-1][j-1] == n && allChess[i+1][j+1] == n && allChess[i+2][j+2] == n && allChess[i+3][j+3] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "����Ϸ������");
					//������֣����ڴ˸�������Խ���쳣����
				}
				if(allChess[i+1][j+1] == n && allChess[i+2][j+2] == n && allChess[i+3][j+3] == n && allChess[i+4][j+4] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "����Ϸ������");
					//������֣����ڴ˸�������Խ���쳣����
				}
				
				//�ж����µ����Ϸ����Ƿ��γ�����
				if(allChess[i-1][j+1] == n && allChess[i-2][j+2] == n && allChess[i-3][j+3] == n && allChess[i-4][j+4] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "����Ϸ������");
					//������֣����ڴ˸�������Խ���쳣����
				}
				if(allChess[i-1][j+1] == n && allChess[i-2][j+2] == n && allChess[i-3][j+3] == n && allChess[i+1][j-1] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "����Ϸ������");
					//������֣����ڴ˸�������Խ���쳣����
				}
				if(allChess[i-1][j+1] == n && allChess[i-2][j+2] == n && allChess[i+1][j-1] == n && allChess[i+2][j-2] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "����Ϸ������");
					//������֣����ڴ˸�������Խ���쳣����
				}
				if(allChess[i-1][j+1] == n && allChess[i+1][j-1] == n && allChess[i+2][j-2] == n && allChess[i+3][j-3] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "����Ϸ������");
					//������֣����ڴ˸�������Խ���쳣����
				}
				if(allChess[i+1][j-1] == n && allChess[i+2][j-2] == n && allChess[i+3][j-3] == n && allChess[i+4][j-4] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "����Ϸ������");
					//������֣����ڴ˸�������Խ���쳣����
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				System.out.println();
			}	
		}
	}
	
	
	public void PlayGame(){
		int i = 0;
		int j = 0;
		if(FiveChessFrame.x >= 23 && FiveChessFrame.x <= 387 && FiveChessFrame.y >= 80 && FiveChessFrame.y <= 444){
			if(canPlay == true){
			
				int a = (FiveChessFrame.x-25)%20;
				int b = (FiveChessFrame.y-82)%20;
				if(a<=10){
						j = (FiveChessFrame.x-25)/20;
				}
				else{
					j = (FiveChessFrame.x-25)/20+1;
				}
				if(b<=10){
					i = (FiveChessFrame.y-82)/20;
				}
				else{
					i = (FiveChessFrame.y-82)/20+1;
				}
				if(allChess[i][j] == 0){
					if(isBlack == true){
						allChess[i][j] = 1;
						step++;
						locationI[step] = i;
						locationJ[step] = j;
						frame.message = "�ֵ��׷�";
						isBlack = false;
						frame.repaint();
						ButtonControl.blackTime = ButtonControl.maxTime;
						Test(i,j,1);
					}
					else{
						frame.message = "�ֵ��ڷ�";
						allChess[i][j] = 2;
						step++;
						locationI[step] = i;
						locationJ[step] = j;
						isBlack = true;
						frame.repaint();
						ButtonControl.whiteTime = ButtonControl.maxTime;
						Test(i,j,2);
					}
				}
				else{
					JOptionPane.showMessageDialog(frame, "�˴������ӣ����������ӣ�");
				}
			}
					
		}
	}
}
