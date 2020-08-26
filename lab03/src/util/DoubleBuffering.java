/*
 *	SWE30001, 2020
 *
 *	Double buffering
 * 
 */

package util;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class DoubleBuffering 
{
	private static boolean fIsWin = System.getProperty( "os.name" ).startsWith( "Windows" );
	
	public static boolean isWin()
	{
		return fIsWin;
	}
		
	private static Image fOffImage = null;
	private static Graphics2D fTargetGraphics = null;
	
	public static Graphics2D getGraphics( Component aComponent )
	{
		if ( fIsWin )
		{
			fOffImage = aComponent.createImage( aComponent.getWidth(), aComponent.getHeight() );
			fTargetGraphics = (Graphics2D)fOffImage.getGraphics();
		}
		else
		{
			fTargetGraphics = (Graphics2D)aComponent.getGraphics();
		}
		
		return fTargetGraphics;
	}
	
	public static void switchBuffer( Graphics g )
	{
		if ( fIsWin )
		{
	        g.drawImage( fOffImage, 0, 0, null );       	
		}
	}
}
