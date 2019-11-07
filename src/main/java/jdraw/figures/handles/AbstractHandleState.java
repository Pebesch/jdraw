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
    public void dragInteraction(int x, int y, MouseEvent e, DrawView v) {
        System.out.println(getAnchor().getClass().toString());
        System.out.println("x: " + getAnchor().getOwner().getBounds().x);
        System.out.println("y: " + getAnchor().getOwner().getBounds().y);
        getOwner().setBounds(new Point(x,y), getAnchor().getLocation());
/*        if(x > getOwner().getBounds().x + getOwner().getBounds().width) {
            for(FigureHandle handle : getOwner().getHandles()) {
                ((Handle)handle).setState(swapHorizontal());
            }
        }
        if(y > getOwner().getBounds().y + getOwner().getBounds().height) {
            for(FigureHandle handle : getOwner().getHandles()) {
                ((Handle)handle).setState(swapVertical());
            }
        }*/
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
