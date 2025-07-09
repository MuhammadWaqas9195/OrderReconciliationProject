package Project2StubFiles;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ReportGenerator {

    // Prints a report to the console sorted by filled percentage (highest first)
    public void printOrderReport(List<ClientOrder> clientOrders) {
        // Sorts orders by filled percentage in descending order
        clientOrders.sort((a, b) -> Double.compare(b.getFillPercentage(), a.getFillPercentage()));

        // Prints each order’s reconciliation details
        for (ClientOrder client : clientOrders) {
            System.out.println("Client Order " + client.getID()
                    + " | Symbol: " + client.getSymbol()
                    + " | Filled: " + client.getFilledQuantity() + " / " + client.getQuantity()
                    + " | Status: " + client.getStatus());
        }
    }

    // Exports the report to a CSV file
    public void exportReportToCSV(List<ClientOrder> clientOrders, String outputPath) {
        // Sorts again by filled percentage
        clientOrders.sort((a, b) -> Double.compare(b.getFillPercentage(), a.getFillPercentage()));

        try (FileWriter writer = new FileWriter(outputPath)) {
            // Header line
            writer.write("ClientOrderID,Symbol,Side,Quantity,FilledQuantity,Status\n");

            // Each client order's data in CSV format
            for (ClientOrder client : clientOrders) {
                writer.write(client.getID() + ","
                        + client.getSymbol() + ","
                        + client.getSide() + ","
                        + client.getQuantity() + ","
                        + client.getFilledQuantity() + ","
                        + client.getStatus() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
