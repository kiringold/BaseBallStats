package com.example.baseballstats.databaseadaptor;

import static com.example.baseballstats.constants.FieldColName.*;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.baseballstats.R;
import com.example.baseballstats.database.FielderStatsRow;

public class TeamFielderRowAdaptor extends ArrayAdapter<FielderStatsRow>{
	//LayoutInflater(レイアウトからViewを生成）
	private LayoutInflater inflater;
	private boolean desc;
	private String click;

	//コンストラクタ
	public TeamFielderRowAdaptor(Context context, int ResourceId, List<FielderStatsRow> objects, boolean desc, String click) {
		super(context, ResourceId, objects);
		//Contextからlayoutinflaterを取得
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.desc = desc;
		this.click = click;
	}

	private class ViewHolder{
		TextView tv1;
		TextView tv2;
		TextView tv3;
		TextView tv4;
		TextView tv5;
		TextView tv6;
		TextView tv7;
		TextView tv8;
		TextView tv9;
		TextView tv10;
		TextView tv11;
		TextView tv12;
		TextView tv13;
		TextView tv14;
		TextView tv15;
		TextView tv16;
		TextView tv17;
		TextView tv18;
		TextView tv19;
		TextView tv20;
		TextView tv21;
		TextView tv22;
		TextView tv23;
		TextView tv24;
		TextView tv25;
		TextView tv26;
		TextView tv27;
	}


	//一列分のリストの表示
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		View view = convertView;
		ViewHolder holder;

		if(view == null){
			//convertViewがnullの場合、新規作成
			view = inflater.inflate(R.layout.team_fielder_row, null);

			holder = new ViewHolder();

			holder.tv1 = (TextView)view.findViewById(R.id.number_fielder_rowt);

			holder.tv2 = (TextView)view.findViewById(R.id.name_fielder_rowt);

			holder.tv3 = (TextView)view.findViewById(R.id.batting_average_fielder_rowt);

			holder.tv4 = (TextView)view.findViewById(R.id.games_fielder_rowt);

			holder.tv5 = (TextView)view.findViewById(R.id.plate_appearances_fielder_rowt);

			holder.tv6 = (TextView)view.findViewById(R.id.at_bats_fielder_rowt);

			holder.tv7 = (TextView)view.findViewById(R.id.hits_fielder_rowt);

			holder.tv8 = (TextView)view.findViewById(R.id.double_fielder_rowt);

			holder.tv9 = (TextView)view.findViewById(R.id.triple_fielder_rowt);

			holder.tv10 = (TextView)view.findViewById(R.id.home_runs_fielder_rowt);

			holder.tv11 = (TextView)view.findViewById(R.id.total_bases_fielder_rowt);

			holder.tv12 = (TextView)view.findViewById(R.id.runs_battend_in_fielder_rowt);

			holder.tv13 = (TextView)view.findViewById(R.id.runs_fielder_rowt);

			holder.tv14 = (TextView)view.findViewById(R.id.strikeouts_fielder_rowt);

			holder.tv15 = (TextView)view.findViewById(R.id.bases_on_balls_fielder_rowt);

			holder.tv16 = (TextView)view.findViewById(R.id.hit_by_pitch_fielder_rowt);

			holder.tv17 = (TextView)view.findViewById(R.id.sacrifice_hits_fielder_rowt);

			holder.tv18 = (TextView)view.findViewById(R.id.sacrifice_flies_fielder_rowt);

			holder.tv19 = (TextView)view.findViewById(R.id.stolen_bases_fielder_rowt);

			holder.tv20 = (TextView)view.findViewById(R.id.on_base_percentage_fielder_rowt);

			holder.tv21 = (TextView)view.findViewById(R.id.slugging_percentage_fielder_rowt);

			holder.tv22 = (TextView)view.findViewById(R.id.batting_average_with_runners_in_scoring_position_fielder_rowt);

			holder.tv23 = (TextView)view.findViewById(R.id.game_winning_runs_batted_in_fielder_rowt);

			holder.tv24 = (TextView)view.findViewById(R.id.double_play_fielder_rowt);

			holder.tv25 = (TextView)view.findViewById(R.id.errors_fielder_rowt);

			holder.tv26 = (TextView)view.findViewById(R.id.ops_fielder_rowt);

			holder.tv27 = (TextView)view.findViewById(R.id.isod_fielder_rowt);

			view.setTag(holder);

		}else{
			holder = (ViewHolder)view.getTag();
		}

