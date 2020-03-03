package com.example.demo13.MyUtils;

import android.graphics.Bitmap;
import android.os.Message;
import androidx.core.util.Pair;

import android.util.Log;
import android.widget.ImageView;

import java.util.concurrent.Future;

public class ImageItem {
    private String url;
    ImageItem (String url){
        this.url=url;
    }
    public void into(final ImageView imageView){
        final Future<Bitmap> future= ImageController.get(url);
        Thread thread = new Thread(){

            @Override
            public void run() {
                super.run();
                try{
                    Bitmap bitmap = future.get();
                    Message msg=new Message();
                    msg.what=1;
                    msg.obj=new Pair<>(imageView,bitmap);
                    ThreadPool.getInstance().getHandler().sendMessage(msg);
                    Log.d("sandyzhang","2222");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        ThreadPool.getInstance().execute(thread);
    }
}
