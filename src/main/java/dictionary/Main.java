package dictionary;

public class Main {
    public static void main (String[] args) {
        testAdd();
        testGetCommonPrefix();
        testToString();
        testCheck();
        testCheckPrefix();

    }
    private static CompactPrefixTree compactPrefixTree;
    private static void testAdd() {
        CompactPrefixTree tree = new CompactPrefixTree();
        tree.add("ham");
        System.out.println("Tree: ");
        System.out.println(tree);
        tree.add("hamster");
        System.out.println("Tree: ");
        System.out.println(tree);
        tree.add("hamburger");
        System.out.println("Tree: ");
        System.out.println(tree);
        System.out.println("----------------");
    }
    private static void testGetCommonPrefix() {
        System.out.println();
        String s1 = "catastrophe";
        String s2 = "cater";
        int i = 0;
        while (s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        System.out.println(s1.substring(0, i));
        System.out.println("----------------");
    }

    private static void testToString() {
        String[] words = {"cat", "car", "cart", "ape", "apple", "dog", "demon", "demons"};
        compactPrefixTree = new CompactPrefixTree();
        for (String word : words) {
            compactPrefixTree.add(word);
        }
        System.out.println(compactPrefixTree.toString());
        System.out.println("----------------");
    }

    private static void testCheck() {
        String[] words = {"cat", "car", "cart", "ape", "apple", "dog", "demon", "demons"};
        compactPrefixTree = new CompactPrefixTree();
        for (String word : words) {
            compactPrefixTree.add(word);
        }
        System.out.println("True: " + compactPrefixTree.check("cat"));
        System.out.println("False: " + compactPrefixTree.check("catastrophe"));
        System.out.println("False: " + compactPrefixTree.check("bat"));
        System.out.println("True: " + compactPrefixTree.check("apple"));
        System.out.println("----------------");
    }

    private static void testCheckPrefix() {
        String[] words = {"cat", "car", "cart", "ape", "apple", "dog", "demon", "demons"};
        compactPrefixTree = new CompactPrefixTree();
        for (String word : words) {
            compactPrefixTree.add(word);
        }
        System.out.println("True: " + compactPrefixTree.checkPrefix("ca"));
        System.out.println("False: " + compactPrefixTree.checkPrefix("character"));
        System.out.println("False: " + compactPrefixTree.checkPrefix("bat"));
        System.out.println("True: " + compactPrefixTree.checkPrefix("ap"));
        System.out.println("----------------");
    }



}
