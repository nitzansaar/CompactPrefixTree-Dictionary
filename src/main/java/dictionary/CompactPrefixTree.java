package dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * CompactPrefixTree class, implements Dictionary ADT and
 * several additional methods. Can be used as a spell checker.
 * Fill in code and feel free to add additional methods as needed.
 * S19
 */
public class CompactPrefixTree implements Dictionary {

    private Node root; // the root of the tree

    /**
     * Default constructor
     */
    public CompactPrefixTree() {
        root = new Node("");
    }

    /**
     * Creates a dictionary ("compact prefix tree")
     * using words from the given file.
     *
     * @param filename the name of the file with words
     */
    public CompactPrefixTree(String filename) {
        // Read each word from the file, add it to the tree
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String word;
            while ((word = reader.readLine()) != null) {
                add(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Adds a given word to the dictionary.
     *
     * @param word the word to add to the dictionary
     */
    public void add(String word) {
        root = add(word.toLowerCase(), root); // Calling private add method
    }

    /**
     * Checks if a given word is in the dictionary
     *
     * @param word the word to check
     * @return true if the word is in the dictionary, false otherwise
     */
    public boolean check(String word) {
        return check(word.toLowerCase(), root); // Calling a private check method
    }

    /**
     * Checks if a given prefix is stored in the dictionary
     *
     * @param prefix The prefix of a word
     * @return true if this prefix is a prefix of any word in the dictionary,
     * and false otherwise
     */
    public boolean checkPrefix(String prefix) {
        return checkPrefix(prefix.toLowerCase(), root); // Calling a private checkPrefix method
    }

    /**
     * Returns a human-readable string representation of the compact prefix tree;
     * contains nodes listed using pre-order traversal and uses indentations to show the level of the node.
     * An asterisk after the node means the node's boolean flag is set to true.
     * The root is at the current indentation level (followed by * if the node's valid bit is set to true),
     * then there are children of the node at a higher indentation level.
     */
    public String toString() {
        // FILL IN CODE
        StringBuilder builder = new StringBuilder();
        toString(root, builder, 0);
        return builder.toString();
    }

    private void toString(Node node, StringBuilder builder, int level) {
        if (node == null) {
            return;
        }
        builder.append(" ".repeat(Math.max(0, level)));
        builder.append(node.prefix);
        if (node.isWord) {
            builder.append('*');
        }
        builder.append('\n');
        for (Node child : node.children) {
            if (child != null) {
                toString(child, builder, level + 1); // recursive call
            }
        }
    }

    /**
     * Print out the nodes of the tree to a file, using indentations to specify the level
     * of the node.
     *
     * @param filename the name of the file where to output the tree
     */
    public void printTree(String filename) {
        // FILL IN CODE
        // Uses toString() method; outputs info to a file
        try (FileWriter fileWriter = new FileWriter(filename)) {
            String tree = toString();
            fileWriter.write(tree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return an array of the entries in the dictionary that are as close as possible to
     * the parameter word.  If the word passed in is in the dictionary, then
     * return an array of length 1 that contains only that word.  If the word is
     * not in the dictionary, then return an array of numSuggestions different words
     * that are in the dictionary, that are as close as possible to the target word.
     * Implementation details are up to you, but you are required to make it efficient
     * and make good use ot the compact prefix tree.
     *
     * @param word           The word to check
     * @param numSuggestions The length of the array to return.  Note that if the word is
     *                       in the dictionary, this parameter will be ignored, and the array will contain a
     *                       single world.
     * @return An array of the closest entries in the dictionary to the target word
     */

    public String[] suggest(String word, int numSuggestions) {
        // FILL IN CODE
        // Note: you need to create a private suggest method in this class
        // (like we did for methods add, check, checkPrefix)


        return null; // don't forget to change it
    }

    // ---------- Private helper methods ---------------

    private String getCommonPrefix(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());
        int i = 0;
        while (i < minLength && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        return s1.substring(0, i);
    }

    /**
     * A private add method that adds a given string to the tree
     *
     * @param s    the string to add
     * @param node the root of a tree where we want to add a new string
     * @return a reference to the root of the tree that contains s
     */
    private Node add(String s, Node node) {
        if (node == null) {
            node = new Node(s); // create new node with prefix we are looking for
            node.isWord = true;
            return node;
        }
        String commonPrefix = getCommonPrefix(s, node.prefix);
        if (commonPrefix.length() < node.prefix.length()) { // need to split
            Node newNode = new Node(commonPrefix); // create new prefix node
            newNode.children[node.prefix.charAt(commonPrefix.length()) - 'a'] = node; // set current node as child
            node.prefix = node.prefix.substring(commonPrefix.length()); // update prefix of current node
            node = newNode;
        }
        if (commonPrefix.length() == s.length() && commonPrefix.length() == node.prefix.length()) {
            node.isWord = true;
        } else if (commonPrefix.length() == node.prefix.length()) {
            s = s.substring(commonPrefix.length());
            int index = s.charAt(0) - 'a';
            node.children[index] = add(s, node.children[index]);
        }
        return node;
    }


    /**
     * A private method to check whether a given string is stored in the tree.
     *
     * @param s    the string to check
     * @param node the root of a tree
     * @return true if the prefix is in the dictionary, false otherwise
     */
    private boolean check(String s, Node node) {
        if (node == null) {
            return false; // not in tree
        }
        String commonPrefix = getCommonPrefix(s, node.prefix);
        if (commonPrefix.equals(node.prefix)) {
            if (s.length() > commonPrefix.length()) {
                String leftoverChars = s.substring(commonPrefix.length());
                int index = leftoverChars.charAt(0) - 'a';
                return check(leftoverChars, node.children[index]);
            } else if (s.length() == commonPrefix.length()) {
                return node.isWord;
            }
        }
        return false;
    }

    /**
     * A private recursive method to check whether a given prefix is in the tree
     *
     * @param prefix the prefix
     * @param node the root of the tree
     * @return true if the prefix is in the dictionary, false otherwise
     */
    private boolean checkPrefix(String prefix, Node node) {
        if (node == null)
            return false;
        String commonPrefix = getCommonPrefix(prefix, node.prefix);
        if (commonPrefix.equals(node.prefix)) {
            if (prefix.length() > commonPrefix.length()) {
                String leftoverChars = prefix.substring(commonPrefix.length());
                int index = leftoverChars.charAt(0) - 'a';
                return checkPrefix(leftoverChars, node.children[index]);
            } else
                return prefix.length() == commonPrefix.length(); // prefix exists in the tre
        } else
            return commonPrefix.equals(prefix);
    }


    // You might want to create a private recursive helper method for toString
    // that takes the node and the number of indentations, and returns the tree  (printed with indentations) in a string.
    // private String toString(Node node, int numIndentations)


    // Add a private suggest method. Decide which parameters it should have

    // --------- Private class Node ------------
    // Represents a node in a compact prefix tree
    private class Node {
        String prefix; // prefix stored in the node
        Node children[]; // array of children (26 children)
        boolean isWord; // true if by concatenating all prefixes on the path from the root to this node, we get a valid word

        Node(String prefix) {
            this.prefix = prefix;
            children = new Node[26];
            isWord = false;
        }
    }
}
