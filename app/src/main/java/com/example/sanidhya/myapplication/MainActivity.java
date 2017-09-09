package com.example.sanidhya.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener{
    private TextView myMessage;
    private GestureDetector gestureDetector;
    private static boolean isClicked = true;
    private  String login_text,pwd_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, login_text, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        final Button btn_login = (Button) findViewById(R.id.btn_click);
        btn_login.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextView txt_hd = (TextView) findViewById(R.id.txt_hd);
                        if (isClicked==true){
                            txt_hd.setText("Welcome to Weddy DB");
                            btn_login.setText("Click Again");
                            isClicked = ! isClicked;
                        }else {
                            txt_hd.setText("Hello Again");
                            btn_login.setText("Click Me");
                            isClicked = ! isClicked;
                        }
                    }
                }
        );

        btn_login.setOnLongClickListener(
                new Button.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        TextView txt_hd = (TextView) findViewById(R.id.txt_hd);
                        txt_hd.setText("Kitna Babayega be");
                        btn_login.setText("Mil gayi shanti");
                        return true;
                    }
                }
        );
        myMessage = (TextView) findViewById(R.id.txt_hd);
        this.gestureDetector = new GestureDetector(this,this);

//        Button btn_check = (Button) findViewById(R.id.btn_click);
//        btn_check.setOnClickListener(
//                new Button.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        EditText txt_lgn = (EditText) findViewById(R.id.edt_txt_login);
//                        EditText txt_pwd = (EditText) findViewById(R.id.edt_txt_pwd);
//                        login_text = txt_lgn.getText().toString();
//                        pwd_text = txt_pwd.getText().toString();
//                    }
//                }
//        );
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        myMessage.setText("SingleTapConfirmed");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        myMessage.setText("DoubleTap");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        myMessage.setText("DoubleTapEvent");
        return false;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        myMessage.setText("onDown");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        myMessage.setText("onSingleTapUp");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        myMessage.setText("onScroll");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        myMessage.setText("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        myMessage.setText("onFling");
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
