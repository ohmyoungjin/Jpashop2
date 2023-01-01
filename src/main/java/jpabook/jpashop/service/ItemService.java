package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Transactional
    //이걸 객체 자체를 넘겨서 ex)BookForm 보냈으면 조금 더 깔끔해지지 않았을까?
    //여러개의 인자를 가지는 함수는 좋지 않다고 하던데 ..흠.. BookForm  같은 경우 웹 계층에서만 쓴다고 해서
    //안쓴다고 하는데 흠 .. 잘 모르겠다 뭐가 더 좋은 설계인지
    //Service 계층에 DTO를 만들어서 넘겨주는 방법도 존재한다.
    //public void updateItem(Long itemId, Book bookParam) {
    //public void updateItem(Long itemId, String name, int price, int stockQuantity) {
    public void updateItem(Long itemId, UpdateItemDto updateItemDto) {

        Item findItem = itemRepository.findOne(itemId);

        findItem.changeItem(updateItemDto);

    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
