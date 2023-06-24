import java.util.*;

class HuffmanNode implements Comparable<HuffmanNode> {
    char character;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }
}

public class HuffmanCoding {
    private static Map<Character, String> encodeHuffmanTree(HuffmanNode root) {
        Map<Character, String> huffmanCodes = new HashMap<>();
        encodeHuffmanTreeRec(root, "", huffmanCodes);
        return huffmanCodes;
    }

    private static void encodeHuffmanTreeRec(HuffmanNode node, String code, Map<Character, String> huffmanCodes) {
        if (node.isLeaf()) {
            huffmanCodes.put(node.character, code);
            return;
        }

        encodeHuffmanTreeRec(node.left, code + "0", huffmanCodes);
        encodeHuffmanTreeRec(node.right, code + "1", huffmanCodes);
    }

    private static HuffmanNode buildHuffmanTree(Map<Character, Integer> charFrequencies) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();

        for (Map.Entry<Character, Integer> entry : charFrequencies.entrySet()) {
            char character = entry.getKey();
            int frequency = entry.getValue();
            pq.add(new HuffmanNode(character, frequency));
        }

        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();

            HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;

            pq.add(parent);
        }

        return pq.poll();
    }

    public static String encode(String text) {
        Map<Character, Integer> charFrequencies = new HashMap<>();

        for (char c : text.toCharArray()) {
            charFrequencies.put(c, charFrequencies.getOrDefault(c, 0) + 1);
        }

        HuffmanNode root = buildHuffmanTree(charFrequencies);
        Map<Character, String> huffmanCodes = encodeHuffmanTree(root);

        StringBuilder encodedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            encodedText.append(huffmanCodes.get(c));
        }

        return encodedText.toString();
    }

    public static String decode(String encodedText, HuffmanNode root) {
        StringBuilder decodedText = new StringBuilder();
        HuffmanNode current = root;

        for (char bit : encodedText.toCharArray()) {
            if (bit == '0') {
                current = current.left;
            } else if (bit == '1') {
                current = current.right;
            }

            if (current.isLeaf()) {
                decodedText.append(current.character);
                current = root;
            }
        }

        return decodedText.toString();
    }

    public static void main(String[] args) {
        String text = "Hello, world!";
        System.out.println("Original text: " + text);

        String encodedText = encode(text);
        System.out.println("Encoded text: " + encodedText);

        Map<Character, Integer> charFrequencies = new HashMap<>();
        for (char c : text.toCharArray())
            charFrequencies.put(c, charFrequencies.getOrDefault(c, 0) + 1);

        HuffmanNode root = buildHuffmanTree(charFrequencies);
        String decodedText = decode(encodedText, root);
        System.out.println("Decoded text: " + decodedText);
    }
}
