package com.kingbell.govarthan_september_test;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.kingbell.govarthan_september_test.R.id.shareButton;


public class LocateActivity extends ActionBarActivity {

    Button direction1,shareBtn;
    TextView webText;
    Intent intent = null;
    Intent chooser = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locate);

        //Set Map it Button click even Listener
        direction1 = (Button) findViewById(R.id.direction1);
        direction1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:12.935345,77.607612"));
                chooser = Intent.createChooser(intent, "Launch Maps");
                startActivity(chooser);
                //  Toast toast = Toast.makeText(LocateActivity.this,"Hll",Toast.LENGTH_SHORT);
            }
        });

        //text view on click event
        webText = (TextView) findViewById(R.id.websiteText);
        webText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LocateActivity.this,WebsiteActivity.class);
                String name = webText.getText().toString();
                intent.putExtra("urlA",name);
                startActivity(intent);
            }
        });

        //Share Button Onlcick Listener
        shareBtn = (Button) findViewById(shareButton);
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String webInfo = webText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");

                intent.putExtra(Intent.EXTRA_TEXT, "Just Shawarma Restaurant @Christ University- "+webInfo);
                //        Intent chooser = Intent.createChooser(intent, "Share Text");
                startActivity(intent);

            }
        });

    }


}
