package seba0.javaszc4.wzorce.pylek.tree;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertSame;

public class TreeFactoryTest {

    private TreeFactory factory;

    @DataProvider
    public Object[] dataSizes() {
        return Size.values();
    }

    @BeforeClass
    public void init() {
        factory = new TreeFactory();
    }

    @Test(dataProvider = "dataSizes")
    public void testGetTree(Size size) {

        // when
        Tree a = factory.getTree(size);
        Tree b = factory.getTree(size);

        // then
        assertSame(a, b);
    }
}