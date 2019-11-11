package jdraw.figures.handles;

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
    public HandleState swapHorizontal() {
        return new SEState(getOwner());
    }

    @Override
    public HandleState swapVertical() {
        return new NWState(getOwner());
    }
}
