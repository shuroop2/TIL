import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> list = new ArrayList<>();
        HashMap<String, Integer> genreMap = new HashMap<>();
        HashMap<Integer, Integer> playMap = new HashMap<>();
        
        for(int i=0; i<genres.length; i++)
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        
        List<String> genreKeySet = new ArrayList<>(genreMap.keySet());
        genreKeySet.sort((o1, o2) -> genreMap.get(o2).compareTo(genreMap.get(o1)));
        
        for(String genreKey : genreKeySet) {
            playMap.clear();
            
            for(int i=0; i<genres.length; i++)
                if(genreKey.equals(genres[i]))
                    playMap.put(i, plays[i]);
            
            List<Integer> playKeySet = new ArrayList<>(playMap.keySet());
            playKeySet.sort((o1, o2) -> playMap.get(o2).compareTo(playMap.get(o1)));
            
            int cnt = 0;
            for(Integer playKey : playKeySet) {
                list.add(playKey);
                cnt++;
                if(cnt == 2)
                    break;
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        
        return answer;
    }
}