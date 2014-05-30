package Projects;

import java.awt.Point;

public class ValidityChecker {
	public boolean validMove(Point start, Point end, char piece, boolean taking) {
		if (Character.toUpperCase(piece) == 'R') {
			return validRook(start, end);
		}
		else if (piece == 'N') {
			return validKnight(start, end);
		}
		else if (piece == 'B') {
			return validBishop(start, end);
		}
		else if (piece == 'Q') {
			return validQueen(start, end);
		}
		else if (piece == 'K') {
			return validKing(start, end);
		}
		else if (piece == 'P') {
			return validPawn(start, end, piece, taking);
		}
		
		return false;
	}

	private boolean validRook(Point start, Point end) {
		if (start.x == end.x || start.y == end.y) {
			return true;
		}
		return false;
	}

	private boolean validKnight(Point start, Point end) {
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

	private boolean validBishop(Point start, Point end) {
		return(start.x - end.x == start.y - end.y || start.x - end.x == end.y - start.y || end.x - start.x == start.y - end.y);
			
	}

	private boolean validKing(Point start, Point end) {
		if((start.x - end.x == 1 || start.x - end.x == -1) && (start.y - end.y == 1 || start.y - end.y == -1)){
			return true;
		}else if((start.x == end.x && (start.y - end.y == 1 || start.y - end.y == -1)) || (start.y == end.y && (start.x - end.x == 1 || start.x - end.x == -1))){
			return true;
		}
		return false;
	}

	private boolean validQueen(Point start, Point end) {
		if(start.x - end.x == start.y - end.y || start.x - end.x == end.y - start.y || end.x - start.x == start.y - end.y){
			return true;
		}else if (start.x == end.x || start.y == end.y) {
			return true;
		}
		return false;
	}
	private boolean validPawn(Point start, Point end, char piece, boolean taking){
		if(taking){
			if(Character.isUpperCase(piece)){
				return start.x == end.x - 1 && (start.y == end.y - 1 || start.y == end.y + 1);
			}else{
				return start.x == end.x + 1 && (start.y == end.y - 1 || start.y == end.y + 1);
			}
		}
		if(Character.isUpperCase(piece) && (start.x == 1 || start.x == 6)){
			
			return start.x == end.x - 2;
		}else if(Character.isLowerCase(piece) && (start.x == 1 || start.x == 6)){
			return start.x == end.x + 2;
		}
		if(Character.isUpperCase(piece)){
			return start.x == end.x - 1;
		}else{
			return start.x == end.x + 1;
		}
		
	}
}
