import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void BankPerformance() {
        Bank b = new Bank();
        b.loadAccountsFromXML("accounts.xml");
        System.out.println(b.printAccounts());

        b.loadTransactionsFromXML("transactions.xml");
        System.out.println(b.printTransQueue());

        b.executeTransactions();
        System.out.println(b.printAccounts());

    }




    @Test
    public void convertStringToUpperCaseStreams() {
        List<String> collected = Stream.of("a", "b", "hello") // Stream of String
                .map(String::toUpperCase) // Returns a stream consisting of the results of applying the given function to the elements of this stream.
                .collect(Collectors.toList());
        assertEquals(asList("A", "B", "HELLO"), collected);
    }


    @Test
    public void testflatMap() throws Exception {
        List<Integer> together = Stream.of(1, 2, 3, 4, 5, 6)//.stream())//, asList(3, 4)) // Stream of List<Integer>
                //.flatMap(List::stream)
                //asList(1, 2).stream()
                .map((x) -> x*x)
                .filter(x -> x>9)
                .collect(Collectors.toList());
        assertEquals(asList(2, 3, 4, 5), together);
    }


    @AllArgsConstructor
    class SimThread implements Runnable
    {
        int threadNum;
        @Override
        @SneakyThrows
        public void run()
        {
            for(int i=0; i<10; i++){
                System.out.println(String.format("This is thread %d, iteration %d", threadNum, i));
                Thread.sleep(1000);
            }
        }
    }
    @Test
    @SneakyThrows
    void MyExecutor()
    {
        ConcurrentLinkedQueue<SimThread> taskQ = new ConcurrentLinkedQueue<>();
        taskQ.add(new SimThread(1));
        taskQ.add(new SimThread(2));
        taskQ.add(new SimThread(3));
        taskQ.add(new SimThread(4));



        ExecutorService ex = Executors.newCachedThreadPool();
        ex.execute(taskQ.poll());
        ex.execute(taskQ.poll());
        ex.execute(taskQ.poll());
        ex.execute(taskQ.poll());
     //   ex.awaitTermination(20, TimeUnit.SECONDS);
        ex.shutdown();

    }

    @AllArgsConstructor
    class AccountUser implements Runnable{
        String userName;
        Account account;
        int sum;

        public void run(){
            account.withdraw(sum);
        }
    }
    @Test
    void syncTest()
    {
        Account ac1 = new Account("ac1", 100);

    }

    @Test
    void myQueue(){
        ConcurrentLinkedQueue<Integer> clq = new ConcurrentLinkedQueue<>();
        clq.add(1);
        clq.add(2);
        clq.add(3);
        System.out.println(clq);
        Integer b = clq.poll();
        System.out.println(clq);
        System.out.println(clq.poll());
        System.out.println(clq.poll());
        System.out.println(clq.poll());
        System.out.println(clq.poll());
    }






    @Test
    void myStreamMap(){
        HashMap<String, Integer> hm = new HashMap<>();
        hm.putIfAbsent("hello", 3);
        Integer ans = hm.putIfAbsent("hello", 9);
        Assert.assertNull(ans);
    }















}