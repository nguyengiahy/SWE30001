/*
 *	SWE30001, 2020
 *
 *	Tutorial 3
 * 
 */

package trafficlights;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import util.DoubleBuffering;

public class TrafficLightsCanvas extends Canvas 
{
	private static final long serialVersionUID = 1L;

	private enum State
	{
		RED,
		GREEN,
		AMBER
	}
	
	private String fDirection;
	private Font fDirectionFont;	// String font

	private State fState;			// Current state of traffic light

	public TrafficLightsCanvas( String aDirection )		// Constructor
	{ 
		super();
		
		setPreferredSize( new Dimension( 150, 400 ) );		// Set size of Canvas
		// Arial works both on Windows 10 and Mac OS X

		fDirection = aDirection;
		
		fDirectionFont = new Font( "Arial", Font.BOLD, 36 );
		
		fState = State.RED;		
	}

	public void setRed() 
	{
		fState = State.RED;
		
		repaint();
	}
	
	public void setGreen()
	{
		fState = State.GREEN;
		
		repaint();
	}
	
	public void setAmber()
	{
		fState = State.AMBER;
		
		repaint();
	}
	
	public void paint( Graphics g )
	{
		update( g );
	}

	public void update( Graphics g ) 
	{ 
		// update requires double-buffering on Windows
		Graphics2D gg = DoubleBuffering.getGraphics( this );

    	// 1. clear background
        gg.setColor( getBackground() );
        gg.fillRect( 0, 0, getWidth(), getHeight() );			// Ko lam buoc 1 nay van bthg
        
        // 2. draw direction
        gg.setFont( fDirectionFont );
        FontMetrics lFontMetrics = gg.getFontMetrics();			// Bat buoc phai setFont truoc khi goi FontMetrics
        String lDirectionString = String.valueOf( fDirection );
        
        // calculate the leftmost position for text within canvas
        int lXPos = (getWidth() - lFontMetrics.stringWidth( lDirectionString ))/2;
        // calculate baseline: 20 + ascent
        int lYPos = 20 + lFontMetrics.getAscent();
        
        gg.setColor( Color.BLACK );
        gg.drawString( lDirectionString, lXPos,  lYPos );

        // 3. draw arcs, per 100 pixels
        
        lXPos = 30;
        lYPos = 85;
        
        gg.setColor( fState == State.RED? Color.RED : Color.DARK_GRAY );
        gg.fillArc( lXPos, lYPos, 90, 90, 0, 360 );

        lYPos += 100;																		// Test +90: se bi thut len
        gg.setColor( fState == State.AMBER? Color.YELLOW : Color.DARK_GRAY );
        gg.fillArc( lXPos, lYPos, 90, 90, 0, 360 );

        lYPos += 100;
        gg.setColor( fState == State.GREEN? Color.GREEN : Color.DARK_GRAY );
        gg.fillArc( lXPos, lYPos, 90, 90, 0, 360 );
        
        // draw image: switch buffer
        DoubleBuffering.switchBuffer( g );
	}
}
