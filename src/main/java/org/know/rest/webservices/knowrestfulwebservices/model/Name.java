package org.know.rest.webservices.knowrestfulwebservices.model;

/**
 *
 * @author KnowGroup
 */
public class Name {
    private String first;
    private String middle;
    private String last;

    public Name() {
    }

    public Name(String first, String middle, String last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public String getMiddle() {
        return middle;
    }

    public String getLast() {
        return last;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public void setLast(String last) {
        this.last = last;
    }
    
    
}
