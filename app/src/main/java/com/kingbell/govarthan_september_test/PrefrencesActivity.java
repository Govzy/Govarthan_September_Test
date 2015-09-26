package com.kingbell.govarthan_september_test;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;


public class PrefrencesActivity extends ActionBarActivity {

    RadioGroup rg;
    TextView tv,specialTV,commentText;
    String updateDiet;
    String updateToggle;
    String updateComment;
    String updateReset;
    ToggleButton tb;
    EditText et;
    Button addButton,resetButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefrences);

        tv = (TextView) findViewById(R.id.dietText);
        tv.setText("You love meat");
        rg = (RadioGroup) findViewById(R.id.radioG);
        rg.check(R.id.meatR);
        tb = (ToggleButton) findViewById(R.id.toggleButton);
        specialTV= (TextView) findViewById(R.id.specialsText);
        et = (EditText) findViewById(R.id.commentEdit);
        addButton = (Button) findViewById(R.id.addButton);
        commentText = (TextView) findViewById(R.id.commentText);
        resetButton = (Button) findViewById(R.id.resetButton);


        //Shared Prefrences
        SharedPreferences prefs = getSharedPreferences("MyDataDiet", MODE_PRIVATE);
        final String test=prefs.getString("dietName","Empty");
        if(test.equals("Empty"))
        {
            updateDiet="Empty";
        }
        else {
            updateDiet=test;
            if(updateDiet.equals("You hate Animals"))
            {
                rg.check(R.id.vegR);
            }

            if(updateDiet.equals("You love meat"))
            {
                rg.check(R.id.meatR);
            }
            if(updateDiet.equals("You are a vegan"))
            {
                rg.check(R.id.veganR);
            }
            if(updateDiet.equals("You are kosher")){
                rg.check(R.id.kosherR);
            }
            if(updateDiet.equals("You are halal")){
                rg.check(R.id.halalR);
            }
            updateDietMethod();
        }
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                    switch (checkedId) {
                        case R.id.vegR:
                            updateDiet = "You hate Animals";
                            break;
                        case R.id.meatR:
                            updateDiet = "You love meat";
                            break;
                        case R.id.veganR:
                            updateDiet = "You are a vegan";
                            break;
                        case R.id.kosherR:
                            updateDiet = "You are kosher";
                            break;
                        case R.id.halalR:
                            updateDiet = "You are halal";
                            break;

                    }
                    updateDietMethod();

            }
        });


        //toggle
        SharedPreferences prefs1 = getSharedPreferences("toggleUpdater", MODE_PRIVATE);
        final String test1=prefs1.getString("toggleName","Empty");
        if(test1.equals("Don't send me speicals"))
        {
            updateToggle="Don't send me speicals";
            toggleUpdater();
            tb.setChecked(false);
        }
        else if(test1.equals("Send me Specials"))
        {
             {
                updateToggle = "Send me Specials";
                toggleUpdater();
                tb.setChecked(true);
            }
        }


        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    updateToggle="Send me Specials";
                } else {
                    updateToggle="Don't send me speicals";
                }
                toggleUpdater();
            }
        });

        SharedPreferences prefs2 = getSharedPreferences("commentUpdater", MODE_PRIVATE);
        final String test2=prefs2.getString("updateComment","Empty");
        if(!test2.equals("Empty"))
        {
            updateComment=test2;
            commentUpdater();
        }

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateComment = et.getText().toString();
                commentUpdater();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResetUpdater();
            }
        });
    }

    //Set the text
    public void updateDietMethod(){
        SharedPreferences sharedPreferences= getSharedPreferences("MyDataDiet", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("dietName",updateDiet);
        editor.commit();
        tv.setText(updateDiet);
    }

    public void toggleUpdater()
    {    SharedPreferences sharedPreferences= getSharedPreferences("toggleUpdater", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("toggleName",updateToggle);
        editor.commit();
        specialTV.setText(updateToggle);
    }
    public void commentUpdater()
    {
        et.setVisibility(View.INVISIBLE);
        addButton.setVisibility(View.INVISIBLE);

        commentText.setVisibility(View.VISIBLE);
        resetButton.setVisibility(View.VISIBLE);
        SharedPreferences sharedPreferences= getSharedPreferences("commentUpdater", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("updateComment",updateComment);
        editor.commit();

        commentText.setText(updateComment);
    }
    public  void ResetUpdater()
    {
        commentText.setVisibility(View.INVISIBLE);
        resetButton.setVisibility(View.INVISIBLE);

        et.setVisibility(View.VISIBLE);
        addButton.setVisibility(View.VISIBLE);
    }
}
