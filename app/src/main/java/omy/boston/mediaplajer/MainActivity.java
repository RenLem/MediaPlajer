package omy.boston.mediaplajer;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnPlayStop;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlayStop = (Button) findViewById(R.id.btnPlayStop);
        mediaPlayer = MediaPlayer.create(this, R.raw.sound_embarrassingmoment);

        btnPlayStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.btnPlayStop){
                    if (!mediaPlayer.isPlaying()){
                        mediaPlayer.start();
                        btnPlayStop.setText("Pause");
                    }else {
                        mediaPlayer.pause();
                        btnPlayStop.setText("Play");
                    }
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.release();
    }
}
