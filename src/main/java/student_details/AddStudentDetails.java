package student_details;



import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

//import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

public class AddStudentDetails 
{

	public static void main(String[] args) throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		Connection con=null;
		PreparedStatement ps=null;
		
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gl", "root", "root");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			
		}
		
		
		int rollno=0;
		do
		{
			System.out.print("Enter roll no: ");
			String rollstring=sc.nextLine();
			
			try
			{
				rollno=Integer.parseInt(rollstring);
				if(String.valueOf(rollno).length()!=4)
				{
					rollno=0;
				}
			}
			catch(Exception e)
			{}
			
			
		}
		while(rollno==0);
		
		
		
		String student_name="";
		boolean lowercase;
		
		do
		{
			System.out.println("Enter name : ");
			student_name=sc.nextLine();
			
			lowercase=false;
			for(int i=0;i<student_name.length();i++)
			{
				if(Character.isLowerCase(student_name.charAt(i)))
				{
					lowercase=true;
					break;
				}
				
			}
		}
		while(student_name.length()>20 || lowercase);
		
		
		
		
		String standard="";
		String[] standards= {"I","II","III","IV","V","VI","VII","VII","IX","X"};
		List<String> list=new ArrayList<String>(Arrays.asList(standards));
		do
		{
			System.out.println("Enter standard : ");
			standard=sc.nextLine();
		}
		while(!list.contains(standard));
		
		
		System.out.println("Enter Date of Birth : ");
		String date_of_birth=sc.nextLine();
		
		
		
		Double fees=0.0;
		do	
		{
			System.out.println("Enter fees : ");
			if(sc.hasNextDouble())
			{
				fees=sc.nextDouble();
			}
		}
		while(fees==0.0);
		
			
		String sql="Insert into student values(?,?,?,?,?)";
		try
		{
			ps=con.prepareStatement(sql);
			//ResultSet rs = ps.executeQuery(selectQuery);
			ps.setInt(1, rollno);
			ps.setString(2, student_name);
			ps.setString(3, standard);
			ps.setString(4,date_of_birth);
			ps.setDouble(5, fees);
			int logged = ps.executeUpdate();
			//ps.executeQuery();
			System.out.println("Student details added successfully !");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Error");
			ps.close();
			con.close();
		}
		sc.close();
	}

}
