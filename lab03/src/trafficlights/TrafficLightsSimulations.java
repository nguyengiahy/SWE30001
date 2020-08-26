/*
 *	SWE30001, 2020
 *
 *	Tutorial 3
 * 
 */

package trafficlights;

public class TrafficLightsSimulations
{
    private static void createAndShowGUI() 
    {
    	(new IntersectionFrame( "Traffic Lights" )).setVisible( true );
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
