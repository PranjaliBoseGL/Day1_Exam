package show.studentDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetStudentDetails 
{


	public static void main(String[] args) 
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter roll no  : ");
		int rollno=sc.nextInt();
		showStudentDetails(rollno);
		//showStudentDetails(0);
		
		
	}
	
	public static void  showStudentDetails(Integer rollno)
	{
		
		System.out.println();
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gl", "root", "root");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		//System.out.println("Enter valid Roll no : ");
		//int rollno= sc.nextInt();
		//int rollno = 0;
		/*try 
		{
			rollno = Integer.parseInt(args[0]);
		} 
		catch (Exception e) {}*/


		try 
		{			
			// select student data from student table
			if (rollno != 0)
				sql = "SELECT * FROM student WHERE rollno = ?";
			else 
				sql = "SELECT * FROM student";

			pstmt = conn.prepareStatement(sql);
			if (rollno != 0) pstmt.setInt(1, rollno);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) 
			{
				int rollno1 = rs.getInt("rollno");
				String student_name = rs.getString("student_name");
				String standard = rs.getString("standard");
				String date_of_birth = rs.getString("date_of_birth");
				double fees= rs.getDouble("fees");

				System.out.println(rollno1 + " " + student_name + " " + standard + 
						" " + date_of_birth + " " + fees);
			}
		} 
		catch (SQLException e) 
		{ 
		
			e.printStackTrace();
		}		

		
		sc.close();
	}

}