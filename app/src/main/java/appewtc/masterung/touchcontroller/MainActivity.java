package appewtc.masterung.touchcontroller;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import ioio.lib.api.DigitalOutput;
import ioio.lib.api.exception.ConnectionLostException;
import ioio.lib.util.BaseIOIOLooper;
import ioio.lib.util.IOIOLooper;
import ioio.lib.util.android.IOIOActivity;

public class MainActivity extends IOIOActivity{

    //Explicit
    private ImageView topImageView, leftImageView,
            rightImageView, buttonImageView;
    private boolean sing1ABoolean, sing2ABoolean,
            sing3ABoolean, sing4ABoolean;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        bindWidget();

        //Clear Status
        clearStatus();

        touchTOPcontroller();

        touchLEFTcontroller();

        touchRIGHTcontroller();

        touchBUTTONcontroller();


    }   // onCreate

    private void clearStatus() {
        sing1ABoolean = false;
        sing2ABoolean = false;
        sing3ABoolean = false;
        sing4ABoolean = false;
    }

    class Looper extends BaseIOIOLooper {

        //Explicit
        private DigitalOutput sing1DigitalOutput, sing2DigitalOutput,
                            sing3DigitalOutput, sing4DigitalOutput;

        @Override
        protected void setup() throws ConnectionLostException, InterruptedException {

            sing1DigitalOutput = ioio_.openDigitalOutput(1, false);
            sing2DigitalOutput = ioio_.openDigitalOutput(2, false);
            sing3DigitalOutput = ioio_.openDigitalOutput(3, false);
            sing4DigitalOutput = ioio_.openDigitalOutput(4, false);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, "Connected IOIO Board OK !!!", Toast.LENGTH_SHORT).show();
                }
            });

            //super.setup();
        }   // setup

        @Override
        public void loop() throws ConnectionLostException, InterruptedException {

            sing1DigitalOutput.write(sing1ABoolean);
            sing2DigitalOutput.write(sing2ABoolean);
            sing3DigitalOutput.write(sing3ABoolean);
            sing4DigitalOutput.write(sing4ABoolean);

            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //super.loop();
        }   //loop


    }   // Looper Class

    protected IOIOLooper createIOIOLooper() {

        return new Looper();
    }




    private void touchBUTTONcontroller() {
        buttonImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    buttonImageView.setImageAlpha(100);
                    soundEffect();

                    //Backward
                    sing1ABoolean = true;
                    sing2ABoolean = true;

                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    buttonImageView.setImageAlpha(255);
                    clearStatus();
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
                    soundEffect();

                    //Turn Right
                    sing1ABoolean = true;
                    sing4ABoolean = true;

                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    rightImageView.setImageAlpha(255);
                    clearStatus();
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
                    soundEffect();


                    //Turn Left
                    sing2ABoolean = true;
                    sing3ABoolean = true;

                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    leftImageView.setImageAlpha(255);
                    clearStatus();
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

                    soundEffect();

                    //Forward
                    sing3ABoolean = true;
                    sing4ABoolean = true;

                }

                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {

                    topImageView.setImageAlpha(255);

                    clearStatus();

                }


                return true;
            }
        });

    }   //top

    private void soundEffect() {
        MediaPlayer mySound = MediaPlayer.create(getBaseContext(), R.raw.effect_btn_shut);
        mySound.start();
    }


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
