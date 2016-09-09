package com.example.mitchelle.cohort7.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mitchelle.cohort7.R;


/**
 * Created by mitchelle on 8/31/16.
 */
public class DrawerNavigationListAdapter extends ArrayAdapter<String> {
    public DrawerNavigationListAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if( convertView == null ) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from( getContext() ).inflate( R.layout.avigation_list_item, parent, false );
            convertView.setTag( holder );
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.title = (TextView) convertView.findViewById( R.id.title );
        holder.title.setText( getItem( position ) );

        return convertView;
    }


}