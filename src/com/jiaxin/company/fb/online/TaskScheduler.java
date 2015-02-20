package com.jiaxin.company.fb.online;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * 
 * Tasks: AABABCD
 * Cooldown Time: 2
 * A__AB_ABCD
 * Output: 10
 * 
 * BAB -> not good but actually is good because AB_AB that's really
 * 
 * @author jiashan
 *
 */

public class TaskScheduler {
	
	public int taskScheduler(String task, int coolDown) {
		int total = 0;
		int interval = 0;
		
		Map<Character, Integer> dict = new HashMap<Character, Integer>();
		char[] tasks = task.toCharArray();
		
		for (int i = 0; i < tasks.length; i++) {
			if (dict.containsKey(tasks[i])) {
				int distance = i + interval - dict.get(tasks[i]); // find distance with last same char.
				
				if (distance <= 2) {
					int curInterval = 3 - (i + interval - dict.get(tasks[i]));
					interval += curInterval;  // cool down time
					total += curInterval + 1; // 1 means that task 
				} else {
					total += 1;
				}
			} else {
				total += 1;
			}
			
			dict.put(tasks[i], i + interval); // update index
		}
		
		return total;
	}
	
	
	public int taskSchedulerCoolDown(String task, int coolDown) {
		int total = 0;
		int interval = 0;
		
		Map<Character, Integer> dict = new HashMap<Character, Integer>();
		char[] tasks = task.toCharArray();
		
		for (int i = 0; i < tasks.length; i++) {
			if (dict.containsKey(tasks[i])) {
				int distance = i + interval - dict.get(tasks[i]); // find distance with last same char.
				
				if (distance <= coolDown) {
					int curInterval = coolDown + 1 - (i + interval - dict.get(tasks[i]));
					interval += curInterval;  // cool down time
					total += curInterval + 1; // 1 means that task 
				} else {
					total += 1;
				}
			} else {
				total += 1;
			}
			
			dict.put(tasks[i], i + interval); // update index
		}
		
		return total;
	}
	
	@Test
	public void test() {
		String task = "AABABCD";
		String task2 = "AAABABBCDC";
		System.out.println(taskScheduler(task2, 2)); //18
		System.out.println(taskSchedulerCoolDown(task, 3));
	}
}
