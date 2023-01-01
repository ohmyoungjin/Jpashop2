package jpabook.jpashop.domain.item;

import jpabook.jpashop.service.UpdateItemDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
@Getter @Setter
public class Album extends Item{

    private String artist;

    private String etc;

    @Override
    public void changeItem(UpdateItemDto updateItemDto) {
        System.out.println("Album============================");
    }
}
