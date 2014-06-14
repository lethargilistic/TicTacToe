import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.event.AncestorListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class XOButton extends JButton implements ActionListener {
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
		
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		choosePic++;
		choosePic %= 3;
		
		switch(choosePic)
		{
			case 0:
				setIcon(null);
				break;
			case 1:
				setIcon(X);
				break;
			case 2:
				setIcon(O);
				break;
		}
	}
}
