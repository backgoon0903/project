/*레드-블랙 트리는 자가 균형을 맞추는 이진 검색 트리의 한 종류로, 각 노드가 레드 혹은 블랙의 색상을 가집니다.

각 노드는 레드 혹은 블랙입니다.
루트 노드는 블랙입니다.
        모든 리프(NIL) 노드는 블랙입니다.
레드 노드의 자식 노드들은 모두 블랙입니다. (레드 노드는 연속될 수 없습니다.)
어떤 노드로부터 시작해 리프 노드까지 도달하는 모든 경로에는 같은 수의 블랙 노드가 존재합니다.

        레드-블랙 트리에 새로운 값을 삽입하는 연산을 구현하세요.

마지막에 rotate 하는 부분을 보면, 만약에 트리의 구조가 변경 될 때 색상이 어떻게 변경되는지 볼 수 있습니다.

어떠한 노드가 추가됨에 따라서 레드-블랙 트리의 구조가 무너지면, 회전과 색상 변환 메소드를 이용하여 복원해야 하는 구조를 지니고 있습니다.
새 노드의 색상은 반드시 "레드"로 지정합니다.*/

enum Color {
    RED,
    BLACK
}

class RBNode {
    int value;
    RBNode left, right, parent;
    Color color;

    public RBNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.color = Color.RED;
    }
}

public class RedBlackTree {
    private RBNode root;

    public RedBlackTree() {
        root = null;
    }

    public void insert(int value) {
        RBNode newNode = new RBNode(value);
        if (root == null) {
            root = newNode;
            root.color = Color.BLACK;
        } else {
            insertRecursive(root, newNode);
        }
        fixInsert(newNode);
    }

    private void insertRecursive(RBNode current, RBNode newNode) {
        if (newNode.value < current.value) {
            if (current.left == null) {
                current.left = newNode;
                newNode.parent = current;
            } else {
                insertRecursive(current.left, newNode);
            }
        } else if (newNode.value > current.value) {
            if (current.right == null) {
                current.right = newNode;
                newNode.parent = current;
            } else {
                insertRecursive(current.right, newNode);
            }
        }
    }

    private void fixInsert(RBNode node) {
        RBNode parent = null;
        RBNode grandParent = null;

        while (node != root && node.color != Color.BLACK && node.parent.color == Color.RED) {
            parent = node.parent;
            grandParent = node.parent.parent;


            if (parent == grandParent.left) {
                RBNode uncle = grandParent.right;


                if (uncle != null && uncle.color == Color.RED) {
                    grandParent.color = Color.RED;
                    parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    node = grandParent;
                } else {
                    if (node == parent.right) {
                        rotateLeft(parent);
                        node = parent;
                        parent = node.parent;
                    }
                    rotateRight(grandParent);
                    Color tempColor = parent.color;
                    parent.color = grandParent.color;
                    grandParent.color = tempColor;
                    node = parent;
                }
            } else {
                RBNode uncle = grandParent.left;

                if (uncle != null && uncle.color == Color.RED) {
                    grandParent.color = Color.RED;
                    parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    node = grandParent;
                } else {
                    if (node == parent.left) {
                        rotateRight(parent);
                        node = parent;
                        parent = node.parent;
                    }
                    rotateLeft(grandParent);
                    Color tempColor = parent.color;
                    parent.color = grandParent.color;
                    grandParent.color = tempColor;
                    node = parent;
                    // implement here
                }
            }
                root.color = Color.BLACK;
            }
        }


    private void rotateRight(RBNode node) {
        RBNode leftChild = node.left;
        node.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }
        leftChild.parent = node.parent;
        if (node.parent == null) {
            this.root = leftChild;
        } else if (node == node.parent.right) {
            node.parent.right = leftChild;
        } else {
            node.parent.left = leftChild;
        }
        leftChild.right = node;
        node.parent = leftChild;
    }


    private void rotateLeft(RBNode node) {
        RBNode rightChild = node.right;
        node.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }
        rightChild.parent = node.parent;
        if (node.parent == null) {
            this.root = rightChild;
        } else if (node == node.parent.left) {
            node.parent.left = rightChild;
        } else {
            node.parent.right = rightChild;
        }
        rightChild.left = node;
        node.parent = rightChild;
    }
}
