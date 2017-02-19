package bookshare.tomek.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Tomek on 2017-01-21.
 */

public class BoundedService extends Service {

    private final IBinder mBinder = new LocalBinder();

    private Handler handler = new Handler();

    public class LocalBinder extends Binder{
        BoundedService getService(){
            return BoundedService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public void generateToast(){
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(BoundedService.this, "Jestem z service", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
