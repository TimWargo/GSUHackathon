package edu.uga.tmw65104.hackgsuprojectidea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Guideline;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import java.util.LinkedList;

public class EditPerson extends AppCompatActivity {

    Button saveBtn;
    Button cancelBtn;
    TextView titleTextView;
    LinearLayout contactListLinearLayout;
    LinkedList<String[]> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_person);
        createVariables();
        setLayout();
        setFunctionality();
    }






    private void createVariables() {
        saveBtn = (Button) findViewById(R.id.saveBtn);
        titleTextView = (TextView) findViewById(R.id.titleTextView);
        contactListLinearLayout = (LinearLayout) findViewById(R.id.editPersonListLinearLayout);
        list = DataParser.dateEntries(getIntent().getExtras().getString("edu.uga.tmw65104.hackgsuprojectidea.DATE"));
    }

    private void setLayout() {
        titleTextView.setText(getIntent().getExtras().getString("edu.uga.tmw65104.hackgsuprojectidea.DATE"));
        for(int i = 0; i < list.size(); i++) {
            LinearLayout horizontalLayout = new LinearLayout(getApplicationContext());
            horizontalLayout.setOrientation(LinearLayout.HORIZONTAL);
            TextView t = new TextView(getApplicationContext());
            t.setText(DataParser.getName(list.get(i)));
            t.setTextSize(25);
            ImageButton deleteBtn = new ImageButton(getApplicationContext());
            deleteBtn.setImageDrawable(getResources().getDrawable(R.drawable.trashcan));
            horizontalLayout.addView(t);
            horizontalLayout.addView(deleteBtn);
            contactListLinearLayout.addView(horizontalLayout);

        }
    }

    private void setFunctionality() {
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                String name = nameText.getText().toString();
                String time = dateTimeText.getText().toString();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("edu.uga.tmw65104.hackgsuprojectidea.NAME", name);
                i.putExtra("edu.uga.tmw65104.hackgsuprojectidea.TIME", time);
                startActivity(i);
                */
            }
        });
    }
}