package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;

/**
 * Class for working with files IO
 *
 * @author Valeriya Polezhaeva
 */
class fileUtils {
    private static final Charset utf8 = StandardCharsets.UTF_8;
    private final File file;
    private BufferedReader reader = null;
    private BufferedWriter writer = null;
    private List<String> oldLines = null;

    fileUtils(String path, char mode) throws IOException {
        file = new File(path);
        if ('r' == mode) {
            initReader();
        } else if ('w' == mode) {
            initOldLines();
            initWriter();
        }
    }

    private void initReader() throws IOException {
        FileInputStream stream = new FileInputStream(file);
        InputStreamReader streamReader = new InputStreamReader(stream, utf8);
        reader = new BufferedReader(streamReader);
    }

    private void initWriter() throws IOException {
        FileOutputStream stream = new FileOutputStream(file);
        OutputStreamWriter streamWriter = new OutputStreamWriter(stream, utf8);
        writer = new BufferedWriter(streamWriter);
    }

    private void initOldLines() throws IOException {
        Path mdPathObj = file.toPath();
        oldLines = Files.readAllLines(mdPathObj, utf8);
    }

    List<String> oldLines() {
        return Collections.unmodifiableList(oldLines);
    }

    /**
     * Wrapper for writing to an .md file using string format
     */
    void writeFormat(String pattern, String... args)
            throws IOException {
        String format = MessageFormat.format(pattern, args);
        writer.write(format);
    }

    void write(String s) throws IOException {
        writer.write(s);
    }

    String readLine() throws IOException {
        String line = reader.readLine();
        return line;
    }

    void saveChanges() throws IOException {
        writer.flush();
    }
}
