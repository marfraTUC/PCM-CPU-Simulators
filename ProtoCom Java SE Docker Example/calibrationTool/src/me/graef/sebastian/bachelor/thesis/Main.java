package me.graef.sebastian.bachelor.thesis;

public class Main {

    private static final int NUM_OF_FIBONACCI_NUMBERS = 1000000;

    public static void main(String[] args) {
        System.out.println("start calculation");
//        long startTime = System.nanoTime();
        fibonacci(NUM_OF_FIBONACCI_NUMBERS);
//        System.out.println(System.nanoTime() - startTime);
    }

    private static void fibonacci(int iterationCount) {
        long i1 = 1L;
        long i2 = 1L;
        long i3 = 0L;

        for (long i = 0L; i < iterationCount; ++i) {
            i3 = i1 + i2;
            i2 = i1;
            i1 = i3;
        }
    }
}
