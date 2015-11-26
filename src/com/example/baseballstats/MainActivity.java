package com.example.baseballstats;

import java.util.ArrayList;


import com.example.baseballstats.database.Stats;
import com.example.baseballstats.stats.getFielderStats;
import com.example.baseballstats.stats.getPitchStats;
import com.example.baseballstats.stats.setFielderStats;
import com.example.baseballstats.stats.setPitchStats;

import static com.example.baseballstats.constants.TeamNameConstants.*;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;


/**
 * 成績表アプリのメインアクチビチイ
 * @author ぼく
 * @version 1.0
 */
/**
 * @author PM
 *
 */
public class MainActivity extends Activity {


	/**
	 * ハンドラを使用するためオブジェクト作成
	 */
	private Handler handler = new Handler();
//	private boolean dbex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

//		dbex = MainActivity.this.getDatabasePath("BaseBallStats").exists();


		//ここからビューにクリックリスナーを設定していく
		ImageView clp = (ImageView)findViewById(R.id.central_pitch);
		clp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//インテントで遷移先を設定
				Intent intent = new Intent(MainActivity.this, LeagueStatsPitchActivity.class);
				//チーム名をインテントに入れる
				intent.putExtra(TEAM_NAME, GIANTS + "','" + TIGERS + "','" + CARP + "','" + DRAGONS + "','" + BAYSTARS + "','" + SWALLOWS);
				startActivity(intent);
			}
		});


		ImageView gp = (ImageView)findViewById(R.id.giants_pitch);
		gp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, PitchStatsActivity.class);
				intent.putExtra(TEAM_NAME, GIANTS);
				startActivity(intent);
			}
		});


		ImageView tp = (ImageView)findViewById(R.id.tigers_pitch);
		tp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, PitchStatsActivity.class);
				intent.putExtra(TEAM_NAME, TIGERS);
				startActivity(intent);
			}
		});

		ImageView cp = (ImageView)findViewById(R.id.carp_pitch);
		cp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, PitchStatsActivity.class);
				intent.putExtra(TEAM_NAME, CARP);
				startActivity(intent);
			}
		});

		ImageView dp = (ImageView)findViewById(R.id.dragons_pitch);
		dp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, PitchStatsActivity.class);
				intent.putExtra(TEAM_NAME, DRAGONS);
				startActivity(intent);
			}
		});

		ImageView bp = (ImageView)findViewById(R.id.baystars_pitch);
		bp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, PitchStatsActivity.class);
				intent.putExtra(TEAM_NAME, BAYSTARS);
				startActivity(intent);
			}
		});

		ImageView sp = (ImageView)findViewById(R.id.swallows_pitch);
		sp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, PitchStatsActivity.class);
				intent.putExtra(TEAM_NAME, SWALLOWS);
				startActivity(intent);
			}
		});

		ImageView plp = (ImageView)findViewById(R.id.pacific_pitch);
		plp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, LeagueStatsPitchActivity.class);
				intent.putExtra(TEAM_NAME, HAWKS + "','" + BUFFALOES + "','" + FIGHTERS + "','" + MARINES + "','" + LIONS + "','" + EAGLES);
				startActivity(intent);
			}
		});

		ImageView hp = (ImageView)findViewById(R.id.hawks_pitch);
		hp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, PitchStatsActivity.class);
				intent.putExtra(TEAM_NAME, HAWKS);
				startActivity(intent);
			}
		});

		ImageView op = (ImageView)findViewById(R.id.buffaloes_pitch);
		op.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, PitchStatsActivity.class);
				intent.putExtra(TEAM_NAME, BUFFALOES);
				startActivity(intent);
			}
		});

		ImageView fp = (ImageView)findViewById(R.id.fighters_pitch);
		fp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, PitchStatsActivity.class);
				intent.putExtra(TEAM_NAME, FIGHTERS);
				startActivity(intent);
			}
		});

		ImageView mp = (ImageView)findViewById(R.id.marines_pitch);
		mp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, PitchStatsActivity.class);
				intent.putExtra(TEAM_NAME, MARINES);
				startActivity(intent);
			}
		});

		ImageView lp = (ImageView)findViewById(R.id.lions_pitch);
		lp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, PitchStatsActivity.class);
				intent.putExtra(TEAM_NAME, LIONS);
				startActivity(intent);
			}
		});

		ImageView ep = (ImageView)findViewById(R.id.eagles_pitch);
		ep.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, PitchStatsActivity.class);
				intent.putExtra(TEAM_NAME, EAGLES);
				startActivity(intent);
			}
		});

		ImageView clf = (ImageView)findViewById(R.id.central_fielder);
		clf.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, LeagueStatsFielderActivity.class);
				intent.putExtra(TEAM_NAME, GIANTS + "','" + TIGERS + "','" + CARP + "','" + DRAGONS + "','" + BAYSTARS + "','" + SWALLOWS);
				startActivity(intent);
			}
		});

		ImageView gf = (ImageView)findViewById(R.id.giants_fielder);
		gf.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, FielderStatsActivity.class);
				intent.putExtra(TEAM_NAME, GIANTS);
				startActivity(intent);
			}
		});

		ImageView tf = (ImageView)findViewById(R.id.tigers_fielder);
		tf.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, FielderStatsActivity.class);
				intent.putExtra(TEAM_NAME, TIGERS);
				startActivity(intent);
			}
		});

		ImageView cf = (ImageView)findViewById(R.id.carp_fielder);
		cf.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, FielderStatsActivity.class);
				intent.putExtra(TEAM_NAME, CARP);
				startActivity(intent);
			}
		});

		ImageView df = (ImageView)findViewById(R.id.dragons_fielder);
		df.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, FielderStatsActivity.class);
				intent.putExtra(TEAM_NAME, DRAGONS);
				startActivity(intent);
			}
		});

		ImageView bf = (ImageView)findViewById(R.id.baystars_fielder);
		bf.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, FielderStatsActivity.class);
				intent.putExtra(TEAM_NAME, BAYSTARS);
				startActivity(intent);
			}
		});

		ImageView sf = (ImageView)findViewById(R.id.swallows_fielder);
		sf.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, FielderStatsActivity.class);
				intent.putExtra(TEAM_NAME, SWALLOWS);
				startActivity(intent);
			}
		});

		ImageView plf = (ImageView)findViewById(R.id.pacific_fielder);
		plf.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, LeagueStatsFielderActivity.class);
				intent.putExtra(TEAM_NAME, HAWKS + "','" + BUFFALOES + "','" + FIGHTERS + "','" + MARINES + "','" + LIONS + "','" + EAGLES);
				startActivity(intent);
			}
		});

		ImageView hf = (ImageView)findViewById(R.id.hawks_fielder);
		hf.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, FielderStatsActivity.class);
				intent.putExtra(TEAM_NAME, HAWKS);
				startActivity(intent);
			}
		});

		ImageView of = (ImageView)findViewById(R.id.buffaloes_fielder);
		of.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, FielderStatsActivity.class);
				intent.putExtra(TEAM_NAME, BUFFALOES);
				startActivity(intent);
			}
		});

		ImageView ff = (ImageView)findViewById(R.id.fighters_fielder);
		ff.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, FielderStatsActivity.class);
				intent.putExtra(TEAM_NAME, FIGHTERS);
				startActivity(intent);
			}
		});

		ImageView mf = (ImageView)findViewById(R.id.marines_fielder);
		mf.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, FielderStatsActivity.class);
				intent.putExtra(TEAM_NAME, MARINES);
				startActivity(intent);
			}
		});

		ImageView lf = (ImageView)findViewById(R.id.lions_fielder);
		lf.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, FielderStatsActivity.class);
				intent.putExtra(TEAM_NAME, LIONS);
				startActivity(intent);
			}
		});

		ImageView ef = (ImageView)findViewById(R.id.eagles_fielder);
		ef.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, FielderStatsActivity.class);
				intent.putExtra(TEAM_NAME, EAGLES);
				startActivity(intent);
			}
		});

	}

	/**
	 * 回るダイアログを使う
	 */
	private ProgressDialog dialog;

	/**
	 * 成績の取得、表示等全部やるメソッド
	 */
	private void dbStart(){
		//ダイアログの設定
		dialog = new ProgressDialog(MainActivity.this);
		dialog.setTitle("データベース更新中...");
		dialog.setMessage("しばらくお待ちください...");
		dialog.setIndeterminate(true);
		dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//		dialog.setCancelable(false);
		dialog.setCancelable(true);
		dialog.show();


		new Thread(new Runnable(){
			public void run(){
				//データベースの存在を確認
				boolean dbex = MainActivity.this.getDatabasePath("BaseBallStats").exists();
				//投手の成績を取得するための準備（トーストを使うのでcontextとハンドラーを渡す）
				getPitchStats gps = new getPitchStats(MainActivity.this, handler);
				//取得した成績をデータベースにセットするための準備
				setPitchStats sps = new setPitchStats();
				//投手と同じことを野手でもやる
				getFielderStats gfs = new getFielderStats();
				setFielderStats sfs = new setFielderStats();

				//データベースの作成
				Stats st = new Stats(MainActivity.this);
				//取得した成績をlistに入れる
				ArrayList<ArrayList<String>> prow = gps.getStart();
				ArrayList<ArrayList<String>> frow = gfs.getStart();
				//データベースを開くまたは作成
				st.createOpen();

				//取得したデータの数だけ繰り返す
				for(int i=0; i<prow.size(); i++){
					//		sps.setPitchStats(row, i);
					//データベースがあればtrue
					if(dbex){
						//既にデータベースがあれば成績の更新
						st.updatePitch(sps.setPitchStats(prow, i));
					}else{
						//データベースがなければ登録
						st.insertPitch(sps.setPitchStats(prow, i));//分岐
					}
				}

				//投手と同じことを野手でもやる
				for(int i=0; i<frow.size(); i++){
					if(dbex){
						st.updateFielder(sfs.setFielderStats(frow, i));
					}else{
						st.insertFielder(sfs.setFielderStats(frow, i));//分岐
					}
				}


				//		st.delete();
				st.close(); //ヘルパーのクローズ
				dialog.dismiss();
			}
		}).start();
	}




	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}



	/**
	 * メニューを押したときの処理メソッド
	 * 登録・更新→そのメソッドを呼ぶ
	 * 削除→データベースを削除
	 */
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		super.onMenuItemSelected(featureId, item);
		Stats sat = new Stats(MainActivity.this);
		switch(item.getItemId()){
		case R.id.dbInsert:
			Log.d("insert", "insert");
			dbStart();
			break;
		case R.id.dbUpdate:
			Log.d("2", "2");
			dbStart();
			break;
		case R.id.dbDelete:
			Log.d("3", "3");
			sat.delete();
			break;
		default:
			return true;
		}
		return true;

	}



}
