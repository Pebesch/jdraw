package jdraw.figures;

import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Abstract class implementation for all figures.
 */
public abstract class AbstractFigure implements Figure {
    // All figures have a x, y origin point (upper-left corner)
    private int originX, originY;
    private List<FigureListener> listeners;

    public AbstractFigure(int x, int y) {
        this.listeners = new CopyOnWriteArrayList<>();
        this.originX = x;
        this.originY = y;
        notifyAllListener();
    }

    /**
     * Returns a list of 8 handles for this Rectangle.
     * @return all handles that are attached to the targeted figure.
     * @see jdraw.framework.Figure#getHandles()
     */
    @Override
    public List<FigureHandle> getHandles() {
        return null;
    }

    @Override
    public void addFigureListener(FigureListener listener) {
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
