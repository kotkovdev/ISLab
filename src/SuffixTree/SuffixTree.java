package SuffixTree;

import java.util.TreeMap;

public class SuffixTree {
    private Integer entry = -1;
    private static TreeMap<String, String> suffixMap = new TreeMap<>();

    public SuffixTree(String string) {
        for (Integer i = 0; i <= string.length(); i += 1) {
            String parsedString = string.substring(i);
            for (Integer iterator = 0; iterator <= parsedString.length(); iterator += 1) {
                String substr = parsedString.substring(0, parsedString.length() - iterator);
                if (substr.length() > 0) {
                    suffixMap.put(substr, substr);
                }
            }
        }
    }

    public boolean search(String substr) {
        entry = -1;
        Integer iterator = 0;
        for (String item: suffixMap.values()) {
            if (substr.equals(item)) {
                entry = iterator;
                //System.out.println(item + ":" + substr);
                suffixMap.remove(item);
                return true;
            }
            iterator += 1;
        }
        return false;
    }

}
