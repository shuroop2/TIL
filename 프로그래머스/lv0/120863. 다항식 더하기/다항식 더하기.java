class Solution {
    public String solution(String polynomial) {
        if(polynomial.equals("x"))
            return "x";
        String answer = "";
        int[] cnt = new int[2];
        String[] tmp = polynomial.split(" ");
        for(int i=0; i<tmp.length; i+=2) {
            if(tmp[i].equals("x"))
                cnt[0]++;
            else if(tmp[i].contains("x"))
                cnt[0] += Integer.parseInt(tmp[i].substring(0, tmp[i].length() - 1));
            else
                cnt[1] += Integer.parseInt(tmp[i]);
        }
        
        if(cnt[0] == 0) {
            answer = String.valueOf(cnt[1]);
        } else if(cnt[1] == 0) {
            answer = cnt[0] + "x";
        } else {
            if(cnt[0] == 1)
                answer = "x + " + cnt[1];
            else
                answer = cnt[0] + "x + " + cnt[1];
        }
        return answer;
    }
}