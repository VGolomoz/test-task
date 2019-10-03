import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        String text = "SMS messages are really short";
        int delimiter = 12;
        System.out.println(new Test().solution(text, delimiter));
    }


    public Integer solution(String s, int k) {

        if (!checkText(s, k)) return -1;  // private method for check input parameters

        List<String> messages = new ArrayList<>();   // List for final messages
        List<String> words = new ArrayList<>(Arrays.asList(s.split("")));  // List for symbols from text

        StringBuilder sb = new StringBuilder();   // StringBuilder for build short messages

        for (int i = 0; i < words.size(); i++) {

            if (sb.length() <= k) {

                if (sb.length() == k) {
                    if (words.get(i).equals(" ")) {
                        messages.add(sb.toString());
                        sb.delete(0, sb.length());
                    } else {

                        while (!sb.toString().endsWith(" ")) {
                            sb.delete(sb.length() - 1, sb.length());
                            i--;
                        }

                        sb.delete(sb.length() - 1, sb.length());
                        messages.add(sb.toString());
                        sb.delete(0, sb.length());
                        i--;
                    }

                } else {
                    sb.append(words.get(i));
                }
            }
        }

        messages.add(sb.toString());

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
}
