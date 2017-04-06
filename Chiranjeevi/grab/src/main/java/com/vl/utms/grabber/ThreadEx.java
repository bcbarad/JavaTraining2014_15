package com.vl.utms.grabber;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.filechooser.FileSystemView;

public class ThreadEx {
	public static void main(String[] args) {
		/*FileSystemView fsv = FileSystemView.getFileSystemView();		
		File[] drives = File.listRoots();
		File f = new File("/media");
		for (File file : f.listFiles()) {
			System.out.println(file.getAbsolutePath());
		}*/
		String s = "aabbbcccc%$";
		int[] arr = new int[256];
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i)]++;
		}
		char tempCh;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > 0){
				tempCh = (char)i;
				System.out.println(arr[i]+ "" +tempCh);
			}
		}
		/*ThreadEx ex = new ThreadEx();
		ex.executor();*/
	}

	private void executor() {
		ExecutorService executorService = Executors.newWorkStealingPool(10);
		List<Callable<String>> callables = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Callable<String> t = () -> {
				print();
				return null;
			};
			callables.add(t);
		}
		try {
			executorService.invokeAny(callables);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void print() {
		System.out.println("Inside Thread : " + Thread.currentThread().getName());
	}
}