package jdraw.figures;

import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Abstract class implementation for all figures.
 */
public abstract class AbstractFigure implements Figure {
    private final List<FigureListener> listeners = new CopyOnWriteArrayList();
    private final List<FigureHandle> handles = new LinkedList<>();

    /**
     * Returns a list of 8 handles for this Rectangle.
     * @return all handles that are attached to the targeted figure.
     * @see jdraw.framework.Figure#getHandles()
     */
    @Override
    public List<FigureHandle> getHandles() {
        return handles;
    }

    public void addHandle(FigureHandle handle) {
        if(handle != null && !handles.contains(handle)) {
            this.handles.add(handle);
        }
    }

    @Override
    public void addFigureListener(FigureListener listener) {
        if(listener != null && !listeners.contains(listener))
            listeners.add(listener);
    }

    @Override
    public void removeFigureListener(FigureListener listener) {
        listeners.remove(listener);
    }

    @Override
    public Figure clone() {
        return null;
    }

    /**
     * Notifies all listener of a Figure change event.
     */
    protected void notifyAllListener() {
        listeners.forEach(l -> l.figureChanged(new FigureEvent(this)));
    }
}
