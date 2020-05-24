
public class Controller {
	private Model model;
	private View view;
	
	public static int STONE = 1;
	public static int PAPER = 2;
	public static int SCISSORS = 3;
	
	public Controller() {
		view = new View(this);
		view.display();
		model = new Model();
	}

	public void move(int playerSignal) {
		int opponentSignal = model.opponentMove();
		
		view.updatePlayer(playerSignal);
		view.updateOpponent(opponentSignal);
		
		if(playerSignal == opponentSignal) {
			model.setTied();
			view.updateStatus("Sin ganador");
		}else if(model.isWinner(playerSignal, opponentSignal)) {
			model.setWon();
			view.updateStatus("Ganaste");
		}else {
			model.setLost();
			view.updateStatus("Perdiste");
		}
		
	}
	
	public String score() {
		String out = "";
		
		out += "Ganados: "+model.getWon()+"\n";
		out += "Perdidos: "+model.getLost()+"\n";
		out += "Empates: "+model.getTied()+"\n";
		
		return out;
	}
	
	public static void main(String[] args) {
		new Controller();
	}
	
}
