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
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import android.graphics.drawable.GradientDrawable;

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
        TextView near =(TextView)QuakeView.findViewById((R.id.near_text_view));
        TextView location =(TextView)QuakeView.findViewById((R.id.Location_text_view));
        TextView magnitude =(TextView)QuakeView.findViewById((R.id.magnitude_text_view));
        TextView time = (TextView)QuakeView.findViewById((R.id.time));



        Date dateObject = new Date(quake.getmTimeInMilliseconds());
        String formattedDate = formatDate(dateObject);
        String a = quake.getmLocation();
        String part1;
        String part2;
        if(a.contains("of")) {
            int b = a.indexOf("of");
            part1 = a.substring(0, b + 2);
            part2 = a.substring(b + 2);
        }
        else
        {
            part2 =a;
            part1= "Near the";
        }
        Double mag = quake.getmMagnitude();
        DecimalFormat formatter = new DecimalFormat("0.00");
        String output = formatter.format(mag);
        date.setText(formattedDate);
        time.setText(formatTime(dateObject));
        near.setText(part1);
        location.setText(part2);
        magnitude.setText(mag.toString());
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();
        // Set the color on the magnitude circle
        int magnitudeColor = getMagnitudeColor(quake.getmMagnitude());
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

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
    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}

