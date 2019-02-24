package IntellectualSystem;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    private Integer patternAmountValue = 0;
    private Integer rulesAmountValue = 0;
    private Integer patternLengthValue = 6;
    private Integer rulesLengthValue = 3;
    private Boolean fullSearch;
    ToggleGroup searchTypeGroup;
    @FXML
    public TextField patternAmount;
    public TextField patternLength;
    public TextField rulesAmount;
    public TextField rulesLength;
    public TextArea patternList;
    public TextArea rulesList;
    public TextArea approved;
    public TextArea declined;
    public RadioButton full;
    public RadioButton part;
    public ProgressBar progress;

    public void initialize() {
        searchTypeGroup = new ToggleGroup();
        full.setToggleGroup(searchTypeGroup);
        part.setToggleGroup(searchTypeGroup);
    }

    /**
     * Getting length and amount values for generating strings
     * @return boolean
     */
    private boolean parseAmount() {
        if (patternAmount.getText().length() > 0) {
            patternAmountValue = Integer.parseInt(patternAmount.getText());
        }

        if (patternLength.getText().length() > 0) {
            patternLengthValue = Integer.parseInt(patternLength.getText());
        }

        if (rulesAmount.getText().length() > 0) {
            rulesAmountValue = Integer.parseInt(rulesAmount.getText());
        }

        if (rulesLength.getText().length() > 0) {
            rulesLengthValue = Integer.parseInt(rulesLength.getText());
        }

        if (patternAmountValue > 0 && rulesAmountValue > 0) {
            return true;
        }
        return false;
    }

    /**
     * Generating patterns
     */
    public void generatePatterns() {
        if (parseAmount()) {
            patternList.clear();
            for (Integer i = 1; i <= patternAmountValue; i = i + 1) {
                if (i != patternAmountValue) {
                    patternList.appendText(Generator.generate(patternLengthValue) + "\n");
                } else {
                    patternList.appendText(Generator.generate(patternLengthValue));
                }
            }
        }
    }

    /**
     * Generating rules strings
     */
    public void generateRules() {
        if (parseAmount()) {
            rulesList.clear();
            for (Integer i = 1; i <= rulesAmountValue; i = i + 1) {
                if (i != rulesAmountValue) {
                    rulesList.appendText(Generator.generate(rulesLengthValue) + "\n");
                } else {
                    rulesList.appendText(Generator.generate(rulesLengthValue));
                }
            }
        }
    }

    /**
     * Check searching type
     */
    public void checkSearchType() {
        if (part.isSelected()) {
            fullSearch = false;
        }
        if (full.isSelected()) {
            fullSearch = true;
        }
    }

    /**
     * Run process
     */
    public void process() {
        progress.setProgress(0.1);
        checkSearchType();
        if (patternList.getText().length() <= 0) {
            generatePatterns();
        }
        if (rulesList.getText().length() <= 0) {
            generateRules();
        }
        progress.setProgress(0.5);
        System.out.println(fullSearch.toString());
        String[] patterns = patternList.getText().split("\n");
        String[] rules = rulesList.getText().split("\n");
        Validator.validate(patterns, rules);
        progress.setProgress(1);
    }
}
