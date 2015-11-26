package com.example.baseballstats.database;

import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import static com.example.baseballstats.constants.TableNameConstants.*;
import static com.example.baseballstats.constants.FieldColName.*;

import static com.example.baseballstats.constants.PitchColName.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import static com.example.baseballstats.constants.TableNameConstants.*;

public class Stats {

	static final String DATABASE_NAME = "BaseBallStats";
	static final int DATABASE_VERSION = 1;

	public static final String ID = "id";


	protected final Context context;
	protected DatabaseHelper dbHelper;
	protected SQLiteDatabase db;

	public Stats(Context context){
		this.context = context;
		dbHelper = new DatabaseHelper(this.context);
	}


	//
	// SQLiteOpenHelper
	//

	private static class DatabaseHelper extends SQLiteOpenHelper {

		public DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}


		//データベースを作成した瞬間に呼ぶ
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(
					"CREATE TABLE " + PITCH_TABLE + " ("
							+ ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
							+ NUMBER_PITCH + " TEXT NOT NULL DEFAULT '-',"
							+ NAME_PITCH + " TEXT NOT NULL DEFAULT '-',"
							+ EARNED_RUN_AVERAGE_PITCH + " TEXT NOT NULL DEFAULT '-',"
							+ GAMES_PITCH + " TEXT NOT NULL DEFAULT '-',"
							+ COMPLETE_GAMES_PITCH + " TEXT NOT NULL DEFAULT '-',"
							+ SHUTOUTS_PITCH + " TEXT NOT NULL DEFAULT '-',"
							+ NOT_BB_HBP_PITCH + " TEXT NOT NULL DEFAULT '-',"
							+ WINS_PITCH + " TEXT NOT NULL DEFAULT '-',"
							+ LOSSES_PITCH + " TEXT NOT NULL DEFAULT '-',"
							+ HOLDS_PITCH + " TEXT NOT NULL DEFAULT '-',"
							+ HOLDS_PONTS_PITCH + " TEXT NOT NULL DEFAULT '-',"
							+ SAVES_PITCH + " TEXT NOT NULL DEFAULT '-',"
							+ WINNING_PERCENTAGE_PITCH + " TEXT NOT NULL DEFAULT '-',"
							+ INNINGS_PITCHED_PITCH + " TEXT NOT NULL DEFAULT '-',"
							+ HITS_PITCH + " TEXT NOT NULL DEFAULT '-',"
							+ HOME_RUNS_PITCH + " TEXT NOT NULL DEFAULT '-',"
							+ STRIKEOUTS_PITCH + " TEXT NOT NULL DEFAULT '-',"
							+ BASES_ON_BALLS_PITCH + " TEXT NOT NULL DEFAULT '-',"
							+ HIT_BY_PITCH_PITCH + " TEXT NOT NULL DEFAULT '-',"
							+ WILD_PITCHES_PITCH + " TEXT NOT NULL DEFAULT '-',"
							+ BALK_PITCH + " TEXT NOT NULL DEFAULT '-',"
							+ RUNS_PITCH+ " TEXT NOT NULL DEFAULT '-',"
							+ EARNED_RUNS_PITCH + " TEXT NOT NULL DEFAULT '-',"
							+ WHIP_PITCH + " TEXT NOT NULL DEFAULT '-',"
							+ KBB_PITCH + " TEXT NOT NULL DEFAULT '-',"
							+ TEAM_PITCH + " TEXT NOT NULL DEFAULT '-'"
							+ ");"
					);

