package Projects;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PieceMovement {

	private static final Pattern pattern1 = Pattern
			.compile("([a-h])([1-8]) ([a-h])([1-8])");
	private static final Pattern pattern2 = Pattern
			.compile("([a-h])([1-8]) ([a-h])([1-8])[*]");
	private static final Pattern pattern3 = Pattern
			.compile("([a-h])([1-8]) ([a-h])([1-8]) ([a-h])([1-8]) ([a-h])([1-8])");

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

		Matcher match3;
		Matcher match2;
		Matcher match1;
		String next;

		try {
			next = br.readLine();
			while (next != null) {
				match1 = pattern1.matcher(next);
				match2 = pattern2.matcher(next);
				match3 = pattern3.matcher(next);

				if (match3.find()) {

					if (validMove(
							new Point(
									(int) match3.group(2).toCharArray()[0] - 49,
									(int) match3.group(1).toLowerCase()
											.toCharArray()[0] - 97),
							new Point((int) match3.group(
									6).toCharArray()[0] - 49,(int) match3.group(5).toLowerCase()
									.toCharArray()[0] - 97),
							board[(int) match3.group(1).toLowerCase()
									.toCharArray()[0] - 97][(int) match3.group(
									2).toCharArray()[0] - 49])
							&& board[(int) match3.group(5).toLowerCase()
									.toCharArray()[0] - 97][(int) match3.group(
									6).toCharArray()[0] - 49] != '-') {

						char piece = board[(int) match3.group(1).toLowerCase()
								.toCharArray()[0] - 97][(int) match3.group(2)
								.toCharArray()[0] - 49];
						board[(int) match3.group(1).toLowerCase().toCharArray()[0] - 97][(int) match3
								.group(2).toCharArray()[0] - 49] = '-';
						board[(int) match3.group(3).toLowerCase().toCharArray()[0] - 97][(int) match3
								.group(4).toCharArray()[0] - 49] = piece;

						piece = board[(int) match3.group(5).toLowerCase()
								.toCharArray()[0] - 97][(int) match3.group(6)
								.toCharArray()[0] - 49];
						board[(int) match3.group(5).toLowerCase().toCharArray()[0] - 97][(int) match3
								.group(6).toCharArray()[0] - 49] = '-';
						board[(int) match3.group(7).toLowerCase().toCharArray()[0] - 97][(int) match3
								.group(8).toCharArray()[0] - 49] = piece;
					}
					else if (match2.find()) {
						if (board[(int) match2.group(1).toLowerCase().toCharArray()[0] - 97][(int) match2
								.group(2).toCharArray()[0] - 49] != '-'
								&& board[(int) match2.group(3).toLowerCase()
										.toCharArray()[0] - 97][(int) match2.group(4)
										.toCharArray()[0] - 49] != '-') {
							if (board[(int) match2.group(1).toLowerCase().toCharArray()[0] - 97][(int) match2
									.group(2).toCharArray()[0] - 49] >= 'a'
									&& board[(int) match2.group(1).toLowerCase()
											.toCharArray()[0] - 97][(int) match2.group(
											2).toCharArray()[0] - 49] <= 'z') {
								if (board[(int) match2.group(3).toLowerCase()
										.toCharArray()[0] - 97][(int) match2.group(4)
										.toCharArray()[0] - 49] >= 'A'
										&& board[(int) match2.group(3).toLowerCase()
												.toCharArray()[0] - 97][(int) match2
												.group(4).toCharArray()[0] - 49] <= 'Z') {

									char piece = board[match2.group(1).toLowerCase()
											.toCharArray()[0] - 97][match2.group(2)
											.toCharArray()[0] - 49];

									board[(int) match2.group(1).toLowerCase()
											.toCharArray()[0] - 97][(int) match2.group(
											2).toCharArray()[0] - 49] = '-';

									board[(int) match2.group(3).toLowerCase()
											.toCharArray()[0] - 97][(int) match2.group(
											4).toCharArray()[0] - 49] = piece;
								}
							}

							if (board[(int) match2.group(1).toLowerCase().toCharArray()[0] - 97][(int) match2
									.group(2).toCharArray()[0] - 49] >= 'A'
									&& board[(int) match2.group(1).toLowerCase()
											.toCharArray()[0] - 97][(int) match2.group(
											2).toCharArray()[0] - 49] <= 'Z') {
								if (board[(int) match2.group(3).toLowerCase()
										.toCharArray()[0] - 97][(int) match2.group(4)
										.toCharArray()[0] - 49] >= 'a'
										&& board[(int) match2.group(3).toLowerCase()
												.toCharArray()[0] - 97][(int) match2
												.group(4).toCharArray()[0] - 49] <= 'z') {

									char piece = board[match2.group(1).toLowerCase()
											.toCharArray()[0] - 97][match2.group(2)
											.toCharArray()[0] - 49];

									board[(int) match2.group(1).toLowerCase()
											.toCharArray()[0] - 97][(int) match2.group(
											2).toCharArray()[0] - 49] = '-';

									board[(int) match2.group(3).toLowerCase()
											.toCharArray()[0] - 97][(int) match2.group(
											4).toCharArray()[0] - 49] = piece;
								}
							}
						}

					}
				}
				next = br.readLine();
			}
		} catch (IOException e) {

		}

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	private static boolean validMove(Point start, Point end, char piece) {
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
		return true;
	}

	private static boolean validKing(Point start, Point end) {
		return true;
	}

	private static boolean validQueen(Point start, Point end) {
		return true;
	}

}
