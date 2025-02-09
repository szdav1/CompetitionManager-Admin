package com._2p1team.cmadmin.support.util;

import com._2p1team.cmadmin.support.constants.BeforeLaunchExceptionType;
import lombok.*;

@AllArgsConstructor(access=AccessLevel.NONE)
public final class BeforeLaunchExceptionQueue {

    @Getter
    @Setter
    private static BeforeLaunchExceptionType exceptionType = BeforeLaunchExceptionType.NONE;

}