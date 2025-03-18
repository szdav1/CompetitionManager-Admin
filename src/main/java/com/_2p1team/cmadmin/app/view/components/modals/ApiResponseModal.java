package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.http.ResponseInterpreter;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import static com._2p1team.cmadmin.general.constants.AppearanceConstants.PADDING;
import static com._2p1team.cmadmin.general.constants.SizeData.BUTTON_HEIGHT;
import com._2p1team.cmadmin.general.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.scrollpanel.ScrollPanel;
import com._2p1team.cmadmin.swing.override.components.text.area.TextArea;

import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

public final class ApiResponseModal extends AbstractModal {

    private final ScrollPanel scrollPanel;
    private final TextArea messageField;

    public ApiResponseModal() {
        super();
        this.setTitle("Api Response");

        this.scrollPanel = new ScrollPanel(this.getCenterPanel().getPreferredSize(), new FlowLayout(FlowLayout.CENTER, 0, 0), AppearanceRepository.BASE_SCROLL_PANEL_APPEARANCE);
        this.scrollPanel.setScrollSpeed(BUTTON_HEIGHT);

        this.messageField = new TextArea(new Dimension(this.scrollPanel.getWidth()-PADDING, this.scrollPanel.getHeight()-PADDING), "", AppearanceRepository.MODAL_BACKGROUND_APPEARANCE);
        this.messageField.setLineWrap(true);
        this.messageField.setWrapStyleWord(true);
        this.messageField.setEditable(false);

        this.setUpComponent();
    }

    @Override
    public void appear() {
        super.appear();
        this.messageField.setText(ResponseInterpreter.interpretResponse(FrameManager.getLastApiResponse()));
        this.scrollPanel.resizeViewPanel(this.messageField.getWidth());
    }

    @Override
    public void setUpComponent() {
        this.scrollPanel.addComponent(this.messageField);
        this.scrollPanel.resizeViewPanel(this.messageField.getWidth());

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