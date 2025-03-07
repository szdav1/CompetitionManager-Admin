package com._2p1team.cmadmin.swing.override.components.scrollpanel;

import com._2p1team.cmadmin.swing.override.components.AppearanceComponent;
import com._2p1team.cmadmin.swing.override.components.Container;
import com._2p1team.cmadmin.swing.override.constants.Position;
import com._2p1team.cmadmin.swing.override.constants.UIState;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.AdjustmentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

/**
 * The ScrollPanel class is the custom representation of Swing's
 * JScrollPanel and awt's ScrollPanel class. As every custom UI component,
 * this class determines its visual representation based on the
 * specified Appearance object.
 *
 * @see JScrollPane
 * @see AbstractScrollPanel
 * @see AppearanceComponent
 * @see Container
 */
public class ScrollPanel extends AbstractScrollPanel {

    /**
     * Constructs a basic custom ScrollPanel using an empty constructor Appearance.
     */
    public ScrollPanel() {
    }

    /**
     * Constructs a basic custom ScrollPanel using the specified Appearance class, preferred size
     * and text.
     *
     * @param preferredSize The Dimension object that describes the preferred size of this component
     * @param layout        The layout manager of the component
     * @param appearance    The Appearance class that describes the UI attributes of this component
     */
    public ScrollPanel(Dimension preferredSize, LayoutManager layout, final Appearance appearance) {
        super(preferredSize, layout, appearance);
    }

    /**
     * Constructs a basic custom ScrollPanel using the specified Appearance class, preferred size
     * and text.
     *
     * @param preferredSize The Dimension object that describes the preferred size of this component
     * @param appearance    The Appearance class that describes the UI attributes of this component
     */
    public ScrollPanel(Dimension preferredSize, final Appearance appearance) {
        super(preferredSize, appearance);
    }

    /**
     * Constructs a basic custom ScrollPanel using the specified Appearance class, bounds
     * and text.
     *
     * @param bounds     The Rectangle object that describes the bounds of this component
     * @param layout     The layout manager of the component
     * @param appearance The Appearance class that describes the UI attributes of this component
     */
    public ScrollPanel(Rectangle bounds, LayoutManager layout, final Appearance appearance) {
        super(bounds, layout, appearance);
    }

    /**
     * Constructs a basic custom ScrollPanel using the specified Appearance class, bounds
     * and text.
     *
     * @param bounds     The Rectangle object that describes the bounds of this component
     * @param appearance The Appearance class that describes the UI attributes of this component
     */
    public ScrollPanel(Rectangle bounds, final Appearance appearance) {
        super(bounds, appearance);
    }

    /**
     * Resizes the scroll panel's view panel based on the sum of the
     * height of the components inside the contents of the object using the
     * specified width.
     *
     * @param newWidth The width of the view panel
     */
    public void resizeViewPanel(int newWidth) {
        int contentsHeight = 0;

        for (JComponent content : this.getContents()) {
            contentsHeight += content.getPreferredSize().height;
        }

        this.getViewPanel().setPreferredSize(new Dimension(newWidth, (int) (contentsHeight*1.3f)));

        this.setViewportView(this.getViewPanel());
        this.getViewPanel().repaint();
        this.getViewPanel().revalidate();
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
    public void addComponent(JComponent component, Position position) {
        this.getContents().add(component);
        this.getViewPanel().addComponent(component, position);
    }

    @Override
    public void addComponent(JComponent component) {
        this.getContents().add(component);
        this.getViewPanel().addComponent(component);
    }

    @Override
    public JComponent removeComponent(JComponent component) {
        this.getContents().remove(component);
        return this.getViewPanel().removeComponent(component);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }


    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        if (e.getSource().equals(this.getVerticalScrollBar()))
            this.setScrollCounter(e.getValue());
    }

}