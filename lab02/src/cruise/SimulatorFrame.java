/*
 *	SWE30001, 2020
 *
 * 	Car simulator Main window (Java JFrame)
 * 
 *  Code based on CruiseControl, Concurrency: State Models & Java Programs
 * 
 */

package cruise;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class SimulatorFrame extends JFrame 
{
	private static final long serialVersionUID = 1L;
	
	CarSimulatorController fCarSimulator;
	CruiseControlController fCruiseControlSimulator;

    public SimulatorFrame( String aTitle )
    {
    	super( aTitle );
    	
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated( true );

        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        getContentPane().setLayout( new GridLayout( 1, 2, 1, 1 ) );

        fCarSimulator = new CarSimulatorController();
        fCruiseControlSimulator = new CruiseControlController( fCarSimulator );
        
        getContentPane().add( fCarSimulator );
        getContentPane().add( fCruiseControlSimulator );
        pack();
    }
}
