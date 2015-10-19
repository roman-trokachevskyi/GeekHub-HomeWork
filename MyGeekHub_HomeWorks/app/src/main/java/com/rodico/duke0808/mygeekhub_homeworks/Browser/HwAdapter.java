package com.rodico.duke0808.mygeekhub_homeworks.Browser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rodico.duke0808.mygeekhub_homeworks.R;

import java.util.List;

/**
 * Created by duke0808 on 15.10.15.
 */
public class HwAdapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    List<HomeWorkItem> list;

    public HwAdapter(List<HomeWorkItem> list, Context context) {
        this.list = list;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view==null){
            view = layoutInflater.inflate(R.layout.item_activity_layout, parent, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.textView4);
        HomeWorkItem homeWorkItem = (HomeWorkItem) getItem(position);
        textView.setText(homeWorkItem.getName());

        return view;
    }
}
