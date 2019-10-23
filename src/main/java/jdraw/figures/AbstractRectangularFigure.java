package jdraw.figures;

import java.awt.*;
import java.awt.geom.RectangularShape;

/**
 * AbstractRectangularFigure implements common methods for all rectangular-like shapes
 */
public abstract class AbstractRectangularFigure extends AbstractFigure{
    private int width, length;

    public AbstractRectangularFigure(int x, int y, int width, int length) {
        super(x, y);
        this.width = width;
        this.length = length;
    }
}
