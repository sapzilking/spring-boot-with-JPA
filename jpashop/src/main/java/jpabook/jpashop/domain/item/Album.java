package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ㅁ") //기본으로 두면 entity이름인 Album로 구분한다
@Getter @Setter
public class Album extends  Item {

    private String artist;

    private String etc;
}
