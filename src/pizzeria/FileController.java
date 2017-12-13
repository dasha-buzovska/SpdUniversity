package pizzeria;

import pizzeria.fileManager.Store;


import static pizzeria.order.OrdersGenerator.createArchivedList;

public class FileController {

    public static void main(String[] args) {
        Store.write(createArchivedList(1000));
    }

}
