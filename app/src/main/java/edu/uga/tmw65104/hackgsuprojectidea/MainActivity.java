package edu.uga.tmw65104.hackgsuprojectidea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    TextView titleTextView;
    Button addBtn;
    Button editBtn;
    Button nextBtn;
    Button prevBtn;
    LinearLayout contactListLinearLayout;
    LinkedList<TextView> textViews;
    Date dateShown;
    GregorianCalendar calendar;
    private int offset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the Variables
        createVariables();

        // Sets the layouts for certain variables
        setLayouts();

        // Create functionality
        createFunctionality();
    }

    private void createVariables() {
        titleTextView = (TextView) findViewById(R.id.titleTextView);
        addBtn = (Button) findViewById(R.id.addBtn);
        editBtn = (Button) findViewById(R.id.editBtn);
        contactListLinearLayout = (LinearLayout) findViewById(R.id.contactListLinearLayout);
        prevBtn = (Button) findViewById(R.id.prevBtn);
        nextBtn = (Button) findViewById(R.id.nextBtn);

        dateShown = java.util.Calendar.getInstance().getTime();
        calendar = new GregorianCalendar();
        offset = 0;
        // Creates the list of people to use for the program
        DataParser.initialize();
    }


    private void setLayouts() {
        titleTextView.setText(generateDateString(offset));
        nextBtn.setText(">");
        prevBtn.setText("<");
    } // setLayouts

    private void createFunctionality() {
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AddPersonActivity.class);
                Date date = java.util.Calendar.getInstance().getTime();
                i.putExtra("edu.uga.tmw65104.hackgsuprojectidea.DATE", generateDateString(offset));
                startActivity(i);
            }
        });
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), EditPerson.class);
                startActivity(i);
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something
            }
        });
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something
            }
        });
    } // createFunctionality

    private void addPerson() {
        // ENTER CODE HERE TO ADD A PERSON
        /*
        System.out.println(textViews.add(new TextView(getApplicationContext())));
        textViews.getLast().setText(getIntent().getExtras().getString("edu.uga.tmw65104.hackgsuprojectidea.NAME"));
        for(int i = 0; i < textViews.size(); i++) {
            contactListLinearLayout.addView(textViews.get(i));
        } // for
        */
    }

    private String generateDateString(int offset) {
        calendar.add(Calendar.DAY_OF_MONTH, offset);
        dateShown = calendar.getTime();
        return calendar.get(Calendar.MONTH) + "/"
                + calendar.get(Calendar.DAY_OF_MONTH) + "/"
                + calendar.get(Calendar.YEAR);
    }
}