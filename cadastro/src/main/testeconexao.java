package main;

import java.sql.*;

public class testeconexao {
		
	public void conexao()
	{  
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:33061/pacientes","root","julimary2019");
			System.out.println("sucsex");
			
		}catch(Exception ex)
		{
			System.out.println(ex);
		}  
	}
	
}
