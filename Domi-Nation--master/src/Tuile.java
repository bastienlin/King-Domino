public class Tuile {
	int number, crown1, crown2;
	char tile1, tile2;

	public int getnumber() {
		return this.number;
	}

	public char gettile1() {
		return this.tile1;
	}

	public char gettile2() {
		return this.tile2;
	}

	public int getcrown1() {
		return this.crown1;
	}

	public int getcrown2() {
		return this.crown2;
	}

	public void setnumber(int number) {
		this.number = number;
	}

	public void settile1(char tile1) {
		this.tile1 = tile1;
	}

	public void settile2(char tile2) {
		this.tile2 = tile2;
	}

	public void setcrown1(int crown1) {
		this.crown1 = crown1;
	}

	public void setcrown2(int crown2) {
		this.crown2 = crown2;
	}

	public Tuile(int number, int crown1, int crown2, char tile1, char tile2) {
		this.number = number;
		this.crown1 = crown1;
		this.crown2 = crown2;
		this.tile1 = tile1;
		this.tile2 = tile2;
	}

	public void inserttuile(Board board, int x1, int y1, int x2, int y2) {
		crown1 = this.getcrown1();
		crown2 = this.getcrown2();
		tile1 = this.gettile1();
		tile2 = this.gettile2();
		Case case1 = new Case(x1, y1, crown1, tile1);
		Case case2 = new Case(x2, y2, crown2, tile2);
		board.setcase(case1);
		board.setcase(case2);
	}

	public int evaluate(int[] CrownsPWFLQM) {

		int Value = 0;
		if (this.tile1 == 'P') {
			Value = CrownsPWFLQM[0];
		}
		if (this.tile1 == 'W') {
			Value = +CrownsPWFLQM[1];
		}
		if (this.tile1 == 'F') {
			Value = CrownsPWFLQM[2];
		}
		if (this.tile1 == 'L') {
			Value = CrownsPWFLQM[3];
		}
		if (this.tile1 == 'Q') {
			Value = CrownsPWFLQM[4];
		}
		if (this.tile1 == 'M') {
			Value = CrownsPWFLQM[5];
		}
		if (this.tile1 == '#') {
			Value = 0;
		}
		if (this.tile2 == 'P') {
			Value = Value + CrownsPWFLQM[0];
		}
		if (this.tile2 == 'W') {
			Value = Value + CrownsPWFLQM[1];
		}
		if (this.tile2 == 'F') {
			Value = Value + CrownsPWFLQM[2];
		}
		if (this.tile2 == 'L') {
			Value = Value + CrownsPWFLQM[3];
		}
		if (this.tile2 == 'Q') {
			Value = Value + CrownsPWFLQM[4];
		}
		if (this.tile2 == 'M') {
			Value = Value + CrownsPWFLQM[5];
		}
		if (this.tile1 == '#') {
			Value = Value + 0;
		}
		return Value;
	}

}