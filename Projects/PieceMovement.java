package Projects;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class PieceMovement {

	public static void main(String[] args) throws FileNotFoundException {

		File f = new File(args[0]);
		FileInputStream is = new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		Character[][] board = new Character[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = '-';
			}
		}
		board[0][0] = 'R';
		board[0][1] = 'N';
		board[0][2] = 'B';
		board[0][3] = 'Q';
		board[0][4] = 'K';
		board[0][5] = 'B';
		board[0][6] = 'N';
		board[0][7] = 'R';

		board[7][0] = 'r';
		board[7][1] = 'n';
		board[7][2] = 'b';
		board[7][3] = 'q';
		board[7][4] = 'k';
		board[7][5] = 'b';
		board[7][6] = 'n';
		board[7][7] = 'r';

		String next;
		ValidityChecker vc = new ValidityChecker();
		PatternChecker pc = new PatternChecker();
		Board b = new Board();

		try {
			next = br.readLine();
			while (next != null) {

				if (pc.checkDubMove(next)) {

					if (vc.validMove(
							new Point(
									(int) pc.getGroup(2).toCharArray()[0] - '1',
									(int) pc.getGroup(1).toLowerCase()
											.toCharArray()[0] - 'a'),
							new Point(
									(int) pc.getGroup(6).toCharArray()[0] - '1',
									(int) pc.getGroup(5).toLowerCase()
											.toCharArray()[0] - 'a'),
							b.getCoord(new Point((int) pc.getGroup(1).toLowerCase()
									.toCharArray()[0] - 'a',(int) pc.getGroup(
									2).toCharArray()[0] - '1')))
							&& b.getCoord(new Point((int) pc.getGroup(5).toLowerCase()
									.toCharArray()[0] - 'a',(int) pc.getGroup(
									6).toCharArray()[0] - '1')) != '-') {
						b.move(new Point((int) pc.getGroup(1).toLowerCase()
								.toCharArray()[0] - 'a', (int) pc.getGroup(2)
								.toCharArray()[0] - '1'), new Point(
								(int) pc.getGroup(3).toLowerCase()
										.toCharArray()[0] - 'a', (int) pc
										.getGroup(4).toCharArray()[0] - '1'));

						b.move(new Point((int) pc.getGroup(5).toLowerCase()
								.toCharArray()[0] - 'a', (int) pc.getGroup(6)
								.toCharArray()[0] - '1'), new Point(
								(int) pc.getGroup(7).toLowerCase()
										.toCharArray()[0] - 'a', (int) pc
										.getGroup(8).toCharArray()[0] - '1'));

					} else if (pc.checkTake(next)) {
						if (vc.validMove(
								new Point(
										(int) pc.getGroup(2).toCharArray()[0] - '1',
										(int) pc.getGroup(1).toLowerCase()
												.toCharArray()[0] - 'a'),
								new Point(
										(int) pc.getGroup(6).toCharArray()[0] - '1',
										(int) pc.getGroup(5).toLowerCase()
												.toCharArray()[0] - 'a'),
								b.getCoord(new Point((int) pc.getGroup(1).toLowerCase()
										.toCharArray()[0] - 'a',(int) pc
										.getGroup(2).toCharArray()[0] - '1')))
								&& b.getCoord(new Point((int) pc.getGroup(3).toLowerCase()
										.toCharArray()[0] - 'a',(int) pc
										.getGroup(4).toCharArray()[0] - '1')) != '-') {
							if (b.getCoord(new Point((int) pc.getGroup(1).toLowerCase()
									.toCharArray()[0] - 'a',(int) pc.getGroup(
									2).toCharArray()[0] - '1')) >= 'a'
									&& b.getCoord(new Point((int) pc.getGroup(1).toLowerCase()
											.toCharArray()[0] - 'a',(int) pc
											.getGroup(2).toCharArray()[0] - '1')) <= 'z') {
								if (b.getCoord(new Point((int) pc.getGroup(3).toLowerCase()
										.toCharArray()[0] - 'a',(int) pc
										.getGroup(4).toCharArray()[0] - '1')) >= 'A'
										&& b.getCoord(new Point((int) pc.getGroup(3)
												.toLowerCase().toCharArray()[0] - 'a',(int) pc
												.getGroup(4).toCharArray()[0] - '1')) <= 'Z') {
									
									b.move(new Point((int) pc.getGroup(1).toLowerCase()
											.toCharArray()[0] - 'a', (int) pc.getGroup(2)
											.toCharArray()[0] - '1'), new Point(
											(int) pc.getGroup(3).toLowerCase()
													.toCharArray()[0] - 'a', (int) pc
													.getGroup(4).toCharArray()[0] - '1'));
									
									
								}
							}

							if (b.getCoord(new Point((int) pc.getGroup(1).toLowerCase()
									.toCharArray()[0] - 'a',(int) pc.getGroup(
									2).toCharArray()[0] - '1')) >= 'A'
									&& b.getCoord(new Point((int) pc.getGroup(1).toLowerCase()
											.toCharArray()[0] - 'a',(int) pc
											.getGroup(2).toCharArray()[0] - '1')) <= 'Z') {
								if (b.getCoord(new Point((int) pc.getGroup(3).toLowerCase()
										.toCharArray()[0] - 'a',(int) pc
										.getGroup(4).toCharArray()[0] - '1')) >= 'a'
										&& b.getCoord(new Point((int) pc.getGroup(3)
												.toLowerCase().toCharArray()[0] - 'a',(int) pc
												.getGroup(4).toCharArray()[0] - '1')) <= 'z') {

									b.move(new Point((int) pc.getGroup(1).toLowerCase()
											.toCharArray()[0] - 'a', (int) pc.getGroup(2)
											.toCharArray()[0] - '1'), new Point(
											(int) pc.getGroup(3).toLowerCase()
													.toCharArray()[0] - 'a', (int) pc
													.getGroup(4).toCharArray()[0] - '1'));
								}
							}
						}

					}
				} else if (pc.checkMove(next)) {
					if (vc.validMove(
							new Point(
									(int) pc.getGroup(2).toCharArray()[0] - '1',
									(int) pc.getGroup(1).toLowerCase()
											.toCharArray()[0] - 'a'),
							new Point(
									(int) pc.getGroup(6).toCharArray()[0] - '1',
									(int) pc.getGroup(5).toLowerCase()
											.toCharArray()[0] - 'a'),
							b.getCoord(new Point((int) pc.getGroup(1).toLowerCase()
									.toCharArray()[0] - 'a',(int) pc
									.getGroup(2).toCharArray()[0] - '1'))) && b.getCoord(new Point((int) pc.getGroup(1).toLowerCase().toCharArray()[0] - 97,(int) pc
							.getGroup(2).toCharArray()[0] - 49)) != '-') {
						b.move(new Point((int) pc.getGroup(1).toLowerCase()
								.toCharArray()[0] - 'a', (int) pc.getGroup(2)
								.toCharArray()[0] - '1'), new Point(
								(int) pc.getGroup(3).toLowerCase()
										.toCharArray()[0] - 'a', (int) pc
										.getGroup(4).toCharArray()[0] - '1'));
					}
				}
				next = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		b.printBoard();
		}
	}


