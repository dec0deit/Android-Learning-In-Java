package com.example.gridviewwithimageandtext;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomerAdaptor extends BaseAdapter {
    String[] arr={"alarm","android","mobile","website","profile","profile"};
    int [] imageName={R.drawable.alarm,R.drawable.images,R.drawable.images,R.drawable.website,R.drawable.profile,R.drawable.website};


    LayoutInflater inflter;
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = inflter.inflate(R.layout.row_data,null);
        //getting view in row_data
        TextView name = view1.findViewById(R.id.text);
        ImageView image = view1.findViewById(R.id.icon);

        name.setText(arr[i]);
        image.setImageResource(imageName[i]);
        return view1;
    }
}
