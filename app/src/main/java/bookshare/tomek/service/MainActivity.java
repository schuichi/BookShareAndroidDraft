package bookshare.tomek.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private BoundedService mService;
    private boolean isConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Intent i = new Intent(this, BoundedService.class);
        bindService(i, mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        if (isConnected){
            unbindService(mConnection);
        }
        super.onDestroy();
    }

    @OnClick(R.id.buttonRun)
    public void runButton(){
    //    startService(new Intent(this, SimpleService.class));
        if (isConnected){
            mService.generateToast();
        }

    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder service) {
            BoundedService.LocalBinder binder = (BoundedService.LocalBinder) service;
            mService = binder.getService();
            isConnected = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isConnected = false;

        }
    };
}
