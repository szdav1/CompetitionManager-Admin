package com._2p1team.cmadmin.support.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

@NoArgsConstructor(access=AccessLevel.PRIVATE)
public final class SizeData {

    public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int SCREEN_WIDTH = SCREEN_SIZE.width;
    public static final int SCREEN_HEIGHT = SCREEN_SIZE.height;

    public static final Dimension FRAME_SIZE = SCREEN_SIZE;

    public static final int FRAME_WIDTH = FRAME_SIZE.width;
    public static final int TITLE_WIDTH = FRAME_WIDTH;
    public static final int N_BUTTON_WIDTH = FRAME_WIDTH*2/100;
    public static final int TITLE_TEXT_WIDTH = FRAME_WIDTH*32/100;
    public static final int SIDEBAR_WIDTH = FRAME_WIDTH*15/100;
    public static final int W_LABEL_WIDTH = FRAME_WIDTH*25/100;
    public static final int MODAL_WIDTH = FRAME_WIDTH*70/100;
    public static final int FRAME_HEIGHT = FRAME_SIZE.height;
    public static final int TITLE_HEIGHT = FRAME_HEIGHT*4/100;
    public static final Dimension TITLE_SIZE = new Dimension(TITLE_WIDTH, TITLE_HEIGHT);
    public static final int BUTTON_HEIGHT = TITLE_HEIGHT;
    public static final Dimension N_BUTTON_SIZE = new Dimension(N_BUTTON_WIDTH, BUTTON_HEIGHT);
    public static final Dimension W_LABEL_SIZE = new Dimension(W_LABEL_WIDTH, BUTTON_HEIGHT);
    public static final Dimension TITLE_TEXT_SIZE = new Dimension(TITLE_TEXT_WIDTH, TITLE_HEIGHT);
    public static final int BUTTON_WIDTH = FRAME_HEIGHT*13/100;
    public static final Dimension BUTTON_SIZE = new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT);
    public static final int W_BUTTON_WIDTH = FRAME_HEIGHT*18/100;
    public static final Dimension W_BUTTON_SIZE = new Dimension(W_BUTTON_WIDTH, BUTTON_HEIGHT);
    public static final Dimension SIDEBAR_SIZE = new Dimension(SIDEBAR_WIDTH, FRAME_HEIGHT);
    public static final int MODAL_HEIGHT = FRAME_HEIGHT*70/100;
    public static final Dimension MODAL_SIZE = new Dimension(MODAL_WIDTH, MODAL_HEIGHT);
    public static final Rectangle MODAL_BOUNDS = new Rectangle((FRAME_WIDTH/2)-(MODAL_WIDTH/2), (FRAME_HEIGHT/2)-(MODAL_HEIGHT/2), MODAL_WIDTH, MODAL_HEIGHT);

}