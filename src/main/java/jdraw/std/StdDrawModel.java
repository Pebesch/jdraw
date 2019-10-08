/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.std;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

import jdraw.framework.*;

/**
 * Provide a standard behavior for the drawing model. This class initially does not implement the methods
 * in a proper way.
 * It is part of the course assignments to do so.
 * @author Peter Schmucki
 *
 */
public class StdDrawModel implements DrawModel, FigureListener {
	private List<Figure> figures;
	private List<DrawModelListener> listeners;

	public StdDrawModel() {
		figures = new CopyOnWriteArrayList<>();
		listeners = new CopyOnWriteArrayList<>();
	}

	@Override
	public void addFigure(Figure f) {
		if(!figures.contains(f)) {
			f.addFigureListener(this);
			figures.add(f);
			listeners.forEach(l -> l.modelChanged(new DrawModelEvent(this, f, DrawModelEvent.Type.FIGURE_ADDED)));
		}
	}

	@Override
	public Stream<Figure> getFigures() {
		return figures.stream();
	}

	@Override
	public void removeFigure(Figure f) {
		if(figures.contains(f)) {
			f.removeFigureListener(this);
			figures.remove(f);
			listeners.forEach(l -> l.modelChanged(new DrawModelEvent(this, f, DrawModelEvent.Type.FIGURE_REMOVED)));
		}
	}

	@Override
	public void addModelChangeListener(DrawModelListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removeModelChangeListener(DrawModelListener listener) {
		listeners.remove(listener);
	}

	/** The draw command handler. Initialized here with a dummy implementation. */
	// TODO initialize with your implementation of the undo/redo-assignment.
	private DrawCommandHandler handler = new EmptyDrawCommandHandler();

	/**
	 * Retrieve the draw command handler in use.
	 * @return the draw command handler.
	 */
	@Override
	public DrawCommandHandler getDrawCommandHandler() {
		return handler;
	}

	@Override
	public void setFigureIndex(Figure f, int index) {
		if(!figures.contains(f))
			throw new IllegalArgumentException();
		Figure oldFigureAtIndex = figures.set(index, f);
		for(int i = index + 1; i < figures.size(); i++) {
			oldFigureAtIndex = figures.set(i, oldFigureAtIndex);
		}
		listeners.forEach(l -> l.modelChanged(new DrawModelEvent(this, f, DrawModelEvent.Type.DRAWING_CHANGED)));
	}

	@Override
	public void removeAllFigures() {
		for (Figure f : figures) {
			removeFigure(f);
			listeners.forEach(l -> l.modelChanged(new DrawModelEvent(this, f, DrawModelEvent.Type.DRAWING_CLEARED)));
		}
	}

	@Override
	public void figureChanged(FigureEvent e) {
		Figure f = e.getFigure();
		listeners.forEach(l -> l.modelChanged(new DrawModelEvent(this, f, DrawModelEvent.Type.FIGURE_CHANGED)));
	}
}
