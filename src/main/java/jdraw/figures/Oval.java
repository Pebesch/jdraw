/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.figures;

import jdraw.framework.Figure;
import jdraw.framework.FigureListener;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.List;

/**
 * Represents ovals in JDraw.
 * 
 * @author Peter Schmucki
 *
 */
public class Oval extends AbstractRectangularFigure {
	private static final long serialVersionUID = 9120181044386552132L;

	public Oval(Point p) {
		super(p);
	}

	/**
	 * Draw the oval to the given graphics context.
	 * @param g the graphics context to use for drawing.
	 */
	@Override
	public void draw(Graphics g) {
		Rectangle oval = getBounds();
		g.setColor(Color.WHITE);
		g.fillOval((int)oval.x, (int)oval.y, (int)oval.width, (int)oval.height);
		g.setColor(Color.BLACK);
		g.drawOval((int)oval.x, (int)oval.y, (int)oval.width, (int)oval.height);
		notifyAllListener();
	}

	@Override
	public boolean contains(int x, int y) {
		Rectangle oval = getBounds();
		return oval.contains(x, y);
	}

}
