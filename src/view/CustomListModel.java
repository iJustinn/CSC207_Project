package view;

import javax.swing.*;
import java.util.*;

/**
 * CustomListModel.java
 * This is an implementation of ListModel that supports using a List
 * collection as the underlying data.
 * @author www.codejava.net
 */
public class CustomListModel<E> extends AbstractListModel<E> {
    protected List<E> list;

    public CustomListModel(List<E> list) {
        this.list = list;
    }

    public void addElement(E element) {
        list.add(element);
        int index = list.size();
        fireContentsChanged(element, index, index);
    }

    public void fireDataChanged() {
        int index = list.size();
        fireContentsChanged(list.get(index - 1), index, index);
    }

    public int getSize() {
        return list.size();
    }

    public E getElementAt(int index) {
        return list.get(index);
    }

    public void setList(List<E> newList) {
        this.list = newList;
    }
}
