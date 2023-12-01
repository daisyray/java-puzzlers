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
}
