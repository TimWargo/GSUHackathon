package edu.uga.tmw65104.hackgsuprojectidea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditPerson extends AppCompatActivity {

    Button saveBtn;
    Button cancelBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_person);
    }

    private void createVariables() {
        saveBtn = (Button) findViewById(R.id.saveBtn);
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