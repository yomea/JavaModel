package youth.hong;

public class HappyState extends State {

	@Override
	public void smile() {
		System.out.println("�̳����ۣ���Ҫȥ���");
	}

	@Override
	public void cry() {
		System.out.println("�����������İ��Ѿõ�ȹ���ˣ��Ϲ������!");
	}

	@Override
	public void say() {
		System.out.println("������Ҫ���������裡");
	}

}
