class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i:nums){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(freq.get(a),freq.get(b)));
        //minheap
        for(int i:freq.keySet()){
            pq.offer(i);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int [] res = new int[k];
        int index=0;
        while(!pq.isEmpty()){
            res[index++]=pq.poll();
        }
        return res;
    }
}