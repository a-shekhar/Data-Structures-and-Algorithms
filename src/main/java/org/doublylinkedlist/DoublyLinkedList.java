package org.doublylinkedlist;

public class DoublyLinkedList {
    private DoublyListNode head;
    private DoublyListNode tail;
    private int size;

    public DoublyListNode createLinkedList(int val){
        if(head == null){
            DoublyListNode newNode = new DoublyListNode(val);
            head = newNode;
            tail = newNode;
            size = 1;
        }
        return head;
    }

    public void insertAtPosition(int val, int index){
        if(index < 0){
            System.out.println("Invalid index");
            return;
        }

        if(head == null){
            createLinkedList(val);
            return;
        }

        DoublyListNode newNode = new DoublyListNode(val);

        if(index == 0){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if(index >= size){
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else{
            DoublyListNode curr = head;
            for(int i = 0; i < index - 1; i++){
                curr = curr.next;
            }

            newNode.next = curr.next;
            curr.next.prev = newNode;
            curr.next = newNode;
            newNode.prev = curr;
            
        }

        size++;
    }

    public void deleteAtPosition(int index){

         if(head == null){
            System.out.println("Empty Linked List");
            return;
        }
        
        if(index < 0 || index >= size){
            System.out.println("Invalid Index");
            return;
        }

    


        System.out.println("Deleting Node at Index " + index);

        if(index == 0){
            if(size == 1){
                head = null;
                tail = null;
                size = 0;
                return;
            }

            DoublyListNode curr = head.next;
            // if(curr == tail){
            //     removeFromEnd(curr);
            // }
            curr.prev = null;
            head = curr;
        } else if(index == size - 1){
            //DoublyListNode curr = head;
            //for(int )
            tail = tail.prev;
            tail.next = null;
        } else {
            DoublyListNode curr = head;
            for(int i = 0; i < index - 1; i++){
                curr = curr.next;
            }

            DoublyListNode nodeToBeRemoved = curr.next;
            curr.next = nodeToBeRemoved.next;
            nodeToBeRemoved.next.prev = curr;
        }
        size--;
    }

    private void removeFromEnd(DoublyListNode curr){

    }

    public void search(int val){
        if(head == null){
            System.out.println("Empty Doubly Linked List");
            return;
        }

        DoublyListNode curr = head;
        int i = 0;
        while(curr != null){
            if(curr.val == val){
                System.out.println("Value found at index " + i);
                return;
            }
            curr = curr.next;
            i++;
        }
        System.out.println("Value not found in Doubly Linked List");
    }

    public void traverse(){
        if(head == null){
            System.out.println("Empty Doubly Linked list");
            return;
        }

        DoublyListNode curr = head;

        for(int i = 0; i < size; i++){
            System.out.print(curr.val);
            if(i != size - 1){
                System.out.print(" -> ");
            }
            curr = curr.next;
        }

        System.out.println();
    }


    public void backwardTraverse(){
        System.out.println("Traversing Backward...");
        if(head == null){
            System.out.println("Empty Doubly Linked list");
            return;
        }

        DoublyListNode curr = tail;

        for(int i = 0; i < size; i++){
            System.out.print(curr.val);
            if(i != size - 1){
                System.out.print(" -> ");
            }
            curr = curr.prev;
        }

        System.out.println();
    }
}
