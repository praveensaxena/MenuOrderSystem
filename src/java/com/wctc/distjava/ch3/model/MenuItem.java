package com.wctc.distjava.ch3.model;

/**
 * This is called an "entity" class, and it represents a domain object and/or
 * a database table. Here it repreents a database table. The advantage of
 * using this is that it gives us nice property accessors/mutators with
 * which to manipulate information in our code.
 */
public class MenuItem {
    private int id;
    private String itemName;
    private double itemPrice;
    private String description;

    public MenuItem() {
    }

    public MenuItem(int id, String itemName, double itemPrice, String description) {
        this.id = id;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MenuItem other = (MenuItem) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MenuItem{" + "id=" + id + ", itemName=" + itemName 
                + ", itemPrice=" + itemPrice + ", description=" 
                + description + '}';
    }
    
    
}
