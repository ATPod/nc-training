package by.training.nc.dev5.service;



public class LibaryServiceSQL {



    private static String getRangeQuery = "SELECT TrainNumber,Destination,ArrivalTime,DepartureTime FROM mydb.train_info  " +
            "INNER JOIN mydb.train_numbers ON idTrain=train_numbers.id " +
            "WHERE Destination = (?) and DepartureTime BETWEEN (?) and (?)  ";
    private static String deleteReaderByIdQuery = "delete from mk-library.readers where id = (?) ";
    private static String deleteRBookByIdQuery = "delete from mk-library.books where id = (?) ";
    private static String getAllLoansQuery = "SELECT name,title,loan_type FROM mydb.train_info  " +
            "INNER JOIN mydb.train_numbers ON idTrain=train_numbers.id ";








}
