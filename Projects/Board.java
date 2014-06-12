package Projects;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

public class Board {
	private Piece[][] board;
	private ArrayList<Point> checkPath = new ArrayList<Point>();
	private Point taker;

	public Board() {
		board = new Piece[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = new Piece('-');
			}
		}

		board[0][0] = new Rook('R');
		board[0][1] = new Knight('N');
		board[0][2] = new Bishop('B');
		board[0][3] = new Queen('Q');
		board[0][4] = new King('K');
		board[0][5] = new Bishop('B');
		board[0][6] = new Knight('N');
		board[0][7] = new Rook('R');

		board[1][0] = new Pawn('P');
		board[1][1] = new Pawn('P');
		board[1][2] = new Pawn('P');
		board[1][3] = new Pawn('P');
		board[1][4] = new Pawn('P');
		board[1][5] = new Pawn('P');
		board[1][6] = new Pawn('P');
		board[1][7] = new Pawn('P');

		board[7][0] = new Rook('r');
		board[7][1] = new Knight('n');
		board[7][2] = new Bishop('b');
		board[7][3] = new Queen('q');
		board[7][4] = new King('k');
		board[7][5] = new Bishop('b');
		board[7][6] = new Knight('n');
		board[7][7] = new Rook('r');

		board[6][0] = new Pawn('p');
		board[6][1] = new Pawn('p');
		board[6][2] = new Pawn('p');
		board[6][3] = new Pawn('p');
		board[6][4] = new Pawn('p');
		board[6][5] = new Pawn('p');
		board[6][6] = new Pawn('p');
		board[6][7] = new Pawn('p');
	}

	public void clearPath() {
		checkPath.clear();
	}

	public Piece getCoord(Point query) {
		return board[query.x][query.y];
	}

	public void move(Point start, Point end) {
		Piece piece = board[start.x][start.y];
		board[start.x][start.y] = new Piece('-');
		board[end.x][end.y] = piece;
	}

	public void printBoard() {
		System.out.println("  a b c d e f g h");
		for (int i = 0; i < 8; i++) {
			System.out.print(i + 1 + " ");
			for (int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public boolean collisionDetection(Point start, Point end, boolean check) {
		boolean collide = false;
		if (check) {
			taker = start;
		}
		if (start.x == end.x && start.y != end.y) {
			if (start.y > end.y) {
				for (int i = end.y + 1; i < start.y; i++) {
					if (check) {
						checkPath.add(new Point(start.x, i));
					}
					if (board[start.x][i].getRep() != '-') {
						collide = true;
					}
				}
			} else if (start.y < end.y) {
				for (int i = start.y + 1; i < end.y; i++) {
					if (check)
						checkPath.add(new Point(start.x, i));
					if (board[start.x][i].getRep() != '-') {
						collide = true;
					}
				}
			}

		} else if (start.y == end.y && start.x != end.x) {
			if (start.x > end.x) {
				for (int i = end.x + 1; i < start.x; i++) {
					if (check)
						checkPath.add(new Point(i, start.y));
					if (board[i][start.y].getRep() != '-') {
						collide = true;
					}
				}
			} else if (start.x < end.x) {
				for (int i = start.x + 1; i < end.x; i++) {
					if (check)
						checkPath.add(new Point(i, start.y));
					if (board[i][start.y].getRep() != '-') {
						collide = true;
					}
				}
			}

		}
		if (Math.abs(start.x - end.x) == Math.abs(start.y - end.y)) {
			int x, y;
			if (start.x > end.x && start.y > end.y) {
				x = start.x - 1;
				y = start.y - 1;
				while (y > end.y) {
					if (board[x][y].getRep() != '-') {
						collide = true;
					}
					if (check)
						checkPath.add(new Point(x, y));
					x--;
					y--;
				}
			} else if (start.x < end.x && start.y > end.y) {
				x = start.x + 1;
				y = start.y - 1;
				while (y > end.y) {
					if (board[x][y].getRep() != '-') {
						collide = true;
					}
					if (check)
						checkPath.add(new Point(x, y));
					x++;
					y--;
				}
			} else if (start.x < end.x && start.y < end.y) {
				x = start.x + 1;
				y = start.y + 1;
				while (y < end.y) {
					if (board[x][y].getRep() != '-') {
						collide = true;
					}
					if (check)
						checkPath.add(new Point(x, y));
					x++;
					y++;
				}
			} else if (start.x > end.x && start.y < end.y) {
				x = start.x - 1;
				y = start.y + 1;
				while (y < end.y) {
					if (board[x][y].getRep() != '-') {
						collide = true;
					}
					if (check)
						checkPath.add(new Point(x, y));
					x--;
					y++;
				}
			}
		}
		return !collide;
	}

	public boolean checkTurn(boolean isWhiteTurn, Point start) {
		if (Character.isUpperCase(board[start.x][start.y].getRep())
				&& isWhiteTurn) {
			return true;
		}
		if (Character.isLowerCase(board[start.x][start.y].getRep())
				&& !isWhiteTurn) {
			return true;
		}
		return false;
	}

	public boolean detectCheck(boolean isWhiteTurn) {
		Point king = null;
		char target;
		boolean check = false;
		if (isWhiteTurn) {
			target = 'K';
		} else {
			target = 'k';
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j].getRep() == target && king == null) {
					king = new Point(i, j);
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (Character.isUpperCase(target)) {
					if (Character.isLowerCase(board[i][j].getRep()) && !check) {
						check = board[i][j].moveValidityChecker(
								new Point(i, j), king, true, isWhiteTurn)
								&& collisionDetection(new Point(i, j), king,
										true);
					}
				} else {
					if (Character.isUpperCase(board[i][j].getRep()) && !check) {
						check = board[i][j].moveValidityChecker(
								new Point(i, j), king, true, isWhiteTurn)
								&& collisionDetection(new Point(i, j), king,
										true);
					}
				}

			}
		}

		return check;
	}

	public boolean detectCheckMate(boolean isWhiteTurn) {
		Point king = null;
		boolean checkmate = true;
		char target;

		if (isWhiteTurn) {
			target = 'K';
		} else {
			target = 'k';
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j].getRep() == target && king == null) {
					king = new Point(i, j);
				}
			}
		}
		Point[] kingMoves = new Point[] { new Point(king.x + 1, king.y),
				new Point(king.x + 1, king.y + 1),
				new Point(king.x + 1, king.y - 1),
				new Point(king.x, king.y + 1), new Point(king.x, king.y - 1),
				new Point(king.x - 1, king.y),
				new Point(king.x - 1, king.y + 1),
				new Point(king.x - 1, king.y - 1) };
		boolean invalidSpace = false;
		ArrayList<Boolean> kingCanMove = new ArrayList<Boolean>();
		

		for (Point p : kingMoves) {
			if (p.x >= 0 && p.x <= 7 && p.y >= 0 && p.y <= 7
					&& board[p.x][p.y].getRep() == '-') {
				for (int i = 0; i < board.length; i++) {
					for (int j = 0; j < board[0].length; j++) {
						if (Character.isUpperCase(target) && checkmate) {
							if (Character.isLowerCase(board[i][j].getRep())) {
								invalidSpace = board[i][j].moveValidityChecker(
										new Point(i, j), p, false, isWhiteTurn)
										&& collisionDetection(new Point(i, j),
												p, false);
								kingCanMove.add(invalidSpace);
							}
						} else {
							if (Character.isUpperCase(board[i][j].getRep())) {
								invalidSpace = board[i][j].moveValidityChecker(
										new Point(i, j), p, false, isWhiteTurn)
										&& collisionDetection(new Point(i, j),
												p, false);
								kingCanMove.add(invalidSpace);
							}
						}
					}
				}

				if (!kingCanMove.contains(true)) {
					checkmate = false;
				}
				kingCanMove.clear();
				if (!checkmate) {

					this.move(king, p);
					if (this.detectCheck(isWhiteTurn)) {
						checkmate = true;
					}
					this.move(p, king);
				}
			}
		}
		
		if (checkmate) {
			ArrayList<Point> temp = (ArrayList<Point>) checkPath.clone();
			Iterator<Point> iterate = temp.iterator();
			while (iterate.hasNext()) {
				Point p = iterate.next();
				for (int i = 0; i < board.length; i++) {
					for (int j = 0; j < board[0].length; j++) {
						if (Character.isUpperCase(target)) {
							if (Character.isUpperCase(board[i][j].getRep())
									&& checkmate
									&& Character.toUpperCase(board[i][j]
											.getRep()) != 'K') {
								checkmate = !(board[i][j].moveValidityChecker(
										new Point(i, j), p, false, isWhiteTurn) && collisionDetection(
										new Point(i, j), p, false));
							}
						} else {
							if (Character.isLowerCase(board[i][j].getRep())
									&& checkmate
									&& Character.toUpperCase(board[i][j]
											.getRep()) != 'K') {
								checkmate = !(board[i][j].moveValidityChecker(
										new Point(king.x, king.y), p, false,
										isWhiteTurn) && collisionDetection(
										new Point(i, j), p, false));
							}
						}
					}
				}
				if (!checkmate) {

					this.move(king, p);
					if (this.detectCheck(isWhiteTurn)) {
						checkmate = true;
					}
					this.move(p, king);
				}
			}

		}

		if (checkmate && taker != null) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (checkmate && board[i][j].getRep() != '-') {
						checkmate = !(board[i][j].moveValidityChecker(
								new Point(i, j), taker, true, isWhiteTurn) && collisionDetection(
								new Point(i, j), taker, false));
						if (!checkmate) {

							this.move(king, new Point(i,j));
							if (this.detectCheck(isWhiteTurn)) {
								checkmate = true;
							}
							this.move(new Point(i,j), king);
						}
					}
				}
			}

		}
		
		checkPath.clear();
		return checkmate;
	}

	public boolean detectStalemate(boolean isWhiteTurn) {
		char target;
		boolean stalemate = true;
		if (isWhiteTurn) {
			target = 'K';
		} else {
			target = 'k';
		}
		Point king = null;;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j].getRep() == target && king == null) {
					king = new Point(i, j);
				}
			}
		}
		Point[] kingMoves = new Point[] { new Point(king.x + 1, king.y),
				new Point(king.x + 1, king.y + 1),
				new Point(king.x + 1, king.y - 1),
				new Point(king.x, king.y + 1), new Point(king.x, king.y - 1),
				new Point(king.x - 1, king.y),
				new Point(king.x - 1, king.y + 1),
				new Point(king.x - 1, king.y - 1) };
		boolean invalidSpace = false;
		ArrayList<Boolean> kingCanMove = new ArrayList<Boolean>();
		

		for (Point p : kingMoves) {
			if (p.x >= 0 && p.x <= 7 && p.y >= 0 && p.y <= 7
					&& board[p.x][p.y].getRep() == '-') {
				for (int i = 0; i < board.length; i++) {
					for (int j = 0; j < board[0].length; j++) {
						if (Character.isUpperCase(target) && stalemate) {
							if (Character.isLowerCase(board[i][j].getRep())) {
								invalidSpace = board[i][j].moveValidityChecker(
										new Point(i, j), p, false, isWhiteTurn)
										&& collisionDetection(new Point(i, j),
												p, false);
								kingCanMove.add(invalidSpace);
							}
						} else {
							if (Character.isUpperCase(board[i][j].getRep())) {
								invalidSpace = board[i][j].moveValidityChecker(
										new Point(i, j), p, false, isWhiteTurn)
										&& collisionDetection(new Point(i, j),
												p, false);
								kingCanMove.add(invalidSpace);
							}
						}
					}
				}
				
			}
			if (!kingCanMove.contains(true)) {
				stalemate = false;
			}
			kingCanMove.clear();
			
		}
		return stalemate;
	}
	
}
