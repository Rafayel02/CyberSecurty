package org.example.huffman;

import java.util.*;
import java.util.stream.Collectors;

/**
 * © Ռաֆայել Շահնազարյան Դավիթի, Իրինա Գևորգյան Արտյոմի Երևան 2022
 * <p>
 * Այս լուծումը մշակվել է Հայաստանի Ազգային Պոլիտեխնիկական Համալսարանում
 * «Տեղեկատվության գաղտնագրային և թաքնագրային պաշտպանություն» առարկայի
 * ընթացքում։ Ծրագրային ապահովումը վերաբերվում է 'Huffman' ալգորիթմին։
 * Մշակված հատվածը կիրառելու դեպքում հեղիանկների անունները նշելը պարտադիր է։
 **/
public class HuffmanAlgorithm {

    private Node rootNode;

    public String encrypt(String text) {

        Map<Character, Integer> charsCount = getCharsCount(text);
        List<Node> unsortedNodes = makeNodes(charsCount);

        List<Node> nodes = unsortedNodes.stream().sorted().collect(Collectors.toList());

        while (nodes.size() != 1) {
            // Taking first two smallest nodes
            Node first = nodes.get(0);
            Node second = nodes.get(1);

            // Creating parent node for them
            Node node = new Node();
            node.setType(NodeType.NUMBER_TYPE);
            node.setLeft(first);
            node.setRight(second);
            node.setCount(first.getCount() + second.getCount());

            // Removing first two nodes
            nodes.remove(0);
            nodes.remove(0);

            // Adding parent node instead
            nodes.add(node);

            // Sorting again after addition
            nodes = nodes.stream().sorted().collect(Collectors.toList());
        }

        this.rootNode = nodes.get(0);

        return makeResult(text, this.rootNode);
    }


    public String decrypt(String encrypted) {
        StringBuilder result = new StringBuilder();

        Node root = this.rootNode;

        for (char c : encrypted.toCharArray()) {
            if (c == '0') {
                // In case '0' should take left node
                Node left = root.getLeft();
                // If it is ValueType node, then append value to result and update root for next iteration
                if (Objects.equals(left.getType(), NodeType.VALUE_TYPE)) {
                    result.append(left.getValue());
                    root = this.rootNode;
                    continue;
                }
                // Update root for next iteration
                root = left;
            } else if (c == '1') {
                // In case '1' should take right node
                Node right = root.getRight();
                // If it is ValueType node, then append value to result and update root for next iteration
                if (Objects.equals(right.getType(), NodeType.VALUE_TYPE)) {
                    result.append(right.getValue());
                    root = this.rootNode;
                    continue;
                }
                // Update root for next iteration
                root = right;
            }
        }

        return result.toString();
    }

    private String makeResult(String text, Node rootNode) {
        // Getting all symbols with their 01 view in map
        Map<Character, String> values = new HashMap<>();
        getCharBinaryValue(values, rootNode, new StringBuilder());

        // Appending all symbols result according to text
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            result.append(values.get(c));
        }

        return result.toString();
    }

    /**
     * Recursive method for iterating on all branches
     */
    private void getCharBinaryValue(Map<Character, String> values, Node tempNode, StringBuilder builder) {
        Node left = tempNode.getLeft();
        Node right = tempNode.getRight();

        if (Objects.equals(NodeType.VALUE_TYPE, tempNode.getType())) {
            values.put(tempNode.getValue(), builder.toString());
        }

        if (left != null) {
            getCharBinaryValue(values, left, new StringBuilder(builder + "0"));
        }

        if (right != null) {
            getCharBinaryValue(values, right, new StringBuilder(builder + "1"));
        }
    }

    /**
     * Making list of nodes from map of {symbol, count}
     */
    private List<Node> makeNodes(Map<Character, Integer> map) {
        List<Node> result = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Node node = new Node();
            node.setValue(entry.getKey());
            node.setCount(entry.getValue());
            node.setType(NodeType.VALUE_TYPE);
            result.add(node);
        }

        return result;
    }

    /**
     * Resolving text, getting symbols count
     */
    private Map<Character, Integer> getCharsCount(String text) {
        final Map<Character, Integer> charCountMap = new HashMap<>();

        char[] chars = text.toCharArray();

        for (Character ch : chars) {
            if (!charCountMap.containsKey(ch)) {
                charCountMap.put(ch, 1);
            } else {
                charCountMap.put(ch, charCountMap.get(ch) + 1);
            }
        }

        return charCountMap;
    }
}