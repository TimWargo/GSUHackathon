package edu.uga.tmw65104.hackgsuprojectidea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class AddPersonActivity extends AppCompatActivity {

    EditText nameText;
    Button addBtn;
    Button cancelBtn;
    EditText phoneText;
    String currentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);
        setFunctionality();

        if(getIntent().hasExtra("edu.uga.tmw65104.hackgsuprojectidea.DATE")) {
            currentDate = getIntent().getExtras().getString("edu.uga.tmw65104.hackgsuprojectidea.DATE");
        }


    }

    private void setFunctionality() {
        nameText = (EditText) findViewById(R.id.nameText);
        phoneText = (EditText) findViewById(R.id.phoneText);
        addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString();
                String phoneNum = phoneText.getText().toString();
                //DataParser.add(phoneNum, name, currentDate);
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("edu.uga.tmw65104.hackgsuprojectidea.NAME", name);
                startActivity(i);
            }
        });
    }
}