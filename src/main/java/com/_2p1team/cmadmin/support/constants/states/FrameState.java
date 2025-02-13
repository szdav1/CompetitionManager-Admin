package com._2p1team.cmadmin.support.constants.states;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FrameState {
    DEFAULT(0),
    MODAL_OPENED(1),
    CLOSE_FRAME_MODAL_OPENED(2),
    EXCEPTION_MODAL_OPENED(3);

    private final int value;
}