/*
Assumptions made:
- We have a priority heap (min heap based on weight inputted) that has the following functions:
	- heap has elements that are (Node, weight) do they have to be Nodes vs ints?
	- insert right now inserts a Node and weight
	- has a function called isEmpty which returns a bool if the heap is empty 
	- has a function called deleteMin() that takes nothing and returns the minimum element in the heap (should be of the same type as v or we will have another step that gets the v type from the deleted min)
- I'd like to be able to take a dimension0 object and grab its graph from it but I don't have that right now
- v and w are Node "pointers" aka are Nodes themselves, could they just be ints?
- right now set is an ArrayList of nodes but I think we can just make it an arraylist of integers because we just need it to access singular nodes (not what they point to in the graph) and to check if a vertex is in the set

prims should take in a dimension0 object?
*/



public prims(LinkedList[] g) {
	double[] dist = new double[numpoints];
	int[] prev = new int[numpoints];
	int set_size = 0;
	Node v = new Node();
	Node w = new Node();
	int[] set = new int[numpoints];
	MinHeap min = new MinHeap(numpoints);
	
	min.insert(g[0].get[0]);

	for (int i = 0; i < numpoints; i++) {
		dist[i] = MAX_INT;
		prev[i] = null;
	}

	dist[0] = 0;

	while (min.size > 0) {
		v = min.remove();
		set[set_size] = v.vertexName;
		set_size++;
		for (int i = 0; i < numpoints; i++) {
			w = g[v.vertexName].get(i); 
			if (set.indexOf(w.vertexName) == -1) {
				if (dist[w.vertexName] > w.weight) {
					dist[w.vertexName] = w.weight;
					prev[w.vertexName] = v.vertexName;
					
					min.insert(w);
				}
			}
		}

	}

	//now find the last vertex added to the set and follow its prev pointers to the start, adding up the distances from the dist array to get the weight of the MST?
}