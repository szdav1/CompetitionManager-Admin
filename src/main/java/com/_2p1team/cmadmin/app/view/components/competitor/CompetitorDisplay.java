package com._2p1team.cmadmin.app.view.components.competitor;

import com._2p1team.cmadmin.app.dto.competitor.Competitor;
import com._2p1team.cmadmin.app.view.components.checkbox.Checkbox;
import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import com._2p1team.cmadmin.support.constants.CustomColors;
import static com._2p1team.cmadmin.support.constants.SizeData.BUTTON_SIZE;
import static com._2p1team.cmadmin.support.constants.SizeData.W_BUTTON_SIZE;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.awt.Dimension;
import java.awt.FlowLayout;

@Data
@EqualsAndHashCode(callSuper=true)
public class CompetitorDisplay extends Panel implements ComplexComponent {

    private final Checkbox checkbox;
    private final Label idLabel;
    private final Label nameLabel;
    private final Label clubLabel;
    private final Label birthDateLabel;

    public CompetitorDisplay(Dimension idPreferredSize, Dimension otherPreferredSize, final Competitor competitor) {
        super(new Appearance(AppearanceRepository.COMPETITOR_COMPONENT_APPEARANCE));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.checkbox = new Checkbox();
        this.idLabel = new Label(idPreferredSize, String.valueOf(competitor.getId()), new Appearance(AppearanceRepository.BASE_LABEL_APPEARANCE));
        this.nameLabel = new Label(otherPreferredSize, competitor.getName(), new Appearance(AppearanceRepository.BASE_LABEL_APPEARANCE));
        this.clubLabel = new Label(otherPreferredSize, competitor.getClub(), new Appearance(AppearanceRepository.BASE_LABEL_APPEARANCE));
        this.birthDateLabel = new Label(otherPreferredSize, competitor.getBirthDateAsString(), new Appearance(AppearanceRepository.BASE_LABEL_APPEARANCE));

        this.setUpComponent();
    }

    public CompetitorDisplay(final Competitor competitor) {
        this(BUTTON_SIZE, W_BUTTON_SIZE, competitor);
    }

    public static final class Header extends CompetitorDisplay {

        public Header(Dimension idPreferredSize, Dimension otherPreferredSize) {
            super(idPreferredSize, otherPreferredSize, new Competitor(0L, "Name", "Club", "Birth Date"));
            this.setUIAttributes();
        }

        public Header() {
            super(new Competitor(0L, "Name", "Club", "Birth Date"));
            this.setUIAttributes();
        }

        private void setUIAttributes() {
            this.getIdLabel().setForeground(CustomColors.ORANGEISH);
            this.getNameLabel().setForeground(CustomColors.ORANGEISH);
            this.getClubLabel().setForeground(CustomColors.ORANGEISH);
            this.getBirthDateLabel().setForeground(CustomColors.ORANGEISH);
            this.getIdLabel().setText("Id");
        }

    }

    @Override
    public void setUpComponent() {
        this.addComponent(this.checkbox);
        this.addComponent(this.idLabel);
        this.addComponent(this.nameLabel);
        this.addComponent(this.clubLabel);
        this.addComponent(this.birthDateLabel);
    }

}