package main.services;

public interface IOToolService {
    String[] readAndSplit() throws Exception;

    void write(String str);
}
