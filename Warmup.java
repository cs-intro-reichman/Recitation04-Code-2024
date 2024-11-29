public class Warmup {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello world"));
        System.out.println(lengthOfLastWord("Intro to computer science"));
        System.out.println(lengthOfLastWord(" Strings      are  great   "));
        System.out.println(lengthOfLastWord("   a "));
        System.out.println(lengthOfLastWord(" test "));
        System.out.println(lengthOfLastWord("test"));
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