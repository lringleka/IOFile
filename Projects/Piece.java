package Projects;

import java.awt.Point;

public class Piece {
private char pieceRep;
public Piece(char piece){
	pieceRep = piece;
}
public String toString(){
	return Character.toString(pieceRep);
}
public boolean moveValidityChecker(Point start, Point end, boolean taking, boolean isWhiteTurn){
	return true;
}
public char getRep(){
	return pieceRep;
}
}
