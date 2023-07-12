package main.interfaces;

public interface IOTool {
    String[] readAndSplit() throws Exception;

    void write(String str);
}
