package com._2p1team.cmadmin.app.view.components.fencing.table;

import com._2p1team.cmadmin.app.view.components.fencing.Box;
import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import com._2p1team.cmadmin.app.view.interfaces.ControlComponent;
import com._2p1team.cmadmin.general.constants.CustomColors;
import static com._2p1team.cmadmin.general.constants.SizeData.*;
import com._2p1team.cmadmin.general.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.components.scrollpanel.ScrollPanel;
import com._2p1team.cmadmin.swing.override.constants.Position;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.JComponent;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=true)
public final class TableElement extends Panel implements ComplexComponent, ControlComponent {

    private final Label topNumberLabel;
    private final Label bottomNumberLabel;
    private final Box topCompetitorBox;
    private final Box bottomCompetitorBox;
    private final Box winnerCompetitorBox;
    private final Panel connector;

    private final TableElement topParentElement;
    private final TableElement bottomParentElement;

    private boolean dropdownToggled;
    private final Panel dropdownPanel;
    private final List<Button> dropdownButtons;

    public TableElement(String topIndexString, String bottomIndexString, int x, int y) {
        super(new Rectangle(x, y, (W_BUTTON_WIDTH*2)+(N_BUTTON_WIDTH*2), BUTTON_HEIGHT*3), null, new Appearance(AppearanceRepository.TABLE_ELEMENT_APPEARANCE));

        this.topNumberLabel = new Label(new Rectangle(0, 0, N_BUTTON_WIDTH, BUTTON_HEIGHT), topIndexString, AppearanceRepository.BASE_LABEL_APPEARANCE);
        this.bottomNumberLabel = new Label(new Rectangle(0, BUTTON_HEIGHT*2, N_BUTTON_WIDTH, BUTTON_HEIGHT), bottomIndexString, AppearanceRepository.BASE_LABEL_APPEARANCE);
        this.topCompetitorBox = new Box(new Rectangle(0, 0, W_BUTTON_WIDTH, BUTTON_HEIGHT), "");
        this.bottomCompetitorBox = new Box(new Rectangle(0, BUTTON_HEIGHT*2, W_BUTTON_WIDTH, BUTTON_HEIGHT), "");
        this.winnerCompetitorBox = new Box(new Rectangle(W_BUTTON_WIDTH, BUTTON_HEIGHT, W_BUTTON_WIDTH, BUTTON_HEIGHT), "");
        this.connector = new Panel();

        this.topParentElement = this;
        this.bottomParentElement = this;

        this.dropdownToggled = false;
        this.dropdownPanel = new Panel(new Rectangle(0, 0, W_BUTTON_WIDTH, BUTTON_HEIGHT*2), new FlowLayout(FlowLayout.CENTER, 0, 0), new Appearance(AppearanceRepository.DROPDOWN_APPEARANCE));
        this.dropdownButtons = new ArrayList<>();

        final Button topCompetitorButton = new Button(W_BUTTON_SIZE, this.topCompetitorBox.getText(), new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        final Button bottomCompetitorButton = new Button(W_BUTTON_SIZE, this.bottomCompetitorBox.getText(), new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));

        this.dropdownButtons.add(topCompetitorButton);
        this.dropdownButtons.add(bottomCompetitorButton);

        this.setUpComponent();
    }

    public TableElement(final TableElement topParentElement, final TableElement bottomParentElement, int columnNumberConstant) {
        super(new Rectangle(0, 0, 0, 0), null, new Appearance(AppearanceRepository.TABLE_ELEMENT_APPEARANCE));
        this.setBounds(this.calculateBounds(topParentElement, bottomParentElement, columnNumberConstant));

        this.topNumberLabel = null;
        this.bottomNumberLabel = null;
        this.topCompetitorBox = new Box(new Rectangle(0, 0, W_BUTTON_WIDTH, BUTTON_HEIGHT), topParentElement.getWinnerCompetitorBox().getText());
        this.bottomCompetitorBox = new Box(new Rectangle(0, this.getHeight()-BUTTON_HEIGHT, W_BUTTON_WIDTH, BUTTON_HEIGHT), bottomParentElement.getWinnerCompetitorBox().getText());
        this.winnerCompetitorBox = new Box(new Rectangle(W_BUTTON_WIDTH, (this.getHeight()/2)-(BUTTON_HEIGHT/2), W_BUTTON_WIDTH, BUTTON_HEIGHT), "", CustomColors.REDDISH);
        this.connector = new Panel(new Rectangle(W_BUTTON_WIDTH, 0, 2, this.getHeight()), null, new Appearance(AppearanceRepository.VERTICAL_DIVIDER_APPEARANCE));

        this.topParentElement = topParentElement;
        this.bottomParentElement = bottomParentElement;

        this.dropdownToggled = false;
        this.dropdownPanel = new Panel(new Rectangle(0, 0, W_BUTTON_WIDTH, BUTTON_HEIGHT*2), new FlowLayout(FlowLayout.CENTER, 0, 0), new Appearance(AppearanceRepository.DROPDOWN_APPEARANCE));
        this.dropdownButtons = new ArrayList<>();

        final Button topCompetitorButton = new Button(W_BUTTON_SIZE, topParentElement.getWinnerCompetitorBox().getText(), new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        final Button bottomCompetitorButton = new Button(W_BUTTON_SIZE, bottomParentElement.getWinnerCompetitorBox().getText(), new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));

        this.dropdownButtons.add(topCompetitorButton);
        this.dropdownButtons.add(bottomCompetitorButton);

        this.setUpComponent();
    }