			db.execSQL(
					"CREATE TABLE " + FIELDER_TABLE + " ("
							+ ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
							+ NUMBER_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ NAME_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ BATTING_AVERAGE_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ GAMES_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ PLATE_APPEARANCES_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ AT_BATS_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ HITS_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ DOUBLE_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ TRIPLE_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ HOME_RUNS_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ TOTAL_BASES_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ RUN_BATTED_IN_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ RUNS_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ STRIKEOUTS_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ BASES_ON_BALLS_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ HIT_BY_PITCH_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ SACRIFICE_HITS_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ SACRIFICE_FLIES_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ STOLEN_BASES_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ ON_BASE_PERCENTAGE_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ SLUGGING_PERCENTAGE_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ BATTING_AVERAGE_WITH_RUNNERS_IN_SCORING_POSITION_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ GAME_WINNING_RUNS_BATTED_IN_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ DOUBLE_PLAY_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ ERRORS_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ OPS_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ ISOD_FIELDER + " TEXT NOT NULL DEFAULT '-',"
							+ TEAM_FIELDER + " TEXT NOT NULL DEFAULT '-'"
							+ ");"



					);



		}

		@Override
		public void onUpgrade(
				SQLiteDatabase db,
				int oldVersion,
				int newVersion) {
			db.execSQL("DROP DATABASE IF EXISTS "+DATABASE_NAME);
			onCreate(db);
		}

	}

	//
	// Adapter Methods
	//

	public void createOpen() {
		db = dbHelper.getWritableDatabase();
	}


	public void close(){
		dbHelper.close();
	}


	public void delete(){
//		db.deleteDatabase(context.getDatabasePath(dbHelper.getDatabaseName()));
		File file = (context.getDatabasePath(dbHelper.getDatabaseName()));
		boolean dbd = deleteDatabase(file);
		Log.d("dbdelete", "db:" + dbd );
	}
	public static boolean deleteDatabase(File file) {
	    if (file == null) {
	        throw new IllegalArgumentException("file must not be null");
	    }
	    boolean deleted = false;
	    deleted |= file.delete();
	    deleted |= new File(file.getPath() + "-journal").delete();
	    deleted |= new File(file.getPath() + "-shm").delete();
	    deleted |= new File(file.getPath() + "-wal").delete();
	    File dir = file.getParentFile();
	    if (dir != null) {
	        final String prefix = file.getName() + "-mj";
	        final FileFilter filter = new FileFilter() {
	            @Override
	            public boolean accept(File candidate) {
	                return candidate.getName().startsWith(prefix);
	            }
	        };
	        for (File masterJournal : dir.listFiles(filter)) {
	            deleted |= masterJournal.delete();
	        }
	    }
	    return deleted;
	}
	

	//	private String getDateTime() {
	//		SimpleDateFormat dateFormat = new SimpleDateFormat(
	//				"yyyy-MM-dd HH:mm:ss", Locale.getDefault());
	//		Date date = new Date();
	//		return dateFormat.format(date);
	//	}

	//
	// App Methods
	//

	//投手用登録メソッド
	public int insertPitch(PitchStatsRow row){
		int id = -1;
		if(row == null) throw new IllegalArgumentException("Row..null!");

		String numberPitch = row.getNumberPitch();
		String namePitch = row.getNamePitch();
		String earnedRunAveragePitch = row.getEarnedRunAveragePitch();
		String gamesPitch = row.getGamesPitch();
		String completeGamesPitch = row.getCompleteGamesPitch();
		String shutoutsPitch = row.getShutoutsPitch();
		String notBbHbpPitch = row.getNotBbHbpPitch();
		String winsPitch = row.getWinsPitch();
		String lossesPitch = row.getLossesPitch();
		String holdsPitch = row.getHoldsPitch();
		String holdsPointsPitch = row.getHoldsPointsPitch();
		String savesPitch = row.getSavesPitch();
		String winningPercentagePitch = row.getWinningPercentagePitch();
		String inningsPitchedPitch = row.getInningsPitchedPitch();
		String hitsPitch = row.getHitsPitch();
		String homeRunsPitch = row.getHomeRunsPitch();
		String strikeoutsPitch = row.getStrikeoutsPitch();
		String basesOnBallsPitch = row.getBasesOnBallsPitch();
		String hitByPitchPitch = row.getHitByPitchPitch();
		String wildPitchesPitch = row.getWildPitchesPitch();
		String balksPitch = row.getBalksPitch();
		String runsPitch = row.getRunsPitch();
		String earnedRunsPitch = row.getEarnedRunsPitch();
		String whipPitch = row.getWhipPitch();
		String kbbPitch = row.getKbbPitch();
		String teamPitch = row.getTeamPitch();



		//		if(memo == null || memo.equals("")) {
		//			throw new IllegalArgumentException("�����͕K�{");
		//		}
		//		if(path == null || path.equals("")) {
		//			throw new IllegalArgumentException("�摜�͕K�{");
		//		}


		//登録する処理
		ContentValues values = new ContentValues();
		values.put(NUMBER_PITCH, numberPitch);
		values.put(NAME_PITCH, namePitch);
		values.put(EARNED_RUN_AVERAGE_PITCH, earnedRunAveragePitch);
		values.put(GAMES_PITCH, gamesPitch);
		values.put(COMPLETE_GAMES_PITCH, completeGamesPitch);
		values.put(SHUTOUTS_PITCH, shutoutsPitch);
		values.put(NOT_BB_HBP_PITCH, notBbHbpPitch);
		values.put(WINS_PITCH, winsPitch);
		values.put(LOSSES_PITCH, lossesPitch);
		values.put(HOLDS_PITCH, holdsPitch);
		values.put(HOLDS_PONTS_PITCH, holdsPointsPitch);
		values.put(SAVES_PITCH, savesPitch);
		values.put(WINNING_PERCENTAGE_PITCH, winningPercentagePitch);
		values.put(INNINGS_PITCHED_PITCH, inningsPitchedPitch);
		values.put(HITS_PITCH, hitsPitch);
		values.put(HOME_RUNS_PITCH, homeRunsPitch);
		values.put(STRIKEOUTS_PITCH, strikeoutsPitch);
		values.put(BASES_ON_BALLS_PITCH, basesOnBallsPitch);
		values.put(HIT_BY_PITCH_PITCH, hitByPitchPitch);
		values.put(WILD_PITCHES_PITCH, wildPitchesPitch);
		values.put(BALK_PITCH, balksPitch);
		values.put(RUNS_PITCH, runsPitch);
		values.put(EARNED_RUNS_PITCH, earnedRunsPitch);
		values.put(WHIP_PITCH, whipPitch);
		values.put(KBB_PITCH, kbbPitch);
		values.put(TEAM_PITCH, teamPitch);


		//トランザクション開始
		db.beginTransaction();
		try{
			id = (int)db.insert(PITCH_TABLE, null, values);

			// トランザクション正常終了
			db.setTransactionSuccessful();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			// トランザクション終了
			db.endTransaction();
			//			db.close();
		}
		//
		//		Log.d("test", id + "");
		//
		return id;

	}


	//野手用登録メソッド
	public int insertFielder(FielderStatsRow row){
		int id = -1;
		if(row == null) throw new IllegalArgumentException("Row..null!");


		String numberFielder = row.getNumberFielder();
		String nameFielder = row.getNameFielder();
		String battingAverageFielder = row.getBattingAverageFielder();
		String gamesFielder = row.getGamesFielder();
		String plateAppearanceFielder = row.getPlateAppearanceFielder();
		String atBatsFielder = row.getAtBatsFielder();
		String hitsFielder = row.getHitsFielder();
		String doubleFielder = row.getDoubleFielder();
		String tripleFielder = row.getTripleFielder();
		String homeRunsFielder = row.getHomeRunsFielder();
		String totalBasesFielder = row.getTotalBasesFielder();
		String runsBattedInFielder = row.getRunsBattedInFielder();
		String runsFielder = row.getRunsFielder();
		String strikeoutsFielder = row.getStrikeoutsFielder();
		String basesOnBallsFielder = row.getBasesOnBallsFielder();
		String hitByPitchFielder = row.getHitByPitchFielder();
		String sacrificeHitsFielder = row.getSacrificeHitsFielder();
		String sacrificeFliesFielder = row.getSacrificeFliesFielder();
		String stolenBasesFielder = row.getStolenBasesFielder();
		String onBasePercentageFielder = row.getOnBasePercentageFielder();
		String sluggingPercentageFielder = row.getSluggingPercentageFielder();
		String battingAverageWithRunnerInScoringPositionFielder = row.getBattingAverageWithRunnerInScoringPositionFielder();
		String gameWinningRunsBattedInFielder = row.getGameWinningRunsBattedInFielder();
		String doublePlayFielder = row.getDoublePlayFielder();
		String errorsFielder = row.getErrorsFielder();
		String opsFielder = row.getOpsFielder();
		String isoDFielder = row.getIsoDFielder();
		String teamFielder = row.getTeamFielder();
		//
		//
		//
		////		if(memo == null || memo.equals("")) {
		////			throw new IllegalArgumentException("�����͕K�{");
		////		}
		////		if(path == null || path.equals("")) {
		////			throw new IllegalArgumentException("�摜�͕K�{");
		////		}

		//登録する処理
		ContentValues values = new ContentValues();
		values.put(NUMBER_FIELDER, numberFielder);
		values.put(NAME_FIELDER, nameFielder);
		values.put(BATTING_AVERAGE_FIELDER, battingAverageFielder);
		values.put(GAMES_FIELDER, gamesFielder);
		values.put(PLATE_APPEARANCES_FIELDER, plateAppearanceFielder);
		values.put(AT_BATS_FIELDER, atBatsFielder);
		values.put(HITS_FIELDER, hitsFielder);
		values.put(DOUBLE_FIELDER, doubleFielder);
		values.put(TRIPLE_FIELDER, tripleFielder);
		values.put(HOME_RUNS_FIELDER, homeRunsFielder);
		values.put(TOTAL_BASES_FIELDER, totalBasesFielder);
		values.put(RUN_BATTED_IN_FIELDER, runsBattedInFielder);
		values.put(RUNS_FIELDER, runsFielder);
		values.put(STRIKEOUTS_FIELDER, strikeoutsFielder);
		values.put(BASES_ON_BALLS_FIELDER, basesOnBallsFielder);
		values.put(HIT_BY_PITCH_FIELDER, hitByPitchFielder);
		values.put(SACRIFICE_HITS_FIELDER, sacrificeHitsFielder);
		values.put(SACRIFICE_FLIES_FIELDER, sacrificeFliesFielder);
		values.put(STOLEN_BASES_FIELDER, stolenBasesFielder);
		values.put(ON_BASE_PERCENTAGE_FIELDER, onBasePercentageFielder);
		values.put(SLUGGING_PERCENTAGE_FIELDER, sluggingPercentageFielder);
		values.put(BATTING_AVERAGE_WITH_RUNNERS_IN_SCORING_POSITION_FIELDER, battingAverageWithRunnerInScoringPositionFielder);
		values.put(GAME_WINNING_RUNS_BATTED_IN_FIELDER, gameWinningRunsBattedInFielder);
		values.put(DOUBLE_PLAY_FIELDER, doublePlayFielder);
		values.put(ERRORS_FIELDER, errorsFielder);
		values.put(OPS_FIELDER, opsFielder);
		values.put(ISOD_FIELDER, isoDFielder);
		values.put(TEAM_FIELDER, teamFielder);


		//トランザクション開始
		db.beginTransaction();
		try{
			id = (int)db.insert(FIELDER_TABLE, null, values);

			// トランザクション正常終了
			db.setTransactionSuccessful();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			// トランザクション終了
			db.endTransaction();
			//					db.close();
		}



		return id;
	}
	//

	//とうしゅ更新用
	public boolean updatePitch(PitchStatsRow row){
		if(row == null) throw new IllegalArgumentException("Row��null");

		String numberPitch = row.getNumberPitch();
		String namePitch = row.getNamePitch();
		String earnedRunAveragePitch = row.getEarnedRunAveragePitch();
		String gamesPitch = row.getGamesPitch();
		String completeGamesPitch = row.getCompleteGamesPitch();
		String shutoutsPitch = row.getShutoutsPitch();
		String notBbHbpPitch = row.getNotBbHbpPitch();
		String winsPitch = row.getWinsPitch();
		String lossesPitch = row.getLossesPitch();
		String holdsPitch = row.getHoldsPitch();
		String holdsPointsPitch = row.getHoldsPointsPitch();
		String savesPitch = row.getSavesPitch();
		String winningPercentagePitch = row.getWinningPercentagePitch();
		String inningsPitchedPitch = row.getInningsPitchedPitch();
		String hitsPitch = row.getHitsPitch();
		String homeRunsPitch = row.getHomeRunsPitch();
		String strikeoutsPitch = row.getStrikeoutsPitch();
		String basesOnBallsPitch = row.getBasesOnBallsPitch();
		String hitByPitchPitch = row.getHitByPitchPitch();
		String wildPitchesPitch = row.getWildPitchesPitch();
		String balksPitch = row.getBalksPitch();
		String runsPitch = row.getRunsPitch();
		String earnedRunsPitch = row.getEarnedRunsPitch();
		String whipPitch = row.getWhipPitch();
		String kbbPitch = row.getKbbPitch();
		String teamPitch = row.getTeamPitch();

		//		if(memo == null || memo.equals("")) {
		//			throw new IllegalArgumentException("�����͕K�{");
		//		}
		//		if(path == null || path.equals("")) {
		//			throw new IllegalArgumentException("�摜�͕K�{");
		//		}


		//登録する処理
		ContentValues values = new ContentValues();
		values.put(NUMBER_PITCH, numberPitch);
		values.put(NAME_PITCH, namePitch);
		values.put(EARNED_RUN_AVERAGE_PITCH, earnedRunAveragePitch);
		values.put(GAMES_PITCH, gamesPitch);
		values.put(COMPLETE_GAMES_PITCH, completeGamesPitch);
		values.put(SHUTOUTS_PITCH, shutoutsPitch);
		values.put(NOT_BB_HBP_PITCH, notBbHbpPitch);
		values.put(WINS_PITCH, winsPitch);
		values.put(LOSSES_PITCH, lossesPitch);
		values.put(HOLDS_PITCH, holdsPitch);
		values.put(HOLDS_PONTS_PITCH, holdsPointsPitch);
		values.put(SAVES_PITCH, savesPitch);
		values.put(WINNING_PERCENTAGE_PITCH, winningPercentagePitch);
		values.put(INNINGS_PITCHED_PITCH, inningsPitchedPitch);
		values.put(HITS_PITCH, hitsPitch);
		values.put(HOME_RUNS_PITCH, homeRunsPitch);
		values.put(STRIKEOUTS_PITCH, strikeoutsPitch);
		values.put(BASES_ON_BALLS_PITCH, basesOnBallsPitch);
		values.put(HIT_BY_PITCH_PITCH, hitByPitchPitch);
		values.put(WILD_PITCHES_PITCH, wildPitchesPitch);
		values.put(BALK_PITCH, balksPitch);
		values.put(RUNS_PITCH, runsPitch);
		values.put(EARNED_RUNS_PITCH, earnedRunsPitch);
		values.put(WHIP_PITCH, whipPitch);
		values.put(KBB_PITCH, kbbPitch);
		values.put(TEAM_PITCH, teamPitch);


		//トランザクション開始
		db.beginTransaction();
		try{
			long id = db.update(PITCH_TABLE, values, NUMBER_PITCH + " = ? AND " + TEAM_PITCH + " = ?", new String[]{row.getNumberPitch(), row.getTeamPitch() });

			// トランザクション正常終了
			db.setTransactionSuccessful();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			// トランザクション終了
			db.endTransaction();
			//					db.close();
		}

		//		Log.d("test", id + "");
		return true;
	}
	//

	//野手更新用
	public boolean updateFielder(FielderStatsRow row){
		if(row == null) throw new IllegalArgumentException("MemoRow��null");

		String numberFielder = row.getNumberFielder();
		String nameFielder = row.getNameFielder();
		String battingAverageFielder = row.getBattingAverageFielder();
		String gamesFielder = row.getGamesFielder();
		String plateAppearanceFielder = row.getPlateAppearanceFielder();
		String atBatsFielder = row.getAtBatsFielder();
		String hitsFielder = row.getHitsFielder();
		String doubleFielder = row.getDoubleFielder();
		String tripleFielder = row.getTripleFielder();
		String homeRunsFielder = row.getHomeRunsFielder();
		String totalBasesFielder = row.getTotalBasesFielder();
		String runsBattedInFielder = row.getRunsBattedInFielder();
		String runsFielder = row.getRunsFielder();
		String strikeoutsFielder = row.getStrikeoutsFielder();
		String basesOnBallsFielder = row.getBasesOnBallsFielder();
		String hitByPitchFielder = row.getHitByPitchFielder();
		String sacrificeHitsFielder = row.getSacrificeHitsFielder();
		String sacrificeFliesFielder = row.getSacrificeFliesFielder();
		String stolenBasesFielder = row.getStolenBasesFielder();
		String onBasePercentageFielder = row.getOnBasePercentageFielder();
		String sluggingPercentageFielder = row.getSluggingPercentageFielder();
		String battingAverageWithRunnerInScoringPositionFielder = row.getBattingAverageWithRunnerInScoringPositionFielder();
		String gameWinningRunsBattedInFielder = row.getGameWinningRunsBattedInFielder();
		String doublePlayFielder = row.getDoublePlayFielder();
		String errorsFielder = row.getErrorsFielder();
		String opsFielder = row.getOpsFielder();
		String isoDFielder = row.getIsoDFielder();
		String teamFielder = row.getTeamFielder();


		//		if(memo == null || memo.equals("")) {
		//			throw new IllegalArgumentException("�����͕K�{");
		//		}
		//		if(path == null || path.equals("")) {
		//			throw new IllegalArgumentException("�摜�͕K�{");
		//		}

		//登録する処理
		ContentValues values = new ContentValues();
		values.put(NUMBER_FIELDER, numberFielder);
		values.put(NAME_FIELDER, nameFielder);
		values.put(BATTING_AVERAGE_FIELDER, battingAverageFielder);
		values.put(GAMES_FIELDER, gamesFielder);
		values.put(PLATE_APPEARANCES_FIELDER, plateAppearanceFielder);
		values.put(AT_BATS_FIELDER, atBatsFielder);
		values.put(HITS_FIELDER, hitsFielder);
		values.put(DOUBLE_FIELDER, doubleFielder);
		values.put(TRIPLE_FIELDER, tripleFielder);
		values.put(HOME_RUNS_FIELDER, homeRunsFielder);
		values.put(TOTAL_BASES_FIELDER, totalBasesFielder);
		values.put(RUN_BATTED_IN_FIELDER, runsBattedInFielder);
		values.put(RUNS_FIELDER, runsFielder);
		values.put(STRIKEOUTS_FIELDER, strikeoutsFielder);
		values.put(BASES_ON_BALLS_FIELDER, basesOnBallsFielder);
		values.put(HIT_BY_PITCH_FIELDER, hitByPitchFielder);
		values.put(SACRIFICE_HITS_FIELDER, sacrificeHitsFielder);
		values.put(SACRIFICE_FLIES_FIELDER, sacrificeFliesFielder);
		values.put(STOLEN_BASES_FIELDER, stolenBasesFielder);
		values.put(ON_BASE_PERCENTAGE_FIELDER, onBasePercentageFielder);
		values.put(SLUGGING_PERCENTAGE_FIELDER, sluggingPercentageFielder);
		values.put(BATTING_AVERAGE_WITH_RUNNERS_IN_SCORING_POSITION_FIELDER, battingAverageWithRunnerInScoringPositionFielder);
		values.put(GAME_WINNING_RUNS_BATTED_IN_FIELDER, gameWinningRunsBattedInFielder);
		values.put(DOUBLE_PLAY_FIELDER, doublePlayFielder);
		values.put(ERRORS_FIELDER, errorsFielder);
		values.put(OPS_FIELDER, opsFielder);
		values.put(ISOD_FIELDER, isoDFielder);
		values.put(TEAM_FIELDER, teamFielder);


		//トランザクション開始
		db.beginTransaction();
		try{
			long id = db.update(FIELDER_TABLE, values, NUMBER_FIELDER + " = ? AND " + TEAM_FIELDER + " = ?", new String[]{row.getNumberFielder(), row.getTeamFielder() });

			// トランザクション正常終了
			db.setTransactionSuccessful();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			// トランザクション終了
			db.endTransaction();
			//			db.close();
		}

		return true;
	}
	//
	//	//削除はしないので
	////	public boolean delete(MemoRow row){
	////		return db.delete(TABLE_NAME, COL_ID + "= ?", new String[]{ Integer.toString(row.getId()) }) > 0;
	////	}
	//
	//
	//	public MemoRow find(int id){
	//		if(id == 0) throw new IllegalArgumentException("id��0�s�B");
	//
	//		Cursor c =db.query(TABLE_NAME, null, "id = ?", new String[]{ Integer.toString(id) }, null, null, null);
	//		ArrayList<MemoRow> memos = new ArrayList<MemoRow>();
	//		if(!c.moveToFirst()){
	//			// �G���[����
	//			throw new IllegalArgumentException("���݂��Ȃ����R�[�h");
	//		}
	//		MemoRow memo = new MemoRow(
	//				c.getInt(c.getColumnIndex(Memo.COL_ID)),
	//				c.getString(c.getColumnIndex(Memo.COL_MEMO)),
	//				c.getString(c.getColumnIndex(Memo.COL_PATH)),
	//				c.getString(c.getColumnIndex(Memo.COL_CREATED_AT)),
	//				c.getString(c.getColumnIndex(Memo.COL_UPDATED_AT))
	//				);
	//
	//		return memo;
	//	}
	//
	public ArrayList<PitchStatsRow> findPitch(String team){
		String sql = "SELECT * "
				+ "FROM " + PITCH_TABLE
				+ " WHERE " + TEAM_PITCH + " IN " + "('"+ team +"')"
				+ " ORDER BY " + ID;
		Cursor c = db.rawQuery(sql, null);
		ArrayList<PitchStatsRow> rowlist = new ArrayList<PitchStatsRow>();
		//		if(c.moveToFirst()){
		//			do{
		while(c.moveToNext()){
			PitchStatsRow row = new PitchStatsRow(
					c.getInt(c.getColumnIndex(ID)),
					c.getString(c.getColumnIndex(NUMBER_PITCH)),
					c.getString(c.getColumnIndex(NAME_PITCH)),
					c.getString(c.getColumnIndex(EARNED_RUN_AVERAGE_PITCH)),
					c.getString(c.getColumnIndex(GAMES_PITCH)),
					c.getString(c.getColumnIndex(COMPLETE_GAMES_PITCH)),
					c.getString(c.getColumnIndex(SHUTOUTS_PITCH)),
					c.getString(c.getColumnIndex(NOT_BB_HBP_PITCH)),
					c.getString(c.getColumnIndex(WINS_PITCH)),
					c.getString(c.getColumnIndex(LOSSES_PITCH)),
					c.getString(c.getColumnIndex(HOLDS_PITCH)),
					c.getString(c.getColumnIndex(HOLDS_PONTS_PITCH)),
					c.getString(c.getColumnIndex(SAVES_PITCH)),
					c.getString(c.getColumnIndex(WINNING_PERCENTAGE_PITCH)),
					c.getString(c.getColumnIndex(INNINGS_PITCHED_PITCH)),
					c.getString(c.getColumnIndex(HITS_PITCH)),
					c.getString(c.getColumnIndex(HOME_RUNS_PITCH)),
					c.getString(c.getColumnIndex(STRIKEOUTS_PITCH)),
					c.getString(c.getColumnIndex(BASES_ON_BALLS_PITCH)),
					c.getString(c.getColumnIndex(HIT_BY_PITCH_PITCH)),
					c.getString(c.getColumnIndex(WILD_PITCHES_PITCH)),
					c.getString(c.getColumnIndex(BALK_PITCH)),
					c.getString(c.getColumnIndex(RUNS_PITCH)),
					c.getString(c.getColumnIndex(EARNED_RUNS_PITCH)),
					c.getString(c.getColumnIndex(WHIP_PITCH)),
					c.getString(c.getColumnIndex(KBB_PITCH)),
					c.getString(c.getColumnIndex(TEAM_PITCH))
					);
			rowlist.add(row);
			//			}while(c.moveToNext());
		}
		c.close();
		return rowlist;
	}

	public ArrayList<PitchStatsRow> findDescSortPitch(String team, String sort){
		String sql = "SELECT *"
				+ " FROM " + PITCH_TABLE
				+ " WHERE " + TEAM_PITCH + " IN " + "('"+ team +"')"
				+ " AND " + sort + " <> " + "'-'"
				+ " ORDER BY ABS(" + sort + ") DESC";
		Cursor c = db.rawQuery(sql, null);
		ArrayList<PitchStatsRow> rowlist = new ArrayList<PitchStatsRow>();
		//		if(c.moveToFirst()){
		//			do{
		while(c.moveToNext()){
			PitchStatsRow row = new PitchStatsRow(
					c.getInt(c.getColumnIndex(ID)),
					c.getString(c.getColumnIndex(NUMBER_PITCH)),
					c.getString(c.getColumnIndex(NAME_PITCH)),
					c.getString(c.getColumnIndex(EARNED_RUN_AVERAGE_PITCH)),
					c.getString(c.getColumnIndex(GAMES_PITCH)),
					c.getString(c.getColumnIndex(COMPLETE_GAMES_PITCH)),
					c.getString(c.getColumnIndex(SHUTOUTS_PITCH)),
					c.getString(c.getColumnIndex(NOT_BB_HBP_PITCH)),
					c.getString(c.getColumnIndex(WINS_PITCH)),
					c.getString(c.getColumnIndex(LOSSES_PITCH)),
					c.getString(c.getColumnIndex(HOLDS_PITCH)),
					c.getString(c.getColumnIndex(HOLDS_PONTS_PITCH)),
					c.getString(c.getColumnIndex(SAVES_PITCH)),
					c.getString(c.getColumnIndex(WINNING_PERCENTAGE_PITCH)),
					c.getString(c.getColumnIndex(INNINGS_PITCHED_PITCH)),
					c.getString(c.getColumnIndex(HITS_PITCH)),
					c.getString(c.getColumnIndex(HOME_RUNS_PITCH)),
					c.getString(c.getColumnIndex(STRIKEOUTS_PITCH)),
					c.getString(c.getColumnIndex(BASES_ON_BALLS_PITCH)),
					c.getString(c.getColumnIndex(HIT_BY_PITCH_PITCH)),
					c.getString(c.getColumnIndex(WILD_PITCHES_PITCH)),
					c.getString(c.getColumnIndex(BALK_PITCH)),
					c.getString(c.getColumnIndex(RUNS_PITCH)),
					c.getString(c.getColumnIndex(EARNED_RUNS_PITCH)),
					c.getString(c.getColumnIndex(WHIP_PITCH)),
					c.getString(c.getColumnIndex(KBB_PITCH)),
					c.getString(c.getColumnIndex(TEAM_PITCH))
					);
			rowlist.add(row);
			//			}while(c.moveToNext());
		}
		c.close();
		return rowlist;
	}

	public ArrayList<PitchStatsRow> findAscSortPitch(String team, String sort){
		String sql = "SELECT *"
				+ " FROM " + PITCH_TABLE
				+ " WHERE " + TEAM_PITCH + " IN " + "('"+ team +"')"
				+ " AND " + sort + " <> " + "'-'"
				+ " ORDER BY ABS(" + sort + ") ASC";
		Cursor c = db.rawQuery(sql, null);
		ArrayList<PitchStatsRow> rowlist = new ArrayList<PitchStatsRow>();
		//		if(c.moveToFirst()){
		//			do{
		while(c.moveToNext()){
			PitchStatsRow row = new PitchStatsRow(
					c.getInt(c.getColumnIndex(ID)),
					c.getString(c.getColumnIndex(NUMBER_PITCH)),
					c.getString(c.getColumnIndex(NAME_PITCH)),
					c.getString(c.getColumnIndex(EARNED_RUN_AVERAGE_PITCH)),
					c.getString(c.getColumnIndex(GAMES_PITCH)),
					c.getString(c.getColumnIndex(COMPLETE_GAMES_PITCH)),
					c.getString(c.getColumnIndex(SHUTOUTS_PITCH)),
					c.getString(c.getColumnIndex(NOT_BB_HBP_PITCH)),
					c.getString(c.getColumnIndex(WINS_PITCH)),
					c.getString(c.getColumnIndex(LOSSES_PITCH)),
					c.getString(c.getColumnIndex(HOLDS_PITCH)),
					c.getString(c.getColumnIndex(HOLDS_PONTS_PITCH)),
					c.getString(c.getColumnIndex(SAVES_PITCH)),
					c.getString(c.getColumnIndex(WINNING_PERCENTAGE_PITCH)),
					c.getString(c.getColumnIndex(INNINGS_PITCHED_PITCH)),
					c.getString(c.getColumnIndex(HITS_PITCH)),
					c.getString(c.getColumnIndex(HOME_RUNS_PITCH)),
					c.getString(c.getColumnIndex(STRIKEOUTS_PITCH)),
					c.getString(c.getColumnIndex(BASES_ON_BALLS_PITCH)),
					c.getString(c.getColumnIndex(HIT_BY_PITCH_PITCH)),
					c.getString(c.getColumnIndex(WILD_PITCHES_PITCH)),
					c.getString(c.getColumnIndex(BALK_PITCH)),
					c.getString(c.getColumnIndex(RUNS_PITCH)),
					c.getString(c.getColumnIndex(EARNED_RUNS_PITCH)),
					c.getString(c.getColumnIndex(WHIP_PITCH)),
					c.getString(c.getColumnIndex(KBB_PITCH)),
					c.getString(c.getColumnIndex(TEAM_PITCH))
					);
			rowlist.add(row);
			//			}while(c.moveToNext());
		}
		c.close();
		return rowlist;
	}


	public ArrayList<FielderStatsRow> findFielder(String team){
		String sql = "SELECT * "
				+ "FROM " + FIELDER_TABLE
				+ " WHERE " + TEAM_FIELDER + " IN " + "('"+ team +"')"
				+ " ORDER BY " + ID;
		Cursor c = db.rawQuery(sql, null);
		ArrayList<FielderStatsRow> rowlist = new ArrayList<FielderStatsRow>();
		//		if(c.moveToFirst()){
		//			do{
		while(c.moveToNext()){
			FielderStatsRow row = new FielderStatsRow(
					c.getInt(c.getColumnIndex(ID)),
					c.getString(c.getColumnIndex(NUMBER_FIELDER)),
					c.getString(c.getColumnIndex(NAME_FIELDER)),
					c.getString(c.getColumnIndex(BATTING_AVERAGE_FIELDER)),
					c.getString(c.getColumnIndex(GAMES_FIELDER)),
					c.getString(c.getColumnIndex(PLATE_APPEARANCES_FIELDER)),
					c.getString(c.getColumnIndex(AT_BATS_FIELDER)),
					c.getString(c.getColumnIndex(HITS_FIELDER)),
					c.getString(c.getColumnIndex(DOUBLE_FIELDER)),
					c.getString(c.getColumnIndex(TRIPLE_FIELDER)),
					c.getString(c.getColumnIndex(HOME_RUNS_FIELDER)),
					c.getString(c.getColumnIndex(TOTAL_BASES_FIELDER)),
					c.getString(c.getColumnIndex(RUN_BATTED_IN_FIELDER)),
					c.getString(c.getColumnIndex(RUNS_FIELDER)),
					c.getString(c.getColumnIndex(STRIKEOUTS_FIELDER)),
					c.getString(c.getColumnIndex(BASES_ON_BALLS_FIELDER)),
					c.getString(c.getColumnIndex(HIT_BY_PITCH_FIELDER)),
					c.getString(c.getColumnIndex(SACRIFICE_HITS_FIELDER)),
					c.getString(c.getColumnIndex(SACRIFICE_FLIES_FIELDER)),
					c.getString(c.getColumnIndex(STOLEN_BASES_FIELDER)),
					c.getString(c.getColumnIndex(ON_BASE_PERCENTAGE_FIELDER)),
					c.getString(c.getColumnIndex(SLUGGING_PERCENTAGE_FIELDER)),
					c.getString(c.getColumnIndex(BATTING_AVERAGE_WITH_RUNNERS_IN_SCORING_POSITION_FIELDER)),
					c.getString(c.getColumnIndex(GAME_WINNING_RUNS_BATTED_IN_FIELDER)),
					c.getString(c.getColumnIndex(DOUBLE_PLAY_FIELDER)),
					c.getString(c.getColumnIndex(ERRORS_FIELDER)),
					c.getString(c.getColumnIndex(OPS_FIELDER)),
					c.getString(c.getColumnIndex(ISOD_FIELDER)),
					c.getString(c.getColumnIndex(TEAM_FIELDER))
					);
			rowlist.add(row);
			//			}while(c.moveToNext());
		}
		c.close();
		return rowlist;
	}

	public ArrayList<FielderStatsRow> findDescSortFielder(String team, String sort){
		String sql = "SELECT *"
				+ " FROM " + FIELDER_TABLE
				+ " WHERE " + TEAM_FIELDER + " IN " + "('"+ team +"')"
				+ " AND " + sort + " <> " + "'-'"
				+ " ORDER BY ABS(" + sort + ") DESC";
		Cursor c = db.rawQuery(sql, null);
		ArrayList<FielderStatsRow> rowlist = new ArrayList<FielderStatsRow>();
		//		if(c.moveToFirst()){
		//			do{
		while(c.moveToNext()){
			FielderStatsRow row = new FielderStatsRow(
					c.getInt(c.getColumnIndex(ID)),
					c.getString(c.getColumnIndex(NUMBER_FIELDER)),
					c.getString(c.getColumnIndex(NAME_FIELDER)),
					c.getString(c.getColumnIndex(BATTING_AVERAGE_FIELDER)),
					c.getString(c.getColumnIndex(GAMES_FIELDER)),
					c.getString(c.getColumnIndex(PLATE_APPEARANCES_FIELDER)),
					c.getString(c.getColumnIndex(AT_BATS_FIELDER)),
					c.getString(c.getColumnIndex(HITS_FIELDER)),
					c.getString(c.getColumnIndex(DOUBLE_FIELDER)),
					c.getString(c.getColumnIndex(TRIPLE_FIELDER)),
					c.getString(c.getColumnIndex(HOME_RUNS_FIELDER)),
					c.getString(c.getColumnIndex(TOTAL_BASES_FIELDER)),
					c.getString(c.getColumnIndex(RUN_BATTED_IN_FIELDER)),
					c.getString(c.getColumnIndex(RUNS_FIELDER)),
					c.getString(c.getColumnIndex(STRIKEOUTS_FIELDER)),
					c.getString(c.getColumnIndex(BASES_ON_BALLS_FIELDER)),
					c.getString(c.getColumnIndex(HIT_BY_PITCH_FIELDER)),
					c.getString(c.getColumnIndex(SACRIFICE_HITS_FIELDER)),
					c.getString(c.getColumnIndex(SACRIFICE_FLIES_FIELDER)),
					c.getString(c.getColumnIndex(STOLEN_BASES_FIELDER)),
					c.getString(c.getColumnIndex(ON_BASE_PERCENTAGE_FIELDER)),
					c.getString(c.getColumnIndex(SLUGGING_PERCENTAGE_FIELDER)),
					c.getString(c.getColumnIndex(BATTING_AVERAGE_WITH_RUNNERS_IN_SCORING_POSITION_FIELDER)),
					c.getString(c.getColumnIndex(GAME_WINNING_RUNS_BATTED_IN_FIELDER)),
					c.getString(c.getColumnIndex(DOUBLE_PLAY_FIELDER)),
					c.getString(c.getColumnIndex(ERRORS_FIELDER)),
					c.getString(c.getColumnIndex(OPS_FIELDER)),
					c.getString(c.getColumnIndex(ISOD_FIELDER)),
					c.getString(c.getColumnIndex(TEAM_FIELDER))
					);
			rowlist.add(row);
			//			}while(c.moveToNext());
		}
		c.close();
		return rowlist;
	}

	public ArrayList<FielderStatsRow> findAscSortFielder(String team, String sort){
		String sql = "SELECT *"
				+ " FROM " + FIELDER_TABLE
				+ " WHERE " + TEAM_FIELDER + " IN " + "('"+ team +"')"
				+ " AND " + sort + " <> " + "'-'"
				+ " ORDER BY ABS(" + sort + ") ASC";
		Cursor c = db.rawQuery(sql, null);
		ArrayList<FielderStatsRow> rowlist = new ArrayList<FielderStatsRow>();
		//		if(c.moveToFirst()){
		//			do{
		while(c.moveToNext()){
			FielderStatsRow row = new FielderStatsRow(
					c.getInt(c.getColumnIndex(ID)),
					c.getString(c.getColumnIndex(NUMBER_FIELDER)),
					c.getString(c.getColumnIndex(NAME_FIELDER)),
					c.getString(c.getColumnIndex(BATTING_AVERAGE_FIELDER)),
					c.getString(c.getColumnIndex(GAMES_FIELDER)),
					c.getString(c.getColumnIndex(PLATE_APPEARANCES_FIELDER)),
					c.getString(c.getColumnIndex(AT_BATS_FIELDER)),
					c.getString(c.getColumnIndex(HITS_FIELDER)),
					c.getString(c.getColumnIndex(DOUBLE_FIELDER)),
					c.getString(c.getColumnIndex(TRIPLE_FIELDER)),
					c.getString(c.getColumnIndex(HOME_RUNS_FIELDER)),
					c.getString(c.getColumnIndex(TOTAL_BASES_FIELDER)),
					c.getString(c.getColumnIndex(RUN_BATTED_IN_FIELDER)),
					c.getString(c.getColumnIndex(RUNS_FIELDER)),
					c.getString(c.getColumnIndex(STRIKEOUTS_FIELDER)),
					c.getString(c.getColumnIndex(BASES_ON_BALLS_FIELDER)),
					c.getString(c.getColumnIndex(HIT_BY_PITCH_FIELDER)),
					c.getString(c.getColumnIndex(SACRIFICE_HITS_FIELDER)),
					c.getString(c.getColumnIndex(SACRIFICE_FLIES_FIELDER)),
					c.getString(c.getColumnIndex(STOLEN_BASES_FIELDER)),
					c.getString(c.getColumnIndex(ON_BASE_PERCENTAGE_FIELDER)),
					c.getString(c.getColumnIndex(SLUGGING_PERCENTAGE_FIELDER)),
					c.getString(c.getColumnIndex(BATTING_AVERAGE_WITH_RUNNERS_IN_SCORING_POSITION_FIELDER)),
					c.getString(c.getColumnIndex(GAME_WINNING_RUNS_BATTED_IN_FIELDER)),
					c.getString(c.getColumnIndex(DOUBLE_PLAY_FIELDER)),
					c.getString(c.getColumnIndex(ERRORS_FIELDER)),
					c.getString(c.getColumnIndex(OPS_FIELDER)),
					c.getString(c.getColumnIndex(ISOD_FIELDER)),
					c.getString(c.getColumnIndex(TEAM_FIELDER))
					);
			rowlist.add(row);
			//			}while(c.moveToNext());
		}
		c.close();
		return rowlist;
	}

	//
	//	public ArrayList<MemoRow> find_search(String word){
	//		if(word == null || word.equals("")) throw new IllegalArgumentException("word����");
	//
	//		Cursor c =db.query(TABLE_NAME, null, "memo like ?", new String[]{ "%"+ word +"%" }, null, null, "id desc");
	//		ArrayList<MemoRow> memos = new ArrayList<MemoRow>();
	//		if(c.moveToFirst()){
	//			do {
	//				MemoRow memo = new MemoRow(
	//						c.getInt(c.getColumnIndex(Memo.COL_ID)),
	//						c.getString(c.getColumnIndex(Memo.COL_MEMO)),
	//						c.getString(c.getColumnIndex(Memo.COL_PATH)),
	//						c.getString(c.getColumnIndex(Memo.COL_CREATED_AT)),
	//						c.getString(c.getColumnIndex(Memo.COL_UPDATED_AT))
	//					);
	//				memos.add(memo);
	//			} while(c.moveToNext());
	//		}
	//		return memos;
	//	}
}