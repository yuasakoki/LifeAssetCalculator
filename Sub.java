package test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

public class Sub {
	//現在の時間を取得
	static Calendar now = Calendar.getInstance();
	static SimpleDateFormat sdf2 =new SimpleDateFormat("yyyyMMdd");
	static String now2 = sdf2.format(now.getTime());
	public static final int NOWYEAR = Integer.parseInt(now2.substring(0,4));
	public static final int NOWMONTH = Integer.parseInt(now2.substring(5,6));
	public static final int NOWDAY = Integer.parseInt(now2.substring(7,8));
	//生存期間
	private int count = 0;
	//残りの日数
	private int count2 = 0;
	//生まれた年
	String barth = null;
	private int birthYear = 0;
	private int birthMonth = 0;
	private int birthDay = 0;
	//予定年
	String end2 = null;
	private int deadYear = 0;
	private int deadMonth = 0;
	private int deadDay = 0;
	//享年
	private long end = 0;
	//年齢
	private int age = 0;

	private long dayMoney = 5000;
	private long yearMoney = (dayMoney * 30) * 12;
	private long money2 = count2 * dayMoney;

	private long h = 0;
	private long m = 0;
	private long s = 0;

	private long yIncome = 0;

	private long shisan2 = 0;
	private int n = 0;

	private double nenri = 0;
	private double nenri2 = 0;
	private float geturi = 0;
	private double a1 = 0;
	private double a2 = 0;
	private int aa = 0;
	private int nokori = 0;
	
	String red    = "\u001b[00;31m";
	String green  = "\u001b[00;32m";
	String yellow = "\u001b[00;33m";
	String purple = "\u001b[00;34m";
	String pink   = "\u001b[00;35m";
	String cyan   = "\u001b[00;36m";
	String cEnd    = "\u001b[00m";



	public Sub() {
		boolean loop = true;
		while(loop) {
			try {
				System.out.println(cyan + "生年月日を入力してください。例：1995/01/06" + cEnd);
				System.out.print(">>");
				this.barth = new Scanner(System.in).nextLine();
				if(this.barth.length() != 10) {
					throw new ArithmeticException();
				}
				this.birthYear = Integer.parseInt(barth.substring(0, 4));
				this.birthMonth = Integer.parseInt(barth.substring(5,7));
				this.birthDay = Integer.parseInt(barth.substring(8,10));
				loop = false;
			}catch(Exception e) {
				System.out.println("\u001b[00;31m" + "エラー：もう一度 <例> を確認してください" + "\u001b[00m");
			}finally {
				
			}
		}
	}


	public void jyumyou() {
		System.out.println("");
		System.out.println("\u001b[00;36m" + "寿命を何歳に設定しますか？\n指定したい場合は0を入力してください。" + "\u001b[00m");
		System.out.print(">>");
		this.end = new Scanner(System.in).nextInt();
	}

	public void dead() {
		System.out.println("\u001b[00;36m" + "命日を指定して下さい。例：2045/11/27" + "\u001b[00m");
		System.out.print(">>");
		this.end2 = new Scanner(System.in).nextLine();
		this.deadYear = Integer.parseInt(end2.substring(0, 4));
		this.deadMonth = Integer.parseInt(end2.substring(5,7));
		this.deadDay = Integer.parseInt(end2.substring(8,10));
	}

	public void keisan1() {
		//生存可能日数 例 2075,01,06 - 1995,01,06
		Duration duration = Duration.between(
				LocalDate.of(birthYear, birthMonth, birthDay).atTime(0, 0, 0),
				LocalDate.of((int) deadYear, deadMonth, deadDay).atTime(0, 0, 0));
		this.count = ((int) duration.toDays());
		//残り日数 例 2075,01,06 - 現在
		Duration duration2 = Duration.between(
				LocalDate.of(NOWYEAR, NOWMONTH, NOWDAY).atTime(0, 0, 0),
				LocalDate.of((int) deadYear, deadMonth, deadDay).atTime(0, 0, 0));
		this.count2 = (int) duration2.toDays();
	}

	public void keisan2() {
		//生存可能日数 例 2075,01,06 - 1995,01,06
		Duration duration =
				Duration.between(
				LocalDate.of(birthYear, birthMonth, birthDay).atTime(0, 0, 0),
				LocalDate.of((int) (birthYear + end), birthMonth, birthDay).atTime(0, 0, 0));
		this.count = ((int) duration.toDays());
		//残り日数 例 2075,01,06 - 現在
		Duration duration2 =
				Duration.between(LocalDate.of(NOWYEAR, NOWMONTH, NOWDAY).atTime(0, 0, 0),
				LocalDate.of((int) (birthYear + end), birthMonth, birthDay).atTime(0, 0, 0));
		this.count2 = ((int) duration2.toDays());
	}

	public int age() {
		Calendar now = Calendar.getInstance();
		Calendar birth = Calendar.getInstance();
		birth.set(birthYear, birthMonth - 1, birthDay);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return this.age =((Integer.parseInt(sdf.format(now.getTime()))) -
				(Integer.parseInt(sdf.format(birth.getTime())))) / 10000;
	}


