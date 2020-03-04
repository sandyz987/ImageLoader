package com.example.demo13;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.demo13.MyUtils.ImageLoader;

public class MainActivity extends AppCompatActivity {
    private Button button,button2;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;
    private ImageView imageView1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String url="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1583295690667&di=8b46f91cfcc86ece8632e99915d26eca&imgtype=0&src=http%3A%2F%2Fyouimg1.c-ctrip.com%2Ftarget%2Ftg%2F490%2F660%2F076%2Fe6a09618df784c32a66a086a01c6d35c.jpg";
        final String url2="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1583241996140&di=3089942d5dbd8ba4756f54b0c55b0521&imgtype=0&src=http%3A%2F%2Fcache.house.sina.com.cn%2Fcitylifehouse%2Fcitylife%2F48%2Fe9%2F20090614_32953_1.jpg";
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        //final ImageController imageItem=ImageLoader.with(MainActivity.this).load("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1963304009,2816364381&fm=26&gp=0.jpg");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageLoader.with(MainActivity.this).load(url).into(imageView1);
                ImageLoader.with(MainActivity.this).load(url).into(imageView2);
                ImageLoader.with(MainActivity.this).load(url).into(imageView3);
                ImageLoader.with(MainActivity.this).load(url).into(imageView4);
                ImageLoader.with(MainActivity.this).load(url).into(imageView5);
                ImageLoader.with(MainActivity.this).load(url).into(imageView6);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView1.setImageBitmap(null);
                imageView2.setImageBitmap(null);
                imageView3.setImageBitmap(null);
                imageView4.setImageBitmap(null);
                imageView5.setImageBitmap(null);
                imageView6.setImageBitmap(null);
            }
        });

    }
}
