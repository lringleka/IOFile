package Projects;

import java.awt.Point;

public class Board {
private Piece[][] board;
	public Board(){
		board = new Piece[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = new Piece('-');
			}
		}
		
		board[0][0] = new Rook('R');
		board[0][1] = new Knight('N');
		board[0][2] = new Bishop('B');
		board[0][3] = new Queen('Q');
		board[0][4] = new King('K');
		board[0][5] = new Bishop('B');
		board[0][6] = new Knight('N');
		board[0][7] = new Rook('R');
		
		board[1][0] = new Pawn('P');
		board[1][1] = new Pawn('P');
		board[1][2] = new Pawn('P');
		board[1][3] = new Pawn('P');
		board[1][4] = new Pawn('P');
		board[1][5] = new Pawn('P');
		board[1][6] = new Pawn('P');
		board[1][7] = new Pawn('P');

		board[7][0] = new Rook('r');
		board[7][1] = new Knight('n');
		board[7][2] = new Bishop('b');
		board[7][3] = new Queen('q');
		board[7][4] = new King('k');
		board[7][5] = new Bishop('b');
		board[7][6] = new Knight('n');
		board[7][7] = new Rook('r');
		
		board[6][0] = new Pawn('p');
		board[6][1] = new Pawn('p');
		board[6][2] = new Pawn('p');
		board[6][3] = new Pawn('p');
		board[6][4] = new Pawn('p');
		board[6][5] = new Pawn('p');
		board[6][6] = new Pawn('p');
		board[6][7] = new Pawn('p');
	}
	public Piece getCoord(Point query){
		return board[query.x][query.y];
	}
	public void move(Point start, Point end){
		Piece piece = board[start.x][start.y];
		board[start.x][start.y] = new Piece('-');
		board[end.x][end.y] = piece;
	}
	public void printBoard(){
		System.out.println("  a b c d e f g h");
		for (int i = 0; i < 8; i++) {
			System.out.print(i + 1 + " ");
			for (int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public boolean collisionCheck(Point start, Point end){
		boolean collide = false;
		if (start.x == end.x && start.y != end.y) {
			if(start.y > end.y){
				for(int i = end.y + 1; i < start.y; i++){
					if(board[start.x][i].getRep() != '-'){
						collide = true;
					}
				}
			}else if(start.y < end.y){
				for(int i = start.y + 1; i < end.y; i++){
					if(board[start.x][i].getRep() != '-'){
						collide = true;
					}
				}
			}
			
		}else if (start.y == end.y && start.x != end.x) {
			if(start.x > end.x){
				for(int i = end.x + 1; i < start.x; i++){
					if(board[i][start.y].getRep() != '-'){
						collide = true;
					}
				}
			}else if(start.x < end.x){
				for(int i = start.x + 1; i < end.x; i++){
					if(board[i][start.y].getRep() != '-'){
						collide = true;
					}
				}
			}
			
		}if(Math.abs(start.x - end.x) == Math.abs(start.y - end.y)){
			int x,y;
			if(start.x > end.x && start.y > end.y){
				x = start.x - 1;
				y = start.y - 1;
				while(y > end.y){
					if(board[x][y].getRep() != '-'){
						collide = true;
					}
					x--;
					y--;
				}
			}else if(start.x < end.x && start.y > end.y){
				x = start.x + 1;
				y = start.y - 1;
				while(y > end.y){
					if(board[x][y].getRep() != '-'){
						collide = true;
					}
					x++;
					y--;
				}
			}else if(start.x < end.x && start.y < end.y){
				x = start.x + 1;
				y = start.y + 1;
				while(y < end.y){
					if(board[x][y].getRep() != '-'){
						collide = true;
					}
					x++;
					y++;
				}
			}else if(start.x > end.x && start.y < end.y){
				x = start.x - 1;
				y = start.y + 1;
				while(y < end.y){
					if(board[x][y].getRep() != '-'){
						collide = true;
					}
					x--;
					y++;
				}
			}
		}
		return !collide;
	}
	public boolean turnCheck(boolean isWhiteTurn, Point start){
		if(Character.isUpperCase(board[start.x][start.y].getRep())&& isWhiteTurn){
			return true;
		}
		if(Character.isLowerCase(board[start.x][start.y].getRep())&& !isWhiteTurn){
			return true;
		}
		return false;
	}
	public void detectCheck(boolean isWhiteTurn){
		Point king = null;
		char target;
		boolean check = false;
		if(isWhiteTurn){
			target = 'K';
		}else{
			target = 'k';
		}
		for(int i = 0; i < board.length;i++){
			for(int j = 0; j < board[0].length;j++){
				if(board[i][j].getRep() == target && king == null){
					king = new Point(i,j);
				}
			}
		}
		for(int i = 0; i < board.length;i++){
			for(int j = 0; j < board[0].length;j++){
				if(Character.isUpperCase(target)){
					if(Character.isLowerCase(board[i][j].getRep()) && !check){
						check =	board[i][j].moveValidityChecker(new Point(i,j), king, true, isWhiteTurn) && collisionCheck(new Point(i,j),king);
					}
				}else{
					if(Character.isUpperCase(board[i][j].getRep()) && !check){
						check =	board[i][j].moveValidityChecker(new Point(i,j), king, true, isWhiteTurn) && collisionCheck(new Point(i,j),king);
					}
				}
			}
		}
		String color = null;
		if(isWhiteTurn){
			color = "white";
		}else{
			color = "black";
		}
		if(check){
			System.out.println("The " + color +  " king is in check.");
		}
		System.out.println();
	}
}
