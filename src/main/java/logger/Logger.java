package logger;

import com.epam.reportportal.service.ReportPortal;

import java.util.Calendar;

public class Logger {
    private String LEVEL_LOG = "INFO";
    public void log(String message){
        ReportPortal.emitLog(message, LEVEL_LOG, Calendar.getInstance().getTime());
    }
}
