package main.java.trans;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;


/**
 * 性能测试工具
 * @author tianfeng1
 *
 */
public class PerformUtil {
	private PerformUtil() {
		
	}
	
	/**
	 * 并行执行
	 * @param runnable 执行工作线程
	 * @param concurrentCount 并行量
	 * @param repeatCount 重复执行次数
	 */
	public static void concurrentExecute(Runnable runnable, int concurrentCount, int repeatCount) {
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(concurrentCount);
		// 启动工作线程
		ExecutorService executorService = Executors.newFixedThreadPool(concurrentCount);
		for(int i = 0; i < concurrentCount; i++) {
			executorService.execute(new ConcurrentWorker(runnable, repeatCount, startSignal, doneSignal));
		}
		// 触发所有线程的执行
		startSignal.countDown();
		long startTime = System.currentTimeMillis();
		try {
	    	// 等待所有线程执行完毕
			doneSignal.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
	    System.out.println("concurrentExecute get done in " + (endTime - startTime) + " millsecond");
	    
	    executorService.shutdown();
	}
	
	/**
	 * 并行执行
	 * @param runnable 执行工作线程
	 * @param concurrentCount 并行量
	 * @param consistentTime 持续时间
	 */
	public static void concurrentExecute(Runnable runnable, int concurrentCount, long consistentTime) {
		CountDownLatch startSignal = new CountDownLatch(1);
		// 启动工作线程
		ExecutorService executorService = Executors.newFixedThreadPool(concurrentCount);
		AtomicBoolean isInterrupted = new AtomicBoolean(false);
		for(int i = 0; i < concurrentCount; i++) {
			executorService.execute(new ConcurrentWorker(runnable, consistentTime, startSignal, isInterrupted));
		}
		// 触发所有线程的执行
		startSignal.countDown();
		long startTime = System.currentTimeMillis();
		try {
			TimeUnit.MILLISECONDS.sleep(consistentTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		isInterrupted.set(true);
//		executorService.shutdown();
		long endTime = System.currentTimeMillis();
	    System.out.println("concurrentExecute get done in " + (endTime - startTime) + " millsecond");
	}
	
	private static class ConcurrentWorker implements Runnable {
		private Runnable runnable;
		private int repeatCount;
		private CountDownLatch startSignal;
        private CountDownLatch doneSignal;
        private long consistentTime;
        private AtomicBoolean isInterrupted;
		
		public ConcurrentWorker(Runnable runnable, int repeatCount, CountDownLatch startSignal, CountDownLatch doneSignal) {
			this.runnable = runnable;
			this.repeatCount = repeatCount;
			this.startSignal = startSignal;
            this.doneSignal = doneSignal;
            this.consistentTime = 0;
		}
		
		public ConcurrentWorker(Runnable runnable, long consistentTime, CountDownLatch startSignal, AtomicBoolean isInterrupted) {
			this.runnable = runnable;
			this.consistentTime = consistentTime;
			this.startSignal = startSignal;
			this.isInterrupted = isInterrupted;
            this.doneSignal = null;
            this.repeatCount = 0;
		}
		
		@Override
		public void run() {
			try {
				if(repeatCount != 0) {
					startSignal.await();
					for(int i = 0; i < repeatCount; i++) {
						runnable.run();
					}
					doneSignal.countDown();
				} else if(consistentTime != 0) {
					startSignal.await();
					while(!Thread.currentThread().isInterrupted() && !isInterrupted.get()) {
						runnable.run();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
