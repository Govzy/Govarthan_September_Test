package com.kingbell.govarthan_september_test;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MenuActivity extends ActionBarActivity {

    String[] itemName ={"Just Shawarma","Malgom Shawarma", "Shawarma On Plate"};
    String[] price ={"$5.99","$6.99","$7.99"};
    int[] image ={R.drawable.js,R.drawable.plate,R.drawable.wholemeat};

    ListView ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ls= (ListView) findViewById(R.id.listView);

        customAdapter adapter = new customAdapter(this,itemName,price,image);
        ls.setAdapter(adapter);
    }

    //Custom Adapter
    public class customAdapter extends ArrayAdapter<String> {

        Context context;
        String [] itemNameData;
        String [] itemPriceData;
        int[] imageNameData;
        public customAdapter(Context context, String[] itemNamed, String[] itemPrice, int[] imageName) {
            super(context, R.layout.single_row, itemNamed);
            this.context=context;
            this.itemNameData=itemNamed;
            this.itemPriceData=itemPrice;
            this.imageNameData=imageName;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.single_row,parent,false);
            ImageView img = (ImageView) row.findViewById(R.id.imageView);
            TextView name = (TextView) row.findViewById(R.id.textView1);
            TextView dia = (TextView) row.findViewById(R.id.textView2);

            img.setImageResource(imageNameData[position]);
            name.setText(itemNameData[position]);
            dia.setText(itemPriceData[position]);
            return row;

        }
    }
}