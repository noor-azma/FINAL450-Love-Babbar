QUESTION LINK - https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
VIDEO LINK - https://www.youtube.com/watch?v=wTloJwckQTU&t=644s

========================================================ANSWER=====================================================================================
  
 
class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();
        
        q.add(new Pair(0 , root));
        
        while(!q.isEmpty()){
            
            Pair curr = q.poll(); 
            
            if(!map.containsKey(curr.hd)){
                map.put(curr.hd, curr.node.data);
            }
            
            if(curr.node.left != null) q.add(new Pair(curr.hd-1, curr.node.left));
            if(curr.node.right != null) q.add(new Pair(curr.hd+1, curr.node.right));
         
        }
      
         ArrayList<Integer> ans = new ArrayList<>();
        for(int key: map.keySet()){
            ans.add( map.get(key) );
        }
        
        return ans;   
    }
    
    static class Pair{
        
        int hd;
        Node node;
        
        public Pair(int hd, Node node){
            
            this.hd = hd;
            this.node = node;
        }
    }
}
