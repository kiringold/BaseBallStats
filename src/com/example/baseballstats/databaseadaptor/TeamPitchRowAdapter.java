package com.example.baseballstats.databaseadaptor;

import static com.example.baseballstats.constants.PitchColName.*;

import java.util.List;

import com.example.baseballstats.R;
import com.example.baseballstats.database.PitchStatsRow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TeamPitchRowAdapter extends ArrayAdapter<PitchStatsRow>{

	//LayoutInflater(レイアウトからViewを生成）
			private LayoutInflater inflater;
			private boolean desc;
			private String click;

			//コンストラクタ
	public TeamPitchRowAdapter(Context context, int ResourceId, List<PitchStatsRow> objects, boolean desc, String click) {
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
	}


	//一列分のリストの表示
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		View view = convertView;
		ViewHolder holder;

		if(view == null){
			//convertViewがnullの場合、新規作成
			view = inflater.inflate(R.layout.team_pitch_row, null);

		holder = new ViewHolder();

		holder.tv1 = (TextView)view.findViewById(R.id.number_pitch_rowt);

		holder.tv2 = (TextView)view.findViewById(R.id.name_pitch_rowt);

		holder.tv3 = (TextView)view.findViewById(R.id.earned_run_average_pitch_rowt);

		holder.tv4 = (TextView)view.findViewById(R.id.games_pitch_rowt);

		holder.tv5 = (TextView)view.findViewById(R.id.complete_games_pitch_rowt);

		holder.tv6 = (TextView)view.findViewById(R.id.shutouts_pitch_rowt);

		holder.tv7 = (TextView)view.findViewById(R.id.no_bb_hbp_pitch_rowt);

		holder.tv8 = (TextView)view.findViewById(R.id.wins_pitch_rowt);

		holder.tv9 = (TextView)view.findViewById(R.id.losses_pitch_rowt);

		holder.tv10 = (TextView)view.findViewById(R.id.holds_pitch_rowt);

		holder.tv11 = (TextView)view.findViewById(R.id.holds_points_pitch_rowt);

		holder.tv12 = (TextView)view.findViewById(R.id.saves_pitch_rowt);

		holder.tv13 = (TextView)view.findViewById(R.id.winning_percentage_pitch_rowt);

		holder.tv14 = (TextView)view.findViewById(R.id.innings_pitched_pitch_rowt);

		holder.tv15 = (TextView)view.findViewById(R.id.hits_pitch_rowt);

		holder.tv16 = (TextView)view.findViewById(R.id.home_runs_pitch_rowt);

		holder.tv17 = (TextView)view.findViewById(R.id.strikeouts_pitch_rowt);

		holder.tv18 = (TextView)view.findViewById(R.id.bases_on_balls_pitch_rowt);

		holder.tv19 = (TextView)view.findViewById(R.id.hit_by_pitch_pitch_rowt);

		holder.tv20 = (TextView)view.findViewById(R.id.wild_pitches_pitch_rowt);

		holder.tv21 = (TextView)view.findViewById(R.id.balks_pitch_rowt);

		holder.tv22 = (TextView)view.findViewById(R.id.runs_pitch_rowt);

		holder.tv23 = (TextView)view.findViewById(R.id.earned_runs_pitch_rowt);

		holder.tv24 = (TextView)view.findViewById(R.id.whip_pitch_rowt);

		holder.tv25 = (TextView)view.findViewById(R.id.k_bb_pitch_rowt);

		view.setTag(holder);

		}else{
			holder = (ViewHolder)view.getTag();
		}

		//１列分のアイテムを取得
		PitchStatsRow row = getItem(position);

		holder.tv1.setText(row.getNumberPitch());

		holder.tv2.setText(row.getNamePitch());

		holder.tv3.setText(row.getEarnedRunAveragePitch());
		if(getItem(0).getEarnedRunAveragePitch().equals(row.getEarnedRunAveragePitch()) && !(row.getEarnedRunAveragePitch().equals("-"))
			&& click.equals(EARNED_RUN_AVERAGE_PITCH)){
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

		holder.tv4.setText(row.getGamesPitch());
		if(getItem(0).getGamesPitch().equals(row.getGamesPitch()) && !(row.getGamesPitch().equals("-"))
				&& click.equals(GAMES_PITCH)){
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

		holder.tv5.setText(row.getCompleteGamesPitch());
		if(getItem(0).getCompleteGamesPitch().equals(row.getCompleteGamesPitch()) && !(row.getCompleteGamesPitch().equals("-"))
				&& click.equals(COMPLETE_GAMES_PITCH)){
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

		holder.tv6.setText(row.getShutoutsPitch());
		if(getItem(0).getShutoutsPitch().equals(row.getShutoutsPitch()) && !(row.getShutoutsPitch().equals("-"))
				&& click.equals(SHUTOUTS_PITCH)){
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

		holder.tv7.setText(row.getNotBbHbpPitch());
		if(getItem(0).getNotBbHbpPitch().equals(row.getNotBbHbpPitch()) && !(row.getNotBbHbpPitch().equals("-"))
				&& click.equals(NOT_BB_HBP_PITCH)){
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

		holder.tv8.setText(row.getWinsPitch());
		if(getItem(0).getWinsPitch().equals(row.getWinsPitch()) && !(row.getWinsPitch().equals("-"))
				&& click.equals(WINS_PITCH)){
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

		holder.tv9.setText(row.getLossesPitch());
		if(getItem(0).getLossesPitch().equals(row.getLossesPitch()) && !(row.getLossesPitch().equals("-"))
				&& click.equals(LOSSES_PITCH)){
			if(!desc){
				holder.tv9.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
				holder.tv9.setTextColor(Color.BLUE);
			}else{
				holder.tv9.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
				holder.tv9.setTextColor(Color.RED);
			}
		}else{
			holder.tv9.setTypeface(Typeface.DEFAULT);
			holder.tv9.setTextColor(Color.BLACK);
		}

		holder.tv10.setText(row.getHoldsPitch());
		if(getItem(0).getHoldsPitch().equals(row.getHoldsPitch()) && !(row.getHoldsPitch().equals("-"))
				&& click.equals(HOLDS_PITCH)){
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

		holder.tv11.setText(row.getHoldsPointsPitch());
		if(getItem(0).getHoldsPointsPitch().equals(row.getHoldsPointsPitch()) && !(row.getHoldsPointsPitch().equals("-"))
				&& click.equals(HOLDS_PONTS_PITCH)){
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

		holder.tv12.setText(row.getSavesPitch());
		if(getItem(0).getSavesPitch().equals(row.getSavesPitch()) && !(row.getSavesPitch().equals("-"))
				&& click.equals(SAVES_PITCH)){
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

		holder.tv13.setText(row.getWinningPercentagePitch());
		if(getItem(0).getWinningPercentagePitch().equals(row.getWinningPercentagePitch()) && !(row.getWinningPercentagePitch().equals("-"))
				&& click.equals(WINNING_PERCENTAGE_PITCH)){
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

		holder.tv14.setText(row.getInningsPitchedPitch());
		if(getItem(0).getInningsPitchedPitch().equals(row.getInningsPitchedPitch()) && !(row.getInningsPitchedPitch().equals("-"))
				&& click.equals(INNINGS_PITCHED_PITCH)){
			if(!desc){
				holder.tv14.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
				holder.tv14.setTextColor(Color.RED);
			}else{
				holder.tv14.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
				holder.tv14.setTextColor(Color.BLUE);
			}
		}else{
			holder.tv14.setTypeface(Typeface.DEFAULT);
			holder.tv14.setTextColor(Color.BLACK);
		}

		holder.tv15.setText(row.getHitsPitch());
		if(getItem(0).getHitsPitch().equals(row.getHitsPitch()) && !(row.getHitsPitch().equals("-"))
				&& click.equals(HITS_PITCH)){
			if(!desc){
				holder.tv15.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
				holder.tv15.setTextColor(Color.BLUE);
			}else{
				holder.tv15.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
				holder.tv15.setTextColor(Color.RED);
			}
		}else{
			holder.tv15.setTypeface(Typeface.DEFAULT);
			holder.tv15.setTextColor(Color.BLACK);
		}

		holder.tv16.setText(row.getHomeRunsPitch());
		if(getItem(0).getHomeRunsPitch().equals(row.getHomeRunsPitch()) && !(row.getHomeRunsPitch().equals("-"))
				&& click.equals(HOME_RUNS_PITCH)){
			if(!desc){
				holder.tv16.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
				holder.tv16.setTextColor(Color.BLUE);
			}else{
				holder.tv16.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
				holder.tv16.setTextColor(Color.RED);
			}
		}else{
			holder.tv16.setTypeface(Typeface.DEFAULT);
			holder.tv16.setTextColor(Color.BLACK);
		}

		holder.tv17.setText(row.getStrikeoutsPitch());
		if(getItem(0).getStrikeoutsPitch().equals(row.getStrikeoutsPitch()) && !(row.getStrikeoutsPitch().equals("-"))
				&& click.equals(STRIKEOUTS_PITCH)){
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

		holder.tv18.setText(row.getBasesOnBallsPitch());
		if(getItem(0).getBasesOnBallsPitch().equals(row.getBasesOnBallsPitch()) && !(row.getBasesOnBallsPitch().equals("-"))
				&& click.equals(BASES_ON_BALLS_PITCH)){
			if(!desc){
				holder.tv18.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
				holder.tv18.setTextColor(Color.BLUE);
			}else{
				holder.tv18.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
				holder.tv18.setTextColor(Color.RED);
			}
		}else{
			holder.tv18.setTypeface(Typeface.DEFAULT);
			holder.tv18.setTextColor(Color.BLACK);
		}

		holder.tv19.setText(row.getHitByPitchPitch());
		if(getItem(0).getHitByPitchPitch().equals(row.getHitByPitchPitch()) && !(row.getHitByPitchPitch().equals("-"))
				&& click.equals(HIT_BY_PITCH_PITCH)){
			if(!desc){
				holder.tv19.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
				holder.tv19.setTextColor(Color.BLUE);
			}else{
				holder.tv19.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
				holder.tv19.setTextColor(Color.RED);
			}
		}else{
			holder.tv19.setTypeface(Typeface.DEFAULT);
			holder.tv19.setTextColor(Color.BLACK);
		}

		holder.tv20.setText(row.getWildPitchesPitch());
		if(getItem(0).getWildPitchesPitch().equals(row.getWildPitchesPitch()) && !(row.getWildPitchesPitch().equals("-"))
				&& click.equals(WILD_PITCHES_PITCH)){
			if(!desc){
				holder.tv20.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
				holder.tv20.setTextColor(Color.BLUE);
			}else{
				holder.tv20.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
				holder.tv20.setTextColor(Color.RED);
			}
		}else{
			holder.tv20.setTypeface(Typeface.DEFAULT);
			holder.tv20.setTextColor(Color.BLACK);
		}

		holder.tv21.setText(row.getBalksPitch());
		if(getItem(0).getBalksPitch().equals(row.getBalksPitch()) && !(row.getBalksPitch().equals("-"))
				&& click.equals(BALK_PITCH)){
			if(!desc){
				holder.tv21.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
				holder.tv21.setTextColor(Color.BLUE);
			}else{
				holder.tv21.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
				holder.tv21.setTextColor(Color.RED);
			}
		}else{
			holder.tv21.setTypeface(Typeface.DEFAULT);
			holder.tv21.setTextColor(Color.BLACK);
		}

		holder.tv22.setText(row.getRunsPitch());
		if(getItem(0).getRunsPitch().equals(row.getRunsPitch()) && !(row.getRunsPitch().equals("-"))
				&& click.equals(RUNS_PITCH)){
			if(!desc){
				holder.tv22.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
				holder.tv22.setTextColor(Color.BLUE);
			}else{
				holder.tv22.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
				holder.tv22.setTextColor(Color.RED);
			}
		}else{
			holder.tv22.setTypeface(Typeface.DEFAULT);
			holder.tv22.setTextColor(Color.BLACK);
		}

		holder.tv23.setText(row.getEarnedRunsPitch());
		if(getItem(0).getEarnedRunsPitch().equals(row.getEarnedRunsPitch()) && !(row.getEarnedRunsPitch().equals("-"))
				&& click.equals(EARNED_RUNS_PITCH)){
			if(!desc){
				holder.tv23.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
				holder.tv23.setTextColor(Color.BLUE);
			}else{
				holder.tv23.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
				holder.tv23.setTextColor(Color.RED);
			}
		}else{
			holder.tv23.setTypeface(Typeface.DEFAULT);
			holder.tv23.setTextColor(Color.BLACK);
		}

		holder.tv24.setText(row.getWhipPitch());
		if(getItem(0).getWhipPitch().equals(row.getWhipPitch()) && !(row.getWhipPitch().equals("-"))
				&& click.equals(WHIP_PITCH)){
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

		holder.tv25.setText(row.getKbbPitch());
		if(getItem(0).getKbbPitch().equals(row.getKbbPitch()) && !(row.getKbbPitch().equals("-"))
				&& click.equals(KBB_PITCH)){
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
		return view;
	}

}
