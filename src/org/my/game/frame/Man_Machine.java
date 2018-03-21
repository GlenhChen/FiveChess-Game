package org.my.game.frame;
import javax.swing.JOptionPane;
public class Man_Machine {
	Attack attack;
	FiveChessFrame frame;
	boolean over = false;
	int[] noneI = new int[361];
	int[] noneJ = new int[361];
	int[] locationI = new int[361];
	int[] locationJ = new int[361];
	int step = 0;
	
	Man_Machine(FiveChessFrame _frame,Attack _attack){
		attack = _attack;
		frame = _frame;
	}
	//��������+1���գ��������������:���Լ���Է���
	void Condition1(int a1,int b1,int a2,int b2,int a3,int b3,int a4,int b4,int a5,int b5,int a6,int b6,int n){ 
		try {
			if (Attack.allChess[a2][b2] == n && Attack.allChess[a3][b3] == n && Attack.allChess[a4][b4] == n && Attack.allChess[a5][b5] == n) {
				try {
					if (Attack.allChess[a1][b1] == 0) {
						Attack.allChess[a1][b1] = 2;
						step++;	
						;
						locationI[step] = a1;
						locationJ[step] = b1;
						
						frame.repaint();
						attack.isBlack = true;
						attack.Test(a1, b1, n);
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					// TODO Auto-generated catch block
					
					System.out.println();
					
				}
				try {
					if (Attack.allChess[a6][b6] == 0 && attack.canPlay == true && attack.isBlack == false) {
						Attack.allChess[a6][b6] = 2;
						step++;	
						;
						locationI[step] = a6;
						locationJ[step] = b6;
						frame.repaint();
						attack.isBlack = true;
						attack.Test(a6, b6, n);
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					// TODO Auto-generated catch block
					
					System.out.println();
					
				}

			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.out.println();
		}
			
	}
	
	//�����м��һ��λ��
	void Condition2(int a1,int b1,int a2,int b2,int a3,int b3,int a4,int b4,int n){
		try {
			if(Attack.allChess[a1][b1] == n && Attack.allChess[a2][b2] == n && Attack.allChess[a3][b3] == 0 && Attack.allChess[a4][b4] == n){
				Attack.allChess[a3][b3] = 2;
				step++;
				;
				locationI[step] = a3;
				locationJ[step] = b3;
				frame.repaint();
				attack.isBlack = true;
				attack.Test(a3, b3, n);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.out.println();
		}
		if (attack.canPlay == true && attack.isBlack == false) {
			try {
				if (Attack.allChess[a1][b1] == n && Attack.allChess[a2][b2] == 0 && Attack.allChess[a3][b3] == n && Attack.allChess[a4][b4] == n) {
					Attack.allChess[a2][b2] = 2;
					step++;
					;
					locationI[step] = a2;
					locationJ[step] = b2;
					frame.repaint();
					attack.isBlack = true;
					attack.Test(a3, b3, n);
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				System.out.println();
			}
		}
			
		
	}
	
	
	//�����������߿յ�������������ȣ����Լ���Է���
	void Condition3(int a1,int b1,int a2,int b2,int a3,int b3,int a4,int b4,int a5,int b5,int n){
		try {
			if (Attack.allChess[a1][b1] == 0 && Attack.allChess[a2][b2] == n && Attack.allChess[a3][b3] == n && Attack.allChess[a4][b4] == n && Attack.allChess[a5][b5] == 0) {
				Attack.allChess[a1][b1] = 2;
				step++;
				;
				locationI[step] = a1;
				locationJ[step] = b1;
				frame.repaint();
				attack.isBlack = true;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.out.println();
		}
	}
	
	//��������һ�߿գ����������������ȣ�
	void Condition4(int a1,int b1,int a2,int b2,int a3,int b3,int a4,int b4,int a5,int b5,int a6,int b6){
		try {
			if(Attack.allChess[a1][b1] == 1 && Attack.allChess[a2][b2] == 2 && Attack.allChess[a3][b3] == 2 && Attack.allChess[a4][b4] == 2 && Attack.allChess[a4][b4] == 0 && Attack.allChess[a4][b4] == 0) {
				Attack.allChess[a4][b4] = 2;
				step++;
				;
				locationI[step] = a4;
				locationJ[step] = b4;
				frame.repaint();
				attack.isBlack = true;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.out.println();
		}
		try {
			if(Attack.allChess[a1][b1] == 0 && Attack.allChess[a2][b2] == 0 && Attack.allChess[a3][b3] == 2 && Attack.allChess[a4][b4] == 2 && Attack.allChess[a4][b4] == 2 && Attack.allChess[a4][b4] == 1){
				Attack.allChess[a2][b2] = 2;
				step++;
				;
				locationI[step] = a2;
				locationJ[step] = b2;
				frame.repaint();
				attack.isBlack = true;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.out.println();
		}
	}
	
	
	//������������һ�߿�(��������)��
	void Condition5(int a1,int b1,int a2,int b2,int a3,int b3,int a4,int b4,int a5,int b5){
		try {
			if(Attack.allChess[a1][b1] == 0 && Attack.allChess[a2][b2] == 0 && Attack.allChess[a3][b3] == 0 && Attack.allChess[a4][b4] == 2 && Attack.allChess[a5][b5] == 2){
				Attack.allChess[a3][b3] = 2;
				step++;
				;
				locationI[step] = a3;
				locationJ[step] = b3;
				frame.repaint();
				attack.isBlack = true;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.out.println();
		}
		try {
			if(Attack.allChess[a1][b1] == 0 && Attack.allChess[a2][b2] == 0 && Attack.allChess[a3][b3] == 2 && Attack.allChess[a4][b4] == 2 && Attack.allChess[a5][b5] == 0){
				Attack.allChess[a2][b2] = 2;
				step++;
				;
				locationI[step] = a2;
				locationJ[step] = b2;
				frame.repaint();
				attack.isBlack = true;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.out.println();
		}
		try {
			if(Attack.allChess[a1][b1] == 0 && Attack.allChess[a2][b2] == 2 && Attack.allChess[a3][b3] == 2 && Attack.allChess[a4][b4] == 0 && Attack.allChess[a5][b5] == 0){
				Attack.allChess[a1][b1] = 2;
				step++;
				;
				locationI[step] = a1;
				locationJ[step] = b1;
				frame.repaint();
				attack.isBlack = true;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.out.println();
		}
		try {
			if(Attack.allChess[a1][b1] == 2 && Attack.allChess[a2][b2] == 2 && Attack.allChess[a3][b3] == 0 && Attack.allChess[a4][b4] == 0 && Attack.allChess[a5][b5] == 0){
				Attack.allChess[a3][b3] = 2;
				step++;
				;
				locationI[step] = a3;
				locationJ[step] = b3;
				frame.repaint();
				attack.isBlack = true;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.out.println();
		}
	}
	
	//һ���ӣ����ܿյ�λ������£��������ȣ���
	void Condition6(int a,int b){
		int t = 1;
		boolean flag = true;
		while(flag == true) {
			for (int m = a - 1 * t; m <= a + 1 * t && flag == true; m++) {
				for (int n = b - 1 * t; n <= b + 1 * t && flag == true; n++) {
					try {
						if (Attack.allChess[m][n] == 0) {
							Attack.allChess[m][n] = 2;
							step++;
							;
							locationI[step] = m;
							locationJ[step] = n;
							frame.repaint();
							attack.isBlack = true;
							flag = false;
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						// TODO Auto-generated catch block
						System.out.println();
					}

				}
			}
			if(flag == true){
				t++;
			}
		}
		if(flag == true){
			int k = 0;
			for(a = 0;a < 19;a++){
				for(b = 0;b < 19;b++){
					if(Attack.allChess[a][b] == 0){
						noneI[k]=a;
						noneJ[k]=b;
						k++;
					}
				}
			}
			k =(int)(Math.random()*100+0);
			try {
				a = noneI[k];
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				System.out.println();
			}
		    try {
				b = noneJ[k];
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				System.out.println();
			}
			try {
				Attack.allChess[a][b] = 2;
				step++;
				;
				locationI[step] = a;
				locationJ[step] = b;
				frame.repaint();
				attack.isBlack = true;
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				System.out.println();
			}
			
		}
	}
	
	
	void PlayGame(){
		int i = 0;
		int j = 0;
		
		if(FiveChessFrame.x >= 23 && FiveChessFrame.x <= 387 && FiveChessFrame.y >= 80 && FiveChessFrame.y <= 444){
			if(attack.canPlay == true){
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
				if(Attack.allChess[i][j] == 0){
					if(attack.isBlack == true){
						Attack.allChess[i][j] = 1;
						step++;
						frame.repaint();
						attack.Test(i,j,1);
												
						locationI[step] = i;
						locationJ[step] = j;
						attack.isBlack = false;
						
						if(step == 1){
							try {
								Attack.allChess[i-1][j+1] = 2;
								attack.isBlack = true;
								frame.repaint();
								step++;
								locationI[step] = i - 1;
								locationJ[step] = j + 1;
								
							} catch (ArrayIndexOutOfBoundsException e) {
								// TODO Auto-generated catch block
								
								
								Attack.allChess[9][9] = 2;
								attack.isBlack = true;
								frame.repaint();
								step++;
								locationI[step] = 9;
								locationJ[step] = 9;
							}
						}
						
						//���Ӳ�һ��:����
						if(attack.isBlack == false && attack.canPlay == true){
							int count = 0;
							i = locationI[step-1];
							j = locationJ[step-1];
							while(count <= 3 && attack.canPlay == true && attack.isBlack == false){
								Condition1(i,j - 1,i,j,i,j + 1,i,j + 2,i,j + 3,i,j + 4,2);
								count++;
								j--;
							}
						}
						//���Ӳ�һ��:����
						if(attack.isBlack == false && attack.canPlay == true){
							int count = 0;
							i = locationI[step-1];
							j = locationJ[step-1];
							while(count <= 3 && attack.canPlay == true && attack.isBlack == false){
								Condition1(i - 1,j,i,j,i + 1,j,i + 2,j,i + 3,j,i + 4,j,2);
								count++;
								i--;
							}
						}
						//���Ӳ�һ��:б��
						if(attack.isBlack == false && attack.canPlay == true){
							int count = 0;
							i = locationI[step-1];
							j = locationJ[step-1];
							while(count <= 3 && attack.canPlay == true && attack.isBlack == false){
								Condition1(i-1,j - 1,i,j,i+1,j + 1,i + 2,j + 2,i + 3,j + 3,i + 4,j + 4,2);
								count++;
								i--;
								j--;
							}
						}
						//���Ӳ�һ��:б��
						if(attack.isBlack == false && attack.canPlay == true){
							int count = 0;
							i = locationI[step-1];
							j = locationJ[step-1];
							while(count <= 3 && attack.canPlay == true && attack.isBlack == false){
								Condition1(i - 1,j + 1,i,j,i + 1,j - 1,i + 2,j - 2,i + 3,j - 3,i + 4,j - 4,2);
								count++;
								i--;
								j++;
							}
						}
						
						
						//�����м��һ�ӣ�����4�֣�
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step - 1];
							j = locationJ[step - 1];
							Condition2(i,j,i,j + 1,i,j + 2,i,j + 3,2);
						}
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step - 1];
							j = locationJ[step - 1];
							Condition2(i,j - 1,i,j,i,j + 1,i,j + 2,2);
						}
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step - 1];
							j = locationJ[step - 1];
							Condition2(i,j - 3,i,j - 2,i,j,i,j + 1,2);
						}
						
						//�����м��һ�ӣ�����4�֣�
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step - 1];
							j = locationJ[step - 1];
							Condition2(i,j,i + 1,j,i + 2,j,i + 3,j,2);
						}
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step - 1];
							j = locationJ[step - 1];
							Condition2(i - 1,j,i,j,i + 1,j,i + 2,j,2);
						}
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step - 1];
							j = locationJ[step - 1];
							Condition2(i - 3,j,i - 2,j,i - 1,j,i,j,2);
						}
						
						
						//�����м��һ�ӣ�б��4�֣�
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step - 1];
							j = locationJ[step - 1];
							Condition2(i,j,i + 1,j + 1,i + 2,j + 2,i + 3,j + 3,2);
						}
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step - 1];
							j = locationJ[step - 1];
							Condition2(i - 1,j - 1,i,j,i + 1,j + 1,i + 2,j + 2,2);
						}
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step - 1];
							j = locationJ[step - 1];
							Condition2(i - 3,j - 3,i - 2,j - 2,i - 1,j - 1,i,j,2);
						}
						//�����м��һ�ӣ�б��4�֣�
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step - 1];
							j = locationJ[step - 1];
							Condition2(i,j,i + 1,j - 1,i + 2,j - 2,i + 3,j - 3,2);
						}
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step - 1];
							j = locationJ[step - 1];
							Condition2(i - 1,j + 1,i,j,i + 1,j - 1,i + 2,j - 2,2);
						}
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step - 1];
							j = locationJ[step - 1];
							Condition2(i - 3,j + 3,i - 2,j + 2,i - 1,j + 1,i,j,2);
						}
						
						
						//���Ӳ�һ��:����(��ס�Է�)
						if(attack.isBlack == false && attack.canPlay == true){
							int count = 0;
							i = locationI[step];
							j = locationJ[step];
							while(count <= 3 && attack.canPlay == true && attack.isBlack == false){
								Condition1(i,j - 1,i,j,i,j + 1,i,j + 2,i,j + 3,i,j + 4,1);
								count++;
								j--;
							}
						}
						//���Ӳ�һ��:����(��ס�Է�)
						if(attack.isBlack == false && attack.canPlay == true){
							int count = 0;
							i = locationI[step];
							j = locationJ[step];
							while(count <= 3 && attack.canPlay == true && attack.isBlack == false){
								Condition1(i - 1,j,i,j,i + 1,j,i + 2,j,i + 3,j,i + 4,j,1);
								count++;
								i--;
							}
						}
						//���Ӳ�һ��:б��(��ס�Է�)
						if(attack.isBlack == false && attack.canPlay == true){
							int count = 0;
							i = locationI[step];
							j = locationJ[step];
							while(count <= 3 && attack.canPlay == true && attack.isBlack == false){
								Condition1(i-1,j - 1,i,j,i+1,j + 1,i + 2,j + 2,i + 3,j + 3,i + 4,j + 4,1);
								count++;
								i--;
								j--;
							}
						}
						//���Ӳ�һ��:б��(��ס�Է�)
						if(attack.isBlack == false && attack.canPlay == true){
							int count = 0;
							i = locationI[step];
							j = locationJ[step];
							while(count <= 3 && attack.canPlay == true && attack.isBlack == false){
								Condition1(i - 1,j + 1,i,j,i + 1,j - 1,i + 2,j - 2,i + 3,j - 3,i + 4,j - 4,1);
								count++;
								i--;
								j++;
							}
						}
						
						
						//�����м��һ�ӣ�����:��ס�Է���4�֣�
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step];
							j = locationJ[step];
							Condition2(i,j,i,j + 1,i,j + 2,i,j + 3,1);
						}
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step];
							j = locationJ[step];
							Condition2(i,j - 1,i,j,i,j + 1,i,j + 2,1);
						}
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step];
							j = locationJ[step];
							Condition2(i,j - 3,i,j - 2,i,j - 1,i,j,1);
						}
						//�����м��һ�ӣ�����4�֣�
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step];
							j = locationJ[step];
							Condition2(i,j,i + 1,j,i + 2,j,i + 3,j,1);
						}
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step];
							j = locationJ[step];
							Condition2(i - 1,j,i,j,i + 1,j,i + 2,j,1);
						}
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step];
							j = locationJ[step];
							Condition2(i - 3,j,i - 2,j,i - 1,j,i,j,1);
						}
						//�����м��һ�ӣ�б��4�֣�
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step];
							j = locationJ[step];
							Condition2(i,j,i + 1,j + 1,i + 2,j + 2,i + 3,j + 3,1);
						}
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step];
							j = locationJ[step];
							Condition2(i - 1,j - 1,i,j,i + 1,j + 1,i + 2,j + 2,1);
						}
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step];
							j = locationJ[step];
							Condition2(i - 3,j - 3,i - 2,j - 2,i - 1,j - 1,i,j,1);
						}
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step];
							j = locationJ[step];
							Condition2(i - 4,j - 4,i - 3,j - 3,i - 2,j - 2,i - 1,j - 1,1);
						}
						//�����м��һ�ӣ�б��4�֣�
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step];
							j = locationJ[step];
							Condition2(i,j,i + 1,j - 1,i + 2,j - 2,i + 3,j - 3,1);
						}
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step];
							j = locationJ[step];
							Condition2(i - 1,j + 1,i,j,i + 1,j - 1,i + 2,j - 2,1);
						}
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step];
							j = locationJ[step];
							Condition2(i - 3,j + 3,i - 2,j + 2,i - 1,j + 1,i,j,1);
						}
						
						
	
						//���Ӳ����ӣ�����
						if(attack.isBlack == false && attack.canPlay == true){
							int count = 0;
							i = locationI[step-1];
							j = locationJ[step-1];
							while(count <= 2 && attack.canPlay == true && attack.isBlack == false){
								Condition3(i,j-1,i,j,i,j+1,i,j+2,i,j+3,2);
								count++;
								j--;
							}
						}
						//���Ӳ�����:����
						if(attack.isBlack == false && attack.canPlay == true){
							int count = 0;
							i = locationI[step-1];
							j = locationJ[step-1];
							while(count <= 2 && attack.canPlay == true && attack.isBlack == false){
								Condition3(i - 1,j,i,j,i + 1,j,i + 2,j,i + 3,j,2);
								count++;
								i--;
							}
						}
						//���Ӳ����ӣ�б��
						if(attack.isBlack == false && attack.canPlay == true){
							int count = 0;
							i = locationI[step-1];
							j = locationJ[step-1];
							while(count <= 2 && attack.canPlay == true && attack.isBlack == false){
								Condition3(i-1,j - 1,i,j,i+1,j + 1,i + 2,j + 2,i + 3,j + 3,2);
								count++;
								i--;
								j--;
							}
						}
						//���Ӳ����ӣ�б��
						if(attack.isBlack == false && attack.canPlay == true){
							int count = 0;
							i = locationI[step-1];
							j = locationJ[step-1];
							while(count <= 2 && attack.canPlay == true && attack.isBlack == false){
								Condition3(i - 1,j + 1,i,j,i + 1,j - 1,i + 2,j - 2,i + 3,j - 3,2);
								count++;
								i--;
								j++;
							}
						}
						
						//���Ӳ����ӣ���ס�Է���������
						if(attack.isBlack == false && attack.canPlay == true){
							int count = 0;
							i = locationI[step];
							j = locationJ[step];
							while(count <= 2 && attack.canPlay == true && attack.isBlack == false){
								Condition3(i,j-1,i,j,i,j+1,i,j+2,i,j+3,1);
								count++;
								j--;
							}
						}
						//���Ӳ����ӣ���ס�Է���:����
						if(attack.isBlack == false && attack.canPlay == true){
							int count = 0;
							i = locationI[step];
							j = locationJ[step];
							while(count <= 2 && attack.canPlay == true && attack.isBlack == false){
								Condition3(i - 1,j,i,j,i + 1,j,i + 2,j,i + 3,j,1);
								count++;
								i--;
							}
						}
						//���Ӳ����ӣ���ס�Է�����б��
						if(attack.isBlack == false && attack.canPlay == true){
							int count = 0;
							i = locationI[step];
							j = locationJ[step];
							while(count <= 2 && attack.canPlay == true && attack.isBlack == false){
								Condition3(i-1,j - 1,i,j,i+1,j + 1,i + 2,j + 2,i + 3,j + 3,1);
								count++;
								i--;
								j--;
							}
						}
						//���Ӳ����ӣ���ס�Է�����б��
						if(attack.isBlack == false && attack.canPlay == true){
							int count = 0;
							i = locationI[step];
							j = locationJ[step];
							while(count <= 2 && attack.canPlay == true && attack.isBlack == false){
								Condition3(i - 1,j + 1,i,j,i + 1,j - 1,i + 2,j - 2,i + 3,j - 3,1);
								count++;
								i--;
								j++;
							}
						}
						
						
						//��������һ�߿գ�������(����)
						if(attack.isBlack == false && attack.canPlay == true){
							int count = 0;
							i = locationI[step-1];
							j = locationJ[step-1];
							while(count <= 2 && attack.canPlay == true && attack.isBlack == false){
								Condition4(i,j - 1,i,j,i,j + 1,i,j + 2,i,j + 3,i,j + 4);
								count++;
								j--;
							}
						}
						
						//��������һ�߿գ�������(����)
						if(attack.isBlack == false && attack.canPlay == true){
							int count = 0;
							i = locationI[step-1];
							j = locationJ[step-1];
							while(count <= 2 && attack.canPlay == true && attack.isBlack == false){
								Condition4(i - 1,j,i,j,i + 1,j,i + 2,j,i + 3,j,i + 4,j);
								count++;
								i--;
							}
						}
						
						//��������һ�߿գ�������(б��)
						if(attack.isBlack == false && attack.canPlay == true){
							int count = 0;
							i = locationI[step-1];
							j = locationJ[step-1];
							while(count <= 2 && attack.canPlay == true && attack.isBlack == false){
								Condition4(i-1,j - 1,i,j,i+1,j + 1,i + 2,j + 2,i + 3,j + 3,i + 4,j + 4);
								count++;
								i--;
								j--;
							}
						}
						//��������һ�߿գ�������(б��)
						if(attack.isBlack == false && attack.canPlay == true){
							int count = 0;
							i = locationI[step-1];
							j = locationJ[step-1];
							while(count <= 2 && attack.canPlay == true && attack.isBlack == false){
								Condition4(i - 1,j + 1,i,j,i + 1,j - 1,i + 2,j - 2,i + 3,j - 3,i + 4,j - 4);
								count++;
								i--;
								j++;
							}
						}
			
						//������������һ�߿�(��������)������
						if(attack.isBlack == false && attack.canPlay == true){
							int count = 0;
							i = locationI[step-1];
							j = locationJ[step-1];
							while(count <= 1 && attack.canPlay == true && attack.isBlack == false){
								Condition5(i,j-1,i,j,i,j+1,i,j+2,i,j+3);
								count++;
								j--;
							}	
						}
						//������������һ�߿�(��������)������
						if(attack.isBlack == false && attack.canPlay == true){
							int count = 0;
							i = locationI[step-1];
							j = locationJ[step-1];
							while(count <= 1 && attack.canPlay == true && attack.isBlack == false){
								Condition5(i - 1,j,i,j,i + 2,j,i + 3,j,i + 4,j);
								count++;
								i--;
							}	
						}
						//������������һ�߿�(��������)��б��
						if(attack.isBlack == false && attack.canPlay == true){
							int count = 0;
							i = locationI[step-1];
							j = locationJ[step-1];
							while(count <= 1 && attack.canPlay == true && attack.isBlack == false){
								Condition5(i - 1,j - 1,i,j,i + 2,j + 2,i + 3,j + 3,i + 4,j+4);
								count++;
								j--;
								i--;
							}	
						}
						//������������һ�߿�(��������)��б��
						if(attack.isBlack == false && attack.canPlay == true){
							int count = 0;
							i = locationI[step-1];
							j = locationJ[step-1];
							while(count <= 1 && attack.canPlay == true && attack.isBlack == false){
								Condition5(i - 1,j + 1,i,j,i + 1,j - 1,i + 2,j - 2,i + 3,j - 3);
								count++;
								i--;
								j++;
							}	
						}
						
						//һ����
						if(attack.isBlack == false && attack.canPlay == true){
							i = locationI[step-1];
							j = locationJ[step-1];
							Condition6(i,j);	
						}
					}
				}
				else{
					JOptionPane.showMessageDialog(frame, "�˴������ӣ����������ӣ�");
				}
			}
		}
	}
}




