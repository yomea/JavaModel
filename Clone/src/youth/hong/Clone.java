package youth.hong;

class CloneObject implements Cloneable {
	private String name;
	
	private String content;

	public CloneObject(String name, String content) {
		super();
		this.name = name;
		this.content = content;
	}

	@Override
	public String toString() {
		return "CloneObject [name=" + name + ", content=" + content + "]";
	}
	
	/**
	 * ���Ըĳ�public�ķ���Ȩ�ޣ������ܸĳɱ������ϸ�ķ���Ȩ��
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}

public class Clone {
	public static void main(String[] args) {
		CloneObject entity = new CloneObject("youth", "���");
		try {
			CloneObject clone = (CloneObject)entity.clone();
			System.out.println("entity:" + entity);
			System.out.println("clone:" + clone);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
