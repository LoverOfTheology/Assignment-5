package application;

public class TreeNode<T> {
	public String data;
	public TreeNode<T> leftChild;
	public TreeNode<T> rightChild;
		
	
	
	public TreeNode(String dataNode) {
		this.data = dataNode;
		leftChild = rightChild = null;
		
	}
	
	public TreeNode(TreeNode<T> node) {
		
	}
	
	public TreeNode() {
	}

	public void setData(String dataset) {
		data = dataset;
	}
	
	public String getData() {
		return data;
	}
	
	public boolean hasLeftChild() {
		return leftChild != null;
	}
	
	public boolean hasRightChild() {
		return rightChild != null;
	}
	
	public TreeNode<T> getLeftChild(){
		return leftChild;
	}
	
	public TreeNode<T> getRightChild(){
		return rightChild;
	}
	
	public void setLeftChild(TreeNode<T> leftChild){
		this.leftChild = leftChild;
	}
	
	public void setRightChild(TreeNode<T> rightChild){
		this.rightChild = rightChild;
	}
}
