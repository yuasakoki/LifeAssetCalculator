package test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Sub sub = new Sub();
		sub.age();
		sub.jyumyou();
		if(sub.getEnd() == 0) {
			sub.dead();
			sub.keisan1();
		}else {
			sub.keisan2();
		}
		//経過日数 = 生存可能日数 - 残り日数
		System.out.println();
		System.out.println("生存可能日数：	" + String.format("%,d", sub.getCount()) + "日");
		System.out.println("経過日数：		" + String.format("%,d", sub.getCount() - sub.getCount2()) + "日");
		System.out.println("\u001b[00;31m" + "のこり：		" + String.format("%,d", sub.getCount2() ) + "日" + "\u001b[00m");
		System.out.println();
		System.out.println("現在の月収が15万円の方は、");
		System.out.println("およそ " + String.format("%,d", sub.shisan()) + "円");
		System.out.println("を今すぐ手に入れると働かなくてもいいです");
		System.out.println("---------------------------------------------------------------");

		sub.teinen();
		
		//命日までのカウントダウン 秒、分、時
		System.out.println( "#	残り	" + String.format("%,d", sub.hour()) + "時間です");
		System.out.println( "#	残り	" + String.format("%,d", sub.minutes()) + "分です");
		System.out.println( "#	残り	" + String.format("%,d", sub.seconds()) + "秒です");
		System.out.println("-----------------------------------------------------------");
		
		System.out.println("\u001b[00;36m" + "*月収の変更をします。\n月収を2桁で入力してください" + "\u001b[00m");
		System.out.println("\u001b[00;31m" + "終了する場合は0" + "\u001b[00m");
		System.out.print(">>");
		
		int mIncome = new Scanner(System.in).nextInt();
		if (mIncome != 0) {
			long yIncome = (mIncome * 10000) * 12;
			sub.teinen2((mIncome * 10000));
			
			boolean loop = true;
			while(loop) {
		
				System.out.println("--------------------------------------------------------");
				System.out.println("\u001b[00;36m" + "*資産運用を計算します\nリタイヤを希望する年齢を入力してください。" + "\u001b[00m");
				
				System.out.println("\u001b[00;31m" + "終了する場合は0" + "\u001b[00m");
				System.out.print(">>");
				int rAge = new Scanner(System.in).nextInt();
				if (rAge != 0) {
					long shisan3 = (sub.getEnd() - rAge) * yIncome;
					int n2 = (rAge - sub.getAge()); //残りの年数
					int n3 = (n2 * 12) + 1; //残りの月数
					
//					System.out.println("--------------------------------------------------------");
					System.out.println("\u001b[00;36m" + "*希望の年利\n6％以上は希望の年利を入力してください。%を省く" + "\u001b[00m");
					System.out.println("\u001b[00;31m" + "数字が多くなるにつれてハイリスクハイリターンです。" + "\u001b[00m");
					System.out.println("1: 3%    2: 4%    3: 5%    4: 6%    ");
					System.out.print(">>");
					
					int select3 = new Scanner(System.in).nextInt();
					sub.shisanKeisei(select3, shisan3, n3, n2);
					
					sub.ikkatu();
					
				}else {loop = false;}
			}
		}
		
		
		
	
		
		
		
		System.out.println("ご利用ありがとうございました。\nリクエストがありましたら是非おきかせください。");
		System.out.println("* あくまでも予想の計算です。\nマイナスに考えないでくださいね。\nあなたの幸せを願っています。");
		System.out.println();
		System.out.println("** 年利の対象となっているのは ");
		System.out.println("	~3％			海外債権(先進国) ");
		System.out.println("	4％〜5％		インデックスファンド ");
		System.out.println("	6％〜8％		アクティブファンド グロース株 ");
		System.out.println("	9％〜11％		アクティブファンド バリュー株 ");
		System.out.println("	10%~		リートREIT(不動産投資信託) ");
		System.out.println("");
		System.out.println("ちなみに、資産運用をしない場合、時給" + sub.jikyu() + "円でないといけません");
		
//		System.out.println("投資などはリスクはありますが、イデコは所得控除、ニーサや積み立てニーサは少額投資非課税制度");
//		System.out.println("投資信託型変額生命保険は保険なので支払うと所得控除、満期の返金は保険金なので所得税がかからないみたいです。");
//		System.out.println("	r＞g  『21世紀の資本』 ピケティ著");
				
	}

//		System.out.println("P.S.予定日までのカウントダウンにも使えます。");

}
//		
//			for(int teinen = 60; teinen < sub.getEnd() ; teinen += 5) {
//
//				long shisan2 = (sub.getEnd() - teinen) * yIncome;
//				int n = (teinen - sub.getAge());
//				System.out.println(teinen + "歳で定年退職する場合は,のこり " + n + "年");
////				System.out.println(teinen + "歳で定年退職する場合は");
//				System.out.println(teinen + "歳から命日までおよそ " +
//							String.format("%,d", shisan2 ) + "円 以上が必要なので、");
//				System.out.println("月々 " +
//							String.format("%,d", (shisan2 / n)/12 ) + "円を貯金してください。");
//				System.out.println("-----------------------------------------------------------");
//				if(teinen == 90) {
//					break;
//				}
//			}
		// 秒 second
//		System.out.println("今までで		" + ((count3 * 24) * 60) * 60 + "秒、生きてきました。");
//		System.out.println("トータル：	" + ((count  * 24) * 60) * 60 + "秒、生きることがでるので");
//		System.out.println();

		// 分 min
//		System.out.println("今までで		" + (count3 * 24) * 60 + "分、生きてきました。");
//		System.out.println("トータル：	" + (count  * 24) * 60 + "分、生きることがでるので");
//		System.out.println();

		// 時間 hour
//		System.out.println("今までで		" + (count3 * 24) + "時間、生きてきました。");
//		System.out.println("トータル：	" + (count  * 24) + "時間、生きることがでるので");







//		生年月日を入力してください。例：1995,01,06
//		>>1995,01,06
//		寿命を何年後に設定しますか？
//		指定したい場合は0を入力してください。
//		>>0
//		命日を指定して下さい。例：2045,11,27
//		>>2095,01,06
//		生存可能日数：	36,525日
//		経過日数：		9,523日
//		のこり：		27,002日
//
//		必要な資産は
//		およそ 135,010,000円
//
//		残り:2,332,972,800秒
//		残り:38,882,880分
//		残り:648,048時間

//		あなたの1時間の価値?
//		いくら稼いできたか?