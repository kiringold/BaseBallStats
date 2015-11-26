package com.example.baseballstats;

import static com.example.baseballstats.constants.FieldColName.AT_BATS_FIELDER;
import static com.example.baseballstats.constants.FieldColName.BASES_ON_BALLS_FIELDER;
import static com.example.baseballstats.constants.FieldColName.BATTING_AVERAGE_FIELDER;
import static com.example.baseballstats.constants.FieldColName.BATTING_AVERAGE_WITH_RUNNERS_IN_SCORING_POSITION_FIELDER;
import static com.example.baseballstats.constants.FieldColName.DOUBLE_FIELDER;
import static com.example.baseballstats.constants.FieldColName.DOUBLE_PLAY_FIELDER;
import static com.example.baseballstats.constants.FieldColName.ERRORS_FIELDER;
import static com.example.baseballstats.constants.FieldColName.GAMES_FIELDER;
import static com.example.baseballstats.constants.FieldColName.GAME_WINNING_RUNS_BATTED_IN_FIELDER;
import static com.example.baseballstats.constants.FieldColName.HITS_FIELDER;
import static com.example.baseballstats.constants.FieldColName.HIT_BY_PITCH_FIELDER;
import static com.example.baseballstats.constants.FieldColName.HOME_RUNS_FIELDER;
import static com.example.baseballstats.constants.FieldColName.ISOD_FIELDER;
import static com.example.baseballstats.constants.FieldColName.NUMBER_FIELDER;
import static com.example.baseballstats.constants.FieldColName.ON_BASE_PERCENTAGE_FIELDER;
import static com.example.baseballstats.constants.FieldColName.OPS_FIELDER;
import static com.example.baseballstats.constants.FieldColName.PLATE_APPEARANCES_FIELDER;
import static com.example.baseballstats.constants.FieldColName.RUNS_FIELDER;
import static com.example.baseballstats.constants.FieldColName.RUN_BATTED_IN_FIELDER;
import static com.example.baseballstats.constants.FieldColName.SACRIFICE_FLIES_FIELDER;
import static com.example.baseballstats.constants.FieldColName.SACRIFICE_HITS_FIELDER;
import static com.example.baseballstats.constants.FieldColName.SLUGGING_PERCENTAGE_FIELDER;
import static com.example.baseballstats.constants.FieldColName.STOLEN_BASES_FIELDER;
import static com.example.baseballstats.constants.FieldColName.STRIKEOUTS_FIELDER;
import static com.example.baseballstats.constants.FieldColName.TOTAL_BASES_FIELDER;
import static com.example.baseballstats.constants.FieldColName.TRIPLE_FIELDER;
import static com.example.baseballstats.constants.TeamNameConstants.BAYSTARS;
import static com.example.baseballstats.constants.TeamNameConstants.BUFFALOES;
import static com.example.baseballstats.constants.TeamNameConstants.CARP;
import static com.example.baseballstats.constants.TeamNameConstants.DRAGONS;
import static com.example.baseballstats.constants.TeamNameConstants.EAGLES;
import static com.example.baseballstats.constants.TeamNameConstants.FIGHTERS;
import static com.example.baseballstats.constants.TeamNameConstants.GIANTS;
import static com.example.baseballstats.constants.TeamNameConstants.HAWKS;
import static com.example.baseballstats.constants.TeamNameConstants.LIONS;
import static com.example.baseballstats.constants.TeamNameConstants.MARINES;
import static com.example.baseballstats.constants.TeamNameConstants.SWALLOWS;
import static com.example.baseballstats.constants.TeamNameConstants.TEAM_NAME;
import static com.example.baseballstats.constants.TeamNameConstants.TIGERS;

import java.util.ArrayList;

import com.example.baseballstats.database.FielderStatsRow;
import com.example.baseballstats.database.Stats;
import com.example.baseballstats.databaseadaptor.LeagueFielderRowAdaptor;

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

