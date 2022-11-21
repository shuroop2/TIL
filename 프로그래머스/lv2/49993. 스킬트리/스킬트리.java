class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String s : skill_trees) {
            String tmp = s;
            
            for(int i=0; i<s.length(); i++) {
                String s2 = s.substring(i, i+1);
                if(!skill.contains(s2))
                    tmp = tmp.replace(s2, "");
            }

            if(skill.startsWith(tmp))
                answer++;
        }
        
        return answer;
    }
}