package moe.yak.yrl.release.dateBinder;

import java.util.Date;

/**
 * @apiNote 日付バリデータの設定クラス
 * @author yakishizimi
 *
 */
public class ValidationMode {
	private boolean af,ap,at;
	private int afd,apd;
	private Date referenceDate;
	
	/**
	 * 未来の日付を許容するか
	 * @param true 許容 false 拒絶
	 * 
	 */
	public ValidationMode setAllowFuture (boolean b) {
		this.af = b;
		return this;
	}
	/**
	 * 過去の日付を許容するか
	 * @param true 許容 false 拒絶
	 * 
	 */
	public ValidationMode setAllowPast (boolean b) {
		
		this.ap = b;
		return this;
	}
	/**
	 * 未来の日付の許容する日数
	 * @param 0もしくは未設定 :　無限 (int) 0>d（無効値） :　0
	 * 
	 */
	public ValidationMode setAllowFutureDays (int d) {
		if(d < 0) {
			this.afd=0;
			return this;
		}
		this.afd = d;
		return this;
	}
	/**
	 * 過去の日付の許容する日数
	 * @param 0もしくは未設定 :　無限 (int) 0>d（無効値） :　0
	 * 
	 */
	public ValidationMode setAllowPastDays (int d) {
		if(d < 0) {
			this.apd=0;
			return this;
		}
		this.apd = d;
		return this;
	}
	/**
	 * 基準日
	 * @param Date型　時刻を含めた検証もできるもののきれいに何日間みたいな検証なら一旦String化したあと再度時刻を含まないDateにしてしまったほうが安全
	 * 
	 */
	public ValidationMode setRefferenceDate (Date d) {
		this.referenceDate = d;
		return this;
	}
	/**
	 * 当日を許容するか
	 * @param true: 許容　false: 拒絶
	 * 
	 */
	public ValidationMode setAllowToday(boolean b) {
		this.at = b;
		return this;
		}
	/**
	 * 設定クラスのインスタンスを出す
	 */
	public static ValidationMode generate(){
		return new ValidationMode();
	}
	private ValidationMode() {}
	public boolean isAllowedFuture() {
		return af;
	}
	public boolean isAllowedPast() {
		return ap;
	}
	public int getAllowablePastDays() {
		return apd;
	}
	public int getAllowableFutureDays() {
		return afd;
	}
	public Date getReferenceDate() {
		return referenceDate;
	}
	public boolean isAllowToday() {
		return at;
	}
}