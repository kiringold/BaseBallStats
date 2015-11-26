package com.example.baseballstats.stats;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import static com.example.baseballstats.constants.TeamNameConstants.*;
import static com.example.baseballstats.constants.TeamURLConstants.*;
import static com.example.baseballstats.constants.FielderStatsConstants.*;

public class getFielderStats {
//	private Context context;
//	private Handler handler;
	public getFielderStats() {
		super();
//		this.context = context;
//		this.handler = handler;
	}

	private ArrayList< ArrayList<String>> person  = new ArrayList< ArrayList<String>>();


	private String[] teamFielderURL = {GIANTS_FIELDER_URL, TIGERS_FIELDER_URL,
			CARP_FIELDER_URL, DRAGONS_FIELDER_URL,
			BAYSTARS_FIELDER_URL, SWALLOWS_FIELDER_URL,
			HAWKS_FIELDER_URL, BUFFALOES_FIELDER_URL,
			FIGHTERS_FIELDER_URL, MARINES_FIELDER_URL,
			LIONS_FIELDER_URL, EAGLES_FIELDER_URL };



	public ArrayList< ArrayList<String>> getStart(){
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// マルチスレッドにしたい処理 ここから
					for(int i=0; i<teamFielderURL.length; i++){

						// HTMLのドキュメントを取得
						Document document = Jsoup.connect(teamFielderURL[i]).get();
//						Document document = Jsoup.connect(teamFielderURL[i]).timeout(0).get();


						//							Document document = Jsoup.connect(SWALLOWS_FIELDER_URL).get();


						// bodyタグをIDから取得
						Elements FielderStatsTeam = document.getElementsByTag("td");


						String[] FielderStatsSingle  = FielderStatsTeam.text().split(" ", 0);

						//リストの中身確認
						//							for(String a : PitchStatsSingle ){
						//							Log.d("split", a);
						//							}


						int tes = 0;
						for(int k=0; k<FielderStatsSingle.length/25; k++){
							ArrayList<String> list1 =new ArrayList<String>();

							for(int j=0; j<25; j++,tes++){
								list1.add(FielderStatsSingle[tes]);
							}


							list1.add(opsCalc(list1.get(SLUGGING_PERCENTAGE_FIELDER), list1.get(ON_BASE_PERCENTAGE_FIELDER)));
							list1.add(isoDCalc(list1.get(ON_BASE_PERCENTAGE_FIELDER), list1.get(BATTING_AVERAGE_FIELDER)));





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
						}
					}

				} catch (IOException e) {
					e.printStackTrace();
//					handler.post(new Runnable() {
//						public void run() {
//							String msg = "エラー：通信環境を確認してください";
//							Toast.makeText(context, msg, Toast.LENGTH_LONG *10).show();
//						}
//					});
				}



			}

		});
		th.start();
		try {
			th.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return person;
	}

	private String opsCalc(String slg, String obp){
		String ops = "-";
		if(!slg.equals("-") && !obp.equals("-")){
			BigDecimal lslg = new BigDecimal(slg);
			BigDecimal lobp = new BigDecimal(obp);
			//				Log.d("lslg", slg.toString());
			//				Log.d("obp", obp.toString());
			ops = lslg.add(lobp).toString().replaceFirst("0\\.", "\\.");
		}
		//			Log.d("ops", ops.toString());
		return ops;
	}

	private String isoDCalc(String obp, String ave){
		String isoD = "-";
		if(!obp.equals("-") && !ave.equals("-")){
			BigDecimal lobp = new BigDecimal(obp);
			BigDecimal lave = new BigDecimal(ave);
			isoD = lobp.subtract(lave).toString().replaceFirst("0\\.", "\\.");
		}
		//			Log.d("isod", isoD.toString());
		return isoD;
	}

}
