package com.spandiar.download.processor;

import com.spandiar.multithreading.main.DownloadStatus;

public class FileDownloader{
	
	private DownloadStatus tracker;
	
	public FileDownloader(DownloadStatus tracker) {
		this.tracker = tracker;
	}
	
	public void download() {
		System.out.println("Inside download..." + Thread.currentThread().getName());
		for(int i=1; i<=10_000L; i++) {
			tracker.incrementTotalDownloadedBytes();
		}
		Thread.currentThread().notifyAll();
	}

}
	