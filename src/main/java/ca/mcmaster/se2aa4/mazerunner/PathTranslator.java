package ca.mcmaster.se2aa4.mazerunner;

public class PathTranslator {

    public PathTranslator() {}

    public void translateToFact(String canonical) {
        String result = "";
        Integer count = 1;

        for (Integer i = 1; i <= canonical.length(); i++) {
            if(i == canonical.length() || canonical.charAt(i) != canonical.charAt(i-1)) {
                result = result + count + canonical.charAt(i - 1) + " ";
                count = 1;
            } else {
                count++;
            }
        }
        System.out.println(result);
    }

    public String translateToCanon(String factorized) {
        String[] pathSplit = factorized.split("(?<=\\D)(?=\\d)");
        String result = "";
        Integer count = 0;

        for (String element : pathSplit) {
            count = element.charAt(0) - '0';
            for (Integer i = 0; i < count; i++) {
                result = result + element.charAt(1);
            }
        }
        return result;
    }
    
}
