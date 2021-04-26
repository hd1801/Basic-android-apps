package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsetsAnimationControlListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class QuakeAdapter extends ArrayAdapter<Quake> {

    public QuakeAdapter(@NonNull Context context, @NonNull List<Quake> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View QuakeView = convertView;
        if(QuakeView==null)
            QuakeView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        Quake quake= getItem(position);
        TextView date =(TextView)QuakeView.findViewById((R.id.Date_text_view));
        TextView location =(TextView)QuakeView.findViewById((R.id.Location_text_view));
        TextView magnitude =(TextView)QuakeView.findViewById((R.id.magnitude_text_view));

        date.setText(quake.getmDate());
        location.setText(quake.getmLocation());
        magnitude.setText(quake.getmMagnitude());

        return QuakeView;
    }
}

