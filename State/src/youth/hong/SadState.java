package youth.hong;

public class SadState extends State {

	@Override
	public void smile() {
		System.out.println("û�뵽��ô�����ˣ��Ҳŷ�����һֱ��ƭ��");
	}

	@Override
	public void cry() {
		System.out.println("��������������������������");
	}

	@Override
	public void say() {
		System.out.println("��Ҫ������");
	}

}
