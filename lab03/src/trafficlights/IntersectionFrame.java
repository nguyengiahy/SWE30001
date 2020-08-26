/*
  *	SWE30001, 2020
 *
 *	Tutorial 3
 * 
 */

package trafficlights;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class IntersectionFrame extends JFrame implements Runnable
{
	private static final long serialVersionUID = 1L;

	private TrafficLightsCanvas fEast;
	private TrafficLightsCanvas fNorth;
	private JButton fStart;
	private Thread fController;
	
	private void animate()
	  {
	    fController = new Thread( this );
	    fController.start();
	  }
		
	  public void run() // animation thread function
	  {
	    try
	    {
	      synchronized (this)
	      {
	        while ( fController != null )
	        {
	          // cycle twice (per direction) through traffic lights stages
	          // transition from red to green delayed by 0.5s
	          // green for 4s
	          // amber for 1s
	          // use Thread.sleep( millis ) to pause the animation thread
	          Thread.sleep( 500 );
	          fNorth.setGreen();
	          Thread.sleep( 4000 );
	          fNorth.setAmber();
	          Thread.sleep( 1000 );
	          fNorth.setRed();
	          Thread.sleep( 500 );
	          fEast.setGreen();
	          Thread.sleep( 4000 );
	          fEast.setAmber();
	          Thread.sleep( 1000 );
	          fEast.setRed();
	        }
	      }
	    }
	    catch ( InterruptedException e )
	    {}
	  }

	public IntersectionFrame( String aTitle )
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

        fEast = new TrafficLightsCanvas( "East" );
		lConstraints.gridx = 0;		// 1st column
		lConstraints.gridy = 0;		// 1st row
		lConstraints.gridwidth = 1;	// occupy 1 column
        
        getContentPane().add( fEast, lConstraints );

        fNorth = new TrafficLightsCanvas( "North" );
		lConstraints.gridx = 1;		// 2nd column
		lConstraints.gridy = 0;		// 1st row
		lConstraints.gridwidth = 1;	// occupy 1 column
        
        getContentPane().add( fNorth, lConstraints );
        
        fStart = new JButton( "Start" );
        fStart.addActionListener( e -> animate() ); // use lambda expression
		lConstraints.gridx = 0;		// 1st column
		lConstraints.gridy = 1;		// 1st row
		lConstraints.gridwidth = 2;	// occupy 2 columns
		lConstraints.fill = GridBagConstraints.HORIZONTAL;
        
        getContentPane().add( fStart, lConstraints );
        
        pack();				// force layout manager to place GUI elements
 	}
}