    private void disableBoxes() {
        this.topCompetitorBox.setFocusable(false);
        this.bottomCompetitorBox.setFocusable(false);
        this.winnerCompetitorBox.setFocusable(false);

        this.topCompetitorBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.bottomCompetitorBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.winnerCompetitorBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    void setUpDropdownPanel(final ScrollPanel scrollPanel) {
        scrollPanel.addComponent(this.dropdownPanel, Position.HIGH);
        this.dropdownPanel.setVisible(false);
    }

    public void toggleDropdownPanel(int y) {
        this.dropdownToggled = !this.dropdownToggled;
        this.dropdownPanel.setVisible(this.dropdownToggled);

        Point location = this.winnerCompetitorBox.getLocationOnScreen();
        this.dropdownPanel.setLocation(location.x, y == 0 ? location.y : (location.y+y));

        if (this.topParentElement.equals(this) && this.bottomParentElement.equals(this)) {
            this.dropdownButtons.getFirst().setText(this.topCompetitorBox.getText());
            this.dropdownButtons.getLast().setText(this.bottomCompetitorBox.getText());
        }
        else {
            this.dropdownButtons.getFirst().setText(this.topParentElement.getWinnerCompetitorBox().getText());
            this.dropdownButtons.getLast().setText(this.bottomParentElement.getWinnerCompetitorBox().getText());
        }

        if (this.dropdownButtons.getFirst().getText().equals(Table.EMPTY_COMPETITOR))
            this.dropdownButtons.getFirst()
                .getAppearance()
                .disableInteractivity();
        else if (this.dropdownButtons.getLast().getText().equals(Table.EMPTY_COMPETITOR))
            this.dropdownButtons.getLast()
                .getAppearance()
                .disableInteractivity();
    }

    public void hideDropdownPanel() {
        this.dropdownToggled = false;
        this.dropdownPanel.setVisible(this.dropdownToggled);
    }

    private Rectangle calculateBounds(final TableElement topParentElement, final TableElement bottomParentElement, final int columnNumberConstant) {
        return new Rectangle(
            topParentElement.getX()+W_BUTTON_WIDTH,
            topParentElement.getY()+(BUTTON_HEIGHT*(columnNumberConstant-1)),
            W_BUTTON_WIDTH*2,
            bottomParentElement.getY()-topParentElement.getY()+BUTTON_HEIGHT
        );
    }

    public int getTopNumbering() {
        if (this.topNumberLabel == null)
            return 0;

        return Integer.parseInt(this.topNumberLabel.getText());
    }

    public int getBottomNumbering() {
        if (this.bottomNumberLabel == null)
            return 0;

        return Integer.parseInt(this.bottomNumberLabel.getText());
    }

    public void stepFencers() {
        if (!this.topParentElement.equals(this) && !this.bottomParentElement.equals(this))
            return;

        if (this.topCompetitorBox.getText().equals(Table.EMPTY_COMPETITOR))
            this.winnerCompetitorBox.setText(this.bottomCompetitorBox.getText());
        else if (this.bottomCompetitorBox.getText().equals(Table.EMPTY_COMPETITOR))
            this.winnerCompetitorBox.setText(this.topCompetitorBox.getText());
    }

    @Override
    public void setUpComponent() {
        if (this.topNumberLabel != null && this.bottomNumberLabel != null) {
            this.addComponent(this.topNumberLabel);
            this.addComponent(this.bottomNumberLabel);
        }


        this.addComponent(this.topCompetitorBox);
        this.addComponent(this.bottomCompetitorBox);
        this.addComponent(this.winnerCompetitorBox);
        this.addComponent(this.connector);
        this.disableBoxes();

        this.dropdownButtons.forEach(this.dropdownPanel::addComponent);
    }

    @Override
    public List<JComponent> getControls() {
        return List.of(this.topCompetitorBox, this.bottomCompetitorBox, this.winnerCompetitorBox);
    }

}