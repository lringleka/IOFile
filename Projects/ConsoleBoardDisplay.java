package Projects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class ConsoleBoardDisplay {
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File(args[0]);
		FileInputStream is = new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		Character[][] board = new Character[8][8];
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				board[i][j] = '-';
			}
		}
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
