/*
 *	SWE30001, 2020
 *
 * 	Car simulator 
 * 
 *  Code based on CruiseControl, Concurrency: State Models & Java Programs
 * 
 */

package cruise;

public class Simulator
{
    private static void createAndShowGUI() 
    {
    	SimulatorFrame lFrame = new SimulatorFrame( "Cruise Control Simulator" );
    	
    	lFrame.setVisible( true );
    }

    public static void main(String[] args) 
    {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
