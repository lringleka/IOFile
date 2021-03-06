package Projects;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

	public static void main(String[] args) throws Exception {

		File f = new File(args[0]);
		FileInputStream is = new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String next;
		PatternChecker pc = new PatternChecker();
		Board b = new Board();
		Boolean valid;
		Boolean isWhiteTurn;
		

		try {
			next = br.readLine();
			isWhiteTurn = true;
			while (next != null) {
				valid = true;
				if (pc.checkDubMove(next)) {

					Point start1 = new Point(
							(int) pc.getGroup(2).toCharArray()[0] - '1',
							(int) pc.getGroup(1).toLowerCase().toCharArray()[0] - 'a');
					Point end1 = new Point(
							(int) pc.getGroup(4).toCharArray()[0] - '1',
							(int) pc.getGroup(3).toLowerCase().toCharArray()[0] - 'a');
					Point start2 = new Point(
							(int) pc.getGroup(6).toCharArray()[0] - '1',
							(int) pc.getGroup(5).toLowerCase().toCharArray()[0] - 'a');
					Point end2 = new Point(
							(int) pc.getGroup(8).toCharArray()[0] - '1',
							(int) pc.getGroup(7).toLowerCase().toCharArray()[0] - 'a');

					if (b.getCoord(start1).moveValidityChecker(start1, end1, false, isWhiteTurn)
							&& b.getCoord(end1).getRep() == '-' && b.collisionDetection(start1, end1, false)
							&& b.getCoord(start2).moveValidityChecker(start2, end2, false, isWhiteTurn)
							&& b.getCoord(end2).getRep() == '-' && b.collisionDetection(start2, end2, false) && b.checkTurn(isWhiteTurn, start1) && b.checkTurn(isWhiteTurn, start2)) {
						b.move(start1, end1);

						b.move(start2, end2);

					} else {
						Exception ex = new Exception("Invalid move.");
						System.out.println(ex.getMessage());
						System.out.println();
						valid = false;
					}
				} else if (pc.checkTake(next)) {

					Point start = new Point(
							(int) pc.getGroup(2).toCharArray()[0] - '1',
							(int) pc.getGroup(1).toLowerCase().toCharArray()[0] - 'a');
					Point end = new Point(
							(int) pc.getGroup(4).toCharArray()[0] - '1',
							(int) pc.getGroup(3).toLowerCase().toCharArray()[0] - 'a');

					if (b.getCoord(start).moveValidityChecker(start, end, true, isWhiteTurn)
							&& b.getCoord(end).getRep() != '-' && b.collisionDetection(start, end, false) && b.checkTurn(isWhiteTurn, start)) {
						if (Character.isLowerCase(b.getCoord(start).getRep())) {
							if (Character.isUpperCase(b.getCoord(end).getRep())) {

								b.move(start, end);

							}
						}

						if (Character.isUpperCase(b.getCoord(start).getRep())) {
							if (Character.isLowerCase(b.getCoord(end).getRep())) {

								b.move(start, end);
							}
						}
					} else {
						Exception ex = new Exception("Invalid move.");
						System.out.println(ex.getMessage());
						System.out.println();
						valid = false;
					}

				} else if (pc.checkMove(next)) {
					
					Point start = new Point(
							(int) pc.getGroup(2).toCharArray()[0] - '1',
							(int) pc.getGroup(1).toLowerCase().toCharArray()[0] - 'a');
					Point end = new Point(
							(int) pc.getGroup(4).toCharArray()[0] - '1',
							(int) pc.getGroup(3).toLowerCase().toCharArray()[0] - 'a');
					
					if (b.getCoord(start).moveValidityChecker(start, end, false, isWhiteTurn) && b.collisionDetection(start, end, false)
							&& b.getCoord(start).getRep() != '-' && b.getCoord(end).getRep() == '-' && b.checkTurn(isWhiteTurn, start)) {
						b.move(start, end);
					} else {
						
						Exception ex = new Exception("Invalid move.");
						System.out.println(ex.getMessage());
						System.out.println();
						valid = false;
					}
				} else {
					Exception ex = new Exception("Invalid input.");
					System.out.println(ex.getMessage());
					valid = false;
				}
				next = br.readLine();
				if(valid){
					b.printBoard();	
					isWhiteTurn = !isWhiteTurn;
					boolean check = b.detectCheck(isWhiteTurn);
					boolean checkmate = false;
					boolean stalemate = false;
					if(check){
						checkmate = b.detectCheckMate(isWhiteTurn);
					}else{
						stalemate = b.detectStalemate(isWhiteTurn);
					}
					
					String color = null;
					if (isWhiteTurn) {
						color = "white";
					} else {
						color = "black";
					}
					if (checkmate) {
						System.out.println("The " + color + " king is in checkmate.");
					} else if (check) {
						System.out.println("The " + color + " king is in check.");
					}else if(stalemate)
					System.out.println("The " + color + " king is in stalemate.");
				}
			b.clearPath();	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
