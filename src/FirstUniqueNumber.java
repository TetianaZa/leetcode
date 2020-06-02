//You have a queue of integers, you need to retrieve the first unique integer in the queue.
//
//Implement the FirstUnique class:
//
//FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
//int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
//void add(int value) insert value to the queue.
// Input:
//["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
//[[[2,3,5]],[],[5],[],[2],[],[3],[]]
//Output:
//[null,2,null,2,null,3,null,-1]
//
//Explanation:
//FirstUnique firstUnique = new FirstUnique([2,3,5]);
//firstUnique.showFirstUnique(); // return 2
//firstUnique.add(5);            // the queue is now [2,3,5,5]
//firstUnique.showFirstUnique(); // return 2
//firstUnique.add(2);            // the queue is now [2,3,5,5,2]
//firstUnique.showFirstUnique(); // return 3
//firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
//firstUnique.showFirstUnique(); // return -1

import java.util.HashMap;
import java.util.HashSet;

public class FirstUniqueNumber {
    class FirstUnique {
        class Node {
            Node next;
            Integer value;
            Node previous;

            public Node(Integer value) {
                this.value = value;
            }
        }

        Node firsNode;
        Node lastNode;
        HashMap<Integer, Node> uniqueValue = new HashMap<>();
        HashSet<Integer> values = new HashSet<>();

        public FirstUnique(int[] nums) {
            for (int number : nums) {
                add(number);
            }
        }

        public int showFirstUnique() {
            if (firsNode == null) return -1;
            return firsNode.value;
        }

        public void add(int value) {
            if (uniqueValue.containsKey(value)) {
                Node current = uniqueValue.get(value);
                rejoin(current);
                uniqueValue.remove(value);
            }
            if (!uniqueValue.containsKey(value) && !values.contains(value)) {
                uniqueValue.put(value, createNode(value));
                values.add(value);
            }

        }

        private Node createNode(Integer value) {
            Node newNode = new Node(value);
            if (firsNode == null) {
                firsNode = newNode;
            } else if (lastNode != null) {
                newNode.previous = lastNode;
                lastNode.next = newNode;
                lastNode = newNode;
            } else if (lastNode == null) {
                newNode.previous = firsNode;
                firsNode.next = newNode;
                lastNode = newNode;
            }
            return newNode;
        }
        private void rejoin(Node node){
            if (node.previous==null && node.next==null){
                firsNode=null; lastNode= null;
            }else if(node.previous == null) {
                firsNode = node.next;
                if(firsNode==lastNode) {lastNode=null; }
                firsNode.previous=null;
            }else if(node.next==null){
                if(lastNode.previous==firsNode){
                    lastNode=null;
                    firsNode.next=null;
                } else {
                    lastNode =lastNode.previous;
                    lastNode.next=null;
                }

            }else {
                lastNode.previous.next =lastNode.next;
                lastNode.next.previous =lastNode.previous;
            }

        }
    }

    public static void main(String[] args) {
        FirstUnique firstUnique = new FirstUniqueNumber().new FirstUnique(new int[]{2,3,5});
        firstUnique.showFirstUnique(); // return 2
        firstUnique.add(5);            // the queue is now [2,3,5,5]
        firstUnique.showFirstUnique(); // return 2
        firstUnique.add(2);            // the queue is now [2,3,5,5,2]
        firstUnique.showFirstUnique(); // return 3
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        firstUnique.showFirstUnique(); // return
    }
}
