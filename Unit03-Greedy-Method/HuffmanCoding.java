import java.util.*;

public class HuffmanCoding {
    private static class Node implements Comparable<Node> {
        char ch;
        int frequency;
        Node left, right;

        Node(char ch, int frequency) {
            this.ch = ch;
            this.frequency = frequency;
        }

        Node(Node left, Node right) {
            this.left = left;
            this.right = right;
            this.frequency = left.frequency + right.frequency;
        }

        boolean isLeaf() {
            return left == null && right == null;
        }

        public int compareTo(Node other) {
            return Integer.compare(frequency, other.frequency);
        }
    }

    public static Map<Character, String> buildCodes(String text) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : text.toCharArray())
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> e : frequency.entrySet())
            pq.offer(new Node(e.getKey(), e.getValue()));

        if (pq.isEmpty()) return new HashMap<>();

        while (pq.size() > 1)
            pq.offer(new Node(pq.poll(), pq.poll()));

        Map<Character, String> codes = new HashMap<>();
        buildCodes(pq.poll(), "", codes);
        return codes;
    }

    private static void buildCodes(Node node, String code, Map<Character, String> codes) {
        if (node.isLeaf()) {
            codes.put(node.ch, code.isEmpty() ? "0" : code);
            return;
        }
        buildCodes(node.left, code + "0", codes);
        buildCodes(node.right, code + "1", codes);
    }
}
