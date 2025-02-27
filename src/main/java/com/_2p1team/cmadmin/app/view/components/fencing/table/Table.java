package com._2p1team.cmadmin.app.view.components.fencing.table;

import com._2p1team.cmadmin.app.dto.competitor.CompetitorTransferModel;
import com._2p1team.cmadmin.app.view.components.fencing.Box;
import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: Create table element, generate table, fill table, implement control logic
@Data
@EqualsAndHashCode(callSuper=false)
public final class Table extends Panel implements ComplexComponent {

    private static final String tableau8 = "1;8;5;4;3;6;7;2";
    private static final String tableau16 = "1;16;9;8;5;12;13;4;3;14;11;6;7;10;15;2";
    private static final String tableau32 = "1;32;17;16;9;24;25;8;5;28;21;12;13;20;29;4;3;30;19;14;11;22;27;6;7;26;23;10;15;18;31;2";
    private static final String tableau64 = "1;64;33;32;17;48;49;16;9;56;41;24;25;40;57;8;5;60;37;28;21;44;53;12;13;52;45;20;29;36;61;4;3;62;35;30;19;46;51;14;11;54;43;22;27;38;59;6;7;58;39;26;23;42;55;10;15;50;47;18;31;34;63;2";
    private static final String tableau128 = "1;128;65;64;33;96;97;32;17;112;81;48;49;80;113;16;9;120;73;56;41;88;105;24;25;104;89;40;57;72;121;8;5;124;69;60;37;92;101;28;21;108;85;44;53;76;117;12;13;116;77;52;45;84;109;20;29;100;93;36;61;68;125;4;3;126;67;62;35;94;99;30;19;110;83;46;51;78;115;14;11;118;75;54;43;86;107;22;27;102;91;38;59;70;123;6;7;122;71;58;39;90;103;26;23;106;87;42;55;74;119;10;15;114;79;50;47;82;111;18;31;98;95;34;63;66;127;2";
    private static final Map<Integer, String> tableaus = new HashMap<>(Map.of(8, tableau8, 16, tableau16, 32, tableau32, 64, tableau64, 128, tableau128));

    public static final int MINIMUM_SIZE = 8;
    public static final int MAXIMUM_SIZE = 128;

    private final List<CompetitorTransferModel> competitorTransferModels;
    private int tableSize;
    private String tableau;
    private final List<Box> boxes;

    public Table(final List<CompetitorTransferModel> competitorTransferModels) {
        super(new Dimension(0, 0), null, new Appearance(AppearanceRepository.TABLE_PANEL_APPEARANCE));

        this.competitorTransferModels = competitorTransferModels;
        this.tableSize = this.determineTableSize();
        this.tableau = tableaus.get(this.tableSize);
        this.boxes = new ArrayList<>(this.tableSize);

        this.setUpComponent();
    }

    private int determineTableSize() {
        final int numberOfCompetitors = this.competitorTransferModels.size();
        int nPowerOf2 = 3;

        if (numberOfCompetitors > MINIMUM_SIZE) {
            while (Math.pow(2, nPowerOf2) < numberOfCompetitors)
                nPowerOf2++;

            return (int) Math.pow(2, nPowerOf2);
        }
        else
            return MINIMUM_SIZE;
    }

    private void createStructure() {

    }

    @Override
    public void setUpComponent() {
        this.createStructure();
    }

}