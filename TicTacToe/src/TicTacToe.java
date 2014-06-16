import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.GridLayout;

public class TicTacToe extends JFrame
{
	private static XOButton buttons[] = new XOButton[9];
	private JPanel p = new JPanel();
	
	public TicTacToe()
	{
		super("TicTacToe");
		setSize(300,300);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		p.setLayout(new GridLayout(3,3));
		for (int nextButton = 0; nextButton < 9; nextButton++)
		{
			buttons[nextButton] = new XOButton(nextButton);
			p.add(buttons[nextButton]);
		}
		add(p);
		
		setVisible(true);
	}
	
	//Post: Returns 0 for cats' game, 1 for X win, 2 for Y win.
	public static int testWinConditions(ImageIcon X, ImageIcon O)
	{
		//Create a 2D array to make testing more intuitive
		int[][] testArray = fillTestArray(X, O);
		
		//Test rows
		for(int rowIndex = 0; rowIndex < testArray.length; rowIndex++)
		{
			if (testArray[rowIndex][0] == 1 && testArray[rowIndex][1] == 1 
					&& testArray[rowIndex][2] == 1)
			{
				return 1;
			}

			if (testArray[rowIndex][0] == 2 && testArray[rowIndex][1] == 2 
					&& testArray[rowIndex][2] == 2)
			{
				return 2;
			}
		}
		
		//Test cols
		for(int colIndex = 0; colIndex < testArray.length; colIndex++)
		{
			if (testArray[0][colIndex] == 1 && testArray[1][colIndex] == 1 
					&& testArray[2][colIndex] == 1)
			{
				return 1;
			}
			if (testArray[0][colIndex] == 2 && testArray[1][colIndex] == 2
					&& testArray[2][colIndex] == 2)
			{
				return 2;
			}
		}
		//Test diagonals
		//TopLeft to BotRight
		if (testArray[0][0] == 1 && testArray[1][1] == 1 
				&& testArray[2][2]== 1)
		{
			return 1;
		}
		if (testArray[0][0] == 2 && testArray[1][1] == 2 
				&& testArray[2][2] == 2)
		{
			return 2;
		}
		//TopRight to BotLeft
		if (testArray[0][2] == 1 && testArray[1][1] == 1 
				&& testArray[2][0] == 1)
		{
			return 1;
		}
		if (testArray[0][2] == 2 && testArray[1][1] == 2 
				&& testArray[2][0] == 2)
		{
			return 2;
		}
		
		//Cats' game
		return 0;
	}
	
	public static int[][] fillTestArray(ImageIcon X, ImageIcon O)
	{
		int testArray[][] = new int[3][3];
		
		//Fill the testArray with data from buttons
		int cellTransferring = 0;
		for(int rowIndex = 0; rowIndex < testArray.length; rowIndex++)
		{
			for(int colIndex = 0; colIndex < testArray[rowIndex].length; colIndex++)
			{
				testArray[rowIndex][colIndex] = buttons[cellTransferring].getPlayer();
				cellTransferring++;
			}
		}
		
		return testArray;
	}
}
