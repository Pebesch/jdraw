package jdraw.figures.handles;

import jdraw.framework.DrawView;
import jdraw.framework.Figure;

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
    public HandleState swapHorizontal() {
        return new SWState(getOwner());
    }

    @Override
    public HandleState swapVertical() {
        return new NEState(getOwner());
    }
}
