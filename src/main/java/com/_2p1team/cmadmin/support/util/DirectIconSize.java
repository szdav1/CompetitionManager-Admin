package com._2p1team.cmadmin.support.util;

import com._2p1team.cmadmin.support.constants.SizeData;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.awt.Dimension;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class DirectIconSize {
    public static Dimension sizeByFrame(int widthPercentage, int heightPercentage) {
        int width = SizeData.FRAME_WIDTH*widthPercentage/100;
        int height = SizeData.FRAME_HEIGHT*heightPercentage/100;

        return new Dimension(width, height);
    }
}