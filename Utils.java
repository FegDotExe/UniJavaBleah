public class Utils {
    public static void printArray(Object[] array){
        String output="[";
        for(int i=0;i<array.length-1;i++){
            output=output+array[i]+",";
        }
        output=output+array[array.length-1]+"]";
        System.out.println(output);
    }
    public static void printArray(int[] array){
        String output="[";
        for(int i=0;i<array.length-1;i++){
            output=output+array[i]+",";
        }
        output=output+array[array.length-1]+"]";
        System.out.println(output);
    }
}
