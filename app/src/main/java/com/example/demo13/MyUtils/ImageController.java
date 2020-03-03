package com.example.demo13.MyUtils;

import android.graphics.Bitmap;
import android.os.Message;
import android.widget.ImageView;

import androidx.core.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

public class ImageController {
    private static Map<String,Future<android.graphics.Bitmap>> imageData=new ConcurrentHashMap<>();
    public static void add(String url, Future<android.graphics.Bitmap> future){
        imageData.put(url,future);
    }
    public static Future<android.graphics.Bitmap> get(String url){
        return imageData.get(url);
    }

}
