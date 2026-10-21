/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Queue<Node> q = new ArrayDeque<>();
        HashMap<Node,Node> copiedMap = new HashMap<>();
        q.offer(node);
        copiedMap.put(node,new Node(node.val));
        while (!q.isEmpty()){
            Node current = q.poll();
            for(Node neighbor:current.neighbors){
                if(!copiedMap.containsKey(neighbor)){
                    Node copied = new Node(neighbor.val);
                    copiedMap.put(neighbor,copied);
                    q.offer(neighbor);
                }
                copiedMap.get(current).neighbors.add(copiedMap.get(neighbor));
            }
        }
        return copiedMap.get(node);
    }
}