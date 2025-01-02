package com._2p1team.cmadmin.support.appdata;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.awt.Dimension;
import java.awt.Toolkit;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SizeData {
    public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int SCREEN_WIDTH = SCREEN_SIZE.width;
    public static final int SCREEN_HEIGHT = SCREEN_SIZE.height;

    public static final int TITLE_WIDTH = SCREEN_WIDTH;
    public static final int TITLE_HEIGHT = SCREEN_HEIGHT*5/100;
    public static final Dimension TITLE_SIZE = new Dimension(TITLE_WIDTH, TITLE_HEIGHT);

    public static final int N_BUTTON_WIDTH = SCREEN_WIDTH*2/100;
    public static final int BUTTON_WIDTH = SCREEN_HEIGHT*6/100;
    public static final int W_BUTTON_WIDTH = SCREEN_HEIGHT*12/100;
    public static final int BUTTON_HEIGHT = TITLE_HEIGHT;
    public static final Dimension N_BUTTON_SIZE = new Dimension(N_BUTTON_WIDTH, BUTTON_HEIGHT);
    public static final Dimension BUTTON_SIZE = new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT);
    public static final Dimension W_BUTTON_SIZE = new Dimension(W_BUTTON_WIDTH, BUTTON_HEIGHT);

    public static final int TITLE_TEXT_WIDTH = SCREEN_WIDTH*32/100;
    public static final Dimension TITLE_TEXT_SIZE = new Dimension(TITLE_TEXT_WIDTH, TITLE_HEIGHT);

    public static final int SIDEBAR_WIDTH = SCREEN_WIDTH*15/100;
    public static final Dimension SIDEBAR_SIZE =new Dimension(SIDEBAR_WIDTH, SCREEN_HEIGHT);
}