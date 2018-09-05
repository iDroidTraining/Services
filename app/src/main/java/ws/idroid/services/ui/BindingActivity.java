package ws.idroid.services.ui;

import android.content.*;
import android.os.*;
import android.support.v7.app.AppCompatActivity;
import android.widget.*;

import ws.idroid.services.*;
import ws.idroid.services.services.BindingService;

public class BindingActivity extends AppCompatActivity {
    TextView txt_result;
    Button btn_get;

    boolean isBound = false;
    BindingService bindingService;
    //same goes with the 'OnServiceDisconnect' here we implement our logic as we leave or unbind
    // from the Service
    private ServiceConnection sConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            BindingService.myLocalBinder binder = (BindingService.myLocalBinder) iBinder;
            bindingService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binding2);

        //this intent will be used to start binding with the service
        Intent i = new Intent(BindingActivity.this, BindingService.class);

        //here the bind starts
        //flag Context.BIND_AUTO_CREATE : is a flag that will bind and start the service
        //we can replace it with 0 ,however in this case  we will bind without starting the
        // service so we need to start it manually later
        //using startService(intent);
        bindService(i, sConnection, Context.BIND_AUTO_CREATE);

        //TextView to show the Result from the service
        txt_result = findViewById(R.id.txt_result);

        btn_get = findViewById(R.id.btn_get);
        btn_get.setOnClickListener(view -> {
            //here we access the service method getMyName to get the data
            String myName = bindingService.getMyName();
            if (isBound)
                txt_result.setText(myName);
            else
                txt_result.setText(R.string.error);
        });

    }

    //Always when I need to bind to a service I need a ServiceConnection
    //it has the belows 2 main methods which I should override
    //OnServiceConnected : normally we use it to get the reference of the service
    //using the local binder which we already developed in the service, as well we can add our
    // logic here..

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
