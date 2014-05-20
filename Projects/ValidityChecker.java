package Projects;

import java.awt.Point;

public class ValidityChecker {
	public boolean validMove(Point start, Point end, char piece) {
		if (piece == 'R' || piece == 'r') {
			return validRook(start, end);
		}
		if (piece == 'N' || piece == 'n') {
			return validKnight(start, end);
		}
		if (piece == 'B' || piece == 'b') {
			return validBishop(start, end);
		}
		if (piece == 'Q' || piece == 'q') {
			return validQueen(start, end);
		}
		if (piece == 'K' || piece == 'k') {
			return validKing(start, end);
		}
		
		return false;
	}

	private static boolean validRook(Point start, Point end) {
		if (start.x == end.x || start.y == end.y) {
			return true;
		}
		return false;
	}

	private static boolean validKnight(Point start, Point end) {
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

	private static boolean validBishop(Point start, Point end) {
		if(start.x - end.x == start.y - end.y || start.x - end.x == end.y - start.y || end.x - start.x == start.y - end.y){
			return true;
		}
		return false;
	}

	private static boolean validKing(Point start, Point end) {
		if((start.x - end.x == 1 || start.x - end.x == -1) && (start.y - end.y == 1 || start.y - end.y == -1)){
			return true;
		}else if((start.x == end.x && (start.y - end.y == 1 || start.y - end.y == -1)) || (start.y == end.y && (start.x - end.x == 1 || start.x - end.x == -1))){
			return true;
		}
		return false;
	}

	private static boolean validQueen(Point start, Point end) {
		if(start.x - end.x == start.y - end.y || start.x - end.x == end.y - start.y || end.x - start.x == start.y - end.y){
			return true;
		}else if (start.x == end.x || start.y == end.y) {
			return true;
		}
		return false;
	}
}
