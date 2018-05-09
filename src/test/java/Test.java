import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
	
	public static void main (String[] args){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
		String hashedPassword  = passwordEncoder.encode("1234");
		System.out.println(hashedPassword);
		System.out.println(passwordEncoder.matches("1234", "$2a$12$1hfh6qb07fnmbvRokYvdR.Ea0jLw5ZNp8wG.akwFDf/a/OVzPxbGu"));
		
	}
}
