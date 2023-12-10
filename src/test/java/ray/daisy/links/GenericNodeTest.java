package ray.daisy.links;

import org.testng.annotations.Test;
import ray.daisy.puzzlers.links.GenericNode;

import static org.testng.Assert.*;
import static org.testng.Assert.assertNull;

public class GenericNodeTest {
    @Test
    public void createStringList() {
        GenericNode<String> genericNode =  GenericNode.createNodeList(new String[]{"cat", "dog", "bunny"});
        assertNotNull(genericNode);
        assertEquals(genericNode.getValue(), "cat");
        assertEquals(genericNode.retreiveLastNode().getValue(), "bunny");
    }

}
