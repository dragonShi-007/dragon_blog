package com.dragon.juc;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class L1 {

    private static OrderService orderService = new OrderService();

    public static void main(String[] args) {
        // async表示执行异步任务,就是跟当前不是一个线程，run表示无返回值，supply表示又返回值
        Integer orderId = 33;
        /*
        public static CompletableFuture<Void> 	runAsync(Runnable runnable)
        public static CompletableFuture<Void>   runAsync(Runnable runnable, Executor executor)
        public static <U> CompletableFuture<U> 	supplyAsync(Supplier<U> supplier)
        public static <U> CompletableFuture<U> 	supplyAsync(Supplier<U> supplier, Executor executor)
        */
        ExecutorService executor = Executors.newFixedThreadPool(5);
        CompletableFuture<List<Integer>> cf1 = CompletableFuture.supplyAsync(() -> {
            return orderService.getOrderDetail(orderId);
        }, executor);
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> {
            return orderService.getOrderSale(orderId);
        }, executor);
        CompletableFuture<Integer> cf3 = CompletableFuture.supplyAsync(() -> {
            return orderService.getUserLevel(orderId);
        }, executor);

        /*
        //完成和异常都会走进来
        public CompletableFuture<T> 	whenComplete(BiConsumer<? super T,? super Throwable> action)
        public CompletableFuture<T> 	whenCompleteAsync(BiConsumer<? super T,? super Throwable> action)
        public CompletableFuture<T> 	whenCompleteAsync(BiConsumer<? super T,? super Throwable> action, Executor executor)
        //相当于catch，发生异常会执行，并完成，未发生异常也算执行完成
        public CompletableFuture<T>     exceptionally(Function<Throwable,? extends T> fn)


        */

        // 一对一

        /*
        public <U> CompletableFuture<U> 	handle(BiFunction<? super T,Throwable,? extends U> fn)
        public <U> CompletableFuture<U> 	handleAsync(BiFunction<? super T,Throwable,? extends U> fn)
        public <U> CompletableFuture<U> 	handleAsync(BiFunction<? super T,Throwable,? extends U> fn, Executor executor)
        //handle可以处理异常，但是thenApply不可以，只能处理正常结束
        public <U> CompletableFuture<U> 	thenApply(Function<? super T,? extends U> fn)
        public <U> CompletableFuture<U> 	thenApplyAsync(Function<? super T,? extends U> fn)
        public <U> CompletableFuture<U> 	thenApplyAsync(Function<? super T,? extends U> fn, Executor executor)

        //只处理，不返回
        public CompletableFuture<Void> 	thenAccept(Consumer<? super T> action)
        public CompletableFuture<Void> 	thenAcceptAsync(Consumer<? super T> action)
        public CompletableFuture<Void> 	thenAcceptAsync(Consumer<? super T> action, Executor executor)

        */

        //二对一
        /*
        // 无返回值，纯消费
        public <U> CompletableFuture<Void> 	thenAcceptBoth(CompletionStage<? extends U> other, BiConsumer<? super T,? super U> action)
        public <U> CompletableFuture<Void> 	thenAcceptBothAsync(CompletionStage<? extends U> other, BiConsumer<? super T,? super U> action)
        public <U> CompletableFuture<Void> 	thenAcceptBothAsync(CompletionStage<? extends U> other, BiConsumer<? super T,? super U> action, Executor executor)
        public     CompletableFuture<Void> 	runAfterBoth(CompletionStage<?> other,  Runnable action)
        // 又返回值，做转换
        public <U,V> CompletableFuture<V> 	thenCombine(CompletionStage<? extends U> other, BiFunction<? super T,? super U,? extends V> fn)
        public <U,V> CompletableFuture<V> 	thenCombineAsync(CompletionStage<? extends U> other, BiFunction<? super T,? super U,? extends V> fn)
        public <U,V> CompletableFuture<V> 	thenCombineAsync(CompletionStage<? extends U> other, BiFunction<? super T,? super U,? extends V> fn, Executor executor)

        public <U> CompletableFuture<U> 	thenCompose(Function<? super T,? extends CompletionStage<U>> fn)
        public <U> CompletableFuture<U> 	thenComposeAsync(Function<? super T,? extends CompletionStage<U>> fn)
        public <U> CompletableFuture<U> 	thenComposeAsync(Function<? super T,? extends CompletionStage<U>> fn, Executor executor)

        //下面是不必都完成，又一个完成就行
        public CompletableFuture<Void> 	acceptEither(CompletionStage<? extends T> other, Consumer<? super T> action)
        public CompletableFuture<Void> 	acceptEitherAsync(CompletionStage<? extends T> other, Consumer<? super T> action)
        public CompletableFuture<Void> 	acceptEitherAsync(CompletionStage<? extends T> other, Consumer<? super T> action, Executor executor)
        public <U> CompletableFuture<U> 	applyToEither(CompletionStage<? extends T> other, Function<? super T,U> fn)
        public <U> CompletableFuture<U> 	applyToEitherAsync(CompletionStage<? extends T> other, Function<? super T,U> fn)
        public <U> CompletableFuture<U> 	applyToEitherAsync(CompletionStage<? extends T> other, Function<? super T,U> fn, Executor executor)

         */

        //多对一

        /*
        public static CompletableFuture<Void> 	    allOf(CompletableFuture<?>... cfs)
        public static CompletableFuture<Object> 	anyOf(CompletableFuture<?>... cfs)
        */

    }
}
