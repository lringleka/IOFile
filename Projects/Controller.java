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
		ValidityChecker vc = new ValidityChecker();
		PatternChecker pc = new PatternChecker();
		Board b = new Board();
		Boolean valid;
		Boolean turn;

		try {
			next = br.readLine();
			turn = true;
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

					if (vc.validMove(start1, end1, b.getCoord(start1), false)
							&& b.getCoord(end1) == '-' && b.collisionCheck(start1, end1)
							&& vc.validMove(start2, end2, b.getCoord(start2), false)
							&& b.getCoord(end2) == '-' && b.collisionCheck(start2, end2) && b.turnCheck(turn, start1) && b.turnCheck(turn, start2)) {
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

					if (vc.validMove(start, end, b.getCoord(start), true)
							&& b.getCoord(end) != '-' && b.collisionCheck(start, end) && b.turnCheck(turn, start)) {
						if (Character.isLowerCase(b.getCoord(start))) {
							if (Character.isUpperCase(b.getCoord(end))) {

								b.move(start, end);

							}
						}

						if (Character.isUpperCase(b.getCoord(start))) {
							if (Character.isLowerCase(b.getCoord(end))) {

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
					
					if (vc.validMove(
							start, end, b.getCoord(start), false) && b.collisionCheck(start, end)
							&& b.getCoord(start) != '-' && b.getCoord(end) == '-' && b.turnCheck(turn, start)) {
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
					if(turn){
						turn = false;
					}else{
						turn = true;
					}
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
