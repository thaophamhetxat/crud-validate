package moduls;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false)
    @Size(min = 4,max = 8, message = "code_id qua ngan/dai")
    String codeId;

    @Column(nullable = false)
    @Size(min = 2,max = 10, message = "name qua ngan/dai")
    String name;

    @Min(value = 18, message = "Age must be over 18")
    int age;

    @Column(nullable = false)
    String phongBan;

    public Employee() {
    }

    public Employee(int id, String codeId, String name, int age, String phongBan) {
        this.id = id;
        this.codeId = codeId;
        this.name = name;
        this.age = age;
        this.phongBan = phongBan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }
}

