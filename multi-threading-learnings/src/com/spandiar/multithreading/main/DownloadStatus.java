package com.spandiar.multithreading.main;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
	
	private long totalDownloadedBytes;
	private Lock lock;

	public DownloadStatus() {
		super();
		this.totalDownloadedBytes = 0;
		this.lock = new ReentrantLock();
	}

	public long getTotalDownloadedBytes() {
		return this.totalDownloadedBytes;
	}

	public  void incrementTotalDownloadedBytes() {
		lock.lock();
		this.totalDownloadedBytes++;
		lock.unlock();
	}
	
}
