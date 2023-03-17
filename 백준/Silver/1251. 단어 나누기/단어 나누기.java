import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String[] arr = new String[3];
        List<String> list = new ArrayList<>();

        for(int i=1; i<word.length()-1; i++) {
            for(int j=i+1; j<word.length(); j++) {
                arr[0] = word.substring(0, i);
                arr[1] = word.substring(i, j);
                arr[2] = word.substring(j);

                StringBuffer sb = new StringBuffer();

                for(int k=0; k<3; k++)
                    for(int l=arr[k].length()-1; l>=0; l--)
                        sb.append(arr[k].substring(l, l+1));
                    
                list.add(sb.toString());
            }
        }
        Collections.sort(list);

        System.out.println(list.get(0));

        br.close();
    }
}