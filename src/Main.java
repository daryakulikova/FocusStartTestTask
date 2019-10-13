import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Triangle maxTriangle =readInFile(args[0]);
        writeOutFile(args[1], maxTriangle);
    }

    public static void writeOutFile(String path, Triangle tr) {
        try(FileWriter writer = new FileWriter(path, false))
        {
            String text = "";
            if (tr!=null) {
                text=tr.toString();
            }
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public static Triangle readInFile(String path) {
        Triangle triangle;
        Triangle maxTriangle=null;
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
                            if (maxTriangle == null || triangle.getS()>maxTriangle.getS())
                            {
                               maxTriangle=triangle;
                            }
                        }
                    }
                }
                str += (char) c;
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        return maxTriangle;
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
            if (numberCount != 6) {
                return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }
        return new Triangle(triangleCoord);

    }
}

