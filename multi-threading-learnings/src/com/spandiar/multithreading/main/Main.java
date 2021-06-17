package com.spandiar.multithreading.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.spandiar.download.processor.FileDownloader;

public class Main {

	public static void main(String[] args) {

		DownloadStatus tracker = new DownloadStatus();
		List<Thread> downloaderThreads = new ArrayList<>();
		int counter = 0;
		Random random = new Random();

		for (int i = 1; i <= 10; i++) {
			downloaderThreads.add(new Thread(new FileDownloader(tracker)));
		}

		for (Thread thread : downloaderThreads) {
			thread.start();
		}
		
		for (Thread thread : downloaderThreads) {
			counter++;
			if(counter == random.nextInt(9))
			{
				thread.interrupt();
				System.out.println("Interrupted thread: " + thread.getName());
			}
		}
		
		try {
			for (Thread thread : downloaderThreads) {
				thread.join();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Total bytes downloaded is: " + tracker.getTotalDownloadedBytes());

	}
}
