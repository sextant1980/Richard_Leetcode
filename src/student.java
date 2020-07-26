import java.util.Objects;

class student{
    private int id;

    public student(int id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //comparing hash
        if (o == null || getClass() != o.getClass()) return false;
        student student = (student) o; //comparing class
        return id == student.id; //comparing content
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
