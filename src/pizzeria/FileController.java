package pizzeria;

import pizzeria.dateTimeTools.SumForPeriod;
import pizzeria.fileManager.Store;
import static pizzeria.order.OrdersGenerator.createArchivedList;

public class FileController {

    public static void main(String[] args) {
        Store.write(createArchivedList(100));
        SumForPeriod sumForPeriod = new SumForPeriod(Store.readArchive());
        Store.writeSumsForPeriods(sumForPeriod);
    }

}
