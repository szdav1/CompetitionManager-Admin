package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.http.ResponseInterpreter;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import static com._2p1team.cmadmin.general.constants.AppearanceConstants.PADDING;
import com._2p1team.cmadmin.general.constants.Language;
import static com._2p1team.cmadmin.general.constants.SizeData.BUTTON_HEIGHT;
import com._2p1team.cmadmin.general.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.scrollpanel.ScrollPanel;
import com._2p1team.cmadmin.swing.override.components.text.field.TextField;

import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

public final class ApiResponseModal extends AbstractModal {

    private final ScrollPanel scrollPanel;
    private final TextField messageArea;

    public ApiResponseModal() {
        super();
        this.setTitle(Language.get("ServerResponse"));

        this.scrollPanel = new ScrollPanel(this.getCenterPanel().getPreferredSize(), new FlowLayout(FlowLayout.CENTER, 0, 0), AppearanceRepository.BASE_SCROLL_PANEL_APPEARANCE);
        this.scrollPanel.setScrollSpeed(BUTTON_HEIGHT);

        this.messageArea = new TextField(new Dimension(this.scrollPanel.getWidth()/2, this.scrollPanel.getHeight()-PADDING), "", AppearanceRepository.LABELED_INPUT_APPEARANCE);
        this.messageArea.setEditable(false);

        this.setUpComponent();
    }

    public void appear(final String message) {
        super.appear();
        this.messageArea.setText(message);
        this.scrollPanel.resizeViewPanel(this.messageArea.getWidth());
    }

    @Override
    public void appear() {
        super.appear();
        this.messageArea.setText(ResponseInterpreter.interpretResponse(FrameManager.getLastApiResponse()));
        this.scrollPanel.resizeViewPanel(this.messageArea.getWidth());
    }

    @Override
    public void setUpComponent() {
        this.scrollPanel.addComponent(this.messageArea);
        this.scrollPanel.resizeViewPanel(this.messageArea.getWidth());

        this.getCenterPanel().addComponent(this.scrollPanel);
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