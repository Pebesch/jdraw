package jdraw.figures;

import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Line implements Figure {
    private static final long serialVersionUID = 0;
    private List<FigureListener> listeners;

    /**
     * Use the java.awt.Rectangle in order to save/reuse code.
     */
    private final Line2D.Double line;

    /**
     * Create a new Line with the specified coordinates
     * @param x1 x origin
     * @param y1 y origin
     * @param x2 x destination
     * @param y2 y destination
     */
    public Line(int x1, int y1, int x2, int y2) {
        this.listeners = new CopyOnWriteArrayList<>();
        line = new Line2D.Double(x1, y1, x2, y2);
        notifyAllListener();
    }

    /**
     * Draw the Line to the given graphics context.
     * @param g the graphics context to use for drawing.
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine((int)line.x1, (int)line.y1, (int)line.x2, (int)line.y2);
        notifyAllListener();
    }

    @Override
    public void setBounds(Point origin, Point corner) {
        line.setLine(origin, corner);
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
            line.setLine(line.x1 + dx, line.y1 + dx, line.x2 + dx, line.y2 + dx);
            notifyAllListener();
        }
    }

    @Override
    public boolean contains(int x, int y) {
        return line.contains(x, y);
    }

    @Override
    public Rectangle getBounds() {
        return line.getBounds();
    }

    /**
     * Returns a list of 8 handles of the line
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
    private void notifyAllListener() {
        listeners.forEach(l -> l.figureChanged(new FigureEvent(this)));
    }
}