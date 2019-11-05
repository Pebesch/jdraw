package jdraw.figures.handles;

import jdraw.framework.DrawView;
import jdraw.framework.Figure;

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
    public void dragInteraction(int x, int y, MouseEvent e, DrawView v) {
        Rectangle r = getOwner().getBounds();
        getOwner().setBounds(new Point(x,y), new Point(r.x + r.width, r.y + r.height));
        if(x > r.x + r.width) {
            swapHorizontal();
        }
        if(y > r.y + r.height) {
            swapVertical();
        }
    }

    @Override
    public HandleState getAnchor() {
        return swapHorizontal().swapVertical();
    }

    @Override
    public abstract HandleState swapHorizontal();

    @Override
    public abstract HandleState swapVertical();
}
