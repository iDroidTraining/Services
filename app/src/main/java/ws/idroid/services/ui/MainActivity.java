package ws.idroid.services.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import ws.idroid.services.R;
import ws.idroid.services.services.*;

public class MainActivity extends AppCompatActivity {

    private Button btnIntent;
    private Button btnService;
    private Button btnBoundService;
    private Button btnJobSceduler;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_menu);
        initViews();
        btnIntent.setOnClickListener(view -> {
            intent = new Intent(MainActivity.this, MyIntentService.class);
            startService(intent);

        });
        //
        btnService.setOnClickListener(view -> {

            intent = new Intent(MainActivity.this, MyService.class);
            startService(intent);

        });
        //
        btnBoundService.setOnClickListener(view -> {

            intent = new Intent(MainActivity.this, BindingActivity.class);
            startActivity(intent);

        });
        btnJobSceduler.setOnClickListener(view -> {
            intent = new Intent(MainActivity.this, JobSchedulerActivity.class);
            startActivity(intent);
        });

    }

    private void initViews() {
        btnIntent = findViewById(R.id.btn_intent);
        btnService = findViewById(R.id.btn_service);
        btnBoundService = findViewById(R.id.btn_bound_service);
        btnJobSceduler = findViewById(R.id.btn_job_scheduler);
    }
}
