import java.text.DateFormat;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BigOInfo {

	public static int[] selectionSortInfo(int[] list){
		
		String info="";
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		long start=System.nanoTime();
		int[] returnedlist=Sorts.selectionSort(list);
		long end=System.nanoTime();
		
		long difference=end-start;
		
		info+="Selection Sort ran at "+dateFormat.format(date)+"\n\nExpected number of iterations:\n"
		+(list.length*list.length)+
		"\n\nTime taken: "+difference+" nanoseconds.\n" +
		"==========================================";
		
		
		FileHandler.writeBigOInfo(info);
		return returnedlist;
				
		
	}
	
	public static int[] bubbleSortInfo(int[] list){
		
		String info="";
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		long start=System.nanoTime();
		int[] returnedlist=Sorts.bubbleSort(list);
		long end=System.nanoTime();
		
		long difference=end-start;
		
		info+="Bubble Sort ran at "+dateFormat.format(date)+"\n\nExpected number of iterations:\nBetween: "
		+list.length+" and "+(list.length*list.length)+
		"\n\nTime taken: "+difference+" nanoseconds.\n" +
		"==========================================";
		
		
		FileHandler.writeBigOInfo(info);
		return returnedlist;
				
		
	}
	
	public static int[] insertionSortInfo(int[] list){
		
		String info="";
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		long start=System.nanoTime();
		int[] returnedlist=Sorts.insertionSortImproved(list);
		long end=System.nanoTime();
		
		long difference=end-start;
		
		info+="Insertion Sort ran at "+dateFormat.format(date)+"\n\nExpected number of iterations:\nBetween: "
		+list.length+" and "+(list.length*list.length)+
		"\n\nTime taken: "+difference+" nanoseconds.\n" +
		"==========================================";
		
		
		FileHandler.writeBigOInfo(info);
		return returnedlist;
				
		
	}
	
	public static int[] javaSortInfo(int[] list){
		
		int[] temp=Arrays.copyOf(list, list.length);
		String info="";
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		long start=System.nanoTime();
		Arrays.sort(temp);
		
		long end=System.nanoTime();
		
		int[] returnedlist=temp;
		
		long difference=end-start;
		
		info+="Java Sort ran at "+dateFormat.format(date)+"\n\nExpected number of iterations:\nBetween: "
		+list.length+" and "+((int) (list.length*Math.log(list.length)))+
		"\n\nTime taken: "+difference+" nanoseconds.\n" +
		"==========================================";
		
		
		FileHandler.writeBigOInfo(info);
		return returnedlist;
				
		
	}
	
	
	public static void main(String[] args){
		
		int[] sort={1,2,5,4,3,6,5,4,3,6,7,5,4,3,2,4,3,6,5,4,8,7,6,5,4,8,7,6,5,5,4,5,4,3,3,4,3,4,2,4,3,6,5,7,6,7,9,10,2,3,4};
		FileHandler.BigOInfoclear();
		BigOInfo.selectionSortInfo(sort);
		BigOInfo.bubbleSortInfo(sort);
		BigOInfo.insertionSortInfo(sort);
	}
	
	
}
