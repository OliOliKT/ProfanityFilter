import java.util.Scanner;
import java.util.ArrayList;

public class ProfanityFilter {

    public static void main(String[] args) {    
        Scanner input = new Scanner(System.in);
        ArrayList<String> swearWords = new ArrayList<String>();
        ArrayList<String> inputWords = new ArrayList<String>();
        
        // Alle ord på øverste linje bliver lagt ind i en array
        String swearWordString = input.nextLine();
        for (String word : swearWordString.split(" ")) {
            swearWords.add(word.toLowerCase());
        }

        // Alle ord på de resterende linjer bliver lagt ind i en array
        String[] line;
        while (input.hasNextLine()) {
            line = input.nextLine().split(" ");
            for (String word : line) {
                inputWords.add(word);
            }
            // Tilføjer linjeskift ved hvert linjeskift
            inputWords.add("\n");
        }

        // Alle ord på de resterende linjer, som også er på øverste linje, bliver erstattet med "*&#$%"
        for (String word : inputWords) {
            
            if (word.endsWith(".") || word.endsWith("!") || word.endsWith(",") || word.endsWith("?")) {
                    if (swearWords.contains(word.substring(0, word.length() - 1).toLowerCase())) {
                        String str = "";
                        for(int i=0;i<word.length()-1;i++){
                            str+="*";
                            if(str.length()==word.length()-1){
                                break;
                            }
                            str+="&";
                            if(str.length()==word.length()-1){
                                break;
                            }
                            str+="#";
                            if(str.length()==word.length()-1){
                                break;
                            }
                            str+="$";
                            if(str.length()==word.length()-1){
                                break;
                            }
                            str+="%";
                            if(str.length()==word.length()-1){
                                break;
                            }
                        }
                        str += word.substring(word.length() - 1);
                        inputWords.set(inputWords.indexOf(word), str);
                    }
                }    
            else if (swearWords.contains(word.toLowerCase())) {
                String str = "";
                for(int i=0;i<word.length();i++){
                    str+="*";
                    if(str.length()==word.length()){
                        break;
                    }
                    str+="&";
                    if(str.length()==word.length()){
                        break;
                    }
                    str+="#";
                    if(str.length()==word.length()){
                        break;
                    }
                    str+="$";
                    if(str.length()==word.length()){
                        break;
                    }
                    str+="%";
                    if(str.length()==word.length()){
                        break;
                    }
                }
                inputWords.set(inputWords.indexOf(word), str);
            } 
        }

        input.close();

        String listString = String.join(" ", inputWords);
        listString = listString.replace("\n ", "\n");
        System.out.println(listString);
    }
}

// ctrl + d for afslut