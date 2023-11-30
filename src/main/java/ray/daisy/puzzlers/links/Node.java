package ray.daisy.puzzlers.links;

public class Node {
    private int value;
    private Node next;
    private Node previous;

    public Node(int value, Node next, Node previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
    public int getValue() {
        return value;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public void setPrevious(Node previous) {
        this.previous = previous;
    }
    public Node getPrevious() {
        return previous;
    }

    public static Node createNodeList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        Node head = null;
        Node previousNode = null;

        for(int value : values) {
            Node temp = new Node(value, null);
            if (head == null) {
                head = temp;
                previousNode = temp;
            } else {
                previousNode.setNext(temp);
                previousNode = temp;
            }
        }
        return head;
    }
    public static Node createBidirectionalNodeList(int[] values) {
        if ( values == null || values.length == 0 ) {
            return null;
        }
        Node head = null;
        Node previousNode = null;
        for(int value : values) {
            Node temp = new Node(value, null, null);
            if ( head == null) {
                head = temp;
                previousNode = temp;
            } else {
                previousNode.setNext(temp);
                temp.setPrevious(previousNode);
                previousNode = temp;

            }
        }
        return head;
    }
    public Node retreiveLastNode() {
        Node temp = this;
        while(true) {
            if ( temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        return temp;
    }

    public Node getAt(int index) {
        Node temp = this;
        int i = 0;
        while (temp != null) {
            if (i == index){
                return temp;
            }
            i++;
            temp = temp.getNext();
        }
        return null;
    }
    public Node search(int value) {
        //find the value from the node else return null
        Node temp = this;
        while(temp != null) {
            if (temp.getValue() == value) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

    public Node removeNode(int value) {
        if ( value == this.value) {
            Node tempNext = this.getNext();
            if (tempNext != null) {
                tempNext.setPrevious(null);
            }
            return tempNext;
        }
        Node temp = this;
        while (temp != null) {
            if (temp.getValue() == value) {
                Node tempNext = temp.getNext();
                if (tempNext != null) {
                    tempNext.setPrevious(temp.getPrevious());
                }
                Node tempPrevious = temp.getPrevious();
                if(tempPrevious != null) {
                    tempPrevious.setNext(temp.getNext());
                }
                break;
            }
            temp = temp.getNext();
        }
        return this;
    }
}

