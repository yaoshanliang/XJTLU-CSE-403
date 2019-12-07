package coursework;

/**
 *
 * @author shanliang.yao19
 * @date 25/09/2019
 */
public class CourseWork {

   // “coord”, “weather”, “main”, “wind” are JSON objects. Print these objects and
    // their contents, formatted similarly to how they appear in a text editor.
    // Print the values for temperature, pressure, and the City name.

    static String jsonString = "{\"coord\":{\"lon\":-0.13,\"lat\":51.51},\"weather\":[{\"id\":520,\"main\":\"Rain\",\"description\":\"light intensity shower rain\",\"icon\":\"09d\"}],\"base\":\"stations\",\"main\":{\"temp\":293.04,\"pressure\":1003,\"humidity\":77,\"temp_min\":289.26,\"temp_max\":296.48},\"visibility\":10000,\"wind\":{\"speed\":3.1},\"clouds\":{\"all\":74},\"dt\":1569148567,\"sys\":{\"type\":1,\"id\":1414,\"message\":0.0198,\"country\":\"GB\",\"sunrise\":1569131156,\"sunset\":1569175255},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";

    public static void main(String[] args) {
        printValue("coord");
        
        printValue("weather");

        printValue("main");

        printValue("wind");

        printValue("temp");

        printValue("pressure");

        printValue("name");
    }

    // print the value of the given key.
    public static void printValue(String string) {
        String array[] = jsonString.split(string + "\":");

        // if the string contains the parameter string then do the following process,
        // else do nothing.
        if (array.length > 1) {

            // if the string contains more than one given value, then loop to print.
            for (int index = 1; index < array.length; index++) {
                String insideString = array[index];
                
                System.out.print("\"" + string + "\": ");

                // only one string
                if (insideString.indexOf('\"') == 0) {
                    System.out.print(insideString.split(",")[0]);
                    System.out.print("\n");
                } else {
                    String eachChar[] = insideString.split("");
                    int flag = 0;
                    for (int i = 0; i < eachChar.length; i++) {
                        switch (eachChar[i]) {
                            case "{":
                            case "[":
                                flag++;
                                eachChar[i] = eachChar[i].replace("{", "{\n");
                                eachChar[i] = eachChar[i].replace("[", "[\n");

                                System.out.print(eachChar[i]);
                                for (int j = 0; j < flag; j++) {
                                    System.out.print("\t");
                                }
                                break;

                            case "}":
                            case "]":
                                flag--;
                                System.out.print("\n");

                                for (int j = 0; j < flag; j++) {
                                    System.out.print("\t");
                                }
                                System.out.print(eachChar[i]);
                                break;

                            case ":":
                                System.out.print(eachChar[i] + " ");

                                break;

                            case ",":
                                System.out.print(eachChar[i]);

                                System.out.print("\n");
                                for (int j = 0; j < flag; j++) {
                                    System.out.print("\t");
                                }
                                break;

                            default:
                                System.out.print(eachChar[i]);
                                break;
                        }
                        if (flag == 0) {
                            System.out.print("\n");
                            break;
                        }
                    }
                }
            }

        }
    }
}
