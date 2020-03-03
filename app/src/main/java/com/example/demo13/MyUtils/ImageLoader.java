package com.example.demo13.MyUtils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class ImageLoader {
    private static ImageLoader imageLoader;
    private Context context;


    private ImageLoader(Context context){
        this.context=context;
    }

    public static ImageLoader with(Context context){
        if(imageLoader==null){
            synchronized (ImageLoader.class){
                if(imageLoader==null){
                    imageLoader=new ImageLoader(context);
                }
            }
        }
        return imageLoader;
    }

    public ImageItem load(final String url){
        Callable<Bitmap> callable=new Callable<Bitmap>() {
            @Override
            public Bitmap call() throws Exception {
                Log.d("sandyzhang",url);
                URL url1=new URL(url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url1.openConnection();
                httpURLConnection.setRequestMethod("GET");
                //BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                Bitmap bitmap= BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                httpURLConnection.getInputStream().close();
                httpURLConnection.disconnect();
                return bitmap;
            }
        };
        try{
            Future<Bitmap> future=ThreadPool.getInstance().submit(callable);
            ImageController.add(url,future);

            return new ImageItem(url);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {

        }
    }


}
