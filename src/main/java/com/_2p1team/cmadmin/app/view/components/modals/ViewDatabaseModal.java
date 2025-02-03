package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.model.competitor.Competitor;
import com._2p1team.cmadmin.app.model.http.HttpCommunicator;
import com._2p1team.cmadmin.app.view.components.competitor.CompetitorComponent;

import javax.swing.JComponent;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

public final class ViewDatabaseModal extends AbstractModal {

    private List<Competitor> competitors;
    private List<CompetitorComponent> competitorComponents;

    public ViewDatabaseModal() {
        super();
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        // TODO: Finish displaying the fencers
        this.competitors = HttpCommunicator.CompetitorApi.getAllCompetitors();
        this.competitorComponents = new ArrayList<>();
        this.competitors.forEach(competitor -> competitorComponents.add(new CompetitorComponent(competitor)));

        this.setUpComponent();
    }

    @Override
    public void setUpComponent() {
        this.competitorComponents.forEach(cc -> this.getCenterPanel().addComponent(cc));
    }

    @Override
    public List<JComponent> getControls() {
        return List.of();
    }

    @Override
    public List<JComponent> getKeyControls() {
        return List.of();
    }

    @Override
    public void appear() {
        super.appear();
    }

}