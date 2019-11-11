package jdraw.figures.handles;

import jdraw.framework.DrawView;
import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Handle implements FigureHandle {
    private Figure owner;
    private HandleState state;
    private Color color;
    private Point corner;

    public Handle(Figure owner, HandleState state, Color color) {
        this.owner = owner;
        this.state = state;
        this.color = color;
    }

    @Override
    public Figure getOwner() {
        return owner;
    }

    @Override
    public Point getLocation() {
        return state.getLocation();
    }

    @Override
    public void draw(Graphics g) {
        Point loc = getLocation();
        g.setColor(color);
        g.fillRect(loc.x - 3, loc.y - 3, 6, 6);
        g.setColor(Color.BLACK);
        g.drawRect(loc.x - 3, loc.y - 3, 6, 6);
    }

    @Override
    public Cursor getCursor() {
        return state.getCursor();
    }

    @Override
    public boolean contains(int x, int y) {
        Point loc = getLocation();
        Rectangle handle = new Rectangle(loc.x - 3, loc.y - 3, 6, 6);
        return handle.contains(x, y);
    }

    public HandleState getState() { return this.state; }

    public void setState(HandleState state) {
        this.state = state;
    }

    @Override
    public void startInteraction(int x, int y, MouseEvent e, DrawView v) {
        corner = state.getAnchor().getLocation();
    }

    @Override
    public void dragInteraction(int x, int y, MouseEvent e, DrawView v) {
        state.dragInteraction(x, y, e, v, corner);
    }

    @Override
    public void stopInteraction(int x, int y, MouseEvent e, DrawView v) {
        corner = null;
    }
}
