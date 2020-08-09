package hacine.mohamed.abdelhakim.jobschedular;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MAINACTIVITY" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view) {
        ComponentName componentName = new ComponentName(this , JOB.class) ;
        JobInfo info = new JobInfo.Builder(123 , componentName)
                .setRequiresCharging(true)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setPersisted(true)
                .setPeriodic(15*60*1000)
                .build();

        JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        int resultcode =        scheduler.schedule(info);
        if (resultcode==JobScheduler.RESULT_SUCCESS){

            Log.d(TAG, "JOB ScHEDULED   : ");
        }else {
            Log.d(TAG, "JOB FAILED: ");
        }


    }

    public void cancel(View view) {

JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
jobScheduler.cancel(123);
        Log.d(TAG, "JOB canceled: ");
    }
}