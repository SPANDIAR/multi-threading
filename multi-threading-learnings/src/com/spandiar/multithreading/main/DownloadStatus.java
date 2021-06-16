package com.spandiar.multithreading.main;


public class DownloadStatus {
	
	private long totalDownloadedBytes;

	public DownloadStatus() {
		super();
		this.totalDownloadedBytes = 0;
	}

	public long getTotalDownloadedBytes() {
		return this.totalDownloadedBytes;
	}

	public synchronized void incrementTotalDownloadedBytes() {
		this.totalDownloadedBytes++;
	}
	
}
