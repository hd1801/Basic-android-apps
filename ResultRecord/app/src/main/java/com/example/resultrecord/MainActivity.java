package com.example.resultrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ReportCard> reportCards = new ArrayList<>();
        reportCards.add(new ReportCard("Student A",91.3,81.2,88.9,78.9));
        reportCards.add(new ReportCard("Student B",87.4,81.2,88.9,78.9));
        reportCards.add(new ReportCard("Student C",91.3,81.2,88.9,78.9));
        reportCards.add(new ReportCard("Student D",91.3,81.2,88.9,78.9));
        reportCards.add(new ReportCard("Student E",91.3,81.2,88.9,78.9));
        reportCards.add(new ReportCard("Student F",91.3,81.2,88.9,78.9));
        reportCards.add(new ReportCard("Student G",91.3,81.2,88.9,78.9));
        reportCards.add(new ReportCard("Student H",91.3,81.2,88.9,78.9));
        reportCards.add(new ReportCard("Student I",91.3,81.2,88.9,78.9));
        reportCards.add(new ReportCard("Student J",91.3,81.2,88.9,78.9));
        reportCards.add(new ReportCard("Student K",91.3,81.2,88.9,78.9));
        StudentsAdapter adapter = new StudentsAdapter(this, reportCards);
        ListView slist = (ListView) findViewById(R.id.List_View);
        slist.setAdapter(adapter);
    }


}