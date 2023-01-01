package jpabook.jpashop.domain.item;

import jpabook.jpashop.service.UpdateItemDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
@Getter @Setter
public class Book extends Item{

    private String author;
    private String isbn;

    @Override
    public void changeItem(UpdateItemDto updateItemDto) {
        this.author = updateItemDto.getAuthor();
        this.isbn = updateItemDto.getIsbn();
        System.out.println("Book===========================");
    }
}
