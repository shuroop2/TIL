import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0)
                break;

            String[] name = new String[n];
            List<int[]> list = new ArrayList<>();
            for(int i=0; i<n; i++) {
                String[] tmp = br.readLine().split(" ");
                name[i] = tmp[0];

                for(int j=1; j<tmp.length; j++)
                    if(tmp[j].equals("N"))
                        list.add(new int[]{i, i - j < 0 ? n + i - j : i - j});
            }
            
            sb.append("Group " + idx + "\n");
            if(list.size() > 0)
                for(int[] tmp : list)
                    sb.append(name[tmp[1]] + " was nasty about " + name[tmp[0]] + "\n");
            else
                sb.append("Nobody was nasty\n");
            
            sb.append("\n");
            idx++;
        }
        System.out.println(sb);

        br.close();
    }
}