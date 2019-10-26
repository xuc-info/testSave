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
		users.put(1, new User("����", 25));
		users.put(2, new User("����", 22));
		users.put(3, new User("��2��", 28));
		users.put(4, new User("��3��", 218));
		users.put(5, new User("��4��", 248));
		users.put(6, new User("��5��", 58));
		users.put(7, new User("��11��", 3));
		users.put(8, new User("��455��", 55));
		System.out.println(users);
		HashMap<Integer, User> sortHashMap = sortHashMap(users);
		System.out.println(sortHashMap);
		/**
		 * ����̨������� {1=User [name=����, age=25], 2=User [name=����, age=28], 3=User
		 * [name=����, age=22]} {2=User [name=����, age=28], 1=User [name=����,
		 * age=25], 3=User [name=����, age=22]}
		 */
	}

	public static HashMap<Integer, User> sortHashMap(HashMap<Integer, User> map) {
		// �����õ� map �ļ�ֵ�Լ���
		Set<Entry<Integer, User>> entrySet = map.entrySet();
	
		TreeSet<Entry<Integer, User>> treeSet = new TreeSet<>(new Comparator<Entry<Integer, User>>() {

			@Override
			public int compare(Entry<Integer, User> o1, Entry<Integer, User> o2) {
				// ����Ҫ����� User �� age �ĵ��������
				return o2.getValue().getAge() - o1.getValue().getAge();
			}
		});
		treeSet.addAll(entrySet);

		// ����һ���µ������ HashMap ����ļ���
		LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<Integer, User>();
		// �� List �е����ݴ洢�� LinkedHashMap ��
		for (Entry<Integer, User> entry : treeSet) {
			linkedHashMap.put(entry.getKey(), entry.getValue());
		}

		return linkedHashMap;

	}
	/*
	 * public static HashMap<Integer, User> sortHashMap(HashMap<Integer, User>
	 * map) { // �����õ� map �ļ�ֵ�Լ��� Set<Entry<Integer, User>> entrySet =
	 * map.entrySet();
	 * 
	 * // �� set ����תΪ List ���ϣ�Ϊʲô��Ϊ��ʹ�ù���������򷽷� List<Entry<Integer, User>> list =
	 * new ArrayList<Entry<Integer, User>>(entrySet); // ʹ�� Collections ���Ϲ������
	 * list ���������������ʹ�������ڲ�����ʵ�� Collections.sort(list, new
	 * Comparator<Entry<Integer, User>>() {
	 * 
	 * @Override public int compare(Entry<Integer, User> o1, Entry<Integer,
	 * User> o2) { // ����Ҫ����� User �� age �ĵ�������� return o2.getValue().getAge() -
	 * o1.getValue().getAge(); } }); // ����һ���µ������ HashMap ����ļ���
	 * LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<Integer,
	 * User>(); // �� List �е����ݴ洢�� LinkedHashMap �� for (Entry<Integer, User>
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