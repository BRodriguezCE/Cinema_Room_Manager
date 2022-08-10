
class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {
        // write your code here
        try {
            int num = array[index];
            System.out.println(num * num);
        } catch (Exception e) {
            System.out.println("Exception!");
        }
    }
}