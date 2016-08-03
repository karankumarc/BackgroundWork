package com.ps.backgroundwork;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;


public class MyLocationListener implements LocationListener {

    @Override
    public void onLocationChanged(Location location) {
        LogHelper.logThreadId(String.format("Provider:%s - Location:%.6f/%.6f",
                location.getProvider(), location.getLatitude(), location.getLongitude()));
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle bundle) {
        String statusMessage = "unknown";
        switch (status) {
            case LocationProvider.AVAILABLE:
                statusMessage = "Available";
                break;
            case LocationProvider.TEMPORARILY_UNAVAILABLE:
                statusMessage = "Temporarily Unavailable";
                break;
            case LocationProvider.OUT_OF_SERVICE:
                statusMessage = "Out of Service";
                break;
        }

        LogHelper.logThreadId(String.format("Provider:%s Status changed - new status:%s", provider, statusMessage));
    }

    @Override
    public void onProviderEnabled(String provider) {
        LogHelper.logThreadId(String.format("Provider:%s ENABLED", provider));
    }

    @Override
    public void onProviderDisabled(String provider) {
        LogHelper.logThreadId(String.format("Provider:%s DISABLED", provider));
    }
}
