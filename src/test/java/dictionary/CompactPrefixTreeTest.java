package dictionary;

import junit.framework.TestCase;



public class CompactPrefixTreeTest extends TestCase {

    public void testGetCommonPrefix() {
        String s1 = "catastrophe";
        String s2 = "cater";
        int i = 0;
        while (s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        System.out.println(s1.substring(0, i));
    }
}