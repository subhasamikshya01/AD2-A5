import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class T1 {

		class HuffmanNode implements Comparable<HuffmanNode>{
			int data;
			char c;
			HuffmanNode left;
			HuffmanNode right;

			@Override
			public int compareTo(HuffmanNode N) {
				return this.data-N.data;
			
		}}
		
		public void printTree(HuffmanNode root,String s) {
			if(root.left==null && root.right==null) {
				System.out.println(root.c+" : "+s);
				return;
			}
			printTree(root.left,s+"0");
			printTree(root.right,s+"1");
		}
		public void HuffmanTree(char []sym,int[]freq) {
			PriorityQueue<HuffmanNode>q=new PriorityQueue<HuffmanNode>();
			for(int i=0;i<sym.length;i++) {
				HuffmanNode hn=new HuffmanNode();
				hn.c=sym[i];
				hn.data=freq[i];
				hn.left=null;
				hn.right=null;
				q.add(hn);
			}
			HuffmanNode root=null;
			while(q.size()>1) {
				HuffmanNode x=q.peek();
				q.poll();
				HuffmanNode y=q.peek();
				q.poll();
				HuffmanNode f=new HuffmanNode();
				f.data=x.data+y.data;
				f.c='-';
				f.left=x;
				f.right=y;
				root=f;
				q.add(f);
			}
			printTree(root,"");
		}
		public static void main(String[]args) {
			char[]charArray= {'a','b','c','d','e','f'};
			int[]charfreq= {15,9,112,53,96,45};
			T1 obj=new T1();
			obj.HuffmanTree(charArray,charfreq);
		}
}


