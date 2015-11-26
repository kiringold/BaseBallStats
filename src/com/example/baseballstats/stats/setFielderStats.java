package com.example.baseballstats.stats;

import static com.example.baseballstats.constants.FielderStatsConstants.*;

import java.util.ArrayList;

import android.util.Log;

import com.example.baseballstats.database.FielderStatsRow;
import com.example.baseballstats.database.PitchStatsRow;

public class setFielderStats {


	public setFielderStats() {
		super();
	}

	public FielderStatsRow setFielderStats(ArrayList< ArrayList<String>> person, int i){
		FielderStatsRow row = new FielderStatsRow();
		row.setNumberFielder(person.get(i).get(NUMBER_FIELDER));
		row.setNameFielder(person.get(i).get(NAME_FIELDER));
		row.setBattingAverageFielder(person.get(i).get(BATTING_AVERAGE_FIELDER));
		row.setGamesFielder(person.get(i).get(GAMES_FIELDER));
		row.setPlateAppearanceFielder(person.get(i).get(PLATE_APPEARANCES_FIELDER));
		row.setAtBatsFielder(person.get(i).get(AT_BATS_FIELDER));
		row.setHitsFielder(person.get(i).get(HITS_FIELDER));
		row.setDoubleFielder(person.get(i).get(DOUBLE_FIELDER));
		row.setTripleFielder(person.get(i).get(TRIPLE_FIELDER));
		row.setHomeRunsFielder(person.get(i).get(HOME_RUNS_FIELDER));
		row.setTotalBasesFielder(person.get(i).get(TOTAL_BASES_FIELDER));
		row.setRunsBattedInFielder(person.get(i).get(RUN_BATTED_IN_FIELDER));
		row.setRunsFielder(person.get(i).get(RUNS_FIELDER));
		row.setStrikeoutsFielder(person.get(i).get(STRIKEOUTS_FIELDER));
		row.setBasesOnBallsFielder(person.get(i).get(BASES_ON_BALLS_FIELDER));
		row.setHitByPitchFielder(person.get(i).get(HIT_BY_PITCH_FIELDER));
		row.setSacrificeHitsFielder(person.get(i).get(SACRIFICE_HITS_FIELDER));
		row.setSacrificeFliesFielder(person.get(i).get(SACRIFICE_FLIES_FIELDER));
		row.setStolenBasesFielder(person.get(i).get(STOLEN_BASES_FIELDER));
		row.setOnBasePercentageFielder(person.get(i).get(ON_BASE_PERCENTAGE_FIELDER));
		row.setSluggingPercentageFielder(person.get(i).get(SLUGGING_PERCENTAGE_FIELDER));
		row.setBattingAverageWithRunnerInScoringPositionFielder(person.get(i).get(BATTING_AVERAGE_WITH_RUNNERS_IN_SCORING_POSITION_FIELDER));
		row.setGameWinningRunsBattedInFielder(person.get(i).get(GAME_WINNING_RUNS_BATTED_IN_FIELDER));
		row.setDoublePlayFielder(person.get(i).get(DOUBLE_PLAY_FIELDER));
		row.setErrorsFielder(person.get(i).get(ERRORS_FIELDER));
		row.setOpsFielder(person.get(i).get(OPS_FIELDER));
		row.setIsoDFielder(person.get(i).get(ISOD_FIELDER));
		row.setTeamFielder(person.get(i).get(TEAM_FIELDER));
		Log.d("rowtes", row.getTeamFielder());

		return row;


	}
}
