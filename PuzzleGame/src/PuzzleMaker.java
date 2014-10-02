import java.util.ArrayList;
import java.util.Map;
import java.util.Random;


/**
 * The Class PuzzleMaker.
 */
public class PuzzleMaker {

	/** The board1.
	 * Holds the puzzle pieces for board1
	 */
	protected ArrayList<PuzzlePiece> board1;
	/** The board2. 
	 * Holds the puzzle pieces for board2
	 */
	protected ArrayList<PuzzlePiece> board2;
	/** The board3.
	 * Holds the puzzle pieces for board3 */
	protected ArrayList<PuzzlePiece> board3;
	/** The map holding the 3 panel info and clues for the game. */
	protected Map<String, ArrayList<String>> map;

	/**
	 * Instantiates a new puzzle maker.
	 * 
	 * @param file
	 *            the file
	 * @throws Exception
	 *             the exception
	 */
	public PuzzleMaker(String file) throws Exception {
		map = FileLoader.loadPuzzle(file);
		createBoard();
	}

	/**
	 * Creates the board. Initializes all the boards will puzzle pieces. Uses the map to turn strings into puzzle pieces.
	 */
	public void createBoard() {
		board1 = new ArrayList<PuzzlePiece>();
		board2 = new ArrayList<PuzzlePiece>();
		board3 = new ArrayList<PuzzlePiece>();

		for (int x = 0; x <= 3; x++) {
			for (int y = 4; y <= 7; y++) {
				board1.add(new PuzzlePiece(map.get("puzzleOne").get(x), map
						.get("puzzleOne").get(y)));
				board2.add(new PuzzlePiece(map.get("puzzleTwo").get(x), map
						.get("puzzleTwo").get(y)));
				board3.add(new PuzzlePiece(map.get("puzzleThree").get(x), map
						.get("puzzleThree").get(y)));

			}
		}

	}

	/**
	 * Check to see if all the activated cells are the right ones.
	 * 
	 * @return true, if successful
	 */
	public boolean checkWon() {
		boolean status = true;
		if (board1.get(Integer.parseInt(map.get("puzzleOne").get(8)))
				.isActivated() == true
				&& board1.get(Integer.parseInt(map.get("puzzleOne").get(9)))
						.isActivated() == true
				&& board1.get(Integer.parseInt(map.get("puzzleOne").get(10)))
						.isActivated() == true
				&& board1.get(Integer.parseInt(map.get("puzzleOne").get(11)))
						.isActivated() == true
				&& board2.get(Integer.parseInt(map.get("puzzleTwo").get(8)))
						.isActivated() == true
				&& board2.get(Integer.parseInt(map.get("puzzleTwo").get(9)))
						.isActivated() == true
				&& board2.get(Integer.parseInt(map.get("puzzleTwo").get(10)))
						.isActivated() == true
				&& board2.get(Integer.parseInt(map.get("puzzleTwo").get(11)))
						.isActivated() == true
				&& board3.get(Integer.parseInt(map.get("puzzleThree").get(8)))
						.isActivated() == true
				&& board3.get(Integer.parseInt(map.get("puzzleThree").get(9)))
						.isActivated() == true
				&& board3.get(Integer.parseInt(map.get("puzzleThree").get(10)))
						.isActivated() == true
				&& board3.get(Integer.parseInt(map.get("puzzleThree").get(11)))
						.isActivated() == true)
			status = true;
		else
			status = false;

		return status;
	}

	/**
	 * Creates a random number between 1-12. Using that number, it finds that slot and marks it to true.
	 * Makes it so there is a random hint every time and not linear.
	 */

	public void giveHint() {
		int status = 0;
		Random rand = new Random();
		int random;
			while (status == 0) {
				random = (rand.nextInt(13));
				switch (random) {
				case 1:
					if (board1.get(
							(Integer.parseInt(map.get("puzzleOne").get(8))))
							.isActivated() == false) {
						board1.get(
								(Integer.parseInt(map.get("puzzleOne").get(8))))
								.toggleBttn();
						status++;
					}
					break;
				case 2:
					if (board1.get(
							(Integer.parseInt(map.get("puzzleOne").get(9))))
							.isActivated() == false) {
						board1.get(
								(Integer.parseInt(map.get("puzzleOne").get(9))))
								.toggleBttn();
						status++;
					}

					break;
				case 3:
					if (board1.get(
							(Integer.parseInt(map.get("puzzleOne").get(10))))
							.isActivated() == false) {
						board1.get(
								(Integer.parseInt(map.get("puzzleOne").get(10))))
								.toggleBttn();
						status++;
					}

					break;
				case 4:
					if (board1.get(
							(Integer.parseInt(map.get("puzzleOne").get(11))))
							.isActivated() == false) {
						board1.get(
								(Integer.parseInt(map.get("puzzleOne").get(11))))
								.toggleBttn();
						status++;
					}

					break;
				case 5:
					if (board2.get(
							(Integer.parseInt(map.get("puzzleTwo").get(8))))
							.isActivated() == false) {
						board2.get(
								(Integer.parseInt(map.get("puzzleTwo").get(8))))
								.toggleBttn();
						status++;
					}

					break;
				case 6:
					if (board2.get(
							(Integer.parseInt(map.get("puzzleTwo").get(9))))
							.isActivated() == false) {
						board2.get(
								(Integer.parseInt(map.get("puzzleTwo").get(9))))
								.toggleBttn();
						status++;
					}

					break;
				case 7:
					if (board2.get(
							(Integer.parseInt(map.get("puzzleTwo").get(10))))
							.isActivated() == false) {
						board2.get(
								(Integer.parseInt(map.get("puzzleTwo").get(10))))
								.toggleBttn();
						status++;
					}

					break;
				case 8:
					if (board2.get(
							(Integer.parseInt(map.get("puzzleTwo").get(11))))
							.isActivated() == false) {
						board2.get(
								(Integer.parseInt(map.get("puzzleTwo").get(11))))
								.toggleBttn();
						status++;
					}

					break;
				case 9:
					if (board3.get(
							(Integer.parseInt(map.get("puzzleThree").get(8))))
							.isActivated() == false) {
						board3.get(
								(Integer.parseInt(map.get("puzzleThree").get(8))))
								.toggleBttn();
						status++;
					}

					break;
				case 10:
					if (board3.get(
							(Integer.parseInt(map.get("puzzleThree").get(9))))
							.isActivated() == false) {
						board3.get(
								(Integer.parseInt(map.get("puzzleThree").get(9))))
								.toggleBttn();
						status++;
					}

					break;
				case 11:
					if (board3.get(
							(Integer.parseInt(map.get("puzzleThree").get(10))))
							.isActivated() == false) {
						board3.get(
								(Integer.parseInt(map.get("puzzleThree")
										.get(10)))).toggleBttn();
						status++;
					}

					break;
				case 12:
					if (board3.get(
							(Integer.parseInt(map.get("puzzleThree").get(11))))
							.isActivated() == false) {
						board3.get(
								(Integer.parseInt(map.get("puzzleThree")
										.get(11)))).toggleBttn();
						status++;
					}
					break;
				default:
					break;
				}
			}

	}

	/**
	 * Reset game.
	 */
	public void resetGame() {
		for (int i = 0; i < board1.size(); i++) {
			board1.get(i).resetBttn();
			board2.get(i).resetBttn();
			board3.get(i).resetBttn();
		}
	}
}
