
@SpringBootApplication
public class SurveyApplication {
    public static void main(String[] args) {
        SpringApplication.run(SurveyApplication.class, args);
    }
}


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
   
}

@Entity
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @OneToMany(mappedBy = "survey")
    private List<Question> questions;
   
}

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @ManyToOne
    private Survey survey;
  
}

@Entity
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Survey survey;
    @OneToMany(mappedBy = "response")
    private List<Answer> answers;
   
}

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Question question;
    private String text;
 
}



@RestController
@RequestMapping("/api/surveys")
public class SurveyController {
s
}

@RestController
@RequestMapping("/api/users")
public class UserController {

}



public interface SurveyRepository extends JpaRepository<Survey, Long> {
    
}


