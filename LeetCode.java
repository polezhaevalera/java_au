package com.company;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;

/**
 * Class to process .txt file and reformat the strings for .md file.
 *
 * @author Valeriya Polezhaeva
 */
class LeetCode {
    private static final String nl = System.lineSeparator();
    private fileUtils txtFile = null;
    private fileUtils mdFile = null;
    private final String fileHeader;
    private String title;
    private String link;
    private final StringBuilder sourceCode = new StringBuilder(100);

    LeetCode(String txtPath, String mdPath, String header) throws IOException {
        txtFile = new fileUtils(txtPath, 'r');
        mdFile = new fileUtils(mdPath, 'w');
        fileHeader = header;
        initFields();
    }

    /**
     * Get title, link and sourceCode from .txt file
     */
    private void initFields() throws IOException {
        title = txtFile.readLine();
        int dotIndex = title.indexOf('.') + 1;
        title = title.substring(dotIndex).trim();

        link = txtFile.readLine();
        link = MessageFormat.format("{0}{1}{1}", link, nl);

        String format, substring;
        format = MessageFormat.format("```java{0}", nl);
        sourceCode.append(format);
        txtFile.readLine();  // skip `class Solution {`
        while (true) {
            String line = txtFile.readLine();
            if ("}".equals(line)) {
                break;
            }
            if (line.isEmpty()) {
                line = "    ";
            }
            substring = line.substring(4);
            format = MessageFormat.format("{0}{1}", substring, nl);
            sourceCode.append(format);
        }
        format = MessageFormat.format("```{0}", nl);
        sourceCode.append(format);
    }

    /**
     * Writes a line to the table of contents of the .md file
     */
    private void updateHeader(String header) throws IOException {
        boolean isHeader = false;

        for (String loopLine : mdFile.oldLines()) {
            if (loopLine.startsWith("+ [")) {
                isHeader = true;
            } else {
                if (isHeader) {
                    mdFile.writeFormat("{0}{1}", header, nl);
                }
                isHeader = false;
            }
            mdFile.writeFormat("{0}{1}", loopLine, nl);
        }

        mdFile.write(nl);
    }

    void writeTitle() throws IOException {
        String headHref = title.toLowerCase(Locale.ENGLISH).replace(' ', '-');
        String headMd = MessageFormat.format("+ [{0}](#{1})", title, headHref);

        List<String> oldLines = mdFile.oldLines();
        if (oldLines.isEmpty()) {
            mdFile.writeFormat("# {0}{1}{1}", fileHeader, nl);
            mdFile.writeFormat("{0}{1}{1}", headMd, nl);
        } else {
            updateHeader(headMd);
        }
        mdFile.writeFormat("## {0}{1}{1}", title, nl);
    }

    void writeBody() throws IOException {
        mdFile.write(link);
        String sourceCodeString = sourceCode.toString();
        mdFile.write(sourceCodeString);
    }

    void addTask() throws IOException {
        writeTitle();
        writeBody();
        mdFile.saveChanges();
        mdFile.saveChanges();
    }
}


