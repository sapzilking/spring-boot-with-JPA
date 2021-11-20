package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

    @Embedded //내장타입이기때문에 embedded 어노테이션 써줌
    private Address address;

    @Enumerated(EnumType.STRING) //EnumType에는 Ordinal이랑 String가 있는데 Ordinal이 기본타입인데 이러면 1,2,3 이면 중간에 하나의 값이 추가되면 기존의 2가 3이 되면서 망한다. 꼭 String쓰기!
    private DeliveryStatus  status; //READY(배송준비), COMP(배송)


}
