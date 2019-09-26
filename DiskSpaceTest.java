import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DiskSpaceTest {

    @Test
    public void test1() {
        assertTrue(DiskSpace.isWritable(1, 1, new HashSet<>()));
    }

    @Test
    public void test2() {
        assertFalse(DiskSpace.isWritable(1, 1, new HashSet<>(Arrays.asList(1))));
    }

    @Test
    public void test3() {
        assertTrue(DiskSpace.isWritable(4, 2, new HashSet<>(Arrays.asList(1, 4))));
    }  
    
    @Test
    public void test4() {
        assertTrue(DiskSpace.isWritable(10, 6, new HashSet<>(Arrays.asList(1, 8, 10))));
    }
    
    @Test
    public void tes5() {
        assertTrue(DiskSpace.isWritable(10, 8, new HashSet<>(Arrays.asList(1, 2))));
    }
    
    @Test
    public void test6() {
        assertFalse(DiskSpace.isWritable(10, 4, new HashSet<>(Arrays.asList(3, 6, 8, 10))));
    }
    
    @Test
    public void test7() {
        assertTrue(DiskSpace.isWritable(10, 2, new HashSet<>(Arrays.asList(2, 6, 7))));
    }

}