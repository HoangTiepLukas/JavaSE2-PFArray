package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PFArrayTest {

    @Test
    void testCreateManualArray() {
        PFArray pf = new PFArray();
        pf.createManualArray("1,2,3");

        assertEquals(1, pf.size());
        assertArrayEquals(new int[]{1, 2, 3}, pf.getArray(0));
    }

    @Test
    void testCreateRandomArray() {
        PFArray pf = new PFArray();
        pf.createRandomArray();

        assertEquals(1, pf.size());
        assertTrue(pf.getArray(0).length >= 1 && pf.getArray(0).length <= 10);
    }

    @Test
    void testAddNumber() {
        PFArray pf = new PFArray();
        pf.createManualArray("5,10");

        pf.addNumber(0, 20);

        assertArrayEquals(new int[]{5, 10, 20}, pf.getArray(0));
    }

    @Test
    void testFindMax() {
        PFArray pf = new PFArray();
        pf.createManualArray("3,9,1");

        assertEquals(9, pf.findMax(0));
    }

    @Test
    void testFindMin() {
        PFArray pf = new PFArray();
        pf.createManualArray("3,9,1");

        assertEquals(1, pf.findMin(0));
    }

    @Test
    void testSum() {
        PFArray pf = new PFArray();
        pf.createManualArray("3,9,1");

        assertEquals(13, pf.sum(0));
    }

    @Test
    void testRemoveNumber() {
        PFArray pf = new PFArray();
        pf.createManualArray("1,2,3,2,4");

        pf.removeNumber(0, 2);

        assertArrayEquals(new int[]{1, 3, 4}, pf.getArray(0));
    }

    @Test
    void testRegenerate() {
        PFArray pf = new PFArray();
        pf.createManualArray("1,1,1");

        pf.regenerate(0);

        int[] arr = pf.getArray(0);
        assertEquals(3, arr.length);
        // values should be between -100 and 100
        for (int n : arr) {
            assertTrue(n >= -100 && n <= 100);
        }
    }

    @Test
    void testDeleteArray() {
        PFArray pf = new PFArray();
        pf.createManualArray("1,2,3");

        pf.deleteArray(0);

        assertEquals(0, pf.size());
    }
}
