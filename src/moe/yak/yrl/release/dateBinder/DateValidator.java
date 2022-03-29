package moe.yak.yrl.release.dateBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator {
	public static boolean validate(Date d,ValidationMode v) {
		Date refferDate;
		if(v.getReferenceDate()!=null) {
			refferDate = v.getReferenceDate();
		}else {
			System.out.println("[WARN] DateValidator : referenceDate is null or not yet set."
					+ "set to the currentDate");
			refferDate = new Date();
		}

		long time1 = 0;
		long time2 = 0;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			time1 = sdf.parse(sdf.format(d.getTime())).getTime();
			time2 = sdf.parse(sdf.format(refferDate.getTime())).getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if((time1 - time2) == 0) {
			//Today
			System.out.println("Today");
			if(v.isAllowToday()) {
				return true;
			}else {
				return false;
			}
		}

		long ret = (time1-time2) / (1000*60*60*24);
		long reta = Math.abs(ret);

		if(reta >= 0&&reta <1) {
			 SimpleDateFormat d1 = new SimpleDateFormat("yyyy/MM/dd");
			 if(d1.format(refferDate).equals(d1.format(d))) {
				 if(v.isAllowToday())return true;
				 else return false;
			 }

		}

		if(ret/reta>0) {
			//Future
			System.out.println("Future");
			if(v.isAllowedFuture()) {
				if(v.getAllowableFutureDays() == 0) {
					System.out.println("[WARN] DateValidator : allowable future days is zero or not yet set."
							+ "Check Remaining day was skipped");
					return true;
				}
				if(v.getAllowableFutureDays() >= ret) {
					return true;
				}
			}
		}else {
			//Past
			System.out.println("Past");
			if(v.isAllowedPast()) {
				if(v.getAllowablePastDays() == 0) {
					System.out.println("[WARN] DateValidator : allowable past days is zero or not yet set."
							+ "Check Remaining day was skipped");
					return true;
				}
				if(v.getAllowablePastDays() >= reta) {
					return true;
				}
			}
		}
		return false;
	}
}

