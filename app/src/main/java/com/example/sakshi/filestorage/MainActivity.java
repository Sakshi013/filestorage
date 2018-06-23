package com.example.sakshi.filestorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText name,pswd,mail,city;
    Button bttn;
     Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        pswd = findViewById(R.id.pswd);
        mail =findViewById(R.id.mail);
        city = findViewById(R.id.city);
        bttn = findViewById(R.id.bttn);

        spinner = findViewById(R.id.spinner);

        final String[] State ={"Jandk","chandigrah","punjab"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,State);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> AdapterView, View view , int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        bttn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent(MainActivity.this, secondActivity.class);

                                        String userName = name.getText().toString();
                                        String userPassword = pswd.getText().toString();
                                        String userEmail = mail.getText().toString();
                                        String userCity = city.getText().toString();
                                        String spinnerData = spinner.getSelectedItem().toString();

                                        if (TextUtils.isEmpty(name.getText())) {
                                            name.setError("required");
                                            return;
                                        }
                                        if (TextUtils.isEmpty(pswd.getText())) {
                                            pswd.setError("required");
                                            return;

                                        }
                                        if (TextUtils.isEmpty(mail.getText())) {
                                            mail.setError("required");
                                            return;
                                        }
                                        if (TextUtils.isEmpty(city.getText())) {
                                            city.setError("required");
                                            return;
                                        }

                                        //write data


                                        String totalData = "Name :" + userName + "\n" + "Pswd :" + userPassword + "\n" + "mail :" + userEmail + "\n" + "State :" + spinnerData + "\n" + "City :" + userCity;
                                        FileOutputStream fos;

                                        try {
                                            fos = openFileOutput("userData", MODE_PRIVATE);
                                            fos.write(totalData.getBytes());
                                            fos.close();


                                        } catch (FileNotFoundException e) {
                                            e.printStackTrace();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }

                                         startActivity(intent);
                                    }


//       writeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String data = dataEditText.getText().toString();
//
//                if (TextUtils.isEmpty(data)) {
//                    dataEditText.setError("This field is required");
//                    return;
//                }
//                FileOutputStream fos;
//                try {
//                    fos = openFileOutput("userData", MODE_PRIVATE);
//                    fos.write(data.getBytes());
//                    fos.close();
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                readButton.setVisibility(View.VISIBLE);
//                writeButton.setVisibility(outPutTextView.VISIBLE);
//            }
//            });
//
////       readButton
//                  readButton.setOnClickListener(new View.OnClickListener() {
//                      @Override
//                      public void onClick(View v) {
//
//                          BufferedReader input =null;
//                          File file = null;
//
//                          try{
//                              file =getBaseContext().getFileStreamPath("userData");
//                              input =new BufferedReader(new InputStreamReader( new FileInputStream ( file)));
//
//
//                              String line;
//                              StringBuffer buffer =new StringBuffer();
//
//                              while ((line =input.readLine()) !=null){
//                                  buffer.append(line);
//                              }
//                          }catch (IOException e){
//                              e.printStackTrace();
//
//                          }


                  });


    }
}
