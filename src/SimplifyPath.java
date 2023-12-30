import java.util.Stack;

class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        //solve all the slashes
        String[] arr = path.split("/");
        int l = arr.length;

        for (int i = 0; i < l; i++) {
            //meet a command to cancel the current level
            if (!s.isEmpty() && arr[i].equals(".."))
                s.pop();
            else if (!arr[i].equals("") && !arr[i].equals(".") && !arr[i].equals(".."))
                s.push(arr[i]);
        }

        if (s.isEmpty()) return "/";
        while (!s.isEmpty()) {
            sb.insert(0, s.pop());
            sb.insert(0, "/");
        }

        return sb.toString();
    }
}