import java.util.ArrayList;

public class NonTouchingLoops {
	public ArrayList<ArrayList<ArrayList<Edge>>> nonTouchLoops = new ArrayList<ArrayList<ArrayList<Edge>>>();
	public int noOfLoops;
	boolean touch;
	
	public ArrayList<int[]> NonTouchingOfTwoLoops(ArrayList<ArrayList<Edge>> AllLoops){
		ArrayList<int[]> pairsNonTouch = new ArrayList<int[]>();
		for(int x = 0; x < AllLoops.size(); ++x) {
			for(int y = x + 1; y < AllLoops.size(); ++y) {
				if(AllLoops.get(x).get(0).destination == AllLoops.get(y).get(0).source) {
					continue;
				}else if(AllLoops.get(x).get(0).source == AllLoops.get(y).get(0).source) {
					continue;
				}
				int i = 0;
				for(int j = 0; j < AllLoops.get(x).size(); ++j) {
					if(i > 0) {
						break;
					}
					for(int k = 0; k < AllLoops.get(y).size(); ++k) {
						if(AllLoops.get(x).get(j).source == AllLoops.get(y).get(k).source) {
							++i;
							break;
						}
					}
				}
				if(i == 0) {
					int[] edge = new int[2];
					edge[0] = x;
					edge[1] = y;
					pairsNonTouch.add(edge);
				}	
			}
		}
		return pairsNonTouch;
	}

	public ArrayList<int[]> nNONTOUCH(ArrayList<int[]> pairsNonTouch,ArrayList<int[]> non,int n){
		ArrayList<int[]> lo = new ArrayList<int[]>();
		for(int i = 0; i < non.size(); ++i) {
				for(int j = i + 1; j < pairsNonTouch.size(); ++j){
				if(non.get(i)[n - 2] == pairsNonTouch.get(j)[0]) {
					int[] arr = new int[n];
					for(int u = 0; u < n - 1; ++u) {
						arr[u] = non.get(i)[u];
					}
					arr[n - 1] = pairsNonTouch.get(j)[1];
					if(!lo.contains(arr)) {
					lo.add(arr);
					}			 
				}	
			}		
		}
		return lo;	
	}
	
 	public ArrayList<ArrayList<int[]>> Final(ArrayList<int[]> twononTouching){
		 ArrayList<ArrayList<int[]>> aLLNonTouchLoops=new ArrayList<ArrayList<int[]>>();
	 	aLLNonTouchLoops.add(twononTouching);
	 	for(int t = 0; t >= 0; ++t) {
			 ArrayList<int[]> nonTouchMore = new ArrayList<int[]>();
		 	nonTouchMore = nNONTOUCH(twononTouching,aLLNonTouchLoops.get(t),t+3);
		 	if(nonTouchMore.isEmpty()) {
				 break;
		 	}
		 	aLLNonTouchLoops.add(nonTouchMore);
	 	}
	 	return aLLNonTouchLoops;
 	}
 
	 ArrayList<ArrayList<ArrayList<Edge>>> nonTouchingIntoNode( ArrayList<ArrayList<Edge>> allLoops){
		ArrayList<ArrayList<ArrayList<Edge>>> nonTouchingIntoNode = new ArrayList<ArrayList<ArrayList<Edge>>>();
	 	ArrayList<ArrayList<Edge>> Edge1 = new ArrayList<ArrayList<Edge>>();
	 	ArrayList<Edge> Edge = new ArrayList<Edge>();
	 	ArrayList<ArrayList<int[]>> ALL = new ArrayList<ArrayList<int[]>>();
	 	ArrayList<int[]> Two = new ArrayList<int[]>();
	 	Two=NonTouchingOfTwoLoops(allLoops);
	 	ALL = Final(Two);
	 	nonTouchingIntoNode = new ArrayList<ArrayList<ArrayList<Edge>>>();
     	for(ArrayList<int[]> gg: ALL) {
    	  	for(int[] j: gg) {
				  Edge1 = new ArrayList<ArrayList<Edge>>();
				  for(int edge: j){
    				 Edge = new ArrayList<Edge>();
    		  			for(int s = 0; s < allLoops.get(edge).size(); ++s) {
    					 	Edge.add(allLoops.get(edge).get(s));
    		 			}
    			 		Edge1.add(Edge);
				  }
				  nonTouchingIntoNode.add(Edge1);
			}
		 }
		 return nonTouchingIntoNode;
	}
}