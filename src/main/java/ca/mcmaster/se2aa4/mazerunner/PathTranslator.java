package ca.mcmaster.se2aa4.mazerunner;

public class PathTranslator {

    public PathTranslator() {

    }

    // ex. canonical = "FFFRRFLF"
    public void translateToFact(String canonical) {
        String result = "";
        Integer count = 1;

        for (Integer i = 1; i <= canonical.length(); i++) {
            if(i == canonical.length() || canonical.charAt(i) != canonical.charAt(i-1)) {
                result = result + count + canonical.charAt(i-1) + " ";
                count = 1;
            } else {
                count++;
            }
        }
        System.out.println(result);
    }
    
}
