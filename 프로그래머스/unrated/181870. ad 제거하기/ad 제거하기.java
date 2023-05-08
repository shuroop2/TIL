import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        List<String> strList = new ArrayList<>(Arrays.asList(strArr));
        List<String> list = new ArrayList<>();
        for(int i=0; i<strList.size(); i++)
            if(!strList.get(i).contains("ad"))
                list.add(strList.get(i));
        return list.toArray(new String[list.size()]);
    }
}