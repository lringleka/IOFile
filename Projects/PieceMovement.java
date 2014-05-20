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
									(int) pc.getGroup(4).toCharArray()[0] - '1',
									(int) pc.getGroup(3).toLowerCase()
											.toCharArray()[0] - 'a'),
							b.getCoord(new Point((int) pc.getGroup(1)
									.toLowerCase().toCharArray()[0] - 'a',
									(int) pc.getGroup(2).toCharArray()[0] - '1')))
							&& b.getCoord(new Point((int) pc.getGroup(3)
									.toLowerCase().toCharArray()[0] - 'a',
									(int) pc.getGroup(4).toCharArray()[0] - '1')) == '-'
							&& vc.validMove(
									new Point((int) pc.getGroup(6)
											.toCharArray()[0] - '1', (int) pc
											.getGroup(5).toLowerCase()
											.toCharArray()[0] - 'a'),
									new Point((int) pc.getGroup(8)
											.toCharArray()[0] - '1', (int) pc
											.getGroup(7).toLowerCase()
											.toCharArray()[0] - 'a'),
									b.getCoord(new Point(
											(int) pc.getGroup(5).toLowerCase()
													.toCharArray()[0] - 'a',
											(int) pc.getGroup(6).toCharArray()[0] - '1')))
							&& b.getCoord(new Point((int) pc.getGroup(7)
									.toLowerCase().toCharArray()[0] - 'a',
									(int) pc.getGroup(8).toCharArray()[0] - '1')) == '-') {
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
								b.getCoord(new Point(
										(int) pc.getGroup(1).toLowerCase()
												.toCharArray()[0] - 'a',
										(int) pc.getGroup(2).toCharArray()[0] - '1')))
								&& b.getCoord(new Point(
										(int) pc.getGroup(3).toLowerCase()
												.toCharArray()[0] - 'a',
										(int) pc.getGroup(4).toCharArray()[0] - '1')) != '-') {
							if (b.getCoord(new Point((int) pc.getGroup(1)
									.toLowerCase().toCharArray()[0] - 'a',
									(int) pc.getGroup(2).toCharArray()[0] - '1')) >= 'a'
									&& b.getCoord(new Point((int) pc
											.getGroup(1).toLowerCase()
											.toCharArray()[0] - 'a', (int) pc
											.getGroup(2).toCharArray()[0] - '1')) <= 'z') {
								if (b.getCoord(new Point(
										(int) pc.getGroup(3).toLowerCase()
												.toCharArray()[0] - 'a',
										(int) pc.getGroup(4).toCharArray()[0] - '1')) >= 'A'
										&& b.getCoord(new Point((int) pc
												.getGroup(3).toLowerCase()
												.toCharArray()[0] - 'a',
												(int) pc.getGroup(4)
														.toCharArray()[0] - '1')) <= 'Z') {

									b.move(new Point(
											(int) pc.getGroup(1).toLowerCase()
													.toCharArray()[0] - 'a',
											(int) pc.getGroup(2).toCharArray()[0] - '1'),
											new Point(
													(int) pc.getGroup(3)
															.toLowerCase()
															.toCharArray()[0] - 'a',
													(int) pc.getGroup(4)
															.toCharArray()[0] - '1'));

								}
							}

							if (b.getCoord(new Point((int) pc.getGroup(1)
									.toLowerCase().toCharArray()[0] - 'a',
									(int) pc.getGroup(2).toCharArray()[0] - '1')) >= 'A'
									&& b.getCoord(new Point((int) pc
											.getGroup(1).toLowerCase()
											.toCharArray()[0] - 'a', (int) pc
											.getGroup(2).toCharArray()[0] - '1')) <= 'Z') {
								if (b.getCoord(new Point(
										(int) pc.getGroup(3).toLowerCase()
												.toCharArray()[0] - 'a',
										(int) pc.getGroup(4).toCharArray()[0] - '1')) >= 'a'
										&& b.getCoord(new Point((int) pc
												.getGroup(3).toLowerCase()
												.toCharArray()[0] - 'a',
												(int) pc.getGroup(4)
														.toCharArray()[0] - '1')) <= 'z') {

									b.move(new Point(
											(int) pc.getGroup(1).toLowerCase()
													.toCharArray()[0] - 'a',
											(int) pc.getGroup(2).toCharArray()[0] - '1'),
											new Point(
													(int) pc.getGroup(3)
															.toLowerCase()
															.toCharArray()[0] - 'a',
													(int) pc.getGroup(4)
															.toCharArray()[0] - '1'));
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
									(int) pc.getGroup(4).toCharArray()[0] - '1',
									(int) pc.getGroup(3).toLowerCase()
											.toCharArray()[0] - 'a'),
							b.getCoord(new Point((int) pc.getGroup(1)
									.toLowerCase().toCharArray()[0] - 'a',
									(int) pc.getGroup(2).toCharArray()[0] - '1')))
							&& b.getCoord(new Point((int) pc.getGroup(1)
									.toLowerCase().toCharArray()[0] - 97,
									(int) pc.getGroup(2).toCharArray()[0] - 49)) != '-') {
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
