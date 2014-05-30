package Projects;

import java.awt.Point;

public class Pawn extends Piece{
	private char pieceRep;
	
	public Pawn(char piece){
		super(piece);
		pieceRep = piece;
	}
	public String toString(){
		return Character.toString(pieceRep);
	}
	public boolean moveValidityChecker(Point start, Point end, boolean taking, boolean isWhite){
		if(start.x == end.x && start.y == end.y){
			return false;
		}
		if(taking){
			if(isWhite){
				return start.x == end.x - 1 && (start.y == end.y - 1 || start.y == end.y + 1);
			}else{
				return start.x == end.x + 1 && (start.y == end.y - 1 || start.y == end.y + 1);
			}
		}
		if(isWhite && start.x == 1 ){
			
			return start.x == end.x - 2 || start.x == end.x - 1;
		}else if(!isWhite && start.x == 6 ){
			return start.x == end.x + 2 || start.x == start.x + 1;
		}
		if(isWhite){
			return start.x == end.x - 1;
		}else{
			return start.x == end.x + 1;
		}
		
	}
	public char getRep(){
		return pieceRep;
	}
}
