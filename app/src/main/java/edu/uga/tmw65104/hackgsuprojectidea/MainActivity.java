package edu.uga.tmw65104.hackgsuprojectidea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    GregorianCalendar currentDayCalendar;

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
        currentDayCalendar = new GregorianCalendar();
        // Creates the list of people to use for the program
        DataParser.initialize();
        textViews = new LinkedList<>();
    }


    private void setLayouts() {
        titleTextView.setText(generateTitleString());
        nextBtn.setText(">");
        prevBtn.setText("<");
        nextBtn.setClickable(false);
        /* This is fun coding */
        LinkedList<String[]> list = DataParser.dateEntries(generateDateString());
        for(int i = 0; i < list.size(); i++) {
            textViews.add(new TextView(getApplicationContext()));
            textViews.getLast().setText(DataParser.getName(list.get(i)));
            contactListLinearLayout.addView(textViews.getLast());
        } // for

    } // setLayouts

    private void createFunctionality() {
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AddPersonActivity.class);
                Date date = java.util.Calendar.getInstance().getTime();
                i.putExtra("edu.uga.tmw65104.hackgsuprojectidea.DATE", generateDateString());
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
                if (isInBounds(1)) {
                    setDateShown(1);
                    titleTextView.setText(generateTitleString());
                    LinkedList<String[]> list = DataParser.dateEntries(generateDateString());
                    textViews.clear();
                    contactListLinearLayout.removeAllViews();
                    for (int i = 0; i < list.size(); i++) {
                        textViews.add(new TextView(getApplicationContext()));
                        textViews.get(i).setText(DataParser.getName(list.get(i)));
                        contactListLinearLayout.addView(textViews.get(i));
                    }
                } else {
                    nextBtn.setClickable(false);
                }
            }
        });
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInBounds(-1)) {
                    setDateShown(-1);
                    titleTextView.setText(generateTitleString());
                    LinkedList<String[]> list = DataParser.dateEntries(generateDateString());
                    textViews.clear();
                    contactListLinearLayout.removeAllViews();
                    for (int i = 0; i < list.size(); i++) {
                        textViews.add(new TextView(getApplicationContext()));
                        textViews.get(i).setText(DataParser.getName(list.get(i)));
                        contactListLinearLayout.addView(textViews.get(i));
                    }
                } else {
                    prevBtn.setClickable(false);
                }
            }
        });
    } // createFunctionality

    private void setDateShown(int offset) {
        calendar.add(Calendar.DAY_OF_MONTH, offset);
        dateShown = calendar.getTime();
    }

    private String generateTitleString() {

        String calendarMonth = calendar.get(Calendar.MONTH) + 1 + "";
        String calendarDay = calendar.get(Calendar.DAY_OF_MONTH) + "";
        String calendarYear = calendar.get(Calendar.YEAR) + "";

        if (calendarDay.length() != 2) {
            calendarDay = "0" + calendarDay;
        } // if
        if (calendarMonth.length() != 2) {
            calendarMonth = "0" + calendarMonth;
        }

        return calendarMonth + "/"
                + calendarDay + "/"
                + calendarYear;
    }

    private String generateDateString() {

        String calendarMonth = calendar.get(Calendar.MONTH) + 1 + "";
        String calendarDay = calendar.get(Calendar.DAY_OF_MONTH) + "";
        String calendarYear = calendar.get(Calendar.YEAR) + "";

        if (calendarDay.length() != 2) {
            calendarDay = "0" + calendarDay;
        } // if
        if (calendarMonth.length() != 2) {
            calendarMonth = "0" + calendarMonth;
        }

        return calendarYear + calendarMonth + calendarDay;
    }

    private boolean isInBounds(int offset) {
        GregorianCalendar tempCalendar = new GregorianCalendar(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        tempCalendar.add(Calendar.DAY_OF_MONTH, offset);
        if (tempCalendar.compareTo(currentDayCalendar) > 0 || tempCalendar.compareTo(currentDayCalendar) < -14) {
            return false;
        } else {
            return true;
        }
    }
}