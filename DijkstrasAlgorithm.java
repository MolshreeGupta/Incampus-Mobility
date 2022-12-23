package minor_git;

public class DijkstrasAlgorithm {

	 	private static final int NO_PARENT = -1; //no parent means the array stores -1 for that node
	    private static void dijkstra(int[][] adjacencyMatrix, int startVertex) 
	    {
	        int nVertices = adjacencyMatrix[0].length; //defining the number of vertices 
	        //System.out.println(nVertices);
	        int[] shortestDistances = new int[nVertices]; //array for storing shortest distances from nodes
	 
	        boolean[] added = new boolean[nVertices]; //array for storing whether the node has been processed or not
	 
	        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) //filling in the array initially
	        {
	            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
	            added[vertexIndex] = false;
	        }
	  
	        shortestDistances[startVertex] = 0; //distance of the source node is the least initially from itself i.e. 0
	         int[] parents = new int[nVertices]; //array for defining the parent of the current node, processed for adjacent edges
	 
	        // The starting vertex does not have a parent
	        parents[startVertex] = NO_PARENT;
	 
	       
	        for (int i = 0; i < nVertices; i++)
	        {
	            int nearestVertex = -1;
	            int shortestDistance = Integer.MAX_VALUE;
	            for (int vertexIndex =0; vertexIndex < nVertices; vertexIndex++)
	            {
	                if (!added[vertexIndex] && //not processed
	                    shortestDistances[vertexIndex] < shortestDistance)
	                {
	                    nearestVertex = vertexIndex;
	                    shortestDistance = shortestDistances[vertexIndex];
	                }
	            }
	 
	           
	            added[nearestVertex] = true; //processed node
	 
	            for (int vertexIndex = 0;
	                     vertexIndex < nVertices;
	                     vertexIndex++)
	            {
	                int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];
	                 
	                if (edgeDistance > 0
	                    && ((shortestDistance + edgeDistance) <
	                        shortestDistances[vertexIndex]))
	                {
	                    parents[vertexIndex] = nearestVertex;
	                    shortestDistances[vertexIndex] = shortestDistance +
	                                                       edgeDistance;
	                }
	            }
	        }
	 
	        printSolution(startVertex, shortestDistances, parents);
	    }
	
	    private static void printSolution(int startVertex,
	                                      int[] distances,
	                                      int[] parents)
	    {
	        int nVertices = distances.length;
	        System.out.print("Vertex\t\t Distance\tPath");
	         
	        for (int vertexIndex = 0;
	                 vertexIndex < nVertices;
	                 vertexIndex++)
	        {
	            if (vertexIndex != startVertex)
	            {
	                System.out.print("\n" + startVertex + " -> ");
	                System.out.print(vertexIndex + " \t\t ");
	                System.out.print(distances[vertexIndex] + "\t\t");
	                printPath(vertexIndex, parents);
	            }
	        }
	    }
	 
	    // Function to print shortest path from source to currentVertex
	    // using parents array
	    private static void printPath(int currentVertex,
	                                  int[] parents)
	    {
	        if (currentVertex == NO_PARENT)
	        {
	            return;
	        }
	        printPath(parents[currentVertex], parents);
	        System.out.print(currentVertex + " ");
	    }
	 
	    public static void main(String[] args)
	    {
	        int[][] adjacencyMatrix = { { 0, 1, 1, 0, 1,0},
	                                    { 1, 0, 0, 0, 0, 0 },
	                                    { 1, 0, 0, 1, 0, 0},
	                                    { 0, 0, 1, 0, 0, 0 },
	                                    { 1, 0, 0, 0, 0, 1},
	                                    { 0, 0, 0, 0, 1, 0}, };
	        dijkstra(adjacencyMatrix, 0);
	    }
	}

