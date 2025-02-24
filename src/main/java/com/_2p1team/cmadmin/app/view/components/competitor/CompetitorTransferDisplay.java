package com._2p1team.cmadmin.app.view.components.competitor;

import com._2p1team.cmadmin.app.dto.competitor.CompetitorTransferModel;
import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import com._2p1team.cmadmin.support.constants.CustomColors;
import static com._2p1team.cmadmin.support.constants.SizeData.*;
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
            this.getNameLabel().setForeground(CustomColors.ORANGEISH);
            this.getClubLabel().setForeground(CustomColors.ORANGEISH);
            this.getBirthDateLabel().setForeground(CustomColors.ORANGEISH);
            this.getPlacementLabel().setForeground(CustomColors.ORANGEISH);
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