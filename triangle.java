import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Triangle {
    public Dot dot1, dot2, dot3;
    public double square;
    public double length1, length2, length3;

    public Triangle(Dot dot1, Dot dot2, Dot dot3) {
        this.dot1 = dot1;
        this.dot2 = dot2;
        this.dot3 = dot3;

        CalcLength();
    }

    public void CalcLength() {
        length1 = Math.pow((dot1.x - dot2.x) * (dot1.x - dot2.x) + (dot1.y - dot2.y) * (dot1.y - dot2.y), 0.5);
        length2 = Math.pow((dot1.x - dot3.x) * (dot1.x - dot3.x) + (dot1.y - dot3.y) * (dot1.y - dot3.y), 0.5);
        length3 = Math.pow((dot3.x - dot2.x) * (dot3.x - dot2.x) + (dot3.y - dot2.y) * (dot3.y - dot2.y), 0.5);

    }

    public boolean IsItTriangle() {
        return ((length1 + length2) > length3) && ((length3 + length2) > length1) && ((length1 + length3) > length2);
    }

    public void CalcSquare() {
        square = 0.5 * Math.abs((dot2.x - dot1.x) * (dot3.y - dot1.y) - (dot3.x - dot1.x) * (dot2.y - dot1.y));
    }
}

class Dot {
    public int x, y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public static Triangle maxTriangle;

    public static Triangle init_triangle(String line) {
        String[] words = line.split(" ");
        Dot dot1, dot2, dot3;
        dot1 = new Dot(Integer.parseInt(words[0]), Integer.parseInt(words[1]));
        dot2 = new Dot(Integer.parseInt(words[2]), Integer.parseInt(words[3]));
        dot3 = new Dot(Integer.parseInt(words[4]), Integer.parseInt(words[5]));
        return new Triangle(dot1, dot2, dot3);
    }

    public static void read_file(String fileName) {
        try {
            File file = new File(fileName);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
//                System.out.println(line);
                Triangle triangle = init_triangle(line);
                if (triangle.IsItTriangle()) {
                    triangle.CalcSquare();
                    if (maxTriangle == null) {
                        maxTriangle = triangle;
                    } else if (maxTriangle.square < triangle.square) {
                        maxTriangle = triangle;
                    }
                    System.out.println(maxTriangle.square );
                }
                // считываем остальные строки в цикле
                line = reader.readLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Main {
    public static void main(String[] args) {
        Solution.read_file("f.txt");
    }
}
