package com._2p1team.cmadmin.app.view.components.competitor;

import com._2p1team.cmadmin.app.model.competitor.Competitor;
import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import static com._2p1team.cmadmin.support.constants.SizeData.W_BUTTON_SIZE;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import lombok.Getter;
import lombok.ToString;

import java.awt.FlowLayout;

@Getter
@ToString
public final class CompetitorComponent extends Panel implements ComplexComponent {

    private final Label nameLabel;
    private final Label clubLabel;
    private final Label birthDateLabel;

    public CompetitorComponent(final Competitor competitor) {
        super(AppearanceRepository.COMPETITOR_COMPONENT_APPEARANCE);
        
        this.nameLabel = new Label(W_BUTTON_SIZE, competitor.getName(), AppearanceRepository.BASE_LABEL_APPEARANCE);
        this.clubLabel = new Label(W_BUTTON_SIZE, competitor.getClub(), AppearanceRepository.BASE_LABEL_APPEARANCE);
        this.birthDateLabel = new Label(W_BUTTON_SIZE, competitor.getBirthDateAsString(), AppearanceRepository.BASE_LABEL_APPEARANCE);

        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.setUpComponent();
    }

    @Override
    public void setUpComponent() {
        this.addComponent(this.nameLabel);
        this.addComponent(this.clubLabel);
        this.addComponent(this.birthDateLabel);
    }

}