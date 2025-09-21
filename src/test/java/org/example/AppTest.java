package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    void testMergeCase1() {
        assertEquals("[1, 2, 2, 3, 5, 6]",
                App.driver(new int[]{1, 2, 3, 0, 0, 0}, 3,
                        new int[]{2, 5, 6}, 3));
        System.out.println("TC 1 passed");
    }

    @Test
    void testMergeCase2() {
        assertEquals("[2, 3, 4, 5, 6, 6]",
                App.driver(new int[]{4, 6, 3, 0, 0, 0}, 3,
                        new int[]{2, 5, 6}, 3));
        System.out.println("TC 2 passed");
    }
}
