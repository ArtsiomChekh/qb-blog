package spring.blog.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
// Needed for JPA (Java Persistence API)
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "users")
public class User {

  @Id // primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // generate automatically
  private Long id;

	// (nullable = false) - not null, when saved to the db, (unique = true) - must be unique
	@Column(nullable = false, length = 30, unique = true)
	// If the value is empty, an error message will be generated.
  @NotEmpty(message = "Please provide your User Name")
  private String userName;

  @Column(length = 60)
  @Length(min = 5, message = "Your password must have at least 5 characters")
  @NotEmpty(message = "Please provide your password")
  private String passwordHash;

  @Column(length = 100)
  @NotEmpty(message = "Please provide your full name")
  private String fullName;

  @OneToMany(mappedBy = "author")
  private Set<Post> posts = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPasswordHash() {
    return passwordHash;
  }

  public void setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Set<Post> getPosts() {
    return posts;
  }

  public void setPosts(Set<Post> posts) {
    this.posts = posts;
  }

  public User(Long id, String userName, String fullName) {
    this.id = id;
    this.userName = userName;
    this.fullName = fullName;
  }

  public User() {
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", userName=" + userName + ", passwordHash=" + passwordHash
        + ", fullName=" + fullName + "]";
  }


}
