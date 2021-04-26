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

import java.text.SimpleDateFormat;
import java.util.Date;
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
        TextView time = (TextView)QuakeView.findViewById((R.id.time));
        Date dateObject = new Date(quake.getmTimeInMilliseconds());
        String formattedDate = formatDate(dateObject);
        date.setText(formattedDate);
        time.setText(formatTime(dateObject));
        location.setText(quake.getmLocation());
        magnitude.setText(quake.getmMagnitude());

        return QuakeView;
    }
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}