		//１列分のアイテムを取得
		FielderStatsRow row = getItem(position);

		holder.tv1.setText(row.getNumberFielder());

		holder.tv2.setText(row.getNameFielder());

		holder.tv3.setText(row.getBattingAverageFielder());
		if(getItem(0).getBattingAverageFielder().equals(row.getBattingAverageFielder()) && !(row.getBattingAverageFielder().equals("-"))
				&& click.equals(BATTING_AVERAGE_FIELDER)){
				if(!desc){
					holder.tv3.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv3.setTextColor(Color.RED);
				}else{
					holder.tv3.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv3.setTextColor(Color.BLUE);
				}
			}else{
				holder.tv3.setTypeface(Typeface.DEFAULT);
				holder.tv3.setTextColor(Color.BLACK);
			}

		holder.tv4.setText(row.getGamesFielder());
		if(getItem(0).getGamesFielder().equals(row.getGamesFielder()) && !(row.getGamesFielder().equals("-"))
				&& click.equals(GAMES_FIELDER)){
				if(!desc){
					holder.tv4.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv4.setTextColor(Color.RED);
				}else{
					holder.tv4.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv4.setTextColor(Color.BLUE);
				}
			}else{
				holder.tv4.setTypeface(Typeface.DEFAULT);
				holder.tv4.setTextColor(Color.BLACK);
			}

		holder.tv5.setText(row.getPlateAppearanceFielder());
		if(getItem(0).getPlateAppearanceFielder().equals(row.getPlateAppearanceFielder()) && !(row.getPlateAppearanceFielder().equals("-"))
				&& click.equals(PLATE_APPEARANCES_FIELDER)){
				if(!desc){
					holder.tv5.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv5.setTextColor(Color.RED);
				}else{
					holder.tv5.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv5.setTextColor(Color.BLUE);
				}
			}else{
				holder.tv5.setTypeface(Typeface.DEFAULT);
				holder.tv5.setTextColor(Color.BLACK);
			}

		holder.tv6.setText(row.getAtBatsFielder());
		if(getItem(0).getAtBatsFielder().equals(row.getAtBatsFielder()) && !(row.getAtBatsFielder().equals("-"))
				&& click.equals(AT_BATS_FIELDER)){
				if(!desc){
					holder.tv6.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv6.setTextColor(Color.RED);
				}else{
					holder.tv6.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv6.setTextColor(Color.BLUE);
				}
			}else{
				holder.tv6.setTypeface(Typeface.DEFAULT);
				holder.tv6.setTextColor(Color.BLACK);
			}

		holder.tv7.setText(row.getHitsFielder());
		if(getItem(0).getHitsFielder().equals(row.getHitsFielder()) && !(row.getHitsFielder().equals("-"))
				&& click.equals(HITS_FIELDER)){
				if(!desc){
					holder.tv7.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv7.setTextColor(Color.RED);
				}else{
					holder.tv7.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv7.setTextColor(Color.BLUE);
				}
			}else{
				holder.tv7.setTypeface(Typeface.DEFAULT);
				holder.tv7.setTextColor(Color.BLACK);
			}

		holder.tv8.setText(row.getDoubleFielder());
		if(getItem(0).getDoubleFielder().equals(row.getDoubleFielder()) && !(row.getDoubleFielder().equals("-"))
				&& click.equals(DOUBLE_FIELDER)){
				if(!desc){
					holder.tv8.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv8.setTextColor(Color.RED);
				}else{
					holder.tv8.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv8.setTextColor(Color.BLUE);
				}
			}else{
				holder.tv8.setTypeface(Typeface.DEFAULT);
				holder.tv8.setTextColor(Color.BLACK);
			}

