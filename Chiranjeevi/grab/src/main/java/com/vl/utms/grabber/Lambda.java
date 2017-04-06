package com.vl.utms.grabber;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

public class Lambda {
	List outputList = new ArrayList<Integer>();
	private static SecureRandom random = new SecureRandom();
	Random rnd = new Random();
	public static void main(String[] args) throws IOException {
		List list = Arrays.asList("22", "2.2", "1", "2.1", "2.0", "3", "2.11", "2.1.5");
		//System.out.println(list);
		//Arrays.asList(Thread.currentThread().getClass().getClasses()).stream().map(p->p.getSimpleName()).forEach(System.out::println);
		//sortingEx(list);
		
		int[] newData = {149,718,458,456,457,1567,129,457,487,136,291,706,542,149,786,458,37,321,654,987,157,753,951,458,452,325,985};//new int[1000];
		/*for(int i=0;i<1000;i++){
			newData[i] = rnd.nextInt(1000);
		}*/
		int[] data = {1, 5, 8, 9, 3};
		int result = 1312;//rnd.nextInt(500);
		System.out.print("Input : "+result+"\n");
		for (int i : newData) {
			System.out.print(i + " ");
		}
		System.out.print("\nIndexes : ");
		//int[] output = 
				//operate(data, result, 0);
		
		long startTime = System.currentTimeMillis();
		//int[] output = operate(data, 11);
		System.out.println(operateBackTrack(newData, result, 0));
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken : "+(endTime-startTime));
				
		/*for (int i = 0; output != null && i < output.length; i++) {
			System.out.print(output[i] + " ");
		}*/
		//parseCSV();
		//System.out.println(generateRandomString(20));
	    //System.out.println(generateSalt() + "ssss");
	}
	
	public static String generateRandomString(int length) {
      char[] values = {'a','b','c', '%','d','e','f','g','h','i','j',
               'k','l','m','n','o', '$','p','q','r','s','t',
               'u','v','w','x','y','z','0','1','2','3',
               '4','5', '@','6','7','8','9'};

      String out = "";

      for (int i=0;i<2;i++) {
          int idx=random.nextInt(values.length);
          out += values[idx];
      }
      return out;
    }
    
    private static String generateSalt() {
	    StringBuilder buf = new StringBuilder();
	    SecureRandom sr = new SecureRandom();
	    for( int i=0; i<6; i++ ) {// log2(52^6)=34.20... so, this is about 32bit strong.
	        boolean upper = sr.nextBoolean();
	        char ch = (char)(sr.nextInt(26) + 97);
	        if(upper)   ch=Character.toUpperCase(ch);
	        buf.append(ch);
	    }
	    return buf.toString();
	}
	
	private static void parseCSV() throws IOException {
		File file = new File("/home/chiranjeevi/Desktop/practice/Delete/ssa.csv");
		int count = 0;
        /*System.out.println(*/
		Stream<List<String>> fielData = Files.lines(file.toPath(),StandardCharsets.UTF_8)
                /*.substream(1)*/
           	 .map(line -> Arrays.asList(line.split(",")))
           	 //.skip(1)
           	 .filter(s ->!s.get(0).equals(""));
		
		Stream<String> rows = Files.lines(file.toPath(),StandardCharsets.UTF_8);
		Iterator<String> rowIterator = rows.iterator();
		boolean flag = true;
		while(rowIterator.hasNext())
		{
			if(flag){
				flag = false;
				rowIterator.next();
				continue;
			}
			String line = rowIterator.next();
			System.out.println(line);
		}
		
		
           	 //.findFirst()
           	 //.get()
        //     .forEach(System.out::println);
		/*Files.lines(file.toPath())
        .map(s -> s.trim())
        .filter(s -> !s.isEmpty())
        .forEach(System.out::println);*/
		/*List<String> columns;
		List<List<String>> values;
		try(BufferedReader br=Files.newBufferedReader(file.toPath())) {
		    String firstLine=br.readLine();
		    if(firstLine==null) throw new IOException("empty file");
		    columns=Arrays.asList(firstLine.split(","));
		    System.out.println();
		    br.lines()
		        .map(line -> Arrays.asList(line.split(",")))
		        .forEach(System.out::println);
		}*/
		//System.out.println("Columns : " + columns + "\nValues : " + values);
	}

	private static int[] operate(int[] data, int result) {
		//int updatedResult = result;
		Map<Integer, Integer> map = new HashMap<>();
		int[] output = new int[2];
		for (int i = 0; i < data.length; i++) {
	        if(map.containsKey(data[i])){
	            output[1] = data[i];
	        	output[0] = map.get(data[i]);
	          return output;
	        }else if(data[i] < result){
	        	output[0] = data[i];
	        	//updatedResult = result - data[i];
	        	map.put(result-data[i], data[i]);
	        }
		}
		return null;
	}

	private static int operateBackTrack(int[] data, int result, int index) {
		if((data[index]) == result){
			//int output[] = {index, i}; 
			System.out.print("\n" + data[index] + " ");
			return data[index];
		}else if((index < data.length - 1) && operateBackTrack(data, result-data[index], index+1) != -1){
			System.out.print(data[index] + " ");
			return 0;
		}else if((index < data.length - 1) && operateBackTrack(data, result, index+1) != -1){
			//System.out.print("" + data[index]);
			return data[index + 1];
		}
		
		return -1;
	}

	private static void sortingEx(List list) {
		//UniCode Based
		list.sort((e1, e2) -> {
			//return dictionaryCompare((String)e1, (String)e2);
			return ((String) e1).compareTo((String) e2);
			/*int x = Integer.parseInt((String) e1);
			int y = Integer.parseInt((String) e2);
			return (x > y) ? 1 : (x < y) ? -1 : 0;*/
		});
		System.out.println("UniCode/Dictionary Based : " + list);
		//Ascending Order
		/*list.sort((e1, e2) -> {
			//return Integer.compare(Integer.parseInt((String) e1), Integer.parseInt((String) e2));
			int x = Integer.parseInt((String) e1);
			int y = Integer.parseInt((String) e2);
			return (x > y) ? 1 : (x < y) ? -1 : 0;
			//return (x/y > 1.0) ? 1 : (x/y > 0.0) ? -1 : 0;
		});*/
		System.out.println("Ascending Order : " + list);
	}

	static int dictionaryCompare(String x, String y) {
		for(int i = 0; i < x.length(); i++) {
			if(x.charAt(i) > y.charAt(i)) {
				return 1;
			}else if(x.charAt(i) < y.charAt(i)) {
				return -1;
			}
		}
		return 0;
	}
}
