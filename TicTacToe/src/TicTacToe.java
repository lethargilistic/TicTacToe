import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Component;
import java.awt.GridLayout;

public class TicTacToe extends JFrame
{
	private JPanel p = new JPanel();
	private XOButton buttons[] = new XOButton[9];
	
	public TicTacToe()
	{
		super("TicTacToe");
		setSize(300,300);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		p.setLayout(new GridLayout(3,3));
		for (int nextButton = 0; nextButton < 9; nextButton++)
		{
			buttons[nextButton] = new XOButton();
			p.add(buttons[nextButton]);
		}
		add(p);
		
		setVisible(true);	
	}
	
	public static void main(String[] args)
	{
		new TicTacToe();
	}
}
