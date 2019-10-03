
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        String text = "SMS messages are really short";
        int delimiter = 12;
        System.out.println(new Test2().solution(text, delimiter));
    }

    public Integer solution(String s, int k) {


        if (!checkText(s, k)) return -1;  // Check input parameters


        List<String> messages = new ArrayList<>();   // List for final messages
        List<String> words = new ArrayList<>(Arrays.asList(s.split("")));  // List for symbols from text

        StringBuilder temp = new StringBuilder();   // StringBuilder for build short messages


        messages.add(addSymbol(words, 0, temp.toString(), k));

        System.out.println(messages);

        return messages.size();
    }

    private Boolean checkText(String text, int k) {


        if (text == null || text.isEmpty()) return false;

        String[] words = text.split(" ");
        for (String w : words) {
            if (w.length() > k) return false;
        }

        return true;
    }


    protected String addSymbol(List<String> words, int index, String temp,  int k) {

        StringBuilder sb = new StringBuilder();

        sb.append(words.get(index));

        if (sb.length() > k) {
            return deleteSymbol(sb.toString());
        }

        else {
            if(index == words.size() -1) return sb.toString();
            else addSymbol(words, index+1, sb.toString(), k);
        }

        return sb.toString();
    }

    protected String deleteSymbol(String s) {

        StringBuilder sb = new StringBuilder(s);

        while (!sb.toString().endsWith(" ")) {
            sb.delete(sb.length() - 1, sb.length());
        }

        return sb.toString();
    }

}


