package com.example.demo13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.demo13.MyUtils.ImageLoader;

public class MainActivity extends AppCompatActivity {
    private Button button;
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
        final String url="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1583241996140&di=715de41aff9180298a2eb23ed243898d&imgtype=0&src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201604%2F09%2F214443sxvr8vo6850c50o8.jpg";
        final String url2="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1583241863924&di=c71d4750832504860a5cc2b95efe1cfa&imgtype=0&src=http%3A%2F%2Fa2.att.hudong.com%2F88%2F66%2F300000009075132206669464141.jpg";
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        button=findViewById(R.id.button);
        //final ImageController imageItem=ImageLoader.with(MainActivity.this).load("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1963304009,2816364381&fm=26&gp=0.jpg");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageLoader.with(MainActivity.this).load(url).into(imageView1);
                ImageLoader.with(MainActivity.this).load(url).into(imageView2);
                ImageLoader.with(MainActivity.this).load(url).into(imageView3);
//                ImageLoader.with(MainActivity.this).load(url2).into(imageView4);
//                ImageLoader.with(MainActivity.this).load(url2).into(imageView5);
//                ImageLoader.with(MainActivity.this).load(url2).into(imageView6);
            }
        });

    }
}
