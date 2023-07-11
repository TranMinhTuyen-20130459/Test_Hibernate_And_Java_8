package hibernate.pojo;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Order_Details")
public class OrderDetail {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order")
    private Order order;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product")
    private Product product;

    private int quantity;
    private BigDecimal price;
}