package step.text.analyzer;

public class Main {
    //test
    public static void main(String... args) {
        // инициализация анализаторов для проверки в порядке данного набора анализаторов
        String[] spamKeywords = {"spam", "bad"};
        int commentMaxLength = 40;
        TextAnalyzer[] textAnalyzers1 = {
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers2 = {
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers3 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers4 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords)
        };
        TextAnalyzer[] textAnalyzers5 = {
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers6 = {
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords)
        };
        // тестовые комментарии
        String[] tests = new String[8];
        tests[0] = "This comment is so good.";                            // OK
        tests[1] = "This comment is so Loooooooooooooooooooooooooooong."; // TOO_LONG
        tests[2] = "Very negative comment !!!!=(!!!!;";                   // NEGATIVE_TEXT
        tests[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;";    // NEGATIVE_TEXT or TOO_LONG
        tests[4] = "This comment is so bad....";                          // SPAM
        tests[5] = "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!";  // SPAM or TOO_LONG
        tests[6] = "Negative bad :( spam.";                               // SPAM or NEGATIVE_TEXT
        tests[7] = "Very bad, very neg =(, very ..................";      // SPAM or NEGATIVE_TEXT or TOO_LONG
        TextAnalyzer[][] textAnalyzers = {textAnalyzers1, textAnalyzers2, textAnalyzers3,
                textAnalyzers4, textAnalyzers5, textAnalyzers6};
        Main testObject = new Main();
        int numberOfAnalyzer; // номер анализатора, указанный в идентификаторе textAnalyzers{№}
        int numberOfTest = 0; // номер теста, который соответствует индексу тестовых комментариев
        for (String test : tests) {
            numberOfAnalyzer = 1;
            System.out.print("test #" + numberOfTest + ": ");
            System.out.println(test);
            for (TextAnalyzer[] analyzers : textAnalyzers) {
                System.out.print(numberOfAnalyzer + ": ");
                System.out.println(testObject.checkLabels(analyzers, test));
                numberOfAnalyzer++;
            }
            numberOfTest++;
        }
    }

        public TextAnalyzer.Label checkLabels(TextAnalyzer[] analyzers, String text) {
            for (TextAnalyzer anal : analyzers) {
                TextAnalyzer.Label res;
                if ((res = anal.processText(text)) != TextAnalyzer.Label.OK) {
                    return res;
                }
            }
            return TextAnalyzer.Label.OK;
        }

}
    abstract class KeywordAnalyzer implements TextAnalyzer {
        abstract protected String[] getKeywords();
        abstract protected Label getLabel();

        @Override
        public Label processText(String text) {
            String[] keywords = getKeywords();
            for (int i = 0; i < keywords.length; i++) {
                if (text.indexOf(keywords[i]) != -1) {
                    return getLabel();
                }
            }
            return Label.OK;
        }

    }

    class SpamAnalyzer extends KeywordAnalyzer {
        private String[] keywords;
        private Label label = Label.SPAM;

        public SpamAnalyzer(String[] keywords) {
            this.keywords = keywords;
        }

        protected String[] getKeywords() {
            return this.keywords;
        }

        protected Label getLabel() {
            return this.label;
        }

    }

    class NegativeTextAnalyzer extends KeywordAnalyzer {
        private String[] keywords = {":(", "=(", ":|"};
        private Label label = Label.NEGATIVE_TEXT;

        protected String[] getKeywords() {
            return this.keywords;
        }

        protected Label getLabel() {
            return this.label;
        }

    }

    class TooLongTextAnalyzer implements TextAnalyzer {
        private int maxLength;

        public TooLongTextAnalyzer(int size) {
            this.maxLength = size;
        }

        @Override
        public Label processText(String text) {
            return (text.length() > this.maxLength) ? Label.TOO_LONG : Label.OK;
        }

    }
