package counter;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CounterFrame extends JFrame
{
	private static final long serialVersionUID = 1L;

	private CounterCanvas fView;
	private JButton fIncrement;
	private JButton fDecrement;
	
	private void updateButtons()
	{
		fIncrement.setEnabled( fView.getValue() < CounterCanvas.MAX );
		fDecrement.setEnabled( fView.getValue() > 0 );
	}
	
	private void increment()
	{
		fView.increment();
		updateButtons();
	}

	private void decrement()
	{
		fView.decrement();
		updateButtons();
	}

	public CounterFrame( String aTitle )
	{
    	super( aTitle );
    	
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated( true );
		
		// align JFrame to center of screen
		setLocationRelativeTo( null ); 

        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // GridBagLayout: most flexible layout manager
        getContentPane().setLayout( new GridBagLayout() );
		GridBagConstraints lConstraints = new GridBagConstraints();

        fView = new CounterCanvas();
		lConstraints.gridx = 0;		// 1st column
		lConstraints.gridy = 0;		// 1st row
		lConstraints.gridwidth = 2;	// occupy 2 rows
        
        getContentPane().add( fView, lConstraints );
        
        fIncrement = new JButton( "Inc" );
        fIncrement.addActionListener( e -> increment() ); // use lambda expression
		lConstraints.gridx = 0;		// 1st column
		lConstraints.gridy = 1;		// 2nd row
		lConstraints.gridwidth = 1;	// occupy 1 row
		lConstraints.weightx = 0.5; // equal distribution of space between columns
        
        getContentPane().add( fIncrement, lConstraints );
        
        fDecrement = new JButton( "Dec" );
        fDecrement.addActionListener( e -> decrement() ); // use lambda expression
		lConstraints.gridx = 1;		// 2nd column
        
        getContentPane().add( fDecrement, lConstraints );
        
        pack();				// force layout manager to place GUI elements
        
		updateButtons();	// enable/disable buttons
 	}
}
