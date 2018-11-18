package com.company.navdr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TopResultActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    TextView textViewTitle;
    TextView textView1;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_result);

        button = (Button) findViewById(R.id.button);
        textViewTitle = (TextView) findViewById(R.id.textTitle);
        textView = (TextView) findViewById(R.id.textView);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);

        //    textViewLink = (TextView) findViewById(R.id.textViewLink);


        Example title = (Example) getIntent().getSerializableExtra("name");
        textViewTitle.setText( title.getTrack().get(0).getStrArtist());

        Example name = (Example) getIntent().getSerializableExtra("name");
        textView.setText("Nr.1: " + name.getTrack().get(0).getStrTrack());

        Example link = (Example) getIntent().getSerializableExtra("name");
        final TextView myClickableUrl = (TextView) findViewById(R.id.textViewLink);
        myClickableUrl.setText("" + link.getTrack().get(0).getStrMusicVid());
        Linkify.addLinks(myClickableUrl, Linkify.WEB_URLS);



        Example name1 = (Example) getIntent().getSerializableExtra("name");
        textView1.setText("Nr.2: " + name1.getTrack().get(1).getStrTrack());

        Example link1 = (Example) getIntent().getSerializableExtra("name");
        final TextView myClickableUrl1 = (TextView) findViewById(R.id.textViewLink1);
        myClickableUrl1.setText("" + link1.getTrack().get(1).getStrMusicVid());
        Linkify.addLinks(myClickableUrl1, Linkify.WEB_URLS);


        Example name2 = (Example) getIntent().getSerializableExtra("name");
        textView2.setText("Nr.3: " + name2.getTrack().get(2).getStrTrack());

        Example link2 = (Example) getIntent().getSerializableExtra("name");
        final TextView myClickableUrl2 = (TextView) findViewById(R.id.textViewLink2);
        myClickableUrl2.setText("" + link2.getTrack().get(2).getStrMusicVid());
        Linkify.addLinks(myClickableUrl2, Linkify.WEB_URLS);




    }

    public void onClick(View view) {
        Intent intent = new Intent(TopResultActivity.this, TopActivity.class);
        startActivity(intent);
    }
}