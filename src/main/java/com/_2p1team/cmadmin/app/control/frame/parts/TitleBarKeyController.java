package com._2p1team.cmadmin.app.control.frame.parts;

import com._2p1team.cmadmin.app.control.AbstractKeyController;
import com._2p1team.cmadmin.app.view.frame.parts.TitleBar;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;

public final class TitleBarKeyController extends AbstractKeyController {
    public TitleBarKeyController(final TitleBar keyControlledComponent) {
        super(keyControlledComponent);

        List<Integer> shortcutKeys = List.of(KeyEvent.VK_F1, KeyEvent.VK_F3, KeyEvent.VK_F5, KeyEvent.VK_F2, KeyEvent.VK_F4, KeyEvent.VK_F6);
        List<String> actionKeys = List.of("NewCompetitionAction", "NewPouleAction", "NewTableAction", "ViewDatabaseAction", "AddFencerAction", "RemoveFencerAction");
        List<AbstractAction> actions = List.of(new NewCompetitionAction(), new NewPouleAction(), new NewTableAction(), new ViewDatabaseAction(), new AddFencerAction(), new RemoveFencerAction());

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
            System.out.println("New Competition");
        }
    }

    private static class NewPouleAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("New poule");
        }
    }

    private static class NewTableAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("New table");
        }
    }

    private static class ViewDatabaseAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("View database");
        }
    }

    private static class AddFencerAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Add fencer");
        }
    }

    private static class RemoveFencerAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Remove fencer");
        }
    }
}