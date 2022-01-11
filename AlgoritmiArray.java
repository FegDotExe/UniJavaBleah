public class AlgoritmiArray{
    public static void selectionSort(int[] list){//O(n^2)
        for(int i=0;i<list.length;i++){
            int minPosInt=minPos(list, i);
            if(minPosInt!=i){
                swap(list,minPosInt,i);
            }
        }
    }
    private static int minPos(int[] list, int start){
        int pos=start;
        int min=list[start];
        while(start<list.length){
            if(list[start]<min){
                min=list[start];
                pos=start;
            }
            start++;
        }
        return pos;
    }
    private static void swap(int[] list, int pos1, int pos2){
        int temp=list[pos1];
        list[pos1]=list[pos2];
        list[pos2]=temp;
    }

    public static <Comp extends Comparable> void selectionSort(Comp[] list){//O(n^2)
        for(int i=0;i<list.length;i++){
            int minPosInt=minPos(list, i);
            if(minPosInt!=i){
                swap(list,minPosInt,i);
            }
        }
    }
    private static <Comp extends Comparable> int minPos(Comp[] list, int start){
        int pos=start;
        Comp min=list[start];
        while(start<list.length){
            if(min.compareTo(list[start])>0){
                min=list[start];
                pos=start;
            }
            start++;
        }
        return pos;
    }
    private static <Comp extends Comparable> void swap(Comp[] list, int pos1, int pos2){
        Comp temp=list[pos1];
        list[pos1]=list[pos2];
        list[pos2]=temp;
    }

    public static void mergeSort(int[] list){//O(n log_2n)
        if(list.length<2){
            return;
        }
        int mid=(list.length)/2;
        int[] left=new int[mid];
        int[] right=new int[list.length-mid];

        System.arraycopy(list, 0, left, 0, mid);
        System.arraycopy(list, mid, right, 0, list.length-mid);

        mergeSort(left);
        mergeSort(right);

        merge(list,left,right);
    }
    private static void merge(int[] list, int[] left, int[] right){
        int it=0;
        int il=0;
        int ir=0;

        while(il<left.length && ir<right.length){
            if(left[il]<right[ir]){
                list[it++]=left[il++];
            }
            else{
                list[it++]=right[ir++];
            }
        }

        while(il<left.length){
            list[it++]=left[il++];
        }
        while(ir<right.length){
            list[it++]=right[ir++];
        }

    }

    public static void insertionSort(int[] list){//O(n)->O(n^2)
        for(int i=1; i<list.length; i++){
            int temp=list[i];
            int j;
            for(j=i;j>0 && temp<list[j-1];j--){
                list[j]=list[j-1];
            }
            list[j]=temp;
        }
    }

    public static int binarySearch(int[] list, int search){//O(log(n))
        return binarySearch(list,0,list.length,search);
    }
    private static int binarySearch(int[] list, int from, int to, int search){
        if(from>to){
            return -1;
        }
        int mid=(from+to)/2;
        int middle=list[mid];
        if(middle==search){
            return mid;
        }
        if(middle<search){
            return binarySearch(list, mid+1, to, search);
        }

        return binarySearch(list, from, mid-1, search);
    }
}