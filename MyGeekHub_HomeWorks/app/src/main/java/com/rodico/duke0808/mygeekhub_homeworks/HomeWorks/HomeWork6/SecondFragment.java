package com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HomeWork6;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.rodico.duke0808.mygeekhub_homeworks.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {


    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second2, container, false);
    }

    public void showImage(int n){
        ImageView view = (ImageView) getActivity().findViewById(R.id.hw6_img_view);
        int[] images = {R.drawable.sample_0,R.drawable.sample_1, R.drawable.sample_2,
                R.drawable.sample_3,R.drawable.sample_4
        ,R.drawable.sample_5,R.drawable.sample_6,R.drawable.sample_7};
        view.setImageResource(images[n]);
    }


}
