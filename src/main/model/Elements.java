package main.model;

import java.util.concurrent.LinkedBlockingQueue;

public class Elements {
    private LinkedBlockingQueue<Element> elements = new LinkedBlockingQueue<>();

    public Elements() {
    }

    public LinkedBlockingQueue<Element> getElements() {
        return elements;
    }

    public void putElement(Element element) {
        try {
            elements.put(element);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Element pollElement() {
        return elements.poll();
    }

    public boolean hasNext() {
        if (elements.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Elements{" +
                "elements=" + elements +
                '}';
    }
}