	public long  shisan() {
		this.dayMoney = 5000;
		this.yearMoney = (dayMoney * 30) * 12;
		this.money2 = count2 * dayMoney;
		return this.money2;
	}

	//残り00年で0000000円必要なので 月々0000000円貯金してください
	public void teinen() {
		for(int teinen = 60; teinen < this.end ; teinen += 5) {

			long shisan = (this.end - teinen) * this.yearMoney;
			int n = (teinen - this.age);
			System.out.println(teinen + "歳で定年退職する場合は,のこり " + n + "年");
//			System.out.println(teinen + "歳で定年退職する場合は");
			System.out.println(teinen + "歳から命日までおよそ " +
						String.format("%,d", shisan ) + "円 以上が必要");
			System.out.println("今月から月々 " +
						String.format("%,d", (shisan / n)/12 ) + "円を貯金してください。");
			System.out.println("-----------------------------------------------------------");
			if(teinen == 90) {
				break;
			}
		}
	}

	public void teinen2(int mIncome) {
		yIncome = mIncome * 12;
		money2 = this.count2 * (mIncome/30);

		System.out.println("--------------------------------------------------------");
		System.out.println("月収が" + String.format("%,d",mIncome) + "円の場合");
		System.out.println("現在からなくなるまでに必要な資産は");
		System.out.println("およそ " + String.format("%,d", money2) + "円 以上です。");
		System.out.println("この金額以上を手に入れると今すぐリタイヤできます。");
		System.out.println("---------------------------------------------------------------");

		for(int teinen = 60; teinen < this.end ; teinen += 5) {
			shisan2 = (this.end - teinen) * yIncome;
			n = (teinen - this.age);

			System.out.println(teinen + "歳で定年退職する場合は,のこり " + n + "年");
			System.out.println(teinen + "歳から命日までおよそ " +
						String.format("%,d", shisan2 ) + "円 以上が必要なので、");
			System.out.println("月々 " +
						String.format("%,d", (shisan2 / n)/12 ) + "円を貯金してください。");
			System.out.println("-----------------------------------------------------------");
			if(teinen == 90) {
				break;
			}
		}

	}

	public void shisanKeisei(int select3, long shisan2, int n3, int n2) {
		switch(select3) {
		case 1 :
			nenri = 3;
			break;
		case 2 :
			nenri = 4;
			break;
		case 3 :
			nenri = 5;
			break;
		case 4 :
			nenri = 6;
			break;
		default :
			nenri = select3;
			break;
		}
		nenri2 = (nenri / 100) + 1;
		geturi = (float) (Math.pow(nenri2,0.083333));
		a1 = (shisan2) * (geturi - 1);
		a2 = (Math.pow(geturi,n3)) - 1;
		aa = (int) (a1 / a2);
		nokori = n2;

		System.out.println("------------------------------------------------------");
		System.out.println("年利が " + nenri +"%");
		System.out.println("で投資をする場合で");
		System.out.println( String.format("%,d", shisan2 ) + "円を用意するためには" );
		System.out.println("残り" + n2 + "年間  毎月おおよそ" + String.format("%,d", aa) + "円を資産運用に回すと達成できます" );
		System.out.println("----------------------------------------------------------");

	}

	public void ikkatu() {
		System.out.println("一括投資");
		System.out.println("現在の貯金額を入力してください");
		System.out.print(">>");
		int ikkatu = new Scanner(System.in).nextInt();
		double ikkatu1 = (Math.pow(nenri2,nokori));
		int ikkatu2 = (int)(ikkatu1 * ikkatu);
		System.out.println("年利が" + nenri + "%で、残り" + nokori + "年間寝かせると\n" + String.format("%,d", ikkatu2) +"円になります");

	}

	public long jikyu() {
		long jikyu = this.money2 / (this.h / 4);
		return jikyu;
	}



	public long hour() {
		this.h = this.count2 * 24;
		return this.h;
	}
	public long minutes() {
		this.m = this.h * 60;
		return this.m;
	}
	public long seconds() {
		this.s = this.m * 60;
		return this.s;
	}

	public long getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}

	public long getCount2() {
		return count2;
	}
	public void setCount2(int count2) {
		this.count2 = count2;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public long getYearMoney() {
		return yearMoney;
	}

	public void setYearMoney(long yearMoney) {
		this.yearMoney = yearMoney;
	}
}

//	\u001b[00;31m + "hhhhh" + \u001b[00m
//public class Color{
//public static void main(String[] args){
//  String red    = "\u001b[00;31m";
//  String green  = "\u001b[00;32m";
//  String yellow = "\u001b[00;33m";
//  String purple = "\u001b[00;34m";
//  String pink   = "\u001b[00;35m";
//  String cyan   = "\u001b[00;36m";
//  String end    = "\u001b[00m";
//
//  String[] names = new String[]{red,green,yellow,purple,pink,cyan};
//  for(int i=0; i< names.length; i++){
//  System.out.println(names[i]+"hello"+end);
//  }
//}
//}




//}
//

