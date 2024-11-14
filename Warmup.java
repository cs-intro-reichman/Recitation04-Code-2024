public class Warmup {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello world"));
        System.out.println("Intro to computer science");
        System.out.println(" Strings      are  great   ");
        System.out.println("   a ");
        System.out.println(" test ");
    }

    // Question 1
    public static int lengthOfLastWord(String sentence){
        int end = sentence.length() - 1;
        while (end >= 0) {
            if (sentence.charAt(end) != ' ') {
                break;
            }
            end--;
        }
        int start = end;
        while (start >= 0) {
            if (sentence.charAt(start) == ' ') {
                break;
            }
		    start--;
	    }	
        return end - start; 
    }
}