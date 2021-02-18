package com.china.hcg.thread;

import java.util.concurrent.CompletableFuture;

/**
 * @autor hecaigui
 * @date 2020-12-18
 * @description
 */
public class CompletableTest {
	public static void main(String[] args) throws Exception{
		String result = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "s1";
		}).applyToEither(CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "hello world";
		}), s -> s).join();
		System.out.println(result);
	}
}
