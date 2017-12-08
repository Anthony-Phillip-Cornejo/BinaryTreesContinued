public class BinaryTree {
	
	public Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	public void insert(int newRecord) {
		root = subtreeInsert(root, newRecord);
	}
	
	private Node subtreeInsert(Node topNode, int newRecord) {
		if (topNode == null) {
			topNode = new Node(newRecord);
		} else if (newRecord > topNode.record) {
			topNode.left = subtreeInsert(topNode.left, newRecord);
		} else {
			topNode.right = subtreeInsert(topNode.right, newRecord);
		}
		return topNode;
	}
	
	public void inOrder() {
		inOrderSubtree(root);
	}
	
	private void inOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			inOrderSubtree(topNode.right);
			System.out.print(topNode.record + " ");
			inOrderSubtree(topNode.left);
		}
	}
	
	public void preOrder() {
		preOrderSubtree(root);
	}
	
	private void preOrderSubtree(Node topNode) {
		if(topNode == null) {
			return;
		} else {
			System.out.print(topNode.record + " ");
			preOrderSubtree(topNode.right);
			preOrderSubtree(topNode.left);
		}
	}
	
	public void postOrder() {
		postOrderSubtree(root);
	}
	
	private void postOrderSubtree(Node topNode) {
		if(topNode == null) {
			return;
		} else {
			postOrderSubtree(topNode.right);
			postOrderSubtree(topNode.left);
			System.out.print(topNode.record + " ");
		}
	}
	
	public int size() {
		return subtreeSize(root);
	}
	
	private int subtreeSize(Node topNode) {
		int answer;
	    if (topNode == null) {
	        return 0;
	    } else {
	        answer = (subtreeSize(topNode.left) + subtreeSize(topNode.right));
	        answer++;
	        return answer;
	    }
	}
	
	public int maxDepth() {
		return subtreeMaxDepth(root);
	}
	
	private int subtreeMaxDepth(Node topNode) {
		if(topNode == null) {
			return 0;
		} else {
			int leftDepth = subtreeMaxDepth(topNode.left) + 1;
			int rightDepth = subtreeMaxDepth(topNode.right) + 1;
		
			if(leftDepth > rightDepth) {
				return leftDepth;
			} else {
				return rightDepth;
			}
		}
	}
	
	public int minDepth() {
		return subtreeMinDepth(root);
	}
	
	private int subtreeMinDepth(Node topNode) {
		if(topNode == null) {
			return 0;
		} else {
			if(topNode.left == null && topNode.right == null) {
				return 1;
			}
			if(topNode.left == null) {
				return subtreeMinDepth(topNode.right) + 1;
			}
			if(topNode.right == null) {
				return subtreeMinDepth(topNode.left) + 1;
			}
			return Math.min(subtreeMinDepth(topNode.left), subtreeMinDepth(topNode.right)) + 1;
		}
	}
	
	
	public int countMatches(int key) {
	    int count;
	    count = subtreeCountMatches(root, key);
	    return count - 3;
	}

	private int subtreeCountMatches(Node topNode, int key) {
		boolean countAdded = false;
		if(topNode == null) {
			return 0;
		} else {
			int count = 1;
			if (topNode.left != null) {
				if(topNode.record == key && !countAdded) {
					count++;
					countAdded = true;
				}
				subtreeCountMatches(topNode.left, key);
			}
			if (topNode.right != null) {
				if(topNode.record == key && !countAdded) {
					count++;
					countAdded = true;
				}
	    	count = count + subtreeCountMatches(topNode.right, key);
			}
			return count; 
	    }
	}
	
	
	public int minValue() {
		return minimalValue(root);
	}
	
	private int minimalValue(Node topNode) {
        int minv = topNode.record;
        while (topNode.right != null) {
            minv = topNode.right.record;
            topNode = topNode.right;
        }
        return minv;
	}
	
	public int maxValue() {
		return maximumValue(root);
	}
	
    private int maximumValue(Node topNode) {
        if (topNode == null) {
            return 0;
        }
        int caseInt = topNode.record;
        int leftMax = maximumValue(topNode.left);
        int rightMax = maximumValue(topNode.right);
        if (leftMax > rightMax) {
        	caseInt = leftMax;
        }
        if (rightMax > caseInt)
        	caseInt = rightMax;
        return caseInt;
    }
	public void removeNode(int key) {
		root = subtreeRemoveNode(root, key);
	}
    
	private Node subtreeRemoveNode(Node topNode, int key) {
		if(topNode == null) {
			return topNode;
		} else {
			if(key < topNode.record) {
				topNode.right = subtreeRemoveNode(topNode.right, key);
			}
			if(key > topNode.record) {
				topNode.left = subtreeRemoveNode(topNode.left, key);
			}
			if(key == topNode.record) {
				if(topNode.left == null && topNode.right == null) {
					return null;
				}
				if(topNode.left == null && topNode.right != null) {
					return topNode.right;
				}
				if(topNode.right == null && topNode.left != null) {
					return topNode.left;
				}
				if(topNode.right != null && topNode.left != null) {
					int storage = Math.min(topNode.right.record, topNode.left.record);
					if(topNode.right.record > topNode.left.record) {
						topNode.left = subtreeRemoveNode(topNode.left, topNode.record);
					}
					if(topNode.right.record < topNode.left.record) {
						topNode.right = subtreeRemoveNode(topNode.right, topNode.record);
					}
				}
			}
		}
		return topNode;
	}
}
