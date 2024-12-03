//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Tester avec des phrases
        String[] phrases = {
                "le chat mange le fromage",
                "une souris mange du fromage",
                "le fromage mange la souris", // Phrase invalide
                "le fromage des souris"       // Phrase invalide
        };

        for (String phrase : phrases) {
            Parser parser = new Parser(phrase);
            if (parser.parsePhrase()) {
                System.out.println("\"" + phrase + "\" est une phrase valide !");
            } else {
                System.out.println("\"" + phrase + "\" est une phrase invalide !");
            }
        }
    }
}