import java.util.ArrayList;

/**
 * This is a MorseCodeTree which is specifically used for the conversion of Morse code 
 * to English It relies on a root (reference to root of the tree) The root is set to null 
 * when the tree is empty. The class uses an external generic TreeNode class which consists 
 * of a reference to the data and a reference to the left and right child. The TreeNode is
 *  parameterized as a String, TreeNode This class uses a private member root (reference to a TreeNode) 
 *  The constructor will call the buildTree method
 * @author Betty Kouadio
 * 
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	
private TreeNode<String> root;
//private TreeNode root;
private String fetchletter;
/**
 * constructor that call buildTree method
 */
public MorseCodeTree() {
	//this.root= null;
	buildTree();	
}

/**
 * This is a recursive method that adds element to the correct position in the tree based on the code.
 *  A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right.
 *   The code ".-" would be stored as the right child of the left child of the root Algorithm for the recursive method:
1. if there is only one character
a. if the character is '.' (dot) store to the left of the current root
b. if the character is "-" (dash) store to the right of the current root
c. return
2. if there is more than one character
a. if the first character is "." (dot) new root becomes the left child
b. if the first character is "-" (dash) new root becomes the right child
c. new code becomes all the remaining charcters in the code (beyond the first character)
d. call addNode(new root, new code, letter)
 * @param <T>
 */
@Override
public void addNode(TreeNode<String> newRoot2, String newCode2, String letter) {
	
	
	TreeNode<String> newRoot = (TreeNode<String>) newRoot2;
    TreeNode<String> currentNode = (TreeNode<String>) newRoot2;
    String newCode = null;
    if(newCode2.toString().length()==1)
    {
        if(newCode2.toString().contains("."))
        {
            currentNode = new TreeNode<String>((String) letter);
            newRoot.setLeftChild(currentNode);
        }
        if(newCode2.toString().contains("-"))
        {
            currentNode = new TreeNode<String>((String) letter);
            newRoot.setRightChild(currentNode);
        }

        return;
    }
    else//there is more than one character in the morse code
    {
        if(newCode2.toString().charAt(0)=='.')
        {
            newRoot = currentNode.getLeftChild();
        }
        if(newCode2.toString().charAt(0)=='-')
        {
            newRoot = currentNode.getRightChild();
        }
        newCode = newCode2.toString().substring(1);
    }
    addNode((TreeNode<String>)newRoot, (String)newCode, letter);
	
}

	/**
	 * Returns a reference to the root
	 */
	@Override
	public TreeNode<String> getRoot() {
		// TODO Auto-generated method stub
		 return this.root;
	}

	@Override
	/**
	 * sets the root of the MorseCodeTree
	 */
	public void setRoot(TreeNode<String> newNode) {
		// TODO Auto-generated method stub
		//this.root=newNode;
		 TreeNode<String> temp = new TreeNode<>(newNode);
	        this.root = (TreeNode<String>) temp;
	}

	/**
	 * Adds element to the correct position in the tree based on the code 
	 * This method will call the recursive method addNode
	 */
	public LinkedConverterTreeInterface<String> insert (String code, String letter){
		// TODO Auto-generated method stub
		addNode( root,code,letter ); 
		return this;
	}

	
		
	/**
	 * Fetch the data in the tree based on the code This method will call the recursive method fetchNode
	 */
	@Override
	public String fetch(String code) {
		// TODO Auto-generated method stub
		return fetchNode(root, code);
	}
