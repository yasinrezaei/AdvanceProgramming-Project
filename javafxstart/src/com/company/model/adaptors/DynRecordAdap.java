package com.company.model.adaptors;

import com.company.model.Book;
import com.company.model.Student;

import java.io.IOException;

public interface DynRecordAdap {
    void readRecord();
    Student writeRecord(Student s) throws IOException;
    void readRecordBook();
    Book writeRecordBook(Book b) throws IOException;
}
