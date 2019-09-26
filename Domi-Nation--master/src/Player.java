import java.util.ArrayList;

public class Player {
	int[] scores;
	String name;
	Board board;
	boolean isAIcontrolled;
	int Color;

	public int[] getscores() {
		return this.scores;
	}

	public int getColor() {
		return this.Color;
	}

	public void setscores(int[] scores) {
		this.scores = scores;
	}

	public void setColor(int color) {
		this.Color = color;
	}

	public String getname() {
		return this.name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public Board getboard() {
		return this.board;
	}

	public void setboard(Board board) {
		this.board = board;
	}

	public boolean getIA() {
		return this.isAIcontrolled;
	}

	public void setIA(boolean isIA) {
		this.isAIcontrolled = isIA;
	}

	public Player(String name, Board board) {
		int[] scores = { 0, 0, 0 };
		this.scores = scores;
		this.name = name;
		this.board = board;
		this.isAIcontrolled = false;
	}

	public int choosetile(ArrayList<Tuile> pioche, int[] CrownsPWFLQM) {
		int choice = 0;
		int value = 0;
		for (int domino = 0; domino < pioche.size(); domino++) {
			if (value < pioche.get(domino).evaluate(CrownsPWFLQM)) {
				value = pioche.get(domino).evaluate(CrownsPWFLQM);
				choice = domino;
			}
		}
		return choice;
	}

	public int[] choosemove(Tuile tuile) {
		int[] choice = new int[4];
		choice[0] = -1;
		choice[3] = -1;
		int score = -1;
		char[][] totest = this.getboard().copy().playable(tuile, 1);
		int size = totest.length;
		int currentscore = -1;
		for (int colonne = 0; colonne < size; colonne++) {
			for (int ligne = 0; ligne < size; ligne++) {
				if (totest[colonne][ligne] == 'O') {
					if (this.getboard().jouable(tuile, ligne, colonne, ligne + 1, colonne)) {
						Board board = this.getboard().copy();
						tuile.inserttuile(board, ligne, colonne, ligne + 1, colonne);
						currentscore = board.score();
						if (currentscore >= score) {
							score = currentscore;
							choice[0] = ligne;
							choice[1] = colonne;
							choice[2] = ligne + 1;
							choice[3] = colonne;
						}
					}
					if (this.getboard().jouable(tuile, ligne, colonne, ligne - 1, colonne)) {
						Board board = this.getboard().copy();
						tuile.inserttuile(board, ligne, colonne, ligne - 1, colonne);
						currentscore = board.score();
						if (currentscore >= score) {
							score = currentscore;
							choice[0] = ligne;
							choice[1] = colonne;
							choice[2] = ligne - 1;
							choice[3] = colonne;
						}
					}
					if (this.getboard().jouable(tuile, ligne, colonne, ligne, colonne + 1)) {
						Board board = this.getboard().copy();
						tuile.inserttuile(board, ligne, colonne, ligne, colonne + 1);
						currentscore = board.score();
						if (currentscore >= score) {
							score = currentscore;
							choice[0] = ligne;
							choice[1] = colonne;
							choice[2] = ligne;
							choice[3] = colonne + 1;
						}
					}
					if (this.getboard().jouable(tuile, ligne, colonne, ligne, colonne - 1)) {
						Board board = this.getboard().copy();
						tuile.inserttuile(board, ligne, colonne, ligne, colonne - 1);
						currentscore = board.score();
						if (currentscore >= score) {
							score = currentscore;
							choice[0] = ligne;
							choice[1] = colonne;
							choice[2] = ligne;
							choice[3] = colonne - 1;

						}
					}
				}
			}
		}
		totest = this.getboard().copy().playable(tuile, 2);
		size = totest.length;
		for (int colonne = 0; colonne < size; colonne++) {
			for (int ligne = 0; ligne < size; ligne++) {
				if (totest[colonne][ligne] == 'O') {
					if (this.getboard().jouable(tuile, ligne, colonne, ligne + 1, colonne)) {
						Board board = this.getboard().copy();
						tuile.inserttuile(board, ligne, colonne, ligne + 1, colonne);
						currentscore = board.score();
						if (currentscore >= score) {
							score = currentscore;
							choice[0] = ligne;
							choice[1] = colonne;
							choice[2] = ligne + 1;
							choice[3] = colonne;
						}
					}
					if (this.getboard().jouable(tuile, ligne, colonne, ligne - 1, colonne)) {
						Board board = this.getboard().copy();
						tuile.inserttuile(board, ligne, colonne, ligne - 1, colonne);
						currentscore = board.score();
						if (currentscore >= score) {
							score = currentscore;
							choice[0] = ligne;
							choice[1] = colonne;
							choice[2] = ligne - 1;
							choice[3] = colonne;
						}
					}
					if (this.getboard().jouable(tuile, ligne, colonne, ligne, colonne + 1)) {
						Board board = this.getboard().copy();
						tuile.inserttuile(board, ligne, colonne, ligne, colonne + 1);
						currentscore = board.score();
						if (currentscore >= score) {
							score = currentscore;
							choice[0] = ligne;
							choice[1] = colonne;
							choice[2] = ligne;
							choice[3] = colonne + 1;
						}
					}
					if (this.getboard().jouable(tuile, ligne, colonne, ligne, colonne - 1)) {
						Board board = this.getboard().copy();
						tuile.inserttuile(board, ligne, colonne, ligne, colonne - 1);
						currentscore = board.score();
						if (currentscore >= score) {
							score = currentscore;
							choice[0] = ligne;
							choice[1] = colonne;
							choice[2] = ligne;
							choice[3] = colonne - 1;

						}
					}
				}
			}
		}
		return choice;
	}

}