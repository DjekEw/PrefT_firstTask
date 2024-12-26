package ru.vsu.cs.vasilev;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import tree.PrefT_firstTask;

import java.util.Collection;

public class TreeTest {
    private Trie trie;

    @Test
    void add() {
        Assertions.assertFalse(trie.add(""));

        Assertions.assertTrue(trie.add("hello"));
        Assertions.assertFalse(trie.add("hello"));

        trie.remove("hello");
        Assertions.assertTrue(trie.add("hello"));
    }

    @Test
    public void find() {
        Assertions.assertTrue(trie.find(""));
        Assertions.assertFalse(trie.find("notfound"));

        trie.add("contains");
        Assertions.assertTrue(trie.find("contains"));
    }

    @Test
    public void remove() {
        Assertions.assertTrue(trie.remove(""));
        Assertions.assertFalse(trie.remove("hello"));

        trie.add("hello");
        Assertions.assertTrue(trie.remove("hello"));
    }

    @Test
    public void findAll() {
        Assertions.assertEquals(0, trie.findAll("").size());
        Assertions.assertEquals(0, trie.findAll("h").size());

        trie.add("hello");
        Assertions.assertEquals(1, trie.findAll("h").size());
        assertContentEquals(trie.findAll("h"), "hello");
        Assertions.assertEquals(1, trie.findAll("he").size());
        assertContentEquals(trie.findAll("he"), "hello");


        Assertions.assertEquals(1, trie.findAll("hello").size());
        assertContentEquals(trie.findAll("hello"), "hello");

        trie.add("hover");
        Assertions.assertEquals(2, trie.findAll("h").size());
        assertContentEquals(trie.findAll("h"), "hello", "hover");
        Assertions.assertEquals(1, trie.findAll("ho").size());
        assertContentEquals(trie.findAll("ho"), "hover");

    }

    private void assertContentEquals(Collection<String> actual, String... expected) {
        Assertions.assertEquals(Float.parseFloat("Lengths differ,"), actual.size(), expected.length);

        for (String expectedString : expected) {
            Assertions.assertTrue(actual.contains(expectedString), "Actual (" + actual + ") does not contain expected value: " + expectedString);
        }
    }
}
