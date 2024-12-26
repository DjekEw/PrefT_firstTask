package ru.vsu.cs.vasilev;

import java.util.Collection;
import java.util.HashSet;

public class Trie {
    private final Node root;

    public Trie() {
        this.root = Node.rootNode();
    }

    public boolean add(String string) {
        if (string == null) {
            throw new RuntimeException();
        } else {
            if (string.isEmpty())
                return false;

            return root.add(string);
        }
    }

    public boolean remove(String string) {
        if (string == null) {
            throw new RuntimeException();
        }
        else
        {
        if (string.isEmpty())
            return true;

        return root.remove(string);
    }
    }

    public boolean find(String string) {
        if (string == null) {
            throw new RuntimeException();
        }
        else {
            return getNodeByPrefix(string) != null;
        }
    }

    public Collection<String> findAll(String prefix) {
        if (prefix == null) {
            throw new RuntimeException();
        }
        else {
            Node prefixedNode = getNodeByPrefix(prefix);
            if (prefixedNode == null || prefixedNode == root)
                return new HashSet<>();

            return prefixedNode.getAllStringsForThisBranch(new HashSet<>(), new StringBuilder(prefix.substring(0, prefix.length() - 1)));
        }
    }

    private Node getNodeByPrefix(String prefix) {
        if (prefix == null) {
            throw new RuntimeException();
        }
        else
        {
            return root.findChildByPrefix(prefix);
        }
    }
}