public class LeagueStatsFielderActivity extends Activity {
	private String team;
	private boolean desc = true;
	private View moto;
	private String click="";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_league_stats_fielder);

		Intent i = getIntent();
		team = i.getStringExtra(TEAM_NAME);
		Stats st = new Stats(LeagueStatsFielderActivity.this);
		st.createOpen();
		ArrayList<FielderStatsRow> list = st.findFielder(team);
		Log.d("intentes",team);
		st.close();
		setActionBar(team);
		setAdaptor(list);

		OnClickListener number = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = NUMBER_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findAscSortFielder(team, NUMBER_FIELDER);
					desc = false;
				}else{
					list = st.findDescSortFielder(team, NUMBER_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.number_fielder)).setOnClickListener(number);


		OnClickListener ave = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = BATTING_AVERAGE_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortFielder(team, BATTING_AVERAGE_FIELDER);
					desc = false;
				}else{
					list = st.findAscSortFielder(team, BATTING_AVERAGE_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.batting_average_fielder)).setOnClickListener(ave);


		OnClickListener games = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = GAMES_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortFielder(team, GAMES_FIELDER);
					desc = false;
				}else{
					list = st.findAscSortFielder(team, GAMES_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.games_fielder)).setOnClickListener(games);


		OnClickListener pap = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = PLATE_APPEARANCES_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortFielder(team, PLATE_APPEARANCES_FIELDER);
					desc = false;
				}else{
					list = st.findAscSortFielder(team, PLATE_APPEARANCES_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.plate_appearances_fielder)).setOnClickListener(pap);


		OnClickListener atbats = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = AT_BATS_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortFielder(team, AT_BATS_FIELDER);
					desc = false;
				}else{
					list = st.findAscSortFielder(team, AT_BATS_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.at_bats_fielder)).setOnClickListener(atbats);


		OnClickListener hits = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = HITS_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortFielder(team, HITS_FIELDER);
					desc = false;
				}else{
					list = st.findAscSortFielder(team, HITS_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.hits_fielder)).setOnClickListener(hits);


		OnClickListener db = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = DOUBLE_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortFielder(team, DOUBLE_FIELDER);
					desc = false;
				}else{
					list = st.findAscSortFielder(team, DOUBLE_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.double_fielder)).setOnClickListener(db);


		OnClickListener triple = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = TRIPLE_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortFielder(team, TRIPLE_FIELDER);
					desc = false;
				}else{
					list = st.findAscSortFielder(team, TRIPLE_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.triple_fielder)).setOnClickListener(triple);


		OnClickListener hr = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = HOME_RUNS_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortFielder(team, HOME_RUNS_FIELDER);
					desc = false;
				}else{
					list = st.findAscSortFielder(team, HOME_RUNS_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.home_runs_fielder)).setOnClickListener(hr);


		OnClickListener tb = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = TOTAL_BASES_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortFielder(team, TOTAL_BASES_FIELDER);
					desc = false;
				}else{
					list = st.findAscSortFielder(team, TOTAL_BASES_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.total_bases_fielder)).setOnClickListener(tb);


		OnClickListener rbi = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = RUN_BATTED_IN_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortFielder(team, RUN_BATTED_IN_FIELDER);
					desc = false;
				}else{
					list = st.findAscSortFielder(team, RUN_BATTED_IN_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.runs_battend_in_fielder)).setOnClickListener(rbi);


		OnClickListener runs = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = RUNS_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortFielder(team, RUNS_FIELDER);
					desc = false;
				}else{
					list = st.findAscSortFielder(team, RUNS_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.runs_fielder)).setOnClickListener(runs);


		OnClickListener so = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = STRIKEOUTS_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortFielder(team, STRIKEOUTS_FIELDER);
					desc = false;
				}else{
					list = st.findAscSortFielder(team, STRIKEOUTS_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.strikeouts_fielder)).setOnClickListener(so);


		OnClickListener bb = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = BASES_ON_BALLS_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortFielder(team, BASES_ON_BALLS_FIELDER);
					desc = false;
				}else{
					list = st.findAscSortFielder(team, BASES_ON_BALLS_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.bases_on_balls_fielder)).setOnClickListener(bb);


		OnClickListener hbp = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = HIT_BY_PITCH_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortFielder(team, HIT_BY_PITCH_FIELDER);
					desc = false;
				}else{
					list = st.findAscSortFielder(team, HIT_BY_PITCH_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.hit_by_pitch_fielder)).setOnClickListener(hbp);


		OnClickListener sach = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = SACRIFICE_HITS_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortFielder(team, SACRIFICE_HITS_FIELDER);
					desc = false;
				}else{
					list = st.findAscSortFielder(team, SACRIFICE_HITS_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.sacrifice_hits_fielder)).setOnClickListener(sach);




		OnClickListener sacf = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = SACRIFICE_FLIES_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortFielder(team, SACRIFICE_FLIES_FIELDER);
					desc = false;
				}else{
					list = st.findAscSortFielder(team, SACRIFICE_FLIES_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.sacrifice_flies_fielder)).setOnClickListener(sacf);


		OnClickListener stb = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = STOLEN_BASES_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortFielder(team, STOLEN_BASES_FIELDER);
					desc = false;
				}else{
					list = st.findAscSortFielder(team, STOLEN_BASES_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.stolen_bases_fielder)).setOnClickListener(stb);


		OnClickListener obp = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = ON_BASE_PERCENTAGE_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortFielder(team, ON_BASE_PERCENTAGE_FIELDER);
					desc = false;
				}else{
					list = st.findAscSortFielder(team, ON_BASE_PERCENTAGE_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.on_base_percentage_fielder)).setOnClickListener(obp);


		OnClickListener slp = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = SLUGGING_PERCENTAGE_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortFielder(team, SLUGGING_PERCENTAGE_FIELDER);
					desc = false;
				}else{
					list = st.findAscSortFielder(team, SLUGGING_PERCENTAGE_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.slugging_percentage_fielder)).setOnClickListener(slp);


		OnClickListener brs = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = BATTING_AVERAGE_WITH_RUNNERS_IN_SCORING_POSITION_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortFielder(team, BATTING_AVERAGE_WITH_RUNNERS_IN_SCORING_POSITION_FIELDER);
					desc = false;
				}else{
					list = st.findAscSortFielder(team, BATTING_AVERAGE_WITH_RUNNERS_IN_SCORING_POSITION_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.batting_average_with_runners_in_scoring_position_fielder)).setOnClickListener(brs);


		OnClickListener wrbi = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = GAME_WINNING_RUNS_BATTED_IN_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortFielder(team, GAME_WINNING_RUNS_BATTED_IN_FIELDER);
					desc = false;
				}else{
					list = st.findAscSortFielder(team, GAME_WINNING_RUNS_BATTED_IN_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.game_winning_runs_batted_in_fielder)).setOnClickListener(wrbi);


		OnClickListener dp = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = DOUBLE_PLAY_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortFielder(team, DOUBLE_PLAY_FIELDER);
					desc = false;
				}else{
					list = st.findAscSortFielder(team, DOUBLE_PLAY_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.double_play_fielder)).setOnClickListener(dp);


		OnClickListener errors = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = ERRORS_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortFielder(team, ERRORS_FIELDER);
					desc = false;
				}else{
					list = st.findAscSortFielder(team, ERRORS_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.errors_fielder)).setOnClickListener(errors);


		OnClickListener ops = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = OPS_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortFielder(team, OPS_FIELDER);
					desc = false;
				}else{
					list = st.findAscSortFielder(team, OPS_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.ops_fielder)).setOnClickListener(ops);


		OnClickListener isoD = new OnClickListener() {
			@Override
			public void onClick(View v) {
				click = ISOD_FIELDER;
				Stats st = new Stats(LeagueStatsFielderActivity.this);
				st.createOpen();
				ArrayList<FielderStatsRow> list;
				if(desc || (moto != v)){
					list = st.findDescSortFielder(team, ISOD_FIELDER);
					desc = false;
				}else{
					list = st.findAscSortFielder(team, ISOD_FIELDER);
					desc = true;
				}
				st.close();
				setAdaptor(list);
				moto = v;
			}
		};
		((TextView)findViewById(R.id.isod_fielder)).setOnClickListener(isoD);


	}

	private void setAdaptor(ArrayList<FielderStatsRow> list){
		//アダプタクラスのインスタンス設定
				ListAdapter adapter = new LeagueFielderRowAdaptor(this, 0, list, desc, click);
				//アダプタ設定
				ListView listView = (ListView)findViewById(R.id.listView1);
				listView.setAdapter(adapter);

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


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.league_stats_fielder, menu);
		return true;
	}

}
