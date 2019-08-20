package factory;

public class ReportFactory {
    public ReportI getReport(ReportType type){
        switch (type){
            case CSV:
                return new ReportCSV();
            case TXT:
                return  new ReportTXT();

                default:
                 return  null;
        }
    }
}
