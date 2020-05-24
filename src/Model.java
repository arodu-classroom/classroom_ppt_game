import java.util.Random;

public class Model {
	
	private int won = 0;
	private int lost = 0;
	private int tied = 0;
	
	public int getWon() {
		return won;
	}

	public void setWon() {
		this.won = this.won + 1;
	}

	public int getLost() {
		return lost;
	}

	public void setLost() {
		this.lost = this.lost + 1;
	}

	public int getTied() {
		return tied;
	}

	public void setTied() {
		this.tied = this.tied + 1;
	}

	public int opponentMove() {
		Random r = new Random();
		return r.nextInt(3) + 1;
	}
	
}
