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

    private static final List<Integer> validKeyCodesForPouleBoxes = List.of(
        KeyEvent.VK_0, KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3, KeyEvent.VK_4, KeyEvent.VK_5, KeyEvent.VK_V,
        KeyEvent.VK_NUMPAD0, KeyEvent.VK_NUMPAD1, KeyEvent.VK_NUMPAD2, KeyEvent.VK_NUMPAD3, KeyEvent.VK_NUMPAD4, KeyEvent.VK_NUMPAD5
    );

    private static final List<Integer> validKeyCodesForManualIndexInsertions = List.of(
        KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3, KeyEvent.VK_4, KeyEvent.VK_5, KeyEvent.VK_6, KeyEvent.VK_7, KeyEvent.VK_8,
        KeyEvent.VK_NUMPAD1, KeyEvent.VK_NUMPAD2, KeyEvent.VK_NUMPAD3, KeyEvent.VK_NUMPAD4, KeyEvent.VK_NUMPAD5, KeyEvent.VK_NUMPAD6,
        KeyEvent.VK_NUMPAD7, KeyEvent.VK_NUMPAD8
    );

    private static final List<Integer> ambientKeyCodes = List.of(
        KeyEvent.VK_TAB, KeyEvent.VK_CAPS_LOCK, KeyEvent.VK_SHIFT, KeyEvent.VK_CONTROL, KeyEvent.VK_ALT, KeyEvent.VK_ALT_GRAPH, KeyEvent.VK_ENTER
    );

    private final Poule poule;

    private final Box[][] pouleBoxes;
    private final Button insertButton;
    private final Button finishButton;

    private final LabeledInput competitor1;
    private final LabeledInput competitor2;
    private final LabeledInput point1;
    private final LabeledInput point2;
    private final List<LabeledInput> labeledInputs;

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
        this.labeledInputs = List.of(this.competitor1, this.competitor2, this.point1, this.point2);

        this.pouleKeyController = new PouleKeyController(this.poule);

        this.addListeners();
    }

    public void addListeners() {
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

    private void validatePouleBoxInputKeyCodes(final Box box, final KeyEvent keyEvent) {
        final int keyCode = keyEvent.getKeyCode();

        if (!keyEvent.getSource().equals(box) || keyEvent.getKeyCode() == KeyEvent.VK_ENTER || keyEvent.getKeyCode() == KeyEvent.VK_SPACE)
            return;

        if (!validKeyCodesForPouleBoxes.contains(keyCode) && !ambientKeyCodes.contains(keyCode))
            box.setText("");
        else if (keyCode == KeyEvent.VK_5 || keyCode == KeyEvent.VK_NUMPAD5)
            box.setText("v");
    }

    private void validatePouleBoxInput(final Box box) {
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
                this.validatePouleBoxInputKeyCodes(box, keyEvent);
                this.validatePouleBoxInput(box);
            }
        }
    }

    private void validateManualInsertKeyCodes(final LabeledInput labeledInput, final KeyEvent keyEvent) {
        final int keyCode = keyEvent.getKeyCode();

        if (!keyEvent.getSource().equals(labeledInput.getInput()) || keyCode == KeyEvent.VK_SPACE)
            return;

        if (labeledInput.equals(this.competitor1) || labeledInput.equals(this.competitor2)) {
            if (!validKeyCodesForManualIndexInsertions.contains(keyCode) && !ambientKeyCodes.contains(keyCode))
                labeledInput.setText("");
        }
        else if (labeledInput.equals(this.point1) || labeledInput.equals(this.point2)) {
            if (!validKeyCodesForPouleBoxes.contains(keyCode) && !ambientKeyCodes.contains(keyCode))
                labeledInput.setText("");
            else if (keyCode == KeyEvent.VK_5 || keyCode == KeyEvent.VK_NUMPAD5)
                labeledInput.setText("v");
        }
    }

    private void validateManualInsertData(final LabeledInput labeledInput) {
        if (labeledInput.getText().length() >= 2)
            labeledInput.setText("");


        if (labeledInput.equals(this.competitor1) || labeledInput.equals(this.competitor2)) {
            if (this.competitor1.getText().equalsIgnoreCase(this.competitor2.getText()))
                this.competitor2.setText("");

            try {
                int numberData = Integer.parseInt(labeledInput.getText());

                if (numberData > this.poule.getNumberOfCompetitors())
                    labeledInput.setText("");
            }
            catch (Exception exception) {
                labeledInput.setText("");
            }
        }
        else if (labeledInput.equals(this.point1) || labeledInput.equals(this.point2)) {
            if (this.point1.getText().equalsIgnoreCase(this.point2.getText()))
                this.point2.setText("");

            LabeledInput siblingInput = this.point1.equals(labeledInput) ? this.point2 : this.point1;

            if (!siblingInput.getText().equalsIgnoreCase("v") && !labeledInput.getText().equalsIgnoreCase("v") && !siblingInput.getText().isBlank())
                labeledInput.setText("");
        }
    }

    private void validateManualDataInserts(final KeyEvent keyEvent) {
        for (LabeledInput labeledInput : this.labeledInputs) {
            this.validateManualInsertKeyCodes(labeledInput, keyEvent);
            this.validateManualInsertData(labeledInput);
        }
    }

    private void insertManualInputData() {
        String competitor1String = this.competitor1.getText();
        String competitor2String = this.competitor2.getText();
        String point1String = this.point1.getText();
        String point2String = this.point2.getText();

        try {
            int competitor1 = Integer.parseInt(competitor1String);
            int competitor2 = Integer.parseInt(competitor2String);

            this.pouleBoxes[competitor1][competitor2+2].setText(point1String);
            this.pouleBoxes[competitor2][competitor1+2].setText(point2String);

            this.competitor1.setText("");
            this.competitor2.setText("");
            this.point1.setText("");
            this.point2.setText("");
        }
        catch (Exception exception) {
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.insertButton))
            this.insertManualInputData();
        else if (e.getSource().equals(this.finishButton))
            this.poule.calculateCompetitorData();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.handlePouleBoxInput(e);
        this.validateManualDataInserts(e);
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