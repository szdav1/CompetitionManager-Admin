package com._2p1team.cmadmin.app.control.frame.parts;

import com._2p1team.cmadmin.app.control.AbstractKeyController;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.app.view.frame.parts.TitleBar;
import com._2p1team.cmadmin.general.constants.CompetitionType;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;

public final class TitleBarKeyController extends AbstractKeyController {

    public TitleBarKeyController(final TitleBar keyControlledComponent) {
        super(keyControlledComponent);

        List<Integer> shortcutKeys = List.of(KeyEvent.VK_F1, KeyEvent.VK_F3, KeyEvent.VK_F5, KeyEvent.VK_F2, KeyEvent.VK_F4, KeyEvent.VK_F6, KeyEvent.VK_F8);
        List<String> actionKeys = List.of(
            "NewCompetitionAction",
            "NewPouleAction",
            "NewTableAction",
            "ViewDatabaseAction",
            "AddCompetitorAction",
            "UpdateCompetitorAction",
            "RemoveCompetitorAction"
        );
        List<AbstractAction> actions = List.of(
            new NewCompetitionAction(),
            new NewPouleAction(),
            new NewTableAction(),
            new ViewDatabaseAction(),
            new AddCompetitorAction(),
            new UpdateCompetitorAction(),
            new RemoveCompetitorAction()
        );

        for (int i = 0; i < shortcutKeys.size(); i++) {
            keyControlledComponent
                .getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(shortcutKeys.get(i), 0), actionKeys.get(i));

            keyControlledComponent
                .getActionMap()
                .put(actionKeys.get(i), actions.get(i));
        }
    }

    private static class NewCompetitionAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            FrameManager.displayNewPouleModal(CompetitionType.COMPETITION);
        }

    }

    private static class NewPouleAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            FrameManager.displayNewPouleModal(CompetitionType.POULE_ONLY);
        }

    }

    private static class NewTableAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            FrameManager.displayNewTableModal();
        }

    }

    private static class ViewDatabaseAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            FrameManager.displayViewCompetitorsModal();
        }

    }

    private static class AddCompetitorAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            FrameManager.displayAddCompetitorModal();
        }

    }

    private static class UpdateCompetitorAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            FrameManager.displayUpdateCompetitorModal();
        }

    }

    private static class RemoveCompetitorAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            FrameManager.displayRemoveCompetitorModal();
        }

    }

}