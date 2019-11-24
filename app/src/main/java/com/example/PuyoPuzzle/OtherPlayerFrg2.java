package com.example.PuyoPuzzle;

import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class OtherPlayerFrg2 extends Fragment {
    private static Handler mHandler ;
    TextView t2;
    View v;
    int t=0;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.other2, container, false);

        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                t2 = (TextView)v.findViewById(R.id.thread3);
                t2.setText("1 per 1.5sec : "+t+"");
            }
        };

        ViewThread thread = new ViewThread();
        thread.start();
        return v;
    }

    private class ViewThread extends Thread {
        //private static final String TAG = "ExampleThread";

        public ViewThread() {
            // 초기화 작업
        }

        public void run() {
            // 스레드에게 수행시킬 동작들 구현
            while (true) {
                t++;
                try { // 스레드에게 수행시킬 동작들 구현
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //t1.setText(Integer.toString(t));
                mHandler.sendEmptyMessage(0) ;
            }
        }
    }
}