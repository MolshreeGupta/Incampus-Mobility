package minor_git;

//CAMPUS TOUR

// BFS(int s) traverses vertices reachable from s.

import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class BFS_Search
{
	private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists
 
    BFS_Search(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }
 
    // prints BFS traversal from a given source s
    void BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];
 
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);
 
        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");
 
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
}
    public static void main(String args[])
    {
    	BFS_Search g = new BFS_Search(13000);
 
        g.addEdge(1, 2);     //gate to foodCourt
        g.addEdge(1,1401);   //gate to hubble
        g.addEdge(1, 1701);  //gate to enrollement office
        g.addEdge(1401,4001); //hubble to 4th
        g.addEdge(1401,2001); //hubble to 2nd
        g.addEdge(1701,1501); //Enrollement office to MAC
        g.addEdge(4001,5001); //4th to 5th
        g.addEdge(2001,3001); //2nd to 3rd
        g.addEdge(1501,1601); //MAC to container
        g.addEdge(3001,9001); //3rd to 9th
        g.addEdge(1601,1301); //container to library
        g.addEdge(9001,10001); //9th to 10th
        g.addEdge(1301,6001);  //library to 6th
        g.addEdge(1301,1201);  //library to IT
        g.addEdge(10001,11001); //10th to 11th
        g.addEdge(6001,7001); //6th to 7th
        g.addEdge(1201,8001); //IT to 8th
        
       
 
        System.out.println("Following is Breadth First Traversal \n"+"(starting from Gate)");
 
        g.BFS(1);
    }
}