public class Rewrites {
    public static void selectionSort(int[] list){
        for(int i=0; i<list.length; i++){
            int min=findMin(list, i);
            if(min!=i){
                swap(list,min,i);
            }
        }
    }
    private static int findMin(int[] list, int start){
        int minimum=list[start];
        int min=start;
        for(int i=start; i<list.length; i++){
            if(list[i]<minimum){
                minimum=list[i];
                min=i;
            }
        }
        return min;
    }
    private static void swap(int[] list, int from, int to){
        int temp=list[from];
        list[from]=list[to];
        list[to]=temp;
    }

    public static void mergeSort(int[] list){
        if(list.length<2){
            return;
        }
        int mid=list.length/2;
        int[] left=new int[mid];
        int[] right=new int[list.length-mid];

        System.arraycopy(list,0,left,0,mid);
        System.arraycopy(list,mid,right,0,list.length-mid);

        mergeSort(left);
        mergeSort(right);

        merge(list,left,right);
    }
    private static void merge(int[] output, int[] left, int[] right){
        int outIndex=0;
        int leftIndex=0;
        int rightIndex=0;

        while(leftIndex<left.length && rightIndex<right.length){
            if(left[leftIndex]<right[rightIndex]){
                output[outIndex++]=left[leftIndex++];
            }
            else if(left[leftIndex]>right[rightIndex]){
                output[outIndex++]=right[rightIndex++];
            }
            else if(left[leftIndex]==right[rightIndex]){
                output[outIndex++]=left[leftIndex++];
                output[outIndex++]=right[rightIndex++];
            }
        }

        while(leftIndex<left.length){
            output[outIndex++]=left[leftIndex++];
        }
        while(rightIndex<right.length){
            output[outIndex++]=right[rightIndex++];
        }
    }
}
