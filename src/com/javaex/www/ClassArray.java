package com.javaex.www;

public class ClassArray {

	class A {
		int a;
	}
	public static void main(String[] args) {
		// �ڷ����� �⺻�� �迭
		int []a = new int[10];
		a[0] = 20;
		for(int i = 0; i < 10; i++) {
			System.out.println(a[i]);
		}
		
		A[] b = new A[10]; // Ŭ���� �迭 ����
		// b[0] = new A();
		b[0].a = 20; // b�� �ε��� 0�� a������ 20�� ���� // ����ǥ�ð� �ȳ��µ� ���� �ȵǴ°� �迭�� ��ü�ΰ�.
		for(int i = 0; i<10; i++) { // �ݺ��� ������ ���
			// ���⼭ ������ ���� ���� ???
			// ��ü �迭�� �����鼭 a�� ���� ���
			// 1~9�������� ������ �ȸ���� ����.
			// ��ü�� �ȸ���� �ְ� a������ �����Ϸ��� �ϴϱ� ������ �߻���
			System.out.println(b[i]);
		}
	}

}
