package patterns;

public class AddressManager {
    private static AddressManager singleton = new AddressManager();
//    private volatile static AddressManager singleton;
    private int counter = 0;
    public int getCounter(){return counter;}
    private AddressManager(){}

    public static AddressManager getSingleton(){
        return singleton;
    }

//    public static synchronized AddressManager getSingleton(){
//        if(singleton == null){
//            return singleton = new AddressManager();
//        }
//
//        return singleton;
//    }

//    public static AddressManager getSingleton(){
//        if(singleton == null){
//            synchronized (AddressManager.class){
//                if (singleton == null){
//                    singleton = new AddressManager();
//                }
//            }
//        }
//
//        return singleton;
//    }

    public void addCounter(int amount){
        counter += amount;
    }
}
