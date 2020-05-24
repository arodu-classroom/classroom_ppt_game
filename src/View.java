import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View implements ActionListener{
	
	private Controller controller;
	
	private JFrame window;
	private JButton stone, paper, scissors;
	private JLabel player, opponent, status;
	private JMenuItem exit, score;
	
	public View(Controller controller) {
		this.controller = controller;
	}
	
	void display(){
		window = new JFrame();
		window.setLayout(new BorderLayout());
		
		window.add(this.menu(), BorderLayout.NORTH);
		
		window.add(this.board(), BorderLayout.CENTER);
		
		JPanel south = new JPanel();
		window.add(south, BorderLayout.SOUTH);
		
		this.status = new JLabel(" ");
		south.add(status);
		
		window.setTitle("piedra, papel o tijera");
		window.setSize(260, 300);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
	
	protected JMenuBar menu() {
		JMenuBar bar = new JMenuBar();
		
		JMenu game = new JMenu("Juego");
		bar.add(game);

		score = new JMenuItem("Puntaje...");
		score.addActionListener(this);
		game.add(score);
		
		exit = new JMenuItem("Salir");
		exit.addActionListener(this);
		game.add(exit);
		
		return bar;
	}
	
	protected JPanel board() {
		JPanel center = new JPanel(new GridLayout(4,1));
		
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		center.add(buttons);
		
		this.stone = new JButton(text(Controller.STONE));
		stone.addActionListener(this);
		buttons.add(this.stone);
		
		this.paper = new JButton(text(Controller.PAPER));
		paper.addActionListener(this);
		buttons.add(this.paper);
		
		this.scissors = new JButton(text(Controller.SCISSORS));
		scissors.addActionListener(this);
		buttons.add(this.scissors);
		
		this.player = new JLabel("Jugador");
		player.setHorizontalAlignment( SwingConstants.CENTER );
		player.setFont(new Font("Arial", Font.BOLD, 30));
		center.add(player);
		
		JLabel vs = new JLabel("vs");
		vs.setHorizontalAlignment(SwingConstants.CENTER);
		center.add(vs);
		
		this.opponent = new JLabel("Oponente");
		opponent.setHorizontalAlignment(SwingConstants.CENTER);
		opponent.setFont(new Font("Arial", Font.BOLD, 30));
		center.add(opponent);
		
		return center;
	}

	public void updatePlayer(int signal) {
		player.setText(text(signal));
	}

	public void updateOpponent(int signal) {
		opponent.setText(text(signal));
	}
	
	public void updateStatus(String text) {
		status.setText(text);
	}
	
	public String text(int signal) {
		if(signal == Controller.STONE) {
			return "Piedra";
		}
		if(signal == Controller.PAPER) {
			return "Papel";
		}
		if(signal == Controller.SCISSORS) {
			return "Tijera";
		}
		return null;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(stone)) {
			controller.move(Controller.STONE);
		}
		if(arg0.getSource().equals(paper)) {
			controller.move(Controller.PAPER);
		}
		if(arg0.getSource().equals(scissors)) {
			controller.move(Controller.SCISSORS);
		}
		
		if(arg0.getSource().equals(score)) {
			JOptionPane.showMessageDialog(window, controller.score(), "piedra, papel o tijera", JOptionPane.CLOSED_OPTION);
		}
		
		if(arg0.getSource().equals(exit)) {
			if(JOptionPane.showConfirmDialog(window, "¿Esta seguro que desea salir?","piedra, papel o tijera", JOptionPane.YES_NO_OPTION) == 0) {
				System.exit(0);
			}
		}
	}
	
}

