package moe.yak.yrl.release.InputSanitizer;

public class InputSanitizer {
	public static String[] sanitize(String[] strings) throws Exception {
		if(strings == null) {
			return null;
		}
		if(strings instanceof String[]) {
			String[] rets = new String[strings.length];
			for(int i = 0; i < strings.length; i++) {
				String ret = strings[i];
				ret.replace("&", "&amp;");
				ret.replace("<", "&lt;");
				ret.replace(">", "&gt;");
				ret.replace("\"", "&quot;");
				ret.replace("\'", "&#39;");
				ret.replace(" ", "&nbsp;");
				rets[i] = ret;
			}
			return rets;
		}else {
			throw new Exception ("String[] 以外を入れるな");
		}
	}

	public static String sanitize(Object attribute) throws Exception {
		if(attribute == null) {
			return null;
		}
		if(attribute instanceof String) {
			String ret = (String) attribute;
			ret.replace("&", "&amp;");
			ret.replace("<", "&lt;");
			ret.replace(">", "&gt;");
			ret.replace("\"", "&quot;");
			ret.replace("\'", "&#39;");
			ret.replace(" ", "&nbsp;");
			return ret;
		}else {
			throw new Exception ("String 以外を入れるな");
		}
		
	}
	
}
