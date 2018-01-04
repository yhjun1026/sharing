//utilspackage cn.sharing.platform.task;
//
//import com.qianfan123.sailing.open.server.log.LogMessageRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
///**
// * @author  liweihua
// * 2017.12.15
// */
//
//@Component
//@Slf4j
//public class ClearLogScheduled {
//
//    @Autowired
//    LogMessageRepository logMessageRepository;
//
//    @Scheduled(cron="${log.task.cron.clearError}")
//    public void clearError() {
//        Thread current = Thread.currentThread();
//        log.info("清理Error日志:"+current.getId());
//        try {
//            logMessageRepository.clearError();
//        }catch (Exception e){
//            log.error("clear error exception：" + e.getMessage());
//        }
//    }
//
//    @Scheduled(cron="${log.task.cron.clearInfo}")
//    public void clearInfo() {
//        Thread current = Thread.currentThread();
//        log.info("清理Info日志:"+current.getId());
//        try {
//            logMessageRepository.clearInfo();
//        }catch (Exception e){
//            log.error("clear info exception：" + e.getMessage());
//        }
//    }
//
//    @Scheduled(cron="0 */1 * * * ?")
//    public void clearMessageQueue() {
//        try {
//            logMessageRepository.clearMessageQueue();
//        }catch (Exception e){
//            log.error("clear message queue exception：" + e.getMessage());
//        }
//    }
//
//
//}
