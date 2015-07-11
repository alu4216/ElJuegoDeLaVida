package packageprincipal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Button extends JButton implements ActionListener {


	/**
	 * Clase boton
	 */
	private static final long serialVersionUID = 1L;
	private Calculo cal;
	private int x,y;

	public Button(Calculo cal_, int i, int j)
	{
		addActionListener( this );
		setBackground(Color.DARK_GRAY);
		x=i+1;
		y=j+1;
		cal=cal_;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		int tipo = cal.introducirCel(x, y);
		if(tipo == 1)
			setBackground(Color.PINK);
		else
			 setBackground(Color.DARK_GRAY);
	}
	public void setColor(Color color) {
		setBackground(color);
	}


}
