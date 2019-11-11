package jdraw.figures.handles;

import jdraw.framework.DrawView;
import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class AbstractHandleState implements HandleState {
    private final Figure owner;

    public AbstractHandleState(Figure owner) {
        this.owner = owner;
    }

    @Override
    public abstract Point getLocation();

    @Override
    public Figure getOwner() {
        return owner;
    }

    @Override
    public abstract Cursor getCursor();

    @Override
    public void dragInteraction(int x, int y, MouseEvent e, DrawView v, Point anchor) {
        getOwner().setBounds(new Point(x,y), anchor);
    }

    @Override
    public abstract HandleState getAnchor();

    @Override
    public abstract HandleState swapHorizontal();

    @Override
    public abstract HandleState swapVertical();
}
