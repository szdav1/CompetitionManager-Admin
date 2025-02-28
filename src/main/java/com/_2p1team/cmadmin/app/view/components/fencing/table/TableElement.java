package com._2p1team.cmadmin.app.view.components.fencing.table;

import com._2p1team.cmadmin.app.view.components.fencing.Box;
import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import static com._2p1team.cmadmin.support.constants.SizeData.*;
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

    public TableElement() {
        this(new Box(TABLE_ELEMENT_CHILD_BOUNDS, ""), new Box(TABLE_ELEMENT_CHILD_BOUNDS, ""), BUTTON_HEIGHT);
    }

    public TableElement(final Box topChildBox, final Box bottomChilBox, int horizontalGap) {
        super(new Rectangle(W_BUTTON_WIDTH*2, BUTTON_HEIGHT*3), null, new Appearance(AppearanceRepository.TABLE_ELEMENT_APPEARANCE));

        this.topChildBox = topChildBox;
        this.bottomChildBox = bottomChilBox;
        this.parentBox = new Box(TABLE_ELEMENT_CHILD_BOUNDS, "");
        this.connector = new Panel();
    }

    @Override
    public void setUpComponent() {
    }

}