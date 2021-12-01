public class Main
{
    public static Object obj = new Object();
    public static int cnt = 0;

    public static void main(String[] args) throws InterruptedException
    {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; ++i)
        {
            threads[i] = new Thread(() ->
            {
                try
                {
                    Something();
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            });
            threads[i].setName(Integer.toString(i + 1));
            threads[i].start();
            Thread.sleep(10);
        }
    }

    public static void Something() throws InterruptedException
    {
        System.out.println("Лошадь №" + Thread.currentThread().getName() + " побежала");
        synchronized (obj)
        {
            Thread.sleep(300);
        }
        System.out.println("Лошадь №" + Thread.currentThread().getName() + " финишировала на " + ++cnt + " месте");
    }
}