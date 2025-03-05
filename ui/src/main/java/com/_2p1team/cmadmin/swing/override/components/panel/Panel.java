package com._2p1team.cmadmin.swing.override.components.panel;

import com._2p1team.cmadmin.swing.override.components.AppearanceComponent;
import com._2p1team.cmadmin.swing.override.components.Container;
import com._2p1team.cmadmin.swing.override.constants.Position;
import com._2p1team.cmadmin.swing.override.constants.UIState;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.G2DPainter;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

/**
 * The Panel class is the custom representation of Swing's
 * JPanel and awt's Panel class. As every custom UI component,
 * this class determines its visual representation based on the
 * specified Appearance object.
 *
 * @see JLayeredPane
 * @see AbstractPanel
 * @see AppearanceComponent
 * @see Container
 */
public class Panel extends AbstractPanel {

    /**
     * Constructs a basic custom Panel using the specified Appearance class.
     *
     * @param appearance The Appearance class that describes the UI attributes of this component
     */
    public Panel(Appearance appearance) {
        super(appearance);
    }

    /**
     * Constructs a basic custom Panel using an empty constructor Appearance.
     */
    public Panel() {
    }

    /**
     * Constructs a basic custom Panel using the specified Appearance class, preferred size
     * and text.
     *
     * @param preferredSize The Dimension object that describes the preferred size of this component
     * @param layout        The layout manager of the component
     * @param appearance    The Appearance class that describes the UI attributes of this component
     */
    public Panel(Dimension preferredSize, LayoutManager layout, final Appearance appearance) {
        super(preferredSize, layout, appearance);
    }

    /**
     * Constructs a basic custom Panel using the specified Appearance class, preferred size
     * and text.
     *
     * @param preferredSize The Dimension object that describes the preferred size of this component
     * @param appearance    The Appearance class that describes the UI attributes of this component
     */
    public Panel(Dimension preferredSize, final Appearance appearance) {
        super(preferredSize, appearance);
    }

    /**
     * Constructs a basic custom Panel using the specified Appearance class, bounds
     * and text.
     *
     * @param bounds     The Rectangle object that describes the bounds of this component
     * @param layout     The layout manager of the component
     * @param appearance The Appearance class that describes the UI attributes of this component
     */
    public Panel(Rectangle bounds, LayoutManager layout, final Appearance appearance) {
        super(bounds, layout, appearance);
    }

    /**
     * Constructs a basic custom Panel using the specified Appearance class, bounds
     * and text.
     *
     * @param bounds     The Rectangle object that describes the bounds of this component
     * @param appearance The Appearance class that describes the UI attributes of this component
     */
    public Panel(Rectangle bounds, final Appearance appearance) {
        super(bounds, appearance);
    }

    @Override
    public void displayError() {
        this.getAppearance().setState(UIState.ERROR);
        this.repaint();
    }

    @Override
    public void hideError() {
        this.getAppearance().setState(UIState.DEFAULT);
        this.repaint();
    }

    @Override
    public Appearance getComponentAppearance() {
        return this.getAppearance();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.getAppearance().setState(UIState.PRESSED);
        G2DPainter.drawComponentUIElements(this);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.getAppearance().setState(UIState.RELEASED);
        G2DPainter.drawComponentUIElements(this);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.getAppearance().setState(UIState.HOVERED);
        G2DPainter.drawComponentUIElements(this);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.getAppearance().setState(UIState.DEFAULT);
        G2DPainter.drawComponentUIElements(this);
    }

    @Override
    public void addComponent(final JComponent component, final Position position) {
        this.add(component, this.getLayout() instanceof BorderLayout ? position.getLayoutValue() : position.getPositionValue());
        this.revalidate();
    }

    @Override
    public void addComponent(final JComponent component) {
        this.addComponent(component, this.getLayout() instanceof BorderLayout ? Position.CENTER : Position.MID);
    }

    @Override
    public JComponent removeComponent(final JComponent component) {
        this.remove(component);
        this.revalidate();
        return component;
    }

}