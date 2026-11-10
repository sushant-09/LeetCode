class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String word:strs){
            char [] arr = word.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(word);
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            List<String> group = new ArrayList<>();
            for(String word:entry.getValue()){
                group.add(word);
            }
            res.add(group);
        }
        return res;
    }
}