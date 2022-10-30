class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int tmpL = 10;
        int tmpR = 12;
        
        for(int i=0; i<numbers.length; i++) {
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += "L";
                tmpL = numbers[i];
            } else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += "R";
                tmpR = numbers[i];
            } else {
                if(numbers[i] == 0)
                    numbers[i] = 11;
                
                int gapL = (Math.abs(numbers[i] - tmpL) / 3) + (Math.abs(numbers[i] - tmpL) % 3);
                int gapR = (Math.abs(numbers[i] - tmpR) / 3) + (Math.abs(numbers[i] - tmpR) % 3);
                
                if(gapL > gapR) {
                    answer += "R";
                    tmpR = numbers[i];
                } else if (gapL < gapR) {
                    answer += "L";
                    tmpL = numbers[i];
                } else {
                    if(hand.equals("right")) {
                        answer += "R";
                        tmpR = numbers[i];
                    } else {
                        answer += "L";
                        tmpL = numbers[i];
                    }
                }
            }
        }
        return answer;
    }
}