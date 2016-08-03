package com.ps.backgroundwork;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import java.io.FileOutputStream;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogHelper.logThreadId("MainActivity Thread");

        setupButtons();
    }

    private void setupButtons() {
        findViewById(R.id.btnDoLongRunningWork).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDoLongRunningWorkOnClick((Button) v);
            }
        });
        findViewById(R.id.btnStartMonitoring).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnStartMonitoringOnClick((Button) v);
            }
        });
        findViewById(R.id.btnStopMonitoring).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnStopMonitoringOnClick((Button) v);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void btnDoLongRunningWorkOnClick(Button button) {
        LogHelper.logThreadId("btnDoLongRunningWorkOnClick");
        String messageText = "This is the message from the Activity.";

        FileOutputStream outStream = FileHelper.openOutStream(this, "servicedata.txt");
        for (int i = 0; i < 5; i++) {
            FileHelper.slowWrite(outStream, messageText);
        }
        FileHelper.closeOutStream(outStream);

    }

    private void btnStartMonitoringOnClick(Button button) {
        LogHelper.logThreadId("btnStartMonitoringOnClick");

    }

    private void btnStopMonitoringOnClick(Button button) {
        LogHelper.logThreadId("btnStopMonitoringOnClick");
    }
}
