package com.example.music1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class MusicActivity extends AppCompatActivity {
    //创建链表
    private List<Song> songList;
    //创建播放控制对象
    private ControlPlay controlPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        //检验权限
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            //申请权限
            ActivityCompat.requestPermissions(this,new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            },1);
        }
        else {
            //给链表赋值
            songList = MusicData.getInstance(this).getSongList();
        }
        //给播放控制对象赋值
        controlPlay = ControlPlay.getInstance();
        //创建适配器
        MusicAdapter musicAdapter = new MusicAdapter(this,songList);
        //绑定视图
        ListView listView = (ListView)findViewById(R.id.list_item);
        //设置监听
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //创建临时歌曲对象
                Song song = (Song) adapterView.getAdapter().getItem(i);
                //保存当前歌曲
                MusicData.getInstance().setCurSong(song);
                //保存当前歌曲的ID
                MusicData.getInstance().setCurIndex(i);
                //播放歌曲
                controlPlay.playMusic(song.getPath());
                //页面跳转
                Intent intent = new Intent(MusicActivity.this,Music2Activity.class);
                startActivity(intent);
            }
        });
        //设置适配器
        listView.setAdapter(musicAdapter);
    }
}
