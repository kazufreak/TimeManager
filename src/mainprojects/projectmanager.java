package mainprojects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class projectmanager {
	String pjname;
	int pjId;
	String dayspan;
	int MountMoney;
	String personal;
	double prosess;
	String client;
	String contents;
	String claimDate;

	public projectmanager() {
		//処理
		String strdate1 = "2017/03/02";
		String strdate2 = "2017/03/20";


		this.pjname = "test";
		this.pjId = 001;
		this.dayspan = strdate1;
		this.MountMoney = 2500000;
		this.personal = "土屋一勝";
		this.prosess = 25.1;
		this.client = "time";
		this.contents = "測量設計";
		this.claimDate = strdate2;


	}
	private void DBconection(Connection conn) {
		//h2接続
		try {
			//JDBCドライバを読み込み
			Class.forName("org.h2.Driver");//JDBCドライバの名前
			//データベース接続　組込の場合jdbc:h2:~/test
			conn = DriverManager.getConnection("jdbc:h2:tcp://jdbc:h2:~/test:/~/TODO_MANAGER","sa","");//接続先DB、ユーザ名、パスワード

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
				conn.close();
				}catch(SQLException e) {
					e.printStackTrace(); //切断失敗時の処理
				}
			}
		}

	}
	public void ProjectRead() {
		//SQL読込
		Connection conn = null;
		//接続
		DBconection(conn);
		//sql文
		String sqlread = "SELECT PJNAME,PJID,DAYSPAN,MOUNTMONEY,"
				+ "PERSONAL,PROSESS,CLIENT,CONTENTS,CLAIMDATE FROM TODO_MANAGER";
		//準備したSQLをDBに届けるprepareStatementインスタンスを取得
		try {
			PreparedStatement pStmt = conn.prepareStatement(sqlread);
			//SELECTを実行し、結果表（ResultSet)に取得
			ResultSet rs = pStmt.executeQuery();//ResultSetインスタンスにSELECT文の結果が格納される
			//結果表に格納されたレコードの内容を表示
			while(rs.next()) {
				//結果テスト表示ローカル変数
				String pjname = rs.getString("PJNAME");
				int pjId = rs.getInt("PJID");
				String dayspan = rs.getString("DAYSPAN");
				int MountMoney = rs.getInt("MOUNTMONEY");
				String personal = rs.getString("PERSONAL");
				double prosess = rs.getDouble("PROSESS");
				String client = rs.getString("CLIENT");
				String contents = rs.getString("CONTENTS");
				String claimDate = rs.getString("CLAIMDATE");
				System.out.println(pjname);
				System.out.println(pjId);
				System.out.println(dayspan);
				System.out.println(MountMoney);
				System.out.println(personal);
				System.out.println(prosess);
				System.out.println(contents);
				System.out.println(claimDate);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
				conn.close();
				}catch(SQLException e) {
					e.printStackTrace(); //切断失敗時の処理
				}
			}
		}
	}
	public void ProjectWrite() {
		//SQL書込
				Connection conn = null;
				//接続
				DBconection(conn);

				//sql文
				String sqlwrite = "INSERT INTO TODO_MANAGER(PJNAME,PJID,DAYSPAN,MOUNTMONEY," +
									"PERSONAL,PROSESS,CLIENT,CONTENTS,CLAIMDATE)" +
									"VALUES(" + this.pjname+","+
												this.pjId+","+
												this.dayspan+","+
												this.MountMoney+","+
												this.personal+","+
												this.prosess+","+
												this.client+","+
												this.contents+","+
												this.claimDate+")";

				try {
					PreparedStatement pStmt = conn.prepareStatement(sqlwrite);//準備したSQLをDBに届けるprepareStatementインスタンスを取得
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					if(conn != null) {
						try {
						conn.close();
						}catch(SQLException e) {
							e.printStackTrace(); //切断失敗時の処理
						}
					}
				}

	}


}
