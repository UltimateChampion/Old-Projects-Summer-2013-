public class Sorts{

    
    public Sorts(){
        
    }

    
    public static int[] selectionSort(int[] array){
        
        int arraylength= array.length;
        int minvalue;
        int minelement;
        int a=0;
        
        for (int i=0; i<arraylength; i++){
        
            minvalue=array[i];
            minelement=i;
            
            for (int j=i; j<arraylength; j++){
                
                if (array[j]<array[minelement]){
                    
                    minvalue=array[j];
                    minelement=j;
                }
                
            }
            
            switchElements(array, i, minelement);
        }
        
        return array;
    }
    

    
    public static int[] bubbleSort(int[] array){
        
        int comparisonlength=array.length;
        int comparisons=0;
        
        while (true){
            
            comparisons=0;
            
            for(int i=0; i<comparisonlength-1; i++){
                
                if (array[i]>array[i+1]){
                    comparisons++;
                    switchElements(array, (i), (i+1));
                }
                
                
            }
            
           
            
            
            if (comparisons==0){
                return array;
            }
            
            comparisonlength--;
           // printArray(array);
        }
        
    }
    
    
    public static int[] insertionSort(int[] array){
        
        int insertelement=0;
        int ivalue=0;
        int comparison=0;
        
        for (int i=1; i<array.length; i++){
            
            //printArray(array);
            comparison=0;
            
            for (int j=i; j>=0; j--){
                
                if (array[i]<array[j]){
                    insertelement=j;
                    ivalue=array[i];
                    comparison++;
                    
                }
                
            }
            
            if (comparison>0){
                for (int k=i-1; k>=insertelement; k--){
                    array[k+1]=array[k];
                }
                
                array[insertelement]=ivalue;
            }
        }
    
        return array;
    }
    

    
    public static int[] insertionSortImproved(int[] array){
    	
    	for (int i = 1; i < array.length; i++){
   		  	
    		int j = i;
   		  	int B = array[i];
   		  
   		  	while ((j > 0) && (array[j-1] > B)){
   		  		array[j] = array[j-1];
   		  		j--;
   		  	}
   		  array[j] = B;
   		 }
    	
    	return array;
   	 }
   	
 
    
    
    public static void switchElements(int[] array, int firstelement, int secondelement){
        
        int i=array[secondelement];
        array[secondelement]=array[firstelement];
        array[firstelement]=i;
        
        
            
    }
    
    
    
    
    
    
    
    public static void printArray(int[] array){
        
        for (int i=0; i<array.length; i++){
            
            System.out.print(array[i]);
        }
        
        System.out.println("\n");
        
        
    }
    
    
    public static void main(String[] args){
        
        int[] test={3,5,2,1,4};
        test=Sorts.insertionSortImproved(test);
        Sorts.printArray(test);
            
    }

    
}