package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class jdbcCRUDex {

    private  int sernum;
    private  int id;
    private String name;
    private String mail;
    private String address;
    private  long salary;

    public int getSernum() {
        return sernum;
    }

    public void setSernum(int sernum) {
        this.sernum = sernum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public jdbcCRUDex(int sernum, int id, String name, String mail, String address, long salary) {
        this.sernum = sernum;
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.address = address;
        this.salary = salary;
    }

    public static void main(String[] args) {
//	         create();
        retreve();
//	        update();
//	        delete();
    }
    public static void retreve(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emploiye", "root", "pavan");
            Statement stst = con.createStatement();
            ResultSet re = stst.executeQuery("select * from emploiye");

            while(re.next()){

                System.out.println(re.getInt("snum"));
                System.out.println(re.getString("empid"));
                System.out.println(re.getString("name"));
                System.out.println(re.getString("mailid"));
                System.out.println(re.getString("address"));
                System.out.println(re.getString("sal"));
                System.out.println();

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public  static  void create(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter serisl number : ");
        int senum = sc.nextInt();
        System.out.println("enter id : ");
        int id = sc.nextInt();
        System.out.println("enter name : ");
        String name = sc.next();
        System.out.println("enter mail: ");
        String mail = sc.next();
        System.out.println("enter address : ");
        String address = sc.next();
        System.out.println("enter salary : ");
        long sal = sc.nextInt();
        System.out.println("successfully created.........! ");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emploiye", "root", "pavan");
            Statement stst = con.createStatement();
            int re = stst.executeUpdate("insert into emploiye values("+senum+","+id+",'"+name+"','"+mail+"','"+address+"',"+sal+")");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public  static void update(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter mail: ");
        String mail = sc.next();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emploiye", "root", "pavan");
            Statement stst = con.createStatement();
            int re = stst.executeUpdate("update  emploiye set name='"+ mail +"' where snum=2");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public  static void delete(){
        Scanner sc = new Scanner(System.in);
        //System.out.println("enter serisl number : ");
        int senum = sc.nextInt();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emploiye", "root", "pavan");
            Statement stst = con.createStatement();
            int re = stst.executeUpdate("delete from emploiye where sernum = "+0+"");
            System.out.println("successfully deleted.........! ");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


