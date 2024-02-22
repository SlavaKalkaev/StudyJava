import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Vector {

    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length() {
        return (Math.sqrt(x * x + y * y + z * z));
    }

    public double scalar(Vector vector1) {
        return (this.x * vector1.getX() + this.y * vector1.getY() + this.z * vector1.getZ());
    }

    public Vector multiply(Vector vector1) {
        return new Vector(
                this.y * vector1.getZ() - this.z * vector1.getY(),
                this.z * vector1.getX() - this.x * vector1.getZ(),
                this.x * vector1.getY() - this.y * vector1.getX()
        );
    }

    public double cos(Vector vector1) {
        return scalar(vector1) / (length() * vector1.length());
    }

    public Vector sum(Vector vector1) {
        return new Vector(this.x + vector1.getX(), this.y + vector1.getY(), this.z + vector1.getZ());
    }

    public Vector minus(Vector vector1) {
        return new Vector(this.x - vector1.getX(), this.y - vector1.getY(), this.z - vector1.getZ());
    }

    public static Vector[] createVectorArr(int N) {
        Random rd = new Random();
        Vector[] arr = new Vector[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Vector(
                    rd.nextInt(),
                    rd.nextInt(),
                    rd.nextInt()
            );
            System.out.println(arr[i]);
        }
        return arr ;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return String.format("Vector(%1$,.2f,%1$,.2f,%1$,.2f)",x,y,z);
    }
}

class Launch {
    public static void main(String[] args) {
        Vector vec1 = new Vector(17,3,19);
        Vector vec2 = new Vector(27,18,29);
        Vector vec3 = new Vector(37,38,59);
        Vector vec4 = new Vector(47,48,9);
        System.out.println(vec1.length());
        System.out.println(vec1.scalar(vec2));
        System.out.println(vec1.multiply(vec2));
        System.out.println(vec1.minus(vec2).toString());
        System.out.println(vec1.sum(vec2).toString());
        System.out.println(Vector.createVectorArr(6));
    }

}