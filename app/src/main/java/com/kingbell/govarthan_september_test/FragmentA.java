package com.kingbell.govarthan_september_test;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment {

    Button nextButton, prevButton;
    int counter =0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_a,container,false);

        final GalleryActivity gAct= (GalleryActivity) getActivity();

        //Buttons on click Listeners
        nextButton = (Button) v.findViewById(R.id.nextButton);
        prevButton = (Button) v.findViewById(R.id.previousButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             gAct.changeImage();
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gAct.prevImage();
            }
        });

        return v;
    }


}
