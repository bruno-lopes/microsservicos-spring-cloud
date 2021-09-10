package one.digitalinnovation.experts.shoppingcart.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash(value = "cart")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Cart {
    @Id
    private Integer id;
    private List<Item> items;

    public List<Item> getItems() {
        if (items==null) {
            items = new ArrayList<>();
        }
        return items;
    }
}
