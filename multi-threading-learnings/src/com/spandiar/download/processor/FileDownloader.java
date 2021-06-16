package com.spandiar.download.processor;

import com.spandiar.multithreading.main.DownloadStatus;

public class FileDownloader implements Runnable{
	
	private DownloadStatus tracker;
	
	public FileDownloader(DownloadStatus tracker) {
		this.tracker = tracker;
	}

	@Override
	public void run() {
		for(int i=1; i<=10_000L; i++) {
			tracker.incrementTotalDownloadedBytes();
		}
	}

}
	