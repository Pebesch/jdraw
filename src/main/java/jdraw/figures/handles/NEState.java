package jdraw.figures.handles;

import jdraw.figures.AbstractRectangularFigure;
import jdraw.framework.DrawView;
import jdraw.framework.Figure;

import java.awt.*;
import java.awt.event.MouseEvent;

public class NEState extends AbstractHandleState {

    public NEState(Figure owner) {
        super(owner);
    }

    @Override
    public Point getLocation() {
        return new Point(getOwner().getBounds().x + getOwner().getBounds().width, getOwner().getBounds().y);
    }

    @Override
    public Cursor getCursor() {
        return Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);
    }

    @Override
    public HandleState getAnchor() { return new SWState(getOwner()); }

    @Override
    public void dragInteraction(int x, int y, MouseEvent e, DrawView v, Point anchor) {
        super.dragInteraction(x, y, e, v, anchor);
        if(x == (getOwner().getBounds().x)) {
            ((AbstractRectangularFigure)getOwner()).swapHorizontal();
        }
        if(y == (getOwner().getBounds().y + getOwner().getBounds().height)) {
            ((AbstractRectangularFigure)getOwner()).swapVertical();
        }
    }

    @Override
    public HandleState swapHorizontal() {
        return new NWState(getOwner());
    }

    @Override
    public HandleState swapVertical() {
        return new SEState(getOwner());
    }
}
