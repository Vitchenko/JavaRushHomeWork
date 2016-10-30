package com.javarush.test.level17.lesson06.task02;

/* Предложения
Не используя synchronized сделайте так, чтобы количество сделанных и принятых предложений было одинаковым.
*/

public class Solution {
    public volatile static int proposal = 0;

    public static void main(String[] args) throws InterruptedException
    {
        Thread t1= new Thread(new MakeProposal());
        t1.start();
        t1.join();

        proposal = 0;
        Thread t2= new Thread(new AcceptProposal());
        t2.start();
        t2.join();
    }

    public static class MakeProposal extends Thread {
        @Override
        public void run() {
            int thisProposal = proposal;

            while (proposal < 10) {
                System.out.println("Сделано предложение №" + (thisProposal + 1));
                proposal = ++thisProposal;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class AcceptProposal extends Thread {
        @Override
        public void run() {
            int thisProposal = proposal;

            while (proposal < 10) {
                System.out.println("Принято предложение №" + (thisProposal + 1));
                proposal = ++thisProposal;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

//            while (thisProposal < 10) {
//                if (thisProposal != proposal) {
//                    System.out.println("Принято предложение №" + proposal);
//                    thisProposal = proposal;
//                }
//            }
        }
    }
}
