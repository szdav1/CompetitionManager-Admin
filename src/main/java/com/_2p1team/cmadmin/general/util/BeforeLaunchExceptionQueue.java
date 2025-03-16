package com._2p1team.cmadmin.general.util;

import com._2p1team.cmadmin.general.constants.BeforeLaunchExceptionType;
import lombok.*;

@AllArgsConstructor(access=AccessLevel.NONE)
public final class BeforeLaunchExceptionQueue {

    @Getter
    @Setter
    private static BeforeLaunchExceptionType exceptionType = BeforeLaunchExceptionType.NONE;

}