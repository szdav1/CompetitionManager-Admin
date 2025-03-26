package com._2p1team.cmadmin.app.view.components.competitor;

import com._2p1team.cmadmin.app.dto.competitor.CompetitorTransferClass;
import com._2p1team.cmadmin.app.dto.competitor.CompetitorTransferModel;
import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import com._2p1team.cmadmin.general.constants.CustomColors;
import static com._2p1team.cmadmin.general.constants.SizeData.X_BUTTON_SIZE;
import com._2p1team.cmadmin.general.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.awt.Dimension;
import java.awt.FlowLayout;

@Data
@EqualsAndHashCode(callSuper=true)
public class CompetitorTransferDisplay extends Panel implements ComplexComponent {

    private final Label nameLabel;
    private final Label clubLabel;
    private final Label birthDateLabel;
    private final Label placementLabel;

    public CompetitorTransferDisplay(Dimension preferredSize, final CompetitorTransferModel competitorTransferModel) {
        super(new Appearance(AppearanceRepository.COMPETITOR_COMPONENT_APPEARANCE));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.nameLabel = new Label(preferredSize, competitorTransferModel.name(), new Appearance(AppearanceRepository.BASE_LABEL_APPEARANCE));
        this.clubLabel = new Label(preferredSize, competitorTransferModel.club(), new Appearance(AppearanceRepository.BASE_LABEL_APPEARANCE));
        this.birthDateLabel = new Label(preferredSize, competitorTransferModel.birthDate(), new Appearance(AppearanceRepository.BASE_LABEL_APPEARANCE));
        this.placementLabel = new Label(preferredSize, String.valueOf(competitorTransferModel.placement()), new Appearance(AppearanceRepository.BASE_LABEL_APPEARANCE));

        this.setUpComponent();
    }

    public CompetitorTransferDisplay(final CompetitorTransferModel competitorTransferModel) {
        this(X_BUTTON_SIZE, competitorTransferModel);
    }

    public CompetitorTransferDisplay(Dimension preferredSize, final CompetitorTransferClass competitorTransferClass) {
        super(new Appearance(AppearanceRepository.COMPETITOR_COMPONENT_APPEARANCE));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.nameLabel = new Label(preferredSize, competitorTransferClass.getName(), new Appearance(AppearanceRepository.BASE_LABEL_APPEARANCE));
        this.clubLabel = new Label(preferredSize, competitorTransferClass.getClub(), new Appearance(AppearanceRepository.BASE_LABEL_APPEARANCE));
        this.birthDateLabel = new Label(preferredSize, competitorTransferClass.getBirthDate(), new Appearance(AppearanceRepository.BASE_LABEL_APPEARANCE));
        this.placementLabel = new Label(preferredSize, String.valueOf(competitorTransferClass.getPlacement()), new Appearance(AppearanceRepository.BASE_LABEL_APPEARANCE));

        this.setUpComponent();
    }

    public CompetitorTransferDisplay(final CompetitorTransferClass competitorTransferClass) {
        this(X_BUTTON_SIZE, competitorTransferClass);
    }

    public static final class Header extends CompetitorTransferDisplay {

        public Header(Dimension preferredSize) {
            super(preferredSize, new CompetitorTransferModel(0L, "Name", "Club", "Birth Date", 0, 0));
            this.setUIAttributes();
        }

        public Header() {
            super(new CompetitorTransferModel(0L, "Name", "Club", "Birth Date", 0, 0));
            this.setUIAttributes();
        }

        private void setUIAttributes() {
            this.getNameLabel().setForeground(CustomColors.MAIN_COLOR_2);
            this.getClubLabel().setForeground(CustomColors.MAIN_COLOR_2);
            this.getBirthDateLabel().setForeground(CustomColors.MAIN_COLOR_2);
            this.getPlacementLabel().setForeground(CustomColors.MAIN_COLOR_2);
            this.getPlacementLabel().setText("Place");
        }

    }

    @Override
    public void setUpComponent() {
        this.addComponent(this.nameLabel);
        this.addComponent(this.clubLabel);
        this.addComponent(this.birthDateLabel);
        this.addComponent(this.placementLabel);
    }

}