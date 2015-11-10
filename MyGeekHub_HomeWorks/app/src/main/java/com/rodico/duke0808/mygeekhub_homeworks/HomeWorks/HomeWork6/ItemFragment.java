package com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HomeWork6;

import android.app.Activity;
import android.os.Bundle;
import android.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.rodico.duke0808.mygeekhub_homeworks.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A fragment representing a list of Items.
 * <p/>
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnFragmentInteractionListener}
 * interface.
 */
public class ItemFragment extends ListFragment {

    private OnFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Map<String, String>> list = new ArrayList<>();
        HashMap<String,String> map;
        map = new HashMap<>();
        map.put("label", "Show Dog #1");
        list.add(map);
        map = new HashMap<>();
        map.put("label", "Show Dog #2");
        list.add(map);
        map = new HashMap<>();
        map.put("label", "Show Dog #3");
        list.add(map);
        map = new HashMap<>();
        map.put("label", "Show Dog #4");
        list.add(map);
        map = new HashMap<>();
        map.put("label", "Show Dog #5");
        list.add(map);
        map = new HashMap<>();
        map.put("label", "Show Dog #6");
        list.add(map);
        map = new HashMap<>();
        map.put("label", "Show Dog #7");
        list.add(map);
        map = new HashMap<>();
        map.put("label", "Show Dog #8");
        list.add(map);




        // TODO: Change Adapter to display your content
        String[] from = {"label"};
        int[] to = {android.R.id.text1};
        setListAdapter(new SimpleAdapter(getActivity(),list,android.R.layout.simple_list_item_1,from,to));
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        if (null != mListener) {
            // Notify the active callbacks interface (the activity, if the
            // fragment is attached to one) that an item has been selected.
            mListener.onFragmentInteraction(position);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(int position);
    }

}
