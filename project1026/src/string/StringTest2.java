package string;
class StringTest2
{
	public static void main(String[] args) 
	{
		StringBuilder sb = new StringBuilder();
		sb.append("");
		for(int i=0; i<100; i++) {
			sb.append("�ٳѱ� "+i+" ȸ\n");
		}
		System.out.println(sb.toString());
		/*
			String str = "";
			for(int i=0; i<100; i++)
				str = "�ٳѱ�" + i + "ȸ";
				//String�� �Һ��� ���ڼ��� �����ֱ� ������ ��ó�� �ڵ��ߴٰ�
				100���� ���ڿ� ����� ���Ǯ�� ����..(�޸� ����)
				������ StringBuilder�� StringBuffer�� ���� ��ü�� ���� �޸𸮳��� ����
		*/
	}
}
