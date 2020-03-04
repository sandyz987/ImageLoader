package com.example.demo13.MyUtils;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.util.Pair;

import com.example.demo13.MainActivity;import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    private static MainActivity.ThreadPool threadPool;
    private ThreadPoolExecutor threadPoolExecutor;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case 1:
                    Pair<ImageView,Bitmap> pair=(Pair<ImageView, Bitmap>) msg.obj;
                    pair.first.setImageBitmap(pair.second);
            }

        }
    };

    public Handler getHandler(){
        return handler;
    }


    private ThreadPool(){
        threadPoolExecutor=(ThreadPoolExecutor) Executors.newFixedThreadPool(50);
    }
    public static MainActivity.ThreadPool getInstance(){
        if(threadPool==null){
            synchronized (MainActivity.ThreadPool.class){
                if(threadPool==null){
                    threadPool=new MainActivity.ThreadPool();
                }
            }
        }
        return threadPool;
    }
    public void execute(Runnable task){
        threadPoolExecutor.execute(task);
    }

    public <T> Future<T> submit(Callable<T> callable){
        return threadPoolExecutor.submit(callable);
    }

}
