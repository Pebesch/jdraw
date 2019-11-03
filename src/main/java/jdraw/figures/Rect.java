/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import jdraw.figures.handles.NorthWestHandle;
import jdraw.framework.Figure;

/**
 * Represents rectangles in JDraw.
 * 
 * @author Christoph Denzler
 *
 */
public class Rect extends AbstractRectangularFigure {
	private static final long serialVersionUID = 9120181044386552132L;

	public Rect(Point point) {
		super(point);
		//addHandle(new NorthWestHandle(this));
	}

	/**
	 * Draw the rectangle to the given graphics context.
	 * @param g the graphics context to use for drawing.
	 */
	@Override
	public void draw(Graphics g) {
		Rectangle r = getBounds();
		g.setColor(Color.WHITE);
		g.fillRect(r.x, r.y, r.width, r.height);
		g.setColor(Color.BLACK);
		g.drawRect(r.x, r.y, r.width, r.height);
	}
}
