package string;
class StringTest 
{ 
	public static void main(String[] args) 
	{
		String a1 = "apple";
		String a2 = "apple";
		if(a1==a2){		// �ּҺ�... ���������������� ���Ǯ�� ����Ǳ⿡ 
							// �ѹ� ������ �ּҴ� �ٽ� �������ʰ�, ���� �ν��Ͻ��� �����ϱ⿡
							// ����� �׻� true
			System.out.println(a1==a2);
		}
		if(a1.equals(a2)) {
			System.out.println(a1.equals(a2));	// �����
		}
		
	}
}
