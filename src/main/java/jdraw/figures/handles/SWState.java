package jdraw.figures.handles;

import jdraw.framework.Figure;

import java.awt.*;

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
    public HandleState swapHorizontal() {
        return new NWState(getOwner());
    }

    @Override
    public HandleState swapVertical() {
        return new SEState(getOwner());
    }
}
