package com.dragon.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFuture_Learn {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int i = 1/0;
            return 100;
        },executor);
        future.join();//会报线程池执行异常
        //future.get();
        // 会报Exception in thread "main" java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
        //	at java.util.concurrent.CompletableFuture.encodeThrowable(CompletableFuture.java:273)
        //	at java.util.concurrent.CompletableFuture.completeThrowable(CompletableFuture.java:280)
        //	at java.util.concurrent.CompletableFuture$AsyncSupply.run$$$capture(CompletableFuture.java:1606)
        //	at java.util.concurrent.CompletableFuture$AsyncSupply.run(CompletableFuture.java)
        //	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
        //	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
        //	at java.lang.Thread.run(Thread.java:750)
        //
    }
}
