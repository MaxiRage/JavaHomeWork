package com.example.cartservice.model;

import lombok.Data;

@Data
public class CartItem {
  private Long productId;
  private int quantity;
}

