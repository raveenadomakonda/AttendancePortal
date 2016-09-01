CREATE TABLE Student (
Rollno int,
LastName varchar(255),
FirstName varchar(255),
FatherName varchar(255),
Year int,
Branch varchar(255),
Phone int(10)
);

/*CREATE TABLE Teacher (
TeacherId int,
LastName varchar(255),
FirstName varchar(255),
Phone int
);

CREATE TABLE Course (
CourseId int
CourseName varchar(255),
);*/

//System.out.println(System.getProperty("user.dir"));
		//System.out.println(System.getProperty("user.dir").replaceAll("\\\\", "/")+"/"+"db/sql/CreateTable.sql");

//st.executeUpdate("CREATE TABLE DummyTable (PersonID int,LastName varchar(255),FirstName varchar(255))"); 
		//System.out.println("DummyTable created!!! ");
		//st.executeUpdate("INSERT INTO DummyTable VALUES (1,'Doma','Anurag') "); 
		//ResultSet rs = st.executeQuery("SELECT * FROM DummyTable");

 // the order of the rows in a cursor
        // are implementation dependent unless you use the SQL ORDER statement
        // the result set is a cursor into the data.  You can only
        // point to one row at a time
        // assume we are pointing to BEFORE the first row
        // rs.next() points to next row and returns true
        // or false if there is no next row, which breaks the loop

//st.executeUpdate("CREATE TABLE Type (TypeId int, TypeName varchar(255)) ");
		//System.out.println("Type table created");
		//st.executeUpdate("INSERT INTO Type VALUES (1,'Admin'),(2,'Faculty'),(3,'Student')");
		//System.out.println("Populated Type Tbale");