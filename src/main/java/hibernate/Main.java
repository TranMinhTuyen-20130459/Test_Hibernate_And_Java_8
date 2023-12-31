package hibernate;

import hibernate.config.ConfigHibernate;
import hibernate.data.*;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        long executeTime = 0;
        long startTime = System.currentTimeMillis();
        Session session = null;
        try {
            session = ConfigHibernate.getFactory().openSession();
            System.out.println("Kết nối đến database thành công");

            DataStatusProduct.addDataToTable_StatusProducts();
            DataStatusOrder.addDataToTable_StatusOrders();
            DataBrand.addDataToTable_Brands();
            DataSize.addDataToTable_Sizes();
            DataPriceRange.addDataToTable_PriceRanges();
            DataTypeProduct.addDataToTable_TypeProducts();

            for (int i = 0; i < 100; i++) {
                DataProduct.addDataToTable_Products();
            }

            DataImageProduct.addDataToTable_ImageProducts();
            DataSizeProduct.addDataToTable_SizeProducts();
            DataHistoryPriceProduct.addDataToTable_HistoryPriceProducts();
            DataOrder.addDataToTable_Orders();
            DataOrderDetail.addDataToTable_OrderDetails();

            long endTime = System.currentTimeMillis();
            executeTime = endTime - startTime;
        } catch (Exception e) {

            System.out.println("Đã có lỗi xảy ra");
            System.out.println(e.getMessage());

        } finally {
            if (session != null) session.close();
            System.out.println("Time: " + (double) executeTime / (60 * 1000) + " minute");
        }

    }
}