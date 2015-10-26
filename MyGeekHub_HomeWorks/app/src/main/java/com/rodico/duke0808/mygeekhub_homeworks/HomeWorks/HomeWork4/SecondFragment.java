package com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HomeWork4;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rodico.duke0808.mygeekhub_homeworks.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
    TextView textView;
    String text;


    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void setText(String text){
        this.text = text;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = (TextView) getView().findViewById(R.id.sec_tv_hw4);
        textView.setText(text);
    }
}
