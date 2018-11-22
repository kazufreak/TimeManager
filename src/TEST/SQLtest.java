package TEST;

import mainprojects.projectmanager;

public class SQLtest {

	public static void main(String[] args) {
		projectmanager pjm = new projectmanager();//SQLテスト
		pjm.ProjectWrite();//テストデータ書込
		pjm.ProjectRead();//読込テスト

	}

}
