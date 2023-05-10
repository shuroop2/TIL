class Solution {
    public int solution(String binomial) {
        String[] tmp = binomial.split(" ");
        switch(tmp[1]) {
            case "+" : return Integer.parseInt(tmp[0]) + Integer.parseInt(tmp[2]);
            case "-" : return Integer.parseInt(tmp[0]) - Integer.parseInt(tmp[2]);
            case "*" : return Integer.parseInt(tmp[0]) * Integer.parseInt(tmp[2]);
        }
        return 0;
    }
}