package com.india.rit.multimedia;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    Button bt,bt1;
    VideoView vv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.button);
        bt1 = findViewById(R.id.button2);
        vv= findViewById(R.id.videoView);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = "android.resource://com.india.rit.multimedia/"+ R.raw.banana;
                Uri uri=Uri.parse(path);

            //    MediaController mediaController = new MediaController(Video.this);
           //     vv.setMediaController(mediaController);
                vv.requestFocus();
                vv.start();
                //intent i3 = new Intent(mainactivity.this,Vedio.class);
                //startactivity(i3);
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vv.pause();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id./*id of the optinon*/)
        {
            //share via code (chosser)
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");//which type of text you are going to share.
            i.putExtra(Intent.EXTRA_SUBJECT,"RIT");
            i.putExtra(Intent.EXTRA_TEXT,"Download form the following link:https://www.google.com");
            Intent newintent = Intent.createChooser(i/*share intent*/,"Share via");//retruns object from same class.
            startActivity(newintent);
        }


        return super.onOptionsItemSelected(item);
    }
}
