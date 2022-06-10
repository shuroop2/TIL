# TIL_Day_20

> 2022년 06월 09일

## JDBC

### JDBC 예제

- DBConnect

  > DB 연결 처리하는 클래스

  - getConnection() : DB 연결하고 con 객체 반환
  - close() : 리소스 close 객체 수에 따라 메소드 오버로딩
  - 앞으로 DB 연결은 각 클래스에서 `DBConnect.getConnection()` 호출하고 con 객체 받아옴

  ```java
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.PreparedStatement;
  import java.sql.ResultSet;
  import java.sql.SQLException;
  
  // DB 연결 담당 클래스 
  public class DBConnect {
  
  	// 데이터베이스 연결하고 Connection 객체 반환 메소드
  	// 호출하는데서 객체 생성하지 바로 메소드 호출해서 사용할 수 있도록
  	// static 메소드로 정의
  	public static Connection getConnection() {
  		Connection con = null;
  		try {
  			// JDBC Driver 클래스의 객체 생성 런타임 시 로드
  			// Class.forName("com.mysql.cj.jdbc.Driver");
  
  			// 연결 url, 사용자 계정, 패스워드 문자열로 지정
  			String url = "jdbc:mysql://localhost:3306/sqldb3?serverTimezone-UTC";
  			String user = "root";
  			String pwd = "1234";
  
  			// DB 연결하기 위한 객체
  			// DriverManager를 통해 Connection 객체 생성
  			// MySQL 서버 연결 : url, 사용자 계정, 패스워드 전송
  			con = DriverManager.getConnection(url, user, pwd);
  
  			// Connection 객체 생성되면 DB 연결 성공
  			if (con != null) {
  				System.out.println("DB 연결 성공");
  			}
  		} catch (Exception e) {
  			System.out.println("오류 발생");
  			e.printStackTrace();
  		}
  		return con;
  	}
  	// 사용한 리소스 반납하는 close() 메소드 생성
  	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
  		try {
  			if (rs != null)
  				rs.close();
  			rs = null;
  			if (pstmt != null)
  				pstmt.close();
  			pstmt = null;
  			if (con != null)
  				con.close();
  			con = null;
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  	}
  	// 메소드 오버로딩
  	public static void close(Connection con, PreparedStatement pstmt) {
  		try {
  			if (pstmt != null)
  				pstmt.close();
  			pstmt = null;
  			if (con != null)
  				con.close();
  			con = null;
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  	}
  }

- BookSelectMain

  > 도서 정보 조회 클래스 (SELECT)

  ```java
  import java.sql.Connection;
  import java.sql.PreparedStatement;
  import java.sql.ResultSet;
  import java.util.Date;
  
  public class BookSelectMain {
  
  	public static void main(String[] args) {
  		// JDBC : 도서 정보 조회 클래스 (SELECT 수행)
  
  		Connection con = null;
  
  		// (1) DB 연결
  		try {
  			// DB 연결 담당 클래스의 연결 메소드 호출해서 Connection 객체 받아옴
  			con = DBConnect.getConnection();
  
  			// (2) 쿼리문 작성 : SELECT
  			// String sql = "select * from book where bookPrice >= 25000 order by bookNo ";
  			String sql = "select * from book order by bookNo ";
  
  			// (3) 쿼리문 전송을 위한 PreparedStatement 객체 생성
  			// Connection 인터페이스의 prepareStatement() 메소드를 사용하여 객체 생성
  			PreparedStatement pstmt = con.prepareStatement(sql);
  
  			// (4) 쿼리문 실행시키고 결과 받아옴
  			// executeQuery() 메소드 사용
  			// 결과는 ResultSet 객체가 받음
  			ResultSet rs = pstmt.executeQuery(sql);
  			System.out.println("도서 정보 조회");
  			System.out.println("도서번호 \t  도서명 \t\t\t\t\t 저자 \t 가격 \t\t    발행일 \t\t\t 재고 \t     출판사번호");
  			
  			// (5) executeQuery() 실행 결과 받아온 ResultSet에서 데이터 추출
  			// ResultSet의 next() 메소드를 이용해서 논리적 커서 이동해하면서 다음 행 지정
  			// -- 다음 행이 있으면 true, 없으면 false 반환
  			// 모든 행 가져오려면 반복문 사용
  			// 데이터 타입에 맞춰 getXXX() 메소드 사용
  			while (rs.next()) {
  				String bookNo = rs.getString(1);
  				String bookName = rs.getString(2);
  				String bookAuthor = rs.getNString(3);
  				int bookPrice = rs.getInt(4);
  				Date bookDate = rs.getDate(5);
  				int bookStock = rs.getInt(6);
  				String pubNo = rs.getString(7);
  				// (6) 한 행씩 출력
  				System.out.format("%-10s\t%-25s\t%10s\t%6d\t %13s\t%3d\t%10s\n", bookNo, bookName, bookAuthor,
  						bookPrice, bookDate, bookStock, pubNo);
  			}
  			// (7) 리소스 닫기 (close)
  			DBConnect.close(con, pstmt, rs);
  		} catch (Exception e) {
  			System.out.println("오류 발생");
  			e.printStackTrace();
  		}
  	}
  }