		holder.tv9.setText(row.getTripleFielder());
		if(getItem(0).getTripleFielder().equals(row.getTripleFielder()) && !(row.getTripleFielder().equals("-"))
				&& click.equals(TRIPLE_FIELDER)){
				if(!desc){
					holder.tv9.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv9.setTextColor(Color.RED);
				}else{
					holder.tv9.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv9.setTextColor(Color.BLUE);
				}
			}else{
				holder.tv9.setTypeface(Typeface.DEFAULT);
				holder.tv9.setTextColor(Color.BLACK);
			}

		holder.tv10.setText(row.getHomeRunsFielder());
		if(getItem(0).getHomeRunsFielder().equals(row.getHomeRunsFielder()) && !(row.getHomeRunsFielder().equals("-"))
				&& click.equals(HOME_RUNS_FIELDER)){
				if(!desc){
					holder.tv10.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv10.setTextColor(Color.RED);
				}else{
					holder.tv10.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv10.setTextColor(Color.BLUE);
				}
			}else{
				holder.tv10.setTypeface(Typeface.DEFAULT);
				holder.tv10.setTextColor(Color.BLACK);
			}

		holder.tv11.setText(row.getTotalBasesFielder());
		if(getItem(0).getTotalBasesFielder().equals(row.getTotalBasesFielder()) && !(row.getTotalBasesFielder().equals("-"))
				&& click.equals(TOTAL_BASES_FIELDER)){
				if(!desc){
					holder.tv11.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv11.setTextColor(Color.RED);
				}else{
					holder.tv11.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv11.setTextColor(Color.BLUE);
				}
			}else{
				holder.tv11.setTypeface(Typeface.DEFAULT);
				holder.tv11.setTextColor(Color.BLACK);
			}

		holder.tv12.setText(row.getRunsBattedInFielder());
		if(getItem(0).getRunsBattedInFielder().equals(row.getRunsBattedInFielder()) && !(row.getRunsBattedInFielder().equals("-"))
				&& click.equals(RUN_BATTED_IN_FIELDER)){
				if(!desc){
					holder.tv12.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv12.setTextColor(Color.RED);
				}else{
					holder.tv12.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv12.setTextColor(Color.BLUE);
				}
			}else{
				holder.tv12.setTypeface(Typeface.DEFAULT);
				holder.tv12.setTextColor(Color.BLACK);
			}

		holder.tv13.setText(row.getRunsFielder());
		if(getItem(0).getRunsFielder().equals(row.getRunsFielder()) && !(row.getRunsFielder().equals("-"))
				&& click.equals(RUNS_FIELDER)){
				if(!desc){
					holder.tv13.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv13.setTextColor(Color.RED);
				}else{
					holder.tv13.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv13.setTextColor(Color.BLUE);
				}
			}else{
				holder.tv13.setTypeface(Typeface.DEFAULT);
				holder.tv13.setTextColor(Color.BLACK);
			}

		holder.tv14.setText(row.getStrikeoutsFielder());
		if(getItem(0).getStrikeoutsFielder().equals(row.getStrikeoutsFielder()) && !(row.getStrikeoutsFielder().equals("-"))
				&& click.equals(STRIKEOUTS_FIELDER)){
				if(!desc){
					holder.tv14.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv14.setTextColor(Color.BLUE);
				}else{
					holder.tv14.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv14.setTextColor(Color.RED);
				}
			}else{
				holder.tv14.setTypeface(Typeface.DEFAULT);
				holder.tv14.setTextColor(Color.BLACK);
			}

