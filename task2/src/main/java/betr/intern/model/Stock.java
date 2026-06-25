package betr.intern.model;

import betr.intern.exception.OutOfStockException;

public class Stock {

  private Item item;
  private int quantity;

  public Stock(Item item, int quantity) {
    if (item == null) {
      throw new IllegalArgumentException("Item-ul nu exista!");
    }

    if (quantity < 0) {
      throw new IllegalArgumentException("Cantitatea nu poate fi negativa!");
    }
    this.item = item;
    this.quantity = quantity;
  }

  public void setItem(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("Item-ul nu exista!");
    }
    this.item = item;
  }

  public Item getItem() {
    return item;
  }

  public void setQuantity(int quantity) {
    if (quantity < 0) {
      throw new IllegalArgumentException("Cantitatea nu poate fi negativa!");
    }
    this.quantity = quantity;
  }

  public int getQuantity() {
    return quantity;
  }

  public boolean isAvailable() {
    return this.quantity > 0;
  }

  public boolean hasEnoughStock(int requestedQuantity) {
    return this.quantity >= requestedQuantity;
  }

  public void addQuantity(int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("Nu poti adauga o cantitate negativa!");
    }
    this.quantity += amount;
  }

  public void deductQuantity(int amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Nu poti scadea o cantitate negativa!");
    }
    if (!hasEnoughStock(amount)) {
      throw new OutOfStockException("Nu este stoc suficient pentru operatiunea aceasta!");
    }

    this.quantity -= amount;
  }
}
