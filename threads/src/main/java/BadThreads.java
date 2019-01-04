import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BadThreads {

    public static void main(String... args) throws InterruptedException {

        System.out.println("Оригинальный класс BadThreads ->");
        BadThreadsOrigin bt = new BadThreadsOrigin();
        bt.demo();

        System.out.println("Класс BadThreads c synchronized ->");
        BadThreadsSync badThreadsSync = new BadThreadsSync();
        badThreadsSync.demo();

        System.out.println("Класс BadThreads c Lock ->");
        BadThreadsLock badThreadsLock = new BadThreadsLock();
        badThreadsLock.demo();

        System.out.println("Класс BadThreads c join ->");
        BadThreadsJoin btj = new BadThreadsJoin();
        btj.demo();

        System.out.println("Класс BadThreads c sleep ->");
        BadThreadsSleep badThreadsSleep = new BadThreadsSleep();
        badThreadsSleep.demo();

        System.out.println("Класс BadThreads обмен строк ->");
        BadThreadsSwapStrings btsw = new BadThreadsSwapStrings();
        btsw.demo();
    }

    // Оригинальный класс BadThreads
    private static class BadThreadsOrigin {
        static String message;

        private static class CorrectorThread extends Thread {
            public void run() {
                message = "Помиловать";
            }
        }

        public void demo() throws InterruptedException {

            for (int i = 0; i < 500; i++) {
                CorrectorThread correctorThread = new CorrectorThread();
                message = "Казнить";
                correctorThread.start();
                Thread.sleep(10);

                if (message.equalsIgnoreCase("Казнить"))
                    System.out.println(message);
            }
        }
    }

    // Класс BadThreads c synchronized
    private static class BadThreadsSync {
        static String message = "";

        public synchronized void setMessage(String newMessage) {
            synchronized (message) {
                message = newMessage;
            }
        }

        public synchronized String getMessage(){
            synchronized (message) {
                return message;
            }
        }

        private static class CorrectorThread extends Thread {
            @Override
            public synchronized void run() {
                synchronized (message) {
                    message = "Помиловать";
                }
            }
        }

        public void demo() throws InterruptedException {

            for (int i = 0; i < 500; i++) {
                CorrectorThread correctorThread = new CorrectorThread();
                setMessage("Казнить");
                Thread.sleep(10);
                correctorThread.start();

                if (getMessage().equalsIgnoreCase("Казнить"))
                    System.out.println(getMessage());
            }
        }
    }

    // Класс BadThreads c Lock
    private static class BadThreadsLock {
        static String message = "";
        final Lock lock = new ReentrantLock();

        public void setMessage(String newMessage) {
            lock.lock();
            try {
                message = newMessage;
            } finally {
                lock.unlock();
            }
        }

        public synchronized String getMessage() {
            lock.lock();
            try {
                return message;
            } finally {
                lock.unlock();
            }
        }

        private class CorrectorThread extends Thread {
            @Override
            public synchronized void run() {
                lock.lock();
                try {
                    message = "Помиловать";
                } finally {
                    lock.unlock();
                }
            }
        }

        public void demo() throws InterruptedException {
            for (int i = 0; i < 500; i++) {
                CorrectorThread correctorThread = new CorrectorThread();
                setMessage("Казнить");
                Thread.sleep(10);
                correctorThread.start();

                if (getMessage().equalsIgnoreCase("Казнить"))
                    System.out.println(getMessage());
            }
        }
    }

    // Класс BadThreads c join (работает на 100%)
    private static class BadThreadsJoin {
        static String message;

        private static class CorrectorThread extends Thread {
            @Override
            public void run() {
                message = "Помиловать";
            }
        }

        public void demo() throws InterruptedException {

            for (int i = 0; i < 500; i++) {
                CorrectorThread correctorThread = new CorrectorThread();
                message = "Казнить";
                Thread.sleep(10);
                correctorThread.start();
                correctorThread.join();

                if (message.equalsIgnoreCase("Казнить"))
                    System.out.println(message);
            }
        }
    }

    // Класс BadThreads c sleep (работает на 100%)
    private static class BadThreadsSleep{
        static String message;

        private static class CorrectorThread extends Thread {
            @Override
            public void run() {
                message = "Помиловать";
            }
        }

        public void demo() throws InterruptedException {
            for (int i = 0; i < 500; i++) {
                CorrectorThread correctorThread = new CorrectorThread();
                message = "Казнить";
                Thread.sleep(10);
                correctorThread.start();
                Thread.sleep(1);

                if (message.equalsIgnoreCase("Казнить"))
                    System.out.println(message);
            }
        }
    }

    // Класс BadThreads обмен строк (работает на 100%)
    private static class BadThreadsSwapStrings {
        static String message;

        private static class CorrectorThread extends Thread {
            @Override
            public void run() {
                message = "Помиловать";
            }
        }

        public void demo() throws InterruptedException {

            for (int i = 0; i < 1000; i++) {
                CorrectorThread correctorThread = new CorrectorThread();
                correctorThread.start();
                message = "Казнить";
                Thread.sleep(10);

                if (message.equalsIgnoreCase("Казнить"))
                    System.out.println(message);
            }
        }
    }
}