/**
 * This is the recursive method that fetches the data of the TreeNode that corresponds with
 *  the code A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right. 
 *  The code ".-" would fetch the data of the TreeNode stored as the right child of the left child of the root
 */
	//public String fetchNode(TreeNode<String> root, String code) 
	public String fetchNode(TreeNode<String> root, String code){
		
		
		
		TreeNode<String> newRoot = (TreeNode<String>) root;
	    @SuppressWarnings("unused")
		TreeNode<String> currentNode = (TreeNode<String>) root;
	    @SuppressWarnings("unused")
		String newcode = null;
	    if(code.toString().length()==1)
	    {
	        if(code.toString().contains("."))
	        {
	            
	            fetchletter = (String) newRoot.getLeftChild().getData();
	        }
	        if(code.toString().contains("-"))
	        {
	        	fetchletter = (String) root.getRightChild().getData();
	            
	        }

	    }
	    else//there is more than one character in the morse code
	    {
	        if(code.toString().charAt(0)=='.')
	        {
	        	 fetchNode(root.getLeftChild(),code.substring(1));
	        }
	        if(code.toString().charAt(0)=='-')
	        {
	        	fetchNode(root.getRightChild(),code.substring(1));
	        }
	        
	    }
		
	    return fetchletter;
	}

	@Override
	/**
	 * This operation is not supported in the MorseCodeTree
	 */
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This operation is not supported in the MorseCodeTree
	 */
	@Override
	public MorseCodeTree update() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code. 
	 * The root will have a value of "" (empty string) level one: insert(".", "e"); insert("-", "t"); level two: 
	 * insert("..", "i"); insert(".-", "a"); insert("-.", "n"); insert("--", "m"); etc. Look at the tree and 
	 * the table of codes to letters in the assignment description.
	 */
	@Override
	public void buildTree() {

		//build root node
        root = new TreeNode<>("");
        TreeNode<String> eNode = new TreeNode<String>("e");
        root.setLeftChild(eNode);
        TreeNode<String> tNode = new TreeNode<String>("t");
        root.setRightChild(tNode);
        TreeNode<String> iNode = new TreeNode<>("i");
        eNode.setLeftChild(iNode);
        TreeNode<String> aNode = new TreeNode<>("a");
        eNode.setRightChild(aNode);
        TreeNode<String> sNode = new TreeNode<>("s");
        iNode.setLeftChild(sNode);
        TreeNode<String> uNode = new TreeNode<>("u");
        iNode.setRightChild(uNode);
        TreeNode<String> hNode = new TreeNode<>("h");
        sNode.setLeftChild(hNode);
        TreeNode<String> vNode = new TreeNode<>("v");
        sNode.setRightChild(vNode);
        TreeNode<String> fNode = new TreeNode<>("f");
        uNode.setLeftChild(fNode);

        TreeNode<String> rNode = new TreeNode<>("r");
        aNode.setLeftChild(rNode);
        TreeNode<String> wNode = new TreeNode<>("w");
        aNode.setRightChild(wNode);
        TreeNode<String> lNode = new TreeNode<>("l");
        rNode.setLeftChild(lNode);
        TreeNode<String> pNode = new TreeNode<>("p");
        wNode.setLeftChild(pNode);
        TreeNode<String> jNode = new TreeNode<>("j");
        wNode.setRightChild(jNode);

        TreeNode<String> nNode = new TreeNode<>("n");
        tNode.setLeftChild(nNode);
        TreeNode<String> mNode = new TreeNode<>("m");
        tNode.setRightChild(mNode);
        TreeNode<String> dNode = new TreeNode<>("d");
        nNode.setLeftChild(dNode);
        TreeNode<String> kNode = new TreeNode<>("k");
        nNode.setRightChild(kNode);

        TreeNode<String> bNode = new TreeNode<>("b");
        dNode.setLeftChild(bNode);
        TreeNode<String> xNode = new TreeNode<>("x");
        dNode.setRightChild(xNode);
        TreeNode<String> cNode = new TreeNode<>("c");
        kNode.setLeftChild(cNode);
        TreeNode<String> yNode = new TreeNode<>("y");
        kNode.setRightChild(yNode);

        TreeNode<String> gNode = new TreeNode<>("g");
        mNode.setLeftChild(gNode);
        TreeNode<String> oNode = new TreeNode<>("o");
        mNode.setRightChild(oNode);
        TreeNode<String> zNode = new TreeNode<>("z");
        gNode.setLeftChild(zNode);
        TreeNode<String> qNode = new TreeNode<>("q");
        gNode.setRightChild(qNode);		
		
	}

	/**
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order Used for 
	 * testing to make sure tree is built correctly
	 */
	@Override
	public ArrayList<String> toArrayList() {
		// TODO Auto-generated method stub
		ArrayList<String> printTree= new ArrayList<String>();
			LNRoutputTraversal(root, printTree);
		
		return printTree;
	}

	/**
	 * The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder)
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		// TODO Auto-generated method stub
		if (root!=null)
		{
			//recusive method to traverse through the binary tree in LNR (Inorder)
			LNRoutputTraversal(root.getLeftChild(),list);
			list.add(root.getData()); 
			LNRoutputTraversal(root.getRightChild(),list);
		}
		
	}
	

}
