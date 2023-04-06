import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solv(br.readLine()));
        br.close();
    }
    
    public static int[] month(int year) {
		int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
			month[1] = 29;
		return month;
	}

    public static double solv(String now) {
        String[] monthEn = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        double wholeMin = 0, nowMin = 0;
        String[] tmp = now.split(" ");
        int month = Arrays.asList(monthEn).indexOf(tmp[0]);
        int day = Integer.parseInt(tmp[1].replace(",", ""));
        int year = Integer.parseInt(tmp[2]);
        int hour = Integer.parseInt(tmp[3].split(":")[0]);
        int min = Integer.parseInt(tmp[3].split(":")[1]);

        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            wholeMin = 366 * 24 * 60;
        else
            wholeMin = 365 * 24 * 60;
        
        for(int i=0; i<month; i++) {
            int[] monthDay = month(year);
            nowMin += monthDay[i] * 24 * 60;
        }

        nowMin += (day - 1) * 24 * 60;
        nowMin += hour * 60;
        nowMin += min;

        return nowMin * 100 / wholeMin ;
    }
}