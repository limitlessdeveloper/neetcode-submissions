class Solution {
    public boolean validTree(int n, int[][] edges) {
        // return n==edges.length+1;
        ArrayList<Integer> adj[] = new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }
        HashSet<Integer> visited = new HashSet<>();
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj[u].add(v);
            adj[v].add(u);
        }
        boolean isTree = dfs(visited, adj, 0);
        if(isTree){
            return visited.size()==n;
        } 
        else{
            return false;
        }
    }

    public boolean dfs(HashSet<Integer> visited, ArrayList<Integer> adj[], int vertices){
        visited.add(vertices);
        System.out.println(vertices);
        int totalParent = 0;
        for(int nextEle: adj[vertices]){
            if(visited.contains(nextEle)){
                totalParent++;
            }
            if(totalParent>1){
                return false;
            }
            else if(!visited.contains(nextEle)){ 
                boolean result = dfs(visited, adj, nextEle);
                if(!result){
                    return false;
                }
            }
        }
        return true;
    }
}