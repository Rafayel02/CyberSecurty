package org.example.hamming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.example.util.MathUtil.isPowerOfTwo;

public class Hamming {

    public static LinkedList<BitNode> encode(String data) {
        LinkedList<BitNode> nodes = new LinkedList<>();

        char[] chars = data.toCharArray();

        int index = 1;
        int count = chars.length - 1;

        while (count != -1) {
            if (isPowerOfTwo(index)) {
                nodes.add(0, new BitNode(-1, index));
            } else {
                nodes.add(0, new BitNode(Integer.parseInt(String.valueOf(chars[count--])), index));
            }

            index++;
        }

        for (int i = 0; i < nodes.size(); i++) {
            BitNode node = nodes.get(i);
            if (node.getBitValue() == -1) {
                List<Integer> values = new ArrayList<>();
                for (BitNode bitNode : nodes) {
                    if (node == bitNode) continue;
                    if ((node.getIndex() & bitNode.getIndex()) == node.getIndex()) {
                        values.add(bitNode.getBitValue());
                    }
                }

                int value = values.get(0);
                for (int j = 1; j < values.size(); j++) {
                    value = value ^ values.get(j);
                }

                node.setBitValue(value);
            }
        }

        return nodes;
    }

    public static String bitsAsString(LinkedList<BitNode> nodes) {
        StringBuilder result = new StringBuilder();
        for (BitNode node : nodes) {
            result.append(node.getBitValue());
        }
        return result.toString();
    }

    public static String findErrorIndex(LinkedList<BitNode> encoded) {

        List<Integer> values = new ArrayList<>();
        for (BitNode bitNode : encoded) {
            if (bitNode.getBitValue() == 1) {
                values.add(bitNode.getIndex());
            }
        }

        if (!values.isEmpty()) {
            int value = values.get(0);
            for (int i = 1; i < values.size(); i++) {
                Integer next = values.get(i);
                value = value ^ next;
            }
            return value + "";
        }

        return "0";
    }

    public static void changeBit(LinkedList<BitNode> encodedBits, int i) {
        if (i < 0 || i > encodedBits.size()) {
            System.out.println("Please specify a valid index!");
            return;
        }
        BitNode bitNode = encodedBits.get(encodedBits.size() - i);
        bitNode.setBitValue(bitNode.getBitValue() == 1 ? 0 : 1);
    }

    public static class BitNode {
        private int bitValue;
        private int index;


        public BitNode(int bitValue, int index) {
            this.bitValue = bitValue;
            this.index = index;
        }

        public int getBitValue() {
            return bitValue;
        }

        public void setBitValue(int bitValue) {
            this.bitValue = bitValue;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        @Override
        public String toString() {
            return bitValue + "";
//                    + " i" + index;
        }
    }

}
