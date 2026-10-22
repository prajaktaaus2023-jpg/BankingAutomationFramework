
package com.banking.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static Object[][] readLoginData() throws Exception {

        List<Object[]> data = new ArrayList<>();

        InputStream input = CSVReader.class.getClassLoader()
                .getResourceAsStream("testdata/loginData.csv");

        if (input == null) {
            throw new RuntimeException("CSV file not found");
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(input, StandardCharsets.UTF_8))) {

            // Skip header
            reader.readLine();

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.isBlank()) {
                    continue;
                }

                String[] values = line.split(",", -1);

                if (values.length != 3) {
                    throw new IllegalArgumentException(
                        "Invalid CSV row: " + line
                    );
                }

                data.add(new Object[] {
                    values[0],
                    values[1],
                    Boolean.parseBoolean(values[2])
                });
            }
        }

        return data.toArray(new Object[0][]);
    }
}
