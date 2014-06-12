package Projects;

import java.awt.Point;
import java.util.ArrayList;

public class Rook extends Piece{
	private char pieceRep;
	public Rook(char piece){
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
		
		if (start.x == end.x || start.y == end.y) {
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
