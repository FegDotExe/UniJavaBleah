public class Test {
    public static void main(String[] args) {
        Sets prova=new Sets();
        prova.add("Cammello");
        prova.add("Canederli");
        prova.add("Cammello");
        prova.add("Banane");
        prova.add("A");
        prova.add("B");
        prova.add("C");
        prova.add("D");
        prova.add("Be");
        prova.add("Bu");
        prova.add("Bi");
        prova.add("H");
        prova.add("Bo");

        Comparable[] tezt=prova.toSortedArray();
        Utils.printArray(tezt);
    }
}
