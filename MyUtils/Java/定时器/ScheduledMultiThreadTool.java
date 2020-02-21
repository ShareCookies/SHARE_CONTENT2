package common.utils;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @autor hecaigui
 * @date 2020-2-18
 * @description
 */
public class ScheduledMultiThreadTool {
    private  static Integer executeCount = 0;
    public void timerExecute(){
        ScheduledThreadPoolExecutor scheduled = new ScheduledThreadPoolExecutor(2);
        //0表示首次执行任务的延迟时间，40表示每次执行任务的间隔时间，TimeUnit.MILLISECONDS执行的时间间隔数值单位
        scheduled.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("time:"+System.currentTimeMillis());
                executeCount++;
            }
        }, 10, 5, TimeUnit.SECONDS);
        //执行两次后关闭计划任务
        while (!scheduled.isTerminated()){
            if (executeCount > 1){
                scheduled.shutdown();
            }
        }
    }

    public static void main(String[] args) {
        ScheduledMultiThreadTool startTask = new ScheduledMultiThreadTool();
        startTask.timerExecute();
    }
}
