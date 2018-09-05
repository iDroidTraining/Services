package ws.idroid.services.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {

    private static final String TAG = "Services";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //here my code will go !
        Log.i(TAG, "Service is onHandleIntent ");
    }
}
