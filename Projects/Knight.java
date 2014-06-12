package Projects;

import java.awt.Point;
import java.util.ArrayList;

public class Knight extends Piece{
	private char pieceRep;
	public Knight(char piece){
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
		
		if (start.x + 2 == end.x
				&& (start.y + 1 == end.y || start.y - 1 == end.y)) {
			return true;
		}
		if (start.x - 2 == end.x
				&& (start.y + 1 == end.y || start.y - 1 == end.y)) {
			return true;
		}
		if (start.y + 2 == end.y
				&& (start.x + 1 == end.x || start.x - 1 == end.x)) {
			return true;
		}
		if (start.y - 2 == end.y
				&& (start.x + 1 == end.x || start.x - 1 == end.x)) {
			return true;
		}

		return false;
	}
	public char getRep(){
		return pieceRep;
	}
	public ArrayList<Point> possibleMovesKey(Point p){
		ArrayList<Point> parr = new ArrayList<Point>();
		return parr;
	}
}