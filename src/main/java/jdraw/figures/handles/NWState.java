package jdraw.figures.handles;

import jdraw.figures.AbstractRectangularFigure;
import jdraw.framework.DrawView;
import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;

import java.awt.*;
import java.awt.event.MouseEvent;

public class NWState extends AbstractHandleState {

    public NWState(Figure owner) {
        super(owner);
    }

    @Override
    public Point getLocation() {
        return new Point(getOwner().getBounds().x, getOwner().getBounds().y);
    }

    @Override
    public Cursor getCursor() {
        return Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);
    }

    @Override
    public HandleState getAnchor() { return new SEState(getOwner()); }

    @Override
    public void dragInteraction(int x, int y, MouseEvent e, DrawView v, Point anchor) {
        super.dragInteraction(x, y, e, v, anchor);
        if(x == (getOwner().getBounds().x + getOwner().getBounds().width)) {
            ((AbstractRectangularFigure)getOwner()).swapHorizontal();
        }
        if(y == (getOwner().getBounds().y + getOwner().getBounds().height)) {
            ((AbstractRectangularFigure)getOwner()).swapVertical();
        }
    }

    @Override
    public HandleState swapHorizontal() {
        return new NEState(getOwner());
    }

    @Override
    public HandleState swapVertical() {
        return new SWState(getOwner());
    }
}
