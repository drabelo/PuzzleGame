import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;


/**
 * The Class PuzzleGUI.
 * This class builds the Puzzle Game. It reads from a file, the 3 categories to start and the clues.
 */
public class PuzzleGUI {

	/** The puzzle. */
	private PuzzleMaker puzzle;

	/** The frame. */
	private JFrame frame;

	/** The panel b1. */
	private JPanel panelB1;

	/** The panel b2. */
	private JPanel panelB2;

	/** The panel b3. */
	private JPanel panelB3;

	/** The info. */
	private JPanel info;

	/** The buttons. */
	private JPanel buttons;

	/** The check answer. */
	private JButton checkAnswer;

	/** The hint. */
	private JButton hint;

	/** The reset. */
	private JButton reset;

	/** The labelx1. */
	private ArrayList<String> labelx1 = new ArrayList<String>();

	/** The labelx2. */
	private ArrayList<String> labelx2 = new ArrayList<String>();

	/** The labely1. */
	private ArrayList<String> labely1 = new ArrayList<String>();

	/** The labely2. */
	private ArrayList<String> labely2 = new ArrayList<String>();

	/**
	 * Instantiates a new puzzle gui.
	 * 
	 * @param file
	 *            the file
	 * @throws Exception
	 *             the exception
	 */
	public PuzzleGUI(String file) throws Exception {
		puzzle = new PuzzleMaker(file);
		frame = new JFrame("Puzzle");
		frame.setFont(new Font("Dialog", Font.PLAIN, 13));
		frame.setResizable(false);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setForeground(Color.ORANGE);
		frame.setSize(951, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildPanel();

		frame.setVisible(true);
	}

	/**
	 * Builds the panel.
	 */
	private void buildPanel() {

		//Builds the 3 Button Panels and fills them up with buttons
		panelB1 = new JPanel();
		panelB1.setBounds(112, 118, 274, 224);
		panelB1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelB1.setLayout(new GridLayout(4, 4, 2, 2));

		for (int i = 0; i < puzzle.board1.size(); i++) {
			panelB1.add(puzzle.board1.get(i).getButton());
		}
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panelB1);

		panelB2 = new JPanel();
		panelB2.setBounds(404, 118, 284, 224);
		panelB2.setLayout(new GridLayout(4, 4, 2, 2));
		panelB2.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(panelB2);
		for (int i = 0; i < puzzle.board2.size(); i++) {
			panelB2.add(puzzle.board2.get(i).getButton());
		}

		panelB3 = new JPanel();
		panelB3.setBounds(112, 354, 274, 210);
		panelB3.setLayout(new GridLayout(4, 4, 2, 2));
		panelB3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		frame.getContentPane().add(panelB3);
		for (int i = 0; i < puzzle.board3.size(); i++) {
			panelB3.add(puzzle.board3.get(i).getButton());
		}

		info = new JPanel();
		info.setBounds(404, 354, 286, 210);
		frame.getContentPane().add(info);
		info.setLayout(new GridLayout(0, 1, 0, 0));

		//Buttons for action such as hint, solution, and reset
		buttons = new JPanel();
		buttons.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		info.add(buttons);
		buttons.setLayout(new GridLayout(3, 1, 0, 0));

		hint = new JButton("Hint");
		hint.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg1) {
				if (puzzle.checkWon() == false) {
					System.out.println(puzzle.checkWon());
					puzzle.giveHint();
					JOptionPane.showMessageDialog(frame, "Here is your hint!");
				} else
					JOptionPane.showMessageDialog(frame, "No more hints are available!");
			}

		}

		);
		buttons.add(hint);

		checkAnswer = new JButton("Check Solution");
		checkAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (puzzle.checkWon() == true) {
					JOptionPane.showMessageDialog(frame, "You won!");
					puzzle.resetGame();
				} else {
					JOptionPane.showMessageDialog(frame, "Not yet!");

				}
			}
		});
		buttons.add(checkAnswer);

		reset = new JButton("Reset Game");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				puzzle.resetGame();
			}
		});
		buttons.add(reset);
		
		
		//Lables 
		
		for (int i = 0; i < 4; i++)
			labelx1.add(puzzle.map.get("puzzleOne").get(i));
		for (int i = 0; i < 4; i++)
			labelx2.add(puzzle.map.get("puzzleTwo").get(i));
		for (int i = 4; i < 8; i++)
			labely1.add(puzzle.map.get("puzzleOne").get(i));
		for (int i = 4; i < 8; i++)
			labely2.add(puzzle.map.get("puzzleThree").get(i));

		
		JPanel LabelX1 = new JPanel();
		LabelX1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		LabelX1.setBounds(112, 44, 274, 62);
		frame.getContentPane().add(LabelX1);
		LabelX1.setLayout(new GridLayout(0, 4, 1, 1));
		for (int i = 0; i < 4; i++)
			LabelX1.add(new JLabel(labelx1.get(i)));

		JPanel LabelX2 = new JPanel();
		LabelX2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		LabelX2.setBounds(404, 44, 284, 62);
		for (int i = 0; i < 4; i++)
			LabelX2.add(new JLabel(labelx2.get(i)));
		frame.getContentPane().add(LabelX2);
		LabelX2.setLayout(new GridLayout(0, 4, 0, 0));

		JPanel LabelY1 = new JPanel();
		LabelY1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		LabelY1.setBounds(19, 118, 78, 224);
		for (int i = 0; i < 4; i++)
			LabelY1.add(new JLabel(labely1.get(i)));
		frame.getContentPane().add(LabelY1);
		LabelY1.setLayout(new GridLayout(4, 1, 0, 0));

		JPanel LabelY2 = new JPanel();
		LabelY2.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		LabelY2.setBounds(19, 354, 81, 210);
		for (int i = 0; i < 4; i++)
			LabelY2.add(new JLabel(labely2.get(i)));

		frame.getContentPane().add(LabelY2);
		LabelY2.setLayout(new GridLayout(4, 1, 0, 0));
		JLabel lblPuzzleGame = new JLabel("Puzzle Game");
		lblPuzzleGame.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblPuzzleGame.setBounds(309, 6, 120, 16);
		frame.getContentPane().add(lblPuzzleGame);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(700, 118, 245, 446);
		frame.getContentPane().add(panel_4);

		JTextArea clues = new JTextArea();
		clues.setEditable(false);
		clues.setLineWrap(true);
		clues.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		clues.setColumns(17);
		clues.setRows(17);
		clues.setWrapStyleWord(true);
		String clue = "";
		for (int i = 0; i < puzzle.map.get("clues").size(); i++)
			clue += puzzle.map.get("clues").get(i) + "\n \n";
		clues.setText(clue);
		panel_4.add(clues);

		JLabel lblClues = new JLabel("Clues");
		lblClues.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblClues.setBounds(766, 55, 115, 51);
		frame.getContentPane().add(lblClues);
	}
	public static void main(String[] args) throws Exception {

		PuzzleGUI gui = new PuzzleGUI("Puzzle1");
	}
}