package com._2p1team.cmadmin.app.view.components.fencing.table;

import com._2p1team.cmadmin.app.view.components.fencing.Box;
import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import static com._2p1team.cmadmin.support.constants.SizeData.BUTTON_HEIGHT;
import static com._2p1team.cmadmin.support.constants.SizeData.W_BUTTON_WIDTH;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.awt.Rectangle;

@Data
@EqualsAndHashCode(callSuper=true)
public final class TableElement extends Panel implements ComplexComponent {

    private final Box topChildBox;
    private final Box bottomChildBox;
    private final Box parentBox;
    private final Panel connector;

    public TableElement(int x, int y) {
        super(new Rectangle(x, y, W_BUTTON_WIDTH*2, BUTTON_HEIGHT*3), null, new Appearance(AppearanceRepository.TABLE_ELEMENT_APPEARANCE));

        this.topChildBox = new Box(new Rectangle(0, 0, W_BUTTON_WIDTH, BUTTON_HEIGHT), "");
        this.bottomChildBox = new Box(new Rectangle(0, BUTTON_HEIGHT*2, W_BUTTON_WIDTH, BUTTON_HEIGHT), "");
        this.parentBox = new Box(new Rectangle(W_BUTTON_WIDTH, BUTTON_HEIGHT, W_BUTTON_WIDTH, BUTTON_HEIGHT), "");
        this.connector = new Panel();

        this.setUpComponent();
    }

    @Override
    public void setUpComponent() {
        this.addComponent(this.topChildBox);
        this.addComponent(this.bottomChildBox);
        this.addComponent(this.parentBox);
    }

}