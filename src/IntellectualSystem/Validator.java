package IntellectualSystem;

public class Validator {
    private String[] approved;
    private String[] declined;
    public static void validate(String[] patterns, String[] rules) {
        Boolean isValid = false;
        for (String pattern: patterns) {
            System.out.println(pattern);
        }
    }

    public String[] getApproved() {
        return approved;
    }

    public String[] getDeclined() {
        return declined;
    }
}
