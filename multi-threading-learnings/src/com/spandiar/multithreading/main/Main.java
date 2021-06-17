package com.spandiar.multithreading.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.spandiar.download.processor.FileDownloader;

public class Main {

	private static final int THREADSIZE = 5;

	public static void main(String[] args) {

		List<Future<?>> future = new ArrayList<>();
		DownloadStatus tracker = new DownloadStatus();
		ExecutorService threadPool = Executors.newFixedThreadPool(THREADSIZE);

		for (int i = 1; i <= 10; i++) {
			Future<?> complete = threadPool.submit(() -> {
				FileDownloader fileDownloader = new FileDownloader(tracker);
				fileDownloader.download();
			});
			future.add(complete);
		}

		for (Future<?> complete : future) {
			while(!complete.isDone()) {}
		}

		System.out.println("Total bytes downloaded is: " + tracker.getTotalDownloadedBytes());
		threadPool.shutdown();
	}
}
