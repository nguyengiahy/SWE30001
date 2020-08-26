/*
 *	SWE30001, 2020
 *
 * 	cruise control interface 
 * 
 *  Code based on CruiseControl, Concurrency: State Models & Java Programs
 * 
 */

package cruise;

public interface ICruiseControl 
{
	public void engineOn();
	
	public void brake();
	
	public void engineOff();
}
