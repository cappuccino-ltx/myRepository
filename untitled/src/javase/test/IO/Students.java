package javase.test.IO;

import java.io.Serializable;

public class Students implements Serializable {
    private static final long serialVersionUID = 4649076462741345735L;
    String name;
    int id;
    transient boolean sex;

    public Students() {
    }

    public Students(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
