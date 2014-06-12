package Projects;

import java.awt.Point;
import java.util.ArrayList;

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
public ArrayList<Point> possibleMovesKey(Point p){
	ArrayList<Point> parr = new ArrayList<Point>();
	return parr;
}
}
