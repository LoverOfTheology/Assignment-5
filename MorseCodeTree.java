package application;

import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>{

	TreeNode<String> root = new TreeNode<String>("0");
	
	public MorseCodeTree() {
		buildTree();
	}
	
	public TreeNode<String> getRoot() {
		return root;
	}

	
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}
	
	public MorseCodeTree insert(String code, String letter) {
		if(root == null) {
			setRoot(new TreeNode<String>("0"));
		}
		addNode(root , code, letter);
		return null;
	}

	
	public void addNode(TreeNode<String> root, String code, String letter) {
		if(root == null) {
			setRoot(new TreeNode<>(""));
		}
		
		if(code.length() == 1) {
			if(code.equals(".")) {
				root.setLeftChild(new TreeNode<>(letter));
			}
			else
				root.setRightChild(new TreeNode<>(letter));
		}
		else{
			if(code.charAt(0) == '.') {
				addNode(root.getLeftChild(), code.substring(1), letter);
			}
			else
				addNode(root.getRightChild(), code.substring(1), letter);
		}
		
	}
	
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	
public String fetchNode(TreeNode<String> root, String code) {
		if(root == null) {
		 root = new TreeNode<String>("");
		 return root.data;
		}
		
		if(code.length() == 1) {
			if(code.equals(".")) {
				return root.getLeftChild().getData();
			}
			else
				return root.getRightChild().getData();
		}
		else{
			if(code.charAt(0) == '.') {
				return fetchNode(root.getLeftChild(), code.substring(1));
			}
			else
				return fetchNode(root.getRightChild(), code.substring(1));
		}
}
	

	
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		return null;
	}

	
	public MorseCodeTree update() throws UnsupportedOperationException {
		return null;
	}

	
	public void buildTree() {
		setRoot(new TreeNode<String>(""));
		insert(".", "e");insert("-", "t");
		insert("..", "i");insert(".-", "a");insert("-.", "n");insert("--", "m");	
		insert("...", "s");insert("..-", "u");insert(".-.", "r");insert(".--", "w");
		insert("-..", "d");insert("-.-", "k");insert("--.", "g");insert("---", "o");
		insert("....", "h");insert("...-", "v");insert("..-.", "f");insert(".-..", "l");
		insert(".--.", "p");insert(".---", "j");insert("-...", "b");insert("-..-", "x");
		insert("-.-.", "c");insert("-.--", "y");insert("--..", "z");insert("--.-", "q");
	}

	
	public ArrayList<String> toArrayList() {
		if(root == null) {
			return null;
		}
		ArrayList<String> morseCode = new ArrayList<>();
		
		LNRoutputTraversal(root,morseCode);
		
		return morseCode;
	}

	
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root != null) {
			LNRoutputTraversal(root.getLeftChild(),list);
			list.add(root.getData());
			LNRoutputTraversal(root.getRightChild(),list);
			
		}
	
		
	}

}
