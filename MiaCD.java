public class MiaCD implements CD {
    private int start;
    private int end;
    private Object array[];

    public MiaCD(){
        array=new Object[10];
        start=0;
        end=0;
    }

    public int size(){
        return array.length-start + end;
    }
    
    public boolean isEmpty(){
        return start==end;
    }

    public void addFirst(Object obj){
        if(start==nextElement(end)){
            resize();
        }
        array[end]=obj;
        end=nextElement(end);
    }
    public void addLast(Object obj){
        if(end==previousElement(start)){
            resize();
        }
        array[previousElement(start)]=obj;
        start=previousElement(start);
    }

    public Object removeFirst() throws EmptyCDException{
        if(isEmpty()){
            throw new EmptyCDException();
        }
        Object removed=array[start];
        array[start]=null;
        start=nextElement(start);
        return removed;
    }
    public Object removeLast() throws EmptyCDException{
        if(isEmpty()){
            throw new EmptyCDException();
        }
        end=previousElement(end);
        Object removed=array[end];
        array[end]=null;

        return removed;
    }

    public Object getFirst(){
        return array[start];
    }
    public Object getLast(){
        return array[previousElement(end)];
    }

    private int nextElement(int number){
        if(number+1<array.length){
            return number+1;
        }
        else{
            return 0;
        }
    }
    private int previousElement(int number){
        if(number-1<0){
            return array.length-1;
        }
        else{
            return number-1;
        }
    }

    private void resize(){
        Object[] temp=new Object[array.length*2];

        System.arraycopy(array, start, temp, 0, array.length-1-start);
        System.arraycopy(array,0,temp,array.length-1-start,array.length-end-1);

        array=temp;
    }

    public String toString(){
        String output="[";
        for(int i=0; i<array.length;i++){
            output=output+array[i]+",";
        }
        output=output+"] -start:"+start+" -end:"+end;
        return output;
    }

    //[6,2,3,4,5]
}
interface CD{ 
    int size();
    boolean isEmpty();
    void addFirst (Object x); // aggiunge all'inizio della coda
    void addLast (Object x); // aggiunge alla fine della coda
    Object removeFirst () throws EmptyCDException; // toglie dall'inizio
    Object removeLast () throws EmptyCDException; // toglie dalla fine
    Object getFirst () throws EmptyCDException; // elemento all'inizio
    Object getLast () throws EmptyCDException; // elemento alla fine
}