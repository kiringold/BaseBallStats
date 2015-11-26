package com.example.baseballstats.stats;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import static com.example.baseballstats.constants.TeamURLConstants.*;
import static com.example.baseballstats.constants.PitchStatsConstants.*;
import static com.example.baseballstats.constants.TeamNameConstants.*;

public class getPitchStats {
	private Context context;
	private Handler handler;

	public getPitchStats(Context context, Handler handler){
		super();
		this.context = context;
		this.handler = handler;
		}

	private char nbsp = 160;

	private ArrayList< ArrayList<String>> person  = new ArrayList< ArrayList<String>>();


	private String[] teamPitchURL = {GIANTS_PITCH_URL, TIGERS_PITCH_URL,
			CARP_PITCH_URL, DRAGONS_PITCH_URL,
			BAYSTARS_PITCH_URL, SWALLOWS_PITCH_URL,
			HAWKS_PITCH_URL, BUFFALOES_PITCH_URL,
			FIGHTERS_PITCH_URL, MARINES_PITCH_URL,
			LIONS_PITCH_URL, EAGLES_PITCH_URL};

	public ArrayList< ArrayList<String>> getStart(){
		Thread th = new Thread(new Runnable() {
			@Override
			public void run(){
//				// マルチスレッドにしたい処理 ここから
//				for(int i=0; i<teamPitchURL.length; i++){
					try {
						// マルチスレッドにしたい処理 ここから
						for(int i=0; i<teamPitchURL.length; i++){

						// HTMLのドキュメントを取得
							Document document = Jsoup.connect(teamPitchURL[i]).get();
//						Document document = Jsoup.connect(teamPitchURL[i]).timeout(0).get();
//						Document document = Jsoup.connect(GIANTS_PITCH_URL).get();


						// bodyタグをIDから取得
						Elements PitchStatsTeam = document.getElementsByTag("td");


						String[] PitchStatsSingle  = PitchStatsTeam.text().split(" ", 0);

						//リストの中身確認
//						for(String a : PitchStatsSingle ){
//						Log.d("split", a);
//						}


						int tes = 0;
						for(int k=0; k<PitchStatsSingle.length/23; k++){
							ArrayList<String> list1 =new ArrayList<String>();

							for(int j=0; j<23; j++,tes++){
								list1.add(PitchStatsSingle[tes]);
							}


							list1.add(whipCalc(list1.get(HITS_PITCH), list1.get(BASES_ON_BALLS_PITCH), list1.get(INNINGS_PITCHED_PITCH)));
							list1.add(kbbCalc(list1.get(STRIKEOUTS_PITCH), list1.get(BASES_ON_BALLS_PITCH)));





							switch(i){
							case 0:
								list1.add(GIANTS);
								break;
							case 1:
								list1.add(TIGERS);
								break;
							case 2:
								list1.add(CARP);
								break;
							case 3:
								list1.add(DRAGONS);
								break;
							case 4:
								list1.add(BAYSTARS);
								break;
							case 5:
								list1.add(SWALLOWS);
								break;
							case 6:
								list1.add(HAWKS);
								break;
							case 7:
								list1.add(BUFFALOES);
								break;
							case 8:
								list1.add(FIGHTERS);
								break;
							case 9:
								list1.add(MARINES);
								break;
							case 10:
								list1.add(LIONS);
								break;
							case 11:
								list1.add(EAGLES);
								break;
							default:
								break;
							}

							person.add(list1);
//							//リストの中身
//							for(String a:list1){
//								Log.d("listnai", a);
//							}

//							Log.d("persontestuchi1", person.get(0).get(1));
//							Log.d("persontestuchi1", person.get(60).get(1));
//							Log.d("persontestuchi1", person.get(120).get(1));


						}
						}

					} catch (IOException e) {
						e.printStackTrace();
						handler.post(new Runnable() {
						    public void run() {
								String msg = "エラー：通信環境を確認してください";
						        Toast.makeText(context, msg, Toast.LENGTH_LONG *10).show();
						        }
						    });
					}
//					Log.d("persontestuchi2", person.get(22).get(1));

				}

//				Log.d("persontestuchi3", person.get(33).get(1));


		});
		th.start();
		try {
			th.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return person;
	}

	private String whipCalc(String hits, String bb, String innings){
		String whip = "-";
		if(!hits.equals("-") && !hits.equals("0") && !bb.equals("-") &&!bb.equals("0") && !innings.equals("-") &&!innings.equals("0")  ){
			BigDecimal lhits = new BigDecimal(hits);
			BigDecimal lbb = new BigDecimal(bb);
			BigDecimal linnings = null;
			if(innings.endsWith("/3")){
				String[]a = innings.split(String.valueOf(nbsp), 0);
				String[]b = a[1].split("/", 0);
				BigDecimal innings1 = new BigDecimal(a[0]);
				BigDecimal innings2 = new BigDecimal(b[0]);
				BigDecimal innings3 = new BigDecimal(b[1]);
				linnings = innings1.add(innings2.divide(innings3, 2, BigDecimal.ROUND_DOWN));
			}else{
				linnings = new BigDecimal(innings);
			}
			whip = (lhits.add(lbb)).divide(linnings, 2, BigDecimal.ROUND_HALF_UP).toString();
		}
//		Log.d("whip", whip.toString());
		return whip;
	}

	private String kbbCalc(String k, String bb){
		String kbb = "-";
		if(!k.equals("-") && !k.equals("0") && !bb.equals("-") && !bb.equals("0")){
			BigDecimal lk = new BigDecimal(k);
			BigDecimal lbb = new BigDecimal(bb);
			kbb = lk.divide(lbb, 2, BigDecimal.ROUND_HALF_UP).toString();
		}
//		Log.d("kbb", kbb.toString());
		return kbb;
	}

//	public void startSet(){
//		setPitchStats sp = new setPitchStats(context);
//		sp.setPitchStats(person);
//	}

}