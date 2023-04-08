package dictionary;

/** The Driver class for CompactPrefixTree */
public class Driver {
    public static void main(String[] args) {
            Dictionary dict = new CompactPrefixTree();
            dict.add("cat");
            dict.add("cart");
            dict.add("carts");
            dict.add("case");
            dict.add("doge");
            dict.add("doghouse");
            dict.add("wrist");
            dict.add("wrath");
            dict.add("wristle");
            System.out.println(dict);
            System.out.println("----------------");
            testGetCommonPrefix();
            testToString();
            testCheck();
            testCheckPrefix();
    }
        private static CompactPrefixTree compactPrefixTree;

        private static void testGetCommonPrefix() {
                String s1 = "catastrophe";
                String s2 = "cater";
                int i = 0;
                while (s1.charAt(i) == s2.charAt(i)) {
                        i++;
                }
                System.out.println("cat: " + s1.substring(0, i));
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
