package ray.daisy.puzzlers.links;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class GenericNodeTest {
    @Test
    public void createStringList() {
        GenericNode<String> genericNode =  GenericNode.createNodeList(new String[]{"cat", "dog", "bunny"});
        assertNotNull(genericNode);
        assertEquals(genericNode.getValue(), "cat");
        assertEquals(genericNode.retreiveLastNode().getValue(), "bunny");
    }
}
