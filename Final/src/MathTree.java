import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;

public class MathTree {
    private String fileName = "";
    private String fileContent;
    private String[] content;
    public Stack<String> s = new Stack<>();
    public Stack<String> a = new Stack<>();
    public Stack<String> o = new Stack<>();


    public MathTree(String file) {
        fileName = file;
    }

    void toInfix(String[] str) {

        for (int i = 0; i < str.length; i ++) {
            if ("p".equals(str[i])) {
                i += 0;
            } else if (!"p".equals(str[i]) &&
                    !"+".equals(str[i]) &&
                    !"-".equals(str[i]) &&
                    !"*".equals(str[i]) &&
                    !"/".equals(str[i])) {
                s.add(str[i]);

            } else if ("+".equals(str[i]) ||
                    "-".equals(str[i]) ||
                    "*".equals(str[i]) ||
                    "/".equals(str[i])) {
                String a = s.pop();
                String b = s.pop();
                String temp = "(" + a + " " + str[i] + " " + b + ")";
                s.add(temp);
            } else {
                System.out.println("entering else");
                break;
            }
        }
        System.out.println("infix " + s);

        for (int i = 0; i < s.size(); i ++) {
            s.pop();
        }
    }

    void toPostfix(String[] str) {
        int aCount = 0;
        int oCount = 0;

        for (int i = 0; i < str.length; i ++) {
            if ("i".equals(str[i])) {
                i += 0;
            } else if (!"i".equals(str[i]) &&
                    !"+".equals(str[i]) &&
                    !"-".equals(str[i]) &&
                    !"*".equals(str[i]) &&
                    !"/".equals(str[i])) {
                a.add(str[i]);
                aCount ++;

            } else if ("+".equals(str[i]) ||
                    "-".equals(str[i]) ||
                    "*".equals(str[i]) ||
                    "/".equals(str[i])) {
                o.add(str[i]);
                if (aCount % 2 == 0) {
                    String op = o.pop();
                    a.add(op);
                    oCount ++;

                    if (oCount % 2 == 0) {
                        op = o.pop();
                        a.add(op);
                        oCount ++;
                    }
                }

                else {
                    continue;
                }
            }

        }
        System.out.println(a);
    }

    void MathTreeUtil() {
        try {
            BufferedReader file = new BufferedReader(new FileReader(fileName));

            while(file.ready()) {
                fileContent = file.readLine();
                content = fileContent.split(" ");


                if ("p".equals(content[0])) {
//                    toInfix(content);
                } else {
                    toPostfix(content);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        MathTree m = new MathTree("inpostfix.txt");

        m.MathTreeUtil();

    }
}
