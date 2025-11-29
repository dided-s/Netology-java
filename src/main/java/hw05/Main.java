package hw05;

public class Main {
    public static final int SIZE = 8;

    public static void main(String[] args) {
        IntMatrix matrix = new IntMatrix(SIZE, SIZE);
        matrix.fillRandom(0, 256);
        matrix.printMatrix();
        System.out.println();

        System.out.println("Matrix 90: ");
        IntMatrix rotate90Matrix = matrix.getRotate90Matrix();
        rotate90Matrix.printMatrix();

        // Поворот на 180
        System.out.println("Matrix 180: ");
        IntMatrix rotate180Matrix = matrix.getRotate180Matrix();
        rotate180Matrix.printMatrix();
        // Два поворота 90+90 = 180
        IntMatrix rotate9090Matrix = rotate90Matrix.getRotate90Matrix();
        System.out.println("Поворот 180 и 2 поворота 90 равны: " + rotate180Matrix.equals(rotate9090Matrix));

        System.out.println("Matrix 270: ");
        IntMatrix rotate270Matrix = matrix.getRotate270Matrix();
        rotate270Matrix.printMatrix();
        IntMatrix rotate909090Matrix = rotate9090Matrix.getRotate90Matrix();
        System.out.println("Поворот 270 и 3 поворота 90 равны: " + rotate270Matrix.equals(rotate909090Matrix));
    }
}
