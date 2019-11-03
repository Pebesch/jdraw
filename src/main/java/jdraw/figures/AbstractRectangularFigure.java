package jdraw.figures;

import java.awt.*;
import java.awt.geom.RectangularShape;

/**
 * AbstractRectangularFigure implements common methods for all rectangular-like shapes
 */
public abstract class AbstractRectangularFigure extends AbstractFigure {
    private final Rectangle rectangle;

    public AbstractRectangularFigure(Point origin) {
        rectangle = new Rectangle(origin);
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
