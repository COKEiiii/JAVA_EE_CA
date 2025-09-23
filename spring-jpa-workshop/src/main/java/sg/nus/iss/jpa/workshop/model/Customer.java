package sg.nus.iss.jpa.workshop.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private String email;
  
  @OneToMany
  @JoinColumn(name="customer_id") // join column is in table for Address
  private List<Address> addresses;
  
  public Customer() {}
  public Customer(String name, String email) {
    this.name = name;
    this.email = email;
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
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public List<Address> getAddresses() {
    return addresses;
  }
  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }
  
  @Override
  public String toString() {
    return "Customer [id=" + id + ", name=" + name + 
                        ", email=" + email + "]";
  }
}
