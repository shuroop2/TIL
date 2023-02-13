class Solution {
    public String solution(String s, String skip, int index) {
        char[] arr = s.toCharArray();
        
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<index; j++) {
                do {
                    arr[i]++;
                    if(arr[i] > 'z')
                        arr[i] -= 26;
                } while(skip.contains(arr[i] + ""));
            }
        }
        
        return String.valueOf(arr);
    }
}