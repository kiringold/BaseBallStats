package com.example.baseballstats.stats;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;

import com.example.baseballstats.MainActivity;
import com.example.baseballstats.database.PitchStatsRow;
import com.example.baseballstats.database.Stats;

import static com.example.baseballstats.constants.PitchStatsConstants.*;

public class setPitchStats {
	//	protected final Context context;

	public setPitchStats(){
		super();
	}

	public PitchStatsRow setPitchStats(ArrayList< ArrayList<String>> person, int i){
		//		Stats st = new Stats(context);
		//		st.createOpen();
		//		for(int i=0; i<person.size(); i++){
		PitchStatsRow row = new PitchStatsRow();
		row.setNumberPitch(person.get(i).get(NUMBER_PITCH));
		row.setNamePitch(person.get(i).get(NAME_PITCH));
		row.setEarnedRunAveragePitch(person.get(i).get(EARNED_RUN_AVERAGE_PITCH));
		row.setGamesPitch(person.get(i).get(GAMES_PITCH));
		row.setCompleteGamesPitch(person.get(i).get(COMPLETE_GAMES_PITCH));
		row.setShutoutsPitch(person.get(i).get(SHUTOUTS_PITCH));
		row.setNotBbHbpPitch(person.get(i).get(NOT_BB_HBP_PITCH));
		row.setWinsPitch(person.get(i).get(WINS_PITCH));
		row.setLossesPitch(person.get(i).get(LOSSES_PITCH));
		row.setHoldsPitch(person.get(i).get(HOLDS_PITCH));
		row.setHoldsPointsPitch(person.get(i).get(HOLDS_PONTS_PITCH));
		row.setSavesPitch(person.get(i).get(SAVES_PITCH));
		row.setWinningPercentagePitch(person.get(i).get(WINNING_PERCENTAGE_PITCH));
		row.setInningsPitchedPitch(person.get(i).get(INNINGS_PITCHED_PITCH));
		row.setHitsPitch(person.get(i).get(HITS_PITCH));
		row.setHomeRunsPitch(person.get(i).get(HOME_RUNS_PITCH));
		row.setStrikeoutsPitch(person.get(i).get(STRIKEOUTS_PITCH));
		row.setBasesOnBallsPitch(person.get(i).get(BASES_ON_BALLS_PITCH));
		row.setHitByPitchPitch(person.get(i).get(HIT_BY_PITCH_PITCH));
		row.setWildPitchesPitch(person.get(i).get(WILD_PITCHES_PITCH));
		row.setBalksPitch(person.get(i).get(BALK_PITCH));
		row.setRunsPitch(person.get(i).get(RUNS_PITCH));
		row.setEarnedRunsPitch(person.get(i).get(EARNED_RUNS_PITCH));
		row.setWhipPitch(person.get(i).get(WHIP_PITCH));
		row.setKbbPitch(person.get(i).get(KBB_PITCH));
		row.setTeamPitch(person.get(i).get(TEAM_PITCH));
		//		st.insertPitch(row);
		Log.d("rowtes", row.getTeamPitch());

		return row;
		//		}

		//		st.close();

	}
}
