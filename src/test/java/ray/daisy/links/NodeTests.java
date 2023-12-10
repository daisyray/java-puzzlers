package ray.daisy.links;

import org.testng.annotations.Test;
import ray.daisy.puzzlers.links.Node;

import static org.testng.Assert.*;

public class NodeTests {
    @Test
    public void createBidirectionalNodeListTest() {
        int[] ar = new int[]{10, 30, 40 ,50};
        Node head = Node.createBidirectionalNodeList(ar);
        Node lastNode = head.retreiveLastNode();
        assertNotNull(lastNode);
        assertEquals(lastNode.getValue(), 50);
        assertEquals(head.getValue(), 10);
        assertNull(lastNode.getNext());
        assertNull(head.getPrevious());
        assertNotNull(lastNode.getPrevious());
        assertNotNull(head.getNext());
    }
    @Test
    public void getAtTest() {
        int[] ar = new int[]{10,20,30,40,50};
        Node head = Node.createBidirectionalNodeList(ar);
        Node index = head.getAt(3);
        assertEquals(index.getValue(), 40);
        Node index1 = head.getAt(0);
        assertEquals(index1.getValue(), 10);
        Node head2 = Node.createBidirectionalNodeList(new int[]{2});
        Node indexForHead2 = head2.getAt(10);
        assertNull(indexForHead2);
    }
    @Test
    public void nodeSearch() {
        int[] ar = new int[]{10,20,30,40,50};
        Node head = Node.createBidirectionalNodeList(ar);
        Node searchResult = head.search(20);
        assertNotNull(searchResult);
        assertEquals(searchResult.getValue(), 20);
        Node searchResult1 = head.search(100);
        assertNull(searchResult1);
        Node searchResult1stValue = head.search(10);
        assertNotNull(searchResult1stValue);
        assertEquals(searchResult1stValue.getValue(), 10);
    }
    @Test
    public void removeNode() {
        int[] ar = new int[]{10,20,30,40,50};
        Node head = Node.createBidirectionalNodeList(ar);
        Node newHead0 = head.removeNode(30);
        assertEquals(newHead0, head);
        assertEquals(head.getAt(3).getValue(), 50);
        Node head1 = Node.createBidirectionalNodeList(ar);
        Node newHead = head1.removeNode(10);
        assertEquals(newHead.getValue(), 20);
        Node head2 = Node.createBidirectionalNodeList(ar);

        assertEquals(head2.retreiveLastNode().getValue(), 50);

        Node newHead2 = head2.removeNode(50);
        assertEquals(newHead2.retreiveLastNode().getValue(), 40);
    }
}
