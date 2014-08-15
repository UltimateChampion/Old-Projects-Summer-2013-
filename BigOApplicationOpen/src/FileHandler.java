import java.io.*;
import java.util.Arrays;


public class FileHandler {
	
	
	private static PrintWriter randpw;
	private static PrintWriter manpw;
	private static PrintWriter bigopw;
	private static PrintWriter sortedlistpw;
	private static BufferedReader filereader;
	
	
	
	public static int[] writeRandomList(int n, int bound){
		
		if (n>10000000){
			n=10000000;
		}
		
		if (bound>10000000){
			bound=10000000;
		}
		
		int[] returnrandomlist= new int[n];
		
		try {
			randpw=new PrintWriter("randomexportedlist.txt");	
		}
		catch (Exception e){
			System.out.println("File Not Found.");
		}
		
		
		for (int i=0; i<n; i++){
			
			returnrandomlist[i]=(int) (Math.random()*bound);
			randpw.print(returnrandomlist[i]+" ");
			
			if (i>0 && i%19==0){
				
				randpw.print("\n");
			}
			
		}
		
		randpw.close();		
		return returnrandomlist;
		
	}
	
	public static void writeManualList(String s){
		
		try {
			manpw=new PrintWriter("manualexportedlist.txt");	
		}
		catch (Exception e){
			System.out.println("File Not Found.");
		}
		
		String restring= s.replaceAll("[^0-9]", " ");
		
		
		char[] restringcharray=restring.toCharArray();
		
		
		
		
		
		for (int i=0; i<restring.length(); i++){
			
			manpw.print(restringcharray[i]+"");
			
			if (i>0 && i%19==0){
				
				manpw.print("\n");
			}
			
		}
		
		manpw.close();
	}
	
	
	public static void writeList(int[] sorted){
		
		try {
			sortedlistpw=new PrintWriter("sortedlist.txt");	
		}
		catch (Exception e){
			System.out.println("File Not Found.");
		}
		
		for (int i=0; i<sorted.length; i++){
			
			sortedlistpw.print(sorted[i]+" ");
			
			if (i>0 && i%19==0){
				
				sortedlistpw.print("\n");
			}
			
		}
		sortedlistpw.close();
		
	}
	
	
	public static void BigOInfoclear(){
		
		try {
			bigopw=new PrintWriter("bigolist.txt");	
		}
		catch (Exception e){
			System.out.println("File Not Found.");
		}
		
		bigopw.print("");
		bigopw.close();
		
	}
	
	public static void writeBigOInfo(String s){
		
		try {
			bigopw=new PrintWriter(new BufferedWriter(new FileWriter("bigolist.txt", true)));	
		}
		catch (Exception e){
			System.out.println("File Not Found.");
		}
		
		bigopw.print(s+"\n");
		bigopw.close();
		
	}
	
	public static int[] interpretFile(File f){
		
		
		
		int returnedlist[]= new int[10000000];
		int[] actualreturned={};
		int listindex=0;
		int i=0;
		
		int[] temp;
		String s="";
		
		try{
		filereader=new BufferedReader(new FileReader(f));
		
		while ((s=filereader.readLine()) !=null){
			i=0;
			temp=convertString(s+" ");
			
			while (i<temp.length){
				returnedlist[listindex]=temp[i];
				i++;
				listindex++;
			}
			
			
			
	
		}
		
		actualreturned=new int[listindex];
		
		for (int k=0; k<listindex; k++){
			actualreturned[k]=returnedlist[k];
			
		}
		
		
		}
		catch(Exception e){
			System.out.println("File Not Found.");
		}
		

		
		return actualreturned;
		
	}
	
	public static int[] convertString(String s){
		
		int[] toreturn=new int[s.length()];
		
		s=s.replaceAll("[^0-9]", " ");
		
		
		//System.out.println(s);
		char[] schar=s.toCharArray();
		
		int i=0;
		int j=0;
		int numints=0;
		
		String currint="";
		
		while (i<s.length()){
			
			
			if (schar[i]!=' '){
				currint=currint+schar[i];
			}
			else
			if (schar[i]==' '){
				try{
				toreturn[j]=Integer.parseInt(currint);
				j++;
				currint="";
				numints++;
				}
				
				catch(Exception c){
					
				}
				
				
			}
			//System.out.println(currint);
			
			i++;
			
			
		}
		
		int[] toreturnactually=new int[numints];
	
		for (int k=0; k<numints; k++ ){
			toreturnactually[k]=toreturn[k];
			
		}
		
		
		return toreturnactually;
		
	}
	
	
	
	
	public static void main(String[] args){
		
		//int[] x={1 23 4 3 23,4,5,64,3,2,3,4,3,2,1,2,3,4,5,6,4,4,3,2,3,4,5,4,3,2,4,4,5,3,2,4,5,4,3};
		//String x="1 23 4 3 23,4,5,64,3,2,3,4,3,2,1,2,3";
		int[] x=FileHandler.interpretFile(new File("randomexportedlist.txt"));
		System.out.println(Arrays.toString(x));
		//FileHandler.writeList(x);
	}
	
	

}
