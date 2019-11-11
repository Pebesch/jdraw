package jdraw.figures.handles;

import jdraw.framework.DrawView;
import jdraw.framework.Figure;

import java.awt.*;
import java.awt.event.MouseEvent;

public interface HandleState {
    public Figure getOwner();
    public Point getLocation();
    public HandleState getAnchor();
    public abstract Cursor getCursor();
    public abstract void dragInteraction(int x, int y, MouseEvent e, DrawView v, Point anchor);
    public HandleState swapHorizontal();
    public HandleState swapVertical();
}