		holder.tv15.setText(row.getBasesOnBallsFielder());
		if(getItem(0).getBasesOnBallsFielder().equals(row.getBasesOnBallsFielder()) && !(row.getBasesOnBallsFielder().equals("-"))
				&& click.equals(BASES_ON_BALLS_FIELDER)){
				if(!desc){
					holder.tv15.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv15.setTextColor(Color.RED);
				}else{
					holder.tv15.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv15.setTextColor(Color.BLUE);
				}
			}else{
				holder.tv15.setTypeface(Typeface.DEFAULT);
				holder.tv15.setTextColor(Color.BLACK);
			}

		holder.tv16.setText(row.getHitByPitchFielder());
		if(getItem(0).getHitByPitchFielder().equals(row.getHitByPitchFielder()) && !(row.getHitByPitchFielder().equals("-"))
				&& click.equals(HIT_BY_PITCH_FIELDER)){
				if(!desc){
					holder.tv16.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv16.setTextColor(Color.RED);
				}else{
					holder.tv16.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv16.setTextColor(Color.BLUE);
				}
			}else{
				holder.tv16.setTypeface(Typeface.DEFAULT);
				holder.tv16.setTextColor(Color.BLACK);
			}

		holder.tv17.setText(row.getSacrificeHitsFielder());
		if(getItem(0).getSacrificeHitsFielder().equals(row.getSacrificeHitsFielder()) && !(row.getSacrificeHitsFielder().equals("-"))
				&& click.equals(SACRIFICE_HITS_FIELDER)){
				if(!desc){
					holder.tv17.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv17.setTextColor(Color.RED);
				}else{
					holder.tv17.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv17.setTextColor(Color.BLUE);
				}
			}else{
				holder.tv17.setTypeface(Typeface.DEFAULT);
				holder.tv17.setTextColor(Color.BLACK);
			}

		holder.tv18.setText(row.getSacrificeFliesFielder());
		if(getItem(0).getSacrificeFliesFielder().equals(row.getSacrificeFliesFielder()) && !(row.getSacrificeFliesFielder().equals("-"))
				&& click.equals(SACRIFICE_FLIES_FIELDER)){
				if(!desc){
					holder.tv18.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv18.setTextColor(Color.RED);
				}else{
					holder.tv18.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv18.setTextColor(Color.BLUE);
				}
			}else{
				holder.tv18.setTypeface(Typeface.DEFAULT);
				holder.tv18.setTextColor(Color.BLACK);
			}

		holder.tv19.setText(row.getStolenBasesFielder());
		if(getItem(0).getStolenBasesFielder().equals(row.getStolenBasesFielder()) && !(row.getStolenBasesFielder().equals("-"))
				&& click.equals(STOLEN_BASES_FIELDER)){
				if(!desc){
					holder.tv19.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv19.setTextColor(Color.RED);
				}else{
					holder.tv19.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv19.setTextColor(Color.BLUE);
				}
			}else{
				holder.tv19.setTypeface(Typeface.DEFAULT);
				holder.tv19.setTextColor(Color.BLACK);
			}

		holder.tv20.setText(row.getOnBasePercentageFielder());
		if(getItem(0).getOnBasePercentageFielder().equals(row.getOnBasePercentageFielder()) && !(row.getOnBasePercentageFielder().equals("-"))
				&& click.equals(ON_BASE_PERCENTAGE_FIELDER)){
				if(!desc){
					holder.tv20.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv20.setTextColor(Color.RED);
				}else{
					holder.tv20.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv20.setTextColor(Color.BLUE);
				}
			}else{
				holder.tv20.setTypeface(Typeface.DEFAULT);
				holder.tv20.setTextColor(Color.BLACK);
			}

		holder.tv21.setText(row.getSluggingPercentageFielder());
		if(getItem(0).getSluggingPercentageFielder().equals(row.getSluggingPercentageFielder()) && !(row.getSluggingPercentageFielder().equals("-"))
				&& click.equals(SLUGGING_PERCENTAGE_FIELDER)){
				if(!desc){
					holder.tv21.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv21.setTextColor(Color.RED);
				}else{
					holder.tv21.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv21.setTextColor(Color.BLUE);
				}
			}else{
				holder.tv21.setTypeface(Typeface.DEFAULT);
				holder.tv21.setTextColor(Color.BLACK);
			}

