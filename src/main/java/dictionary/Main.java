package dictionary;

public class Main {
    public static void main (String[] args) {
        testAdd();
        testGetCommonPrefix();
    }
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

    }

}
