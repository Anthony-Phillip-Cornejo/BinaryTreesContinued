public class BinaryTreeTester {
	
	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		int[] inputData = {16, 7, 496, 23, -48, -23, 147, 16, 0, 186, 957, -176};
		for (int elem : inputData) {
			tree.insert(elem);
		}
		
		System.out.println("In-Order Traversal");
		tree.inOrder();
		System.out.println("");
		System.out.println("");
		//Correct Answer is -176 -48 -23 0 7 16 16 23 147 186 496 957
		
		System.out.println("Pre-Order Traversal");
		tree.preOrder();
		System.out.println("");
		System.out.println("");
		//Correct Answer is 16 7 -48 -176 -23 0 16 496 23 147 186 957
		
		System.out.println("Post-Order Traversal");
		tree.postOrder();
		System.out.println("");
		System.out.println("");
		//Correct Answer is -176 0 -23 -48 16 7 186 147 23 957 496 16 
		
		System.out.println("Size: " + tree.size());
		//Correct Answer is 12
		
		System.out.println("Maximum Depth: " + tree.maxDepth());
		//Correct Answer is 5
		
		System.out.println("Minimum Depth: " + tree.minDepth());
		//Correct Answer is 3
		
		System.out.println("");
		
		System.out.println("Minimum Value: " + tree.minValue());
		//Correct Answer is -176
		System.out.println("Maximum Value: " + tree.maxValue());
		//Correct Answer is 957
		
		int key = 16;
		System.out.println("Matches of int " + key  + ": " + tree.countMatches(key));
		//Correct Answer is 2
		System.out.println("");
		
		tree.removeNode(957);
		
		System.out.println("In-Order Traversal Removed 957");
		tree.inOrder();
		System.out.println("");
		System.out.println("");
		//Correct Answer is -176 -48 -23 0 7 16 16 23 147 186 496
		
		System.out.println("Pre-Order Traversal Removed 957");
		tree.preOrder();
		System.out.println("");
		System.out.println("");
		//Correct Answer is 16 7 -48 -176 -23 0 16 496 23 147 186
		
		System.out.println("Post-Order Traversal Removed 957");
		tree.postOrder();
		System.out.println("");
		System.out.println("");
		//Correct Answer is -176 0 -23 -48 16 7 186 147 23 496 16 
		
		
	}

}
