import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");
        
        for(int i=0; i<musicinfos.length; i++) {
            String[] tmp = musicinfos[i].split(",");
            int time = (Integer.parseInt(tmp[1].substring(0, 2)) - Integer.parseInt(tmp[0].substring(0, 2))) * 60 + Integer.parseInt(tmp[1].substring(3, 5)) - Integer.parseInt(tmp[0].substring(3, 5));
            tmp[3] = tmp[3].replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");
            
            if(tmp[3].length() < time)
                tmp[3] = tmp[3].repeat(time / tmp[3].length()) + tmp[3].substring(0, time % tmp[3].length());
            else
                tmp[3] = tmp[3].substring(0, time);
            
            if(tmp[3].contains(m)) {
                list.add(time);
                name.add(tmp[2]);
            }
        }
        
        while(list.size() > 1) {
            if(list.get(0) < list.get(1)) {
                list.remove(0);
                name.remove(0);
            } else {
                list.remove(1);
                name.remove(1);
            }
        }
        
        return name.isEmpty() ? "(None)" : name.get(0);
    }
}