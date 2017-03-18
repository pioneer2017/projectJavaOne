package lianxi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
	public ArrayList<Integer> list = new ArrayList();

	public String replaceSpace(StringBuffer str) {
		StringBuffer a = new StringBuffer();
		char b;
		int t = str.length();
		for (int i = 0; i < t; i++) {
			b = str.charAt(i);
			if (b == ' ') {
				a.append("%20");
			} else {
				a.append(b);
			}
		}
		String c = a.toString();
		return c;

	}

	// 输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre.length == 0 || in.length == 0) {
			return null;
		}

		TreeNode t = new TreeNode(pre[0]);
		for (int i = 0; i < pre.length; i++) {
			if (pre[0] == in[i]) {
				t.left = reConstructBinaryTree(
						Arrays.copyOfRange(pre, 1, i + 1),
						Arrays.copyOfRange(in, 0, i));
				t.right = reConstructBinaryTree(
						Arrays.copyOfRange(pre, i + 1, pre.length),
						Arrays.copyOfRange(in, i + 1, in.length));
			}
		}
		return t;
	}

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.add(node);

	}

	public int pop() {
		int k = stack1.size();
		for (int i = 0; i < k; i++) {
			stack2.add(stack1.pop());
		}

		int t = stack2.pop();
		int n = stack2.size();

		for (int i = 0; i < n; i++) {
			stack1.add(stack2.pop());
		}
		return t;
	}

	public static int minNumberInRotateArray(int[] array) {
		int i = array.length;
		if (i == 0) {
			return 0;
		}

		int k = array[0];
		int[] m;

		if (k < array[i / 2]) {
			array[i / 2] = k;
			int t = (i - 1) - (i / 2) + 1;
			m = new int[t];
			for (int j = i / 2; j < i; j++) {
				m[j - (i / 2)] = array[j];

			}
			k = minNumberInRotateArray(m);
		}
		if (k >= array[i / 2]) {
			if (i == 2) {
				return k;
			}
			array[0] = array[i / 2];
			int t = i / 2 + 1;
			m = new int[t];
			for (int r = 0; r < i / 2 + 1; r++) {
				m[r] = array[r];
			}
			k = minNumberInRotateArray(m);
		}
		return k;
	}

	public static int Fibonacci(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		int a = 0, b = 1, c = 1;
		if (n > 1) {
			for (int i = 3; i <= n; i++) {
				c = a + b;
				a = b;
				b = c;
			}
			return c;
		}
		return 0;
	}

	public static int JumpFloor(int target) {
		int n = 1;
		if (target == 1) {
			n = 1;
		}
		if (target == 2) {
			n = 2;
		}
		if (target > 2) {
			for (int i = 1; i < target; i++) {
				n = n * 2;
			}
		}
		return n;

	}

	public static int RectCover(int target) {
		if (target == 1)
			return 1;
		if (target == 2)
			return 2;
		if (target > 2)
			return RectCover(target - 1) + RectCover(target - 2);
		return 0;
	}

	public static int NumberOf1(int n) {
		int t = 0;
		if (n >= 0) {
			while (true) {
				if (n == 0)
					break;
				if (n > 0) {
					if (n % 2 == 1)
						t++;
					n = n / 2;
				}
			}
		} else {
			int j = 0;
			boolean f = true;
			n = Math.abs(n);
			List k = new ArrayList();
			while (true) {
				if (n == 0)
					break;
				if (n > 0) {
					if (n % 2 == 0)
						k.add(1);
					else
						k.add(0);
					n = n / 2;
				}
			}
			while (k.size() < 8)
				k.add(1);

			while (j < k.size()) {
				if (f) {
					if (k.get(j).equals(0)) {
						t++;
						f = false;
					}
				} else {
					if (k.get(j).equals(1)) {
						{
							t++;
						}
					}
				}
				j++;
			}
		}
		return t;

	}

	// 二进制查1
	public int NumberOf2(int n) {
		int t = 0;
		char[] ch = Integer.toBinaryString(n).toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == '1') {
				t++;
			}
		}
		return t;
	}

	public double Power(double base, int exponent) {
		double t = base / base;
		if (exponent >= 0) {
			for (int i = 0; i < exponent; i++) {
				t = t * base;
			}
		} else {
			int m = 0 - exponent;
			for (int i = 0; i < m; i++) {
				t = t * base;
			}
			t = 1 / t;
		}
		return t;
	}

	public void reOrderArray(int[] array) {
		ArrayList list = new ArrayList();
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 1 || array[i] % 2 == -1)
				list.add(array[i]);
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0)
				list.add(array[i]);
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = (Integer) list.get(i);
		}
	}

	public ListNode FindKthToTail(ListNode head, int k) {
		ListNode a = new ListNode(0);
		ListNode b = head;
		ListNode c = new ListNode(0);
		boolean t = false;
		a = head;
		if (k > 1 && head != null) {
			for (int i = 0; i < k - 1; i++) {
				if (a.next == null) {
					t = false;
					c = null;
					break;
				} else {
					a = a.next;
					t = true;
				}
			}
			while (t) {
				if (a.next == null) {
					c = b;
					break;
				} else {
					a = a.next;
					b = b.next;
				}
			}
		}
		if (k == 1 && head != null) {
			t = true;
			while (t) {
				if (b.next == null) {
					c = b;
					break;
				} else {
					b = b.next;
				}
			}
		}
		if (k <= 0 || head == null) {
			c = null;
		}
		return c;
	}

	public ListNode ReverseList(ListNode head) {
		ListNode t = null;
		if (head == null || head.next == null) {
			t = head;
		} else {
			ListNode pre = head;
			ListNode k = head.next;
			if (head.next.next != null) {
				ListNode n = head.next.next;
				pre.next = null;
				while (true) {
					k.next = pre;
					pre = k;
					k = n;
					if (n.next == null) {
						k.next = pre;
						break;
					} else {
						n = n.next;
					}
				}
				t = k;
			} else {
				pre.next = null;
				k.next = pre;
				t = k;
			}
		}
		return t;
	}

	public ListNode Merge(ListNode list1, ListNode list2) {
		ListNode list0 = null, c = null;
		boolean a = false, b = false;
		if (list1 == null && list2 == null) {
			c = null;
		}
		if (list1 != null && list2 == null) {
			c = list1;
		}
		if (list1 == null && list2 != null) {
			c = list2;
		}
		if (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				list0 = list1;
				if (list1.next != null)
					list1 = list1.next;
				else
					a = true;
			} else {
				list0 = list2;
				if (list2.next != null)
					list2 = list2.next;
				else
					b = true;
			}
			c = list0;
			while (a == false && b == false) {
				if (list1.val <= list2.val) {
					list0.next = list1;
					list0 = list0.next;
					if (list1.next != null) {
						list1 = list1.next;
					} else {
						a = true;
						break;
					}
				} else {
					list0.next = list2;
					list0 = list0.next;
					if (list2.next != null) {
						list2 = list2.next;
					} else {
						b = true;
						break;
					}
				}
			}
			while (a) {
				list0.next = list2;
				list0 = list0.next;
				if (list2.next != null)
					list2 = list2.next;
				else
					break;
			}
			while (b) {
				list0.next = list1;
				list0 = list0.next;
				if (list1.next != null)
					list1 = list1.next;
				else
					break;
			}
		}
		return c;
	}

	public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
		boolean res = false;
		if (root1 != null && root2 != null) {
			if (root2.val==root1.val) {
				res=HasSubtreeceshi(root1,root2);
			}
			if(!res)
					res = HasSubtree(root1.left, root2);
			if (!res)
				    res = HasSubtree(root1.right, root2);
		}
		return res;
	}
	public static boolean HasSubtreeceshi(TreeNode root1, TreeNode root2) {
		if(root1==null&&root2!=null)
			return false;
		if(root2==null)
			return true;
		if (root2.val!=root1.val) {
			return false;
		}
		return HasSubtreeceshi(root1.left,root2.left)&&HasSubtreeceshi(root1.right,root2.right);
	}
	/*
	 * 镜像二叉树
	 */
	  public static void Mirror(TreeNode root) {
		  if(root==null)
			  return ;
		  TreeNode t = null;
			 t=root.left;
		     root.left=root.right;  
		     root.right=t;
		     Mirror(root.left);
		     Mirror(root.right);
	    }

	  /*
	   * 旋转矩阵
	   */
	   public static ArrayList<Integer> printMatrix(int [][] matrix) {
		   ArrayList<Integer> list = new ArrayList<Integer>();
		   if(matrix.length>0&&matrix[0].length>0)
		   list = Jvzhen(list,matrix);
		   System.out.println(list);
		return list;
	    }
	private static ArrayList<Integer> Jvzhen(ArrayList<Integer> list2, int[][] matrix) {
		int m=0;
		int n=0;
		int j = n;
		int i =m;
		for(j=n;j<matrix[0].length;j++)
			list2.add(matrix[i][j]);
		i++;j--;
		if(i<matrix.length){
		for(;i<matrix.length;i++)
			list2.add(matrix[i][j]);
		j--;i--;
		}else{
			return list2;
		}
		
		if(i>=0&&j>=0){
		for(;j>=n;j--)
			list2.add(matrix[i][j]);
		i--;j++;
		}
	
		if(i>=0&&j>=0){
		for(;i>m;i--)
			list2.add(matrix[i][j]);}
		if(matrix.length-2>0&&matrix[0].length-2>0)
			{
			int[][] a = new int[matrix.length-2][matrix[0].length-2];
			i=1;j=1;
			for(;i<matrix.length-1;i++){
				n=0;
				for(j=1;j<matrix[0].length-1;j++){
					a[m][n]=matrix[i][j];
					n++;
				}
				m++;
			}
			list2=Jvzhen(list2,a);
			}
		return list2;
	}

	public static void main(String[] args) {
		int[][] a = new int[1][1];
		int t =1;
		a[0][0]=1;
		printMatrix(a);
	}

}
