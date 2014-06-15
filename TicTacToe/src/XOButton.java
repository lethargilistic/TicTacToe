import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class XOButton extends JButton implements ActionListener
{
	private static boolean isPlayerOneTurn;
	
	private ImageIcon X,O;
	private byte choosePic;
	/*
	 * 0: nothing
	 * 1: X
	 * 2: O
	*/
	
	public XOButton()
	{
		X = new ImageIcon(this.getClass().getResource("x.png"));
		O = new ImageIcon(this.getClass().getResource("o.png"));
		
		isPlayerOneTurn = true;
		
		this.addActionListener(this);
	}

	public void manageTurns()
	{
		if (isPlayerOneTurn)
		{
			choosePic = 1;
			isPlayerOneTurn = false; //Move to Player Two's Turn next click
		}
		else
		{
			choosePic = 2;
			isPlayerOneTurn = true; //Move to Player One 's Turn next click
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		manageTurns();

		switch(choosePic)
		{
			case 0:
				setIcon(null);
				break;
			case 1:
				setIcon(X);
				setEnabled(false);
				break;
			case 2:
				setIcon(O);
				setEnabled(false);
				break;
		}
	}
}