- BookInsertMain

  > 도서 정보 입력 클래스 (INSERT)

  ```java
  import java.sql.Connection;
  import java.sql.PreparedStatement;
  
  public class BookInsertMain {
  
  	public static void main(String[] args) {
  		// JDBC : 도서 정보 등록 클래스 (INSERT 수행)
  
  		Connection con = null;
  
  		// (1) DB 연결
  		try {
  			// Connection 객체 받아옴
  			con = DBConnect.getConnection();
  
  			// 저장할 데이터 변수에 저장해서 사용
  			String bookNo = "1017";
  			String bookName = "알고리즘2";
  			String bookAuthor = "김철수";
  			int bookPrice = 25000;
  			String bookDate = "2022-01-05";
  			int bookStock = 10;
  			String pubNo = "1";
  
  			// (2) 쿼리문 작성 : INSERT
  			// 저장할 데이터 위치 설정 : values(?,?,?,?,?,?,?)
  			String sql = "insert into book values (?,?,?,?,?,?,?)";
  
  			// (3) sql문 values에 들어갈 데이터 설정
  			// setXXX() 메소드 사용 : pstmt.setString(1, bookNo)
  			PreparedStatement pstmt = con.prepareStatement(sql);
  			pstmt.setString(1, bookNo);
  			pstmt.setString(2, bookName);
  			pstmt.setString(3, bookAuthor);
  			pstmt.setInt(4, bookPrice);
  			pstmt.setString(5, bookDate);
  			pstmt.setInt(6, bookStock);
  			pstmt.setString(7, pubNo);
  
  			// (4) 쿼리문 실행 : executeUpdate()
  			// 영향을 받은 행의 수 반환
  			// 작업 완료 메시지 출력
  			// result가 0보다 크면 입력 성공 (1행이라도 영향을 받았으면 성공)
  
  			// pstmt.executeUpdate();
  			int result = pstmt.executeUpdate();
  
  			if (result > 0) {
  				System.out.println("도서 정보 등록 성공");
  			}
  
  			// 리소스 close()
  			DBConnect.close(con, pstmt);
  		} catch (Exception e) {
  			System.out.println("오류 발생");
  			e.printStackTrace();
  		}
  	}
  }

- BookUpdateMain

  > 도서 정보 수정 클래스 (UPDATE)

  ```java
  import java.sql.Connection;
  import java.sql.PreparedStatement;
  import java.sql.SQLException;
  import java.util.Scanner;
  
  public class BookUpdateMain {
  	public static void main(String[] args) {
  		// JDBC : 도서 정보 수정 (UPDATE)
  		
  		// 1) DB 연결
  		Connection con = DBConnect.getConnection();
  		
  		// 2) 수정할 데이터 입력
  		Scanner sc = new Scanner(System.in);
  		
  		System.out.println("도서 정보 수정");
  		
  		System.out.print("수정할 도서 번호 입력 : ");
  		String bookNo = sc.nextLine();
  		
  		System.out.print("도서명 입력 : ");
  		String bookName = sc.nextLine();
  		
  		System.out.print("저자 입력 : ");
  		String bookAuthor = sc.nextLine();
  		
  		System.out.print("가격 입력 : ");
  		int bookPrice = sc.nextInt();
  		sc.nextLine(); // 앞의 엔터값이 다음 변수에 들어가지 않도록 버퍼 읽어들임
  		
  		System.out.print("발행일 입력 : ");
  		String bookDate = sc.nextLine();
  		
  		System.out.print("재고 입력 : ");
  		int bookStock = sc.nextInt();
  		sc.nextLine();
  		
  		System.out.print("출판사 번호 입력 : ");
  		String pubNo = sc.nextLine();
  		
  		try {
  			// 3) 쿼리문 작성 : update
  			// UPDATE 테이블명 SET 열이름=값 WHERE 조건;
  			// 주의 : 기본키인 bookNo는 수정 안함 
  			String sql = "update book set bookName=?, bookAuthor=?, bookPrice=?, bookDate=?, bookStock=?, pubNo=? "
  					+ "where bookNo=?";
  			
  			PreparedStatement pstmt = con.prepareStatement(sql);
  			pstmt.setString(1, bookName);
  			pstmt.setString(2, bookAuthor);
  			pstmt.setInt(3, bookPrice);
  			pstmt.setString(4, bookDate);
  			pstmt.setInt(5, bookStock);
  			pstmt.setString(6, pubNo);
  			pstmt.setString(7, bookNo);
  			
  			// 4) 쿼리문 실행
  			int result = pstmt.executeUpdate(); // insert / update / delete : executeUpdate();
  			
  			if(result > 0) {
  				System.out.println("도서 정보 수정 성공");
  			}
  			
  			// 5) 리소스 close()
  			DBConnect.close(con, pstmt);
  			sc.close();
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}	
  	}
  }
  ```

- BookDeleteMain

  > 도서 정보 삭제 클래스 (DELETE)

  ```java
  import java.sql.Connection;
  import java.sql.PreparedStatement;
  import java.sql.SQLException;
  import java.util.Scanner;
  
  public class BookDeleteMain {
  	public static void main(String[] args) {
  		// JDBC : 도서 정보 삭제 (DELETE)
  		
  		// 1) DB 연결
  		Connection con = DBConnect.getConnection();
  		
  		// 2) 삭제할 도서번호 입력
  		Scanner sc = new Scanner(System.in);
  		
  		System.out.println("도서 정보 삭제");
  		
  		System.out.print("삭제할 도서 번호 입력 : ");
  		String bookNo = sc.nextLine();
  		
  		try {
  			// 3) 쿼리문 작성 : DELETE
  			String sql = "delete from book where bookNo=?";
  			
  			PreparedStatement pstmt = con.prepareStatement(sql);
  			pstmt.setString(1, bookNo);
  			
  			// 4) 쿼리문 실행 : executeUpdate()
  			int result = pstmt.executeUpdate();
  			
  			if(result > 0) {
  				System.out.println("도서 정보 삭제 성공");
  			}
  			
  			// 5) 리소스 close()
  			DBConnect.close(con, pstmt);
  			sc.close();
  			
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  	}
  }
  ```

### DTO / DAO

- DTO (Data Transfer Object)

  > 데이터 저장용 클래스

  - 데이터베이스에 데이터 저장하거나 데이터베이스로부터 데이터를 조회할 때 데이터를 저장하기 위해 사용
  - 멤버 필드 / 생성자 / Getters&Setters

- DAO (Data Access Object)

  > 데이터베이스에 액세스하는 클래스

  - 데이터베이스에 데이터를 저장하거나 데이터베이스로부터 데이터를 가져올 때 사용
    1. DB 연결
    2. select() / insert() / update() / delete() 기능의 메소드 포함

- DTO / DAO 사용 예제

  - StudentDTO

    - 필드 (데이터베이스의 테이블 열과 동일)
    - 생성자 (초기화)
    - Getters&Setters

    ```java
    public class StudentDTO {
    	private String stdNo;
    	private String stdName;
    	private int stdYear;
    	private String stdAddress;
    	private String stdBirthday;
    	private String dptNo;
    	
    	public StudentDTO(String stdNo, String stdName, int stdYear, String stdAddress, String stdBirthday, String dptNo) {
    		this.stdNo = stdNo;
    		this.stdName = stdName;
    		this.stdYear = stdYear;
    		this.stdAddress = stdAddress;
    		this.stdBirthday = stdBirthday;
    		this.dptNo = dptNo;
    	}
    
    	public String getStdNo() {
    		return stdNo;
    	}
    
    	public void setStdNo(String stdNo) {
    		this.stdNo = stdNo;
    	}
    
    	public String getStdName() {
    		return stdName;
    	}
    
    	public void setStdName(String stdName) {
    		this.stdName = stdName;
    	}
    
    	public int getStdYear() {
    		return stdYear;
    	}
    
    	public void setStdYear(int stdYear) {
    		this.stdYear = stdYear;
    	}
    
    	public String getStdAddress() {
    		return stdAddress;
    	}
    
    	public void setStdAddress(String stdAddress) {
    		this.stdAddress = stdAddress;
    	}
    
    	public String getStdBirthday() {
    		return stdBirthday;
    	}
    
    	public void setStdBirthday(String stdBirthday) {
    		this.stdBirthday = stdBirthday;
    	}
    
    	public String getDptNo() {
    		return dptNo;
    	}
    
    	public void setDptNo(String dptNo) {
    		this.dptNo = dptNo;
    	}
    }

  - StudentDAO

    - 생성자에서 DB 연결
    - selectStudent() 메소드
    - insertStudent() 메소드

    ```java
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.Date;
    
    public class StudentDAO {
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    
    	public StudentDAO() {
    		// DB 연결 담당
    		try {
    			// JDBC Driver 클래스의 객체 생성 런타임 시 로드
    			// Class.forName("com.mysql.cj.jdbc.Driver");
    			
    			// 연결 url, 사용자 계정, 비밀번호 문자열로 설정
    			String url = "jdbc:mysql://localhost:3306/sqldb3?serverTimezone-UTC";
    			String user = "root";
    			String pwd = "1234";
    			
    			// DB 연결하기 위한 객체
    			// DriverManager를 통해 Connection 객체 생성
    			// MySQL 서버 연결 : url, 사용자 계정, 비밀번호 전송
    			con = DriverManager.getConnection(url, user, pwd);
    			
    			// Connection 객체 생성되면 DB 연결 성공
    			if(con != null) {
    				System.out.println("DB 연결 성공");
    			} 
    			
    		} catch (Exception e) {
    			System.out.println("오류 발생");
    			e.printStackTrace();
    		}
    	}
    	// select문 수행해서 데이터베이스의 student 테이블 내용 조회 / 출력할 메소드
    	public void selectStudent() {
    		try {
    			// 쿼리문 작성
    			String sql = "select * from student order by stdNo";
    			
    			pstmt = con.prepareStatement(sql);
    			
    			// 쿼리문 실행
    			rs = pstmt.executeQuery(sql);
    			
    			while(rs.next()) {
    				String stdNo = rs.getString(1);
    				String stdName = rs.getString(2);
    				int stdYear = rs.getInt(3);
    				String stdAddress = rs.getString(4);
    				Date stdBirthday = rs.getDate(5);
    				String dptNo = rs.getString(6);
    				
    				System.out.format("%-10s\t%-10s\t%-4d\t%-20s\t%13s\t%5s\n",
    						stdNo, stdName, stdYear, stdAddress, stdBirthday, dptNo);
    			}
    			
    		} catch (SQLException e) {
    			System.out.println("오류 발생");
    			e.printStackTrace();
    		}
    	}
    	// insert문 수행해서 데이터베이스의 student 테이블에 저장할 메소드
    	public void insertStudent(StudentDTO dto) {
    		try {
    			String sql = "insert into student values (?,?,?,?,?,?)";
    			
    			// sql문 values에 들어갈 데이터 설정
    			pstmt = con.prepareStatement(sql);
    			pstmt.setString(1, dto.getStdNo());
    			pstmt.setString(2, dto.getStdName());
    			pstmt.setInt(3, dto.getStdYear());
    			pstmt.setString(4, dto.getStdAddress());
    			pstmt.setString(5, dto.getStdBirthday());
    			pstmt.setString(6, dto.getDptNo());
    			
    			// 쿼리문 실행
    			int result = pstmt.executeUpdate();
    			
    			if(result > 0) {
    				System.out.println("학생 정보 입력 성공");
    			}
    			
    		} catch (SQLException e) {
    			System.out.println("오류 발생");
    			e.printStackTrace();
    		}
    	}
    }

  - StudentMain

    - StudentDAO 메소드 호출해서 select 와 insert 수행

    ```java
    public class StudentMain {
    	public static void main(String[] args) {
    		// DTO / DAO 사용
    		
    		// DAO 객체 생성하면서 DB연결
    		// selectStudent() 메소드 호출
    		StudentDAO stdDAO = new StudentDAO();
    		stdDAO.selectStudent();
    		
    		// 데이터 저장 : StudentDTO 객체 생성 / 데이터 저장
    		StudentDTO stdDTO = new StudentDTO("2022002", "변학도", 1, "제주도 서귀포시", "2022-1-1", "1");
    		
    		// insertStudent() 메소드 호출하면서 stdDTO 전달
    		stdDAO.insertStudent(stdDTO);
    	}
    }
