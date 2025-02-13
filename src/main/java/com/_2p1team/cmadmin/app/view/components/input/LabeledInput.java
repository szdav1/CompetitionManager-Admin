package com._2p1team.cmadmin.app.view.components.input;

import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import static com._2p1team.cmadmin.support.constants.SizeData.*;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.components.text.field.TextField;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.FontSet;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

@Data
@EqualsAndHashCode(callSuper=false)
public final class LabeledInput extends Panel implements ComplexComponent {

    private final JLabel label;
    private final TextField input;

    public LabeledInput(String title) {
        super(new Dimension(BUTTON_WIDTH+N_BUTTON_WIDTH, BUTTON_HEIGHT), new FlowLayout(FlowLayout.LEFT, 0, 0), new Appearance(AppearanceRepository.LABELED_INPUT_APPEARANCE));

        this.label = new JLabel(title);
        this.label.setPreferredSize(BUTTON_SIZE);
        this.label.setFont(FontSet.SYSTEM_FONT);
        this.label.setForeground(Color.white);
        this.label.setHorizontalAlignment(SwingConstants.CENTER);

        this.input = new TextField(N_BUTTON_SIZE, new Appearance(AppearanceRepository.SMALL_INPUT_APPEARANCE));

        this.setUpComponent();
    }

    public void setText(final String text) {
        this.input.setText(text);
    }

    public String getText() {
        return this.input.getText();
    }

    public void displayError() {
        this.label.setOpaque(true);
        this.label.setBackground(Color.red);
    }

    public void hideError() {
        this.label.setOpaque(false);
    }

    @Override
    public void setUpComponent() {
        this.addComponent(this.label);
        this.addComponent(this.input);
    }

}