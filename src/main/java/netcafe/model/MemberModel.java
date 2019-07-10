package netcafe.model;

import netcafe.entity.Member;

import java.sql.*;
import java.util.ArrayList;

public class MemberModel {

    //    public Member findByUsernameAndStatus(String username, Student.Status status) {
//        try {
//            String sqlCommand = "select * from students where username = ? and status = ?";
//            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
//            preparedStatement.setString(1, username);
//            preparedStatement.setInt(2, status.getValue());
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                String rsUsername = resultSet.getString("username");
//                String rsPassword = resultSet.getString("password");
//                String rsEmail = resultSet.getString("email");
//                String rsFullName = resultSet.getString("fullName");
//                String rsAddress = resultSet.getString("address");
//                String rsPhone = resultSet.getString("phone");
//                int rsStatus = resultSet.getInt("status");
//                int rsRole = resultSet.getInt("role");
//                int rsVipMember = resultSet.getInt("vipMember");
//                System.out.println("rsVipMember:" + rsVipMember);
//                Student student = new Student();
//                student.setUsername(rsUsername);
//                student.setPassword(rsPassword);
//                student.setEmail(rsEmail);
//                student.setFullName(rsFullName);
//                student.setAddress(rsAddress);
//                student.setPhone(rsPhone);
//                student.setStatus(Student.Status.findByValue(rsStatus));
//                student.setRole(Student.Role.findByValue(rsRole));
//                student.setVipMember(rsVipMember == 1 ? true : false);
//                return student;
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
    public boolean save(Member member) {
        try {
            String sqlCommand = "insert into members (username, password, fullName, avatar, remainTime) values (?,?,?,?,?)";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
            preparedStatement.setString(1, member.getUsername());
            preparedStatement.setString(2, member.getPassword());
            preparedStatement.setString(3, member.getFullName());
            preparedStatement.setString(4, member.getAvatar());
            preparedStatement.setLong(5, member.getRemainTime());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public ArrayList<Member> getList() {
        ArrayList<Member> results = new ArrayList<>();
        try {
            String sqlCommand = "select * from members";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String rsUsername = resultSet.getString("username");
                String rsPassword = resultSet.getString("password");
                String rsFullName = resultSet.getString("fullName");
                String rsAvatar = resultSet.getString("avatar");
                long rsRemainTime = resultSet.getLong("remainTime");
                Member member = new Member();
                member.setUsername(rsUsername);
                member.setPassword(rsPassword);
                member.setFullName(rsFullName);
                member.setAvatar(rsAvatar);
                member.setRemainTime(rsRemainTime);
                results.add(member);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;
    }

    public static void main(String[] args) {
        MemberModel model = new MemberModel();
//        Member member = new Member();
//        member.setUsername("xuanhung2401");
//        member.setPassword("1234");
//        member.setFullName("Xuan Hung");
//        member.setAvatar("https://i.pinimg.com/280x280_RS/ae/50/c4/ae50c4f55e7e04c893a5c0a72ddd99c3.jpg");
//        member.setRemainTime(24 * 60 * 60 * 1000);
//        model.save(member);

        ArrayList<Member> members = model.getList();
        for (int i = 0; i < members.size(); i++) {
            System.out.println(members.get(i).getFullName());
        }
    }
}
