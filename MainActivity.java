package com.example.studentdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    EditText roll,name,branch,score;
    Button clear,getStud,remove,getAllstud,update,save;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roll=findViewById(R.id.roll);
        name=findViewById(R.id.name);
        branch=findViewById(R.id.branch);
        score=findViewById(R.id.score);
        clear=findViewById(R.id.Clear);
        getStud=findViewById(R.id.getstud);
        getAllstud=findViewById(R.id.getAllstud);
        remove=findViewById(R.id.remove);
        update=findViewById(R.id.update);
        save=findViewById(R.id.saving);
        dbHandler = new DBHandler(MainActivity.this);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // below line is to get data from all edit text fields.
                int rollNum = Integer.parseInt( roll.getText().toString());
                String studName = name.getText().toString();
                String branchnm = branch.getText().toString();
                int scoreval=Integer.parseInt(score.getText().toString());

                // validating if the text fields are empty or not.
                if (roll.getText().toString().isEmpty() || studName.isEmpty() || branchnm.isEmpty() || score.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                }
////////////////
               else {
                    // on below line we are calling a method to add new
                    // course to sqlite data and pass all our values to it.
                    dbHandler.addNewData(rollNum, studName, branchnm, scoreval);

                    // after adding the data we are displaying a toast message.
                    Toast.makeText(MainActivity.this, "Data has been added.", Toast.LENGTH_SHORT).show();
                    roll.setText("");
                    name.setText("");
                    branch.setText("");
                    score.setText("");
                }
            }
        });
        getAllstud.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                                           startActivity(intent);

                                       }
                                   });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // below line is to get data from all edit text fields.
                int rollNum = Integer.parseInt( roll.getText().toString());
                String studName = name.getText().toString();
                String branchnm = branch.getText().toString();
                int scoreval=Integer.parseInt(score.getText().toString());

                // validating if the text fields are empty or not.
                if (roll.getText().toString().isEmpty() && studName.isEmpty() && branchnm.isEmpty() && score.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                }
////////////////
                else {
                    // on below line we are calling a method to add new
                    // course to sqlite data and pass all our values to it.
                    dbHandler.updateData(rollNum, studName, branchnm, scoreval);

                    // after adding the data we are displaying a toast message.
                    Toast.makeText(MainActivity.this, "Data has been added.", Toast.LENGTH_SHORT).show();
                    roll.setText("");
                    name.setText("");
                    branch.setText("");
                    score.setText("");
                }
            }
        });

        //deleteStudent(long l)
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // below line is to get data from all edit text fields.
                int rollNum = Integer.parseInt( roll.getText().toString());
//                String studName = name.getText().toString();
//                String branchnm = branch.getText().toString();
//                int scoreval=Integer.parseInt(score.getText().toString());

                // validating if the text fields are empty or not.
                if (roll.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                }
////////////////
                else {
                    // on below line we are calling a method to add new
                    // course to sqlite data and pass all our values to it.
                    dbHandler.deleteStudent(rollNum);

                    // after adding the data we are displaying a toast message.
                    Toast.makeText(MainActivity.this, "Data has been removed.", Toast.LENGTH_SHORT).show();
                    roll.setText("");
                    name.setText("");
                    branch.setText("");
                    score.setText("");
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roll.setText("");
                name.setText("");
                branch.setText("");
                score.setText("");
            }
        });
        getStud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rollNum = Integer.parseInt( roll.getText().toString());
                if (roll.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                }
                else {
                    // on below line we are calling a method to add new
                    // course to sqlite data and pass all our values to it.
                    String studval=dbHandler.getStud(rollNum);

                    // after adding the data we are displaying a toast message.
                    Toast.makeText(MainActivity.this, studval, Toast.LENGTH_SHORT).show();
                    roll.setText("");
                    name.setText("");
                    branch.setText("");
                    score.setText("");
                }
            }
        });

            }

}