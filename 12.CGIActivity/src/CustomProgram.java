import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
public class CustomProgram {
    public static void main(String[] args) throws Exception {
        // reads the provided customPage.html into list
        Scanner in = new Scanner(new File("customPage.html"));
        ArrayList<String> list = new ArrayList<>();
        while(in.hasNextLine()) list.add(in.nextLine());
        // update list to reflect changes requested through command line args
        // TODO: Complete this section
        String name = null;
        if(args.length > 0)
            for(String arg : args[0].split("&")) {
                String[] keyValuePair = arg.split("=");
                switch(keyValuePair[0]) {
                case "name":
                    // TODO: when a greeting is selected (below), this
                    // arguments's value should be displayed in that greeting
                    if (keyValuePair.length == 2) {
                        name = keyValuePair[1];
                        continue;
                    }
                    break;
                case "background":
                    // TODO: when background="Dark", the body's color should be
                    // set to white and it's background-color should be set to
                    // black (the opposite of how they are set for "Light" by
                    // default.
                    String color1 = null;
                    String color2 = null;
                    if (keyValuePair.length == 2) {
                            if(keyValuePair[1] == "Dark") {
                                    for (String line: list) {
                                            String trimmed = line.trim();
                                            if (trimmed.startsWith("background-color")) {
                                                    String temp = line;
                                                    temp = temp.replace("background-color ", "");
                                                    color1 = temp;
                                            }
                                            if (trimmed.startsWith("color")) {
                                                    String temp = line;
                                                    temp = temp.replace("color: ", "");
                                                    color2 = temp;
                                            }
                                    }
                                    for (String line: list) {
                                            String trimmed = line.trim();
                                            if (trimmed.startsWith("background-color")) {
                                                    line = "background-color: " + color2 + ";";
                                            }
                                            if (trimmed.startsWith("color")) {
                                                    line = "color: " + color1 + ";";
                                            }
                                    }
                        }
                        continue;
                    }
                    break;
                case "Greeting":
                    // TODO: when this argument is present and =true, an <h1>
                    // element containing the text "Welcome Stranger" should
                    // be inserted as the first element within the body.  If
                    // a non-empty-string name is provided (see above), that
                    // name should be used in place of the word Stranger in
                    // this greeting.
                    if (keyValuePair.length == 2) {
                            if (keyValuePair[1] == "true") {
                                    if (name == null) {
                                            for (String line: list) {
                                                    String trimmed = line.trim();
                                                    if (trimmed.startsWith("body")) {
                                                            line += "\n<h1>Stranger</h1>";
                                                    }
                                            }
                                    } else {
                                            for (String line: list) {
                                                    String trimmed = line.trim();
                                                    if (trimmed.startsWith("body")) {
                                                            line += "\n<h1>" + name + "</h1>";
                                                    }
                                            }
                                    }
                            }
                            continue;
                    }
                    break;
                case "Time":
                    // TODO: when this argument is present and =true, a <p>
                    // element containing the text: "Page Updated: date-time"
                    // should be inserted as the last element within the body.
                    // Note that the date-time part of this paragraph should
                    // be dynamically generated by calling
                    // java.time.LocalDateTime.now()
                    if (keyValuePair.length == 2) {
                            if (keyValuePair[1] == "true") {
                                    boolean search = false;
                                    for (int i = 0; i < list.size(); i++) {
                                            String trimmed = list.get(i).trim();
                                            if (trimmed.startsWith("body")) {
                                                    search = true;
                                            }
                                            if (trimmed.startsWith("}")) {
                                                    list.add(i, "Page Updated: date-time");
                                                    break;
                                            }
                                    }
                            } else {
                                    break;
                            }
                            continue;
                    }
                    break;
                case "SuppressOptions":
                    // TODO: when this argument is present and =true, the
                    // customization controls should be removed from the page.
                    // Everything from and including the <h1> label through the
                    // final </ul> should be omitted to accomplish this.
                    if (keyValuePair.length == 2) {
                            if (keyValuePair[1] == "true") {
                                    for (String line: list) {
                                            String trimmed = line.trim();
                                            if (trimmed.startsWith("<h1>")) {
                                                    line = "";
                                            }
                                            if (trimmed.startsWith("<ul>")) {
                                                    line = "";
                                            }
                                            if (trimmed.startsWith("<li>")) {
                                                    line = "";
                                            }
                                            if (trimmed.startsWith("</ul>")) {
                                                    line = "";
                                            }
                                    }
                            }
                            continue;
                    }
                    break;
                }
            }
        // print the resulting html out to system.out (standard out)
        for(String line : list)
            System.out.println(line);
    }
}