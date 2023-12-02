package ray.daisy.puzzlers.links;

public class GenericNode<T> {
    private GenericNode previous;
    private GenericNode next;
    private T value;

    public GenericNode(GenericNode<T> previous, GenericNode<T> next, T value) {
        this.previous = previous;
        this.next = next;
        this.value = value;
    }

    public GenericNode<T> getPrevious() {
        return previous;
    }

    public GenericNode<T> getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }

    public void setPrevious(GenericNode<T> previous) {
        this.previous = previous;
    }

    public void setNext(GenericNode<T> next) {
        this.next = next;
    }

    public  GenericNode<T> retreiveLastNode() {
        GenericNode<T> temp = this;
        while(true) {
            if ( temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        return temp;
    }
    public static <T> GenericNode<T> createNodeList(T[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        GenericNode<T> head = null;
        GenericNode<T> previousNode = null;

        for(T value : values) {
            GenericNode<T> temp = new GenericNode<T>(null, null, value);
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
    public GenericNode<T> getAt(int index) {
        GenericNode<T> temp = this;
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
    public GenericNode<T> search(T value) {
        //find the value from the node else return null
        GenericNode<T> temp = this;
        while(temp != null) {
            if (temp.getValue().equals(value)) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

    public GenericNode<T> removeNode(T value) {
        if (this.value == value) {
            GenericNode<T> tempNext = this.getNext();
            if (tempNext != null) {
                tempNext.setPrevious(null);
            }
            return tempNext;
        }
        GenericNode<T> temp = this;
        while (temp != null) {
            if (temp.getValue().equals(value)) {
                GenericNode<T> tempNext = temp.getNext();
                if (tempNext != null) {
                    tempNext.setPrevious(temp.getPrevious());
                }
                GenericNode<T> tempPrevious = temp.getPrevious();
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
