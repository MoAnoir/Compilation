import java.util.Arrays;
import java.util.List;

public class Parser {
    private List<String> tokens;
    private int position = 0;

    public Parser(String input) {
        this.tokens = Arrays.asList(input.split(" "));
    }

    private String currentToken() {
        if (position < tokens.size()) {
            return tokens.get(position);
        }
        return null;
    }

    private boolean match(String expected) {

        if (expected.equals(currentToken())) {
            position++;
            return true;
        }
        return false;
    }
    private boolean parseArticle() {
        return match("le") || match("la") || match("les") ||
                match("une") || match("un") || match("des");
    }
    // <nom> ::= "souris" | "fromage"
    private boolean parseNom() {
        return match("souris") || match("fromage");
    }
    // <verbe> ::= "mange" | "mangent"
    private boolean parseVerbe() {
        return match("mange") || match("mangent");
    }
    // <sujet> ::= <article> <nom>
    private boolean parseSujet() {
        int startPosition = position;
        if (parseArticle() && parseNom()) {
            return true;
        }
        position = startPosition; // Revenir en arrière en cas d'échec
        return false;
    }
    // <complement> ::= <article> <nom>
    private boolean parseComplement() {
        int startPosition = position;
        if (parseArticle() && parseNom()) {
            return true;
        }
        position = startPosition; // Revenir en arrière en cas d'échec
        return false;
    }
    // <phrase> ::= <sujet> <verbe> <complement>
    public boolean parsePhrase() {
        int startPosition = position;
        if (parseSujet() && parseVerbe() && parseComplement()) {
            return true;
        }
        position = startPosition; // Revenir en arrière en cas d'échec
        return false;
    }


}
