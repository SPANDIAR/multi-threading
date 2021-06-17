package com.spandiar.multithreading.main;

import java.util.concurrent.atomic.AtomicLong;

public class DownloadStatus {
	
	private AtomicLong totalDownloadedBytes = new AtomicLong();

	public DownloadStatus() {
		super();
		this.totalDownloadedBytes.set(0L);;
	}

	public long getTotalDownloadedBytes() {
		return this.totalDownloadedBytes.longValue();
	}

	public void incrementTotalDownloadedBytes() {
		this.totalDownloadedBytes.incrementAndGet();
	}
	
}
