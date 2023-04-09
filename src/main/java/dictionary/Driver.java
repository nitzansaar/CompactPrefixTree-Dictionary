package dictionary;

/**
 * The Driver class for CompactPrefixTree
 */
public class Driver {
    public static void main(String[] args) {
//            Dictionary dict = new CompactPrefixTree();
//            dict.add("cat");
//            dict.add("cart");
//            dict.add("carts");
//            dict.add("case");
//            dict.add("doge");
//            dict.add("doghouse");
//            dict.add("wrist");
//            dict.add("wrath");
//            dict.add("wristle");
//            System.out.println(dict);
//            System.out.println("----------------");
//            testGetCommonPrefix();
//            testToString();
//            testCheck();
//            testCheckPrefix();
        testSuggest();
    }

    private static CompactPrefixTree d;

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
        d = new CompactPrefixTree();
        for (String word : words) {
            d.add(word);
        }
        System.out.println(d.toString());
        System.out.println("----------------");
    }

    private static void testCheck() {
        String[] words = {"cat", "car", "cart", "ape", "apple", "dog", "demon", "demons"};
        d = new CompactPrefixTree();
        for (String word : words) {
            d.add(word);
        }
        System.out.println("True: " + d.check("cat"));
        System.out.println("False: " + d.check("catastrophe"));
        System.out.println("False: " + d.check("bat"));
        System.out.println("True: " + d.check("apple"));
        System.out.println("----------------");
    }

    private static void testCheckPrefix() {
        String[] words = {"cat", "car", "cart", "ape", "apple", "dog", "demon", "demons"};
        d = new CompactPrefixTree();
        for (String word : words) {
            d.add(word);
        }
        System.out.println("True: " + d.checkPrefix("ca"));
        System.out.println("False: " + d.checkPrefix("character"));
        System.out.println("False: " + d.checkPrefix("bat"));
        System.out.println("True: " + d.checkPrefix("ap"));
        System.out.println("----------------");
    }

    private static void testSuggest() {
        String filename = "input/words_ospd.txt";
        Dictionary d = new CompactPrefixTree(filename);
        String[] goodWords = {"cat", "baseball", "original"};
        for (String word : goodWords) {
            d.add(word);
        }
        System.out.println("There should only be 1 suggestion because these words are already in the dictionary");
        for (String goodWord : goodWords) {
            String[] result = d.suggest(goodWord, 6);
            System.out.println("Suggestions for \"" + goodWord + "\":");
            for (int i = 0; i < result.length; i++) {
                System.out.println(i + ": " + result[i]);
            }
        }
        System.out.println("There should be 6 suggestions");
        String[] badWords = {"accer", "fatte", "flox", "forg", "forsoom"};
        for (String badWord : badWords) {
            String[] result = d.suggest(badWord, 6);
            System.out.println("Suggestions for \"" + badWord + "\":");
            for (int i = 0; i < result.length; i++) {
                System.out.println(i + ": " + result[i]);
            }
        }
    }
}
