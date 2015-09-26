package com.kingbell.govarthan_september_test;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentB extends Fragment {
    int []img={R.drawable.js,R.drawable.plate,
            R.drawable.wholemeat,R.drawable.mercury,
            R.drawable.venus,R.drawable.earth,
            R.drawable.jupiter,R.drawable.saturn,R.drawable.uranus,R.drawable.mars};
    ImageView mV;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_b,container,false);

        //imageview
        mV = (ImageView) v.findViewById(R.id.imageViewB);
        return v;
    }


}
