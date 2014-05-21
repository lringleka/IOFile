package Projects;

import java.awt.Point;

public class Board {
private Character[][] board;
	public Board(){
		board = new Character[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = '-';
			}
		}
		board[0][0] = 'R';
		board[0][1] = 'N';
		board[0][2] = 'B';
		board[0][3] = 'Q';
		board[0][4] = 'K';
		board[0][5] = 'B';
		board[0][6] = 'N';
		board[0][7] = 'R';
		
		/*board[1][0] = 'P';
		board[1][1] = 'P';
		board[1][2] = 'P';
		board[1][3] = 'P';
		board[1][4] = 'P';
		board[1][5] = 'P';
		board[1][6] = 'P';
		board[1][7] = 'P';*/

		board[7][0] = 'r';
		board[7][1] = 'n';
		board[7][2] = 'b';
		board[7][3] = 'q';
		board[7][4] = 'k';
		board[7][5] = 'b';
		board[7][6] = 'n';
		board[7][7] = 'r';
		
		/*board[6][0] = 'p';
		board[6][1] = 'p';
		board[6][2] = 'p';
		board[6][3] = 'p';
		board[6][4] = 'p';
		board[6][5] = 'p';
		board[6][6] = 'p';
		board[6][7] = 'p';*/
	}
	public char getCoord(Point query){
		return board[query.x][query.y];
	}
	public void move(Point start, Point end){
		char piece = board[start.x][start.y];
		board[start.x][start.y] = '-';
		board[end.x][end.y] = piece;
	}
	public void printBoard(){
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
