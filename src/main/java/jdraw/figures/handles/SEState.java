package jdraw.figures.handles;

import jdraw.figures.AbstractRectangularFigure;
import jdraw.framework.DrawView;
import jdraw.framework.Figure;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SEState extends AbstractHandleState {

    public SEState(Figure owner) {
        super(owner);
    }

    @Override
    public Point getLocation() {
        return new Point(getOwner().getBounds().x + getOwner().getBounds().width, getOwner().getBounds().y + getOwner().getBounds().height);
    }

    @Override
    public Cursor getCursor() {
        return Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);
    }

    @Override
    public HandleState getAnchor() { return new NWState(getOwner()); }

    @Override
    public void dragInteraction(int x, int y, MouseEvent e, DrawView v, Point anchor) {
        super.dragInteraction(x, y, e, v, anchor);
        if(x == (getOwner().getBounds().x)) {
            ((AbstractRectangularFigure)getOwner()).swapHorizontal();
        }
        if(y == (getOwner().getBounds().y)) {
            ((AbstractRectangularFigure)getOwner()).swapVertical();
        }
    }

    @Override
    public HandleState swapHorizontal() {
        return new SWState(getOwner());
    }

    @Override
    public HandleState swapVertical() {
        return new NEState(getOwner());
    }
}
