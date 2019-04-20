import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalTime;

public class LocalTimeDifferenceTest{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        String s = br.readLine().trim();
        String string="";
        int q = Integer.parseInt(br.readLine().trim());
        while (q-- > 0) {
        	string += br.readLine().trim();
        	if (q != 0) {
        		string = string + ":";
        	}
        }
        wr.println(solve(s, string));
        wr.close();
        br.close();

	}
	
	static String solve(String s, String temp) {
		LocalTime l1 = LocalTime.parse(s);
		LocalTime l2 = LocalTime.parse(temp);
		int hourDiff = l1.minusHours(l2.getHour()).getHour();
		int minDiff = l1.minusMinutes(l2.getMinute()).getMinute();
		int secDiff = l1.minusSeconds(l2.getSecond()).getSecond();
		
		if (hourDiff > 0) {
			if (hourDiff == 1) {
				return hourDiff + " hour ago";
			} else {
				return hourDiff + " hours ago";
			}
		} else if (minDiff > 0) {
			if (minDiff == 1) {
				return minDiff + " minute ago";
			} else {
				return minDiff + " minutes ago";
			}
		} else if (secDiff > 0) {
			if (secDiff == 1) {
				return secDiff + " second ago";
			} else {
				return secDiff + " seconds ago";
			}
		} else {
			return "now";
		}
    }

}
