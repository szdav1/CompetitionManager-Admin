package com._2p1team.cmadmin.app.view.components.input;

import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import com._2p1team.cmadmin.general.constants.CustomColors;
import static com._2p1team.cmadmin.general.constants.SizeData.*;
import com._2p1team.cmadmin.general.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.FontSet;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

@Data
@EqualsAndHashCode(callSuper=false)
public final class LabeledInput extends Panel implements ComplexComponent {

    private final Label label;
    private final JTextField input;

    public LabeledInput(String title) {
        super(new Dimension(BUTTON_WIDTH+N_BUTTON_WIDTH, BUTTON_HEIGHT), new FlowLayout(FlowLayout.LEFT, 0, 0), new Appearance(AppearanceRepository.LABELED_INPUT_APPEARANCE));

        this.label = new Label(BUTTON_SIZE, title, new Appearance(AppearanceRepository.LABELED_INPUT_APPEARANCE));

        this.input = new JTextField();
        this.input.setPreferredSize(N_BUTTON_SIZE);
        this.input.setOpaque(true);
        this.input.setForeground(Color.white);
        this.input.setBackground(Color.black);
        this.input.setFont(FontSet.SYSTEM_FONT);
        this.input.setCaretColor(this.getForeground());
        this.input.setHorizontalAlignment(JTextField.CENTER);
        this.input.setBorder(new LineBorder(CustomColors.ORANGEISH, 1));

        this.setUpComponent();
    }

    public LabeledInput(int width, String title) {
        this(title);
        this.setPreferredSize(new Dimension(this.getWidth()+width, this.getHeight()));
        this.input.setPreferredSize(new Dimension(width, BUTTON_HEIGHT));
    }

    public void setText(final String text) {
        this.input.setText(text);
    }

    public String getText() {
        return this.input.getText();
    }

    @Override
    public void setUpComponent() {
        this.addComponent(this.label);
        this.addComponent(this.input);
    }

}