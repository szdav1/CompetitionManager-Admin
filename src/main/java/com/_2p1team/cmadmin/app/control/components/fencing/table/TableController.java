package com._2p1team.cmadmin.app.control.components.fencing.table;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.view.components.fencing.table.Table;
import static com._2p1team.cmadmin.general.constants.SizeData.BUTTON_HEIGHT;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public final class TableController extends AbstractController {

    private final Table table;

    public TableController(final Table component) {
        super(component);

        this.table = component;

        this.addListeners();
    }

    private void addListeners() {
        this.table.getElements().forEach(element -> element.getWinnerCompetitorBox().addMouseListener(this));
        this.table.getElements().forEach(element -> element.getDropdownButtons().forEach(button -> button.addActionListener(this)));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.table.getElements().forEach(element -> element.getDropdownButtons().forEach(button -> {
            if (e.getSource().equals(button) && button.getAppearance().isInteractivityEnabled() && !button.getText().isBlank()) {
                element.getWinnerCompetitorBox().setText(button.getText());
                element.toggleDropdownPanel(0);
            }
        }));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.table.getElements().forEach(element -> {
            if (e.getSource().equals(element.getWinnerCompetitorBox()))
                element.toggleDropdownPanel(this.table.getScrollPanel().getScrollCounter()-BUTTON_HEIGHT);
        });
    }

}