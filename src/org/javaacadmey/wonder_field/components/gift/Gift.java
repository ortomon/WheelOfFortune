package org.javaacadmey.wonder_field.components.gift;

public class Gift {
    private String name;

    public Gift(String name) {
        this.name = name;
    }

    public Gift() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "name='" + name + '\'' +
                '}';
    }
}
