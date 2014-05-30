package Projects;

import java.awt.Point;

public class Bishop extends Piece{
	private char pieceRep;
	public Bishop(char piece){
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
		return(start.x - end.x == start.y - end.y || start.x - end.x == end.y - start.y || end.x - start.x == start.y - end.y);
	}
	public char getRep(){
		return pieceRep;
	}
}
