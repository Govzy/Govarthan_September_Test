package com.kingbell.govarthan_september_test;

import android.speech.SpeechRecognizer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class GalleryActivity extends ActionBarActivity {

    FragmentA fa;
    FragmentC fc;
    fragmentB fb;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        //Fragment initialize
        fa = (FragmentA) getFragmentManager().findFragmentById(R.id.fragment);
        fb= (fragmentB) getFragmentManager().findFragmentById(R.id.fragment2);
        fc= (FragmentC) getFragmentManager().findFragmentById(R.id.fragment3);

    }

    public void updateImage()
    {
        int prog =fc.sb.getProgress();
        fb.mV.setImageResource(fb.img[prog]);

    }

    public void changeImage()
    {
        fa.counter++;
        fa.counter=fa.counter%10;
        fc.sb.setProgress(fa.counter);
        fb.mV.setImageResource(fb.img[fa.counter]);
    }

    public void prevImage()
    {
        if(fa.counter ==0)
        {
            fa.counter=10;
        }
        fa.counter--;
        fa.counter=fa.counter%10;
        fc.sb.setProgress(fa.counter);
        fb.mV.setImageResource(fb.img[fa.counter]);
    }

}
