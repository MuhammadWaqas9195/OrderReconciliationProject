package Project2StubFiles;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReportGenerator {

    public void printReport(List<ClientOrder> clientOrders) {
        // Sort by filled percentage descending
        Collections.sort(clientOrders, new Comparator<ClientOrder>() {
            @Override
            public int compare(ClientOrder o1, ClientOrder o2) {
                return Double.compare(o2.getFillPercentage(), o1.getFillPercentage());
            }
        });

        for (ClientOrder client : clientOrders) {
            System.out.println("Client Order " + client.getID()
                    + " | Symbol: " + client.getSymbol()
                    + " | Filled: " + client.getFilledQuantity() + " / " + client.getQuantity()
                    + " | Status: " + client.getStatus());
        }
    }
}

