package org.my.game.frame;

import javax.swing.JOptionPane;

public class Attack{
	static int[][] allChess = new int[19][19];
	//定义一个数组，若数组值为0，表明当前位置无棋子，若数组值为1，表明当前位置有一个黑子，若数组值为2，表明当前位置有一个白子；	
	int[] locationI = new int[361];//定义一个数组存储每一步棋子对应的横坐标
	int[] locationJ = new int[361];//定义一个数组存储每一步棋子对应的纵坐标
	int[] noneI = new int[361];
	int[] noneJ = new int[361];
	
	static int step = 0;//定义一个变量计算下棋的步数
	

	boolean isBlack = true;//定义一个标识以便于判断当前应该下黑棋还是白棋；
	boolean canPlay = true;//定义一个标识以便于在一方认输后封锁棋局；
	
	String winner = null;
	
	FiveChessFrame frame;
	ButtonControl bControl;
	public Attack(FiveChessFrame _frame){
		frame = _frame;
	}
	

	public void Test(int i,int j,int n){
		if(allChess[i][j]  == n){
			if(n == 1)
				winner = "黑方胜";
			else
				winner = "白方胜";
			//判断横向是否形成五连
			try {
				if(allChess[i][j-1] == n && allChess[i][j-2] == n && allChess[i][j-3] == n && allChess[i][j-4] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "，游戏结束！");
					//更新棋局，并在此附近设置越界异常处理
				}
				if(allChess[i][j-1] == n && allChess[i][j-2] == n && allChess[i][j-3] == n && allChess[i][j+1] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "，游戏结束！");
					//更新棋局，并在此附近设置越界异常处理
				}
				if(allChess[i][j-1] == n && allChess[i][j-2] == n && allChess[i][j+1] == n && allChess[i][j+2] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, "黑方胜，游戏结束！");
					//更新棋局，并在此附近设置越界异常处理
				}
				if(allChess[i][j-1] == n && allChess[i][j+1] == n && allChess[i][j+2] == n && allChess[i][j+3] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "，游戏结束！");
					//更新棋局，并在此附近设置越界异常处理
				}
				if(allChess[i][j+1] == n && allChess[i][j+2] == n && allChess[i][j+3] == n && allChess[i][j+4] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "，游戏结束！");
					//更新棋局，并在此附近设置越界异常处理
				}
				
				//判断纵向是否形成五连
				if(allChess[i-1][j] == n && allChess[i-2][j] == n && allChess[i-3][j] == n && allChess[i-4][j] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "，游戏结束！");
					//更新棋局，并在此附近设置越界异常处理
				}
				if(allChess[i-1][j] == n && allChess[i-2][j] == n && allChess[i-3][j] == n && allChess[i+1][j] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "，游戏结束！");
					//更新棋局，并在此附近设置越界异常处理
				}
				if(allChess[i-1][j] == n && allChess[i-2][j] == n && allChess[i+1][j] == n && allChess[i+2][j] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "，游戏结束！");
					//更新棋局，并在此附近设置越界异常处理
				}
				if(allChess[i-1][j] == n && allChess[i+1][j] == n && allChess[i+2][j] == n && allChess[i+3][j] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "，游戏结束！");
					//更新棋局，并在此附近设置越界异常处理
				}
				if(allChess[i+1][j] == n && allChess[i+2][j] == n && allChess[i+3][j] == n && allChess[i+4][j] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "，游戏结束！");
					//更新棋局，并在此附近设置越界异常处理
				}
				
				//判断从左上到右下的方向是否形成五连
				if(allChess[i-1][j-1] == n && allChess[i-2][j-2] == n && allChess[i-3][j-3] == n && allChess[i-4][j-4] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "，游戏结束！");
					//更新棋局，并在此附近设置越界异常处理
				}
				if(allChess[i-1][j-1] == n && allChess[i-2][j-2] == n && allChess[i-3][j-3] == n && allChess[i+1][j+1] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "，游戏结束！");
					//更新棋局，并在此附近设置越界异常处理
				}
				if(allChess[i-1][j-1] == n && allChess[i-2][j-2] == n && allChess[i+1][j+1] == n && allChess[i+2][j+2] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "，游戏结束！");
					//更新棋局，并在此附近设置越界异常处理
				}
				if(allChess[i-1][j-1] == n && allChess[i+1][j+1] == n && allChess[i+2][j+2] == n && allChess[i+3][j+3] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "，游戏结束！");
					//更新棋局，并在此附近设置越界异常处理
				}
				if(allChess[i+1][j+1] == n && allChess[i+2][j+2] == n && allChess[i+3][j+3] == n && allChess[i+4][j+4] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "，游戏结束！");
					//更新棋局，并在此附近设置越界异常处理
				}
				
				//判断左下到右上方向是否形成五连
				if(allChess[i-1][j+1] == n && allChess[i-2][j+2] == n && allChess[i-3][j+3] == n && allChess[i-4][j+4] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "，游戏结束！");
					//更新棋局，并在此附近设置越界异常处理
				}
				if(allChess[i-1][j+1] == n && allChess[i-2][j+2] == n && allChess[i-3][j+3] == n && allChess[i+1][j-1] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "，游戏结束！");
					//更新棋局，并在此附近设置越界异常处理
				}
				if(allChess[i-1][j+1] == n && allChess[i-2][j+2] == n && allChess[i+1][j-1] == n && allChess[i+2][j-2] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "，游戏结束！");
					//更新棋局，并在此附近设置越界异常处理
				}
				if(allChess[i-1][j+1] == n && allChess[i+1][j-1] == n && allChess[i+2][j-2] == n && allChess[i+3][j-3] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "，游戏结束！");
					//更新棋局，并在此附近设置越界异常处理
				}
				if(allChess[i+1][j-1] == n && allChess[i+2][j-2] == n && allChess[i+3][j-3] == n && allChess[i+4][j-4] == n){
					canPlay = false;
					JOptionPane.showMessageDialog(frame, winner + "，游戏结束！");
					//更新棋局，并在此附近设置越界异常处理
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
						frame.message = "轮到白方";
						isBlack = false;
						frame.repaint();
						ButtonControl.blackTime = ButtonControl.maxTime;
						Test(i,j,1);
					}
					else{
						frame.message = "轮到黑方";
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
					JOptionPane.showMessageDialog(frame, "此处已有子，请重新落子！");
				}
			}
					
		}
	}
}
