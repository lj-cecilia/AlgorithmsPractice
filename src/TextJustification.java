import java.util.ArrayList;
import java.util.List;

class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> temp = new ArrayList<>();
        List<String> result = new ArrayList<>();
        int length = 0;

        for (String word : words) {
            //length = all letters length, word length = new characters, temp = space count
            //exceed maxWidth
            if (length + word.length() + temp.size() > maxWidth) {
                int spaces = maxWidth - length;
                //number of times we need to insert spaces, always 1 smaller than word count
                int count = temp.size() - 1;
                if (count == 0) {
                    result.add(temp.get(0) + " ".repeat(spaces));
                }
                else {
                    int meanSpaces = spaces / count;
                    int extraSpaces = spaces % count;
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < count; i++) {
                        sb.append(temp.get(i));
                        sb.append(" ".repeat(meanSpaces));
                        if (i < extraSpaces) {
                            sb.append(" ");
                        }
                    }
                    sb.append(temp.get(temp.size() - 1)); //append the last word without spaces
                    result.add(sb.toString());
                }
                // temp = new ArrayList<>();   //equivalent to
                temp.clear();
                length = 0;
            }
            //now for both continue to add or just finish the last string
            //update the length and add the word
            length += word.length();    //include this word in this line
            temp.add(word);

        }

        //last line only needs to have one space in between each word
        //then add spaces for any extra space
        StringBuilder lastLine = new StringBuilder(String.join(" ", temp));
        while (lastLine.length() < maxWidth) {
            lastLine.append(" ");
        }
        result.add(lastLine.toString());
        return result;
    }
}