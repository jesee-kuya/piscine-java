import java.util.Scanner;
class String_capitalize {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       String sentence=sc.nextLine();
       String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) { 
            String firstLetter = words[i].substring(0, 1);
            String restOfWord = words[i].substring(1);
            firstLetter = firstLetter.toUpperCase();
            words[i] = firstLetter + restOfWord;
        }
        String capitalizedSentence = String.join(" ", words);
        System.out.println("Capitalized sentence: " + capitalizedSentence);
    }
}
