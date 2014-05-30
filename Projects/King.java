package Projects;

import java.awt.Point;

public class King extends Piece{
	private char pieceRep;
	public King(char piece){
		super(piece);
		pieceRep = piece;
	}
	public String toString(){
		return Character.toString(pieceRep);
	}
	public boolean moveValidityChecker(Point start, Point end, boolean taking, boolean isWhiteTurn){
		if(start.x == end.x && start.y == end.y){
			return false;
		}
		if((start.x - end.x == 1 || start.x - end.x == -1) && (start.y - end.y == 1 || start.y - end.y == -1)){
			return true;
		}else if((start.x == end.x && (start.y - end.y == 1 || start.y - end.y == -1)) || (start.y == end.y && (start.x - end.x == 1 || start.x - end.x == -1))){
			return true;
		}
		return false;
	}
	public char getRep(){
		return pieceRep;
	}
}
