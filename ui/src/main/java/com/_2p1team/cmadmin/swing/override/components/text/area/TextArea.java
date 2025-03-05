package com._2p1team.cmadmin.swing.override.components.text.area;

import com._2p1team.cmadmin.swing.override.components.AppearanceComponent;
import com._2p1team.cmadmin.swing.override.constants.UIState;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.G2DPainter;

import javax.swing.JTextArea;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

/**
 * The TextArea class is the custom representation of Swing's
 * JTextArea and awt's TextArea class. As every custom UI component,
 * this class determines its visual representation based on the
 * specified Appearance object.
 *
 * @see JTextArea
 * @see AbstractTextArea
 * @see AppearanceComponent
 */
public class TextArea extends AbstractTextArea {

    /**
     * Constructs a basic custom TextArea using the specified Appearance class.
     *
     * @param appearance The Appearance class that describes the UI attributes of this component
     */
    public TextArea(Appearance appearance) {
        super(appearance);
    }

    /**
     * Constructs a basic custom TextArea using an empty constructor Appearance.
     */
    public TextArea() {
    }

    /**
     * Constructs a basic custom TextArea using the specified Appearance class, preferred size
     * and text.
     *
     * @param preferredSize The Dimension object that describes the preferred size of this component
     * @param text          The text that should be displayed on the component
     * @param appearance    The Appearance class that describes the UI attributes of this component
     */
    public TextArea(Dimension preferredSize, String text, final Appearance appearance) {
        super(preferredSize, text, appearance);
    }

    /**
     * Constructs a basic custom TextArea using the specified Appearance class and preferred size.
     *
     * @param preferredSize The Dimension object that describes the preferred size of this component
     * @param appearance    The Appearance class that describes the UI attributes of this component
     */
    public TextArea(Dimension preferredSize, final Appearance appearance) {
        super(preferredSize, appearance);
    }

    /**
     * Constructs a basic custom TextArea using the specified Appearance class, bounds
     * and text.
     *
     * @param bounds     The Rectangle object that describes the bounds of this component
     * @param text       The text that should be displayed on the component
     * @param appearance The Appearance class that describes the UI attributes of this component
     */
    public TextArea(Rectangle bounds, String text, final Appearance appearance) {
        super(bounds, text, appearance);
    }

    /**
     * Constructs a basic custom TextArea using the specified Appearance class and bounds.
     *
     * @param bounds     The Rectangle object that describes the bounds of this component
     * @param appearance The Appearance class that describes the UI attributes of this component
     */
    public TextArea(Rectangle bounds, final Appearance appearance) {
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

}