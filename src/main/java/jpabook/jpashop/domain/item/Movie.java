package jpabook.jpashop.domain.item;

import jpabook.jpashop.service.UpdateItemDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
@Getter @Setter
public class Movie extends Item{

    private String director;
    private String actor;

    @Override
    public void changeItem(UpdateItemDto updateItemDto) {
        System.out.println("movie============================");
    }
}
