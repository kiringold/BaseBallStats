package com.example.baseballstats.database;

/**
 * 一行分のデータを保持するクラス
 * @author ぼく
 * @version 1.0
 */
public class FielderStatsRow {
	private int id;
	private String numberFielder;
	private String nameFielder;
	private String battingAverageFielder;
	private String gamesFielder;
	private String plateAppearanceFielder;
	private String atBatsFielder;
	private String hitsFielder;
	private String doubleFielder;
	private String tripleFielder;
	private String homeRunsFielder;
	private String totalBasesFielder;
	private String runsBattedInFielder;
	private String runsFielder;
	private String strikeoutsFielder;
	private String basesOnBallsFielder;
	private String hitByPitchFielder;
	private String sacrificeHitsFielder;
	private String sacrificeFliesFielder;
	private String stolenBasesFielder;
	private String onBasePercentageFielder;
	private String sluggingPercentageFielder;
	private String battingAverageWithRunnerInScoringPositionFielder;
	private String gameWinningRunsBattedInFielder;
	private String doublePlayFielder;
	private String errorsFielder;
	private String opsFielder;
	private String rc27Fielder;
	private String rcWinFielder;
	private String isoDFielder;
	private String teamFielder;



	public FielderStatsRow() {
		super();
	}



	public FielderStatsRow(int id, String numberFielder, String nameFielder,
			String battingAverageFielder, String gamesFielder,
			String plateAppearanceFielder, String atBatsFielder,
			String hitsFielder, String doubleFielder, String tripleFielder,
			String homeRunsFielder, String totalBasesFielder,
			String runsBattedInFielder, String runsFielder,
			String strikeoutsFielder, String basesOnBallsFielder,
			String hitByPitchFielder, String sacrificeHitsFielder,
			String sacrificeFliesFielder, String stolenBasesFielder,
			String onBasePercentageFielder, String sluggingPercentageFielder,
			String battingAverageWithRunnerInScoringPositionFielder,
			String gameWinningRunsBattedInFielder, String doublePlayFielder,
			String errorsFielder, String opsFielder, String isoDFielder,
			String teamFielder) {
		super();
		this.id = id;
		this.numberFielder = numberFielder;
		this.nameFielder = nameFielder;
		this.battingAverageFielder = battingAverageFielder;
		this.gamesFielder = gamesFielder;
		this.plateAppearanceFielder = plateAppearanceFielder;
		this.atBatsFielder = atBatsFielder;
		this.hitsFielder = hitsFielder;
		this.doubleFielder = doubleFielder;
		this.tripleFielder = tripleFielder;
		this.homeRunsFielder = homeRunsFielder;
		this.totalBasesFielder = totalBasesFielder;
		this.runsBattedInFielder = runsBattedInFielder;
		this.runsFielder = runsFielder;
		this.strikeoutsFielder = strikeoutsFielder;
		this.basesOnBallsFielder = basesOnBallsFielder;
		this.hitByPitchFielder = hitByPitchFielder;
		this.sacrificeHitsFielder = sacrificeHitsFielder;
		this.sacrificeFliesFielder = sacrificeFliesFielder;
		this.stolenBasesFielder = stolenBasesFielder;
		this.onBasePercentageFielder = onBasePercentageFielder;
		this.sluggingPercentageFielder = sluggingPercentageFielder;
		this.battingAverageWithRunnerInScoringPositionFielder = battingAverageWithRunnerInScoringPositionFielder;
		this.gameWinningRunsBattedInFielder = gameWinningRunsBattedInFielder;
		this.doublePlayFielder = doublePlayFielder;
		this.errorsFielder = errorsFielder;
		this.opsFielder = opsFielder;
		this.isoDFielder = isoDFielder;
		this.teamFielder = teamFielder;
	}



