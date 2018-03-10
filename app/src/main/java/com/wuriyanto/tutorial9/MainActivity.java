package com.wuriyanto.tutorial9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listViewPlayers;
    private ArrayAdapter<String> playerAdapter;

    private String[] playerDatas = {"Thibout Curtois", "Willian Borges", "Eden Hazard", "Gary Cahlil",
            "Pedro Rodriguez", "Ngolo Kante", "David Luiz", "Cesc Fabregas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewPlayers = (ListView) findViewById(R.id.lv_players);

        loadPlayerDatas();

        listViewPlayers.setAdapter(playerAdapter);

        //event on item click
        listViewPlayers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String player = playerAdapter.getItem(position);

                Toast.makeText(getApplicationContext(), "You Choose : "+player, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void loadPlayerDatas(){
        playerAdapter = new ArrayAdapter<String>(this, R.layout.player_list_detail, playerDatas);
    }
}
