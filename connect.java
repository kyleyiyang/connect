/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root==null) return null;
        Queue<Node> pq=new LinkedList<>();
        Node node=root;
        pq.add(node);
        int count=0;
        Node pre=null;
        while (!pq.isEmpty()) {
            ++count;
            node=pq.poll();
            if ((Math.log(count+1)/Math.log(2))%1==0) node.next=null;
            else if (count>1 && count%2!=0) pre=node;
            else if(count%2==0 && pre!=null) {pre.next=node;pre=null;}
            if (node.left!=null && node.right!=null) {
                node.left.next=node.right;
                pq.add(node.left);
                pq.add(node.right);
            }
        }
        return root;
    }
}

*********************************

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node nextLevHead=null,nextLevLeading=null,curr=root;
        while (curr!=null) {
            while (curr!=null) {
                if (curr.left!=null) {
                    if (nextLevLeading!=null) {
                        nextLevLeading.next=curr.left;
                    } else nextLevHead=curr.left;
                    nextLevLeading=curr.left;
                }
                if (curr.right!=null) {
                    if (nextLevLeading!=null) {
                        nextLevLeading.next=curr.right;
                    } else nextLevHead=curr.right;
                    nextLevLeading=curr.right;
                }
                // move to next node
                curr=curr.next;
            }
            //move to next level
            curr=nextLevHead;
            nextLevHead=null;
            nextLevLeading=null;
        }
        return root;
    }
}