		holder.tv22.setText(row.getBattingAverageWithRunnerInScoringPositionFielder());
		if(getItem(0).getBattingAverageWithRunnerInScoringPositionFielder().equals(row.getBattingAverageWithRunnerInScoringPositionFielder()) && !(row.getBattingAverageWithRunnerInScoringPositionFielder().equals("-"))
				&& click.equals(BATTING_AVERAGE_WITH_RUNNERS_IN_SCORING_POSITION_FIELDER)){
				if(!desc){
					holder.tv22.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv22.setTextColor(Color.RED);
				}else{
					holder.tv22.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv22.setTextColor(Color.BLUE);
				}
			}else{
				holder.tv22.setTypeface(Typeface.DEFAULT);
				holder.tv22.setTextColor(Color.BLACK);
			}

		holder.tv23.setText(row.getGameWinningRunsBattedInFielder());
		if(getItem(0).getGameWinningRunsBattedInFielder().equals(row.getGameWinningRunsBattedInFielder()) && !(row.getGameWinningRunsBattedInFielder().equals("-"))
				&& click.equals(GAME_WINNING_RUNS_BATTED_IN_FIELDER)){
				if(!desc){
					holder.tv23.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv23.setTextColor(Color.RED);
				}else{
					holder.tv23.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv23.setTextColor(Color.BLUE);
				}
			}else{
				holder.tv23.setTypeface(Typeface.DEFAULT);
				holder.tv23.setTextColor(Color.BLACK);
			}

		holder.tv24.setText(row.getDoublePlayFielder());
		if(getItem(0).getDoublePlayFielder().equals(row.getDoublePlayFielder()) && !(row.getDoublePlayFielder().equals("-"))
				&& click.equals(DOUBLE_PLAY_FIELDER)){
				if(!desc){
					holder.tv24.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv24.setTextColor(Color.RED);
				}else{
					holder.tv24.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv24.setTextColor(Color.BLUE);
				}
			}else{
				holder.tv24.setTypeface(Typeface.DEFAULT);
				holder.tv24.setTextColor(Color.BLACK);
			}

		holder.tv25.setText(row.getErrorsFielder());
		if(getItem(0).getErrorsFielder().equals(row.getErrorsFielder()) && !(row.getErrorsFielder().equals("-"))
				&& click.equals(ERRORS_FIELDER)){
				if(!desc){
					holder.tv25.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv25.setTextColor(Color.RED);
				}else{
					holder.tv25.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv25.setTextColor(Color.BLUE);
				}
			}else{
				holder.tv25.setTypeface(Typeface.DEFAULT);
				holder.tv25.setTextColor(Color.BLACK);
			}

		holder.tv26.setText(row.getOpsFielder());
		if(getItem(0).getOpsFielder().equals(row.getOpsFielder()) && !(row.getOpsFielder().equals("-"))
				&& click.equals(OPS_FIELDER)){
				if(!desc){
					holder.tv26.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv26.setTextColor(Color.RED);
				}else{
					holder.tv26.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv26.setTextColor(Color.BLUE);
				}
			}else{
				holder.tv26.setTypeface(Typeface.DEFAULT);
				holder.tv26.setTextColor(Color.BLACK);
			}

		holder.tv27.setText(row.getIsoDFielder());
		if(getItem(0).getIsoDFielder().equals(row.getIsoDFielder()) && !(row.getIsoDFielder().equals("-"))
				&& click.equals(ISOD_FIELDER)){
				if(!desc){
					holder.tv27.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv27.setTextColor(Color.RED);
				}else{
					holder.tv27.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
					holder.tv27.setTextColor(Color.BLUE);
				}
			}else{
				holder.tv27.setTypeface(Typeface.DEFAULT);
				holder.tv27.setTextColor(Color.BLACK);
			}

		return view;
	}

}
