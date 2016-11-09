package com.javarush.test.level25.lesson05.home01;

/**
 * Created by viv on 08.11.2016.
 */
class LoggingStateThread extends Thread
{
        Thread th = new Thread();

    public LoggingStateThread(Thread th)
    {
        this.th = th;
        this.setDaemon(true);
    }

    @Override
    public void run()
    {
        super.run();

        State state = this.th.getState();
        System.out.println(state);
        while (state != State.TERMINATED)
        {
            if (state != this.th.getState())
            {
                state = this.th.getState();
                System.out.println(state);
            }
        }
    }

}