/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author TNO
 */
public class ManageDAO extends DBUtils {

    private Connection connection;
    private ResultSet rs;
    private List<Student> list;

    public ManageDAO() throws SQLException, ClassNotFoundException {
        connection = getConnection();
        list = new ArrayList<>();
    }

    public void addStudent(String name, String dob, String address, String teachingQuality, String stringCoure) {
        String sql = "INSERT INTO [dbo].[Student]\n"
                + "           ([name]\n"
                + "           ,[bod]\n"
                + "           ,[address]\n"
                + "           ,[course]\n"
                + "           ,[teachingQuality])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, dob);
            ps.setString(3, address);
            ps.setString(4, stringCoure);
            ps.setString(5, teachingQuality);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Student> findAllStudent() {
        String sql = "select * from Student";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Date bod = rs.getDate(3);
                String address = rs.getString(4);
                String course = rs.getString(5);
                String teachingQuality = rs.getString(6);

                Student student = new Student();
                
                student.setId(id);
                student.setName(name);
                student.setDob(bod);
                student.setAdress(address);
                student.setCourse(course);
                student.setTeachingQuality(teachingQuality);

                list.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

//    public static void main(String[] args) {
//        try {
//            ManageDAO dao = new ManageDAO();
//            List<Student> listTest = dao.findAllStudent();
//            for (Student o : listTest) {
//                System.out.println(o);
//            }
//            
//            
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(ManageDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ManageDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public void deleteStudent(int id) {
        String sql = "DELETE FROM [dbo].[Student]\n"
                + "      WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateStudent(int idUser, String name, String dob, String address, String teachingQuality) {
        String sql = "UPDATE [dbo].[Student]\n"
                + "   SET [name] = ?\n"
                + "      ,[bod] = ?\n"
                + "      ,[address] = ?\n"
                + "      ,[teachingQuality] = ?\n"
                + " WHERE [id] = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, dob);
            ps.setString(3, address);
            ps.setString(4, teachingQuality);
            ps.setInt(5, idUser);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public Student getInforStudent(int idUser) {
        String sql = "select * from Student\n"
                + "where id = ?";
        Student s = new Student();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idUser);
            rs = ps.executeQuery();
            rs.next();
            int id = rs.getInt(1);
            String name = rs.getString(2);
            Date bod = rs.getDate(3);
            String address = rs.getString(4);
            String course = rs.getString(5);
            String teachingQuality = rs.getString(6);
            
            s.setId(id);
            s.setName(name);
            s.setAdress(address);
            s.setCourse(course);
            s.setDob(bod);
            s.setTeachingQuality(teachingQuality);
            

        } catch (SQLException e) {
            System.out.println(e);
        }
        return s;
    }
public List<Student> searchByName(String nameInput) {
        String sql = "  select * from Student where [name]  like ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, "%" + nameInput + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Student s = null;
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Date bod = rs.getDate(3);
                String address = rs.getString(4);
                String course = rs.getString(5);
                String teachingQuality = rs.getString(6);
                s = new Student(id, name, bod, address, course, teachingQuality);
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public List<Student> searchByBod(String inputSearch) {
        String sql = "select * from Student where bod = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, inputSearch);
            rs = ps.executeQuery();

            while (rs.next()) {
                Student s = null;
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Date bod = rs.getDate(3);
                String address = rs.getString(4);
                String course = rs.getString(5);
                String teachingQuality = rs.getString(6);
                s = new Student(id, name, bod, address, course, teachingQuality);
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
}
