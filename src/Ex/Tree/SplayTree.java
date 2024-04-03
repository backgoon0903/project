package Ex.Tree;

class SplayNode {
    int value;
    SplayNode left, right, parent;

    SplayNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
public class SplayTree {
    private SplayNode root;

    public SplayTree() {
        this.root = null;
    }

    private void splay(SplayNode x) {
        while (x.parent != null) {
            if (x.parent.parent == null) {
                if (x.parent.left == x) {
                    rotateRight(x.parent);
                } else {
                    rotateLeft(x.parent);
                }
            } else if (x.parent.left == x && x.parent.parent.left == x.parent) {
                rotateRight(x.parent.parent);
                rotateRight(x.parent);
            } else if (x.parent.right == x && x.parent.parent.right == x.parent) {
                rotateLeft(x.parent.parent);
                rotateLeft(x.parent);
            } else { // Zig-Zag
                if (x.parent.left == x) {
                    rotateRight(x.parent);
                    rotateLeft(x.parent);
                } else {
                    rotateLeft(x.parent);
                    rotateRight(x.parent);
                }
            }
        }
        root = x;
    }

    private void rotateLeft(SplayNode x) {
        SplayNode y = x.right;
        x.right = y.left;
        if (y.left != null) y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void rotateRight(SplayNode x) {
        SplayNode y = x.left;
        x.left = y.right;
        if (y.right != null) y.right.parent = x;
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    public void insert(int value) {
        SplayNode z = root;
        SplayNode p = null;
        while (z != null) {
            p = z;
            if (z.value < value) {
                z = z.right;
            } else {
                z = z.left;
            }

            z = new SplayNode(value);
            z.parent = p;
            if (p == null) {
                z = root;
            } else if (z.value < p.value) {
                p.left = z;
            } else {
                p.right = z;
                ;
            }
            splay(z);
        }
    }


    public SplayNode search(int value) {
        SplayNode z = root;
        while (z != null) {
            if (value > z.value) {
                z = z.right;
            } else if (value < z.value){
                z = z.left;
            }
            splay(z);
            return z;
        }
        splay(z);
        if (z != null) splay(z);
        return null;
    }

    public void delete(int value) {
        SplayNode node = search(value);
        if (node == null) {
            return;
        }

        splay(node);

        if (node.left == null) {
            replace(node, node.right);
        } else if (node.right == null) {
            replace(node, node.left);
        } else {
            SplayNode min = node.right;
            while (min.left != null) {
                min = min.left;
            }
            if (min.parent != node) {
                replace(min, min.right);
                min.right = node.right;
                min.right.parent = min;
            }
            replace(node, min);
            min.left = node.left;
            min.left.parent = min;
        }
    }

    private void replace(SplayNode a, SplayNode b) {
        if (a.parent == null) {
            root = b;
        } else if (a == a.parent.left) {
            a.parent.left = b;
        } else {
            a.parent.right = b;
        }
        if (b != null) {
            b.parent = a.parent;
        }
    }
}



/*이 코드에서 삽입, 검색, 교체 메쏘드를 추가해주세요.*/
