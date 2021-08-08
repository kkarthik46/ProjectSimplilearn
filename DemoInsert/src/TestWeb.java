import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWeb {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.setProperty("webdriver.chrome.driver","E:\\selinieum\\chromedriver.exe");	
		WebDriver wb=new ChromeDriver();
		wb.manage().window().maximize();
		wb.get("http://localhost:8080/DemoInsert/index.html");
		wb.findElement(By.name("name")).sendKeys("david");
		wb.findElement(By.name("email")).sendKeys("abc@g.com");
		wb.findElement(By.name("submit")).submit();
		String result=wb.findElement(By.name("h1")).getText();
		//test whether the info has went into DB or not
		String expectedname="david";
		String expectedemail="abc@g.com";
		String expectedresult="insertion successfull";
		
		Connection con=DBUtil.getConnection();
		String sql="select * from student";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		boolean status=false;
		while(rs.next()) {
			String actualname=rs.getString(1);
			String actualemail=rs.getString(2);
			
			if(actualname.equals(expectedname)&&actualemail.equals(expectedemail)&&result.equals(expectedresult))
			{
				System.out.println("test case passed");
				status=true;
				break;
			}
		}
		
		if(status==false) {
			System.out.println("testcase failed");
		}
		
	}

}
