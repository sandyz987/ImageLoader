package com.example.demo13.MyUtils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Message;
import androidx.core.util.Pair;

import android.util.Log;
import android.widget.ImageView;

import java.io.ObjectOutputStream;
import java.util.concurrent.Future;

public class ImageItem {
    private String url;
    private Context context;
    ImageItem (String url,Context context){
        this.url=url;
        this.context=context;
    }
    public void into(final ImageView imageView){
        final Future<Bitmap> future= ImageController.get(url);
        Runnable task=new Runnable() {
            @Override
            public void run() {
                try{
                    Bitmap bitmap = future.get();
                    Message msg=new Message();
                    msg.what=1;
                    msg.obj=new Pair<>(imageView,bitmap);
                    ThreadPool.getInstance().getHandler().sendMessage(msg);
                    ImageLoader.with(context).saveImage(url,bitmap);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        ThreadPool.getInstance().execute(task);
    }
}
