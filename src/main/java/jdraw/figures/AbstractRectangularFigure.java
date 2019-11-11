package jdraw.figures;

import jdraw.figures.handles.*;
import jdraw.framework.FigureHandle;

import java.awt.*;

/**
 * AbstractRectangularFigure implements common methods for all rectangular-like shapes
 */
public abstract class AbstractRectangularFigure extends AbstractFigure {
    private final Rectangle rectangle;

    public AbstractRectangularFigure(Point origin) {
        rectangle = new Rectangle(origin);
        addHandle(new Handle(this, new NWState(this), Color.RED));
        addHandle(new Handle(this, new SWState(this), Color.BLUE));
        addHandle(new Handle(this, new NEState(this), Color.GREEN));
        addHandle(new Handle(this, new SEState(this), Color.YELLOW));
    }

    public void swapHorizontal() {
        for(FigureHandle handle : getHandles()) {
            Handle h = (Handle)handle;
            h.setState(h.getState().swapHorizontal());
        }
    }

    public void swapVertical() {
        for(FigureHandle handle : getHandles()) {
            Handle h = (Handle)handle;
            h.setState(h.getState().swapVertical());
        }
    }

    public void setBounds(Point origin, Point corner) {
        Rectangle original = new Rectangle(rectangle);
        rectangle.setFrameFromDiagonal(origin, corner);
        if(!original.equals(rectangle)) {
            notifyAllListener();
        }
    }

    public void move(int dx, int dy) {
        if (!(dx == 0 && dy == 0)) {
            rectangle.translate(dx, dy);
            notifyAllListener();
        }
    }

    public boolean contains(int x, int y) {
        return rectangle.contains(x, y);
    }

    public Rectangle getBounds() {
        return new Rectangle(rectangle);
    }
}
