package pizzeria;

import pizzeria.fileManager.Store;


import static pizzeria.order.OrdersList.createArchivedList;

public class FileController {

    public static void main(String[] args) {
        Store.write(createArchivedList(1000), "archivedOrders.json");
    }

}
