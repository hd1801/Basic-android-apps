package com.example.resultrecord;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class StudentsAdapter extends ArrayAdapter<ReportCard> {


    public StudentsAdapter(@NonNull Context context, @NonNull ArrayList<ReportCard> Students) {
        super(context, 0, Students);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ReportCard students =getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.resultitem, parent, false);
        }
        // Lookup view for data population
        TextView sName = (TextView) convertView.findViewById(R.id.name_text_view);
        TextView total = (TextView) convertView.findViewById(R.id.total_text_view);
        TextView maths =(TextView) convertView.findViewById(R.id.math_text_view);
        TextView Science =(TextView) convertView.findViewById(R.id.science_text_view);
        TextView history =(TextView) convertView.findViewById(R.id.history_text_view);
        TextView english =(TextView) convertView.findViewById(R.id.eng_text_view);
        // Populate the data into the template view using the data object
        sName.setText(students.getsName());
        String result = String.format("%2f",students.getTotalGrade());
        total.setText(result);
        maths.setText(students.getMathGrade().toString());
        english.setText(students.getEnglishGrade().toString());
        Science.setText(students.getScienceGrade().toString());
        history.setText(students.getHistoryGrade().toString());
        // Return the completed view to render on screen
        return convertView;
    }
}