	public FielderStatsRow(String numberFielder, String nameFielder,
			String battingAverageFielder, String gamesFielder,
			String plateAppearanceFielder, String atBatsFielder,
			String hitsFielder, String doubleFielder, String tripleFielder,
			String homeRunsFielder, String totalBasesFielder,
			String runsBattedInFielder, String runsFielder,
			String strikeoutsFielder, String basesOnBallsFielder,
			String hitByPitchFielder, String sacrificeHitsFielder,
			String sacrificeFliesFielder, String stolenBasesFielder,
			String onBasePercentageFielder, String sluggingPercentageFielder,
			String battingAverageWithRunnerInScoringPositionFielder,
			String gameWinningRunsBattedInFielder, String doublePlayFielder,
			String errorsFielder, String opsFielder, String isoDFielder,
			String teamFielder) {
		super();
		this.numberFielder = numberFielder;
		this.nameFielder = nameFielder;
		this.battingAverageFielder = battingAverageFielder;
		this.gamesFielder = gamesFielder;
		this.plateAppearanceFielder = plateAppearanceFielder;
		this.atBatsFielder = atBatsFielder;
		this.hitsFielder = hitsFielder;
		this.doubleFielder = doubleFielder;
		this.tripleFielder = tripleFielder;
		this.homeRunsFielder = homeRunsFielder;
		this.totalBasesFielder = totalBasesFielder;
		this.runsBattedInFielder = runsBattedInFielder;
		this.runsFielder = runsFielder;
		this.strikeoutsFielder = strikeoutsFielder;
		this.basesOnBallsFielder = basesOnBallsFielder;
		this.hitByPitchFielder = hitByPitchFielder;
		this.sacrificeHitsFielder = sacrificeHitsFielder;
		this.sacrificeFliesFielder = sacrificeFliesFielder;
		this.stolenBasesFielder = stolenBasesFielder;
		this.onBasePercentageFielder = onBasePercentageFielder;
		this.sluggingPercentageFielder = sluggingPercentageFielder;
		this.battingAverageWithRunnerInScoringPositionFielder = battingAverageWithRunnerInScoringPositionFielder;
		this.gameWinningRunsBattedInFielder = gameWinningRunsBattedInFielder;
		this.doublePlayFielder = doublePlayFielder;
		this.errorsFielder = errorsFielder;
		this.opsFielder = opsFielder;
		this.isoDFielder = isoDFielder;
		this.teamFielder = teamFielder;
	}



	public int getId() {
		return id;
	}



	public String getNumberFielder() {
		return numberFielder;
	}



	public String getNameFielder() {
		return nameFielder;
	}



	public String getBattingAverageFielder() {
		return battingAverageFielder;
	}



	public String getGamesFielder() {
		return gamesFielder;
	}



	public String getPlateAppearanceFielder() {
		return plateAppearanceFielder;
	}



	public String getAtBatsFielder() {
		return atBatsFielder;
	}



	public String getHitsFielder() {
		return hitsFielder;
	}



	public String getDoubleFielder() {
		return doubleFielder;
	}



	public String getTripleFielder() {
		return tripleFielder;
	}



	public String getHomeRunsFielder() {
		return homeRunsFielder;
	}



	public String getTotalBasesFielder() {
		return totalBasesFielder;
	}



	public String getRunsBattedInFielder() {
		return runsBattedInFielder;
	}



	public String getRunsFielder() {
		return runsFielder;
	}



	public String getStrikeoutsFielder() {
		return strikeoutsFielder;
	}



	public String getBasesOnBallsFielder() {
		return basesOnBallsFielder;
	}



	public String getHitByPitchFielder() {
		return hitByPitchFielder;
	}



	public String getSacrificeHitsFielder() {
		return sacrificeHitsFielder;
	}



	public String getSacrificeFliesFielder() {
		return sacrificeFliesFielder;
	}



	public String getStolenBasesFielder() {
		return stolenBasesFielder;
	}



	public String getOnBasePercentageFielder() {
		return onBasePercentageFielder;
	}



	public String getSluggingPercentageFielder() {
		return sluggingPercentageFielder;
	}



	public String getBattingAverageWithRunnerInScoringPositionFielder() {
		return battingAverageWithRunnerInScoringPositionFielder;
	}



	public String getGameWinningRunsBattedInFielder() {
		return gameWinningRunsBattedInFielder;
	}



	public String getDoublePlayFielder() {
		return doublePlayFielder;
	}



	public String getErrorsFielder() {
		return errorsFielder;
	}



	public String getOpsFielder() {
		return opsFielder;
	}



