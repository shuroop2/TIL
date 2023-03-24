class Solution {
    static char[][] map;
    static int[] answer = new int[2];
    public int[] solution(String[] park, String[] routes) {
        map = new char[park.length][];
        int[] start = new int[2];
        for(int i=0; i<park.length; i++) {
            map[i] = park[i].toCharArray();
            if(park[i].contains("S")) {
                answer[0] = i;
                answer[1] = park[i].indexOf("S");
            }
        }
        
        for(int i=0; i<routes.length; i++) {
            move(routes[i].split(" ")[0], routes[i].split(" ")[1]);
            System.out.println(answer[0] + " " + answer[1]);
        }
        
        return answer;
    }
    
    public static void move(String op, String n) {
        int tmp = Integer.parseInt(n);
        switch(op) {
            case "N" :
                if(answer[0] - tmp >= 0 && answer[0] - tmp < map.length) {
                    boolean flag = true;
                    for(int i=1; i<=tmp; i++) {
                        if(map[answer[0] - i][answer[1]] == 'X') {
                            flag = false;
                            break;
                        }
                    }
                    if(flag)
                        answer[0] -= tmp;
                }
                break;
            case "S" :
                if(answer[0] + tmp >= 0 && answer[0] + tmp < map.length) {
                    boolean flag = true;
                    for(int i=1; i<=tmp; i++) {
                        if(map[answer[0] + i][answer[1]] == 'X') {
                            flag = false;
                            break;
                        }
                    }
                    if(flag)
                        answer[0] += tmp;
                }
                break;
            case "W" :
                if(answer[1] - tmp >= 0 && answer[1] - tmp < map[0].length) {
                    boolean flag = true;
                    for(int i=1; i<=tmp; i++) {
                        if(map[answer[0]][answer[1] - i] == 'X') {
                            flag = false;
                            break;
                        }
                    }
                    if(flag)
                        answer[1] -= tmp;
                }
                break;
            case "E" :
                if(answer[1] + tmp >= 0 && answer[1] + tmp < map[0].length) {
                    boolean flag = true;
                    for(int i=1; i<=tmp; i++) {
                        if(map[answer[0]][answer[1] + i] == 'X') {
                            flag = false;
                            break;
                        }
                    }
                    if(flag)
                        answer[1] += tmp;
                }
                break;
        }
    }
}