package com.pw.basic.thread.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyibo on 17/2/23.
 * <p>
 * add        增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常
 * addall      增加一个 String 集合中的所有元素
 * remove     移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
 * removeAll;  删除队列中参数包含的元素
 * element    返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
 * offer       添加一个元素并返回true       如果队列已满，则返回false
 * poll         移除并返问队列头部的元素    如果队列为空，则返回null
 * peek       返回队列头部的元素             如果队列为空，则返回null
 * put         添加一个元素                      如果队列满，则阻塞
 * take        移除并返回队列头部的元素     如果队列为空，则阻塞
 * <p>
 * <p>
 * remove、element、offer 、poll、peek 其实是属于Queue接口。
 *
 */
public class QueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = init();
		quequTest(list);
	}

	private static void quequTest(List<String> list) {
		// TODO Auto-generated method stub
		
	}

	private static List<String> init() {
		// TODO Auto-generated method stub
		List<String >list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
            list.add("abel--" + i);
        }
        return list;
	}
	
	private static void queueTest(List<String> list) {
		
	}

}
