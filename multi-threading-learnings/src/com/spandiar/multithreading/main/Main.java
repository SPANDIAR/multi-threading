package com.spandiar.multithreading.main;

import java.util.ArrayList;
import java.util.List;

import com.spandiar.download.processor.FileDownloader;

public class Main {

	public static void main(String[] args) {

		DownloadStatus tracker = new DownloadStatus();
		List<Thread> downloaderThreads = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {
			downloaderThreads.add(new Thread(new FileDownloader(tracker)));
		}

		for (Thread thread : downloaderThreads) {
			thread.start();
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
