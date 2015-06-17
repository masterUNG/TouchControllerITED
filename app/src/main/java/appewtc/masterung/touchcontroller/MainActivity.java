package appewtc.masterung.touchcontroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private ImageView topImageView, leftImageView,
            rightImageView, buttonImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        bindWidget();

        touchTOPcontroller();

        touchLEFTcontroller();

        touchRIGHTcontroller();

        touchBUTTONcontroller();


    }   // onCreate

    private void touchBUTTONcontroller() {
        buttonImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    buttonImageView.setImageAlpha(100);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    buttonImageView.setImageAlpha(255);
                }
                return true;
            }
        });
    }

    private void touchRIGHTcontroller() {
        rightImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    rightImageView.setImageAlpha(100);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    rightImageView.setImageAlpha(255);
                }
                return true;
            }
        });
    }

    private void touchLEFTcontroller() {
        leftImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    leftImageView.setImageAlpha(100);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    leftImageView.setImageAlpha(255);
                }

                return true;
            }
        });
    }   //left

    private void touchTOPcontroller() {

        topImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {

                    topImageView.setImageAlpha(100);

                }

                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {

                    topImageView.setImageAlpha(255);

                }


                return true;
            }
        });

    }   //top

    private void bindWidget() {

        topImageView = (ImageView) findViewById(R.id.imvTop);
        leftImageView = (ImageView) findViewById(R.id.imvleft);
        rightImageView = (ImageView) findViewById(R.id.imvRight);
        buttonImageView = (ImageView) findViewById(R.id.imvButton);

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
}   //Main Class