	public String getRc27Fielder() {
		return rc27Fielder;
	}



	public String getRcWinFielder() {
		return rcWinFielder;
	}



	public String getIsoDFielder() {
		return isoDFielder;
	}



	public String getTeamFielder() {
		return teamFielder;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setNumberFielder(String numberFielder) {
		this.numberFielder = numberFielder;
	}



	public void setNameFielder(String nameFielder) {
		this.nameFielder = nameFielder;
	}



	public void setBattingAverageFielder(String battingAverageFielder) {
		this.battingAverageFielder = battingAverageFielder;
	}



	public void setGamesFielder(String gamesFielder) {
		this.gamesFielder = gamesFielder;
	}



	public void setPlateAppearanceFielder(String plateAppearanceFielder) {
		this.plateAppearanceFielder = plateAppearanceFielder;
	}



	public void setAtBatsFielder(String atBatsFielder) {
		this.atBatsFielder = atBatsFielder;
	}



	public void setHitsFielder(String hitsFielder) {
		this.hitsFielder = hitsFielder;
	}



	public void setDoubleFielder(String doubleFielder) {
		this.doubleFielder = doubleFielder;
	}



	public void setTripleFielder(String tripleFielder) {
		this.tripleFielder = tripleFielder;
	}



	public void setHomeRunsFielder(String homeRunsFielder) {
		this.homeRunsFielder = homeRunsFielder;
	}



	public void setTotalBasesFielder(String totalBasesFielder) {
		this.totalBasesFielder = totalBasesFielder;
	}



	public void setRunsBattedInFielder(String runsBattedInFielder) {
		this.runsBattedInFielder = runsBattedInFielder;
	}



	public void setRunsFielder(String runsFielder) {
		this.runsFielder = runsFielder;
	}



	public void setStrikeoutsFielder(String strikeoutsFielder) {
		this.strikeoutsFielder = strikeoutsFielder;
	}



	public void setBasesOnBallsFielder(String basesOnBallsFielder) {
		this.basesOnBallsFielder = basesOnBallsFielder;
	}



	public void setHitByPitchFielder(String hitByPitchFielder) {
		this.hitByPitchFielder = hitByPitchFielder;
	}



	public void setSacrificeHitsFielder(String sacrificeHitsFielder) {
		this.sacrificeHitsFielder = sacrificeHitsFielder;
	}



	public void setSacrificeFliesFielder(String sacrificeFliesFielder) {
		this.sacrificeFliesFielder = sacrificeFliesFielder;
	}



	public void setStolenBasesFielder(String stolenBasesFielder) {
		this.stolenBasesFielder = stolenBasesFielder;
	}



	public void setOnBasePercentageFielder(String onBasePercentageFielder) {
		this.onBasePercentageFielder = onBasePercentageFielder;
	}



	public void setSluggingPercentageFielder(String sluggingPercentageFielder) {
		this.sluggingPercentageFielder = sluggingPercentageFielder;
	}



	public void setBattingAverageWithRunnerInScoringPositionFielder(
			String battingAverageWithRunnerInScoringPositionFielder) {
		this.battingAverageWithRunnerInScoringPositionFielder = battingAverageWithRunnerInScoringPositionFielder;
	}



	public void setGameWinningRunsBattedInFielder(
			String gameWinningRunsBattedInFielder) {
		this.gameWinningRunsBattedInFielder = gameWinningRunsBattedInFielder;
	}



	public void setDoublePlayFielder(String doublePlayFielder) {
		this.doublePlayFielder = doublePlayFielder;
	}



	public void setErrorsFielder(String errorsFielder) {
		this.errorsFielder = errorsFielder;
	}



	public void setOpsFielder(String opsFielder) {
		this.opsFielder = opsFielder;
	}



	public void setRc27Fielder(String rc27Fielder) {
		this.rc27Fielder = rc27Fielder;
	}



	public void setRcWinFielder(String rcWinFielder) {
		this.rcWinFielder = rcWinFielder;
	}



	public void setIsoDFielder(String isoDFielder) {
		this.isoDFielder = isoDFielder;
	}



	public void setTeamFielder(String teamFielder) {
		this.teamFielder = teamFielder;
	}

}