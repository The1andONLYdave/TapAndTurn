package com.gabm.tapandturn.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.gabm.tapandturn.TapAndTurnApplication;
import com.gabm.tapandturn.settings.SettingsKeys;
import com.gabm.tapandturn.settings.SettingsManager;

/**
 * Created by gabm on 17/12/16.
 */

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        final boolean serviceState = TapAndTurnApplication.settings.getBoolean(SettingsKeys.SERVICESTATE, false);
        final boolean autoStart = TapAndTurnApplication.settings.getBoolean(SettingsKeys.START_ON_BOOT, false);
        if (autoStart && serviceState)
            ServiceRotationControlService.Start(context);
    }
}
