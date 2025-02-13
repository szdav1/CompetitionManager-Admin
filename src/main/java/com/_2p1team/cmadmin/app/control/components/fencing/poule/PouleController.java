package com._2p1team.cmadmin.app.control.components.fencing.poule;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.view.components.fencing.poule.Box;
import com._2p1team.cmadmin.app.view.components.fencing.poule.Poule;
import com._2p1team.cmadmin.app.view.components.input.LabeledInput;
import com._2p1team.cmadmin.swing.override.components.button.Button;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Optional;

public final class PouleController extends AbstractController {

    private static final List<Integer> validKeyCodes = List.of(
        KeyEvent.VK_0, KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3, KeyEvent.VK_4, KeyEvent.VK_5, KeyEvent.VK_V,
        KeyEvent.VK_NUMPAD0, KeyEvent.VK_NUMPAD1, KeyEvent.VK_NUMPAD2, KeyEvent.VK_NUMPAD3, KeyEvent.VK_NUMPAD4, KeyEvent.VK_NUMPAD5
    );

    private final Poule poule;

    private final Box[][] pouleBoxes;
    private final Button insertButton;
    private final Button finishButton;

    private final LabeledInput competitor1;
    private final LabeledInput competitor2;
    private final LabeledInput point1;
    private final LabeledInput point2;
    private final List<LabeledInput> inputs;

    private final PouleKeyController pouleKeyController;

    public PouleController(final Poule component) {
        super(component);

        this.poule = component;

        this.pouleBoxes = this.poule.getBoxes();
        this.insertButton = this.poule.getInsertDataButton();
        this.finishButton = this.poule.getFinishButton();

        this.competitor1 = this.poule.getCompetitor1IndexInput();
        this.competitor2 = this.poule.getCompetitor2IndexInput();
        this.point1 = this.poule.getCompetitor1PointInput();
        this.point2 = this.poule.getCompetitor2PointInput();
        this.inputs = List.of(this.competitor1, this.competitor2, this.point1, this.point2);

        this.pouleKeyController = new PouleKeyController(this.poule);

        this.addListeners();
    }

    private void addListeners() {
        for (Box[] pouleBoxRow : this.pouleBoxes) {
            for (Box box : pouleBoxRow) {
                box.addMouseListener(this);
                box.addKeyListener(this);
            }
        }

        this.insertButton.addActionListener(this);
        this.finishButton.addActionListener(this);

        this.competitor1.getInput().addKeyListener(this);
        this.competitor2.getInput().addKeyListener(this);
        this.point1.getInput().addKeyListener(this);
        this.point2.getInput().addKeyListener(this);
    }

    private Optional<Box> getSiblingBox(final Box box) {
        for (int y = 1; y < this.pouleBoxes.length; y++) {
            for (int x = 3; x < this.pouleBoxes[y].length-5; x++) {
                if (this.pouleBoxes[y][x] == box)
                    return Optional.ofNullable(this.pouleBoxes[x-2][y+2]);
            }
        }

        return Optional.empty();
    }

    private void focusEnteredBox(final Box box, final MouseEvent mouseEvent) {
        if (mouseEvent.getID() == MouseEvent.MOUSE_ENTERED)
            box.requestFocus();
    }

    private void highlightBoxes(final int x, final int y, final Box box, final MouseEvent mouseEvent) {
        final Box siblingBox = this.getSiblingBox(box).orElse(null);

        if (siblingBox == null)
            return;

        if (mouseEvent.getID() == MouseEvent.MOUSE_ENTERED) {
            box.setBackground(Box.HIGHLIGHTED_BACKGROUND);
            siblingBox.setBackground(Box.HIGHLIGHTED_BACKGROUND);
            this.pouleBoxes[y][1].setBackground(Box.HIGHLIGHTED_BACKGROUND);
            this.pouleBoxes[x-2][1].setBackground(Box.HIGHLIGHTED_BACKGROUND);

            this.pouleKeyController.setHighlightedBox(box);
            this.pouleKeyController.setHighlightedBoxSibling(siblingBox);
        }
        else if (mouseEvent.getID() == MouseEvent.MOUSE_EXITED) {
            box.setBackground(Box.DEFAULT_BACKGROUND);
            siblingBox.setBackground(Box.DEFAULT_BACKGROUND);
            this.pouleBoxes[y][1].setBackground(Box.DEFAULT_BACKGROUND);
            this.pouleBoxes[x-2][1].setBackground(Box.DEFAULT_BACKGROUND);
        }
    }

    private void handleBoxHighlighting(final MouseEvent mouseEvent) {
        for (int y = 1; y < this.pouleBoxes.length; y++) {
            for (int x = 3; x < this.pouleBoxes[y].length-5; x++) {
                final Box box = this.pouleBoxes[y][x];

                if (mouseEvent.getSource().equals(box) && box.isEnabled()) {
                    this.focusEnteredBox(box, mouseEvent);
                    this.highlightBoxes(x, y, box, mouseEvent);
                    return;
                }
            }
        }
    }

    private void validateInputKeyCodes(final Box box, final KeyEvent keyEvent) {
        final int eventKeyCode = keyEvent.getKeyCode();

        if (!keyEvent.getSource().equals(box) || keyEvent.getKeyCode() == KeyEvent.VK_ENTER || keyEvent.getKeyCode() == KeyEvent.VK_SPACE)
            return;

        if (!validKeyCodes.contains(eventKeyCode))
            box.setText("");
        else if (eventKeyCode == KeyEvent.VK_5 || eventKeyCode == KeyEvent.VK_NUMPAD5)
            box.setText("v");
    }

    private void validateBoxInput(final Box box) {
        final Box siblingBox = this.getSiblingBox(box).orElse(null);

        if (siblingBox == null)
            return;

        if (box.compareContentsWith(siblingBox))
            box.setText("");
        else if ((!siblingBox.compareContentsTo("v") && !box.compareContentsTo("v")) && !siblingBox.getText().isBlank())
            box.setText("");

        box.setText(box.getText().replaceAll(" ", ""));

        switch (box.getText()) {
            case "0", "1", "2", "3", "4", "v" -> {
            }
            default -> box.setText("");
        }
    }

    private void handlePouleBoxInput(final KeyEvent keyEvent) {
        for (Box[] pouleBoxRow : this.pouleBoxes) {
            for (Box box : pouleBoxRow) {
                this.validateInputKeyCodes(box, keyEvent);
                this.validateBoxInput(box);
            }
        }
    }

    private void validateValuesToBeInserted(final KeyEvent keyEvent) {
        // TODO: Implement this
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.handlePouleBoxInput(e);
        this.validateValuesToBeInserted(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.handleBoxHighlighting(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.handleBoxHighlighting(e);
    }

}