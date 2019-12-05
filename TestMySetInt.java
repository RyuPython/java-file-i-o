// 2016114311, Ryu Jonghyeon, COMP217, Homework 2-1

import java.io.*;
import java.util.*;

class MySetInt{
    private static final int MAX_ELEMENTS = 10;
    private int[] elements = new int[MAX_ELEMENTS];
    private int num_elements = 0;
    
    public int numelms() { return num_elements; }
    public boolean isIn(int x) {
        boolean same = false;
        for(int i=0; i<num_elements; i++){
            if(elements[i] == x) same = true;
        }
        
        return same;
    }
    
    public boolean add(int x){
        if(num_elements<MAX_ELEMENTS){
            int here = 0;
            for(int i=0; i<num_elements && elements[i]<x; i++)here = i+1;
            if(elements[here]!=x){
                for(int i=num_elements; i>here; i--)elements[i]=elements[i-1];
                elements[here] = x;
                num_elements++;
            }return true;
        }else return false;
    }
    
    public void remove(int x) {
        boolean done = false;
        if(num_elements>0){
            for(int i=0; i<num_elements; i++){
                if(elements[i] == x) done = true;
                else if(done == true) elements[i] = elements[i+1];
            }
            num_elements--;
        }
    }
    
    public boolean union(MySetInt X, MySetInt Y) {
        int[] instant = new int[20];
		int j=0, k=0, num=0;
		
		for(int i=0; i<X.numelms(); i++){
			if(X.getelms(j)<Y.getelms(k)){
				instant[i] = X.getelms(i);
				num++;
			}else if(X.getelms(j)>Y.getelms(k)){
				instant[i] = X.getelms(i);
				num++;
			}else k++;
		}
        
		if(num<=10){
			for(int i=0; i<MAX_ELEMENTS; i++){
				elements[i] = instant[i];
			}
			num_elements = num;
			return true;
		}else return false;
    }
    
    public void intersection(MySetInt X, MySetInt Y){
        this.difference(X,Y);
        this.difference(X,this);
    }
    
    public void difference(MySetInt X, MySetInt Y){
        this.copy(X);
        
        for(int i=0; i<Y.numelms(); i++){
            this.remove(Y.getelms(i));
        }
    }
    
    public void complement(MySetInt X, MySetInt U) { this.difference(U,X); }
    
    public void print() { System.out.print(elements); }
    public void copy(MySetInt X){
        boolean nothing;
        for(int i=this.numelms()-1; i>=0; i--){
            this.remove(elements[i]);
        }
        for(int i=0; i<X.numelms(); i++){
            nothing = this.add(X.getelms(i));
        }
    }
    
    public int getelms(int i){
        return elements[i];
    }
}

public class TestMySetInt{
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        
        String[] SetNames = {"U", "A", "B", "C", "D"};
		String[] Command = {"numel", "isin", "add", "remove", "copy", "union", "intersection", "difference", "complement"};
        MySetInt[] mysets = new MySetInt[SetNames.length];
        
        for(int i=0; i<mysets.length; i++){
            mysets[i] = new MySetInt();
        }
		
		if (args.length != 1) {
			System.out.println(
			"Usage: java FindStatics sourceFile");
			System.exit(1);
		}
		
		File sourceFile = new File(args[0]);
		if (!sourceFile.exists()) {
			System.out.println("Source file " + args[0] + " does not exist");
			System.exit(2);
		}
		
		Scanner input = new Scanner(sourceFile);
		
		while(input.hasNext()){
			String s1 = input.next();
			if(s1=="exit")break;
			
			String c1 = input.next();
			if(s1==Command[0]){
				System.out.println(mysets[findIndex(c1,SetNames)].numelms());
			}else if(s1==Command[1]){
				int x = input.nextInt();
				System.out.println(mysets[findIndex(c1,SetNames)].isIn(x));
			}else if(s1==Command[2]){
				int x = input.nextInt();
				if(mysets[findIndex(c1,SetNames)].add(x)==true){
					mysets[findIndex(c1,SetNames)].print();
				}else System.out.println("overflow");
			}else if(s1==Command[3]){
				int x = input.nextInt();
				mysets[findIndex(c1,SetNames)].remove(x);
				mysets[findIndex(c1,SetNames)].print();
			}else if(s1==Command[4]){
				String c2 = input.next();
				mysets[findIndex(c1,SetNames)].copy(mysets[findIndex(c2,SetNames)]);
				mysets[findIndex(c1,SetNames)].print();
			}else if(s1==Command[5]){
				String c2 = input.next();
				String c3 = input.next();
				mysets[findIndex(c1,SetNames)].union(mysets[findIndex(c2,SetNames)],mysets[findIndex(c3,SetNames)]);
				mysets[findIndex(c1,SetNames)].print();
			}else if(s1==Command[6]){
				String c2 = input.next();
				String c3 = input.next();
				mysets[findIndex(c1,SetNames)].intersection(mysets[findIndex(c2,SetNames)],mysets[findIndex(c3,SetNames)]);
				mysets[findIndex(c1,SetNames)].print();
			}else if(s1==Command[7]){
				String c2 = input.next();
				String c3 = input.next();
				mysets[findIndex(c1,SetNames)].difference(mysets[findIndex(c2,SetNames)],mysets[findIndex(c2,SetNames)]);
				mysets[findIndex(c1,SetNames)].print();
			}else if(s1==Command[8]){
				String c2 = input.next();
				mysets[findIndex(c1,SetNames)].complement(mysets[findIndex(c2,SetNames)],mysets[0]);
				mysets[findIndex(c1,SetNames)].print();
			}
		
		}
    }
	
	public static int findIndex(String a, String[] b){
		int index=0;
		for(int i=0; i<b.length; i++){
			if(a==b[i]){
				index = i;
				break;
			}
		}
		
		return index;
	}
}