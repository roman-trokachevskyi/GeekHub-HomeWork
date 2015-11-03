package com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HomeWork4;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ViewAnimator;

import com.rodico.duke0808.mygeekhub_homeworks.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContainerFragment extends Fragment implements MyDemonstrator {
    FrameLayout container;
    FragmentManager fragmentManager;
    SecondFragment secondFragment;
    Button nextBt;
    Button prevBt;


    public ContainerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_container, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        container = (FrameLayout) getView().findViewById(R.id.container_sec_hw4);
        nextBt = (Button) getView().findViewById(R.id.nextBt_hw4);
        prevBt = (Button) getView().findViewById(R.id.prevBt_hw4);
        nextBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNext();
            }
        });
        prevBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPrev();
            }
        });
    }

    public void setNext(){
        secondFragment = new SecondFragment();
        secondFragment.setText("Next");
        fragmentManager.beginTransaction().replace(R.id.container_sec_hw4, secondFragment, "secFr").commit();
    }
    public void setPrev(){
        secondFragment = new SecondFragment();
        secondFragment.setText("Previous");
        fragmentManager.beginTransaction().replace(R.id.container_sec_hw4, secondFragment, "secFr").commit();
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }
}
