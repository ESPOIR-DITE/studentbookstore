package company.ac.za.studentbookstore.controller;

import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.util.List;

public interface Icontroller<T,t> {
    T create(T t) throws IOException, UnirestException;
    T delete(T t);
    T read(String id);
    T update(T t) throws IOException;
    List<T> readAll();
}
