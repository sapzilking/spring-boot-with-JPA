package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") //나는 order테이블에 있는 member이랑 매핑 된거야. 연관관계의 주인이 아니므로 수정 불가
    private List<Order> orders = new ArrayList<>();
}
