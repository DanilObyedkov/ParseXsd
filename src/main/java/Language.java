public class Language  {
    private String documentation;
    private int age;

    public String getName() {
        return documentation;
    }
    public void setName(String name) {
        this.documentation = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Language: Name = " + this.documentation + " Age = " + this.age;
    }
}
