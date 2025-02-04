package com._2p1team.cmadmin.support.util;

import com._2p1team.cmadmin.support.constants.BeforeLaunchException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access=AccessLevel.NONE)
public final class BeforeLaunchExceptionQueue {

    public static BeforeLaunchException exceptionType = BeforeLaunchException.NONE;
}