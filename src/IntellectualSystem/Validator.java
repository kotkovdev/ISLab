package IntellectualSystem;

import SuffixTree.SuffixTree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Validator {
    private static TreeMap approved;
    private static TreeMap declined ;
    private boolean fullSearch = true;
    public Validator() {
        approved = new TreeMap<String, String>();
        declined = new TreeMap<String, String>();
    }

    public void validate(String[] patterns, String[] rules) throws Exception {
        if (fullSearch) {
            for (String pattern: patterns) {
                approved.put(pattern, pattern);
                for (String rule: rules) {
                    if (pattern.equals(rule)) {
                        declined.put(pattern, pattern);
                        approved.remove(pattern);
                    }
                }
            }
        } else {
            for (String pattern: patterns) {
                SuffixTree suffixTree = new SuffixTree(pattern);
                approved.put(pattern, pattern);
                for (String rule: rules) {
                    if (suffixTree.search(rule)) {
                        try {
                            declined.put(pattern, pattern);
                            approved.remove(pattern);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    }
                }
            }
        }
    }

    public void setFull() {
        fullSearch = true;
    }

    public void setPart() {
        fullSearch = false;
    }

    public TreeMap getApproved() {
        return approved;
    }

    public TreeMap getDeclined() {
        return declined;
    }
}
