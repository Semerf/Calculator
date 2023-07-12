package main.interfaces;

public interface IOToolService {
    String[] readAndSplit() throws Exception;

    void write(String str);
}
