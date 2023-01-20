package member;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class MemberMgr {

	private DBConnectionMgr pool;

	public MemberMgr() {
		pool = DBConnectionMgr.getInstance();
	}

	// ��� ����Ʈ : SELECT - DB1
	public Vector<MemberBean> selectAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<MemberBean> vlist = new Vector<MemberBean>();
		try {
			con = pool.getConnection();
			sql = "SELECT * FROM tblMember"; // ������ ���� ����
			pstmt = con.prepareStatement(sql);// �������� ���� ��ɹ��� ������
			rs = pstmt.executeQuery();// ������ ����� �� �����Ѵ�.
			while (rs.next()) {
				MemberBean bean = new MemberBean();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setPhone(rs.getString("phone"));
				bean.setAddress(rs.getString("address"));
				bean.setTeam(rs.getString("team"));
				vlist.addElement(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}

	// ���� : INSERT - DB2
	public boolean insert(MemberBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "insert tblMember values(null,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			// ù��° ?�� �Ű������� ���� ��� name�� ���� : 'aaa'
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getPhone());
			pstmt.setString(3, bean.getAddress());
			pstmt.setString(4, bean.getTeam());
			// insert, update, delete ����� ���ڵ� ����
			int cnt = pstmt.executeUpdate();
			if (cnt == 1)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	// �Ѱ��� ���ڵ� : SELECT - DB1

	// ���� : UPDATE - DB2

	// ���� : DELETE - DB2

	// �ּҰ˻�(���� ��ȣ �˻�) : SELECT - DB1
	public Vector<ZipcodeBean> zipcodeSearch(String area3){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<ZipcodeBean> vlist = new Vector<ZipcodeBean>();
		try {
			con = pool.getConnection();
			sql = "select * from tblzipcode " + "where area3 like ?";//?�� ���� ���Կ���
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+area3+"%");
			//like %`�������`%
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ZipcodeBean bean = new ZipcodeBean();
				//select�ڿ� �������� �÷��� index
				bean.setZipcode(rs.getString(1));
				bean.setArea1(rs.getString(2));
				bean.setArea1(rs.getString(3));
				bean.setArea1(rs.getString(4));
				vlist.addElement(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	
	public static void main(String[] args) {
		MemberMgr mgr = new MemberMgr();
//		MemberBean bean_insert = new MemberBean();
//		bean_insert.setName("��ȣ��");
//		bean_insert.setPhone("010-5555-2323");
//		bean_insert.setAddress("�λ�� ������");
//		bean_insert.setTeam("â����");
//		boolean flag = mgr.insert(bean_insert);
//		System.out.println(flag);
		
		
		//�迭�� vector�ؿ��� �׻� for�� ����
//		Vector<MemberBean> vlist_select = mgr.selectAll();
//		for (int i = 0; i < vlist_select.size(); i++) {
//			MemberBean bean_select = vlist_select.get(i);
//			System.out.println(bean_select.getId()+"\t"
//							+bean_select.getName()+"\t"
//							+bean_select.getPhone()+"\t"
//							+bean_select.getAddress()+"\t"
//							+bean_select.getTeam());
//		}
	}
}
/*
 * Classpath ���� jdk or jre -> �⺻Ŭ������ �ʿ� ���� �������� class jvm�ν� �ܺ� Ŭ������ -> .jar ��������
 * ����
 */
