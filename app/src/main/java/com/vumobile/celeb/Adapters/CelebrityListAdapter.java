package com.vumobile.celeb.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vumobile.celeb.R;
import com.vumobile.celeb.Utils.CelebrityClass;

import java.util.List;

/**
 * Created by toukirul on 12/4/2017.
 */

public class CelebrityListAdapter extends ArrayAdapter<CelebrityClass> {

    Context mContext;

    public CelebrityListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public CelebrityListAdapter(Context context, int resource, List<CelebrityClass> items) {
        super(context, resource, items);
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.celeb_list_row, null);
        }

        CelebrityClass p = getItem(position);

        if (p != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.txtCelebName);
            ImageView tt2 = (ImageView) v.findViewById(R.id.imgCeleb);
            if (tt1 != null) {
                tt1.setText(p.getCeleb_name());
            }

            if (tt2 != null) {
                Picasso.with(mContext).load(p.getCeleb_image()).into(tt2);
            }
        }

        return v;
    }

}
