package lee.ocean.cloud.entity;


public class NewBeeCartItem {

    private Integer itemId;

    private String cartString;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getCartString() {
        return cartString;
    }

    public void setCartString(String cartString) {
        this.cartString = cartString;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(" itemId=").append(itemId);
        sb.append(", cartString=").append(cartString);
        sb.append("]");
        return sb.toString();
    }
}
