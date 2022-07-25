
public class TreeNode<T> {
	@SuppressWarnings("rawtypes")
	private TreeNode leftChild;
	@SuppressWarnings("rawtypes")
	private TreeNode  rightChild;
	private  T dataNode;
	
	
	@SuppressWarnings("unchecked")
	public TreeNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	@SuppressWarnings("unchecked")
	public TreeNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild; 
	}

	/**
	 *  Create a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param dataNode
	 */
	public TreeNode (T dataNode) {
		this.dataNode=dataNode;
		this.leftChild=null;
		this.rightChild= null;	
	}
	
	/**
	 * copy constructor.
	 * @param node
	 */
	
	public TreeNode(TreeNode<T> node) {
		
		
		super();
		this.leftChild = node.leftChild;
		this.rightChild = node.rightChild;
		this.dataNode = node.dataNode;
		//new TreeNode<T>(node);
			
	}
	
	/**
	 * 
	 * @return the data within this TreeNode

	 */
	//Return 
	public T getData() {
		return dataNode;
		
	}
	
}
