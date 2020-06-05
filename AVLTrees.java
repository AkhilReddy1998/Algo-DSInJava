public class AVLTrees {
    private class AVLNode{
        int data;
        AVLNode leftChild;
        AVLNode rightChild;
        int height;
        AVLNode(int data){
            this.data = data;
        }
    }
    private AVLNode root;
	public void insert(int data){
        if(root == null){
            root = new AVLNode(data);
        }
        else{
            AVLNode temp = root;
            while(temp!=null){
                if(data > temp.data){
                    if(temp.rightChild == null){
                        temp.rightChild = new AVLNode(data);
                        break;
                    }
                    else temp = temp.rightChild;
                }
                else{
                    if(data < temp.data){
                        if(temp.leftChild == null){
                            temp.leftChild = new AVLNode(data);
                            break;
                        }
                        else temp = temp.leftChild;
                    }
                }
            }
        }
    }
    public void displayInorder(){
        displayInorder(root);
    }
    private void displayInorder(AVLNode root) {
        if(root == null) return;
        displayInorder(root.leftChild);
        System.out.println(root.data + " Height: "+root.height);
        displayInorder(root.rightChild);
    }
	public void insertWithRecursion(int data) {
        root = insertWithRecursion(root,data);
    }
    private AVLNode insertWithRecursion(AVLNode root, int data) {
        if(root == null)
            return new AVLNode(data);
        if(data > root.data)
            root.rightChild = insertWithRecursion(root.rightChild, data);
        else if(data < root.data)
            root.leftChild = insertWithRecursion(root.leftChild, data);
        
        root.height = Math.max(GetLeftHeight(root),GetRightHeight(root)) + 1;
        return root;
    }

    private int GetRightHeight(AVLNode root) {
        if(root.rightChild == null)
            return 0;
        else return root.rightChild.height;
    }

    private int GetLeftHeight(AVLNode root) {
        if(root.leftChild == null)
            return 0;
        else return root.leftChild.height;
    }

}