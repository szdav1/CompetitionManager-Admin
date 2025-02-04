package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.view.components.competitor.CompetitorComponent;
import com._2p1team.cmadmin.repository.CompetitorRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.JComponent;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public final class ViewCompetitorsModal extends AbstractModal {

    private final List<CompetitorComponent> competitorComponents;

    public ViewCompetitorsModal() {
        super();

        this.competitorComponents = new ArrayList<>();
        CompetitorRepository.competitors.forEach(competitor -> competitorComponents.add(new CompetitorComponent(competitor)));

        this.setUpComponent();
    }

    @Override
    public void setUpComponent() {
        this.competitorComponents.forEach(competitorComponent -> this.getCenterPanel().addComponent(competitorComponent));
    }

    @Override
    public List<JComponent> getControls() {
        return List.of();
    }

    @Override
    public List<JComponent> getKeyControls() {
        return List.of();
    }

}