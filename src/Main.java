import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Triangle> isoscelestriangles = parseInFile(args[0]);

    }

    public static void readInFile(String path) {
        Triangle triangle;
        try (FileReader reader = new FileReader(path)) {
            int c;
            int i = 0;
            String str = "";
            while ((c = reader.read()) != -1) {
                if ((char) c == '\n') {
                    if((triangle=createTriangle(str))==null) {
                        str = "";
                        continue;
                    }
                    else
                    {
                        if (triangle.isIsosceles()){
                            if (tr)
                        }
                    }
                }
                str += (char) c;
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static Triangle createTriangle(String str) {
        ArrayList<Integer> triangleCoord = new ArrayList<Integer>();
        String[] subStr;
        int number;
        int numberCount = 0;
        triangleCoord.clear();
        subStr = str.split(" ");
        try {
            for (String word : subStr) {
                number = Integer.parseInt(word);
                numberCount++;
                triangleCoord.add(number);
            }
            if (numberCount > 6) {
                return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }
        return new Triangle(triangleCoord);

    }
}

