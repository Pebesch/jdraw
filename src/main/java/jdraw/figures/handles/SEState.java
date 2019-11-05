package jdraw.figures.handles;

import jdraw.framework.Figure;

import java.awt.*;

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
    public HandleState swapHorizontal() {
        return new NEState(getOwner());
    }

    @Override
    public HandleState swapVertical() {
        return new SWState(getOwner());
    }
}
