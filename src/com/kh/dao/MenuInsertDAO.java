package com.kh.dao;
import com.kh.util.Common;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MenuInsertDAO {

    public void empInsert() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("------------메뉴 정보를 입력하세요ヽ(✿ﾟ▽ﾟ)ノ------------");
        System.out.print("메뉴명 : ");
        String mname = sc.next();
        System.out.print("가격 : ");
        int mprice = sc.nextInt();
        System.out.print("카테고리 : ");
        String category = sc.next();

        String sql = "INSERT INTO EMP(MNAME, MPRICE, CATEGORY) " +
                "VALUES(?,?,?)";
        try{
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, mname);  // 첫번째 자리에 넣겠다.
            pstmt.setInt(2, mprice);
            pstmt.setString(3, category);
            pstmt.executeUpdate();      // 이걸 해줘야지 되는겨~
        } catch(Exception e) {
            e.printStackTrace();
        }
        Common.commit(conn);
        Common.close(pstmt);
        Common.close(conn);
    }
}
