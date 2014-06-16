import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class XOButton extends JButton implements ActionListener
{
	private static boolean isPlayerXTurn;		//true: X player's turn, false: Y player's turn. Needs to be known by all objects to dermine who is clicking.
	private static int numClicks;				//How many of the cells that have been clicked. Static because all need to know status of the board.
	
	private ImageIcon X,O;						//Data for the pictures marking player moves
	private int whichPlayerClicked;			//Store which player clicked each object within each object.
	/*
	 * 0: nothing
	 * 1: X
	 * 2: O
	*/
	private int positionOnBoard; //1-3:first row, 2-6: second row, 7-9: third row (all left to right)
	
	public XOButton(int positionOnBoard)
	{
		setIcon(null);
		
		X = new ImageIcon(this.getClass().getResource("x.png"));
		O = new ImageIcon(this.getClass().getResource("o.png"));
		
		numClicks = 0;
		isPlayerXTurn = true;
		this.positionOnBoard = positionOnBoard;
		
		addActionListener(this);
	}

	public void manageTurns()
	{		
		if (isPlayerXTurn)
		{
			isPlayerXTurn = false; //Move to Player O's Turn next click
		}
		else
		{
			isPlayerXTurn = true; //Move to Player X's Turn next click
		}
	}
	
	public int testWinConditions(ImageIcon X, ImageIcon O)
	{
		return TicTacToe.testWinConditions(X, O);
	}
	
	public int getPlayer()
	{
		return whichPlayerClicked;
	}
	
	public void endGame(int result)
	{
		switch(result)
		{
			case 0:
				System.out.print("Cats game!");
				break;
			case 1:
				System.out.print("X Wins!");
				break;
			case 2:
				System.out.print("O Wins!");
				break;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		numClicks++;
		
		if (isPlayerXTurn)
		{
				setIcon(X);
				whichPlayerClicked = 1;
				setEnabled(false);
		}
		else
		{
				setIcon(O);
				whichPlayerClicked = 2;
				setEnabled(false);
		}
		
		int result = testWinConditions(X, O);
		
		if (result != 0 || numClicks == 9)
		{
			endGame(result);
			//TODO: Show a pop-up that whoever won won
			//TODO: Reset board.
		}
		
		manageTurns();
	}
}
