package ro.pub.cs.systems.eim.practicaltest01;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class PracticalTest01Service extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int left = intent.getIntExtra(Constants.LEFT_TEXT, 0);
        int right = intent.getIntExtra(Constants.RIGHT_TEXT, 0);

        ProcessingThread processingThread = new ProcessingThread(this, left, right);
        processingThread.start();

        return START_REDELIVER_INTENT;
    }
}
