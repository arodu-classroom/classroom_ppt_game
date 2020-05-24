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
	
	public boolean isWinner(int player, int opponent){
		if(player == Controller.PAPER && opponent == Controller.STONE) {
			return true;
		}
		
		if(player == Controller.STONE && opponent == Controller.SCISSORS) {
			return true;
		}
		
		if(player == Controller.SCISSORS && opponent == Controller.PAPER) {
			return true;
		}
		
		return false;
	}
	
	
}
