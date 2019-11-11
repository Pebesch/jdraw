package jdraw.figures.handles;

import jdraw.figures.AbstractRectangularFigure;
import jdraw.framework.DrawView;
import jdraw.framework.Figure;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SWState extends AbstractHandleState {

    public SWState(Figure owner) {
        super(owner);
    }

    @Override
    public Point getLocation() {
        return new Point(getOwner().getBounds().x, getOwner().getBounds().y + getOwner().getBounds().height);
    }

    @Override
    public Cursor getCursor() {
        return Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);
    }

    @Override
    public HandleState getAnchor() { return new NEState(getOwner()); }

    @Override
    public void dragInteraction(int x, int y, MouseEvent e, DrawView v, Point anchor) {
        super.dragInteraction(x, y, e, v, anchor);
        if(x == (getOwner().getBounds().x + getOwner().getBounds().width)) {
            ((AbstractRectangularFigure)getOwner()).swapHorizontal();
        }
        if(y == (getOwner().getBounds().y)) {
            ((AbstractRectangularFigure)getOwner()).swapVertical();
        }
    }

    @Override
    public HandleState swapHorizontal() {
        return new SEState(getOwner());
    }

    @Override
    public HandleState swapVertical() {
        return new NWState(getOwner());
    }
}
