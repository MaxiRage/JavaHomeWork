import java.util.concurrent.Semaphore;

public class Philosophers {
    private static final int COUNT_PHIL = 5;
    private static final Semaphore[] FLAG = new Semaphore[COUNT_PHIL];
    private static final Semaphore MAX_DINERS = new Semaphore(COUNT_PHIL - 1);

    public static void main(String[] args) {
        for (int i = 0; i < COUNT_PHIL; i++) 
            FLAG[i] = new Semaphore(1);

        Thread phil = new Thread(() -> {
            int philNum = 1;
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.println("1 Философ обедает");
                    Thread.sleep(500);

                    FLAG[philNum - 1].release();
                    FLAG[philNum % COUNT_PHIL].release();
                    MAX_DINERS.release();

                    System.out.println("1 Философ размышляет");
                    Thread.sleep(600);

                    MAX_DINERS.acquire();
                    FLAG[philNum - 1].acquire();
                    FLAG[philNum % COUNT_PHIL].acquire();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("1 Философ размышляет");
        });

        Thread philTwo = new Thread(() -> {
            int philosopherNumber = 2;
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.println("2 Философ размышляет");
                    Thread.sleep(600);

                    MAX_DINERS.acquire();
                    FLAG[philosopherNumber - 1].acquire();
                    FLAG[philosopherNumber % COUNT_PHIL].acquire();

                    System.out.println("2 Философ обедает");
                    Thread.sleep(500);

                    FLAG[philosopherNumber - 1].release();
                    FLAG[philosopherNumber % COUNT_PHIL].release();
                    MAX_DINERS.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("2 Философ размышляет");

        });
        Thread philThree = new Thread(() -> {
            int philosopherNumber = 3;
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.println("3 Философ размышляет");
                    Thread.sleep(600);

                    MAX_DINERS.acquire();
                    FLAG[philosopherNumber - 1].acquire();
                    FLAG[philosopherNumber % COUNT_PHIL].acquire();


                    System.out.println("3 Философ обедает");
                    Thread.sleep(500);

                    FLAG[philosopherNumber - 1].release();
                    FLAG[philosopherNumber % COUNT_PHIL].release();
                    MAX_DINERS.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("3 Философ размышляет");
        });
        Thread philFour = new Thread(() -> {
            int philosopherNumber = 4;
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.println("4 Философ размышляет");
                    Thread.sleep(600);

                    MAX_DINERS.acquire();
                    FLAG[philosopherNumber - 1].acquire();
                    FLAG[philosopherNumber % COUNT_PHIL].acquire();


                    System.out.println("4 Философ обедает");
                    Thread.sleep(500);

                    FLAG[philosopherNumber - 1].release();
                    FLAG[philosopherNumber % COUNT_PHIL].release();
                    MAX_DINERS.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("4 Философ размышляет");
        });
        Thread philFive = new Thread(() -> {
            int philosopherNumber = 5;
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.println("5 Философ размышляет");
                    Thread.sleep(600);

                    MAX_DINERS.acquire();
                    FLAG[philosopherNumber - 1].acquire();
                    FLAG[philosopherNumber % COUNT_PHIL].acquire();


                    System.out.println("5 Философ обедает");
                    Thread.sleep(500);

                    FLAG[philosopherNumber - 1].release();
                    FLAG[philosopherNumber % COUNT_PHIL].release();
                    MAX_DINERS.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("5 Философ размышляет");
        });

        phil.start();
        philTwo.start();
        philThree.start();
        philFour.start();
        philFive.start();
    }
}