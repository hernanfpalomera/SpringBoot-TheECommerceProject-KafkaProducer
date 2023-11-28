package com.TheEcommerce.SpringBootTheECommerceProjectKafkaProducer.processor;

import com.TheEcommerce.SpringBootTheECommerceProjectKafkaProducer.model.Sale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Slf4j
@Component
public class CsvProcessor {

    public List<Sale> process() {
        String csvFile = "src/main/resources/sample-file/10000 Sales Records.csv";
        List<Sale> saleList = new ArrayList<>();
        Consumer<String> readCsv = (filename) -> {
            String delimiter = ",";
            try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] tempArr = line.split(delimiter);

                    saleList.add(Sale.
                            builder()
                            .region(tempArr[0])
                            .country(tempArr[1])
                            .itemType(tempArr[2])
                            .salesChannel(tempArr[3])
                            .orderPriority(tempArr[4])
                            .orderDate(tempArr[5])
                            .orderId(Integer.valueOf(tempArr[6]))
                            .shipDate(tempArr[7])
                            .unitsSold(tempArr[8])
                            .unitPrice(tempArr[9])
                            .unitCost(tempArr[10])
                            .totalRevenue(tempArr[11])
                            .totalCost(tempArr[12])
                            .totalProfit(tempArr[13])
                            .build());

                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        };
        readCsv.accept(csvFile);

        return saleList;
    }
}
