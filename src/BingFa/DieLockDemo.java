package BingFa;

/*
 * ͬ���ı׶ˣ�
 *         A:Ч�ʵ�
 *         B:���ײ�������
 * 
 * ������
 *         �������������ϵ��߳���������Դ�Ĺ����У�������һ���໥�ȴ�������
 * 
 * ������
 *         С����Сǿ�����г�����������һ��һ��Կ�װ�����
 *         ���������
 *             С��: ��������Կ�׶���;
 *             Сǿ: ��������Կ�׶��С�
 *         ���ڣ�
 *             С����������һ����������Կ�ף�
 *             Сǿ������һ����������Կ�ס�
 *             ��������˶����ܴ�����������һֱ�ȴ�˷ҹ�𲻵����г�
 */
public class DieLockDemo {
	public static  int a=0;
    public static void main(String[] args) {
    	DieLockDemo.a--;
    	
        DieLock dl1 = new DieLock(true);
        DieLock dl2 = new DieLock(false);

        dl1.start();
        dl2.start();
    }
}
