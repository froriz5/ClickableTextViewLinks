package com.feliperoriz.clickabletextviewlinks;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Toast;

public class ExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClickableTextView textView = (ClickableTextView) findViewById(R.id.clickedTextView);
        if (textView == null) {
            return;
        }

        String testString = "One, Two, Three, Four";
        textView.setText(testString);

        // Create First Link Substring
        ClickableLink link1 = new ClickableLink("One", new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(widget.getContext(), "Clicked One", Toast.LENGTH_LONG).show();
            }
        });

        // Create Second Link Substring
        ClickableLink link2 = new ClickableLink("Two", new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(widget.getContext(), "Clicked Two", Toast.LENGTH_LONG).show();
            }
        }, Color.RED);

        // Create Third Link Substring
        ClickableLink link3 = new ClickableLink("Three,", new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(widget.getContext(), "Clicked Three", Toast.LENGTH_LONG).show();
            }
        }, Color.BLUE);

        textView.addLinks(link1, link2, link3);
    }
}
