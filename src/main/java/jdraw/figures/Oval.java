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
public class Oval extends AbstractRectangularFigure implements Figure {
	private static final long serialVersionUID = 9120181044386552132L;
	private List<FigureListener> listeners;

	/**
	 * Use the java.awt.geom.Ellipse2D.Double in order to save/reuse code.
	 */
	private final Ellipse2D.Double oval;

	/**
	 * Creates a new oval.
	 * @param x the x-coordinate of the upper left corner of the oval
	 * @param y the y-coordinate of the upper left corner of the oval
	 * @param w the oval's width
	 * @param h the oval's height
	 */
	public Oval(int x, int y, int w, int h) {
		super(x, y, w, h);
		oval = new Ellipse2D.Double(x, y, w, h);
	}

	/**
	 * Draw the oval to the given graphics context.
	 * @param g the graphics context to use for drawing.
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval((int)oval.x, (int)oval.y, (int)oval.width, (int)oval.height);
		g.setColor(Color.BLACK);
		g.drawOval((int)oval.x, (int)oval.y, (int)oval.width, (int)oval.height);
		notifyAllListener();
	}

	@Override
	public void setBounds(Point origin, Point corner) {
		oval.setFrameFromDiagonal(origin, corner);
		notifyAllListener();
	}

	/**
	 * Moves the figure by a given distance.
	 * Upon change triggers listeners.
	 * Does however not trigger if there is no change.
	 * @param dx move distance in x direction (argument in pixels)
	 * @param dy move distance in y direction (argument in pixels)
	 */
	@Override
	public void move(int dx, int dy) {
		if (!(dx == 0 && dy == 0)) {
			//oval.setFrame(oval.x + dx, oval.y + dy, oval.height, oval.width);
			oval.x += dx;
			oval.y += dy;
			notifyAllListener();
		}
	}

	@Override
	public boolean contains(int x, int y) {
		return oval.contains(x, y);
	}

	@Override
	public Rectangle getBounds() {
		return oval.getBounds();
	}
}
