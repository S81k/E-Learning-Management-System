/**********************************************************************/
/* CASE STUDY :: E-Learning Management System */
/**********************************************************************/
package com.P;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.Desktop;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
public class main
{
private final String url = "jdbc:postgresql://localhost/201901206_LAB_9";
private final String user = "postgres";
private final String password = "admin";
/* function to connect to the postgresql database */
public Connection connect()
{
Connection conn = null;
try {
conn = DriverManager.getConnection(url, user, password);
System.out.println("Connected to the PostgreSQL server successfully.");
}
catch (SQLException e)
{
System.out.println(e.getMessage());
}
return conn;
}
/* This function inserts the data into the respective Table */
/*
In case of invalid entries,the triggers made corresponding to the schemas
will raise the exception
*/
/* Here we passed argument c in functions so that only authorized people can perform changes in the database */
/* Only Instructor can make changes to the lecture link table and grades table ,rest other changes in tables excluding these two can only be
performed by admin */
/* Student cannot make any changes to the database */
public void Insertion(String str, int c)
{
if (str.compareTo("student") == 0 && c == 2)
{
try {
String url = "jdbc:postgresql://localhost/201901206_LAB_9";
String user = "postgres";
String password = "admin";
Connection conn = DriverManager.getConnection(url, user, password);
String q = "insert into mydata.Student14(s_id,s_name,s_email,sem,cpi) values(?,?,?,?,?)";
PreparedStatement pst = conn.prepareStatement(q);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Scanner in = new Scanner(System.in);
System.out.println("Enter student ID of student");
BigDecimal ID = in.nextBigDecimal();
System.out.println("Enter name of student");
String name = br.readLine();
System.out.println("Enter email address of student");
String email = br.readLine();
System.out.println("Enter current semester of student ");
int sem = in.nextInt();
System.out.println("Enter CPI of student");
float cpi = in.nextFloat();
pst.setBigDecimal(1, ID);
pst.setString(2, name);
pst.setString(3, email);
pst.setInt(4, sem);
pst.setFloat(5, cpi);
pst.executeUpdate();
System.out.println("student details successfully inserted");
}
catch (Exception e)
{
e.printStackTrace();
}
}
else if (str.compareTo("admin") == 0 && c == 2)
{
try {
String url = "jdbc:postgresql://localhost/201901206_LAB_9";
String user = "postgres";
String password = "admin";
Connection conn = DriverManager.getConnection(url, user, password);
String q = "insert into mydata.Admin14(a_name,a_email,dept) values(?,?,?)";
PreparedStatement pst = conn.prepareStatement(q);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Scanner in = new Scanner(System.in);
System.out.println("Enter name of the person ");
String name = br.readLine();
System.out.println("Enter email of the person");
String email = br.readLine();
System.out.println("Enter the department");
String dept = br.readLine();
pst.setString(1, name);
pst.setString(2, email);
pst.setString(3, dept);
pst.executeUpdate();
System.out.println("admin details successfully inserted");
}
catch (Exception e)
{
e.printStackTrace();
}
}
else if (str.compareTo("course") == 0 && c == 2)
{
try {
String url = "jdbc:postgresql://localhost/201901206_LAB_9";
String user = "postgres";
String password = "admin";
Connection conn = DriverManager.getConnection(url, user, password);
String q = "insert into mydata.Course14(c_id,c_name,credits) values(?,?,?)";
PreparedStatement pst = conn.prepareStatement(q);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Scanner in = new Scanner(System.in);
System.out.println("Enter Course ID of the course ");
String cid = br.readLine();
System.out.println("Enter the name of the course");
String cname = br.readLine();
System.out.println("Enter total credits of the course");
float credits = in.nextFloat();
pst.setString(1, cid);
pst.setString(2, cname);
pst.setFloat(3, credits);
pst.executeUpdate();
System.out.println("course details successfully inserted");
}
catch (Exception e)
{
e.printStackTrace();
}
}
else if (str.compareTo("courseinstructor") == 0 && c == 2)
{
try {
String url = "jdbc:postgresql://localhost/201901206_LAB_9";
String user = "postgres";
String password = "admin";
Connection conn = DriverManager.getConnection(url, user, password);
String q = "insert into mydata.Courseinstructor14(i_id,c_id) values(?,?)";
PreparedStatement pst = conn.prepareStatement(q);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Scanner in = new Scanner(System.in);
System.out.println("Enter Instructor ID of the instructor");
String iid = br.readLine();
System.out.println("Enter the course ID that you are going to teach");
String cid = br.readLine();
pst.setString(1, iid);
pst.setString(2, cid);
pst.executeUpdate();
System.out.println("course details successfully inserted");
}
catch (Exception e)
{
e.printStackTrace();
}
}
else if (str.compareTo("grades") == 0 && c == 3)
{
try {
String url = "jdbc:postgresql://localhost/201901206_LAB_9";
String user = "postgres";
String password = "admin";
Connection conn = DriverManager.getConnection(url, user, password);
String q = "insert into mydata. Grades14(id,s_id,c_id,grade) values(?,?,?,?)";
PreparedStatement pst = conn.prepareStatement(q);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Scanner in = new Scanner(System.in);
System.out.println("Enter ID");
BigDecimal ID = in.nextBigDecimal();
System.out.println("Enter the student ID of the student");
BigDecimal SID = in.nextBigDecimal();
System.out.println("Enter Course ID of the course");
String cid = br.readLine();
System.out.println("Enter appropriate grade assigned to the student for this course");
String grade = br.readLine();
pst.setBigDecimal(1, ID);
pst.setBigDecimal(2, SID);
pst.setString(3, cid);
pst.setString(4, grade);
pst.executeUpdate();
System.out.println("grade details of student successfully inserted");
}
catch (Exception e)
{
e.printStackTrace();
}
}
else if (str.compareTo("instructor") == 0 && c == 2)
{
try {
String url = "jdbc:postgresql://localhost/201901206_LAB_9";
String user = "postgres";
String password = "admin";
Connection conn = DriverManager.getConnection(url, user, password);
String q = "insert into mydata.Instructor14(i_id,i_email,i_name) values(?,?,?)";
PreparedStatement pst = conn.prepareStatement(q);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Scanner in = new Scanner(System.in);
System.out.println("Enter Instructor ID of the instructor");
BigDecimal insID = in.nextBigDecimal();
System.out.println("Enter email address of the instructor");
String email = br.readLine();
System.out.println("Enter Name of Instructor ");
String namei = br.readLine();
pst.setBigDecimal(1, insID);
pst.setString(2, email);
pst.setString(3, namei);
pst.executeUpdate();
System.out.println("Instructor details of instructor successfully inserted");
}
catch (Exception e)
{
e.printStackTrace();
}
}
else if (str.compareTo("lecturelink") == 0 && c == 3)
{
try {
String url = "jdbc:postgresql://localhost/201901206_LAB_9";
String user = "postgres";
String password = "admin";
Connection conn = DriverManager.getConnection(url, user, password);
String q = "insert into mydata.leclinks14(c_id,l_day,l_link) values(?,?,?)";
PreparedStatement pst = conn.prepareStatement(q);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Scanner in = new Scanner(System.in);
System.out.println("Enter Course ID of a course");
String cid = br.readLine();
System.out.println("Enter the day the lecture of course is scheduled");
String day = br.readLine();
System.out.println("Enter the lecture link of the scheduled lecture ");
String link = br.readLine();
pst.setString(1, cid);
pst.setString(2, day);
pst.setString(3, link);
pst.executeUpdate();
System.out.println("lecture link details for the course successfully inserted");
}
catch (Exception e)
{
e.printStackTrace();
}
}
else if (str.compareTo("ta") == 0 && c == 2)
{
try {
String url = "jdbc:postgresql://localhost/201901206_LAB_9";
String user = "postgres";
String password = "admin";
Connection conn = DriverManager.getConnection(url, user, password);
String q = "insert into mydata.Ta14(s_id,c_id) values(?,?)";
PreparedStatement pst = conn.prepareStatement(q);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Scanner in = new Scanner(System.in);
System.out.println("Enter Student ID of the Teaching Assistant");
BigDecimal tID = in.nextBigDecimal();
System.out.println("Enter course ID of the course that TA is assisting in ");
String cid = br.readLine();
pst.setBigDecimal(1, tID);
pst.setString(2, cid);
pst.executeUpdate();
System.out.println("TA details successfully inserted");
}
catch (Exception e)
{
e.printStackTrace();
}
}
}
/* Performs deletion in the tables */
public void Deletion(String str, int c)
{
if (str.compareTo("admin") == 0 && c == 2)
{
try {
String url = "jdbc:postgresql://localhost/201901206_LAB_9";
String user = "postgres";
String password = "admin";
Connection conn = DriverManager.getConnection(url, user, password);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Scanner in = new Scanner(System.in);
System.out.println("Enter the email address of the admin that you want to delete");
String email = br.readLine();
String q = "delete from mydata.Admin14 where a_email= ?";
PreparedStatement pst = conn.prepareStatement(q);
pst.setString(1, email);
pst.executeUpdate();
System.out.println("admin details for the email address successfully deleted");
}
catch (Exception e)
{
e.printStackTrace();
}
}
else if (str.compareTo("course") == 0 && c == 2)
{
try {
String url = "jdbc:postgresql://localhost/201901206_LAB_9";
String user = "postgres";
String password = "admin";
Connection conn = DriverManager.getConnection(url, user, password);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Scanner in = new Scanner(System.in);
System.out.println("Enter the Course ID of course you want to delete");
String cid = br.readLine();
String q = "delete from mydata.Course14 where c_id= ?";
PreparedStatement pst = conn.prepareStatement(q);
pst.setString(1, cid);
pst.executeUpdate();
System.out.println("course details for the corresponding course ID successfully deleted");
}
catch (Exception e)
{
e.printStackTrace();
}
}
else if (str.compareTo("courseinstructor") == 0 && c == 2)
{
try {
String url = "jdbc:postgresql://localhost/201901206_LAB_9";
String user = "postgres";
String password = "admin";
Connection conn = DriverManager.getConnection(url, user, password);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Scanner in = new Scanner(System.in);
System.out.println("Enter the Instructor ID of the instructor that you want to delete");
BigDecimal ID = in.nextBigDecimal();
String q = "delete from mydata.Courseinstructor14 where i_id= ?";
PreparedStatement pst = conn.prepareStatement(q);
pst.setBigDecimal(1, ID);
pst.executeUpdate();
System.out.println("course instructor details successfully deleted");
}
catch (Exception e)
{
e.printStackTrace();
}
}
else if (str.compareTo("instructor") == 0 && c == 2)
{
try {
String url = "jdbc:postgresql://localhost/201901206_LAB_9";
String user = "postgres";
String password = "admin";
Connection conn = DriverManager.getConnection(url, user, password);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Scanner in = new Scanner(System.in);
System.out.println("Enter the instructor ID of the instructor that you want to delete");
BigDecimal ID = in.nextBigDecimal();
String q = "delete from mydata.Instructor14 where i_id= ?";
PreparedStatement pst = conn.prepareStatement(q);
pst.setBigDecimal(1, ID);
pst.executeUpdate();
System.out.println("Instructor details of the instructor ID successfully deleted");
}
catch (Exception e)
{
e.printStackTrace();
}
}
else if (str.compareTo("lecturelink") == 0 && c == 3)
{
try {
String url = "jdbc:postgresql://localhost/201901206_LAB_9";
String user = "postgres";
String password = "admin";
Connection conn = DriverManager.getConnection(url, user, password);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Scanner in = new Scanner(System.in);
System.out.println("Enter the course ID of the course for which you want to dekete the link");
String S1 = br.readLine();
String q = "delete from mydata.leclinks14 where c_id= ?";
PreparedStatement pst = conn.prepareStatement(q);
pst.setString(1, S1);
pst.executeUpdate();
System.out.println("lecture link details of the course ID entered are successfully deleted");
}
catch (Exception e)
{
e.printStackTrace();
}
}
else if (str.compareTo("student") == 0 && c == 2)
{
try {
String url = "jdbc:postgresql://localhost/201901206_LAB_9";
String user = "postgres";
String password = "admin";
Connection conn = DriverManager.getConnection(url, user, password);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Scanner in = new Scanner(System.in);
System.out.println("Enter the Student ID of the Student that you want to delete");
BigDecimal SID = in.nextBigDecimal();
String q = "delete from mydata.Student14 where s_id= ?";
PreparedStatement pst = conn.prepareStatement(q);
pst.setBigDecimal(1, SID);
pst.executeUpdate();
System.out.println("Student details of the student ID are successfully deleted");
}
catch (Exception e)
{
e.printStackTrace();
}
}
else if (str.compareTo("ta") == 0 && c == 2)
{
try {
String url = "jdbc:postgresql://localhost/201901206_LAB_9";
String user = "postgres";
String password = "admin";
Connection conn = DriverManager.getConnection(url, user, password);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Scanner in = new Scanner(System.in);
System.out.println("Enter the Student ID of the Teaching Assistant that you want to delete");
BigDecimal tID = in.nextBigDecimal();
String q = "delete from mydata.Ta14 where s_id= ?";
PreparedStatement pst = conn.prepareStatement(q);
pst.setBigDecimal(1, tID);
pst.executeUpdate();
System.out.println("TA details corresponding to student ID tID are successfully deleted");
}
catch (Exception e)
{
e.printStackTrace();
}
}
else if (str.compareTo("grade") == 0 && c == 3)
{
try {
String url = "jdbc:postgresql://localhost/201901206_LAB_9";
String user = "postgres";
String password = "admin";
Connection conn = DriverManager.getConnection(url, user, password);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Scanner in = new Scanner(System.in);
System.out.println("Enter the Student ID of the Student for which you want to delete grade detail");
BigDecimal SID = in.nextBigDecimal();
System.out.println("Enter the Course ID of course of which you want to delete grade details");
String cid = br.readLine();
String q = "delete from mydata.grades14 where s_id= ? and c_id=?";
PreparedStatement pst = conn.prepareStatement(q);
pst.setBigDecimal(1, SID);
pst.setString(2, cid);
pst.executeUpdate();
System.out.println("Grade details of the student ID for the course are successfully deleted");
}
catch (Exception e)
{
e.printStackTrace();
}
}
}
/* This function updates the already present values. Updation of data is done by authorized personnel only */
public void Updation(String str, int c)
{
if (str.compareTo("grades") == 0 && c == 3)
{
try {
String url = "jdbc:postgresql://localhost/201901206_LAB_9";
String user = "postgres";
String password = "admin";
Connection conn = DriverManager.getConnection(url, user, password);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Scanner in = new Scanner(System.in);
System.out.println("Enter ID");
BigDecimal ID = in.nextBigDecimal();
System.out.println("Enter the student ID of the student ");
BigDecimal SID = in.nextBigDecimal();
System.out.println("Enter Course ID of the course you want to update");
String cid = br.readLine();
System.out.println("Enter appropriate grade that you want to update to the student for this course");
String grade = br.readLine();
String q = " update mydata.grades14 SET c_id = ?,grade =? WHERE id = ? and s_id = ? ";
PreparedStatement pst = conn.prepareStatement(q);
pst.setString(1, cid);
pst.setString(2, grade);
pst.setBigDecimal(3, ID);
pst.setBigDecimal(4, SID);
pst.executeUpdate();
System.out.println("Grade details of the student ID for the course are successfully updated");
}
catch (Exception e)
{
e.printStackTrace();
}
}
else if (str.compareTo("courseinstructor") == 0 && c == 2)
{
try {
String url = "jdbc:postgresql://localhost/201901206_LAB_9";
String user = "postgres";
String password = "admin";
Connection conn = DriverManager.getConnection(url, user, password);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Scanner in = new Scanner(System.in);
System.out.println("Enter Instructor ID of the instructor");
BigDecimal iID = in.nextBigDecimal();
System.out.println("Enter Course ID of the course you want to update");
String cid = br.readLine();
String q = " update mydata.courseinstructor14 SET c_id = ? WHERE i_id = ?";
PreparedStatement pst = conn.prepareStatement(q);
pst.setString(1, cid);
pst.setBigDecimal(2, iID);
pst.executeUpdate();
System.out.println("course instructor details of the instructor successfully updated");
}
catch (Exception e)
{
e.printStackTrace();
}
} else if (
str.compareTo("admin") == 0
&& c
== 2)
{
try {
String url = "jdbc:postgresql://localhost/201901206_LAB_9";
String user = "postgres";
String password = "admin";
Connection conn = DriverManager.getConnection(url, user, password);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Scanner in = new Scanner(System.in);
System.out.println("Enter name of admin");
String name = br.readLine();
System.out.println("Enter the email address of the admin");
String email = br.readLine();
System.out.println("Enter the department of the admin");
String dept = br.readLine();
String q = " update mydata.admin14 SET dept = ?, WHERE a_name = ? and a_email = ? ";
PreparedStatement pst = conn.prepareStatement(q);
pst.setString(1, dept);
pst.setString(2, name);
pst.setString(3, email);
pst.executeUpdate();
System.out.println("admin details of admin are successfully updated");
}
catch (Exception e)
{
e.printStackTrace();
}
}
else if (str.compareTo("lecturelink") == 0 && c == 3)
{
try {
String url = "jdbc:postgresql://localhost/201901206_LAB_9";
String user = "postgres";
String password = "admin";
Connection conn = DriverManager.getConnection(url, user, password);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Scanner in = new Scanner(System.in);
System.out.println("Enter the course ID");
String cid = br.readLine();
System.out.println("Enter the day the lecture for this course is scheduled");
String day = br.readLine();
System.out.println("Enter the lecture link ");
String link = br.readLine();
String q = "update leclinks14 SET l_day=?,l_link= WHERE c_id=?;";
PreparedStatement pst = conn.prepareStatement(q);
pst.setString(1, day);
pst.setString(2, link);
pst.setString(3, cid);
pst.executeUpdate();
System.out.println("lecture link details of the course are successfully inserted");
}
catch (Exception e)
{
e.printStackTrace();
}
}
else if (str.compareTo("student") == 0 && c == 2)
{
try {
String url = "jdbc:postgresql://localhost/201901206_LAB_9";
String user = "postgres";
String password = "admin";
Connection conn = DriverManager.getConnection(url, user, password);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Scanner in = new Scanner(System.in);
System.out.println("Enter ID of student");
BigDecimal ID = in.nextBigDecimal();
System.out.println("Enter name of student");
String name = br.readLine();
System.out.println("Enter email of student");
String email = br.readLine();
System.out.println("Enter sem of student");
int sem = in.nextInt();
System.out.println("Enter cpi of student");
float cpi = in.nextFloat();
String q = "update student14 SET cpi=?,sem=? WHERE s_id=? and s_name=? and s_email=?;";
PreparedStatement pst = conn.prepareStatement(q);
pst.setInt(2, sem);
pst.setFloat(1, cpi);
pst.setBigDecimal(3, ID);
pst.setString(4, name);
pst.setString(5, email);
pst.executeUpdate();
System.out.println("student details of the student are successfully updated");
}
catch (Exception e)
{
e.printStackTrace();
}
}
}
/* Display of results obtained according to query written */
public void display()
{
try {
String url = "jdbc:postgresql://localhost/201901206_LAB_9";
String user = "postgres";
String password = "admin";
String q;
Connection conn = DriverManager.getConnection(url, user, password);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Scanner in = new Scanner(System.in);
q = br.readLine();
PreparedStatement pst = conn.prepareStatement(q);
ResultSet result = pst.executeQuery();
ResultSetMetaData rsmd = result.getMetaData();
/* To obtain number of columns in the resultant table of the query*/
int cn = rsmd.getColumnCount();
for (int i = 1; i <= cn; i++)
{
if (i == 1)
System.out.print(" ( " + rsmd.getColumnName(i) + " , ");
else if (i == cn)
System.out.print(rsmd.getColumnName(i) + " ) ");
else
System.out.print(rsmd.getColumnName(i) + " , ");
}
System.out.println();
while (result.next())
{
int x = 1;
while (x <= cn)
{
if (x == 1)
System.out.print("(" + result.getString(x) + " , ");
else if (x == cn)
System.out.print(result.getString(x) + " ) ");
else
System.out.print(result.getString(x) + " , ");
x++;
}
System.out.println();
}
}
catch (Exception e)
{
e.printStackTrace();
}
}
/* Main function */
public static void main(String[] args)
{
main app = new main();
app.connect(); // to establish the connection with postgresql database
Scanner p = new Scanner(System.in);
int c;
System.out.println("Enter the number that you belong to among these choices :");
System.out.println("1 -- Student");
System.out.println("2 -- Admin");
System.out.println("3 -- Instructor");
c = p.nextInt();
int n;
do {
System.out.println("Enter a value among the given choices:");
System.out.println(" 1 -- Insertion of data");
System.out.println(" 2 -- Deletion of data ");
System.out.println(" 3 -- Updation of existing data");
System.out.println(" 4 -- Display the data ");
System.out.println(" 5 -- Terminate ");
Scanner a = new Scanner(System.in);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
n = a.nextInt();
if (n == 1 && c != 1)
{
main tut = new main();
String s;
Scanner scan = new Scanner(System.in);
System.out.println("In which Table,you want to perform Insertion");
System.out.println("It should be one of the following 8 tables");
System.out.println(" 1 -- student");
System.out.println(" 2 -- course ");
System.out.println(" 3 -- courseinstructor");
System.out.println(" 4 -- grades ");
System.out.println(" 5 -- lecturelink");
System.out.println(" 6 -- instructor ");
System.out.println(" 7 -- admin");
System.out.println(" 8 -- ta ");
s = scan.nextLine();
app.Insertion(s, c);
}
else if (n == 2 && c != 1)
{
main del = new main();
String input;
Scanner scan = new Scanner(System.in);
System.out.println("In which table,you want to delete the record");
System.out.println("It should be one of the following 8 tables");
System.out.println(" 1 -- student");
System.out.println(" 2 -- course ");
System.out.println(" 3 -- courseinstructor");
System.out.println(" 4 -- grades ");
System.out.println(" 5 -- lecturelink");
System.out.println(" 6 -- instructor ");
System.out.println(" 7 -- admin");
System.out.println(" 8 -- ta ");
input = scan.nextLine();
app.Deletion(input, c);
}
else if (n == 3 && c != 1) {
main del = new main();
String input;
Scanner scan = new Scanner(System.in);
System.out.println("In which table,you want to update the record");
System.out.println("It should be one of the following 8 tables");
System.out.println(" 1 -- student");
System.out.println(" 2 -- course ");
System.out.println(" 3 -- courseinstructor");
System.out.println(" 4 -- grades ");
System.out.println(" 5 -- lecturelink");
System.out.println(" 6 -- instructor ");
System.out.println(" 7 -- admin");
System.out.println(" 8 -- ta ");
input = scan.nextLine();
app.Updation(input, c);
}
else if (n == 4) {
System.out.println("Write a query of your choice to display the data");
app.display();
}
else
{
System.out.println("Invalid number entered");
}
} while (n != 5);
System.out.println("Program terminated");
}
}