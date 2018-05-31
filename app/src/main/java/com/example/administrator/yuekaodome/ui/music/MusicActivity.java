package com.example.administrator.yuekaodome.ui.music;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.yuekaodome.R;
import com.example.administrator.yuekaodome.ui.music.view.GramophoneView;

import java.io.IOException;

public class MusicActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        final GramophoneView gramophoneView = (GramophoneView)findViewById(R.id.gramophone_view);
        final Button button = (Button)findViewById(R.id.btn_play_pause);
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource("http://sc1.111ttt.cn:8282/2018/1/03m/13/396131229550.m4a?tflag=1519095601&pin=6cd414115fdb9a950d827487b16b5f97#.mp3");
            mediaPlayer.prepare();
            mediaPlayer.setLooping(true);


        } catch (Exception e) {
            e.printStackTrace();
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(gramophoneView.getPlaying()){
                    mediaPlayer.stop();
                    button.setText("点击播放");

                }else{

                    mediaPlayer.start();
                    button.setText("点击暂停");

                }
                gramophoneView.setPlaying(!gramophoneView.getPlaying());
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }
}
