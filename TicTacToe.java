import java.util.*;
public class TicTacToe
{
	public static int row,col;
	public static Scanner s=new Scanner(System.in);
	public static char[][] board=new char[3][3];
	public static char turn ='X';
	
	public static void main(String args[])
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				board[i][j]='_';	
			}
		}
	
	Play();
	}
	public static void PrintBoard()
	{
		for(int i=0;i<3;i++)
		{
			System.out.println();
			for(int j=0;j<3;j++)
			{
				if(j==0)
					System.out.print("| ");
				System.out.print(board[i][j]+" | ");
			}
			System.out.println();
		}
	}
	public static void Play()
	{
		boolean play=true;	
		PrintBoard();
 		tryagain:while(play)
		{
			System.out.println("Please Enter Row and Column");
			row=s.nextInt()-1;
			col=s.nextInt()-1;
			if(board[row][col]=='_')
				board[row][col]=turn;
			else
			{
				System.out.println("INVALID LOCATION!");
				continue tryagain;
			}
			if(GameOver(row,col))
			{
				play=false;
				System.out.println("Game Over player "+turn+" ! wins"); 
			}
			PrintBoard();
			if(turn=='X')
			{
				turn='O';
			}
			else
			turn='X';
		}
	}
	public static boolean GameOver(int r,int c)
	{
		if(board[0][c]==board[1][c]&&board[0][c]==board[2][c])
		return true;
		if(board[r][0]==board[r][1]&&board[r][0]==board[r][2])
		return true;
		if(board[0][0]==board[1][1]&&board[0][0]==board[2][2]&&board[1][1]!='_')
		return true;
		if(board[0][2]==board[1][1]&&board[0][2]==board[2][0]&&board[1][1]!='_')
		return true;
		return false;
	}
}
