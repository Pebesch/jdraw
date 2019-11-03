/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.figures;

import jdraw.framework.DrawContext;
import jdraw.framework.DrawTool;
import jdraw.framework.DrawView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

public class LineTool extends  AbstractDragDrawTool{
	public LineTool(DrawContext context, String name, String icon) {
		super(context, name, icon);
	}

	@Override
	protected Line createFigure(Point p) {
		return new Line(p);
	}
}
