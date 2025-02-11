package com._2p1team.cmadmin.app.view.components.competitor;

import com._2p1team.cmadmin.app.databasemodels.competitor.Competitor;
import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import static com._2p1team.cmadmin.support.constants.SizeData.W_BUTTON_SIZE;
import static com._2p1team.cmadmin.support.constants.SizeData.X_BUTTON_SIZE;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.awt.FlowLayout;

@Data
@EqualsAndHashCode(callSuper=true)
public class CompetitorComponent extends Panel implements ComplexComponent {

    private final Label idLabel;
    private final Label nameLabel;
    private final Label clubLabel;
    private final Label birthDateLabel;

    public CompetitorComponent(final Competitor competitor) {
        super(AppearanceRepository.COMPETITOR_COMPONENT_APPEARANCE);
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.idLabel = new Label(W_BUTTON_SIZE, String.valueOf(competitor.getId()), AppearanceRepository.BASE_LABEL_APPEARANCE);
        this.nameLabel = new Label(X_BUTTON_SIZE, competitor.getName(), AppearanceRepository.BASE_LABEL_APPEARANCE);
        this.clubLabel = new Label(X_BUTTON_SIZE, competitor.getClub(), AppearanceRepository.BASE_LABEL_APPEARANCE);
        this.birthDateLabel = new Label(X_BUTTON_SIZE, competitor.getBirthDateAsString(), AppearanceRepository.BASE_LABEL_APPEARANCE);

        this.setUpComponent();
    }

    @Override
    public void setUpComponent() {
        this.addComponent(this.idLabel);
        this.addComponent(this.nameLabel);
        this.addComponent(this.clubLabel);
        this.addComponent(this.birthDateLabel);
    }

}