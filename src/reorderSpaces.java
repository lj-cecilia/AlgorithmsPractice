import java.util.ArrayList;
import java.util.List;

class reorderSpaces {
    public String reorderSpaces(String text) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int spaces = 0;
        for (char ch : text.toCharArray()) {
            if (ch == ' ') {    //empty char
                if (sb.length() != 0)list.add(sb.toString());
                sb = new StringBuilder();
                spaces++;
            }
            else {
                sb.append(ch);
            }
        }
        if (sb.length() != 0) list.add(sb.toString());

        int size = list.size() - 1;
        int space = (size == 0)? spaces : spaces / size;
        int extra = (size == 0)? spaces : spaces % size;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(list.get(i));
            result.append(" ".repeat(space));
        }
        result.append(list.get(list.size() - 1));
        result.append(" ".repeat(extra));

        return result.toString();
    }
}