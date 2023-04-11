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
            List<String> list = new ArrayList<>();
            
            for(int i=0; i<n; i++)
                name[i] = br.readLine();
            
            for(int i=0; i<2*n-1; i++) {
                String[] tmp = br.readLine().split(" ");
                if(list.contains(tmp[0]))
                    list.remove(tmp[0]);
                else
                    list.add(tmp[0]);
            }
            sb.append(idx + " " + name[Integer.parseInt(list.get(0)) - 1] + "\n");
            
            idx++;
        }
        System.out.println(sb);

        br.close();
    }
}