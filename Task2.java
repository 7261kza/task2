import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    //  (x-x0)-(y-y0)=r2

    static float xCenter;
    static float yCenter;
    static float radius;
    static float radiusSquared;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter path file_1 and file_2:");
        readFile1(new File(scanner.nextLine()));
        List<String> listCoordinates = readFile2(new File(scanner.nextLine()));
        foo(listCoordinates);
    }

    public static void foo(List<String> listCoordinates) {
        for (String coordinates : listCoordinates) {
            String[] arrayXY = coordinates.split("\\s+");
            float x = Float.parseFloat(arrayXY[0]);
            float y = Float.parseFloat(arrayXY[1]);
            float sumXY = (float) (Math.pow(x - xCenter, 2) + Math.pow(y - yCenter, 2));

            if (sumXY == radiusSquared) {
                System.out.println(0);
            } else if (sumXY < radiusSquared) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }

    public static void readFile1(File file1) {
        try {
            List<String> stringList = Files.readAllLines(file1.toPath());
            String[] arrayXY = stringList.get(0).split("\\s+");
            xCenter = Float.parseFloat(arrayXY[0]);
            yCenter = Float.parseFloat(arrayXY[1]);
            radius = Float.parseFloat(stringList.get(1));
            radiusSquared = (float) Math.pow(radius, 2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFile2(File file2) {
        try {
            return Files.readAllLines(file2.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}