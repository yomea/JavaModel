package youth.hong;

public class WatchFilm implements Command {

	@Override
	public void execute() {
		System.out.println("ȥ����Ӱ");
	}

	@Override
	public void undo() {
		System.out.println("��ȥ����Ӱ");
	}

}
