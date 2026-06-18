package betr.intern.model;

import java.util.Objects;

public class Category {

    private Long id;
    private String name;

    public Category(){}
    public Category(Long id, String name){
        this.id=id;
        this.name=name;
    }

    public void setId(Long id){
        this.id=id;
    }
    public Long getId(){
        return id;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true; //daca comparam obiectul cu el insusi
        if(o == null || getClass() != o.getClass()) return false; //daca obiectul nu exista sau nu este de tipul respectiv

        Category category = (Category) o; //convertim o la tipul Category
        return Objects.equals(id, category.id); //comparam id-urile obiectelor
    }
    @Override
    public int hashCode() { //daca obiectele sunt egale dupa equals, atunci trebuie sa fie egale si dupa hash
        return Objects.hash(id);
    }



}
