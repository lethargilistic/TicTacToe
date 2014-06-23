import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class XOButton extends JButton implements ActionListener
{
	private static boolean isPlayerXTurn;		//true: X player's turn, false: Y player's turn. Needs to be known by all objects to dermine who is clicking.
	private static int numClicks;				//How many of the cells that have been clicked. Static because all need to know status of the board.
	
	private ImageIcon X,O, winX, winO;			//Data for the pictures marking player moves
	private int whichPlayerClicked;			//Store which player clicked each object within each object.
	/*
	 * 0: nothing
	 * 1: X
	 * 2: O
	*/
	
	public XOButton()
	{
		setIcon(null);
		
		X = new ImageIcon(this.getClass().getResource("x.png"));
		O = new ImageIcon(this.getClass().getResource("o.png"));
		
		numClicks = 0;
		isPlayerXTurn = true;
		
		addActionListener(this);
	}

	private static void resetNumClicks()
	{
		numClicks = 0;
	}

	private void setTurn(boolean trueForPlayerX)
	{
		isPlayerXTurn = trueForPlayerX;
	}
	
	//Parameterized Constructor
	public XOButton(ImageIcon otherX, ImageIcon otherO, int otherWhichPlayerClicked)
	{
		X = new ImageIcon(otherX.getImage());
		O = new ImageIcon(otherO.getImage());
		
		whichPlayerClicked = otherWhichPlayerClicked; 
		
		addActionListener(this);
	}
	
	public XOButton setWhichPlayerClicked(int newWhichPlayerClicked)
	{
		return new XOButton(X, O, newWhichPlayerClicked);
	}
	
	public void manageTurns()
	{		
		if (isPlayerXTurn)
		{
			setTurn(false); //Move to Player O's Turn next click
		}
		else
		{
			setTurn(true);  //Move to Player X's Turn next click
		}
	}
	
	public int getWhichPlayerClicked()
	{
		return whichPlayerClicked;
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
		
		int result = TicTacToe.testWinConditions(X, O);
		
		if (result != 0 || numClicks == 9)
		{
			resetNumClicks();
			setTurn(true);				//Make sure the next game starts with X as first player.
			TicTacToe.endGame(result);	//A static method because all of the XOButtons have to be managed,
		}
		else
		{
			manageTurns();
		}
	}
}
