package com.ps.backgroundwork;

import android.os.*;
import android.util.Log;


public class LogHelper {
    public static void logThreadId(String message) {
        long processId = android.os.Process.myPid();
        long threadId = Thread.currentThread().getId();
        Log.d("BackgroundWork", String.format("[ Process: %d | Thread: %d] %s", processId, threadId, message));
    }


}
