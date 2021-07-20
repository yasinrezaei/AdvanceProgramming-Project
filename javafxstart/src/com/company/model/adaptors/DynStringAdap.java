package com.company.model.adaptors;

import com.company.model.Book;
import com.company.model.Student;

public interface DynStringAdap {
    void readString();
    void writeString(Student s);
    void readStringBook();
    void writeStringBook(Book b);
}
