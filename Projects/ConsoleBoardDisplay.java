package Projects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleBoardDisplay {

	private static final Pattern pattern1 = Pattern
			.compile("([KQNRBP])([ld])([a-h])([1-8])");
	private static final Pattern pattern2 = Pattern
			.compile("([a-h])([1-8]) ([a-h])([1-8])");
	private static final Pattern pattern3 = Pattern
			.compile("([a-h])([1-8]) ([a-h])([1-8])[*]");
	private static final Pattern pattern4 = Pattern
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

		Matcher m4;
		Matcher m3;
		Matcher m2;
		Matcher m1;
		String next;

		try {
			next = br.readLine();
			while (next != null) {
				m1 = pattern1.matcher(next);
				m2 = pattern2.matcher(next);
				m3 = pattern3.matcher(next);
				m4 = pattern4.matcher(next);
				Map<Character, String> key = new HashMap<Character, String>();
				key.put('K', " king ");
				key.put('Q', " queen ");
				key.put('N', " knight ");
				key.put('R', " rook ");
				key.put('B', " bishop ");
				key.put('P', " pawn ");

				if (m4.find()) {
					
					  if(board[(int)m4.group(1).toLowerCase().toCharArray()[0]
					  - 97][(int)m4.group(2).toCharArray()[0] - 49] != '-' &&
					  board[(int)m4.group(5).toLowerCase().toCharArray()[0] -
					  97][(int)m4.group(6).toCharArray()[0] - 49] != '-'){
						  
						  char piece = board[(int) m4.group(1).toLowerCase()
												.toCharArray()[0] - 97][(int) m4.group(2)
												.toCharArray()[0] - 49];
										board[(int) m4.group(1).toLowerCase().toCharArray()[0] - 97][(int) m4
												.group(2).toCharArray()[0] - 49] = '-';
										board[(int) m4.group(3).toLowerCase().toCharArray()[0] - 97][(int) m4
												.group(4).toCharArray()[0] - 49] = piece;
						  
										
										 piece = board[(int) m4.group(5).toLowerCase()
															.toCharArray()[0] - 97][(int) m4.group(6)
															.toCharArray()[0] - 49];
													board[(int) m4.group(5).toLowerCase().toCharArray()[0] - 97][(int) m4
															.group(6).toCharArray()[0] - 49] = '-';
													board[(int) m4.group(7).toLowerCase().toCharArray()[0] - 97][(int) m4
															.group(8).toCharArray()[0] - 49] = piece;
					  }
					 

				} else if (m3.find()) {
					if (board[(int) m3.group(1).toLowerCase().toCharArray()[0] - 97][(int) m3
							.group(2).toCharArray()[0] - 49] != '-'
							&& board[(int) m3.group(3).toLowerCase()
									.toCharArray()[0] - 97][(int) m3.group(4)
									.toCharArray()[0] - 49] != '-') {
						if (board[(int) m3.group(1).toLowerCase().toCharArray()[0] - 97][(int) m3
								.group(2).toCharArray()[0] - 49] >= 'a'
								&& board[(int) m3.group(1).toLowerCase()
										.toCharArray()[0] - 97][(int) m3.group(
										2).toCharArray()[0] - 49] <= 'z') {
							if (board[(int) m3.group(3).toLowerCase()
									.toCharArray()[0] - 97][(int) m3.group(4)
									.toCharArray()[0] - 49] >= 'A'
									&& board[(int) m3.group(3).toLowerCase()
											.toCharArray()[0] - 97][(int) m3
											.group(4).toCharArray()[0] - 49] <= 'Z') {

								char piece = board[m3.group(1).toLowerCase()
										.toCharArray()[0] - 97][m3.group(2)
										.toCharArray()[0] - 49];

								board[(int) m3.group(1).toLowerCase()
										.toCharArray()[0] - 97][(int) m3.group(
										2).toCharArray()[0] - 49] = '-';

								board[(int) m3.group(3).toLowerCase()
										.toCharArray()[0] - 97][(int) m3.group(
										4).toCharArray()[0] - 49] = piece;
							}
						}

						if (board[(int) m3.group(1).toLowerCase().toCharArray()[0] - 97][(int) m3
								.group(2).toCharArray()[0] - 49] >= 'A'
								&& board[(int) m3.group(1).toLowerCase()
										.toCharArray()[0] - 97][(int) m3.group(
										2).toCharArray()[0] - 49] <= 'Z') {
							if (board[(int) m3.group(3).toLowerCase()
									.toCharArray()[0] - 97][(int) m3.group(4)
									.toCharArray()[0] - 49] >= 'a'
									&& board[(int) m3.group(3).toLowerCase()
											.toCharArray()[0] - 97][(int) m3
											.group(4).toCharArray()[0] - 49] <= 'z') {

								char piece = board[m3.group(1).toLowerCase()
										.toCharArray()[0] - 97][m3.group(2)
										.toCharArray()[0] - 49];

								board[(int) m3.group(1).toLowerCase()
										.toCharArray()[0] - 97][(int) m3.group(
										2).toCharArray()[0] - 49] = '-';

								board[(int) m3.group(3).toLowerCase()
										.toCharArray()[0] - 97][(int) m3.group(
										4).toCharArray()[0] - 49] = piece;
							}
						}
					}

				} else if (m2.find()) {
					if (board[(int) m2.group(1).toLowerCase().toCharArray()[0] - 97][(int) m2
							.group(2).toCharArray()[0] - 49] != '-') {
						char piece = board[(int) m2.group(1).toLowerCase()
								.toCharArray()[0] - 97][(int) m2.group(2)
								.toCharArray()[0] - 49];
						board[(int) m2.group(1).toLowerCase().toCharArray()[0] - 97][(int) m2
								.group(2).toCharArray()[0] - 49] = '-';
						board[(int) m2.group(3).toLowerCase().toCharArray()[0] - 97][(int) m2
								.group(4).toCharArray()[0] - 49] = piece;
					}
				} else if (m1.find()) {

					String piece = m1.group(1);
					if (m1.group(2).equals("l")) {
						piece = piece.toLowerCase();

					}
					board[(int) m1.group(3).toLowerCase().toCharArray()[0] - 97][(int) m1
							.group(4).toCharArray()[0] - 49] = piece
							.toCharArray()[0];

				} else {

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
}
