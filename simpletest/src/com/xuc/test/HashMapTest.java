package com.xuc.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap<Integer, User> users = new HashMap<>();
		users.put(1, new User("张三", 25));
		users.put(2, new User("李四", 22));
		users.put(3, new User("王2五", 28));
		users.put(4, new User("王3五", 218));
		users.put(5, new User("王4五", 248));
		users.put(6, new User("王5五", 58));
		users.put(7, new User("王11五", 3));
		users.put(8, new User("王455五", 55));
		System.out.println(users);
		HashMap<Integer, User> sortHashMap = sortHashMap(users);
		System.out.println(sortHashMap);
		/**
		 * 控制台输出内容 {1=User [name=张三, age=25], 2=User [name=王五, age=28], 3=User
		 * [name=李四, age=22]} {2=User [name=王五, age=28], 1=User [name=张三,
		 * age=25], 3=User [name=李四, age=22]}
		 */
	}

	public static HashMap<Integer, User> sortHashMap(HashMap<Integer, User> map) {
		// 首先拿到 map 的键值对集合
		Set<Entry<Integer, User>> entrySet = map.entrySet();
	
		TreeSet<Entry<Integer, User>> treeSet = new TreeSet<>(new Comparator<Entry<Integer, User>>() {

			@Override
			public int compare(Entry<Integer, User> o1, Entry<Integer, User> o2) {
				// 按照要求根据 User 的 age 的倒序进行排
				return o2.getValue().getAge() - o1.getValue().getAge();
			}
		});
		treeSet.addAll(entrySet);

		// 创建一个新的有序的 HashMap 子类的集合
		LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<Integer, User>();
		// 将 List 中的数据存储在 LinkedHashMap 中
		for (Entry<Integer, User> entry : treeSet) {
			linkedHashMap.put(entry.getKey(), entry.getValue());
		}

		return linkedHashMap;

	}
	/*
	 * public static HashMap<Integer, User> sortHashMap(HashMap<Integer, User>
	 * map) { // 首先拿到 map 的键值对集合 Set<Entry<Integer, User>> entrySet =
	 * map.entrySet();
	 * 
	 * // 将 set 集合转为 List 集合，为什么，为了使用工具类的排序方法 List<Entry<Integer, User>> list =
	 * new ArrayList<Entry<Integer, User>>(entrySet); // 使用 Collections 集合工具类对
	 * list 进行排序，排序规则使用匿名内部类来实现 Collections.sort(list, new
	 * Comparator<Entry<Integer, User>>() {
	 * 
	 * @Override public int compare(Entry<Integer, User> o1, Entry<Integer,
	 * User> o2) { // 按照要求根据 User 的 age 的倒序进行排 return o2.getValue().getAge() -
	 * o1.getValue().getAge(); } }); // 创建一个新的有序的 HashMap 子类的集合
	 * LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<Integer,
	 * User>(); // 将 List 中的数据存储在 LinkedHashMap 中 for (Entry<Integer, User>
	 * entry : list) { linkedHashMap.put(entry.getKey(), entry.getValue()); }
	 * return linkedHashMap;
	 * 
	 * }
	 */}

class User {
	private String name;
	private int age;

	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}