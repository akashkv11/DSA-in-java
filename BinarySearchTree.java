class BinarySearchTree {
    Node root;

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(1);
        tree.insert(3);
        tree.insert(100);
        tree.remove(1);
        System.out.println(tree.contains(1));

    }

    public void insert(int data) {
        Node currentNode = root;
        Node newNode = new Node(data);

        if (currentNode == null) {
            root = newNode;
            return;

        }

        while (true) {
            if (data == currentNode.data) {
                System.out.println("Node already exist");
                return;
            }
            if (data < currentNode.data) {
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    break;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    break;
                } else {
                    currentNode = newNode;

                }
            }
        }

    }

    public void inOrder() {
        inOrderHelper(root);
    }

    private void inOrderHelper(Node node) {
        if (node != null) {
            inOrderHelper(node.left);
            System.out.println(node.data);
            inOrderHelper(node.right);
        }
    }

    public void preOrder() {
        preOrderHelper(root);
    }

    private void preOrderHelper(Node node) {
        if (node != null) {
            System.out.println(node.data);
            preOrderHelper(node.left);
            preOrderHelper(node.right);
        }
    }

    public void postOrder() {
        postOrderHelper(root);
    }

    private void postOrderHelper(Node node) {
        if (node != null) {
            postOrderHelper(node.left);
            postOrderHelper(node.right);
            System.out.println(node.data);
        }
    }

    public boolean contains(int data) {
        Node currentNode = root;

        while (currentNode != null) {
            if (data < currentNode.data) {
                currentNode = currentNode.left;

            } else if (data > currentNode.data) {
                currentNode = currentNode.right;
            } else {
                return true;
            }
        }

        return false;
    }

    public void remove(int data) {
        Node currentNode = root;
        if (currentNode == null) {
            System.out.println("Tree is empty");
            return;
        }
        removeHelper(data, currentNode, null);

    }

    private void removeHelper(int data, Node currentNode, Node parentNode) {
        while (currentNode != null) {
            if (data < currentNode.data) {

                parentNode = currentNode;
                currentNode = currentNode.left;

            } else if (data > currentNode.data) {
                parentNode = currentNode;
                currentNode = currentNode.right;

            } else {
                if (currentNode.left != null && currentNode.right != null) {
                    currentNode.data = getMinValue(currentNode.right);
                    removeHelper(currentNode.data, currentNode.right, currentNode);
                } else {
                    if (parentNode == null) {
                        if (currentNode.right == null) {
                            root = currentNode.left;
                        } else {
                            root = currentNode.right;
                        }
                    } else {
                        if (parentNode.left == currentNode) {
                            if (currentNode.right == null) {
                                parentNode.left = currentNode.left;
                            } else {
                                parentNode.left = currentNode.right;
                            }
                        } else {
                            if (currentNode.right == null) {
                                parentNode.right = currentNode.left;
                            } else {
                                parentNode.right = currentNode.right;
                            }
                        }
                    }
                }
                break;
            }
        }
    }

    private int getMinValue(Node currentNode) {
        if (currentNode.left == null) {
            return currentNode.data;
        } else {
            return getMinValue(currentNode.left);
        }
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
        }
    }

}
