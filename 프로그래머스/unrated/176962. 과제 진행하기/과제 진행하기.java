import java.util.*;
import java.util.stream.Stream;

class Solution {
    public String[] solution(String[][] plans) {
        List<String> list = new ArrayList<>();
        Arrays.sort(plans, (o1, o2) -> o1[1].compareTo(o2[1]));
        Stack<int[]> stack = new Stack<>();
        int i = 0, time = 0, period = 0, current = 0, next = 0;
        while(i != plans.length) {
            time = calc(plans[i][1]);
            period = calc(plans[i][2]);
            current = time + period;
            if(i + 1 < plans.length) {
                next = calc(plans[i + 1][1]);
                if(current > next) {
                    stack.push(new int[]{i, current - next});
                    current = next;
                    i++;
                    continue;
                }
            }
            list.add(plans[i][0]);
            
            while(!stack.isEmpty()) {
                int[] tmp = stack.pop();
                int remain = next - current;
                if(remain >= tmp[1]) {
                    list.add(plans[tmp[0]][0]);
                    current += tmp[1];
                } else {
                    stack.push(new int[]{tmp[0], tmp[1] - remain});
                    break;
                }
            }
            i++;
        }
        
        while(!stack.isEmpty()) {
            list.add(plans[stack.pop()[0]][0]);
        }
        
        return list.toArray(String[]::new);
    }
    
    public static int calc(String a) {
        if(a.contains(":")) {
            int[] tmp = Stream.of(a.split(":")).mapToInt(Integer::parseInt).toArray();
        
            return tmp[0] * 60 + tmp[1];
        } else {
            return Integer.parseInt(a);
        }
        
    }
}