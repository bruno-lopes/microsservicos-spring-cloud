package one.digitalinnovation.experts.shoppingcart.model;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash(value = "items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Integer productId;
    private Integer amount;
}
