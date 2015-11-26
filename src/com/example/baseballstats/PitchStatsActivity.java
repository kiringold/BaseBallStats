package com.example.baseballstats;

import java.util.ArrayList;

import com.example.baseballstats.database.PitchStatsRow;
import com.example.baseballstats.database.Stats;
import com.example.baseballstats.databaseadaptor.TeamPitchRowAdapter;

import static com.example.baseballstats.constants.PitchColName.*;
import static com.example.baseballstats.constants.TeamNameConstants.*;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PitchStatsActivity extends Activity {
	private String team;
	private boolean desc = true;
	private View moto;
	private String click="";



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pitch_stats);

		Intent i = getIntent();
		team = i.getStringExtra(TEAM_NAME);
		Stats st = new Stats(PitchStatsActivity.this);
		st.createOpen();
		ArrayList<PitchStatsRow> list = st.findPitch(i.getStringExtra(TEAM_NAME));
		Log.d("intentes",i.getStringExtra(TEAM_NAME));
		st.close();
		setActionBar(i.getStringExtra(TEAM_NAME));
		setAdaptor(list);

		OnClickListener number = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = NUMBER_PITCH;
				Stats st = new Stats(PitchStatsActivity.this);
				st.createOpen();
				ArrayList<PitchStatsRow> list;
				if(desc || (moto != v)){
					list = st.findAscSortPitch(team, NUMBER_PITCH);
					desc = false;
				}else{
					list = st.findDescSortPitch(team, NUMBER_PITCH);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.number_pitch)).setOnClickListener(number);


		OnClickListener era = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = EARNED_RUN_AVERAGE_PITCH;
				Stats st = new Stats(PitchStatsActivity.this);
				st.createOpen();
				ArrayList<PitchStatsRow> list;
				if(desc || (moto != v)){
					list = st.findAscSortPitch(team, EARNED_RUN_AVERAGE_PITCH);
					desc = false;
				}else{
					list = st.findDescSortPitch(team, EARNED_RUN_AVERAGE_PITCH);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.earned_run_average_pitch)).setOnClickListener(era);


		OnClickListener games = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = GAMES_PITCH;
				Stats st = new Stats(PitchStatsActivity.this);
				st.createOpen();
				ArrayList<PitchStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortPitch(team, GAMES_PITCH);
					desc = false;
				}else{
					list = st.findAscSortPitch(team, GAMES_PITCH);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.games_pitch)).setOnClickListener(games);


		OnClickListener cog = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = COMPLETE_GAMES_PITCH;
				Stats st = new Stats(PitchStatsActivity.this);
				st.createOpen();
				ArrayList<PitchStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortPitch(team, COMPLETE_GAMES_PITCH);
					desc = false;
				}else{
					list = st.findAscSortPitch(team, COMPLETE_GAMES_PITCH);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.complete_games_pitch)).setOnClickListener(cog);


		OnClickListener shutouts = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = SHUTOUTS_PITCH;
				Stats st = new Stats(PitchStatsActivity.this);
				st.createOpen();
				ArrayList<PitchStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortPitch(team, SHUTOUTS_PITCH);
					desc = false;
				}else{
					list = st.findAscSortPitch(team, SHUTOUTS_PITCH);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.shutouts_pitch)).setOnClickListener(shutouts);


		OnClickListener nbbhbp = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = NOT_BB_HBP_PITCH;
				Stats st = new Stats(PitchStatsActivity.this);
				st.createOpen();
				ArrayList<PitchStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortPitch(team, NOT_BB_HBP_PITCH);
					desc = false;
				}else{
					list = st.findAscSortPitch(team, NOT_BB_HBP_PITCH);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.no_bb_hbp_pitch)).setOnClickListener(nbbhbp);


		OnClickListener wins = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = WINS_PITCH;
				Stats st = new Stats(PitchStatsActivity.this);
				st.createOpen();
				ArrayList<PitchStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortPitch(team, WINS_PITCH);
					desc = false;
				}else{
					list = st.findAscSortPitch(team, WINS_PITCH);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.wins_pitch)).setOnClickListener(wins);


		OnClickListener losses = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = LOSSES_PITCH;
				Stats st = new Stats(PitchStatsActivity.this);
				st.createOpen();
				ArrayList<PitchStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortPitch(team, LOSSES_PITCH);
					desc = false;
				}else{
					list = st.findAscSortPitch(team, LOSSES_PITCH);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.losses_pitch)).setOnClickListener(losses);


		OnClickListener holds = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = HOLDS_PITCH;
				Stats st = new Stats(PitchStatsActivity.this);
				st.createOpen();
				ArrayList<PitchStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortPitch(team, HOLDS_PITCH);
					desc = false;
				}else{
					list = st.findAscSortPitch(team, HOLDS_PITCH);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.holds_pitch)).setOnClickListener(holds);


		OnClickListener holdpoints = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = HOLDS_PONTS_PITCH;
				Stats st = new Stats(PitchStatsActivity.this);
				st.createOpen();
				ArrayList<PitchStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortPitch(team, HOLDS_PONTS_PITCH);
					desc = false;
				}else{
					list = st.findAscSortPitch(team, HOLDS_PONTS_PITCH);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.holds_points_pitch)).setOnClickListener(holdpoints);


		OnClickListener saves = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = SAVES_PITCH;
				Stats st = new Stats(PitchStatsActivity.this);
				st.createOpen();
				ArrayList<PitchStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortPitch(team, SAVES_PITCH);
					desc = false;
				}else{
					list = st.findAscSortPitch(team, SAVES_PITCH);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.saves_pitch)).setOnClickListener(saves);


		OnClickListener winsper = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = WINNING_PERCENTAGE_PITCH;
				Stats st = new Stats(PitchStatsActivity.this);
				st.createOpen();
				ArrayList<PitchStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortPitch(team, WINNING_PERCENTAGE_PITCH);
					desc = false;
				}else{
					list = st.findAscSortPitch(team, WINNING_PERCENTAGE_PITCH);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.winning_percentage_pitch)).setOnClickListener(winsper);


		OnClickListener ip = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = INNINGS_PITCHED_PITCH;
				Stats st = new Stats(PitchStatsActivity.this);
				st.createOpen();
				ArrayList<PitchStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortPitch(team, INNINGS_PITCHED_PITCH);
					desc = false;
				}else{
					list = st.findAscSortPitch(team, INNINGS_PITCHED_PITCH);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.innings_pitched_pitch)).setOnClickListener(ip);


		OnClickListener hits = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = HITS_PITCH;
				Stats st = new Stats(PitchStatsActivity.this);
				st.createOpen();
				ArrayList<PitchStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortPitch(team, HITS_PITCH);
					desc = false;
				}else{
					list = st.findAscSortPitch(team, HITS_PITCH);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.hits_pitch)).setOnClickListener(hits);


		OnClickListener hr = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = HOME_RUNS_PITCH;
				Stats st = new Stats(PitchStatsActivity.this);
				st.createOpen();
				ArrayList<PitchStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortPitch(team, HOME_RUNS_PITCH);
					desc = false;
				}else{
					list = st.findAscSortPitch(team, HOME_RUNS_PITCH);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.home_runs_pitch)).setOnClickListener(hr);


		OnClickListener so = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = STRIKEOUTS_PITCH;
				Stats st = new Stats(PitchStatsActivity.this);
				st.createOpen();
				ArrayList<PitchStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortPitch(team, STRIKEOUTS_PITCH);
					desc = false;
				}else{
					list = st.findAscSortPitch(team, STRIKEOUTS_PITCH);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.strikeouts_pitch)).setOnClickListener(so);


		OnClickListener bb = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = BASES_ON_BALLS_PITCH;
				Stats st = new Stats(PitchStatsActivity.this);
				st.createOpen();
				ArrayList<PitchStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortPitch(team, BASES_ON_BALLS_PITCH);
					desc = false;
				}else{
					list = st.findAscSortPitch(team, BASES_ON_BALLS_PITCH);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.bases_on_balls_pitch)).setOnClickListener(bb);


		OnClickListener hbp = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = HIT_BY_PITCH_PITCH;
				Stats st = new Stats(PitchStatsActivity.this);
				st.createOpen();
				ArrayList<PitchStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortPitch(team, HIT_BY_PITCH_PITCH);
					desc = false;
				}else{
					list = st.findAscSortPitch(team, HIT_BY_PITCH_PITCH);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.hit_by_pitch_pitch)).setOnClickListener(hbp);


		OnClickListener wp = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = WILD_PITCHES_PITCH;
				Stats st = new Stats(PitchStatsActivity.this);
				st.createOpen();
				ArrayList<PitchStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortPitch(team, WILD_PITCHES_PITCH);
					desc = false;
				}else{
					list = st.findAscSortPitch(team, WILD_PITCHES_PITCH);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.wild_pitches_pitch)).setOnClickListener(wp);


		OnClickListener balk = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = BALK_PITCH;
				Stats st = new Stats(PitchStatsActivity.this);
				st.createOpen();
				ArrayList<PitchStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortPitch(team, BALK_PITCH);
					desc = false;
				}else{
					list = st.findAscSortPitch(team, BALK_PITCH);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.balks_pitch)).setOnClickListener(balk);


		OnClickListener runs = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = RUNS_PITCH;
				Stats st = new Stats(PitchStatsActivity.this);
				st.createOpen();
				ArrayList<PitchStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortPitch(team, RUNS_PITCH);
					desc = false;
				}else{
					list = st.findAscSortPitch(team, RUNS_PITCH);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.runs_pitch)).setOnClickListener(runs);


		OnClickListener er = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = EARNED_RUNS_PITCH;
				Stats st = new Stats(PitchStatsActivity.this);
				st.createOpen();
				ArrayList<PitchStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortPitch(team, EARNED_RUNS_PITCH);
					desc = false;
				}else{
					list = st.findAscSortPitch(team, EARNED_RUNS_PITCH);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.earned_runs_pitch)).setOnClickListener(er);


		OnClickListener whip = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = WHIP_PITCH;
				Stats st = new Stats(PitchStatsActivity.this);
				st.createOpen();
				ArrayList<PitchStatsRow> list;
				if(desc || (moto != v)){
					list = st.findAscSortPitch(team, WHIP_PITCH);
					desc = false;
				}else{

					list = st.findDescSortPitch(team, WHIP_PITCH);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.whip_pitch)).setOnClickListener(whip);


		OnClickListener kbb = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = KBB_PITCH;
				Stats st = new Stats(PitchStatsActivity.this);
				st.createOpen();
				ArrayList<PitchStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortPitch(team, KBB_PITCH);
					desc = false;
				}else{
					list = st.findAscSortPitch(team, KBB_PITCH);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.k_bb_pitch)).setOnClickListener(kbb);


	}

	private void setAdaptor(ArrayList<PitchStatsRow> list){
		//アダプタクラスのインスタンス設定
				ListAdapter adapter = new TeamPitchRowAdapter(this, 0, list, desc, click);
				//アダプタ設定
				ListView listView = (ListView)findViewById(R.id.listView1);
				listView.setAdapter(adapter);


	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pitch_stats, menu);
		return true;
	}

	private void setActionBar(String team){
	    ActionBar actionBar = getActionBar();
	     //アクションバーでアプリのアイコンの表示設定
	     actionBar.setDisplayShowHomeEnabled(true);
	     //アクションバーでアプリタイトルの表示設定
	     actionBar.setDisplayShowTitleEnabled(true);
	     //アクションバーで戻るボタンの表示設定
	     actionBar.setDisplayHomeAsUpEnabled(true);

//	     switch(team){
//	     case GIANTS:
	     if(team.equals(GIANTS)){
	    	 actionBar.setIcon(R.drawable.giants_logo);
	    	 actionBar.setTitle("読売ジャイアンツ");
	     }else if(team.equals(TIGERS)){
	    	 actionBar.setIcon(R.drawable.tigers_logo);
	    	 actionBar.setTitle("阪神タイガース");
	     }else if(team.equals(CARP)){
	    	 actionBar.setIcon(R.drawable.carp_logo);
	    	 actionBar.setTitle("広島東洋カープ");
	     }else if(team.equals(DRAGONS)){
	    	 actionBar.setIcon(R.drawable.dragons_logo);
	    	 actionBar.setTitle("中日ドラゴンズ");
	     }else if(team.equals(BAYSTARS)){
	    	 actionBar.setIcon(R.drawable.baystars_logo);
	    	 actionBar.setTitle("横浜DeNAベイスターズ");
	     }else if(team.equals(SWALLOWS)){
	    	 actionBar.setIcon(R.drawable.swallows_logo);
	    	 actionBar.setTitle("東京ヤクルトスワローズ");
	     }else if(team.equals(HAWKS)){
	    	 actionBar.setIcon(R.drawable.hawks_logo);
	    	 actionBar.setTitle("福岡ソフトバンクホークス");
	     }else if(team.equals(BUFFALOES)){
	    	 actionBar.setIcon(R.drawable.buffaloes_logo);
	    	 actionBar.setTitle("オリックスバファローズ");
	     }else if(team.equals(FIGHTERS)){
	    	 actionBar.setIcon(R.drawable.fighters_logo);
	    	 actionBar.setTitle("北海道日本ハムファイターズ");
	     }else if(team.equals(MARINES)){
	    	 actionBar.setIcon(R.drawable.marines_logo);
	    	 actionBar.setTitle("千葉ロッテマリーンズ");
	     }else if(team.equals(LIONS)){
	    	 actionBar.setIcon(R.drawable.lions_logo);
	    	 actionBar.setTitle("埼玉西武ライオンズ");
	     }else if(team.equals(EAGLES)){
	    	 actionBar.setIcon(R.drawable.eagles_logo);
	    	 actionBar.setTitle("東北楽天ゴールデンイーグルス");
	     }else if(team.startsWith(GIANTS + "','" + TIGERS)){
	    	 actionBar.setIcon(R.drawable.central_logo);
	    	 actionBar.setTitle("セントラルリーグ");
	     }else if(team.startsWith(HAWKS + "','" + BUFFALOES)){
	    	 actionBar.setIcon(R.drawable.pacific_logo);
	    	 actionBar.setTitle("パシフィックリーグ");
	     }
	 }


	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch(item.getItemId()){
		case android.R.id.home:
			finish();
			break;
			default:
				break;
		}
		return super.onMenuItemSelected(featureId, item);
	}

}
