package main;

import main.model.Element;
import main.model.Elements;
import main.model.Handler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.sleep;

public class StartApp {
    private static Elements elements = new Elements();
    public static Handler handler = new Handler();

    public static void main(String[] args) throws InterruptedException {
        startApp();
    }

    private static void startApp() throws InterruptedException {
        initializeQueue();

        while (elements.getElements().size() != 100) {

        }

        handleMainQueue();

        handler.inithandle();
    }

    private static void handleMainQueue() throws InterruptedException {

        while (elements.getElements().size() != 0) {
            if (elements.hasNext()) {
                Element element = elements.pollElement();

                if (element.getGroupId() == 1) {
                    handler.getElementsGr1().put(element);
                } else if (element.getGroupId() == 2) {
                    handler.getElementsGr2().put(element);
                } else if (element.getGroupId() == 3) {
                    handler.getElementsGr3().put(element);
                } else if (element.getGroupId() == 4) {
                    handler.getElementsGr4().put(element);
                }
            } else {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void initializeQueue() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            executorService.submit(() -> initElement(finalI, ThreadLocalRandom.current().nextInt(1, 5)));
        }

        executorService.shutdown();
    }

    private static void initElement(int id, int grId) {
        elements.putElement(new Element(id, grId));
    }
}
