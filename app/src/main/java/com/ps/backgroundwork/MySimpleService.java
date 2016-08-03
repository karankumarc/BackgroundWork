package com.ps.backgroundwork;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.io.FileOutputStream;

public class MySimpleService extends Service {

    public MySimpleService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        LogHelper.logThreadId("onStartCommand");

        String messageText = intent.getStringExtra("MessageText");

        FileOutputStream outStream = FileHelper.openOutStream(this, "servicedata.txt");
        for (int i = 0; i < 5; i++) {
            FileHelper.slowWrite(outStream, messageText);
        }
        FileHelper.closeOutStream(outStream);
        return 0;
    }
}
