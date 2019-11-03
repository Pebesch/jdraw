package jdraw.figures;

import jdraw.framework.Figure;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Line extends AbstractFigure {
    private static final long serialVersionUID = 0;
    private Point origin, corner;
    private Line2D line;

    public Line(Point origin) {
        this.origin = origin;
        line = new Line2D.Double(origin, origin);
    }

    /**
     * Draw the Line to the given graphics context.
     * @param g the graphics context to use for drawing.
     */
    @Override
    public void draw(Graphics g) {
        if(corner != null) {
            g.setColor(Color.BLACK);
            g.drawLine(origin.x, origin.y, corner.x, corner.y);
            notifyAllListener();
        }
    }

    @Override
    public void setBounds(Point origin, Point corner) {
        this.corner = corner;
        Line2D original = new Line2D.Double(origin, corner);
        line.setLine(origin, corner);
        if(!original.equals(line)) {
            notifyAllListener();
        }
    }

    @Override
    public void move(int dx, int dy) {
        if (!(dx == 0 && dy == 0)) {
            line.setLine(line.getX1() + dx, line.getY1() + dy, line.getX2() + dx, line.getY2() + dy);
            notifyAllListener();
        }
    }

    @Override
    public boolean contains(int x, int y) {
        return line.contains(x, y);
    }

    @Override
    public Rectangle getBounds() {
        return line.getBounds();
    }
}