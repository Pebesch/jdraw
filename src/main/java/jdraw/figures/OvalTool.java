/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.figures;

import jdraw.framework.DrawContext;
import jdraw.framework.DrawTool;
import jdraw.framework.DrawView;
import jdraw.framework.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * This tool defines a mode for drawing rectangles.
 *
 * @see jdraw.framework.Figure
 *
 * @author  Peter Schmucki
 */
public class OvalTool extends AbstractDragDrawTool {
	public OvalTool(DrawContext context, String name, String icon) {
		super(context, name, icon);
	}

	@Override
	protected Oval createFigure(Point p) {
		return new Oval(p);
	}
}
