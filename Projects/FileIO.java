package Projects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileIO {
	private static final Pattern pattern1 = Pattern.compile("[KQNRBP][ld][a-h][1-8]" );
	private static final Pattern pattern2 = Pattern.compile("[a-h][1-8] [a-h][1-8]");
	private static final Pattern pattern3 = Pattern.compile("[a-h][1-8] [a-h][1-8][*]");
	private static final Pattern pattern4 = Pattern.compile("[a-h][1-8] [a-h][1-8] [a-h][1-8] [a-h][1-8]");

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File(args[0]);
		FileInputStream is = new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String next;
		ArrayList<String> out = new ArrayList<String>();
		String toOut = "";
		Matcher m4;
		Matcher m3;
		Matcher m2;
		Matcher m1;
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
					toOut = "Move piece at "
							+ m4.group(0).substring(0, 2).toUpperCase()
							+ " to "
							+ m4.group(0).substring(3, 6).toUpperCase()
							+ "and move the piece at "
							+ m4.group(0).substring(6, 8).toUpperCase()
							+ " to "
							+ m4.group(0).substring(9, 11).toUpperCase() + ".";
					out.add(toOut);
				} else if (m3.find()) {
					toOut = "Piece at "
							+ m3.group(0).substring(0, 2).toUpperCase()
							+ " takes piece at "
							+ m3.group(0).substring(3, 5).toUpperCase() + ".";
					out.add(toOut);
				} else if (m2.find()) {
					toOut = "Move piece at "
							+ m2.group(0).substring(0, 2).toUpperCase()
							+ " to "
							+ m2.group(0).substring(3, 5).toUpperCase() + ".";
					out.add(toOut);
				} else if (m1.find()) {

					String color;
					if (m1.group(0).charAt(1) == 'l') {
						color = " black";
					} else {
						color = "white";
					}
					String piece = key.get(m1.group(0).charAt(0));

					toOut = "Place the" + color + piece + "at "
							+ m1.group(0).substring(2).toUpperCase() + ".";
					out.add(toOut);
				}
				else {
					out.add("Invalid move.");
				}
				next = br.readLine();
				toOut = "";
			}
		} catch (IOException e) {

		}
		for(String line : out){
			System.out.println(line);
		}
	}
}
