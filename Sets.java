public class Sets implements OrderedSetInterface{
    private Comparable[] list;
    private int vSize;

    public Sets(){
        list=new Comparable[10];
        vSize=0;
    }

    public void add(Comparable obj){
        if(contains(obj)){
            return;
        }
        if(vSize==list.length){
            resize();
        }
        vSize++;
        if(isEmpty()){
            list[vSize++]=obj;
            return;
        }
        int i=vSize-1;
        list[i]=obj;
        while(i>0 && list[i-1].compareTo(obj)>0){
            list[i]=list[i-1];
            i--;
        }
        list[i]=obj;
    }

    public boolean contains(Comparable obj){
        if(!isEmpty()){
            int result=binSearch(obj, 0, vSize-1);
            return (result!=-1);
        }
        return false;
    }
    
    //Private utilities
    private int binSearch(Comparable obj, int from, int to){
        if(from>to){
            return -1;
        }
        int mid=(from+to)/2;
        if(list[mid].compareTo(obj)==0){
            return mid;
        }
        if(list[mid].compareTo(obj)<0){
            return binSearch(obj, mid+1, to);
        }
        if(list[mid].compareTo(obj)>0){
            return binSearch(obj, from, mid-1);
        }
        return -1;
    }
    private void resize(){
        Comparable[] temp=new Comparable[list.length*2];
        System.arraycopy(list,0,temp,0,list.length);
        list=temp;
    }

    public Comparable[] toSortedArray(){
        Comparable[] temp=new Comparable[vSize];
        System.arraycopy(list,0,temp,0,vSize);
        return temp;
    }

    public void makeEmpty(){
        vSize=0;
    }
    public boolean isEmpty(){
        return vSize==0;
    }
}
interface OrderedSetInterface{
    void add(Comparable obj);
    boolean contains(Comparable obj);

    Comparable[] toSortedArray();

    void makeEmpty();
    boolean isEmpty();
}
class Algorithms{
    public static void mergeSort(Comparable[] list){
        if(list.length<2){
            return;
        }
        int mid=list.length/2;
        Comparable[] left=new Comparable[mid];
        Comparable[] right=new Comparable[list.length-mid];

        System.arraycopy(list, 0, left, 0, mid);
        System.arraycopy(list, 0, right, 0, list.length-mid);

        mergeSort(left);
        mergeSort(right);

        merge(list,left,right);
    }
    public static void merge(Comparable[] output, Comparable[] left, Comparable[] right){
        int outI=0;
        int lefI=0;
        int rigI=0;

        while(lefI<left.length && rigI<right.length){
            if(left[lefI].compareTo(right[rigI])<0){

            }
        }
    }
}
