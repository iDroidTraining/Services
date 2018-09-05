package ws.idroid.services.services;

import android.app.Service;
import android.content.Intent;
import android.os.*;

public class BindingService extends Service {

    //Bridge used to communicate with the Client Activity
    private final IBinder bridgeBinder = new myLocalBinder();

    public BindingService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return bridgeBinder;

    }

    //my implementation the in Service
    public String getMyName() {
        return "Android Course";
    }

    //The main goal of the Local Binder is to return a reference of the Service Class
    public class myLocalBinder extends Binder {
        public BindingService getService() {
            return BindingService.this;
        }

    }

}
