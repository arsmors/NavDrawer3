package com.company.navdr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.Gson;

public class TopActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    String name1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        AndroidNetworking.initialize(getApplicationContext());

        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
    }

    public void onClick(View view) {
        String name = editText.getText().toString();
        if (name.length() == 0) {
            editText.setError("You must enter band name");
        } else {

            AndroidNetworking.get("https://theaudiodb.com/api/v1/json/195003/track-top10.php?s=" +name)
                    .setPriority(Priority.HIGH)
                    .build()
                    .getAsString(new StringRequestListener() {
                        //сделать сетевой запрос
                        @Override
                        public void onResponse(String response) {
                            Gson gson = new Gson();
                            Example objectFromResponse = gson.fromJson(response, Example.class);
//                        changeMainText(objectFromResponse.getTrack().get(1).getStrTrack());
//                        changeMainText(objectFromResponse.getTrack().get(1).getStrGenre());
                            Intent intent = new Intent(TopActivity.this, TopResultActivity.class);
                            intent.putExtra("name", objectFromResponse);
                            startActivity(intent);
                        }

                        @Override
                        public void onError(ANError anError) {
                            int a = 0;
                        }
                    });

        }
    }
}