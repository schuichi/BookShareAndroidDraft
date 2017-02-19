package bookshare.tomek.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

/**
 * Created by Tomek on 2017-01-21.
 */

public class SimpleService extends IntentService {

    Handler handler = new Handler();

    public SimpleService() {
        super("SimpleService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        for (int i = 0; i <= 10; i++){
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "Jestem z sevice", Toast.LENGTH_SHORT).show();

                }
            });
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }


}
