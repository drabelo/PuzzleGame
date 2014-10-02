import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * The Class PuzzlePiece.
 */
public class PuzzlePiece {

	/** The button. */
	private JButton button;
	
	/** The category x. */
	private String categoryX;
	
	/** The category y. */
	private String categoryY;
	
	/** The activated. */
	private boolean activated;
	
	/** The label x. */
	private JLabel labelX = new JLabel();
	
	/** The label y. */
	private JLabel labelY = new JLabel();;

	/**
	 * Instantiates a new puzzle piece.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public PuzzlePiece(String x, String y) {
		button = new JButton("0");
		button.addActionListener(new ButtonListener());
		button.setOpaque(true);
		button.setBackground(Color.red);
		categoryX = x;
		categoryY = y;
		activated = false;
		labelX.setText(x);
		labelY.setText(y);
	}

	/**
	 * Instantiates a new puzzle piece.
	 */
	public PuzzlePiece() {
		categoryX = "";
		categoryY = "";
		activated = false;
	}

	/**
	 * Toggle bttn.
	 */
	public void toggleBttn() {
		if (button.getText() == "0") {
			button.setText("X");
			button.setBackground(Color.GREEN);
			activated = true;
		} else {
			button.setText("0");
			button.setBackground(Color.red);
			activated = false;
		}
	}
	
	/**
	 * Reset bttn.
	 */
	public void resetBttn(){
		button.setText("0");
		button.setBackground(Color.red);
		activated = false;
	}

	/**
	 * Gets the button.
	 *
	 * @return the button
	 */
	public JButton getButton() {
		return button;
	}
	
	/**
	 * Gets the label.
	 *
	 * @param choice the choice
	 * @return the label
	 */
	public JLabel getLabel(String choice){
		JLabel status = new JLabel();
		if(choice.equals("x")){
			status.setText(labelX.getText());
		}
		if(choice.equals("y")){
			status.setText(labelY.getText());
		}
		return status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return categoryX + categoryY + activated;
	}

	/**
	 * The listener interface for receiving button events.
	 * The class that is interested in processing a button
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addButtonListener<code> method. When
	 * the button event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see ButtonEvent
	 */
	class ButtonListener implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				toggleBttn();
			} catch (Exception b) {
				System.out.println(b.getMessage());
			}
		}
	}

	/**
	 * Checks if is activated.
	 *
	 * @return the activated
	 */
	public boolean isActivated() {
		return activated;
	}

	/**
	 * Sets the activated.
	 *
	 * @param activated the activated to set
	 */
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
}
