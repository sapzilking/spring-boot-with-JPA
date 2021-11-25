package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B") //기본으로 두면 entity이름인 Book로 구분한다
@Getter @Setter
public class Book  extends  Item {

    private String author;
    private String isbn;

//    public static Book createBook(String author, String isbn) {
//        this.author = author;
//        this.isbn = isbn;
//        return this;
//    }

}
