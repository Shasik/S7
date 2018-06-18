package main.model;

public class Element {
    private int itemId;

    private int groupId;

    public Element(int itemId, int groupId) {
        this.itemId = itemId;
        this.groupId = groupId;
    }

    public String handle() {
        return "Метод обработки элемента. Элемент номер " + itemId + ". Группа номер " + groupId + ".";
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "Element{" +
                "itemId=" + itemId +
                ", groupId=" + groupId +
                '}';
    }
}
