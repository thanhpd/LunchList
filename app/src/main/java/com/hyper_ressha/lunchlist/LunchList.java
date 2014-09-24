package com.hyper_ressha.lunchlist;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class LunchList extends Activity {

    Restaurant r = new Restaurant();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_list);

        RadioGroup testLayout = (RadioGroup)findViewById(R.id.types);
        RadioButton test1 = new RadioButton(this);
        RadioButton test2 = new RadioButton(this);
        RadioButton test3 = new RadioButton(this);
        test1.setText("Choice 1");
        test2.setText("Choice 1");
        test3.setText("Choice 1");

        testLayout.addView(test1);
        testLayout.addView(test2);
        testLayout.addView(test3);

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LayoutInflater inflater = LayoutInflater.from(this); // if you're inside of activity then context = this
        View viewInflatedFromXml = inflater.inflate(R.layout.activity_lunch_list, null);
        this.addContentView(viewInflatedFromXml, params);

        Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(onSave);
    }

    private void createRadioButton() {
        ViewGroup.LayoutParams s = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        RadioGroup t = (RadioGroup)findViewById(R.id.types);
        RadioButton reservation = new RadioButton(this);
        reservation.setText("Reservation");
        t.addView(reservation);
        this.addContentView(t, s);

    }

    private View.OnClickListener onSave=new View.OnClickListener() {

        public void onClick(View v) {
            EditText name = (EditText)findViewById(R.id.name);
            EditText address = (EditText)findViewById(R.id.addr);

            r.setName(name.getText().toString());
            r.setAddress(address.getText().toString());

            RadioGroup types = (RadioGroup)findViewById(R.id.types);

            switch (types.getCheckedRadioButtonId()) {
                case R.id.sit_down:
                    r.setType("sit_down");
                    break;
                case R.id.take_out:
                    r.setType("take_out");
                    break;
                case R.id.delivery:
                    r.setType("delivery");
                    break;

            }
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.lunch_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
