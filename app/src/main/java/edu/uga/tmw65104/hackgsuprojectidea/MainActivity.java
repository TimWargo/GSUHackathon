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

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    TextView titleTextView;
    Button addBtn;
    LinearLayout contactListLinearLayout;
    LinkedList<TextView> textViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleTextView = (TextView) findViewById(R.id.titleTextView);
        addBtn = (Button) findViewById(R.id.addBtn);
        contactListLinearLayout = (LinearLayout) findViewById(R.id.contactListLinearLayout);
        textViews = new LinkedList<>();
        setLayouts();
        if(getIntent().hasExtra("edu.uga.tmw65104.hackgsuprojectidea.NAME") &&
            getIntent().hasExtra("edu.uga.tmw65104.hackgsuprojectidea.TIME")) {
            addPerson();
        }
    }


    private void setLayouts() {
        titleTextView.setText("Today");
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AddPersonActivity.class);
                startActivity(i);
            }
        });
    } // setLayouts

    private void addPerson() {
        System.out.println(textViews.add(new TextView(getApplicationContext())));
        textViews.getLast().setText(getIntent().getExtras().getString("edu.uga.tmw65104.hackgsuprojectidea.NAME"));
        contactListLinearLayout.addView(textViews.getLast());

    }
}